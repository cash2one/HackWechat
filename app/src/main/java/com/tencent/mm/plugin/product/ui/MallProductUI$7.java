package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

class MallProductUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ MallProductUI phb;

    MallProductUI$7(MallProductUI mallProductUI) {
        this.phb = mallProductUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String[] stringArray = this.phb.getResources().getStringArray(b.uas);
        List arrayList = new ArrayList();
        for (Object add : stringArray) {
            arrayList.add(add);
        }
        boolean z = (this.phb.pfH.biP().pfD & 1) > 0;
        x.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = " + z);
        if (z) {
            arrayList.add(this.phb.getString(i.uLB));
        }
        h.a(this.phb.mController.xIM, null, (String[]) arrayList.toArray(new String[arrayList.size()]), null, false, new 1(this));
        return true;
    }
}
