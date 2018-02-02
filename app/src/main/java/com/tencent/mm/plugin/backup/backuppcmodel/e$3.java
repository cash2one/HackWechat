package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.b.d;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

class e$3 implements d {
    final /* synthetic */ e koc;

    e$3(e eVar) {
        this.koc = eVar;
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        String str = "MicroMsg.BackupPcServer";
        String str2 = "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[4] = Boolean.valueOf(e.apc());
        x.i(str, str2, objArr);
        if (!z || bArr == null) {
            if (1 != b.aps().apt().knD && 3 != b.aps().apt().knD) {
                return;
            }
            if (i == 10) {
                try {
                    new f().aF(bArr);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BackupPcServer", e, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
                }
                x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", Long.valueOf(r0.kph));
            } else if (i == 5) {
                x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
                this.koc.al(true);
                b.aps().aol().kiJ = -100;
                this.koc.mK(-100);
                g.pQN.a(400, 51, 1, false);
                this.koc.mJ(5);
            } else if (i == 18) {
                c cVar = new c();
                try {
                    cVar.aF(bArr);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.BackupPcServer", e2, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
                }
                x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", Integer.valueOf(cVar.ksA));
                if (cVar.ksA == 9) {
                    if (b.apP() == 1) {
                        b.mM(2);
                        x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                        this.koc.mJ(20);
                        b.apO();
                        b.aps().aol().kiJ = 14;
                        this.koc.mK(14);
                        b.a(new 1(this));
                        return;
                    }
                    x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", Integer.valueOf(b.apP()));
                }
            } else if (i == 17) {
                com.tencent.mm.plugin.backup.h.b bVar = new com.tencent.mm.plugin.backup.h.b();
                try {
                    bVar.aF(bArr);
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.BackupPcServer", e22, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
                }
                x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", Integer.valueOf(bVar.ksA));
                if (bVar.ksA == 10) {
                    int i3 = b.aps().aol().kiJ;
                    x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", Integer.valueOf(i3));
                    if (i3 == 12 || i3 == 14) {
                        this.koc.al(true);
                        b.aps().aoS().stop();
                        b.aps().aol().kiJ = -4;
                        this.koc.mK(-4);
                        g.pQN.a(400, 51, 1, false);
                        this.koc.mJ(5);
                        long j = 0;
                        if (e.b(this.koc).kjr != 0) {
                            j = bh.bz(e.b(this.koc).kjr);
                        }
                        g.pQN.h(13737, Integer.valueOf(3), Long.valueOf(e.b(this.koc).aoy()), Long.valueOf(j / 1000), Integer.valueOf(1));
                        x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", Long.valueOf(e.b(this.koc).aoy()), Long.valueOf(j / 1000));
                    }
                }
            }
        } else if (CdnLogic.kMediaTypeBeatificFile == i) {
            x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", Integer.valueOf(b.aps().aol().kiJ));
            switch (b.aps().aol().kiJ) {
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -5:
                    b.aps().aoS().stop();
                    return;
                case -4:
                    this.koc.al(true);
                    return;
                case 1:
                case 11:
                    b.aps().aoS().stop();
                    b.aps().aol().kiJ = -100;
                    this.koc.mK(-100);
                    return;
                case 4:
                case 12:
                case 14:
                    if (!b.aps().apt().knH || e.apc()) {
                        x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
                        this.koc.al(true);
                        b.aps().aoS().stop();
                        b.aps().aol().kiJ = -4;
                        this.koc.mK(-4);
                        g.pQN.a(400, 9, 1, false);
                        this.koc.mJ(3);
                        return;
                    }
                    switch (b.apP()) {
                        case 0:
                        case 2:
                            x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", Integer.valueOf(b.apP()));
                            this.koc.mJ(19);
                            e.c(this.koc);
                            b.a(b.aps().apt().knM);
                            return;
                        case 1:
                            x.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", Integer.valueOf(b.apP()));
                            return;
                        default:
                            return;
                    }
                case 15:
                    b.aps().aoS().stop();
                    b.aps().aol().kiJ = -100;
                    this.koc.mK(-100);
                    return;
                default:
                    return;
            }
        }
    }
}
