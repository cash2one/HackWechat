package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.f.f$a;
import com.tencent.mm.sdk.platformtools.x;

class c$6 implements f$a {
    final /* synthetic */ c knN;

    c$6(c cVar) {
        this.knN = cVar;
    }

    public final void mF(int i) {
        int i2 = b.aps().aol().kiJ;
        x.i("MicroMsg.BackupPcProcessMgr", "heartBeatTimeoutCallback, heartBeatState[%d], state[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 0:
                if (i2 != 4) {
                    return;
                }
                if (1 == b.aps().apt().knD) {
                    b.aps().aol().kiJ = 14;
                    b.aps().apu().mK(14);
                    return;
                } else if (2 == b.aps().apt().knD) {
                    b.aps().aol().kiJ = 23;
                    b.aps().apv().mz(23);
                    return;
                } else {
                    return;
                }
            case 1:
                if (i2 == 14 || i2 == 23) {
                    b.aps().aol().kiJ = 4;
                    if (1 == b.aps().apt().knD) {
                        b.aps().apu().mK(4);
                        return;
                    } else if (2 == b.aps().apt().knD) {
                        b.aps().apv().mz(4);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
