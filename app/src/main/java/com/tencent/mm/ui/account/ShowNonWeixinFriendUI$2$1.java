package com.tencent.mm.ui.account;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.ShowNonWeixinFriendUI.2;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;

class ShowNonWeixinFriendUI$2$1 implements a {
    final /* synthetic */ 2 xSJ;

    ShowNonWeixinFriendUI$2$1(2 2) {
        this.xSJ = 2;
    }

    public final void a(d dVar) {
        x.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
    }

    public final void a(b bVar) {
        x.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
    }

    public final void k(Bundle bundle) {
        x.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
        h.a(this.xSJ.xSI.mController.xIM, R.l.ees, R.l.dGO, new 1(this));
    }

    public final void onCancel() {
        x.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
    }
}
