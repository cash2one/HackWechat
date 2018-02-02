package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.voicesearch.b;

class ChatroomContactUI$13 implements OnTouchListener {
    final /* synthetic */ ChatroomContactUI yRt;

    ChatroomContactUI$13(ChatroomContactUI chatroomContactUI) {
        this.yRt = chatroomContactUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.yRt.aWs();
                ChatroomContactUI.a(this.yRt, (int) motionEvent.getRawX());
                ChatroomContactUI.b(this.yRt, (int) motionEvent.getRawY());
                break;
        }
        if (ChatroomContactUI.f(this.yRt) != null) {
            d f = ChatroomContactUI.f(this.yRt);
            if (f.hvU != null) {
                f.hvU.onTouchEvent(motionEvent);
            }
        }
        if (ChatroomContactUI.d(this.yRt) != null) {
            b d = ChatroomContactUI.d(this.yRt);
            if (d.hvU != null) {
                d.hvU.onTouchEvent(motionEvent);
            }
        }
        return false;
    }
}
