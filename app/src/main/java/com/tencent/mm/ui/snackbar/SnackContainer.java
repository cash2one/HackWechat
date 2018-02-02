package com.tencent.mm.ui.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.tencent.mm.w.a.a;
import com.tencent.mm.w.a.g;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.util.LinkedList;
import java.util.Queue;

class SnackContainer extends FrameLayout {
    private final Runnable lXq = new 3(this);
    private AnimationSet yAh;
    Queue<a> zfN = new LinkedList();
    private AnimationSet zfO;
    private float zfP;

    public SnackContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    SnackContainer(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        viewGroup.addView(this, new LayoutParams(-1, -1));
        setVisibility(8);
        setId(g.gWn);
        init();
    }

    private void init() {
        this.yAh = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.yAh.setInterpolator(new DecelerateInterpolator(DownloadHelper.SAVE_FATOR));
        this.yAh.addAnimation(translateAnimation);
        this.yAh.addAnimation(alphaAnimation);
        this.zfO = new AnimationSet(false);
        translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, 1.0f);
        alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.zfO.addAnimation(translateAnimation);
        this.zfO.addAnimation(alphaAnimation);
        this.zfO.setDuration(300);
        this.zfO.setAnimationListener(new 1(this));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.yAh.cancel();
        this.zfO.cancel();
        removeCallbacks(this.lXq);
        this.zfN.clear();
    }

    public final boolean isEmpty() {
        return this.zfN.isEmpty();
    }

    public final boolean isShowing() {
        return !this.zfN.isEmpty();
    }

    public final void hide() {
        removeCallbacks(this.lXq);
        this.lXq.run();
    }

    final void a(a aVar, boolean z) {
        setVisibility(0);
        if (aVar.zfV != null) {
            a.nm(true);
            aVar.zfV.onShow();
        }
        addView(aVar.zfS);
        aVar.zfT.setText(aVar.zfU.mMessage);
        if (aVar.zfU.zfz != null) {
            aVar.nVL.setVisibility(0);
            aVar.nVL.setText(aVar.zfU.zfz);
        } else {
            aVar.nVL.setVisibility(8);
        }
        this.yAh.setDuration(500);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.bpZ);
        loadAnimation.setDuration(500);
        startAnimation(this.yAh);
        loadAnimation.setStartOffset(200);
        aVar.nVL.startAnimation(loadAnimation);
        aVar.zfT.startAnimation(loadAnimation);
        if (aVar.zfU.zfC > (short) 0) {
            postDelayed(this.lXq, (long) aVar.zfU.zfC);
        }
        aVar.zfS.setOnTouchListener(new 2(this, aVar));
    }

    private static void a(a aVar) {
        if (aVar.zfV != null) {
            a.nm(false);
            aVar.zfV.onHide();
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if ((i == 0 && a.aHh()) || 8 == i) {
            removeAllViews();
            if (!this.zfN.isEmpty()) {
                a((a) this.zfN.poll());
            }
            if (isEmpty()) {
                setVisibility(8);
            } else {
                a((a) this.zfN.peek(), false);
            }
            a.nm(false);
        }
    }
}
