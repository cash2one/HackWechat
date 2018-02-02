package com.tencent.mm.ui.conversation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ConversationWithAppBrandListView$5 implements AnimatorUpdateListener {
    final /* synthetic */ ConversationWithAppBrandListView yYl;

    ConversationWithAppBrandListView$5(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.yYl = conversationWithAppBrandListView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
        float floatValue2 = ((Float) valueAnimator.getAnimatedValue("headerDeltaY")).floatValue();
        for (int i = 0; i < this.yYl.getChildCount(); i++) {
            if (i == 0) {
                this.yYl.getChildAt(i).setTranslationY(floatValue2);
            } else {
                this.yYl.getChildAt(i).setTranslationY(floatValue);
            }
            ConversationWithAppBrandListView.a(this.yYl, floatValue);
        }
        this.yYl.invalidate();
    }
}
