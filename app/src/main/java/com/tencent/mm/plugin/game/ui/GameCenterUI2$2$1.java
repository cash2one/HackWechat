package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.ui.GameCenterUI2.2;
import com.tencent.mm.sdk.platformtools.x;

class GameCenterUI2$2$1 implements Runnable {
    final /* synthetic */ ai nnj;
    final /* synthetic */ 2 nnk;

    GameCenterUI2$2$1(2 2, ai aiVar) {
        this.nnk = 2;
        this.nnj = aiVar;
    }

    public final void run() {
        try {
            GameCenterUI2.a(this.nnk.nnh, this.nnj, 2);
        } catch (Exception e) {
            x.e("MicroMsg.GameCenterUI2", "GameCenter crash, %s", new Object[]{e.getMessage()});
            this.nnk.nnh.finish();
        }
        if (GameCenterUI2.i(this.nnk.nnh) != null) {
            GameCenterUI2.i(this.nnk.nnh).dismiss();
        }
        x.i("MicroMsg.GameCenterUI2", "Server data parsing time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.nnk.gyu)});
    }
}
