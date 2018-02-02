package com.tencent.mm.plugin.appbrand.widget.c;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.q.a;
import java.util.LinkedList;

public final class e extends FrameLayout implements i {
    public final g jWu = new g(this);
    public final LinkedList<h> jWv = new LinkedList();
    private final Runnable jWw = new 2(this);
    private h jWx;
    public h jWy;
    public final OnClickListener mOnClickListener = new 1(this);

    static /* synthetic */ void a(e eVar) {
        h hVar = (h) eVar.jWv.peekLast();
        if (hVar == null) {
            eVar.setVisibility(8);
        } else if (hVar.amt()) {
            hVar.onCancel();
            eVar.b(hVar);
        }
    }

    public e(Context context) {
        super(context);
        setVisibility(4);
        setBackgroundColor(0);
        setOnClickListener(this.mOnClickListener);
    }

    public final void b(h hVar) {
        if (hVar.getContentView().getParent() == this && this.jWx != hVar) {
            this.jWx = hVar;
            View contentView = hVar.getContentView();
            contentView.animate().cancel();
            contentView.clearAnimation();
            TimeInterpolator loadInterpolator = AnimationUtils.loadInterpolator(contentView.getContext(), a.isu);
            TimeInterpolator loadInterpolator2 = AnimationUtils.loadInterpolator(contentView.getContext(), a.ist);
            Animator animatorSet = new AnimatorSet();
            r4 = new Animator[3];
            Animator duration = ObjectAnimator.ofFloat(contentView, "scaleX", new float[]{1.0f, 0.9f}).setDuration(220);
            duration.setInterpolator(loadInterpolator);
            r4[0] = duration;
            duration = ObjectAnimator.ofFloat(contentView, "scaleY", new float[]{1.0f, 0.9f}).setDuration(220);
            duration.setInterpolator(loadInterpolator);
            r4[1] = duration;
            Animator duration2 = ObjectAnimator.ofFloat(contentView, "alpha", new float[]{1.0f, 0.0f}).setDuration(150);
            duration2.setInterpolator(loadInterpolator2);
            r4[2] = duration2;
            animatorSet.playTogether(r4);
            animatorSet.addListener(new 3(this, contentView, hVar));
            animatorSet.start();
            if (this.jWv.size() <= 1) {
                this.jWu.b(0, this.jWw);
            }
        }
    }

    public static void bQ(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() == 0) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
