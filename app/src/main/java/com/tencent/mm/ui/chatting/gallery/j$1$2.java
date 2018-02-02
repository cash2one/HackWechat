package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.chatting.gallery.j.1;

class j$1$2 implements Runnable {
    final /* synthetic */ 1 yGB;

    j$1$2(1 1) {
        this.yGB = 1;
    }

    public final void run() {
        if (this.yGB.yGA.yGh != null && this.yGB.yGA.yGh.getVisibility() != 0) {
            if (this.yGB.yGA.yGh.getTag() != null && (this.yGB.yGA.yGh.getTag() instanceof r)) {
                r rVar = (r) this.yGB.yGA.yGh.getTag();
                if (rVar.hVQ != null && !bh.ov(rVar.hVQ.hdo)) {
                    this.yGB.yGA.yGh.setVisibility(8);
                    return;
                } else if (!(rVar.hVQ == null || bh.ov(rVar.hVQ.hdr) || bh.ov(rVar.hVQ.hds))) {
                    this.yGB.yGA.yGh.setVisibility(8);
                    return;
                }
            }
            this.yGB.yGA.yGh.setVisibility(0);
            this.yGB.yGA.yGh.startAnimation(AnimationUtils.loadAnimation(this.yGB.yGA.yGh.getContext(), R.a.bpZ));
        }
    }
}
