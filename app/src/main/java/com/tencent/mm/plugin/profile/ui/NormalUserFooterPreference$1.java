package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.e;
import com.tencent.mm.sdk.e.k;

class NormalUserFooterPreference$1 extends k<e, String> {
    final /* synthetic */ NormalUserFooterPreference pkA;

    NormalUserFooterPreference$1(NormalUserFooterPreference normalUserFooterPreference) {
        this.pkA = normalUserFooterPreference;
    }

    public final /* synthetic */ void a(Object obj, Looper looper) {
        e eVar = (e) obj;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        super.a(eVar, looper);
    }

    protected final /* synthetic */ void p(Object obj, Object obj2) {
        e eVar = (e) obj;
        String str = (String) obj2;
        if (str.equals("show_btn")) {
            eVar.au(NormalUserFooterPreference.a(this.pkA).field_username, true);
        } else if (str.equals("hide_btn")) {
            eVar.au(NormalUserFooterPreference.a(this.pkA).field_username, false);
        }
    }
}
