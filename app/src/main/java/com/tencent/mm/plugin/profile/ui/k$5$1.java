package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.g.a.ap;
import com.tencent.mm.plugin.profile.ui.k.5;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.a;

class k$5$1 implements Runnable {
    final /* synthetic */ ap pjE;
    final /* synthetic */ 5 pjF;

    k$5$1(5 5, ap apVar) {
        this.pjF = 5;
        this.pjE = apVar;
    }

    public final void run() {
        String str = this.pjE.foH.foI;
        this.pjF.pjC.fAF.getIntent().putExtra("inviteer", str);
        String gu = this.pjF.pjC.gu(this.pjE.foH.foI);
        x.i("MicroMsg.ContactWidgetNormal", "[ChatroomMemberInviteerUpdatedEvent callback] inviteer:%s inviteerDisplayName:%s", new Object[]{str, gu});
        if (bh.ov(gu)) {
            a.hfL.a(str, "", new 1(this, str));
        } else {
            this.pjF.pjC.dH(str, gu);
        }
    }
}
