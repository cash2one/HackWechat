package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.view.View.OnClickListener;

class AppBrandVideoViewControlBar$1 implements OnClickListener {
    final /* synthetic */ AppBrandVideoViewControlBar$a jtb;
    final /* synthetic */ AppBrandVideoViewControlBar jtc;

    AppBrandVideoViewControlBar$1(AppBrandVideoViewControlBar appBrandVideoViewControlBar, AppBrandVideoViewControlBar$a appBrandVideoViewControlBar$a) {
        this.jtc = appBrandVideoViewControlBar;
        this.jtb = appBrandVideoViewControlBar$a;
    }

    public final void onClick(View view) {
        AppBrandVideoViewControlBar.a(this.jtc);
        if (this.jtb != null) {
            this.jtb.da(AppBrandVideoViewControlBar.b(this.jtc));
        }
    }
}
