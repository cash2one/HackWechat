package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;

public class j implements e {
    private static j nbH;
    private boolean hjs = false;

    public static j aQe() {
        if (nbH == null) {
            synchronized (j.class) {
                if (nbH == null) {
                    nbH = new j();
                }
            }
        }
        return nbH;
    }

    public final synchronized void fB(boolean z) {
        Object obj;
        if (z) {
            obj = 1;
        } else if (bh.by(Long.valueOf(bh.c((Long) g.Dj().CU().get(a.xne, Long.valueOf(0)))).longValue()) > 86400) {
            int i = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            if (!this.hjs) {
                x.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", new Object[]{Boolean.valueOf(z)});
                release();
                this.hjs = true;
                ar.CG().a(1311, this);
                ar.CG().a(new ay(), 0);
            }
        }
    }

    private void release() {
        this.hjs = false;
        ar.CG().b(1311, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 1311) {
            x.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            g.Dj().CU().a(a.xne, Long.valueOf(bh.Wo()));
            release();
        }
    }
}
