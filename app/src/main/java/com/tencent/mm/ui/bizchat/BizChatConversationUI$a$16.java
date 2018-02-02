package com.tencent.mm.ui.bizchat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$16 implements OnTouchListener {
    final /* synthetic */ a ynJ;

    BizChatConversationUI$a$16(a aVar) {
        this.ynJ = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            a.a(this.ynJ, (int) motionEvent.getRawX());
            a.b(this.ynJ, (int) motionEvent.getRawY());
        }
        return false;
    }
}
