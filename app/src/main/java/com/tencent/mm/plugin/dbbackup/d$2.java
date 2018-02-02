package com.tencent.mm.plugin.dbbackup;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.o;
import com.tencent.mm.by.f;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.RecoverKit;
import java.io.File;

class d$2 implements Runnable {
    final /* synthetic */ b lpY;
    final /* synthetic */ c lpZ;
    final /* synthetic */ d lqk;
    final /* synthetic */ String lql;
    final /* synthetic */ long lqm;

    d$2(d dVar, c cVar, String str, long j, b bVar) {
        this.lqk = dVar;
        this.lpZ = cVar;
        this.lql = str;
        this.lqm = j;
        this.lpY = bVar;
    }

    public final void run() {
        SQLiteDatabase openDatabase;
        int i;
        Throwable th;
        d.a(this.lqk, null);
        try {
            c.Fa();
            c.Fd();
            o.Pw();
            com.tencent.mm.modelvideo.o.TU();
            long nanoTime = System.nanoTime();
            byte[] bytes = (q.yE() + c.Cg()).getBytes();
            byte[] t = g.t(bytes);
            byte[] bytes2 = g.s(bytes).substring(0, 7).getBytes();
            int i2 = SQLiteDatabase.CREATE_IF_NECESSARY;
            if (f.ckR()) {
                i2 = 805306368;
            }
            openDatabase = SQLiteDatabase.openDatabase(c.EV().ckV().getPath(), bytes2, d.azH(), null, i2, null, 0);
            try {
                String[] strArr;
                if (this.lql != null) {
                    strArr = new String[]{this.lql};
                } else {
                    String[] strArr2 = new String[2];
                    strArr2[0] = c.CQ() + ".bak";
                    StringBuilder stringBuilder = new StringBuilder();
                    com.tencent.mm.kernel.g.Dk();
                    strArr2[1] = stringBuilder.append(com.tencent.mm.kernel.g.Dj().gQi).append("dbback/EnMicroMsg.db.bak").toString();
                    strArr = strArr2;
                }
                i = -3;
                try {
                    String str;
                    int length = strArr.length;
                    i2 = 0;
                    long j = 0;
                    int i3 = -3;
                    while (i2 < length) {
                        try {
                            str = strArr[i2];
                            try {
                                File file = new File(str);
                                if (file.canRead()) {
                                    j = file.length();
                                    x.i("MicroMsg.SubCoreDBBackup", "[Recover] backupSize: %d, diskFreeSpace: %d", new Object[]{Long.valueOf(j), Long.valueOf(this.lqm)});
                                    if (this.lqm >= 10 * j) {
                                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                                        Object[] objArr = new Object[2];
                                        objArr[0] = Integer.valueOf(10004);
                                        objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(j), Long.valueOf(this.lqm)});
                                        gVar.h(11098, objArr);
                                        d.a(this.lqk, new RecoverKit(openDatabase, str, t));
                                        break;
                                    }
                                    if (this.lpY != null) {
                                        this.lpY.ou(-2);
                                    }
                                    if (d.d(this.lqk) != null) {
                                        d.d(this.lqk).release();
                                        d.a(this.lqk, null);
                                    }
                                    if (openDatabase != null) {
                                        openDatabase.close();
                                    }
                                    d.c(this.lqk);
                                    ar.Dm().cfE();
                                    return;
                                }
                                continue;
                                i2++;
                            } catch (Exception e) {
                                x.e("MicroMsg.SubCoreDBBackup", "Initialize RecoverKit failed: " + e.getMessage());
                                i3 = -1;
                            }
                        } catch (Throwable e2) {
                            Throwable th2 = e2;
                            i = i3;
                            th = th2;
                        }
                    }
                    int i4;
                    if (d.d(this.lqk) == null) {
                        i4 = -3;
                        try {
                            com.tencent.mm.plugin.report.service.g.pQN.a(181, 31, 1, true);
                            throw new RuntimeException();
                        } catch (Exception e3) {
                            th = e3;
                            i = i4;
                            try {
                                x.printErrStackTrace("MicroMsg.SubCoreDBBackup", th, "Failed to start database recovery", new Object[0]);
                                if (this.lpY != null) {
                                    this.lpY.ou(i);
                                }
                                com.tencent.mm.plugin.report.service.g.pQN.a(181, 23, 1, true);
                                if (d.d(this.lqk) != null) {
                                    d.d(this.lqk).release();
                                    d.a(this.lqk, null);
                                }
                                if (openDatabase != null) {
                                    openDatabase.close();
                                }
                                d.c(this.lqk);
                                ar.Dm().cfE();
                            } catch (Throwable th3) {
                                th = th3;
                                if (d.d(this.lqk) != null) {
                                    d.d(this.lqk).release();
                                    d.a(this.lqk, null);
                                }
                                if (openDatabase != null) {
                                    openDatabase.close();
                                }
                                d.c(this.lqk);
                                ar.Dm().cfE();
                                throw th;
                            }
                        }
                    }
                    i4 = d.d(this.lqk).run(false);
                    d.azF();
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    length = d.d(this.lqk).successCount();
                    int failureCount = d.d(this.lqk).failureCount();
                    String lastError = d.d(this.lqk).lastError();
                    d.d(this.lqk).release();
                    d.a(this.lqk, null);
                    openDatabase.close();
                    openDatabase = null;
                    str = "MicroMsg.SubCoreDBBackup";
                    String str2 = "Database recover %s, elapsed %.2f seconds. [success: %d, failure: %d]";
                    Object[] objArr2 = new Object[4];
                    String str3 = i4 == 0 ? "succeeded" : i4 == 1 ? "canceled" : "failed";
                    objArr2[0] = str3;
                    objArr2[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                    objArr2[2] = Integer.valueOf(length);
                    objArr2[3] = Integer.valueOf(failureCount);
                    x.i(str, str2, objArr2);
                    if (i4 == 0) {
                        i = 10005;
                        i3 = 22;
                    } else if (i4 == 1) {
                        i = 10006;
                        i3 = -1;
                    } else {
                        i = CdnLogic.kMediaTypeFavoriteBigFile;
                        i3 = 23;
                        com.tencent.mm.plugin.report.service.g.pQN.c("DBRepair", "Backup recover failed: " + lastError, null);
                    }
                    com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(i);
                    objArr2[1] = String.format("%d|%d|%d|%d", new Object[]{Long.valueOf(j), Long.valueOf(nanoTime2 / 1000000), Integer.valueOf(length), Integer.valueOf(failureCount)});
                    gVar2.h(11098, objArr2);
                    if (i3 >= 0) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(181, (long) i3, 1, true);
                    }
                    if (this.lpY != null) {
                        this.lpY.ou(i4);
                    }
                    if (d.d(this.lqk) != null) {
                        d.d(this.lqk).release();
                        d.a(this.lqk, null);
                    }
                    d.c(this.lqk);
                    ar.Dm().cfE();
                } catch (Exception e4) {
                    th = e4;
                    x.printErrStackTrace("MicroMsg.SubCoreDBBackup", th, "Failed to start database recovery", new Object[0]);
                    if (this.lpY != null) {
                        this.lpY.ou(i);
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.a(181, 23, 1, true);
                    if (d.d(this.lqk) != null) {
                        d.d(this.lqk).release();
                        d.a(this.lqk, null);
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    d.c(this.lqk);
                    ar.Dm().cfE();
                }
            } catch (Exception e5) {
                th = e5;
                i = -1;
                x.printErrStackTrace("MicroMsg.SubCoreDBBackup", th, "Failed to start database recovery", new Object[0]);
                if (this.lpY != null) {
                    this.lpY.ou(i);
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(181, 23, 1, true);
                if (d.d(this.lqk) != null) {
                    d.d(this.lqk).release();
                    d.a(this.lqk, null);
                }
                if (openDatabase != null) {
                    openDatabase.close();
                }
                d.c(this.lqk);
                ar.Dm().cfE();
            }
        } catch (Exception e6) {
            th = e6;
            openDatabase = null;
            i = -1;
            x.printErrStackTrace("MicroMsg.SubCoreDBBackup", th, "Failed to start database recovery", new Object[0]);
            if (this.lpY != null) {
                this.lpY.ou(i);
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(181, 23, 1, true);
            if (d.d(this.lqk) != null) {
                d.d(this.lqk).release();
                d.a(this.lqk, null);
            }
            if (openDatabase != null) {
                openDatabase.close();
            }
            d.c(this.lqk);
            ar.Dm().cfE();
        } catch (Throwable th4) {
            th = th4;
            openDatabase = null;
            if (d.d(this.lqk) != null) {
                d.d(this.lqk).release();
                d.a(this.lqk, null);
            }
            if (openDatabase != null) {
                openDatabase.close();
            }
            d.c(this.lqk);
            ar.Dm().cfE();
            throw th;
        }
    }
}
