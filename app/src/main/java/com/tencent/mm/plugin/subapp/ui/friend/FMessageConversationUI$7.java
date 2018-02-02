package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;

class FMessageConversationUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ FMessageConversationUI rXh;

    FMessageConversationUI$7(FMessageConversationUI fMessageConversationUI) {
        this.rXh = fMessageConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.rXh, AddMoreFriendsUI.class);
        intent.putExtra("invite_friend_scene", 3);
        this.rXh.startActivity(intent);
        return true;
    }
}
