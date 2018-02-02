package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;

class GameDetailUI2$5 implements OnClickListener {
    final /* synthetic */ GameDetailUI2 npz;

    GameDetailUI2$5(GameDetailUI2 gameDetailUI2) {
        this.npz = gameDetailUI2;
    }

    public final void onClick(View view) {
        c.a(view, this.npz);
        ap.a(this.npz.mController.xIM, 12, 1206, 1, 7, GameDetailUI2.f(this.npz), GameDetailUI2.g(this.npz), null);
    }
}
