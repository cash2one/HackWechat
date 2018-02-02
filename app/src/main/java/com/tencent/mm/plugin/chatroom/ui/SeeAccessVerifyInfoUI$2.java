package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.b.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.c;

class SeeAccessVerifyInfoUI$2 implements OnClickListener {
    final /* synthetic */ SeeAccessVerifyInfoUI lcQ;

    SeeAccessVerifyInfoUI$2(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI) {
        this.lcQ = seeAccessVerifyInfoUI;
    }

    public final void onClick(View view) {
        SeeAccessVerifyInfoUI.b(this.lcQ);
        af WO = c.EY().WO(bh.ou(SeeAccessVerifyInfoUI.a(this.lcQ)));
        String str = WO.field_nickname;
        String str2 = null;
        if (SeeAccessVerifyInfoUI.c(this.lcQ) != null) {
            str2 = SeeAccessVerifyInfoUI.c(this.lcQ).gu(SeeAccessVerifyInfoUI.a(this.lcQ));
        }
        if (bh.ov(str2)) {
            str2 = WO.AQ();
        }
        SeeAccessVerifyInfoUI.a(this.lcQ, SeeAccessVerifyInfoUI.a(this.lcQ), str2, str, false);
    }
}
