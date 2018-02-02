package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;

class i$1 implements OnClickListener {
    final /* synthetic */ Context val$context;
    final /* synthetic */ i zaO;

    i$1(i iVar, Context context) {
        this.zaO = iVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Invite_friends", 1);
        d.b(this.val$context, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", intent);
        g.pQN.h(14034, new Object[]{Integer.valueOf(1)});
    }
}
