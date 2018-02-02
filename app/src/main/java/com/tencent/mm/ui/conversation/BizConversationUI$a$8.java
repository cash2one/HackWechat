package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.conversation.BizConversationUI.a;
import com.tencent.mm.ui.tools.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class BizConversationUI$a$8 implements p$d {
    final /* synthetic */ a yWk;

    BizConversationUI$a$8(a aVar) {
        this.yWk = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                ar.Hg();
                af WO = c.EY().WO(a.m(this.yWk));
                if (WO == null) {
                    x.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + a.m(this.yWk));
                    return;
                } else if (WO.AL()) {
                    g.pQN.h(13307, new Object[]{WO.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2)});
                    s.s(a.m(this.yWk), true);
                    return;
                } else {
                    g.pQN.h(13307, new Object[]{WO.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2)});
                    s.r(a.m(this.yWk), true);
                    return;
                }
            case 2:
                ar.Hg();
                b.a(y.Mf().jK(a.m(this.yWk)), this.yWk.thisActivity(), c.EY().WO(a.m(this.yWk)), 2);
                return;
            case 3:
                a.b(this.yWk, a.m(this.yWk));
                return;
            default:
                return;
        }
    }
}
