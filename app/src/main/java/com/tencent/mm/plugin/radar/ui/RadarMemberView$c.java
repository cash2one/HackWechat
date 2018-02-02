package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import b.c.b.e;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarMemberView$c implements AnimationListener {
    final /* synthetic */ RadarMemberView pyq;

    RadarMemberView$c(RadarMemberView radarMemberView) {
        this.pyq = radarMemberView;
    }

    public final void onAnimationStart(Animation animation) {
        e.i(animation, "animation");
    }

    public final void onAnimationRepeat(Animation animation) {
        e.i(animation, "animation");
    }

    public final void onAnimationEnd(Animation animation) {
        e.i(animation, "animation");
        RadarMemberView$a radarMemberView$a = RadarMemberView.pyp;
        x.d(RadarMemberView.access$getTAG$cp(), "dismiss animation end");
        RadarMemberView.e(this.pyq);
        RadarMemberView$d d = RadarMemberView.d(this.pyq);
        RadarMemberView$a radarMemberView$a2 = RadarMemberView.pyp;
        d.sendEmptyMessage(RadarMemberView.blI());
    }
}
