package com.tencent.mm.ui.conversation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ConversationWithAppBrandListView$9 implements AnimatorUpdateListener {
    final /* synthetic */ ConversationWithAppBrandListView yYl;

    ConversationWithAppBrandListView$9(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.yYl = conversationWithAppBrandListView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ConversationWithAppBrandListView.k(this.yYl).setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
        this.yYl.invalidate();
    }
}
