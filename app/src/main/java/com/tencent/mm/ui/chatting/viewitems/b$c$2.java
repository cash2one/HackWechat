package com.tencent.mm.ui.chatting.viewitems;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.chatting.viewitems.b.c;

class b$c$2 implements OnTouchListener {
    final /* synthetic */ c yIH;

    b$c$2(c cVar) {
        this.yIH = cVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        c.a(this.yIH, (int) motionEvent.getRawX());
        c.b(this.yIH, (int) motionEvent.getRawY());
        c.a(this.yIH, view);
        return false;
    }
}
