package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.5;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class f$4 extends a {
    final /* synthetic */ f krr;

    f$4(f fVar) {
        this.krr = fVar;
    }

    public final void run() {
        f fVar = this.krr;
        int ah = f.ah(fVar.krk);
        x.i("MicroMsg.RecoverPCServer", "all msg item Count : " + ah);
        x.d("MicroMsg.RecoverPCServer", "readFromSdcard start");
        e.d(new 5(fVar, ah), "RecoverPCServer_recoverFromSdcard", 1).start();
    }
}
