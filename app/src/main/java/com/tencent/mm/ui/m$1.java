package com.tencent.mm.ui;

class m$1 implements Runnable {
    final /* synthetic */ m xHN;

    m$1(m mVar) {
        this.xHN = mVar;
    }

    public final void run() {
        if (this.xHN.xHM != null) {
            this.xHN.xHM.run();
        }
    }

    public final String toString() {
        return super.toString() + "|onInitDelay";
    }
}
