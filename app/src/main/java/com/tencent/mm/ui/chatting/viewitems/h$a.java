package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class h$a extends d {
    h$a(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        ar.Hg();
        if (c.isSDCardAvailable()) {
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.yqa.getContext(), arVar.fEJ);
            com.tencent.mm.plugin.report.service.g.pQN.h(11592, Integer.valueOf(0));
        }
    }
}
