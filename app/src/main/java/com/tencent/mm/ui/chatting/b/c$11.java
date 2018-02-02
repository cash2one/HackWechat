package com.tencent.mm.ui.chatting.b;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.d$a$a;
import com.tencent.mm.ag.a.d.a;
import com.tencent.mm.ag.a.d.a.b;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class c$11 implements a {
    final /* synthetic */ c yyQ;

    c$11(c cVar) {
        this.yyQ = cVar;
    }

    public final void a(b bVar) {
        if (!this.yyQ.vnK || bVar == null || bVar.hqF != this.yyQ.cti()) {
            return;
        }
        if (this.yyQ.fhr.csP()) {
            x.i("MicroMsg.ChattingUI.BizMgr", "onNotifyChange fragment not foreground, return");
        } else if (bVar.hqP != d$a$a.hqM) {
            x.i("MicroMsg.ChattingUI.BizMgr", "bizChatExtension bizChat change");
            this.yyQ.ync = y.Mh().ag(this.yyQ.cti());
            if (this.yyQ.yyK) {
                this.yyQ.fhr.mJ(e.c(this.yyQ.ync));
                this.yyQ.fhr.cqZ();
            } else {
                j ca = y.Mj().ca(this.yyQ.ync.field_bizChatServId);
                if (ca != null) {
                    this.yyQ.piK = ca;
                }
            }
            this.yyQ.fhr.cqY();
        } else if (this.yyQ.yyK) {
            Toast.makeText(ac.getContext(), this.yyQ.fhr.csq().getMMString(R.l.eFo), 1).show();
            this.yyQ.fhr.csq().finish();
        }
    }
}
