package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class ChattingUI$a$4 implements c {
    final /* synthetic */ a ywR;

    ChattingUI$a$4(a aVar) {
        this.ywR = aVar;
    }

    public final boolean azm() {
        View childAt = a.c(this.ywR).getChildAt(a.c(this.ywR).getChildCount() - 1);
        if (childAt == null) {
            return true;
        }
        if (childAt.getBottom() > a.c(this.ywR).getHeight() || a.c(this.ywR).getLastVisiblePosition() != a.c(this.ywR).getAdapter().getCount() - 1) {
            return false;
        }
        return true;
    }
}
