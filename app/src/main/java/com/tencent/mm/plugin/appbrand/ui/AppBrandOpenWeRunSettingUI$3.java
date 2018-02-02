package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;

class AppBrandOpenWeRunSettingUI$3 implements a {
    final /* synthetic */ AppBrandOpenWeRunSettingUI jLg;

    AppBrandOpenWeRunSettingUI$3(AppBrandOpenWeRunSettingUI appBrandOpenWeRunSettingUI) {
        this.jLg = appBrandOpenWeRunSettingUI;
    }

    public final void v(String str, boolean z) {
        x.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", Boolean.valueOf(z), str);
        AppBrandOpenWeRunSettingUI.a(this.jLg, ((h) g.h(h.class)).EY().WO("gh_43f2581f6fd6"));
        AppBrandOpenWeRunSettingUI.a(this.jLg);
        AppBrandOpenWeRunSettingUI.b(this.jLg).dismiss();
    }
}
