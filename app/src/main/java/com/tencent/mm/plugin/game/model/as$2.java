package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.bp;
import com.tencent.mm.sdk.platformtools.x;

class as$2 implements as$b {
    final /* synthetic */ bp new;

    as$2(bp bpVar) {
        this.new = bpVar;
    }

    public final void onComplete() {
        x.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
        SubCoreGameCenter.aRh().a("game_index4_tab_nav", this.new);
    }
}
