package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.ac;

class RemoteDebugMoveView$1 implements Runnable {
    final /* synthetic */ RemoteDebugMoveView iQO;

    RemoteDebugMoveView$1(RemoteDebugMoveView remoteDebugMoveView) {
        this.iQO = remoteDebugMoveView;
    }

    public final void run() {
        this.iQO.setX((float) (RemoteDebugMoveView.a(this.iQO) - RemoteDebugMoveView.b(this.iQO)));
        this.iQO.setY((float) ((int) (a.getDensity(ac.getContext()) * 120.0f)));
    }
}
