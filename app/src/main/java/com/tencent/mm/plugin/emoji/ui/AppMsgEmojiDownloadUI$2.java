package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppMsgEmojiDownloadUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ AppMsgEmojiDownloadUI lAp;

    AppMsgEmojiDownloadUI$2(AppMsgEmojiDownloadUI appMsgEmojiDownloadUI) {
        this.lAp = appMsgEmojiDownloadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lAp.finish();
        return true;
    }
}
