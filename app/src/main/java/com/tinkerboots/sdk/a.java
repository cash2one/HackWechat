package com.tinkerboots.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.tinker.lib.b.b;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tenpay.android.wechat.PayuSecureEncrypt$EncrptType;
import java.io.File;

public final class a {
    public static a Auc;
    public final com.tencent.tinker.lib.e.a Aud;
    public final com.tinkerboots.sdk.a.a Aue;
    private final ApplicationLike applicationLike;

    public a(Context context, ApplicationLike applicationLike, c cVar, d dVar, b bVar, com.tencent.tinker.lib.c.a aVar, Class<? extends AbstractResultService> cls, com.tinkerboots.sdk.a.a.b bVar2) {
        com.tinkerboots.sdk.b.b.context = context;
        this.applicationLike = applicationLike;
        this.Aue = com.tinkerboots.sdk.a.a.a(bVar2);
        com.tencent.tinker.lib.e.a.a aVar2 = new com.tencent.tinker.lib.e.a.a(applicationLike.getApplication());
        int tinkerFlags = applicationLike.getTinkerFlags();
        if (aVar2.status != -1) {
            throw new TinkerRuntimeException("tinkerFlag is already set.");
        }
        aVar2.status = tinkerFlags;
        if (cVar == null) {
            throw new TinkerRuntimeException("loadReporter must not be null.");
        } else if (aVar2.AiB != null) {
            throw new TinkerRuntimeException("loadReporter is already set.");
        } else {
            aVar2.AiB = cVar;
            if (bVar == null) {
                throw new TinkerRuntimeException("listener must not be null.");
            } else if (aVar2.AiA != null) {
                throw new TinkerRuntimeException("listener is already set.");
            } else {
                aVar2.AiA = bVar;
                if (dVar == null) {
                    throw new TinkerRuntimeException("patchReporter must not be null.");
                } else if (aVar2.AiC != null) {
                    throw new TinkerRuntimeException("patchReporter is already set.");
                } else {
                    aVar2.AiC = dVar;
                    Boolean valueOf = Boolean.valueOf(applicationLike.getTinkerLoadVerifyFlag());
                    if (valueOf == null) {
                        throw new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
                    } else if (aVar2.AiK != null) {
                        throw new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
                    } else {
                        aVar2.AiK = valueOf;
                        com.tencent.tinker.lib.e.a cGY = aVar2.cGY();
                        com.tencent.tinker.lib.e.a.a(cGY);
                        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
                        com.tencent.tinker.lib.e.a.Aiy = true;
                        TinkerPatchService.a(aVar, cls);
                        com.tencent.tinker.lib.f.a.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", new Object[]{Boolean.valueOf(ShareTinkerInternals.IW(cGY.tinkerFlags)), "1.9.4"});
                        if (!ShareTinkerInternals.IW(cGY.tinkerFlags)) {
                            com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
                        } else if (tinkerResultIntent == null) {
                            throw new TinkerRuntimeException("intentResult must not be null.");
                        } else {
                            String abJ;
                            cGY.AiG = new com.tencent.tinker.lib.e.d();
                            com.tencent.tinker.lib.e.d dVar2 = cGY.AiG;
                            com.tencent.tinker.lib.e.a ip = com.tencent.tinker.lib.e.a.ip(cGY.context);
                            dVar2.AiZ = ShareIntentUtil.ar(tinkerResultIntent);
                            dVar2.jHU = ShareIntentUtil.as(tinkerResultIntent);
                            dVar2.AiP = ShareIntentUtil.q(tinkerResultIntent, "intent_patch_system_ota");
                            dVar2.AiM = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_oat_dir");
                            dVar2.AiO = "interpet".equals(dVar2.AiM);
                            boolean z = ip.rSa;
                            com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", new Object[]{Integer.valueOf(dVar2.AiZ), ShareTinkerInternals.iI(r2), Boolean.valueOf(z), Boolean.valueOf(dVar2.AiP), Build.FINGERPRINT, dVar2.AiM, Boolean.valueOf(dVar2.AiO)});
                            String j = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_old_version");
                            String j2 = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_new_version");
                            File file = ip.Aiz;
                            File file2 = ip.AiD;
                            if (!(j == null || j2 == null)) {
                                if (z) {
                                    dVar2.AiL = j2;
                                } else {
                                    dVar2.AiL = j;
                                }
                                com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", new Object[]{j, j2, dVar2.AiL});
                                abJ = SharePatchFileUtil.abJ(dVar2.AiL);
                                if (!ShareTinkerInternals.ov(abJ)) {
                                    dVar2.AiQ = new File(file.getAbsolutePath() + "/" + abJ);
                                    dVar2.AiR = new File(dVar2.AiQ.getAbsolutePath(), SharePatchFileUtil.abK(dVar2.AiL));
                                    dVar2.AiS = new File(dVar2.AiQ, "dex");
                                    dVar2.AiT = new File(dVar2.AiQ, "lib");
                                    dVar2.AiU = new File(dVar2.AiQ, "res");
                                    dVar2.AiV = new File(dVar2.AiU, "resources.apk");
                                }
                                dVar2.patchInfo = new SharePatchInfo(j, j2, Build.FINGERPRINT, dVar2.AiM);
                                dVar2.AiN = !j.equals(j2);
                            }
                            Throwable at = ShareIntentUtil.at(tinkerResultIntent);
                            if (at == null) {
                                switch (dVar2.AiZ) {
                                    case -10000:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
                                        throw new TinkerRuntimeException("can't get the right intent return code");
                                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                                        if (dVar2.AiV != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", new Object[]{dVar2.AiV.getAbsolutePath()});
                                            ip.AiB.a(dVar2.AiV, 6);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
                                        throw new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
                                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                                        if (dVar2.AiQ != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", new Object[]{dVar2.AiV.getAbsolutePath()});
                                            ip.AiB.a(dVar2.AiV, 6, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
                                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                                        if (dVar2.AiQ != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", new Object[]{dVar2.AiU.getAbsolutePath()});
                                            ip.AiB.a(dVar2.AiU, 6, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
                                    case -19:
                                        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
                                        ip.AiB.a(j, j2, file2);
                                        break;
                                    case -18:
                                        abJ = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_missing_lib_path");
                                        if (abJ != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", new Object[]{abJ});
                                            ip.AiB.a(new File(abJ), 5, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
                                    case -17:
                                        if (dVar2.AiQ != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", new Object[]{dVar2.AiT.getAbsolutePath()});
                                            ip.AiB.a(dVar2.AiT, 5, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
                                    case -16:
                                        ip.AiB.b(2, ShareIntentUtil.au(tinkerResultIntent));
                                        break;
                                    case -15:
                                        ip.AiB.b(1, ShareIntentUtil.au(tinkerResultIntent));
                                        break;
                                    case -13:
                                        abJ = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_mismatch_dex_path");
                                        if (abJ != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", new Object[]{abJ});
                                            ip.AiB.a(new File(abJ), 3);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
                                    case -12:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
                                        break;
                                    case -11:
                                        abJ = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (abJ != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", new Object[]{abJ});
                                            ip.AiB.a(new File(abJ), 4, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
                                    case -10:
                                        abJ = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (abJ != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", new Object[]{abJ});
                                            ip.AiB.a(new File(abJ), 3, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
                                    case -9:
                                        if (dVar2.AiS != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", new Object[]{dVar2.AiS.getAbsolutePath()});
                                            ip.AiB.a(dVar2.AiS, 3, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
                                    case -8:
                                        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
                                        if (dVar2.AiR != null) {
                                            ip.AiB.b(dVar2.AiR, tinkerResultIntent.getIntExtra("intent_patch_package_patch_check", -10000));
                                            break;
                                        }
                                        throw new TinkerRuntimeException("error patch package check fail , but file is null");
                                    case -7:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", new Object[]{dVar2.AiL});
                                        if (dVar2.AiR != null) {
                                            ip.AiB.a(dVar2.AiR, 1, false);
                                            break;
                                        }
                                        throw new TinkerRuntimeException("error load patch version file not exist, but file is null");
                                    case -6:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", new Object[]{dVar2.AiL});
                                        ip.AiB.a(dVar2.AiQ, 1, true);
                                        break;
                                    case -5:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
                                        break;
                                    case -4:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
                                        ip.AiB.a(j, j2, file2);
                                        break;
                                    case -3:
                                    case -2:
                                        com.tencent.tinker.lib.f.a.w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
                                        break;
                                    case -1:
                                        com.tencent.tinker.lib.f.a.w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
                                        break;
                                    case 0:
                                        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
                                        ip.AiH = true;
                                        dVar2.AiW = ShareIntentUtil.av(tinkerResultIntent);
                                        dVar2.AiX = ShareIntentUtil.aw(tinkerResultIntent);
                                        dVar2.AiY = ShareIntentUtil.ax(tinkerResultIntent);
                                        if (dVar2.AiO) {
                                            ip.AiB.b(0, null);
                                        }
                                        if (z && dVar2.AiN) {
                                            ip.AiB.a(j, j2, file, dVar2.AiQ.getName());
                                            break;
                                        }
                                    default:
                                        break;
                                }
                            }
                            com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", new Object[]{Integer.valueOf(dVar2.AiZ)});
                            int i = -1;
                            switch (dVar2.AiZ) {
                                case DownloadResult.CODE_SOCKET_TIMEOUT_EXCEPTION /*-25*/:
                                    i = -4;
                                    break;
                                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                                    i = -3;
                                    break;
                                case PayuSecureEncrypt$EncrptType.HASHED_SECRET_ANSWER /*-20*/:
                                    i = -1;
                                    break;
                                case -14:
                                    i = -2;
                                    break;
                            }
                            ip.AiB.a(at, i);
                            cGY.AiB.a(cGY.Aiz, cGY.AiG.AiZ, cGY.AiG.jHU);
                            if (!cGY.AiH) {
                                com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
                            }
                        }
                        this.Aud = cGY;
                    }
                }
            }
        }
    }

    public static a cJn() {
        if (Auc != null) {
            return Auc;
        }
        throw new TinkerRuntimeException("you must init TinkerClient sdk first");
    }

    public final a oe(boolean z) {
        int i = 1;
        if (this.Aue == null || this.Aud == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            return Auc;
        }
        Context context = com.tinkerboots.sdk.b.b.getContext();
        if (VERSION.SDK_INT >= 23) {
            int i2 = context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : 0;
            int i3 = context.checkSelfPermission("android.permission.INTERNET") == 0 ? 1 : 0;
            if (i2 == 0 || i3 == 0) {
                i = 0;
            }
        }
        if (i == 0) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
            return Auc;
        } else if (ShareTinkerInternals.IW(this.Aud.tinkerFlags) && ShareTinkerInternals.iE(context)) {
            if (this.Aud.rSa) {
                Looper.getMainLooper();
                Looper.myQueue().addIdleHandler(new 1(this, z));
            }
            return Auc;
        } else {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
            return Auc;
        }
    }

    public final a gi(String str, String str2) {
        if (this.Aue == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
            return Auc;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchCondition %s with value %s", new Object[]{str, str2});
        this.Aue.Aum.Auo.Aup.put(str, str2);
        return Auc;
    }

    public final a Jj(int i) {
        if (this.Aue == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
            return Auc;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", new Object[]{Integer.valueOf(i)});
        com.tinkerboots.sdk.a.a aVar = this.Aue;
        if (((long) i) == -1) {
            com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "Warning, disableFetchPatchUpdate", new Object[0]);
            com.tinkerboots.sdk.b.b.getContext().getSharedPreferences("patch_server_config", 0).edit().putLong("fetch_patch_last_check", -1).commit();
        } else if (i < 0 || i > 24) {
            throw new TinkerRuntimeException("hours must be between 0 and 24");
        } else {
            aVar.Aul = (((long) i) * 3600) * 1000;
        }
        return Auc;
    }
}
