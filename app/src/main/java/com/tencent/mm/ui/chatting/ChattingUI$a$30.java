package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class ChattingUI$a$30 implements OnTouchListener {
    final /* synthetic */ a ywR;

    ChattingUI$a$30(a aVar) {
        this.ywR = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        a.i(this.ywR);
        if (this.ywR.ywy) {
            this.ywR.ywe.csB().p(0, -1, false);
        }
        return false;
    }
}
