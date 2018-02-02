package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.f.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements e {
    final /* synthetic */ c knN;

    c$3(c cVar) {
        this.knN = cVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        c.akQ();
        g.pQN.h(13736, new Object[]{Integer.valueOf(0), c.e(this.knN), com.tencent.mm.plugin.backup.a.g.cl(ac.getContext()), Integer.valueOf(0), Integer.valueOf(b.aps().apt().knJ)});
        b.b(1, c.f(this.knN));
        if (i == 0 && i2 == 0) {
            a aVar = (a) kVar;
            x.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", new Object[]{Boolean.valueOf((aVar.koC.ktO & c.kiy) != 0), Boolean.valueOf((aVar.koC.ktO & c.kiz) != 0), Boolean.valueOf((aVar.koC.ktO & c.kiA) != 0)});
            if ((aVar.koC.ktO & c.kiA) != 0) {
                com.tencent.mm.bq.b bVar = aVar.koC.ktQ == null ? null : aVar.koC.ktQ;
                if (bVar != null) {
                    this.knN.a(true, bVar);
                    b.aps().apu().knY = r0;
                    b.aps().apu().knZ = r1;
                    return;
                }
                x.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
            }
            this.knN.a(false, null);
            b.aps().apu().knY = r0;
            b.aps().apu().knZ = r1;
            return;
        }
        x.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (i2) {
            case -3:
                g.pQN.a(400, 115, 1, false);
                break;
            case -1:
                g.pQN.a(400, 114, 1, false);
                break;
            default:
                g.pQN.a(400, 116, 1, false);
                break;
        }
        g.pQN.h(13737, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.g(this.knN))});
        b.aps().aol().kiJ = -5;
        b.aps().apu().mK(-5);
    }
}
