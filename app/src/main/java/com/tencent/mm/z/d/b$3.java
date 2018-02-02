package com.tencent.mm.z.d;

import com.tencent.mm.ca.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

class b$3 implements Runnable {
    final /* synthetic */ b hjn;
    final /* synthetic */ String hjo;

    public b$3(b bVar, String str) {
        this.hjn = bVar;
        this.hjo = str;
    }

    public final void run() {
        Throwable e;
        b bVar = this.hjn;
        String str = b.by() + "MMSQL.trace";
        String str2 = this.hjo + "\n";
        if (f.ze()) {
            File file;
            try {
                file = new File(b.hjd);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bVar.a(new File(b.hjd, "MMSQL.trace"), false);
            } catch (Exception e2) {
                x.e("MicroMsg.SQLTraceManager", "init dir fail");
            }
            file = new File(str);
            if (file.length() > bVar.hji) {
                x.e("MicroMsg.SQLTraceManager", "log file invaild foramt,recreate");
                bVar.a(file, true);
            }
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write(e.bz(str2.getBytes()));
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                    }
                } catch (IOException e4) {
                    e3 = e4;
                    try {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e32) {
                                x.printErrStackTrace("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                            }
                        }
                        bVar.l(new File(b.hjd + "MMSQL.trace"));
                        return;
                    } catch (Throwable th) {
                        e32 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e5) {
                                x.printErrStackTrace("MicroMsg.SQLTraceManager", e5, "appendToFile fail with exception", new Object[0]);
                            }
                        }
                        throw e32;
                    }
                }
            } catch (IOException e6) {
                e32 = e6;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                bVar.l(new File(b.hjd + "MMSQL.trace"));
                return;
            } catch (Throwable th2) {
                e32 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e32;
            }
            bVar.l(new File(b.hjd + "MMSQL.trace"));
            return;
        }
        x.i("MicroMsg.SQLTraceManager", "sdcard is not  Available,appendToFile fail ");
    }
}
