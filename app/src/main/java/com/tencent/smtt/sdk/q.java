package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.o;
import java.io.File;
import java.io.IOException;

public class q {
    private static q zXC;
    private boolean zXB;

    private q() {
    }

    public static q cED() {
        if (zXC == null) {
            synchronized (q.class) {
                if (zXC == null) {
                    zXC = new q();
                }
            }
        }
        return zXC;
    }

    public final synchronized boolean bH(Context context, String str) {
        boolean z;
        File file = new File(context.getFilesDir(), str);
        z = file.exists() && file.isFile();
        return z;
    }

    public final synchronized void gM(Context context) {
        if (!this.zXB) {
            if (bH(context, "bugly_switch.txt")) {
                Object cEU;
                if (x.hq(context)) {
                    cEU = x.cEU();
                } else {
                    t.cEF();
                    File hg = t.hg(context);
                    if (hg == null) {
                        TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
                    }
                    if (hg.listFiles() == null || hg.listFiles().length <= 0) {
                        TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
                    } else {
                        String absolutePath = hg.getAbsolutePath();
                    }
                }
                if (TextUtils.isEmpty(cEU)) {
                    TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
                } else {
                    t.cEF();
                    File hg2 = t.hg(context);
                    if (hg2 == null) {
                        TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
                    } else {
                        try {
                            String parent = new File(cEU, "tbs_bugly_dex.jar").getParent();
                            String[] strArr = new String[]{r4.getAbsolutePath()};
                            String absolutePath2 = hg2.getAbsolutePath();
                            o.b(new DexLoader(parent, context, strArr, absolutePath2, null).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", new Class[]{Context.class, String.class, String.class, String.class}, new Object[]{context, cEU, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context))});
                            this.zXB = true;
                            TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
                        } catch (Throwable th) {
                            TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(th));
                        }
                    }
                }
            } else {
                TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
            }
        }
    }

    public final synchronized boolean m(Context context, String str, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (context != null) {
                File file = new File(context.getFilesDir(), str);
                if (z) {
                    if (!file.exists()) {
                        try {
                            if (file.createNewFile()) {
                                z2 = true;
                            }
                        } catch (IOException e) {
                            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + str);
                        }
                    }
                } else if (file.exists()) {
                    if (file.delete()) {
                        z2 = true;
                    } else {
                        TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + str);
                    }
                }
                z2 = true;
            }
        }
        return z2;
    }
}
