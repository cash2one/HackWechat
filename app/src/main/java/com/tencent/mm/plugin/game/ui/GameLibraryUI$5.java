package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;

class GameLibraryUI$5 implements OnClickListener {
    final /* synthetic */ GameLibraryUI nsw;

    GameLibraryUI$5(GameLibraryUI gameLibraryUI) {
        this.nsw = gameLibraryUI;
    }

    public final void onClick(View view) {
        c.a(view, this.nsw);
        ap.a(this.nsw, 11, 1110, 999, 7, GameLibraryUI.e(this.nsw), null);
    }
}
