package com.tencent.mm.ui.account.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.ui.account.RegByMobileVoiceVerifyUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.8;
import com.tencent.mm.ui.base.p.d;

class MobileVerifyUI$8$2 implements d {
    final /* synthetic */ 8 xVn;

    MobileVerifyUI$8$2(8 8) {
        this.xVn = 8;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                MobileVerifyUI.g(this.xVn.xVi);
                return;
            case 1:
                this.xVn.xVi.aWs();
                if (MobileVerifyUI.f(this.xVn.xVi) == 2) {
                    b.oH("R200_500");
                } else if (MobileVerifyUI.f(this.xVn.xVi) == 3) {
                    b.oH("F200_300");
                }
                Intent intent = new Intent(this.xVn.xVi, RegByMobileVoiceVerifyUI.class);
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", this.xVn.xVi.fAf);
                bundle.putInt("voice_verify_type", MobileVerifyUI.h(this.xVn.xVi));
                intent.putExtras(bundle);
                this.xVn.xVi.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
