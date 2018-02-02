package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.account.FacebookFriendUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class h$1 implements OnClickListener {
    final /* synthetic */ h zaM;

    h$1(h hVar) {
        this.zaM = hVar;
    }

    public final void onClick(View view) {
        ar.Hg();
        c.CU().set(65833, Integer.valueOf(0));
        ((Context) this.zaM.voC.get()).startActivity(new Intent((Context) this.zaM.voC.get(), FacebookFriendUI.class));
        this.zaM.view.setVisibility(8);
    }
}
