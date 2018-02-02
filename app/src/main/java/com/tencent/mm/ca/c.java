package com.tencent.mm.ca;

import android.os.Environment;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.concurrent.Executors;

public final class c {
    private static boolean xCW = false;
    public static a xCX = null;

    static /* synthetic */ void lK(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.MemoryDumpOperation", "Hprof error uploadPath %s ", new Object[]{str});
        } else if (ze()) {
            File file = new File(str);
            if (file.exists()) {
                String a = p.a(file, true, null);
                if (a != null) {
                    File file2 = new File(a);
                    if (!an.isWifi(ac.getContext()) && file2.length() > 5242880) {
                        x.i("MicroMsg.MemoryDumpOperation", "Hprof not wifi exceed max size, size " + file2.length());
                        return;
                    } else if (xCX == null) {
                        x.e("MicroMsg.MemoryDumpOperation", "Hprof upload : no file upload impl set!");
                        return;
                    } else {
                        x.i("MicroMsg.MemoryDumpOperation", "Hprof upload : %b", new Object[]{Boolean.valueOf(xCX.Hr(a))});
                        if (xCX.Hr(a)) {
                            e.h(new File(b.xCV));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            x.e("MicroMsg.MemoryDumpOperation", "Hprof upload file is not exist");
        } else {
            x.e("MicroMsg.MemoryDumpOperation", "Hprof sdcard invalid.");
        }
    }

    public static void DG(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        switch (i) {
            case 1:
                z = false;
                z2 = true;
                z3 = false;
                z4 = true;
                break;
            case 2:
                z = false;
                z2 = true;
                z3 = true;
                z4 = true;
                break;
            case 3:
                z = false;
                z2 = false;
                z3 = false;
                z4 = true;
                break;
            case 4:
                z = true;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            case 5:
                z = true;
                z2 = false;
                z3 = true;
                z4 = false;
                break;
            case 6:
                x.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
                System.gc();
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            default:
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
        }
        x.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", new Object[]{Boolean.valueOf(z4), Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z)});
        Executors.newSingleThreadExecutor().execute(new 1(z4, z3, z2, z));
    }

    static boolean ze() {
        try {
            return Environment.getExternalStorageState().equals("mounted") && new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e) {
            return false;
        }
    }
}
