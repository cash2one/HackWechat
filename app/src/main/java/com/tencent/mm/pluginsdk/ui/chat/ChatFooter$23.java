package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.R;

class ChatFooter$23 implements OnFocusChangeListener {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$23(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            ChatFooter.c(this.vra).setBackground(this.vra.getResources().getDrawable(R.g.bDf));
        } else {
            ChatFooter.c(this.vra).setBackground(this.vra.getResources().getDrawable(R.g.bDg));
        }
    }
}
