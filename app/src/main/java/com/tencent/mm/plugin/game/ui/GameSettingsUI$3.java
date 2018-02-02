package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;

class GameSettingsUI$3 implements OnClickListener {
    final /* synthetic */ GameSettingsUI nvX;

    GameSettingsUI$3(GameSettingsUI gameSettingsUI) {
        this.nvX = gameSettingsUI;
    }

    public final void onClick(View view) {
        if (GameSettingsUI.c(this.nvX).isChecked()) {
            GameSettingsUI.c(this.nvX).setChecked(false);
            GameSettingsUI.b(this.nvX, false);
            return;
        }
        GameSettingsUI.c(this.nvX).setChecked(true);
        GameSettingsUI.b(this.nvX, true);
    }
}
