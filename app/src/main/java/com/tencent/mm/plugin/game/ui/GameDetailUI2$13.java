package com.tencent.mm.plugin.game.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.model.ap;

class GameDetailUI2$13 implements OnMenuItemClickListener {
    final /* synthetic */ GameDetailUI2 npz;

    GameDetailUI2$13(GameDetailUI2 gameDetailUI2) {
        this.npz = gameDetailUI2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        GameDetailUI2.a(this.npz, GameDetailUI2.e(this.npz));
        ap.a(this.npz.mController.xIM, 12, 1207, 1, 2, GameDetailUI2.f(this.npz), GameDetailUI2.g(this.npz), null);
        return false;
    }
}
