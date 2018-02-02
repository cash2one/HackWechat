package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements OnClickListener {
    final /* synthetic */ c zIW;

    c$2(c cVar) {
        this.zIW = cVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.OfflinePopupWindow", "on click know");
        this.zIW.zIU.setVisibility(8);
        b cgVar = new cg();
        cgVar.fqz.fqA = 1;
        a.xef.m(cgVar);
    }
}
