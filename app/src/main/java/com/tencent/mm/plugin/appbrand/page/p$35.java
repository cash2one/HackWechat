package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.l.a;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;

class p$35 implements OnClickListener {
    final /* synthetic */ p jEg;

    p$35(p pVar) {
        this.jEg = pVar;
    }

    public final void onClick(View view) {
        boolean z;
        int i = 0;
        AppBrandOptionButton appBrandOptionButton = (AppBrandOptionButton) view;
        if (this.jEg.mContext == null || !(this.jEg.mContext instanceof MMActivity)) {
            z = false;
        } else {
            z = ((MMActivity) this.jEg.mContext).mController.hideVKB();
        }
        if (appBrandOptionButton.jVV) {
            Runnable 1 = new 1(this);
            if (z) {
                i = 100;
            }
            ag.h(1, (long) i);
            return;
        }
        a.se(this.jEg.mAppId);
    }
}
