package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.d;

class ContactSearchResultUI$d$2 implements Runnable {
    final /* synthetic */ d rYt;
    final /* synthetic */ Bitmap rYu;

    ContactSearchResultUI$d$2(d dVar, Bitmap bitmap) {
        this.rYt = dVar;
        this.rYu = bitmap;
    }

    public final void run() {
        if (this.rYt.iip != null && this.rYt.iip.getTag() != null && this.rYt.username != null && this.rYt.username.equals(this.rYt.iip.getTag())) {
            this.rYt.iip.setImageBitmap(this.rYu);
        }
    }
}
