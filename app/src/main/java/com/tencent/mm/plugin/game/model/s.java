package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;

public final class s implements e {
    private static boolean bgH = false;
    private static int nbW = 20;
    private static LinkedList<l> nbX = new LinkedList();
    private static ag nbY;
    private int offset = 0;

    public static void update() {
        ar.Hg();
        if (!(System.currentTimeMillis() - ((Long) c.CU().get(a.xnd, Long.valueOf(0))).longValue() > 86400000)) {
            x.i("MicroMsg.GameListUpdater", "No need to update");
        } else if (bgH) {
            x.e("MicroMsg.GameListUpdater", "Already running");
        } else {
            nbY = new ag("GameListUpdate");
            nbX.clear();
            Object sVar = new s();
            ar.CG().a(1215, sVar);
            ar.CG().a(new bh(sVar.offset, nbW), 0);
            bgH = true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            nbY.F(new 1(this, kVar));
        } else {
            aQl();
        }
    }

    private void aQl() {
        bgH = false;
        nbY.oAt.quit();
        ar.CG().b(1215, this);
    }
}
