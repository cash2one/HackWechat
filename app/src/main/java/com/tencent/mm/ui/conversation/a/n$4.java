package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.conversation.a.n.2;

class n$4 implements OnClickListener {
    final /* synthetic */ n zby;

    n$4(n nVar) {
        this.zby = nVar;
    }

    public final void onClick(View view) {
        n.a(this.zby, this.zby.sfj);
        this.zby.sfj = 1;
        if (this.zby.zbw == null) {
            n nVar = this.zby;
            nVar.zbw = new n$1(nVar);
            a.xef.a(nVar.zbw);
        }
        if (this.zby.zbv == null) {
            nVar = this.zby;
            nVar.zbv = new ak(new 2(nVar), true);
            nVar.zbv.J(1000, 1000);
        }
    }
}
