package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class GroupCardSelectUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ GroupCardSelectUI ySK;

    GroupCardSelectUI$3(GroupCardSelectUI groupCardSelectUI) {
        this.ySK = groupCardSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_User", bh.d(GroupCardSelectUI.e(this.ySK), ","));
        this.ySK.setResult(-1, intent);
        this.ySK.finish();
        return true;
    }
}
