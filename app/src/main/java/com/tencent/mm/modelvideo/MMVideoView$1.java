package com.tencent.mm.modelvideo;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class MMVideoView$1 implements a {
    final /* synthetic */ MMVideoView hTM;

    MMVideoView$1(MMVideoView mMVideoView) {
        this.hTM = mMVideoView;
    }

    public final boolean uF() {
        if (MMVideoView.a(this.hTM) == null) {
            return false;
        }
        boolean iH;
        boolean isPlaying = this.hTM.isPlaying();
        if (isPlaying) {
            MMVideoView.b(this.hTM);
        }
        try {
            int currentPosition = MMVideoView.c(this.hTM).getCurrentPosition() / 1000;
            MMVideoView.a(this.hTM, currentPosition);
            iH = this.hTM.iH(currentPosition);
        } catch (Exception e) {
            x.e(MMVideoView.d(this.hTM), "%s online video timer check error [%s] ", new Object[]{MMVideoView.e(this.hTM), e.toString()});
            iH = false;
        }
        x.d(MMVideoView.f(this.hTM), "%s check timer[%b] isplay[%b]", new Object[]{MMVideoView.g(this.hTM), Boolean.valueOf(iH), Boolean.valueOf(isPlaying)});
        if (iH && isPlaying) {
            return true;
        }
        return false;
    }
}
