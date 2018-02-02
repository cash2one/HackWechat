package com.tencent.mm.ui.chatting.b;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.sdk.platformtools.x;

class w$9 implements OnGlobalLayoutListener {
    final /* synthetic */ long gyu;
    final /* synthetic */ w yBn;

    public w$9(w wVar, long j) {
        this.yBn = wVar;
        this.gyu = j;
    }

    public final void onGlobalLayout() {
        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr needCheckHistoryTips onGlobalLayout run delay[%d], BADCR_SCROLL_DELAY[%d] needCheckHistoryTips[%b]", new Object[]{Long.valueOf(System.currentTimeMillis() - this.gyu), Integer.valueOf(w.yBh), Boolean.valueOf(this.yBn.yBj)});
        w.a(this.yBn).csx().getViewTreeObserver().removeGlobalOnLayoutListener(this);
        w.a(this.yBn).mM(false);
        w.a(this.yBn).csx().postDelayed(new 1(this), (long) w.yBh);
    }
}
