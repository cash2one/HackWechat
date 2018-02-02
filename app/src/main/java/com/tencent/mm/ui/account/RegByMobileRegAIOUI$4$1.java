package com.tencent.mm.ui.account;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.account.RegByMobileRegAIOUI.4;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c.a;

class RegByMobileRegAIOUI$4$1 implements a {
    final /* synthetic */ 4 xQL;

    RegByMobileRegAIOUI$4$1(4 4) {
        this.xQL = 4;
    }

    public final void uY(String str) {
        RegByMobileRegAIOUI.a(this.xQL.xQK, ao.Vk(RegByMobileRegAIOUI.c(this.xQL.xQK).getText().toString()));
        RegByMobileRegAIOUI.b(this.xQL.xQK, ao.Vm(RegByMobileRegAIOUI.d(this.xQL.xQK)));
        String str2 = RegByMobileRegAIOUI.e(this.xQL.xQK) + RegByMobileRegAIOUI.f(this.xQL.xQK);
        this.xQL.xQK.aWs();
        if (RegByMobileRegAIOUI.g(this.xQL.xQK)) {
            Intent intent = new Intent(this.xQL.xQK, ShowAgreementsUI.class);
            intent.putExtra("agreement_type", 0);
            if (ao.Vm(RegByMobileRegAIOUI.d(this.xQL.xQK)).equals("+86")) {
                intent.putExtra("country_code", "CN");
            } else {
                intent.putExtra("country_code", "US");
            }
            this.xQL.xQK.startActivityForResult(intent, 30847);
            return;
        }
        RegByMobileRegAIOUI.c(this.xQL.xQK, str2);
    }

    public final void amI() {
        h.h(this.xQL.xQK, R.l.eLR, R.l.eLT);
    }

    public final void aem() {
        h.h(this.xQL.xQK, R.l.eLS, R.l.eLT);
    }
}
