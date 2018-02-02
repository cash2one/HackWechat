package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.chatting.p.b;

class p$b$1 implements OnTouchListener {
    final /* synthetic */ b ysO;

    p$b$1(b bVar) {
        this.ysO = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (b.b(this.ysO) != null) {
            b.b(this.ysO).onTouch(b.c(this.ysO), motionEvent);
        }
        return false;
    }
}
