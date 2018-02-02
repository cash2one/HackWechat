package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceLikeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceLikeUI lUB;

    ExdeviceLikeUI$1(ExdeviceLikeUI exdeviceLikeUI) {
        this.lUB = exdeviceLikeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.lUB, ExdeviceRankInfoUI.class);
        intent.putExtra("app_username", ExdeviceLikeUI.a(this.lUB));
        intent.putExtra("rank_id", "#");
        intent.putExtra("key_is_latest", true);
        intent.putExtra("device_type", 1);
        this.lUB.startActivity(intent);
        this.lUB.finish();
        return false;
    }
}
