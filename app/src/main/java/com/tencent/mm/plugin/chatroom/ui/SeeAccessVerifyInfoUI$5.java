package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.d.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

class SeeAccessVerifyInfoUI$5 implements OnClickListener {
    final /* synthetic */ SeeAccessVerifyInfoUI lcQ;

    SeeAccessVerifyInfoUI$5(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI) {
        this.lcQ = seeAccessVerifyInfoUI;
    }

    public final void onClick(View view) {
        SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = this.lcQ;
        Context context = this.lcQ.mController.xIM;
        this.lcQ.getString(R.l.dGO);
        SeeAccessVerifyInfoUI.a(seeAccessVerifyInfoUI, h.a(context, this.lcQ.getString(R.l.dCg), false, null));
        new b(SeeAccessVerifyInfoUI.a(this.lcQ), SeeAccessVerifyInfoUI.j(this.lcQ), SeeAccessVerifyInfoUI.k(this.lcQ), new LinkedList(bh.F(SeeAccessVerifyInfoUI.l(this.lcQ).split(",")))).JV().c(this.lcQ).h(new 1(this));
    }
}
