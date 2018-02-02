package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.offline.c.a;

class OfflineAlertView$4 implements OnClickListener {
    final /* synthetic */ OfflineAlertView oXD;

    OfflineAlertView$4(OfflineAlertView offlineAlertView) {
        this.oXD = offlineAlertView;
    }

    public final void onClick(View view) {
        a.dm(this.oXD.getContext());
    }
}
