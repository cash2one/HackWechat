package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.sdk.platformtools.x;

class d$7 implements Runnable {
    final /* synthetic */ d mii;

    d$7(d dVar) {
        this.mii = dVar;
    }

    public final void run() {
        synchronized (this.mii.mic) {
            if (this.mii.mhW) {
                x.i("MicroMsg.NumberFaceMotion", "hy: user already start. do nothing");
            } else {
                x.w("MicroMsg.NumberFaceMotion", "hy: not triggered symbol. auto start");
                this.mii.mhW = true;
                d.b(this.mii);
            }
        }
    }
}
