package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.conversation.BizConversationUI.a.b;
import com.tencent.mm.ui.o.a;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.HashMap;

class BizConversationUI$a$a extends d {
    private String fCU;
    HashMap<String, b> yWl = new HashMap();

    public BizConversationUI$a$a(Context context, String str, a aVar) {
        super(context, aVar);
        this.fCU = str;
    }

    public final void Xy() {
        ar.Hg();
        setCursor(c.Fd().c(s.hfk, this.kiU, this.fCU));
        if (this.xIi != null) {
            this.xIi.Xv();
        }
        super.notifyDataSetChanged();
    }

    protected final void a(ae aeVar, boolean z, int i, boolean z2) {
        if (aeVar != null) {
            b bVar;
            b bVar2 = (b) this.yWl.get(aeVar.field_username);
            if (bVar2 == null) {
                bVar2 = new b((byte) 0);
                this.yWl.put(aeVar.field_username, bVar2);
                bVar = bVar2;
            } else {
                bVar = bVar2;
            }
            if (bVar.yWm <= 0) {
                bVar.wIs = z;
                boolean z3 = bVar.wIv || aeVar.field_unReadCount > 0;
                bVar.wIv = z3;
                bVar.njV = i + 1;
                if (z2) {
                    bVar.yWm = bVar.njV;
                }
                bVar.wIu = (int) (System.currentTimeMillis() / 1000);
                if (aeVar.field_lastSeq != bVar.wLE) {
                    bVar.wLE = aeVar.field_lastSeq;
                    cf Ex = ((h) g.h(h.class)).aZi().Ex(aeVar.field_username);
                    if (Ex != null && Ex.ciV()) {
                        l vL = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(Ex.field_content);
                        if (vL != null || (!bh.cA(vL.hdX) && !bh.ov(((m) vL.hdX.get(0)).url))) {
                            try {
                                Uri parse = Uri.parse(((m) vL.hdX.get(0)).url);
                                bVar.wIq = bh.getLong(parse.getQueryParameter("mid"), 0);
                                bVar.wIr = bh.getInt(parse.getQueryParameter("idx"), 0);
                            } catch (UnsupportedOperationException e) {
                                x.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[]{e.getMessage()});
                            } catch (Exception e2) {
                                x.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[]{e2.getMessage()});
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(ae aeVar, int i) {
        ar.Hg();
        a(aeVar, c.Fd().g(aeVar), i, true);
    }
}
