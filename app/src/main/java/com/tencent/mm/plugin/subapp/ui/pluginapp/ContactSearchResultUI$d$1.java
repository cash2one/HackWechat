package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.graphics.Bitmap;
import com.tencent.mm.ag.m;
import com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.a;
import com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.d;
import com.tencent.mm.sdk.platformtools.bh;

class ContactSearchResultUI$d$1 extends a {
    final /* synthetic */ d rYt;

    ContactSearchResultUI$d$1(d dVar) {
        this.rYt = dVar;
        super((byte) 0);
    }

    public final void run() {
        if (!bh.ov(this.username) && !bh.ov(this.rYt.username) && this.username.equals(this.rYt.username)) {
            Bitmap d = m.d(this.username, this.iconUrl, 0);
            if (d != null && !d.isRecycled()) {
                this.rYt.asF();
            }
        }
    }
}
