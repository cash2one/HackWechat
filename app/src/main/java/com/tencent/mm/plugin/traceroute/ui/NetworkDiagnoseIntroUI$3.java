package com.tencent.mm.plugin.traceroute.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NetworkDiagnoseIntroUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ NetworkDiagnoseIntroUI sfB;

    NetworkDiagnoseIntroUI$3(NetworkDiagnoseIntroUI networkDiagnoseIntroUI) {
        this.sfB = networkDiagnoseIntroUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sfB.finish();
        return true;
    }
}
