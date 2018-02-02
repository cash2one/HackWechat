package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.base.preference.Preference;

class AppBrandAuthorizeUI$9 implements Runnable {
    final /* synthetic */ boolean jEm;
    final /* synthetic */ AppBrandAuthorizeUI jKs;

    AppBrandAuthorizeUI$9(AppBrandAuthorizeUI appBrandAuthorizeUI, boolean z) {
        this.jKs = appBrandAuthorizeUI;
        this.jEm = z;
    }

    public final void run() {
        Preference preference = new Preference(this.jKs);
        preference.yjI = false;
        if (this.jEm) {
            preference.setLayoutResource(h.iwJ);
            preference.setTitle(this.jKs.getString(j.iyu, new Object[]{AppBrandAuthorizeUI.e(this.jKs).fpL}));
        } else {
            preference.setLayoutResource(h.iwK);
            preference.setTitle(this.jKs.getString(j.iyv, new Object[]{AppBrandAuthorizeUI.e(this.jKs).fpL}));
        }
        this.jKs.jKn.a(preference);
        this.jKs.jKn.notifyDataSetChanged();
    }
}
