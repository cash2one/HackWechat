package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.x;

public class FaceScanRect extends RelativeLayout {
    public TranslateAnimation mnA;
    public b mnB;
    public ViewGroup mnC;
    public View mnD;
    public int mnE;
    public View mnm;
    private ImageView mnn;
    private ImageView mno;
    private ImageView mnp;
    private ImageView mnq;
    private ImageView mnr;
    private ImageView mns;
    private ImageView mnt;
    private ImageView mnu;
    public ImageView[] mnv;
    private ScaleAnimation mnw;
    private ScaleAnimation mnx;
    private ScaleAnimation mny;
    private ScaleAnimation mnz;

    public FaceScanRect(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceScanRect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mnm = null;
        this.mnn = null;
        this.mno = null;
        this.mnp = null;
        this.mnq = null;
        this.mnr = null;
        this.mns = null;
        this.mnt = null;
        this.mnu = null;
        this.mnv = null;
        this.mnw = null;
        this.mnx = null;
        this.mny = null;
        this.mnz = null;
        this.mnA = null;
        this.mnB = null;
        this.mnC = null;
        this.mnD = null;
        LayoutInflater.from(context).inflate(g.mdL, this, true);
        this.mnm = findViewById(e.mdn);
        this.mnn = (ImageView) findViewById(e.mdl);
        this.mno = (ImageView) findViewById(e.mdm);
        this.mnp = (ImageView) findViewById(e.mdi);
        this.mnq = (ImageView) findViewById(e.mdh);
        this.mnr = (ImageView) findViewById(e.mdk);
        this.mns = (ImageView) findViewById(e.mdj);
        this.mnt = (ImageView) findViewById(e.mdf);
        this.mnu = (ImageView) findViewById(e.mdg);
        this.mnD = findViewById(e.mcW);
        this.mnC = (ViewGroup) findViewById(e.mcT);
        this.mnv = new ImageView[]{this.mnn, this.mno, this.mnp, this.mnq, this.mnr, this.mns, this.mnt, this.mnu};
        this.mnE = a.mnH;
        this.mnA = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        this.mnA.setRepeatCount(-1);
        this.mnA.setRepeatMode(1);
        this.mnA.setDuration(1000);
    }

    public final void b(AnimationListener animationListener) {
        if (this.mnE == a.mnG) {
            x.w("MicroMsg.FaceScanRect", "hy: already closed");
            if (animationListener != null) {
                animationListener.onAnimationEnd(null);
                return;
            }
            return;
        }
        this.mnE = a.mnG;
        int width = getWidth();
        int height = getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(c.mcz);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c.mcA);
        float f = ((float) (((width - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        float f2 = ((float) (((height - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        x.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
        this.mnw = new ScaleAnimation(1.0f, f, 1.0f, 1.0f, 1, 0.0f, 1, 0.0f);
        this.mnw.setFillAfter(true);
        this.mnw.setDuration(1500);
        this.mnw.setInterpolator(getContext(), 17563654);
        this.mnw.setAnimationListener(animationListener);
        this.mnx = new ScaleAnimation(1.0f, f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.mnx.setFillAfter(true);
        this.mnx.setDuration(1500);
        this.mnx.setInterpolator(getContext(), 17563654);
        this.mny = new ScaleAnimation(1.0f, 1.0f, 1.0f, f2, 1, 0.0f, 1, 0.0f);
        this.mny.setFillAfter(true);
        this.mny.setDuration(1500);
        this.mny.setInterpolator(getContext(), 17563654);
        this.mnz = new ScaleAnimation(1.0f, 1.0f, 1.0f, f2, 1, 0.0f, 1, 1.0f);
        this.mnz.setFillAfter(true);
        this.mnz.setDuration(1500);
        this.mnz.setInterpolator(getContext(), 17563654);
        this.mnn.startAnimation(this.mnw);
        this.mnq.startAnimation(this.mnz);
        this.mnr.startAnimation(this.mny);
        this.mnu.startAnimation(this.mnx);
        this.mnD.setVisibility(8);
        this.mnm.setBackground(null);
        this.mnD.clearAnimation();
        for (ImageView backgroundColor : this.mnv) {
            backgroundColor.setBackgroundColor(getResources().getColor(b.mcv));
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mnB != null) {
            this.mnB.aHq();
        }
    }
}
