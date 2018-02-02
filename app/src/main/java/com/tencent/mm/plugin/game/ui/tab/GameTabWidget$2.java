package com.tencent.mm.plugin.game.ui.tab;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.sdk.platformtools.x;

class GameTabWidget$2 implements OnClickListener {
    final /* synthetic */ GameTabWidget nwT;

    GameTabWidget$2(GameTabWidget gameTabWidget) {
        this.nwT = gameTabWidget;
    }

    public final void onClick(View view) {
        try {
            GameTabWidget.a(GameTabWidget.b(this.nwT), (TabItem) view.getTag(), false, false, false);
        } catch (Exception e) {
            x.e("MicroMsg.GameTabWidget", "selectTab err:%s", new Object[]{e.getMessage()});
        }
    }
}
