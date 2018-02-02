package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.c.du;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

class AppBrandAuthorizeUI$5 implements OnClickListener {
    final /* synthetic */ AppBrandAuthorizeUI jKs;
    final /* synthetic */ du jKt;
    final /* synthetic */ Preference jKu;
    final /* synthetic */ f jKv;

    AppBrandAuthorizeUI$5(AppBrandAuthorizeUI appBrandAuthorizeUI, du duVar, Preference preference, f fVar) {
        this.jKs = appBrandAuthorizeUI;
        this.jKt = duVar;
        this.jKu = preference;
        this.jKv = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state open");
        this.jKt.state = 1;
        ((CheckBoxPreference) this.jKu).tSw = true;
        this.jKv.notifyDataSetChanged();
    }
}
