package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.q.h;

public final class r extends q {
    a jEI;
    b jEJ;
    private boolean jEK;
    private LinearLayout jEL;
    TextView jEM;
    private View jEN;
    ImageView jEO;
    ImageView jEP;
    ImageView jEQ;
    private long jER;

    public r(Context context, t tVar) {
        super(context);
        this.jEK = false;
        this.jER = 0;
        tVar.zvH = this;
        tVar.cyW();
        this.jEL = (LinearLayout) LayoutInflater.from(getContext()).inflate(h.ixg, this, false);
        View view = this.jEL;
        this.jEv = view;
        this.jEw = new FrameLayout(getContext());
        this.jEw.setLayoutParams(new LayoutParams(-1, -1));
        this.jEw.addView(view);
        this.Iv = tVar;
        this.jEx = new FrameLayout(getContext());
        this.jEx.setLayoutParams(new LayoutParams(-1, -1));
        this.jEx.addView(tVar);
        addView(this.jEw);
        addView(this.jEx);
        this.jEM = (TextView) findViewById(q$g.iuG);
        this.jEN = findViewById(q$g.iuC);
        this.jEO = (ImageView) findViewById(q$g.iuD);
        this.jEP = (ImageView) findViewById(q$g.iuE);
        this.jEQ = (ImageView) findViewById(q$g.iuF);
    }

    protected final void ajh() {
        ((AnimationDrawable) this.jEO.getDrawable()).start();
        ((AnimationDrawable) this.jEP.getDrawable()).start();
        ((AnimationDrawable) this.jEQ.getDrawable()).start();
        if (this.jEI != null) {
            this.jEI.ajd();
        }
        this.jER = System.currentTimeMillis();
    }

    protected final void aji() {
        ajm();
    }

    protected final void lg(int i) {
        if (this.jEJ != null) {
            this.jEJ.lf(i);
        }
        if (this.jEK) {
            if (i > this.jEL.getHeight()) {
                i = this.jEL.getHeight();
            }
            this.jEL.setTranslationY((float) (i - this.jEL.getHeight()));
        }
    }

    public final void ajl() {
        long currentTimeMillis = System.currentTimeMillis() - this.jER;
        if (currentTimeMillis < 1000) {
            postDelayed(new 1(this), 1000 - currentTimeMillis);
        } else {
            ajg();
        }
    }

    protected final int ajk() {
        return this.jEL.getHeight();
    }

    public final void cC(boolean z) {
        this.jEK = z;
        this.jEz = z;
        this.jEN.setVisibility(z ? 0 : 4);
    }

    public final void ajm() {
        ((AnimationDrawable) this.jEO.getDrawable()).stop();
        ((AnimationDrawable) this.jEO.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.jEP.getDrawable()).stop();
        ((AnimationDrawable) this.jEP.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.jEQ.getDrawable()).stop();
        ((AnimationDrawable) this.jEQ.getDrawable()).selectDrawable(0);
    }

    static AnimationDrawable d(int i, float[] fArr) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(g(i, fArr[0]), 0);
        animationDrawable.addFrame(g(i, fArr[1]), 300);
        animationDrawable.addFrame(g(i, fArr[2]), 300);
        animationDrawable.addFrame(g(i, fArr[3]), 300);
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
