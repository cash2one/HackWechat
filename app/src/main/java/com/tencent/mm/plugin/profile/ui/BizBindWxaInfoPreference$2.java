package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.e;

class BizBindWxaInfoPreference$2 implements OnClickListener {
    final /* synthetic */ BizBindWxaInfoPreference phi;

    BizBindWxaInfoPreference$2(BizBindWxaInfoPreference bizBindWxaInfoPreference) {
        this.phi = bizBindWxaInfoPreference;
    }

    public final void onClick(View view) {
        ((e) g.h(e.class)).a(this.phi.mContext, BizBindWxaInfoPreference.a(this.phi).field_username, BizBindWxaInfoPreference.a(this.phi).field_appId, BizBindWxaInfoPreference.b(this.phi));
    }
}
