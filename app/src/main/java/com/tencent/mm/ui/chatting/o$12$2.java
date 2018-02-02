package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.chatting.o.12;

class o$12$2 implements d {
    final /* synthetic */ 12 yss;

    o$12$2(12 12) {
        this.yss = 12;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                this.yss.ysq.bjB();
                return;
            case 2:
                this.yss.ysq.bjC();
                return;
            default:
                return;
        }
    }
}
