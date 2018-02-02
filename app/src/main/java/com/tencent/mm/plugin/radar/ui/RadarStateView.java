package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import b.b;
import b.c;
import b.c.b.i;
import b.c.b.j;
import b.e.d;
import com.tencent.mm.plugin.radar.a;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarStateView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] pxT = new d[]{j.a(new i(j.R(RadarStateView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), j.a(new i(j.R(RadarStateView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;"))};
    private static final int pyW = 300;
    public static final a pyX = new a((byte) 0);
    e pxy = e.pwH;
    boolean pyK;
    private final b pyL = c.b(new c(this));
    private final b pyM = c.b(new b(this));
    boolean pyT = true;
    final d pyU = new d(this);
    private ImageView pyV;

    public RadarStateView(Context context, AttributeSet attributeSet) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarStateView(Context context, AttributeSet attributeSet, int i) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    final void blN() {
        x.d(TAG, " state : " + this.pxy);
        if (this.pyT) {
            ImageView imageView;
            switch (f.pxK[this.pxy.ordinal()]) {
                case 1:
                    setVisibility(8);
                    return;
                case 2:
                    setBackgroundResource(a.e.pwb);
                    imageView = this.pyV;
                    if (imageView == null) {
                        b.c.b.e.cJy();
                    }
                    imageView.setImageResource(a.e.pwf);
                    setVisibility(0);
                    return;
                case 3:
                    setBackgroundResource(a.e.pwc);
                    imageView = this.pyV;
                    if (imageView == null) {
                        b.c.b.e.cJy();
                    }
                    imageView.setImageResource(a.e.pwe);
                    setVisibility(0);
                    return;
                case 4:
                    setBackgroundResource(a.e.pwc);
                    imageView = this.pyV;
                    if (imageView == null) {
                        b.c.b.e.cJy();
                    }
                    imageView.setImageResource(a.e.pwd);
                    setVisibility(0);
                    return;
                default:
                    return;
            }
        }
        setVisibility(8);
    }

    final void init() {
        if (this.pyV == null) {
            this.pyV = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMargins(0, 0, com.tencent.mm.bv.a.fromDPToPix(getContext(), 5), com.tencent.mm.bv.a.fromDPToPix(getContext(), 2));
            ImageView imageView = this.pyV;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            addView(this.pyV);
        }
    }

    public final void blO() {
        if (this.pyT) {
            init();
            blN();
            this.pyK = true;
            startAnimation((Animation) this.pyL.getValue());
        }
    }

    public final void blP() {
        if (this.pyT) {
            init();
            blN();
            startAnimation((Animation) this.pyM.getValue());
        }
    }
}
