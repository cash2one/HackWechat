package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ui.o.a;

class GameMessageUI$3 implements a {
    final /* synthetic */ GameMessageUI ntK;

    GameMessageUI$3(GameMessageUI gameMessageUI) {
        this.ntK = gameMessageUI;
    }

    public final void Xw() {
    }

    public final void Xv() {
        if (GameMessageUI.b(this.ntK).getCount() == 0) {
            GameMessageUI.e(this.ntK).setVisibility(8);
            GameMessageUI.a(this.ntK, 0);
            this.ntK.enableOptionMenu(false);
            return;
        }
        GameMessageUI.e(this.ntK).setVisibility(0);
        GameMessageUI.a(this.ntK, 8);
        this.ntK.enableOptionMenu(true);
    }
}
