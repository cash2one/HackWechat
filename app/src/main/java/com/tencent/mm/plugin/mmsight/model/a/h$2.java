package com.tencent.mm.plugin.mmsight.model.a;

class h$2 implements Runnable {
    final /* synthetic */ h ouI;

    h$2(h hVar) {
        this.ouI = hVar;
    }

    public final void run() {
        if (this.ouI.fkb != null) {
            this.ouI.ouE = true;
            this.ouI.fkb.vi();
        }
    }
}
