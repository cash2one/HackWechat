package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

@SuppressLint({"HandlerLeak"})
public class ThrowBottleAnimUI extends FrameLayout {
    int Rn;
    int Ro;
    BottleBeachUI kCH;
    private SprayLayout kDJ;
    private BottleImageView kDK;
    private TextView kDL;
    private AnimationSet kDM;
    private int kDN;
    private int kDO;
    private int kDP;
    private int kDQ;
    int kDR;
    a kDS;
    boolean kDT;
    private af kDU = new 4(this);

    static /* synthetic */ void f(ThrowBottleAnimUI throwBottleAnimUI) {
        float f;
        int i;
        throwBottleAnimUI.kDL.setVisibility(0);
        if (throwBottleAnimUI.kDT) {
            throwBottleAnimUI.kDL.setBackgroundDrawable(a.b(throwBottleAnimUI.kCH, R.g.bEX));
            throwBottleAnimUI.kDL.setWidth(throwBottleAnimUI.kDR);
            f = 1.0f;
            i = 120;
        } else {
            throwBottleAnimUI.kDL.setBackgroundDrawable(a.b(throwBottleAnimUI.kCH, R.g.bzV));
            f = 0.5f;
            i = 25;
        }
        throwBottleAnimUI.kDM = new AnimationSet(true);
        throwBottleAnimUI.kDM.setInterpolator(throwBottleAnimUI.kCH, 17432582);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.0f, 1, 0.0f);
        scaleAnimation.setDuration(700);
        Animation rotateAnimation = new RotateAnimation(0.0f, (float) i, 1, f, 1, 1.0f);
        rotateAnimation.setDuration(700);
        int intrinsicWidth = throwBottleAnimUI.kDK.getBackground().getIntrinsicWidth() / 2;
        int intrinsicHeight = throwBottleAnimUI.kDK.getBackground().getIntrinsicHeight() / 2;
        int b = b.b(throwBottleAnimUI.kCH, 40.0f);
        x.v("MicroMsg.ThrowBottleAnimView", "tran from (" + throwBottleAnimUI.Rn + "," + throwBottleAnimUI.Ro + ") to (" + ((throwBottleAnimUI.arX() - b) - intrinsicWidth) + " , " + ((throwBottleAnimUI.arY() - b) - intrinsicHeight));
        Animation translateAnimation = new TranslateAnimation((float) throwBottleAnimUI.Rn, (float) ((throwBottleAnimUI.arX() - b) - intrinsicWidth), (float) throwBottleAnimUI.Ro, (float) ((throwBottleAnimUI.arY() - b) - intrinsicHeight));
        translateAnimation.setDuration(700);
        throwBottleAnimUI.kDM.addAnimation(rotateAnimation);
        throwBottleAnimUI.kDM.addAnimation(scaleAnimation);
        throwBottleAnimUI.kDM.addAnimation(translateAnimation);
        throwBottleAnimUI.kDM.setAnimationListener(new 2(throwBottleAnimUI));
    }

    public ThrowBottleAnimUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kCH = (BottleBeachUI) context;
        initView();
    }

    public ThrowBottleAnimUI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kCH = (BottleBeachUI) context;
        initView();
    }

    public final void release() {
        this.kCH = null;
        this.kDM = null;
        this.kDJ = null;
        if (this.kDK != null) {
            BottleImageView bottleImageView = this.kDK;
            bottleImageView.context = null;
            bottleImageView.kBZ = null;
        }
        this.kDK = null;
        this.kDS = null;
    }

    public boolean isInEditMode() {
        return false;
    }

    private void initView() {
        inflate(this.kCH, R.i.dby, this);
        this.kDK = (BottleImageView) findViewById(R.h.bOG);
        this.kDL = (TextView) findViewById(R.h.bOJ);
        DisplayMetrics displayMetrics = this.kCH.getResources().getDisplayMetrics();
        this.kDP = displayMetrics.widthPixels;
        this.kDQ = displayMetrics.heightPixels;
    }

    private int arX() {
        int abs = Math.abs(getWidth());
        if (abs <= 0) {
            return this.kDP;
        }
        return abs;
    }

    private int arY() {
        int abs = Math.abs(getHeight());
        if (abs <= 0) {
            return this.kDQ;
        }
        return abs;
    }

    final void arZ() {
        this.kDK.setImageDrawable(null);
        int intrinsicWidth = this.kDK.getBackground().getIntrinsicWidth();
        int intrinsicHeight = this.kDK.getBackground().getIntrinsicHeight();
        this.kDK.setVisibility(0);
        int b = b.b(this.kCH, 40.0f);
        this.kDK.setLayoutParams(new LayoutParams(-2, -2, arX() - (intrinsicWidth + b), arY() - (intrinsicHeight + b)));
    }

    final void asa() {
        int intrinsicWidth = this.kDK.getBackground().getIntrinsicWidth();
        int intrinsicHeight = this.kDK.getBackground().getIntrinsicHeight();
        this.kDK.setVisibility(0);
        int b = b.b(this.kCH, 40.0f);
        setBackgroundDrawable(a.b(this.kCH, bh.cgq() ? R.g.bzP : R.g.bzQ));
        if (this.kDT) {
            this.kDK.setImageDrawable(a.b(this.kCH, R.g.bzX));
        } else {
            this.kDK.setImageDrawable(a.b(this.kCH, R.g.bzW));
        }
        this.kDK.setLayoutParams(new LayoutParams(-2, -2, 0, 0));
        BottleImageView bottleImageView = this.kDK;
        int arX = arX() - (intrinsicWidth + b);
        intrinsicWidth = this.kDN - (intrinsicWidth / 2);
        b = arY() - (b + intrinsicHeight);
        intrinsicHeight = this.kDO - (intrinsicHeight / 2);
        AnimationListener 3 = new 3(this);
        bottleImageView.Rn = arX;
        bottleImageView.Rp = intrinsicWidth;
        bottleImageView.Ro = b;
        bottleImageView.Rq = intrinsicHeight;
        bottleImageView.kBZ.setAnimationListener(3);
        bottleImageView.kBZ.setDuration(2000);
        bottleImageView.kBZ.setRepeatCount(0);
        bottleImageView.kBZ.setStartOffset(500);
        bottleImageView.kBZ.setInterpolator(bottleImageView.context, 17432582);
        bottleImageView.startAnimation(bottleImageView.kBZ);
    }

    final void asb() {
        this.kDN = arX() / 2;
        this.kDO = (arY() * 460) / 800;
        x.v("MicroMsg.ThrowBottleAnimView", "to (" + this.kDN + "," + this.kDO + ")  bottle (" + this.kDK.getDrawable().getIntrinsicWidth() + "," + this.kDK.getDrawable().getIntrinsicHeight() + ")");
    }
}
