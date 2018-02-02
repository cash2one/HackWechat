package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voiceprint.ui.a.5;
import com.tencent.mm.plugin.voiceprint.ui.a.a;
import com.tencent.mm.sdk.platformtools.x;

public class VoiceTipInfoView extends LinearLayout {
    TextView jJn;
    public ProgressBar lpy;
    TextView shX;
    private float siA = 0.0f;
    boolean siw = false;
    private boolean six = false;
    private TextView siy;
    private boolean siz = false;

    public VoiceTipInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.dtI, this, true);
        this.lpy = (ProgressBar) inflate.findViewById(R.h.ctq);
        bFW();
        this.jJn = (TextView) inflate.findViewById(R.h.cWE);
        this.shX = (TextView) inflate.findViewById(R.h.cWG);
        this.siy = (TextView) inflate.findViewById(R.h.cWF);
        reset();
    }

    public final void reset() {
        this.shX.setTextSize(0, getContext().getResources().getDimension(R.f.byr));
        this.siA = this.shX.getTextSize();
        this.shX.clearAnimation();
        x.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[]{Float.valueOf(this.siA)});
    }

    public final void bFV() {
        x.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
        this.lpy.setVisibility(0);
    }

    public final void bFW() {
        x.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
        this.lpy.setVisibility(8);
    }

    public final void MB(String str) {
        this.shX.setText(str);
        this.shX.setVisibility(0);
    }

    public final void ys(int i) {
        this.jJn.setText(i);
        this.jJn.setVisibility(0);
    }

    public final void bFX() {
        x.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[]{Integer.valueOf(this.jJn.getVisibility()), Boolean.valueOf(this.siw)});
        if ((this.jJn.getVisibility() == 4 || this.jJn.getVisibility() == 8) && !this.siw) {
            this.jJn.clearAnimation();
            this.siw = true;
            View view = this.jJn;
            Context context = getContext();
            a 2 = new 2(this);
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.a.bpZ);
            loadAnimation.setDuration(300);
            loadAnimation.setFillAfter(true);
            loadAnimation.setRepeatCount(0);
            loadAnimation.setAnimationListener(new a$4(2));
            view.startAnimation(loadAnimation);
            return;
        }
        x.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
        this.jJn.clearAnimation();
        this.jJn.setVisibility(0);
        this.jJn.invalidate();
    }

    public final void bFY() {
        this.shX.setVisibility(8);
    }

    public final void bFZ() {
        if (this.siy.getVisibility() != 4 || this.siz) {
            this.siy.clearAnimation();
            this.siy.setVisibility(0);
            return;
        }
        this.siy.clearAnimation();
        this.siz = true;
        View view = this.siy;
        getContext();
        a 4 = new 4(this);
        Animation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new 5(4));
        view.startAnimation(translateAnimation);
    }

    public final void bGa() {
        if (this.siy.getVisibility() != 0 || this.siz) {
            this.siy.clearAnimation();
            this.siy.setVisibility(4);
            return;
        }
        this.siy.clearAnimation();
        this.siz = true;
        a.a(this.siy, getContext(), new a(this) {
            final /* synthetic */ VoiceTipInfoView siB;

            {
                this.siB = r1;
            }

            public final void bFN() {
            }

            public final void bFO() {
                this.siB.siy.setVisibility(4);
                this.siB.siz = false;
            }
        });
    }

    public final void yt(int i) {
        this.siy.setText(i);
    }
}
