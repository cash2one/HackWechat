package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;

class r$1 implements OnClickListener {
    final /* synthetic */ l rku;
    final /* synthetic */ r rkv;

    r$1(r rVar, l lVar) {
        this.rkv = rVar;
        this.rku = lVar;
    }

    public final void onClick(View view) {
        this.rkv.bxk();
        f aZ = g.aZ(this.rku.rgh, true);
        if (aZ == null || TextUtils.isEmpty(aZ.field_packageName) || !this.rkv.r(view.getContext(), aZ.field_packageName, g.a(view.getContext(), aZ, null))) {
            this.rkv.bxm();
        }
    }
}
