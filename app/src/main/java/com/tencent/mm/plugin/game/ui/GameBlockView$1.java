package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;

class GameBlockView$1 implements OnClickListener {
    final /* synthetic */ int nlX;
    final /* synthetic */ GameBlockView nlY;

    GameBlockView$1(GameBlockView gameBlockView, int i) {
        this.nlY = gameBlockView;
        this.nlX = i;
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            ap.a(this.nlY.getContext(), 10, 1002, 99, c.p(this.nlY.getContext(), (String) view.getTag(), "game_center_mygame_more"), this.nlX, null);
        }
    }
}
