package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.m;
import com.tencent.mm.ag.n;
import com.tencent.mm.ag.y;
import com.tencent.mm.bm.d;
import com.tencent.mm.protocal.c.pf;
import com.tencent.mm.sdk.platformtools.bh;

class g$84 implements n {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$84(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
    }

    public final void a(int i, k kVar) {
        if (i != 0) {
            g.a(this.tIj, this.tIg, "enterEnterpriseChat:fail", null);
            return;
        }
        pf My = ((m) kVar).My();
        String str = "enterEnterpriseChat:fail";
        if (i < 0) {
            if (!(My == null || My.vNw == null || !bh.ov(My.vNw.ftt))) {
                str = "enterEnterpriseChat:fail_" + My.vNw.ftt;
            }
            g.a(this.tIj, this.tIg, str, null);
            return;
        }
        String str2 = My.vNq;
        String str3 = ((m) kVar).hrt;
        if (str3 == null) {
            g.a(this.tIj, this.tIg, "enterEnterpriseChat:fail", null);
            return;
        }
        c kl = y.Mh().kl(str3);
        if (kl == null || bh.ov(str2)) {
            g.a(this.tIj, this.tIg, str, null);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str2);
        intent.putExtra("key_biz_chat_id", kl.field_bizChatLocalId);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        intent.putExtra("key_is_biz_chat", true);
        d.a(g.i(this.tIj), ".ui.chatting.ChattingUI", intent);
        g.a(this.tIj, this.tIg, "enterEnterpriseChat:ok", null);
    }
}
