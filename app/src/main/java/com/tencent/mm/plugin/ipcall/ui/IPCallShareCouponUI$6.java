package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;

class IPCallShareCouponUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallShareCouponUI nMZ;

    IPCallShareCouponUI$6(IPCallShareCouponUI iPCallShareCouponUI) {
        this.nMZ = iPCallShareCouponUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        boolean z;
        String[] strArr;
        aid aUQ = c.aUQ();
        if (!(aUQ == null || bh.ov(aUQ.wpB))) {
            if (g.zY().getInt("WCOWebPayListSwitch", 0) > 0) {
                z = true;
                if (z) {
                    strArr = new String[]{this.nMZ.getString(R.l.eqJ), this.nMZ.getString(R.l.equ)};
                    IPCallShareCouponUI.a(this.nMZ, false);
                } else {
                    strArr = new String[]{this.nMZ.getString(R.l.erv), this.nMZ.getString(R.l.eqJ), this.nMZ.getString(R.l.equ)};
                    IPCallShareCouponUI.a(this.nMZ, true);
                }
                h.a(this.nMZ.mController.xIM, null, strArr, null, false, new 1(this));
                return true;
            }
        }
        z = false;
        if (z) {
            strArr = new String[]{this.nMZ.getString(R.l.eqJ), this.nMZ.getString(R.l.equ)};
            IPCallShareCouponUI.a(this.nMZ, false);
        } else {
            strArr = new String[]{this.nMZ.getString(R.l.erv), this.nMZ.getString(R.l.eqJ), this.nMZ.getString(R.l.equ)};
            IPCallShareCouponUI.a(this.nMZ, true);
        }
        h.a(this.nMZ.mController.xIM, null, strArr, null, false, new 1(this));
        return true;
    }
}
