package com.tencent.mm.ui.conversation;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class BaseConversationUI$11 implements AnimationListener {
    final /* synthetic */ BaseConversationUI yVX;

    BaseConversationUI$11(BaseConversationUI baseConversationUI) {
        this.yVX = baseConversationUI;
    }

    public final void onAnimationStart(Animation animation) {
        ar.Dm().cfC();
        ag.Df(-8);
        x.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationStart");
        this.yVX.onSettle(true, 0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ar.Dm().cfE();
        ag.Df(0);
        BaseConversationUI.access$600(this.yVX);
        x.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationEnd");
    }
}
