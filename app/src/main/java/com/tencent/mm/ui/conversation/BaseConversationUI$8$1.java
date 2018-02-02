package com.tencent.mm.ui.conversation;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.BaseConversationUI.8;

class BaseConversationUI$8$1 implements AnimationListener {
    final /* synthetic */ 8 yVY;

    BaseConversationUI$8$1(8 8) {
        this.yVY = 8;
    }

    public final void onAnimationStart(Animation animation) {
        x.i("MicroMsg.BaseConversationUI", "klem onAnimationStart onDrawed->onAnimationStart:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.yVY.start)});
        BaseConversationUI.access$802(this.yVY.yVX, true);
        BaseConversationUI.access$900(this.yVY.yVX);
        this.yVY.yVX.onSettle(false, 0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        BaseConversationUI.access$802(this.yVY.yVX, false);
        x.i("MicroMsg.BaseConversationUI", "klem animationEnd");
        BaseConversationUI.access$1000(this.yVY.yVX);
    }
}
