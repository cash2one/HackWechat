package com.tencent.mm.pluginsdk.ui.chat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ChatFooter$27 implements OnTouchListener {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$27(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.vra.ll(true);
        ChatFooter.a(this.vra, 3);
        ChatFooter.j(this.vra).aYL();
        ChatFooter.k(this.vra);
        return false;
    }
}
