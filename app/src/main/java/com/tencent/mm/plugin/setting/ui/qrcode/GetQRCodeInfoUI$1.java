package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import com.tencent.mm.network.e;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd.a;

class GetQRCodeInfoUI$1 implements a {
    final /* synthetic */ GetQRCodeInfoUI qgD;

    GetQRCodeInfoUI$1(GetQRCodeInfoUI getQRCodeInfoUI) {
        this.qgD = getQRCodeInfoUI;
    }

    public final void a(e eVar) {
        if (eVar == null) {
            this.qgD.finish();
        } else if (!ar.Hj() || ar.Cs()) {
            com.tencent.mm.plugin.setting.a.ifs.s(new Intent(), this.qgD);
            this.qgD.finish();
        } else {
            GetQRCodeInfoUI.a(this.qgD, this.qgD.getIntent().getDataString());
        }
    }
}
