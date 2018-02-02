package com.tencent.mm.ui.friend;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class InviteFriendUI$2 implements OnClickListener {
    final /* synthetic */ InviteFriendUI zcP;

    InviteFriendUI$2(InviteFriendUI inviteFriendUI) {
        this.zcP = inviteFriendUI;
    }

    public final void onClick(View view) {
        b lzVar = new lz();
        lzVar.fDy.opType = 0;
        lzVar.fDy.fDA = InviteFriendUI.b(this.zcP) + "@qqim";
        lzVar.fDy.fDB = InviteFriendUI.f(this.zcP);
        a.xef.m(lzVar);
        if (lzVar.fDz.fpW) {
            com.tencent.mm.plugin.c.a.ifs.e(new Intent().putExtra("Chat_User", InviteFriendUI.b(this.zcP) + "@qqim"), this.zcP);
        }
        this.zcP.finish();
    }
}
