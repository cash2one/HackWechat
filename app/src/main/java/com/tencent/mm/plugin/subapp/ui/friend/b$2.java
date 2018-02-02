package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bf.l;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class b$2 implements OnClickListener {
    final /* synthetic */ b rWR;

    b$2(b bVar) {
        this.rWR = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof b) {
            x.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
            b bVar = (b) view.getTag();
            if (bVar == null || bh.ov(bVar.username)) {
                x.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
                return;
            }
            af b = b.b(l.Tw().mX(bVar.username));
            a aVar = new a(b.a(this.rWR), new 1(this, bVar, b));
            x.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(bVar.qra));
            aVar.Sk(b.fWF);
            aVar.b(bVar.username, linkedList, true);
        }
    }
}
