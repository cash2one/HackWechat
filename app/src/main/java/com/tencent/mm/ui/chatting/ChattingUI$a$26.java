package com.tencent.mm.ui.chatting;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class ChattingUI$a$26 implements OnGlobalLayoutListener {
    final /* synthetic */ a ywR;

    ChattingUI$a$26(a aVar) {
        this.ywR = aVar;
    }

    public final void onGlobalLayout() {
        a.c(this.ywR).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        a.d(this.ywR).run();
    }
}
