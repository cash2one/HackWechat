package com.tencent.mm.plugin.appbrand.debugger;

class RemoteDebugMoveView$2 implements Runnable {
    final /* synthetic */ RemoteDebugMoveView iQO;

    RemoteDebugMoveView$2(RemoteDebugMoveView remoteDebugMoveView) {
        this.iQO = remoteDebugMoveView;
    }

    public final void run() {
        if (this.iQO.getY() + ((float) this.iQO.getHeight()) > ((float) RemoteDebugMoveView.c(this.iQO))) {
            this.iQO.setY((float) (RemoteDebugMoveView.c(this.iQO) - this.iQO.getHeight()));
        }
    }
}
