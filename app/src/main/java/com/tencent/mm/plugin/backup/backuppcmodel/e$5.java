package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.a.b$b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

class e$5 implements b$b {
    final /* synthetic */ e koc;

    e$5(e eVar) {
        this.koc = eVar;
    }

    public final void mz(int i) {
        Set hashSet = new HashSet();
        hashSet.addAll(e.d(this.koc));
        ag.y(new 1(this, hashSet, i));
        if (e.e(this.koc) != null) {
            ag.y(new 2(this, i));
        }
    }

    public final void aoh() {
        g.pQN.a(400, 11, 1, false);
        g.pQN.a(400, 12, e.b(this.koc) == null ? 0 : bh.bz(e.b(this.koc).kjr) / 1000, false);
        g.pQN.a(400, 13, e.b(this.koc) == null ? 0 : e.b(this.koc).aoy(), false);
        this.koc.mJ(0);
        if (!e.f(this.koc)) {
            this.koc.mJ(21);
        }
    }

    public final void aoi() {
        x.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", new Object[]{Boolean.valueOf(false)});
        this.koc.al(false);
        g.pQN.a(400, 120, 1, false);
    }
}
