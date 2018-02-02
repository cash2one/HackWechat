package com.tencent.mm.ui.chatting.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class u$9 implements OnTouchListener {
    final /* synthetic */ u yAV;

    public u$9(u uVar) {
        this.yAV = uVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.yAV.fhr.csq().hideVKB();
        return false;
    }
}
