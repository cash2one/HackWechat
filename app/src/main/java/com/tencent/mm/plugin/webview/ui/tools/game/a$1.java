package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import android.os.RemoteException;

class a$1 extends c {
    final /* synthetic */ a tFo;

    a$1(a aVar) {
        this.tFo = aVar;
    }

    protected final void A(Bundle bundle) {
        try {
            if (this.tFo.tFi != null && bundle != null) {
                this.tFo.tFi.e(96, bundle);
            }
        } catch (RemoteException e) {
        }
    }
}
