package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.g.a.ap;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class k$5 extends c<ap> {
    final /* synthetic */ k pjC;

    k$5(k kVar) {
        this.pjC = kVar;
        this.xen = ap.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ap apVar = (ap) bVar;
        x.i("MicroMsg.ContactWidgetNormal", "[ChatroomMemberInviteerUpdatedEvent callback] username:%s inviteer:%s", apVar.foH.username, apVar.foH.foI);
        if (!(bh.ov(apVar.foH.username) || !apVar.foH.username.equals(this.pjC.jLe.field_username) || bh.ov(apVar.foH.foI))) {
            ag.y(new 1(this, apVar));
        }
        return false;
    }
}
