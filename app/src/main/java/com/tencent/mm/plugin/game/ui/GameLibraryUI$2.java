package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameLibraryUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ GameLibraryUI nsw;

    GameLibraryUI$2(GameLibraryUI gameLibraryUI) {
        this.nsw = gameLibraryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.nsw, GameSearchUI.class);
        intent.putExtra("game_report_from_scene", 1109);
        this.nsw.startActivity(intent);
        return true;
    }
}
