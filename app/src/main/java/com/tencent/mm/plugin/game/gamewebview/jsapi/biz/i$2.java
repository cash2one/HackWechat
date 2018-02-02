package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;

class i$2 implements d {
    final /* synthetic */ i mWH;
    final /* synthetic */ String mWI;
    final /* synthetic */ Intent val$intent;

    i$2(i iVar, String str, Intent intent) {
        this.mWH = iVar;
        this.mWI = str;
        this.val$intent = intent;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                this.mWH.a(this.mWI, this.val$intent);
                return;
            case 2:
                this.mWH.J(this.val$intent);
                return;
            default:
                return;
        }
    }
}
