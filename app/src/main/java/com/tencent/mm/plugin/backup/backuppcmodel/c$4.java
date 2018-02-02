package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.backup.f.b.d;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Arrays;
import java.util.LinkedList;

class c$4 implements d {
    final /* synthetic */ c knN;

    c$4(c cVar) {
        this.knN = cVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean z, int i, byte[] bArr, int i2) {
        String str = "MicroMsg.BackupPcProcessMgr";
        String str2 = "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.i(str, str2, objArr);
        if (!z || bArr == null) {
            if (i == 17) {
                b bVar = new b();
                try {
                    bVar.aF(bArr);
                    x.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", new Object[]{Integer.valueOf(bVar.ksA)});
                    switch (bVar.ksA) {
                        case 1:
                            c.a(this.knN, 1, i2);
                            break;
                        case 3:
                            c.b(this.knN, 3, i2);
                            break;
                        case 5:
                            ar.Hg();
                            if (!((Boolean) c.CU().get(a.xtd, Boolean.valueOf(false))).booleanValue()) {
                                x.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
                                c.a(this.knN, 5, i2);
                                break;
                            }
                            b.aps();
                            String string = b.aoq().getString("BACKUP_PC_CHOOSE_SESSION", null);
                            if (string != null) {
                                x.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
                                g.pQN.a(400, 29, 1, false);
                                this.knN.knD = 3;
                                LinkedList linkedList = new LinkedList(Arrays.asList(com.tencent.mm.plugin.backup.a.g.bF(string, ",")));
                                b.aps().apu().init();
                                b.aps().apu().A(linkedList);
                                c.cb(5, i2);
                                b.aps().apu().aoj();
                                this.knN.mI(6);
                                e apu = b.aps().apu();
                                com.tencent.mm.plugin.backup.g.d.aqe().aqh();
                                apu.bI((long) apu.klA.size());
                                break;
                            }
                            x.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
                            c.a(this.knN, 5, i2);
                            break;
                        case 7:
                            ar.Hg();
                            if (!((Boolean) c.CU().get(a.xte, Boolean.valueOf(false))).booleanValue()) {
                                x.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
                                c.b(this.knN, 7, i2);
                                break;
                            }
                            b.aps().apv();
                            if (!d.aoW()) {
                                x.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
                                c.b(this.knN, 7, i2);
                                break;
                            }
                            x.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
                            g.pQN.a(400, 30, 1, false);
                            this.knN.knD = 4;
                            b.aps().apv().init();
                            c.cb(7, i2);
                            b.aps().apu().aoj();
                            this.knN.mI(8);
                            break;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
                }
            }
            if (i == 5) {
                x.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
                g.pQN.h(13737, new Object[]{Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(b.aps().apt().knJ)});
                b.aps().aol().kiJ = -100;
                b.aps().apu().mK(-100);
            }
        } else if (CdnLogic.kMediaTypeBeatificFile == i) {
            x.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]", new Object[]{Integer.valueOf(b.aps().aol().kiJ)});
            switch (b.aps().aol().kiJ) {
                case -100:
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -5:
                    b.aps().aoS().stop();
                    return;
                case 1:
                    if (c.access$200()) {
                        b.aps().aoS().stop();
                        b.aps().aol().kiJ = -4;
                        b.aps().apu().mK(-4);
                        return;
                    }
                    if (c.c(this.knN) != null) {
                        x.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.");
                        c.c(this.knN).TG();
                    }
                    c.d(this.knN);
                    return;
                default:
                    return;
            }
        }
    }
}
