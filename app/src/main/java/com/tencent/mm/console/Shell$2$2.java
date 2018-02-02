package com.tencent.mm.console;

import com.tencent.mm.console.Shell.2;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Shell$2$2 implements Runnable {
    final /* synthetic */ 2 gIK;
    final /* synthetic */ String gIL;

    Shell$2$2(2 2, String str) {
        this.gIK = 2;
        this.gIL = str;
    }

    public final void run() {
        BufferedReader bufferedReader;
        Throwable th;
        Throwable th2;
        SQLiteDatabase ckV = g.Dj().gQj.ckV();
        BufferedReader bufferedReader2 = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            bufferedReader = new BufferedReader(new FileReader(this.gIL));
            try {
                x.i("MicroMsg.Shell", "Executing SQL from file: " + this.gIL);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    ckV.execSQL(readLine);
                }
                x.i("MicroMsg.Shell", "Finish executing SQL in %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
                if (ckV.inTransaction()) {
                    ckV.endTransaction();
                }
            } catch (FileNotFoundException e2) {
                try {
                    x.e("MicroMsg.Shell", "Cannot find file to execute: " + this.gIL);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (ckV.inTransaction()) {
                        ckV.endTransaction();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader2 = bufferedReader;
                    th2 = th;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (ckV.inTransaction()) {
                        ckV.endTransaction();
                    }
                    throw th2;
                }
            } catch (Throwable th32) {
                th = th32;
                bufferedReader2 = bufferedReader;
                th2 = th;
                try {
                    x.printErrStackTrace("MicroMsg.Shell", th2, "Failed to execute file: " + this.gIL, new Object[0]);
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (ckV.inTransaction()) {
                        ckV.endTransaction();
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (ckV.inTransaction()) {
                        ckV.endTransaction();
                    }
                    throw th2;
                }
            }
        } catch (FileNotFoundException e6) {
            bufferedReader = null;
            x.e("MicroMsg.Shell", "Cannot find file to execute: " + this.gIL);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (ckV.inTransaction()) {
                ckV.endTransaction();
            }
        } catch (Exception e7) {
            th2 = e7;
            x.printErrStackTrace("MicroMsg.Shell", th2, "Failed to execute file: " + this.gIL, new Object[0]);
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (ckV.inTransaction()) {
                ckV.endTransaction();
            }
        }
    }
}
