package com.tencent.mm.pluginsdk.ui.chat;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class ChatFooter$26 implements OnEditorActionListener {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$26(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4 && (i != 0 || !ChatFooter.h(this.vra))) {
            return false;
        }
        ChatFooter.i(this.vra).performClick();
        return true;
    }
}
