package com.tencent.mm.ui.conversation;

import com.tencent.mm.ag.a.e;
import com.tencent.mm.ui.conversation.b.11;
import com.tencent.mm.z.ba.a;

class b$11$1 implements a {
    final /* synthetic */ 11 yWs;

    b$11$1(11 11) {
        this.yWs = 11;
    }

    public final boolean HB() {
        return this.yWs.yWn.value || this.yWs.lao == null || !this.yWs.lao.isShowing();
    }

    public final void HA() {
        e.A(this.yWs.xEU, false);
        if (this.yWs.lao != null) {
            this.yWs.lao.dismiss();
        }
    }
}
