package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class k$6 implements OnClickListener {
    final /* synthetic */ k ySB;

    k$6(k kVar) {
        this.ySB = kVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
        ar.Hg();
        c.CU().set(143618, Integer.valueOf(0));
        d.b(k.d(this.ySB), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
    }
}
