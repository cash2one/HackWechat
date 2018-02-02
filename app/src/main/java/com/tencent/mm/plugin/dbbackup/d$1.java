package com.tencent.mm.plugin.dbbackup;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import java.io.File;
import java.util.Date;

class d$1 implements Runnable {
    final /* synthetic */ b lpY;
    final /* synthetic */ c lpZ;
    final /* synthetic */ String lps;
    final /* synthetic */ String lqa;
    final /* synthetic */ boolean lqb;
    final /* synthetic */ SQLiteDatabase lqc;
    final /* synthetic */ String lqd;
    final /* synthetic */ String lqe;
    final /* synthetic */ long[] lqf;
    final /* synthetic */ long[] lqg;
    final /* synthetic */ int lqh;
    final /* synthetic */ String[] lqi;
    final /* synthetic */ String lqj;
    final /* synthetic */ d lqk;

    d$1(d dVar, b bVar, c cVar, String str, boolean z, SQLiteDatabase sQLiteDatabase, String str2, String str3, String str4, long[] jArr, long[] jArr2, int i, String[] strArr, String str5) {
        this.lqk = dVar;
        this.lpY = bVar;
        this.lpZ = cVar;
        this.lqa = str;
        this.lqb = z;
        this.lqc = sQLiteDatabase;
        this.lqd = str2;
        this.lps = str3;
        this.lqe = str4;
        this.lqf = jArr;
        this.lqg = jArr2;
        this.lqh = i;
        this.lqi = strArr;
        this.lqj = str5;
    }

    public final void run() {
        if (d.a(this.lqk)) {
            d.a(this.lqk, null);
            try {
                String str;
                int i;
                int i2;
                long nanoTime = System.nanoTime();
                byte[] t = g.t((q.yE() + c.Cg()).getBytes());
                File file = new File(this.lqa);
                if (!(this.lqb && file.exists())) {
                    boolean renameTo;
                    boolean save = MasterInfo.save(this.lqc, this.lqd, t);
                    File file2 = new File(this.lqd);
                    if (save) {
                        file.delete();
                        renameTo = file2.renameTo(file);
                    } else {
                        file2.delete();
                        renameTo = save;
                    }
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    str = "MicroMsg.SubCoreDBBackup";
                    String str2 = "Master table backup %s, elapsed %.3f";
                    Object[] objArr = new Object[2];
                    objArr[0] = renameTo ? "SUCCEEDED" : "FAILED";
                    objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                    x.i(str, str2, objArr);
                    com.tencent.mm.plugin.report.service.g.pQN.a(181, renameTo ? 24 : 25, 1, false);
                }
                long length = new File(this.lps).length();
                long length2 = new File(this.lqe).length();
                String str3 = "MicroMsg.SubCoreDBBackup";
                String str4 = "Backup started [%s, cursor: %d ~ %d]";
                Object[] objArr2 = new Object[3];
                objArr2[0] = this.lqb ? "incremental" : "new";
                objArr2[1] = Long.valueOf(this.lqf != null ? this.lqf[0] : 0);
                objArr2[2] = Long.valueOf(this.lqg[0]);
                x.i(str3, str4, objArr2);
                int i3 = this.lqb ? CdnLogic.kMediaTypeBeatificFile : 10000;
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr3 = new Object[2];
                objArr3[0] = Integer.valueOf(i3);
                objArr3[1] = String.format("%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), this.lqk.lpS.format(new Date())});
                gVar.h(11098, objArr3);
                d.a(this.lqk, new BackupKit(this.lqc, this.lqe, t, this.lqh, this.lqi));
                int run = d.b(this.lqk).run();
                nanoTime = System.nanoTime() - nanoTime;
                File file3 = new File(this.lqe);
                long length3 = file3.length();
                if (run == 0) {
                    d.b(this.lps, this.lqg);
                    file = new File(this.lqj);
                    file.delete();
                    file3.renameTo(file);
                    if (this.lqb) {
                        i = 10012;
                        i2 = 19;
                    } else {
                        i = 10001;
                        i2 = 16;
                    }
                } else {
                    file3.delete();
                    if (run == 1) {
                        if (this.lqb) {
                            i = 10013;
                            i2 = 20;
                        } else {
                            i = 10002;
                            i2 = 17;
                        }
                    } else if (this.lqb) {
                        i = 10014;
                        i2 = 21;
                    } else {
                        i = 10003;
                        i2 = 18;
                    }
                }
                str = "MicroMsg.SubCoreDBBackup";
                str3 = "Database %s backup %s, elapsed %.2f seconds.";
                objArr3 = new Object[3];
                objArr3[0] = this.lqb ? "incremental" : "new";
                String str5 = run == 0 ? "succeeded" : run == 1 ? "canceled" : "failed";
                objArr3[1] = str5;
                objArr3[2] = Float.valueOf(((float) nanoTime) / 1.0E9f);
                x.i(str, str3, objArr3);
                com.tencent.mm.plugin.report.service.g.pQN.a(181, (long) i2, 1, false);
                com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr4 = new Object[2];
                objArr4[0] = Integer.valueOf(i);
                objArr4[1] = String.format("%d|%d|%d|%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), Long.valueOf(length3), Integer.valueOf(d.b(this.lqk).statementCount()), Long.valueOf(nanoTime / 1000000), this.lqk.lpS.format(new Date())});
                gVar2.h(11098, objArr4);
                if (this.lpY != null) {
                    this.lpY.ou(run);
                }
                d.b(this.lqk).release();
                d.a(this.lqk, null);
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.Dk();
                FileOp.mh(stringBuilder.append(com.tencent.mm.kernel.g.Dj().gQi).append("dbback").toString());
                str5 = this.lqa;
                StringBuilder stringBuilder2 = new StringBuilder();
                com.tencent.mm.kernel.g.Dk();
                FileOp.x(str5, stringBuilder2.append(com.tencent.mm.kernel.g.Dj().gQi).append("dbback/EnMicroMsg.db.sm").toString());
                str5 = this.lqj;
                stringBuilder2 = new StringBuilder();
                com.tencent.mm.kernel.g.Dk();
                FileOp.x(str5, stringBuilder2.append(com.tencent.mm.kernel.g.Dj().gQi).append("dbback/EnMicroMsg.db.bak").toString());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database backup, path: %s", new Object[]{this.lps});
                if (this.lpY != null) {
                    this.lpY.ou(-1);
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(181, this.lqb ? 18 : 21, 1, false);
            } finally {
                if (d.b(this.lqk) != null) {
                    d.b(this.lqk).release();
                    d.a(this.lqk, null);
                }
                d.c(this.lqk);
            }
        } else if (this.lpY != null) {
            this.lpY.ou(1);
        }
    }
}
