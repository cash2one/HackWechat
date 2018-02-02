package com.tencent.mm.plugin.recharge.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;

class PhoneRechargeUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ PhoneRechargeUI pDm;

    PhoneRechargeUI$2(PhoneRechargeUI phoneRechargeUI) {
        this.pDm = phoneRechargeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        try {
            PhoneRechargeUI.d(this.pDm, URLDecoder.decode(PhoneRechargeUI.i(this.pDm).url, ProtocolPackage.ServerEncoding));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
        }
        return false;
    }
}
