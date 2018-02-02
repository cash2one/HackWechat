package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

class BizBindWxaInfoPreference$1 implements OnClickListener {
    final /* synthetic */ BizBindWxaInfoPreference phi;

    BizBindWxaInfoPreference$1(BizBindWxaInfoPreference bizBindWxaInfoPreference) {
        this.phi = bizBindWxaInfoPreference;
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof String)) {
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1020;
            appBrandStatObject.fnp = BizBindWxaInfoPreference.a(this.phi).field_username;
            ((c) g.h(c.class)).a(this.phi.mContext, (String) tag, null, 0, 0, null, appBrandStatObject, BizBindWxaInfoPreference.a(this.phi).field_appId);
        }
    }
}
