package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.game.c.bp;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class as$1 implements e {
    final /* synthetic */ as$a nev;

    as$1(as$a com_tencent_mm_plugin_game_model_as_a) {
        this.nev = com_tencent_mm_plugin_game_model_as_a;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(2641, this);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.NetSceneGameIndex4TabNav", "pull gameIndexTabNav data success");
            ag.y(new 1(this, (bp) ((as) kVar).lMW.hmh.hmo));
            return;
        }
        x.i("MicroMsg.NetSceneGameIndex4TabNav", "pull gameIndexTabNav data fail");
    }
}
