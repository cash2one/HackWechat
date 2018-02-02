package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.f.a.c;

class ShowNonWeixinFriendUI$2 implements OnClickListener {
    final /* synthetic */ ShowNonWeixinFriendUI xSI;

    ShowNonWeixinFriendUI$2(ShowNonWeixinFriendUI showNonWeixinFriendUI) {
        this.xSI = showNonWeixinFriendUI;
    }

    public final void onClick(View view) {
        c cVar = new c("290293790992170");
        Bundle bundle = new Bundle();
        bundle.putString("message", this.xSI.getString(R.l.een));
        bundle.putString("to", Long.toString(ShowNonWeixinFriendUI.a(this.xSI)));
        cVar.a(this.xSI, "apprequests", bundle, new 1(this));
    }
}
