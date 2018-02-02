package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;
import com.tencent.smtt.sdk.WebView;

public class ThreeDotsLoadingView extends FrameLayout {
    private boolean AV = false;
    private int zwI = WebView.NIGHT_MODE_COLOR;
    private boolean zwJ = false;
    private ViewGroup zwK;
    private ImageView zwL;
    private ImageView zwM;
    private ImageView zwN;
    private final Runnable zwO = new Runnable(this) {
        final /* synthetic */ ThreeDotsLoadingView zwP;

        {
            this.zwP = r1;
        }

        public final void run() {
            ThreeDotsLoadingView.a(this.zwP);
            ((AnimationDrawable) this.zwP.zwL.getDrawable()).start();
            ((AnimationDrawable) this.zwP.zwM.getDrawable()).start();
            ((AnimationDrawable) this.zwP.zwN.getDrawable()).start();
        }
    };

    static /* synthetic */ void a(ThreeDotsLoadingView threeDotsLoadingView) {
        threeDotsLoadingView.zwL.setImageDrawable(d(threeDotsLoadingView.zwI, new float[]{0.4f, 0.3f, 0.5f}));
        threeDotsLoadingView.zwM.setImageDrawable(d(threeDotsLoadingView.zwI, new float[]{0.5f, 0.4f, 0.3f}));
        threeDotsLoadingView.zwN.setImageDrawable(d(threeDotsLoadingView.zwI, new float[]{0.3f, 0.5f, 0.4f}));
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.zwK = (ViewGroup) LayoutInflater.from(context).inflate(h.gXm, this, true);
        this.zwL = (ImageView) this.zwK.findViewById(g.gVF);
        this.zwM = (ImageView) this.zwK.findViewById(g.gVG);
        this.zwN = (ImageView) this.zwK.findViewById(g.gVH);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.faV);
            this.zwI = obtainStyledAttributes.getColor(m.gZD, WebView.NIGHT_MODE_COLOR);
            obtainStyledAttributes.recycle();
        }
        czf();
    }

    public void setVisibility(int i) {
        if (8 == i || 4 == i) {
            ajm();
        }
        super.setVisibility(i);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.zwJ) {
            this.zwJ = false;
            cze();
        }
    }

    public void setAlpha(float f) {
        this.zwL.setAlpha(f);
        this.zwM.setAlpha(f);
        this.zwN.setAlpha(f);
        if (getBackground() != null) {
            getBackground().setAlpha(Math.round(255.0f * f));
        }
    }

    public final void cze() {
        if (!z.ak(this)) {
            this.zwJ = true;
        } else if (!this.AV) {
            this.AV = true;
            czf();
            postDelayed(this.zwO, 300);
        }
    }

    public final void ajm() {
        this.zwJ = false;
        if (this.AV) {
            this.AV = false;
            removeCallbacks(this.zwO);
            if (this.zwL.getDrawable() instanceof AnimationDrawable) {
                ((AnimationDrawable) this.zwL.getDrawable()).stop();
                ((AnimationDrawable) this.zwM.getDrawable()).stop();
                ((AnimationDrawable) this.zwN.getDrawable()).stop();
            }
        }
    }

    private void czf() {
        this.zwL.setImageDrawable(g(this.zwI, 0.5f));
        this.zwM.setImageDrawable(g(this.zwI, 0.4f));
        this.zwN.setImageDrawable(g(this.zwI, 0.3f));
    }

    private static AnimationDrawable d(int i, float[] fArr) {
        int i2 = 0;
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        while (i2 < 3) {
            animationDrawable.addFrame(g(i, fArr[i2]), 300);
            i2++;
        }
        return animationDrawable;
    }

    private static Drawable g(int i, float f) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        return shapeDrawable;
    }
}
