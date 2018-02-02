package com.tencent.mm.plugin.mmsight.segment.a;

import com.tencent.mm.plugin.s.c;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements c {
    final /* synthetic */ b oAr;

    b$1(b bVar) {
        this.oAr = bVar;
    }

    public final void hX() {
        if (this.oAr.oAp != null) {
            this.oAr.oAp.by(this.oAr.oAj);
        }
        if (this.oAr.fAs) {
            this.oAr.oAj.start();
        }
        this.oAr.HE = true;
    }

    public final void vh() {
        if (this.oAr.hkw) {
            this.oAr.oAj.sD(this.oAr.oAl);
        }
    }

    public final void onError(int i, int i2) {
        if (this.oAr.oAn != null) {
            this.oAr.oAn.cP(i, i2);
        }
    }

    public final void aZA() {
        x.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[]{this.oAr.oAq});
        if (this.oAr.oAq != null) {
            this.oAr.oAq.bz(this.oAr.oAj);
        } else if (this.oAr.fAs) {
            this.oAr.oAj.start();
        }
    }

    public final void O(int i, int i2, int i3) {
        this.oAr.oAk = i3;
        if (this.oAr.oAo != null) {
            this.oAr.oAo.Q(i, i2, i3);
        }
    }
}
