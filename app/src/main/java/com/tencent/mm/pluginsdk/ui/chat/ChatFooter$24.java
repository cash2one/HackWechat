package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class ChatFooter$24 implements a {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$24(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final void Sj(String str) {
        x.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", str);
        if (bh.ov(ChatFooter.d(this.vra)) || bh.ov(str)) {
            x.e("MicroMsg.ChatFooter", "onImageReceived, error args");
        } else {
            h.a(this.vra.getContext(), this.vra.getContext().getString(R.l.edW), "", new 1(this, str), new 2(this));
        }
    }
}
