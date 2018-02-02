package com.tencent.mm.ui.tools;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.x;

class g$4 implements AnimationListener {
    final /* synthetic */ g$b zkQ;
    final /* synthetic */ g zkR;

    g$4(g gVar, g$b com_tencent_mm_ui_tools_g_b) {
        this.zkR = gVar;
        this.zkQ = com_tencent_mm_ui_tools_g_b;
    }

    public final void onAnimationStart(Animation animation) {
        x.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation start!");
        if (this.zkQ != null) {
            this.zkQ.onAnimationStart();
        }
        this.zkR.rpS = this.zkR.rpR;
    }

    public final void onAnimationEnd(Animation animation) {
        x.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation end!");
        if (this.zkQ != null) {
            this.zkQ.onAnimationEnd();
        }
        this.zkR.rpS = this.zkR.rpO;
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
