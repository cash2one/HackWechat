package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.bv.a;

public final class AppBrandNearbyShowcaseView extends FrameLayout {
    private int dY = a.fromDPToPix(getContext(), 25);
    private int jUt = a.fromDPToPix(getContext(), 19);

    public AppBrandNearbyShowcaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandNearbyShowcaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void lN(int i) {
        if (i > 0 && i != this.dY) {
            this.dY = i;
            amd();
        }
    }

    public final void lO(int i) {
        if (i >= 0 && this.jUt != i) {
            this.jUt = i;
            amd();
        }
    }

    private void amd() {
        if (getChildCount() > 0) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                LayoutParams layoutParams = childAt.getLayoutParams();
                LayoutParams layoutParams2 = childAt.getLayoutParams();
                int i = this.dY;
                layoutParams2.height = i;
                layoutParams.width = i;
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams3.gravity |= 5;
                ((FrameLayout.LayoutParams) childAt.getLayoutParams()).rightMargin = this.jUt * childCount;
            }
            requestLayout();
            invalidate();
        }
    }

    public final void lP(int i) {
        if (i >= 0 && i != getChildCount()) {
            if (i > getChildCount()) {
                int childCount = i - getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View imageView = new ImageView(getContext());
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dY, this.dY);
                    layoutParams.gravity = 16;
                    addViewInLayout(imageView, 0, layoutParams, true);
                }
            } else if (i < getChildCount()) {
                removeViewsInLayout(0, getChildCount() - i);
            }
            amd();
        }
    }

    public final ImageView lQ(int i) {
        return (ImageView) getChildAt((getChildCount() - 1) - i);
    }

    public final void ame() {
        if (getChildCount() > 1) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                childAt.setTranslationX((float) ((FrameLayout.LayoutParams) childAt.getLayoutParams()).rightMargin);
            }
        }
    }

    public final void amf() {
        int i = 1;
        if (getChildCount() > 1) {
            int i2 = 200;
            while (i < getChildCount()) {
                getChildAt(i).animate().setDuration((long) i2).translationX(0.0f).start();
                i2 += 50;
                i++;
            }
        }
    }
}
