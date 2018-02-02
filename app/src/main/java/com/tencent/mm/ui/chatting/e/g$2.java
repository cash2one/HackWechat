package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.a.b$e;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class g$2 implements b$e {
    final /* synthetic */ g yHJ;

    g$2(g gVar) {
        this.yHJ = gVar;
    }

    public final void a(int i, b bVar) {
        Context context = this.yHJ.mContext;
        String str = this.yHJ.jRw;
        long j = bVar.fqm;
        if (str == null) {
            x.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
            return;
        }
        ar.Hg();
        x.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[]{Long.valueOf(c.Fa().dH(j).field_msgId)});
        if (s.eV(str)) {
            ar.Hg();
            if (c.Fh().hD(str) == null) {
                x.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[]{str});
                h.a(context, context.getString(R.l.eEv), context.getString(R.l.cRU), null);
                return;
            }
        }
        ar.Hg();
        af WO = c.EY().WO(str);
        if (WO == null || !a.fZ(WO.field_type)) {
            if (WO == null) {
                x.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[]{str});
            } else {
                x.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[]{str});
            }
            h.a(context, context.getString(R.l.eEv), context.getString(R.l.cRU), null);
            return;
        }
        com.tencent.mm.plugin.chatroom.a.ifs.e(new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j), context);
    }

    public final void a(View view, int i, b bVar) {
    }
}
