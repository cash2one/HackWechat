package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.a.g;
import com.tencent.mm.aq.o;
import com.tencent.mm.by.f;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;

class d$3 implements Runnable {
    final /* synthetic */ b lpY;
    final /* synthetic */ c lpZ;
    final /* synthetic */ d lqk;
    final String[] lqn = new String[]{"message", "ImgInfo2", "videoinfo2", "EmojiInfo", "conversation", "rconversation"};
    final /* synthetic */ String lqo;

    d$3(d dVar, c cVar, String str, b bVar) {
        this.lqk = dVar;
        this.lpZ = cVar;
        this.lqo = str;
        this.lpY = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        SQLiteDatabase openDatabase;
        MasterInfo masterInfo;
        Throwable th;
        MasterInfo masterInfo2;
        SQLiteDatabase sQLiteDatabase;
        d.a(this.lqk, null);
        try {
            long nanoTime;
            int i;
            int i2;
            c.Fa();
            c.Fd();
            o.Pw();
            com.tencent.mm.modelvideo.o.TU();
            byte[] bytes = (q.yE() + c.Cg()).getBytes();
            byte[] t = g.t(bytes);
            byte[] bytes2 = g.s(bytes).substring(0, 7).getBytes();
            int i3 = SQLiteDatabase.CREATE_IF_NECESSARY;
            if (f.ckR()) {
                i3 = 805306368;
            }
            openDatabase = SQLiteDatabase.openDatabase(c.EV().ckV().getPath(), bytes2, d.azH(), null, i3, null, 0);
            try {
                nanoTime = System.nanoTime();
                String[] strArr = new String[2];
                strArr[0] = this.lqo + ".sm";
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.Dk();
                strArr[1] = stringBuilder.append(com.tencent.mm.kernel.g.Dj().gQi).append("dbback/EnMicroMsg.db.sm").toString();
                int i4 = 0;
                masterInfo = null;
                while (i4 < 2) {
                    try {
                        String str = strArr[i4];
                        masterInfo = MasterInfo.load(str, t, this.lqn);
                        x.i("MicroMsg.SubCoreDBBackup", "Loaded saved master: " + str);
                        break;
                    } catch (Exception e) {
                        x.e("MicroMsg.SubCoreDBBackup", "Failed to load saved master: " + e.getMessage());
                        i4++;
                    } catch (Throwable th2) {
                        th = th2;
                        masterInfo2 = masterInfo;
                    }
                }
                if (masterInfo == null) {
                    masterInfo = MasterInfo.make(this.lqn);
                    x.w("MicroMsg.SubCoreDBBackup", "Saved master not available.");
                    com.tencent.mm.plugin.report.service.g.pQN.a(181, 32, 1, true);
                } else if (i4 > 0) {
                    x.i("MicroMsg.SubCoreDBBackup", "Use backup saved master.");
                    com.tencent.mm.plugin.report.service.g.pQN.a(181, 33, 1, true);
                }
                d.a(this.lqk, new RepairKit(this.lqo, bytes2, d.azH(), masterInfo));
                i = d.e(this.lqk).output(openDatabase, 1) == 0 ? 1 : 0;
                i2 = (d.e(this.lqk).isHeaderCorrupted() && d.e(this.lqk).isDataCorrupted()) ? 0 : 1;
                i &= i2;
                openDatabase.close();
                sQLiteDatabase = null;
            } catch (Exception e2) {
                th = e2;
                sQLiteDatabase = openDatabase;
                masterInfo2 = null;
                try {
                    x.printErrStackTrace("MicroMsg.SubCoreDBBackup", th, "Failed to repair database '%s'", new Object[]{this.lqo});
                    if (this.lpY != null) {
                        this.lpY.ou(-1);
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.c("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                    com.tencent.mm.plugin.report.service.g.pQN.a(181, 27, 1, true);
                    if (d.e(this.lqk) != null) {
                        d.e(this.lqk).release();
                        d.a(this.lqk, null);
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    if (masterInfo2 != null) {
                        masterInfo2.release();
                    }
                    d.c(this.lqk);
                    ar.Dm().cfE();
                } catch (Throwable th3) {
                    th = th3;
                    openDatabase = sQLiteDatabase;
                    if (d.e(this.lqk) != null) {
                        d.e(this.lqk).release();
                        d.a(this.lqk, null);
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    if (masterInfo2 != null) {
                        masterInfo2.release();
                    }
                    d.c(this.lqk);
                    ar.Dm().cfE();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                masterInfo2 = null;
                if (d.e(this.lqk) != null) {
                    d.e(this.lqk).release();
                    d.a(this.lqk, null);
                }
                if (openDatabase != null) {
                    openDatabase.close();
                }
                if (masterInfo2 != null) {
                    masterInfo2.release();
                }
                d.c(this.lqk);
                ar.Dm().cfE();
                throw th;
            }
            try {
                masterInfo.release();
                masterInfo2 = null;
                try {
                    d.e(this.lqk).release();
                    d.a(this.lqk, null);
                    d.azF();
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    String str2 = "MicroMsg.SubCoreDBBackup";
                    String str3 = "DB repair %s, elapsed %.2f seconds.";
                    Object[] objArr = new Object[2];
                    objArr[0] = i != 0 ? "succeeded" : "failed";
                    objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                    x.i(str2, str3, objArr);
                    if (i != 0) {
                        i2 = 26;
                        if (this.lpY != null) {
                            this.lpY.ou(0);
                        }
                    } else {
                        i2 = 27;
                        if (this.lpY != null) {
                            this.lpY.ou(-1);
                        }
                        com.tencent.mm.plugin.report.service.g.pQN.c("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.a(181, (long) i2, 1, true);
                    if (d.e(this.lqk) != null) {
                        d.e(this.lqk).release();
                        d.a(this.lqk, null);
                    }
                    d.c(this.lqk);
                    ar.Dm().cfE();
                } catch (Exception e3) {
                    th = e3;
                    x.printErrStackTrace("MicroMsg.SubCoreDBBackup", th, "Failed to repair database '%s'", new Object[]{this.lqo});
                    if (this.lpY != null) {
                        this.lpY.ou(-1);
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.c("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                    com.tencent.mm.plugin.report.service.g.pQN.a(181, 27, 1, true);
                    if (d.e(this.lqk) != null) {
                        d.e(this.lqk).release();
                        d.a(this.lqk, null);
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    if (masterInfo2 != null) {
                        masterInfo2.release();
                    }
                    d.c(this.lqk);
                    ar.Dm().cfE();
                } catch (Throwable th5) {
                    th = th5;
                    openDatabase = null;
                    if (d.e(this.lqk) != null) {
                        d.e(this.lqk).release();
                        d.a(this.lqk, null);
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    if (masterInfo2 != null) {
                        masterInfo2.release();
                    }
                    d.c(this.lqk);
                    ar.Dm().cfE();
                    throw th;
                }
            } catch (Exception e4) {
                th = e4;
                masterInfo2 = masterInfo;
                x.printErrStackTrace("MicroMsg.SubCoreDBBackup", th, "Failed to repair database '%s'", new Object[]{this.lqo});
                if (this.lpY != null) {
                    this.lpY.ou(-1);
                }
                com.tencent.mm.plugin.report.service.g.pQN.c("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                com.tencent.mm.plugin.report.service.g.pQN.a(181, 27, 1, true);
                if (d.e(this.lqk) != null) {
                    d.e(this.lqk).release();
                    d.a(this.lqk, null);
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                if (masterInfo2 != null) {
                    masterInfo2.release();
                }
                d.c(this.lqk);
                ar.Dm().cfE();
            } catch (Throwable th6) {
                th = th6;
                openDatabase = null;
                masterInfo2 = masterInfo;
                if (d.e(this.lqk) != null) {
                    d.e(this.lqk).release();
                    d.a(this.lqk, null);
                }
                if (openDatabase != null) {
                    openDatabase.close();
                }
                if (masterInfo2 != null) {
                    masterInfo2.release();
                }
                d.c(this.lqk);
                ar.Dm().cfE();
                throw th;
            }
        } catch (Exception e5) {
            th = e5;
            sQLiteDatabase = null;
            masterInfo2 = null;
            x.printErrStackTrace("MicroMsg.SubCoreDBBackup", th, "Failed to repair database '%s'", new Object[]{this.lqo});
            if (this.lpY != null) {
                this.lpY.ou(-1);
            }
            com.tencent.mm.plugin.report.service.g.pQN.c("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
            com.tencent.mm.plugin.report.service.g.pQN.a(181, 27, 1, true);
            if (d.e(this.lqk) != null) {
                d.e(this.lqk).release();
                d.a(this.lqk, null);
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            if (masterInfo2 != null) {
                masterInfo2.release();
            }
            d.c(this.lqk);
            ar.Dm().cfE();
        } catch (Throwable th7) {
            th = th7;
            openDatabase = null;
            masterInfo2 = null;
            if (d.e(this.lqk) != null) {
                d.e(this.lqk).release();
                d.a(this.lqk, null);
            }
            if (openDatabase != null) {
                openDatabase.close();
            }
            if (masterInfo2 != null) {
                masterInfo2.release();
            }
            d.c(this.lqk);
            ar.Dm().cfE();
            throw th;
        }
    }
}
