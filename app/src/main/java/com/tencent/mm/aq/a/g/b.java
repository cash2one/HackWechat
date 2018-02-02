package com.tencent.mm.aq.a.g;

import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static final String bnD = h.getExternalStorageDirectory().getAbsolutePath();
    public static final String bnF = (bnD + "/tencent/MicroMsg/");
    public static final String hEr = (bnF + ".tmp");
    public static long hEs = 0;

    public static String PM() {
        x.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", hEr + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis())));
        File file = new File(hEr);
        if (!file.exists()) {
            file.mkdirs();
        }
        return r0;
    }

    public static boolean PN() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - hEs > 86400000) {
            x.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
            hEs = currentTimeMillis;
            return true;
        }
        x.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
        return false;
    }

    public static boolean PO() {
        File file = new File(hEr);
        try {
            if (!file.exists() || file.isFile()) {
                return true;
            }
            b(file, true);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] clean tmp file path exception.");
            return false;
        }
    }

    private static void b(File file, boolean z) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        if (!file2.isFile()) {
                            int i;
                            x.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] can delete current time:%d,listModified:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(file2.lastModified()));
                            if (System.currentTimeMillis() - file2.lastModified() >= 259200000) {
                                i = 1;
                            } else {
                                boolean z2 = false;
                            }
                            if (i != 0 && z) {
                                b(file2, false);
                            }
                        } else if (file2 != null && file2.isFile() && file2.exists()) {
                            file2.delete();
                        }
                    }
                }
            }
            file.delete();
        }
    }
}
