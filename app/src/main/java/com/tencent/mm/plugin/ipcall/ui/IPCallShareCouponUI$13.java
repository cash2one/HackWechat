package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class IPCallShareCouponUI$13 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponUI nMZ;

    IPCallShareCouponUI$13(IPCallShareCouponUI iPCallShareCouponUI) {
        this.nMZ = iPCallShareCouponUI;
    }

    public final void onClick(View view) {
        ar.Hg();
        if (((Boolean) c.CU().get(a.xpw, Boolean.valueOf(false))).booleanValue()) {
            ar.Hg();
            i.N(4, -1, ((Integer) c.CU().get(a.xpx, Integer.valueOf(-1))).intValue());
        }
        ar.Hg();
        c.CU().a(a.xpx, Integer.valueOf(-1));
        ar.Hg();
        c.CU().a(a.xpw, Boolean.valueOf(false));
        IPCallShareCouponUI.g(this.nMZ).setVisibility(8);
        Intent intent = new Intent();
        intent.setClass(this.nMZ.mController.xIM, IPCallMsgUI.class);
        this.nMZ.mController.xIM.startActivity(intent);
    }
}
