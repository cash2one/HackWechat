package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import android.os.RemoteException;

class GameBaseWebViewUI$1 extends c {
    final /* synthetic */ GameBaseWebViewUI tFa;

    GameBaseWebViewUI$1(GameBaseWebViewUI gameBaseWebViewUI) {
        this.tFa = gameBaseWebViewUI;
    }

    protected final void A(Bundle bundle) {
        try {
            if (GameBaseWebViewUI.a(this.tFa) != null && bundle != null) {
                GameBaseWebViewUI.b(this.tFa).e(96, bundle);
            }
        } catch (RemoteException e) {
        }
    }
}
