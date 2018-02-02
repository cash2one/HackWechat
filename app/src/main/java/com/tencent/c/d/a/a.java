package com.tencent.c.d.a;

import com.tencent.c.f.h;
import java.io.File;

public final class a {
    public static boolean aaQ(String str) {
        if (!new File(str).exists()) {
            return true;
        }
        try {
            boolean aaQ = com.tencent.c.d.b.a.aaQ(str);
            if (!aaQ) {
                h.aaW("BootScriptChecker found no-elf file : " + str);
            }
            return aaQ;
        } catch (Throwable e) {
            h.k(e);
            return true;
        }
    }

    public static boolean aaR(String str) {
        boolean z = true;
        File file = new File(str);
        if (file.exists() && file.length() <= 51200) {
            try {
                String str2 = new String(com.tencent.c.d.b.a.aaS(file.getAbsolutePath()));
                z = str2.contains("applypatch ");
                h.aaX("BootScriptChecker script (" + str + ") content : \n" + str2);
                if (!z) {
                    h.aaW("BootScriptChecker found unofficial file : " + str);
                }
            } catch (Throwable e) {
                h.k(e);
            }
        }
        return z;
    }
}
