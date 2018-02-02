package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;

class PhoneRechargeUI$18 implements OnClickListener {
    final /* synthetic */ PhoneRechargeUI pDm;

    PhoneRechargeUI$18(PhoneRechargeUI phoneRechargeUI) {
        this.pDm = phoneRechargeUI;
    }

    public final void onClick(View view) {
        if (PhoneRechargeUI.f(this.pDm) != null && !bh.ov(PhoneRechargeUI.f(this.pDm).url)) {
            f.eB(6, 1);
            try {
                PhoneRechargeUI.d(this.pDm, URLDecoder.decode(PhoneRechargeUI.f(this.pDm).url, ProtocolPackage.ServerEncoding));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
            }
        }
    }
}
