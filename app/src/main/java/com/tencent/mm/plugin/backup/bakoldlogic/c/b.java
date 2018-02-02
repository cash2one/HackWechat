package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.backup.h.ab;
import com.tencent.mm.plugin.backup.h.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends com.tencent.mm.plugin.backup.f.b {
    private ab kry = new ab();
    private ac krz = new ac();

    public b(int i) {
        this.kry.ksA = i;
    }

    public final a apH() {
        return this.krz;
    }

    public final a apI() {
        return this.kry;
    }

    public final void mL(int i) {
        if (this.krz.ktm == 0) {
            f(0, 0, "ok");
            return;
        }
        x.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[]{Integer.valueOf(this.kry.ksA), Integer.valueOf(this.krz.ktm)});
        f(4, this.krz.ktm, "fail");
    }

    public final int getType() {
        return 3;
    }
}
