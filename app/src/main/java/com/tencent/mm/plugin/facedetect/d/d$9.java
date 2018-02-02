package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.d.a.b;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class d$9 implements b {
    final /* synthetic */ d mii;

    d$9(d dVar) {
        this.mii = dVar;
    }

    public final void aGT() {
        synchronized (this.mii.mic) {
            x.i("MicroMsg.NumberFaceMotion", "hy: triggered read symbol");
            if (!this.mii.mhW && this.mii.mhX) {
                this.mii.mhW = true;
                d.b(this.mii);
            }
        }
    }

    public final void onError(int i) {
        synchronized (this.mii.mic) {
            x.w("MicroMsg.NumberFaceMotion", "hy: on voice prepare error: %d", new Object[]{Integer.valueOf(i)});
            switch (i) {
                case 11:
                    this.mii.mhU = true;
                    break;
                default:
                    this.mii.mid = true;
                    this.mii.mie = new a(ac.getResources().getString(h.ezQ));
                    break;
            }
        }
    }
}
