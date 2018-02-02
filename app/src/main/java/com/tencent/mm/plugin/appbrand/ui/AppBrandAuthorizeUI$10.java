package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.protocal.c.du;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

class AppBrandAuthorizeUI$10 implements Runnable {
    final /* synthetic */ AppBrandAuthorizeUI jKs;
    final /* synthetic */ List jKw;

    AppBrandAuthorizeUI$10(AppBrandAuthorizeUI appBrandAuthorizeUI, List list) {
        this.jKs = appBrandAuthorizeUI;
        this.jKw = list;
    }

    public final void run() {
        x.d("MicroMsg.AppBrandAuthorizeUI", "initAuthItem authItems.size = %d", new Object[]{Integer.valueOf(this.jKw.size())});
        for (du duVar : this.jKw) {
            boolean z;
            Preference checkBoxPreference = new CheckBoxPreference(this.jKs);
            checkBoxPreference.yjI = false;
            checkBoxPreference.setKey(duVar.scope);
            checkBoxPreference.setTitle(duVar.vIX);
            if (duVar.state == 1) {
                z = true;
            } else {
                z = false;
            }
            checkBoxPreference.tSw = z;
            this.jKs.jKn.a(checkBoxPreference);
        }
        this.jKs.jKn.notifyDataSetChanged();
        x.d("MicroMsg.AppBrandAuthorizeUI", "initAuthItem finish");
    }
}
