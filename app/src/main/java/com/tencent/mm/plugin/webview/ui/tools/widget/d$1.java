package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;

class d$1 implements OnClickListener {
    final /* synthetic */ Callback mZL;
    final /* synthetic */ String mZM;
    final /* synthetic */ d tKb;

    d$1(d dVar, Callback callback, String str) {
        this.tKb = dVar;
        this.mZL = callback;
        this.mZM = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mZL.invoke(this.mZM, true, true);
    }
}
