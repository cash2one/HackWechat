package com.tencent.xweb.xwalk;

class b$2 implements Runnable {
    final /* synthetic */ b AsS;

    b$2(b bVar) {
        this.AsS = bVar;
    }

    public final void run() {
        while (this.AsS.AsR) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
