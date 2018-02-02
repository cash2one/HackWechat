package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.u;

class AddMoreFriendsUI$2 implements OnClickListener {
    final /* synthetic */ AddMoreFriendsUI rYm;

    AddMoreFriendsUI$2(AddMoreFriendsUI addMoreFriendsUI) {
        this.rYm = addMoreFriendsUI;
    }

    public final void onClick(View view) {
        d.b(this.rYm, "search", ".ui.FTSAddFriendUI", new Intent().putExtra("Search_Scene", 2).putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, 0));
    }
}
