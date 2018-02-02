package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.f.g.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class c$8 implements a {
    final /* synthetic */ c knN;

    c$8(c cVar) {
        this.knN = cVar;
    }

    public final void apz() {
        x.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
        if (b.aps().aol().kiJ != 5) {
            b.aps().aol().kiJ = 5;
            int i = b.aps().apt().knD;
            if (1 == i || 3 == i) {
                b.aps().apu().mK(5);
            } else if (2 == i || 4 == i) {
                b.aps().apv().mz(5);
            }
        }
        this.knN.mI(9);
    }

    public final void apA() {
        int i = b.aps().apt().knD;
        x.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", new Object[]{Integer.valueOf(i)});
        if (1 == i || 3 == i) {
            b.aps().apu();
            e.apC();
            b.aps().apu().al(true);
            b.aps().aoS().stop();
            b.aps().aol().kiJ = -4;
            b.aps().apu().mK(-4);
            g.pQN.a(400, 9, 1, false);
            b.aps().apu().mJ(3);
        } else if (2 == i || 4 == i) {
            b.aps().apv();
            d.apB();
            b.aps().apv().a(true, false, -4);
            b.aps().aoS().stop();
            g.pQN.a(400, 17, 1, false);
            b.aps().apv().mJ(3);
        }
    }
}
