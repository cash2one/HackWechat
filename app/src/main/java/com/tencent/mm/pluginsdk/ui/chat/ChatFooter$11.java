package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class ChatFooter$11 implements b {
    final /* synthetic */ ChatFooter vra;

    ChatFooter$11(ChatFooter chatFooter) {
        this.vra = chatFooter;
    }

    public final void cbl() {
        x.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(ChatFooter.b(this.vra), "android.permission.RECORD_AUDIO", 80, "", "")), bh.cgy(), ChatFooter.b(this.vra)});
        if (a.a(ChatFooter.b(this.vra), "android.permission.RECORD_AUDIO", 80, "", "")) {
            int Km = ar.CG().Km();
            if (Km == 4 || Km == 6) {
                ChatFooter.A(this.vra);
            } else if (ChatFooter.l(this.vra) == null || !ChatFooter.l(this.vra).isShowing()) {
                ChatFooter.a(this.vra, h.h(this.vra.getContext(), R.l.eVz, R.l.dGO));
            }
        }
    }
}
