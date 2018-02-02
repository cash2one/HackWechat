package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class AbstractVideoView$7 implements OnClickListener {
    final /* synthetic */ AbstractVideoView vjf;

    AbstractVideoView$7(AbstractVideoView abstractVideoView) {
        this.vjf = abstractVideoView;
    }

    public final void onClick(View view) {
        x.i(this.vjf.TAG, "%s seek bar play button on click ", new Object[]{this.vjf.asN()});
        AbstractVideoView abstractVideoView = this.vjf;
        if (abstractVideoView.kTe != null) {
            if (abstractVideoView.isPlaying()) {
                abstractVideoView.pause();
            } else if (bh.ov(abstractVideoView.kTe.Ur())) {
                abstractVideoView.start();
            } else {
                abstractVideoView.play();
            }
        }
    }
}
