package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class GameSettingsUI$1 implements OnClickListener {
    final /* synthetic */ GameSettingsUI nvX;

    GameSettingsUI$1(GameSettingsUI gameSettingsUI) {
        this.nvX = gameSettingsUI;
    }

    public final void onClick(View view) {
        h.a(this.nvX, R.l.eme, R.l.emd, new 1(this), new 2(this));
    }
}
