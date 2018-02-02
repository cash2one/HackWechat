package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import b.b;
import b.c;
import b.c.b.e;
import b.c.b.i;
import b.c.b.j;
import b.e.d;
import com.tencent.mm.plugin.radar.a$e;
import com.tencent.mm.plugin.radar.b.e.a;

public final class RadarStateChooseView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] pxT = new d[]{j.a(new i(j.R(RadarStateChooseView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), j.a(new i(j.R(RadarStateChooseView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;"))};
    public static final a pyP = new a((byte) 0);
    boolean pyK;
    final b pyL = c.b(new c(this));
    final b pyM = c.b(new b(this));
    boolean pyN = true;
    a pyO = a.pxv;

    public RadarStateChooseView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarStateChooseView(Context context, AttributeSet attributeSet, int i) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    final void blN() {
        switch (e.pxK[this.pyO.ordinal()]) {
            case 1:
                setVisibility(4);
                return;
            case 2:
                setBackgroundResource(a$e.pwg);
                setVisibility(0);
                return;
            default:
                setVisibility(4);
                return;
        }
    }
}
