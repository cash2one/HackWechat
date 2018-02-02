package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class IPCallShareCouponUI$15 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponUI nMZ;

    IPCallShareCouponUI$15(IPCallShareCouponUI iPCallShareCouponUI) {
        this.nMZ = iPCallShareCouponUI;
    }

    public final void onClick(View view) {
        ar.Hg();
        if (((Boolean) c.CU().get(a.xpo, Boolean.valueOf(false))).booleanValue()) {
            i.N(3, -1, -1);
        }
        ar.Hg();
        c.CU().a(a.xpo, Boolean.valueOf(false));
        IPCallShareCouponUI.a(this.nMZ).setVisibility(8);
        Intent intent = new Intent();
        intent.setClass(this.nMZ.mController.xIM, IPCallRechargeUI.class);
        this.nMZ.startActivity(intent);
    }
}
