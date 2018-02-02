package com.tencent.tinker.loader;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.ComponentHotplug;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class TinkerLoader extends AbstractTinkerLoader {
    private static final String TAG = "Tinker.TinkerLoader";
    private SharePatchInfo patchInfo;

    public Intent tryLoad(TinkerApplication tinkerApplication) {
        Intent intent = new Intent();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tryLoadPatchFilesInternal(tinkerApplication, intent);
        ShareIntentUtil.a(intent, SystemClock.elapsedRealtime() - elapsedRealtime);
        return intent;
    }

    private void tryLoadPatchFilesInternal(TinkerApplication tinkerApplication, Intent intent) {
        int tinkerFlags = tinkerApplication.getTinkerFlags();
        if (!ShareTinkerInternals.IW(tinkerFlags)) {
            ShareIntentUtil.a(intent, -1);
        } else if (ShareTinkerInternals.iG(tinkerApplication)) {
            ShareIntentUtil.a(intent, -1);
        } else {
            File iy = SharePatchFileUtil.iy(tinkerApplication);
            if (iy == null) {
                ShareIntentUtil.a(intent, -2);
                return;
            }
            String absolutePath = iy.getAbsolutePath();
            if (iy.exists()) {
                File abH = SharePatchFileUtil.abH(absolutePath);
                if (abH.exists()) {
                    File abI = SharePatchFileUtil.abI(absolutePath);
                    this.patchInfo = SharePatchInfo.o(abH, abI);
                    if (this.patchInfo == null) {
                        ShareIntentUtil.a(intent, -4);
                        return;
                    }
                    String str = this.patchInfo.AlD;
                    String str2 = this.patchInfo.AlE;
                    String str3 = this.patchInfo.AiM;
                    if (str == null || str2 == null || str3 == null) {
                        ShareIntentUtil.a(intent, -4);
                        return;
                    }
                    intent.putExtra("intent_patch_old_version", str);
                    intent.putExtra("intent_patch_new_version", str2);
                    boolean iF = ShareTinkerInternals.iF(tinkerApplication);
                    Object obj = !str.equals(str2) ? 1 : null;
                    Object obj2 = (str3.equals("changing") && iF) ? 1 : null;
                    str3 = ShareTinkerInternals.bW(tinkerApplication, str3);
                    intent.putExtra("intent_patch_oat_dir", str3);
                    if (obj == null || !iF) {
                        str2 = str;
                    }
                    if (ShareTinkerInternals.ov(str2)) {
                        ShareIntentUtil.a(intent, -5);
                        return;
                    }
                    str = SharePatchFileUtil.abJ(str2);
                    if (str == null) {
                        ShareIntentUtil.a(intent, -6);
                        return;
                    }
                    absolutePath = absolutePath + "/" + str;
                    File file = new File(absolutePath);
                    if (file.exists()) {
                        String abK = SharePatchFileUtil.abK(str2);
                        File file2 = abK != null ? new File(file.getAbsolutePath(), abK) : null;
                        if (SharePatchFileUtil.ae(file2)) {
                            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(tinkerApplication);
                            int a = ShareTinkerInternals.a(tinkerApplication, tinkerFlags, file2, shareSecurityCheck);
                            if (a != 0) {
                                intent.putExtra("intent_patch_package_patch_check", a);
                                ShareIntentUtil.a(intent, -8);
                                return;
                            }
                            intent.putExtra("intent_patch_package_config", shareSecurityCheck.cHf());
                            boolean IS = ShareTinkerInternals.IS(tinkerFlags);
                            if (IS && !TinkerDexLoader.a(absolutePath, shareSecurityCheck, str3, intent)) {
                                return;
                            }
                            if (!ShareTinkerInternals.IT(tinkerFlags) || TinkerSoLoader.a(absolutePath, shareSecurityCheck, intent)) {
                                boolean IU = ShareTinkerInternals.IU(tinkerFlags);
                                if (!IU || TinkerResourceLoader.a(tinkerApplication, absolutePath, shareSecurityCheck, intent)) {
                                    boolean z = ShareTinkerInternals.cHg() && ShareTinkerInternals.abN(this.patchInfo.AlF) && VERSION.SDK_INT >= 21 && !ShareTinkerInternals.cHi();
                                    intent.putExtra("intent_patch_system_ota", z);
                                    if ((iF && obj != null) || obj2 != null) {
                                        this.patchInfo.AlD = str2;
                                        this.patchInfo.AiM = str3;
                                        if (!SharePatchInfo.a(abH, this.patchInfo, abI)) {
                                            ShareIntentUtil.a(intent, -19);
                                            return;
                                        } else if (obj2 != null) {
                                            SharePatchFileUtil.bP(absolutePath + "/interpet");
                                        }
                                    }
                                    if (checkSafeModeCount(tinkerApplication)) {
                                        if (IS) {
                                            boolean a2 = TinkerDexLoader.a(tinkerApplication, absolutePath, str3, intent, z);
                                            if (z) {
                                                this.patchInfo.AlF = Build.FINGERPRINT;
                                                this.patchInfo.AiM = a2 ? "interpet" : "odex";
                                                obj2 = null;
                                                if (SharePatchInfo.a(abH, this.patchInfo, abI)) {
                                                    intent.putExtra("intent_patch_oat_dir", this.patchInfo.AiM);
                                                } else {
                                                    ShareIntentUtil.a(intent, -19);
                                                    return;
                                                }
                                            }
                                            if (!a2) {
                                                return;
                                            }
                                        }
                                        if (!IU || TinkerResourceLoader.a(tinkerApplication, absolutePath, intent)) {
                                            if (IS && IU) {
                                                ComponentHotplug.a(tinkerApplication, shareSecurityCheck);
                                            }
                                            if (obj2 != null) {
                                                ShareTinkerInternals.iH(tinkerApplication);
                                            }
                                            ShareIntentUtil.a(intent, 0);
                                            return;
                                        }
                                        return;
                                    }
                                    intent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
                                    ShareIntentUtil.a(intent, -25);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ShareIntentUtil.a(intent, -7);
                        return;
                    }
                    ShareIntentUtil.a(intent, -6);
                    return;
                }
                new StringBuilder("tryLoadPatchFiles:patch info not exist:").append(abH.getAbsolutePath());
                ShareIntentUtil.a(intent, -3);
                return;
            }
            ShareIntentUtil.a(intent, -2);
        }
    }

    private boolean checkSafeModeCount(TinkerApplication tinkerApplication) {
        String str = "tinker_own_config_" + ShareTinkerInternals.iI(tinkerApplication);
        SharedPreferences sharedPreferences = tinkerApplication.getSharedPreferences(str, 0);
        int i = sharedPreferences.getInt("safe_mode_count", 0) + 1;
        new StringBuilder("tinker safe mode preferName:").append(str).append(" count:").append(i);
        if (i >= 3) {
            sharedPreferences.edit().putInt("safe_mode_count", 0).commit();
            return false;
        }
        tinkerApplication.setUseSafeMode(true);
        sharedPreferences.edit().putInt("safe_mode_count", i).commit();
        return true;
    }
}
