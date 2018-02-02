package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import b.c.b.e;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarWaveView extends RelativeLayout {
    static final String TAG = TAG;
    public static final a pAu = new a((byte) 0);
    MediaPlayer pAr;
    View pAs;
    Animation pAt;

    public RadarWaveView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public final void bmk() {
        x.d(TAG, "start wave animation");
        setVisibility(0);
        View view = this.pAs;
        if (view == null) {
            e.cJy();
        }
        view.startAnimation(this.pAt);
    }

    public final void bml() {
        x.d(TAG, "stop wave animation. forces, %d, %d", Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()));
        setVisibility(4);
        View view = this.pAs;
        if (view == null) {
            e.cJy();
        }
        view.clearAnimation();
    }
}
