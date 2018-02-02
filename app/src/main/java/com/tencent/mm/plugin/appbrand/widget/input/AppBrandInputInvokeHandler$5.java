package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class AppBrandInputInvokeHandler$5 implements OnEditorActionListener {
    final /* synthetic */ AppBrandInputInvokeHandler jXc;
    final /* synthetic */ int jXd;

    AppBrandInputInvokeHandler$5(AppBrandInputInvokeHandler appBrandInputInvokeHandler, int i) {
        this.jXc = appBrandInputInvokeHandler;
        this.jXd = i;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != this.jXd) {
            return false;
        }
        AppBrandInputInvokeHandler.access$902$2c1acb32(this.jXc, AppBrandInputInvokeHandler$c.jXf);
        AppBrandInputInvokeHandler.access$1000(this.jXc);
        AppBrandInputInvokeHandler.access$902$2c1acb32(this.jXc, 0);
        return true;
    }
}
