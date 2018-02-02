package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;
import java.util.Random;

public class SprayLayout extends FrameLayout {
    private af handler;
    AnimationSet kDA;
    private int kDB;
    private int kDC;
    private int kDD;
    private int kDE;
    private int kDF;
    private int kDG;
    private Runnable kDH;
    private ImageView kDq;
    private ImageView kDr;
    private ImageView kDs;
    Animation kDt;
    Animation kDu;
    Animation kDv;
    Animation kDw;
    Animation kDx;
    AnimationSet kDy;
    AnimationSet kDz;
    private int repeatCount;

    static /* synthetic */ void d(SprayLayout sprayLayout) {
        int i = -1;
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sprayLayout.getLayoutParams();
        FrameLayout frameLayout = (FrameLayout) sprayLayout.getParent();
        if (marginLayoutParams != null && frameLayout != null) {
            if (sprayLayout.kDD == -1 && sprayLayout.kDE == -1) {
                Random random = new Random();
                int nextInt = (random.nextBoolean() ? 1 : -1) * random.nextInt(sprayLayout.kDF);
                int sqrt = (int) Math.sqrt((double) (((((sprayLayout.kDF * sprayLayout.kDF) - (nextInt * nextInt)) * sprayLayout.kDG) * sprayLayout.kDG) / (sprayLayout.kDF * sprayLayout.kDF)));
                if (random.nextBoolean()) {
                    i = 1;
                }
                marginLayoutParams.setMargins(nextInt, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, ((frameLayout.getHeight() * 300) / 800) + (random.nextInt(Math.max(sqrt, 1)) * i));
            } else {
                marginLayoutParams.setMargins(sprayLayout.kDD - (frameLayout.getWidth() / 2), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, frameLayout.getHeight() - sprayLayout.kDE);
            }
            sprayLayout.setLayoutParams(marginLayoutParams);
        }
    }

    static /* synthetic */ int k(SprayLayout sprayLayout) {
        int i = sprayLayout.kDB + 1;
        sprayLayout.kDB = i;
        return i;
    }

    public SprayLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SprayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kDt = new ScaleAnimation(0.6f, 0.8f, 0.6f, 0.8f, 1, 0.5f, 1, 1.0f);
        this.kDu = new AlphaAnimation(0.2f, 1.0f);
        this.kDv = new ScaleAnimation(0.8f, 1.27f, 0.8f, 1.27f, 1, 0.5f, 1, 1.0f);
        this.kDw = new AlphaAnimation(1.0f, 0.5f);
        this.kDx = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 1.0f);
        this.kDy = new AnimationSet(true);
        this.kDz = new AnimationSet(true);
        this.kDA = new AnimationSet(true);
        this.kDt.setDuration(280);
        this.kDu.setDuration(280);
        this.kDv.setDuration(280);
        this.kDw.setDuration(280);
        this.kDy.addAnimation(this.kDt);
        this.kDy.addAnimation(this.kDu);
        this.kDy.setRepeatCount(1);
        this.kDy.setDuration(280);
        this.kDz.addAnimation(this.kDv);
        this.kDz.setRepeatCount(1);
        this.kDz.setDuration(280);
        this.kDA.addAnimation(this.kDx);
        this.kDA.setRepeatCount(1);
        this.kDA.setDuration(280);
        this.kDB = 0;
        this.repeatCount = 1;
        this.kDD = -1;
        this.kDE = -1;
        this.handler = new af();
        this.kDH = new 1(this);
    }

    public final void G(int i, int i2, int i3) {
        this.kDB = 0;
        this.repeatCount = i;
        this.kDC = 0;
        this.kDD = i2;
        this.kDE = i3;
        if (this.kDq == null) {
            this.kDq = (ImageView) findViewById(R.h.bOA);
            this.kDr = (ImageView) findViewById(R.h.bOC);
            this.kDs = (ImageView) findViewById(R.h.bOB);
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            this.kDF = (displayMetrics.widthPixels * 35) / 96;
            this.kDG = displayMetrics.heightPixels / 16;
        }
        this.kDq.setVisibility(8);
        this.kDr.setVisibility(8);
        this.kDs.setVisibility(8);
        setVisibility(0);
        this.handler.removeCallbacks(this.kDH);
        this.handler.postDelayed(this.kDH, 0);
    }

    public final void stop() {
        this.handler.removeCallbacks(this.kDH);
        setVisibility(8);
    }
}
