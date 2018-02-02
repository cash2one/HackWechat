package com.tencent.mm.ui.chatting.viewitems;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ui.chatting.viewitems.i.a;
import com.tencent.mm.ui.chatting.viewitems.i.b;

class i$b$1 implements Runnable {
    final /* synthetic */ a yKq;
    final /* synthetic */ b yKr;

    i$b$1(b bVar, a aVar) {
        this.yKr = bVar;
        this.yKq = aVar;
    }

    public final void run() {
        this.yKq.mRY.setLayoutParams(new LayoutParams(-2, -2));
        this.yKq.mSe.setLayoutParams(new LayoutParams(this.yKq.mRY.getWidth(), this.yKq.mRY.getHeight()));
    }
}
