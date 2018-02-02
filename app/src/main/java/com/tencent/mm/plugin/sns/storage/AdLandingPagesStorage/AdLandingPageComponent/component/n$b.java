package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.io.Serializable;

class n$b extends BroadcastReceiver implements Serializable {
    final /* synthetic */ n rjH;

    private n$b(n nVar) {
        this.rjH = nVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            Object schemeSpecificPart;
            if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart) && schemeSpecificPart.equals(n.b(this.rjH).uC)) {
                    this.rjH.rjD.Dh(3);
                }
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart) && schemeSpecificPart.equals(n.b(this.rjH).uC)) {
                    this.rjH.rjD.Dh(4);
                }
            }
        }
    }
}
