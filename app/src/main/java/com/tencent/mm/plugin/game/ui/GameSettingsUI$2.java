package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;

class GameSettingsUI$2 implements OnClickListener {
    final /* synthetic */ GameSettingsUI nvX;

    GameSettingsUI$2(GameSettingsUI gameSettingsUI) {
        this.nvX = gameSettingsUI;
    }

    public final void onClick(View view) {
        if (GameSettingsUI.b(this.nvX).isChecked()) {
            GameSettingsUI.b(this.nvX).setChecked(false);
            GameSettingsUI.a(this.nvX, false);
            return;
        }
        GameSettingsUI.b(this.nvX).setChecked(true);
        GameSettingsUI.a(this.nvX, true);
    }
}
