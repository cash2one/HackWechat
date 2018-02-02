package com.tencent.mm.ui.friend;

import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.friend.InviteFriendUI.1;
import java.util.HashMap;

class InviteFriendUI$1$3 implements c {
    final /* synthetic */ HashMap zcQ;
    final /* synthetic */ 1 zcS;

    InviteFriendUI$1$3(1 1, HashMap hashMap) {
        this.zcS = 1;
        this.zcQ = hashMap;
    }

    public final void a(n nVar) {
        for (String add : this.zcQ.keySet()) {
            nVar.add(add);
        }
    }
}
