package com.tencent.mm.plugin.location.ui.impl;

class i$6 implements Runnable {
    final /* synthetic */ i nYD;

    i$6(i iVar) {
        this.nYD = iVar;
    }

    public final void run() {
        if (this.nYD.nVY) {
            if (this.nYD.iln != null) {
                this.nYD.iln.dismiss();
            }
            this.nYD.aWH();
        }
        this.nYD.nVY = false;
    }
}
