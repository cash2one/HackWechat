package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.backup.h.n;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends b {
    public n kpC = new n();
    public o kpD = new o();

    public final /* bridge */ /* synthetic */ a apH() {
        return this.kpD;
    }

    public j(String str) {
        x.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[]{str});
        this.kpC.ID = str;
    }

    public final int getType() {
        return 3;
    }

    public final a apI() {
        return this.kpC;
    }

    public final void mL(int i) {
        x.i("MicroMsg.BackupStartScene", "onSceneEnd.");
        if (this.kpD.ktm != 0) {
            f(4, this.kpD.ktm, "BackupStartScene onSceneEnd failed");
        } else {
            f(0, this.kpD.ktm, "BackupStartScene onSceneEnd success");
        }
    }
}
