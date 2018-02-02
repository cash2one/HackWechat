package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni {
    private static boolean zXZ = false;
    private static boolean zYa = false;

    public TbsLinuxToolsJni(Context context) {
        synchronized (TbsLinuxToolsJni.class) {
            if (zYa) {
                return;
            }
            zYa = true;
            try {
                File file;
                if (x.hq(context)) {
                    file = new File(x.cEU());
                } else {
                    t.cEF();
                    file = t.hg(context);
                }
                if (file != null) {
                    if (!(new File(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so").exists() || x.hq(context))) {
                        t.cEF();
                        file = t.hf(context);
                    }
                    if (file != null) {
                        System.load(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
                        zXZ = true;
                    }
                }
                ChmodInner("/checkChmodeExists", "700");
            } catch (Throwable th) {
                zXZ = false;
            }
        }
    }

    private native int ChmodInner(String str, String str2);

    public final int fX(String str, String str2) {
        if (zXZ) {
            return ChmodInner(str, str2);
        }
        TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
        return -1;
    }
}
