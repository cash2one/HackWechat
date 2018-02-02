package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;

class a$5 implements OnMenuItemClickListener {
    final /* synthetic */ a lFm;

    a$5(a aVar) {
        this.lFm = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.setClass(this.lFm.thisActivity(), EmojiMineUI.class);
        this.lFm.startActivity(intent);
        return false;
    }
}
