package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.b.d;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class d$1 implements d {
    final /* synthetic */ d knU;

    d$1(d dVar) {
        this.knU = dVar;
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        String str = "MicroMsg.BackupPcRecoverServer";
        String str2 = "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        if (z && CdnLogic.kMediaTypeBeatificFile == i) {
            d.a(this.knU);
        } else if (i == 5) {
            x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
            this.knU.a(true, false, -100);
            g.pQN.a(400, 52, 1, false);
            this.knU.mJ(5);
        } else {
            int i3 = b.aps().apt().knD;
            if (2 != i3 && 4 != i3) {
                x.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", Integer.valueOf(b.aps().apt().knD));
            } else if (i == 10) {
                f fVar = (f) com.tencent.mm.plugin.backup.a.g.a(new f(), bArr);
                str2 = "MicroMsg.BackupPcRecoverServer";
                String str3 = "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Long.valueOf(fVar != null ? fVar.kph : -1);
                x.i(str2, str3, objArr2);
            } else if (i == 18) {
                c cVar = new c();
                try {
                    cVar.aF(bArr);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
                }
                x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", Integer.valueOf(cVar.ksA));
                if (cVar.ksA == 9) {
                    if (b.apP() == 1) {
                        b.mM(2);
                        x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                        this.knU.mJ(20);
                        b.apO();
                        b.aps().aol().kiJ = 23;
                        this.knU.mz(23);
                        b.mM(0);
                        return;
                    }
                    x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", Integer.valueOf(b.apP()));
                }
            } else if (i == 17) {
                com.tencent.mm.plugin.backup.h.b bVar = new com.tencent.mm.plugin.backup.h.b();
                try {
                    bVar.aF(bArr);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
                }
                x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", Integer.valueOf(bVar.ksA));
                if (bVar.ksA == 10) {
                    i3 = b.aps().aol().kiJ;
                    x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", Integer.valueOf(i3));
                    if (i3 == 22 || i3 == 23) {
                        this.knU.a(true, false, -4);
                        b.aps().aoS().stop();
                        g.pQN.a(400, 52, 1, false);
                        this.knU.mJ(5);
                        long j = 0;
                        if (d.b(this.knU) != 0) {
                            j = bh.bz(d.b(this.knU));
                        }
                        g.pQN.h(13737, Integer.valueOf(3), Long.valueOf(d.c(this.knU)), Long.valueOf(j), Integer.valueOf(2));
                        x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", Long.valueOf(d.c(this.knU)), Long.valueOf(j));
                    }
                }
            } else {
                ar.Dm().F(new 1(this, i, bArr, i2));
            }
        }
    }
}
