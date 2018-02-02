package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandServiceConversationFmUI yVG;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI) {
        this.yVG = appBrandServiceConversationFmUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.yVG.getContext(), ServiceNotifySettingsUI.class);
        intent.putExtra("mode", 1);
        intent.putExtra("scene_id", AppBrandServiceConversationFmUI.access$000(this.yVG));
        this.yVG.startActivity(intent);
        return true;
    }
}
