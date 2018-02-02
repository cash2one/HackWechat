package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.z.ar;

class GameSettingsUI$5 implements OnCancelListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ GameSettingsUI nvX;

    GameSettingsUI$5(GameSettingsUI gameSettingsUI, k kVar) {
        this.nvX = gameSettingsUI;
        this.flZ = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.flZ);
    }
}
