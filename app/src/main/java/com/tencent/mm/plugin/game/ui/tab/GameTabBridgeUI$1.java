package com.tencent.mm.plugin.game.ui.tab;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.ag;

class GameTabBridgeUI$1 implements c {
    final /* synthetic */ long hAU;
    final /* synthetic */ GameTabBridgeUI nwM;
    final /* synthetic */ Intent val$intent;

    GameTabBridgeUI$1(GameTabBridgeUI gameTabBridgeUI, long j, Intent intent) {
        this.nwM = gameTabBridgeUI;
        this.hAU = j;
        this.val$intent = intent;
    }

    public final void i(Bundle bundle) {
        ag.y(new 1(this));
    }
}
