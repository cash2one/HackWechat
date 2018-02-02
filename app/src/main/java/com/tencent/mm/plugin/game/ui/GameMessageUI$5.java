package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bh;

class GameMessageUI$5 implements OnClickListener {
    final /* synthetic */ GameMessageUI ntK;

    GameMessageUI$5(GameMessageUI gameMessageUI) {
        this.ntK = gameMessageUI;
    }

    public final void onClick(View view) {
        if (!bh.ov(GameMessageUI.f(this.ntK))) {
            ap.a(this.ntK.mController.xIM, 13, 1302, 1, c.ac(this.ntK.mController.xIM, GameMessageUI.f(this.ntK)), GameMessageUI.g(this.ntK), null);
        }
        GameMessageUI.h(this.ntK);
    }
}
