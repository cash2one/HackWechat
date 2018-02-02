package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.ui.GameMessageUI.2;

class GameMessageUI$2$1 implements OnClickListener {
    final /* synthetic */ 2 ntL;

    GameMessageUI$2$1(2 2) {
        this.ntL = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SubCoreGameCenter.aRd().fx("GameRawMessage", "delete from GameRawMessage");
        GameMessageUI.b(this.ntL.ntK).Xz();
        GameMessageUI.b(this.ntL.ntK).notifyDataSetChanged();
    }
}
