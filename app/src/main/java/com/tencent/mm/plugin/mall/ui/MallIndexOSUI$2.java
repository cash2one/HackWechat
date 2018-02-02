package com.tencent.mm.plugin.mall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bxa;
import com.tencent.mm.protocal.c.bxb;
import com.tencent.mm.ui.base.h;

class MallIndexOSUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ MallIndexOSUI omo;

    MallIndexOSUI$2(MallIndexOSUI mallIndexOSUI) {
        this.omo = mallIndexOSUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String[] strArr;
        bxa com_tencent_mm_protocal_c_bxa = MallIndexOSUI.a(this.omo).sPO;
        boolean z = MallIndexOSUI.a(this.omo).sPP;
        if (z) {
            strArr = new String[(com_tencent_mm_protocal_c_bxa.wiJ.size() + 1)];
            strArr[com_tencent_mm_protocal_c_bxa.wiJ.size()] = this.omo.getString(i.uRZ);
        } else {
            strArr = new String[com_tencent_mm_protocal_c_bxa.wiJ.size()];
        }
        for (int i = 0; i < com_tencent_mm_protocal_c_bxa.wiJ.size(); i++) {
            strArr[i] = n.a(((bxb) com_tencent_mm_protocal_c_bxa.wiJ.get(i)).wXL);
        }
        h.a(this.omo.mController.xIM, null, strArr, null, false, new 1(this, com_tencent_mm_protocal_c_bxa, z));
        return true;
    }
}
