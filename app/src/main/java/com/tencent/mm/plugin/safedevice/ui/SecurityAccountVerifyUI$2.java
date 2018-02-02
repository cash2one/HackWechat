package com.tencent.mm.plugin.safedevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;

class SecurityAccountVerifyUI$2 implements a {
    final /* synthetic */ SecurityAccountVerifyUI pRZ;

    SecurityAccountVerifyUI$2(SecurityAccountVerifyUI securityAccountVerifyUI) {
        this.pRZ = securityAccountVerifyUI;
    }

    public final boolean uF() {
        int intValue = ((Integer) SecurityAccountVerifyUI.a(this.pRZ).getTag()).intValue();
        if (intValue <= 1) {
            SecurityAccountVerifyUI.b(this.pRZ).setVisibility(0);
            SecurityAccountVerifyUI.a(this.pRZ).setVisibility(8);
            return false;
        }
        SecurityAccountVerifyUI.a(this.pRZ).setTag(Integer.valueOf(intValue - 1));
        SecurityAccountVerifyUI.a(this.pRZ).setText(this.pRZ.getString(R.l.eGV, new Object[]{Integer.valueOf(intValue)}));
        if (SecurityAccountVerifyUI.a(this.pRZ).getVisibility() != 0) {
            SecurityAccountVerifyUI.a(this.pRZ).setVisibility(0);
        }
        return true;
    }
}
