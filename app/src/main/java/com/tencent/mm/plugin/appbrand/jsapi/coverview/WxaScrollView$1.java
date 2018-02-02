package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.widget.ScrollView;

class WxaScrollView$1 extends ScrollView {
    final /* synthetic */ WxaScrollView jjp;

    WxaScrollView$1(WxaScrollView wxaScrollView, Context context) {
        this.jjp = wxaScrollView;
        super(context);
    }

    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (WxaScrollView.a(this.jjp) != null) {
            WxaScrollView.a(this.jjp).h(this.jjp, i, i2);
        }
    }
}
