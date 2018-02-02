package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class ProductFurtherInfoUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ProductFurtherInfoUI pVB;

    ProductFurtherInfoUI$2(ProductFurtherInfoUI productFurtherInfoUI) {
        this.pVB = productFurtherInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(this.pVB.getString(R.l.eHZ));
        linkedList2.add(Integer.valueOf(0));
        h.a(this.pVB.mController.xIM, "", linkedList, linkedList2, "", false, new 1(this));
        return true;
    }
}
