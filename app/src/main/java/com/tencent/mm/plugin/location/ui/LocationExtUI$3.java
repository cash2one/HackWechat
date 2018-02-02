package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LocationExtUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ LocationExtUI nSF;

    LocationExtUI$3(LocationExtUI locationExtUI) {
        this.nSF = locationExtUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("key_remark_result", LocationExtUI.b(this.nSF));
        intent.putExtra("key_tags_result", LocationExtUI.a(this.nSF));
        this.nSF.setResult(-1, intent);
        this.nSF.finish();
        return true;
    }
}
