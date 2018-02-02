package com.tencent.mm.plugin.subapp.ui.pluginapp;

import com.tencent.mm.R;
import com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.d;
import com.tencent.mm.z.ar;

class ContactSearchResultUI$d$3 implements Runnable {
    final /* synthetic */ d rYt;

    ContactSearchResultUI$d$3(d dVar) {
        this.rYt = dVar;
    }

    public final void run() {
        if (this.rYt.iip != null) {
            this.rYt.iip.setImageResource(R.g.bzZ);
            this.rYt.rYs.er(this.rYt.username, this.rYt.iconUrl);
            ar.Dm().g(this.rYt.rYs, 200);
        }
    }
}
