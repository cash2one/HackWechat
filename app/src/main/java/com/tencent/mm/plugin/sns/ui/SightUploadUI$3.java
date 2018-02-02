package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class SightUploadUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SightUploadUI rxb;

    SightUploadUI$3(SightUploadUI sightUploadUI) {
        this.rxb = sightUploadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        b piVar = new pi();
        piVar.fHh.type = 0;
        piVar.fHh.fHj = false;
        a.xef.m(piVar);
        this.rxb.aWs();
        this.rxb.finish();
        return true;
    }
}
