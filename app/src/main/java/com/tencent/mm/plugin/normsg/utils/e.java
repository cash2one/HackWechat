package com.tencent.mm.plugin.normsg.utils;

import com.tencent.mm.sdk.platformtools.ac;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e {
    private static String[] oTC = new String[]{GL(ac.getContext().getFilesDir().getParent() + "/dumeq/tekcos/ved/"), GL(ac.getContext().getFilesDir().getParent() + "/epip_umeq/ved/")};
    private static String[] oTD = new String[]{GL(ac.getContext().getFilesDir().getParent() + "/hsifdlog")};
    private static String[] oTE = new String[]{GL(ac.getContext().getFilesDir().getParent() + "/os.umeq_gubed_collam_cbil/bil/metsys/"), GL(ac.getContext().getFilesDir().getParent() + "/ecart_umeq/sys/"), GL(ac.getContext().getFilesDir().getParent() + "/sporp-umeq/nib/metsys/")};
    public static boolean oTF;
    public static boolean oTG;
    public static boolean oTH;

    static {
        InputStream fileInputStream;
        String str;
        Throwable th;
        oTF = false;
        oTG = false;
        oTH = false;
        for (String file : oTC) {
            if (new File(file).exists()) {
                oTF = true;
                break;
            }
        }
        File file2 = new File("/proc/tty/drivers");
        if (file2.exists() && file2.canRead() && file2.length() > 0) {
            byte[] bArr = new byte[((int) file2.length())];
            InputStream inputStream = null;
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    fileInputStream.read(bArr);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    inputStream = fileInputStream;
                    th = th3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
            str = new String(bArr);
            while (r0 < r4) {
                if (!str.contains(r5)) {
                    oTG = true;
                    break;
                }
            }
        }
        while (r0 < r3) {
            if (new File(r2).exists()) {
                oTH = true;
                return;
            }
        }
    }

    private static String GL(String str) {
        String[] strArr = new String[]{ac.getContext().getFilesDir().getParent(), str, e.class.toString()};
        return new StringBuilder(strArr[1].substring(strArr[0].length() + 1)).reverse().toString();
    }
}
