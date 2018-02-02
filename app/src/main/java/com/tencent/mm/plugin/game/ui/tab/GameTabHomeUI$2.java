package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class GameTabHomeUI$2 extends BroadcastReceiver {
    final /* synthetic */ GameTabHomeUI nwP;

    GameTabHomeUI$2(GameTabHomeUI gameTabHomeUI) {
        this.nwP = gameTabHomeUI;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && "com.tencent.mm.ACTION_EXIT".equals(intent.getAction()) && this.nwP != null && !this.nwP.isFinishing()) {
            x.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI exit!");
            this.nwP.finish();
        }
    }
}
