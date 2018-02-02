package com.tencent.mm.ui.conversation.a;

import com.tencent.mm.g.a.ck;
import com.tencent.mm.k.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class i$2 extends c<ck> {
    final /* synthetic */ i zaO;

    i$2(i iVar) {
        this.zaO = iVar;
        this.xen = ck.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.InviteFriendBanner", "dynamic config file change");
        this.zaO.fWj = t.getInt(g.zY().getValue("InviteFriendsControlFlags"), 0);
        if ((this.zaO.fWj & 1) > 0) {
            this.zaO.zaN.post(new Runnable(this) {
                final /* synthetic */ i$2 zaP;

                {
                    this.zaP = r1;
                }

                public final void run() {
                    this.zaP.zaO.zaN.setVisibility(0);
                    this.zaP.zaO.zaN.setPadding(0, 0, 0, 0);
                }
            });
        }
        return true;
    }
}
