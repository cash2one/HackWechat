package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.sdk.platformtools.x;

class CreateOrJoinChatroomUI$2 implements a {
    final /* synthetic */ CreateOrJoinChatroomUI nls;

    CreateOrJoinChatroomUI$2(CreateOrJoinChatroomUI createOrJoinChatroomUI) {
        this.nls = createOrJoinChatroomUI;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        au auVar = (au) bVar.hmh.hmo;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", auVar.nhq);
            CreateOrJoinChatroomUI.a(this.nls);
            CreateOrJoinChatroomUI.a(this.nls, r0);
        } else {
            x.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 4) {
                CreateOrJoinChatroomUI.a(this.nls, auVar.lOr);
            } else {
                CreateOrJoinChatroomUI.a(this.nls, -1);
            }
            CreateOrJoinChatroomUI.a(this.nls);
            this.nls.finish();
        }
        return 0;
    }
}
