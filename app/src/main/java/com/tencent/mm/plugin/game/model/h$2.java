package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.h.a;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.sdk.platformtools.x;

class h$2 implements a {
    final /* synthetic */ String jde;
    final /* synthetic */ ajq nbz;

    h$2(String str, ajq com_tencent_mm_protocal_c_ajq) {
        this.jde = str;
        this.nbz = com_tencent_mm_protocal_c_ajq;
    }

    public final void onComplete() {
        x.i("MicroMsg.GameCommOpertionProcessor", "menu icon download complete! save menu data. appid:%s", new Object[]{this.jde});
        SubCoreGameCenter.aRh().a("pb_game_hv_menu_" + this.jde, this.nbz);
    }
}
