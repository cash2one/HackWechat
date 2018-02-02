package com.tencent.mm.ui.conversation;

import com.tencent.mm.ag.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.g;

class EnterpriseConversationUI$a$10 implements a {
    final /* synthetic */ EnterpriseConversationUI.a yZh;

    EnterpriseConversationUI$a$10(EnterpriseConversationUI.a aVar) {
        this.yZh = aVar;
    }

    public final void a(a.a aVar) {
        if (aVar != null && !bh.ov(aVar.hog) && aVar.hog.equals(EnterpriseConversationUI.a.c(this.yZh))) {
            int e = EnterpriseConversationUI.a.e(this.yZh);
            EnterpriseConversationUI.a.b(this.yZh, g.bl(this.yZh.getContext(), EnterpriseConversationUI.a.c(this.yZh)));
            if (EnterpriseConversationUI.a.e(this.yZh) != e) {
                EnterpriseConversationUI.a.b(this.yZh);
            }
        }
    }
}
