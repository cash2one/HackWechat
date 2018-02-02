package com.tencent.mm.plugin.collect.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.a;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.b;
import com.tencent.mm.sdk.platformtools.x;

class CollectMainUI$b$1 implements AnimationListener {
    final /* synthetic */ a lns;
    final /* synthetic */ b lnt;

    CollectMainUI$b$1(b bVar, a aVar) {
        this.lnt = bVar;
        this.lns = aVar;
    }

    public final void onAnimationEnd(Animation animation) {
        this.lnt.lnh.lmt.setVisibility(8);
        x.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + this.lns.fuI);
        for (int i = 0; i < this.lnt.lnh.lmF.size(); i++) {
            if (((a) this.lnt.lnh.lmF.get(i)).fuI.equals(this.lns.fuI)) {
                ((a) this.lnt.lnh.lmF.get(i)).kSa = true;
                x.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + this.lns.fuI);
                break;
            }
        }
        this.lnt.lnh.azu();
        this.lnt.lnq = false;
        this.lnt.azy();
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
