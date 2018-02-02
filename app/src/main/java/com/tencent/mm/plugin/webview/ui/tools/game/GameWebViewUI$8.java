package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class GameWebViewUI$8 extends BroadcastReceiver {
    final /* synthetic */ GameWebViewUI tFJ;

    GameWebViewUI$8(GameWebViewUI gameWebViewUI) {
        this.tFJ = gameWebViewUI;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && "com.tencent.mm.ACTION_RELOAD".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("hashcode", 0);
            if (intExtra == this.tFJ.hashCode()) {
                GameWebViewUI.K(this.tFJ);
                if (GameWebViewUI.L(this.tFJ)) {
                    GameWebViewUI.M(this.tFJ);
                    return;
                }
                return;
            }
            a aVar = this.tFJ.tEZ;
            if (intExtra == (aVar.juE != null ? aVar.juE.hashCode() : -1)) {
                this.tFJ.tEZ.bUd();
            }
        }
    }
}
