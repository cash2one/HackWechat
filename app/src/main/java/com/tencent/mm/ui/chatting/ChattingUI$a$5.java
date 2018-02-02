package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class ChattingUI$a$5 implements d {
    final /* synthetic */ a ywR;

    ChattingUI$a$5(a aVar) {
        this.ywR = aVar;
    }

    public final boolean azl() {
        View childAt = a.c(this.ywR).getChildAt(a.c(this.ywR).getFirstVisiblePosition());
        return childAt != null && childAt.getTop() == 0;
    }
}
