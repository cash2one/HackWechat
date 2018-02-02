package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b;
import b.c;
import b.c.b.e;
import b.c.b.i;
import b.c.b.j;
import b.e.d;
import com.tencent.mm.plugin.radar.a$c;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarTipsView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] pxT = new d[]{j.a(new i(j.R(RadarTipsView.class), "tipsFadeIn", "getTipsFadeIn()Landroid/view/animation/Animation;")), j.a(new i(j.R(RadarTipsView.class), "tipsFadeOut", "getTipsFadeOut()Landroid/view/animation/Animation;")), j.a(new i(j.R(RadarTipsView.class), "tvTextTips", "getTvTextTips()Landroid/widget/TextView;")), j.a(new i(j.R(RadarTipsView.class), "textTipsContainer", "getTextTipsContainer()Landroid/view/View;")), j.a(new i(j.R(RadarTipsView.class), "noviceEducationTips", "getNoviceEducationTips()Landroid/widget/LinearLayout;"))};
    private static final int pzu = 3;
    private static final int pzv = 0;
    static final int pzw = 1;
    static final int pzx = 2;
    private static final int pzy = 3;
    public static final a pzz = new a((byte) 0);
    private final b pza = new b(this);
    private final b pzb = c.b(new d(this));
    private final b pzc = c.b(new e(this));
    private final b pzd = i.C(this, a$c.pvU);
    private final b pze = i.C(this, a$c.pvS);
    private final b pzf = i.C(this, a$c.pvV);
    private final int pzg;
    final int pzh = 1;
    final int pzi = 2;
    private final int pzj = 3;
    private final int pzk = 3;
    final f pzl = new f(this, Looper.getMainLooper());
    boolean pzm;
    private boolean pzn = true;
    boolean pzo;
    boolean pzp;
    int pzq;
    long pzr;
    boolean pzs;
    int pzt = pzv;

    private final Animation blS() {
        return (Animation) this.pzc.getValue();
    }

    final Animation blR() {
        return (Animation) this.pzb.getValue();
    }

    final View blT() {
        return (View) this.pze.getValue();
    }

    final LinearLayout blU() {
        return (LinearLayout) this.pzf.getValue();
    }

    public RadarTipsView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarTipsView(Context context, AttributeSet attributeSet, int i) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    public static /* synthetic */ void a(RadarTipsView radarTipsView, int i) {
        String string = radarTipsView.getContext().getString(i);
        e.h(string, "context.getString(res)");
        radarTipsView.bV(string, -1);
    }

    private void bV(String str, int i) {
        e.i(str, "msg");
        this.pzm = true;
        blU().setVisibility(8);
        blU().clearAnimation();
        ((TextView) this.pzd.getValue()).setText(str);
        setVisibility(0);
        blT().setVisibility(0);
        blT().startAnimation(blR());
        this.pzl.removeMessages(this.pzg);
        this.pzl.removeMessages(this.pzi);
        if (i > 0) {
            this.pzl.sendEmptyMessageDelayed(this.pzg, (long) i);
        }
    }

    public final void Ib(String str) {
        e.i(str, "msg");
        this.pzt = pzy;
        bV(str, 5000);
    }

    public final void blV() {
        this.pzm = false;
        this.pzt = pzv;
        x.d(TAG, "hidNoviceEducation");
        this.pzl.removeMessages(this.pzj);
        if (getVisibility() == 0 && blU().getVisibility() == 0) {
            blU().clearAnimation();
            if (blT().getAnimation() == blS()) {
                blT().clearAnimation();
            }
            x.d(TAG, "hideNoviceEducation real");
            blU().startAnimation(blS());
        }
    }

    public final void hv(boolean z) {
        this.pzn = z;
        if (!this.pzn) {
            blW();
            blX();
            blV();
        }
    }

    public final void blW() {
        x.d(TAG, "hideRadarTips");
        if (getVisibility() == 0 && blT().getVisibility() == 0) {
            if (blU().getAnimation() == blS()) {
                blU().clearAnimation();
            }
            blT().clearAnimation();
            x.d(TAG, "hideRadarTips real");
            this.pzt = pzv;
            this.pzm = false;
            blT().startAnimation(blS());
        }
    }

    public final void blX() {
        this.pzm = false;
        f fVar = this.pzl;
        fVar.removeMessages(this.pzh);
        fVar.removeMessages(this.pzi);
        fVar.removeMessages(this.pzj);
    }
}
