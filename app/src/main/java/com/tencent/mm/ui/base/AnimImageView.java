package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;

public class AnimImageView extends TextView {
    private boolean bgH = false;
    private Context context;
    private AlphaAnimation pGA;
    private AnimationDrawable pGB;
    private int type = 1;
    public boolean xXq = false;
    private AnimationDrawable xXr;

    public final void setType(int i) {
        this.type = i;
        if (this.xXq) {
            if (i == 2) {
                setBackgroundResource(R.e.brD);
            } else {
                setBackgroundDrawable(a.b(this.context, R.g.bAR));
            }
        } else if (i == 2) {
            setBackgroundResource(R.e.brE);
        } else {
            setBackgroundDrawable(a.b(this.context, R.g.bBt));
        }
    }

    public final void coI() {
        switch (this.type) {
            case 0:
                if (this.xXq) {
                    setBackgroundDrawable(a.b(this.context, R.g.bAR));
                } else {
                    setBackgroundDrawable(a.b(this.context, R.g.bBt));
                }
                setAnimation(this.pGA);
                this.pGA.startNow();
                return;
            case 1:
                break;
            case 2:
                if (!this.xXq) {
                    setBackgroundResource(R.e.brE);
                    break;
                } else {
                    setBackgroundResource(R.e.brD);
                    break;
                }
            default:
                return;
        }
        if (!this.bgH) {
            this.bgH = true;
            if (this.xXq) {
                setCompoundDrawablesWithIntrinsicBounds(this.pGB, null, null, null);
                this.pGB.stop();
                this.pGB.start();
                return;
            }
            setCompoundDrawablesWithIntrinsicBounds(null, null, this.xXr, null);
            this.xXr.stop();
            this.xXr.start();
        }
    }

    public final void bnk() {
        if (this.pGA != null && this.pGA.isInitialized()) {
            setAnimation(null);
        }
        if (this.type == 1 || this.type == 2) {
            this.bgH = false;
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            this.pGB.stop();
            this.xXr.stop();
        }
    }

    public AnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bnj();
    }

    public AnimImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        bnj();
    }

    private void bnj() {
        this.pGA = new AlphaAnimation(0.1f, 1.0f);
        this.pGA.setDuration(1000);
        this.pGA.setRepeatCount(-1);
        this.pGA.setRepeatMode(2);
        this.pGB = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(R.k.dxr);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pGB.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxs);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pGB.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxt);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.pGB.addFrame(drawable, 300);
        this.pGB.setOneShot(false);
        this.pGB.setVisible(true, true);
        this.xXr = new AnimationDrawable();
        drawable = getResources().getDrawable(R.k.dxL);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.xXr.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxM);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.xXr.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.dxN);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.xXr.addFrame(drawable, 300);
        this.xXr.setOneShot(false);
        this.xXr.setVisible(true, true);
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
