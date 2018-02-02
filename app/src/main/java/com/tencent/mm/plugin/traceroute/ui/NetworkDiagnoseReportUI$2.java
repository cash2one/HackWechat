package com.tencent.mm.plugin.traceroute.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NetworkDiagnoseReportUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ NetworkDiagnoseReportUI sfJ;

    NetworkDiagnoseReportUI$2(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        this.sfJ = networkDiagnoseReportUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sfJ.finish();
        return true;
    }
}
