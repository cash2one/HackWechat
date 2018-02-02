package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.plugin.backup.bakoldlogic.d.b.1;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1$1 implements a {
    final /* synthetic */ 1 kso;

    b$1$1(1 1) {
        this.kso = 1;
    }

    public final boolean JC() {
        x.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
        this.kso.ksl.run();
        b.vD();
        return false;
    }

    public final boolean JB() {
        b.aqO();
        b.a(this.kso.ksn, new PLong(), new PLong(), new PLong(), this.kso.ksl, this.kso.ksm);
        return true;
    }

    public final String toString() {
        return super.toString() + "|initTempDB";
    }
}
