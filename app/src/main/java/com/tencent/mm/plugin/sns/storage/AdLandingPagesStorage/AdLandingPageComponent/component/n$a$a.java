package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.TextUtils;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;

class n$a$a extends b {
    final /* synthetic */ a rjT;

    n$a$a(a aVar) {
        this.rjT = aVar;
    }

    public final void enter() {
        super.enter();
        this.rjT.rjH.rjC.setVisibility(8);
        this.rjT.rjH.rjB.setEnabled(false);
        this.rjT.rjH.rjB.setText(!TextUtils.isEmpty(n.b(this.rjT.rjH).rfJ) ? n.b(this.rjT.rjH).rfJ : "暂不支持安卓手机");
        this.rjT.rjH.rjB.setVisibility(0);
    }
}
