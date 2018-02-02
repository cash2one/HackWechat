package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.f.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class c$6 implements e {
    final /* synthetic */ c klx;

    c$6(c cVar) {
        this.klx = cVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        c.dE(true);
        g.pQN.a(485, 42, 1, false);
        g.pQN.h(11787, new Object[]{Integer.valueOf(0)});
        b.b(1, c.f(this.klx));
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
            a aVar = (a) kVar;
            if (aVar.koC.ktM < c.kit) {
                x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", new Object[]{Integer.valueOf(aVar.koC.ktM)});
                g.pQN.a(485, 104, 1, false);
                b.aoR().aol().kiJ = -12;
                this.klx.mz(-12);
                return;
            }
            int i3 = aVar.koC.ktN;
            c.a(this.klx, (aVar.koC.ktO & c.kix) != 0);
            x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[]{Integer.valueOf(aVar.koC.ktM), Integer.valueOf(i3), Boolean.valueOf(c.g(this.klx))});
            if (i3 == c.kiv && c.aoW()) {
                c.b(this.klx, true);
                x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
            } else {
                this.klx.aoX();
                c.b(this.klx, false);
                x.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
            }
            c.h(this.klx);
            b.a(3, c.i(this.klx));
            new j(b.aoR().kiB).apQ();
            b.aoR().aol().kiJ = 22;
            this.klx.mz(22);
            return;
        }
        x.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
        b.aoR().aol().kiJ = -5;
        this.klx.mz(-5);
        this.klx.mD(3);
    }
}
