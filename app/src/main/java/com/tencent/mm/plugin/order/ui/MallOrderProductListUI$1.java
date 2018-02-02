package com.tencent.mm.plugin.order.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;

class MallOrderProductListUI$1 implements OnItemClickListener {
    final /* synthetic */ MallOrderProductListUI pci;

    MallOrderProductListUI$1(MallOrderProductListUI mallOrderProductListUI) {
        this.pci = mallOrderProductListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ProductSectionItem productSectionItem = (ProductSectionItem) MallOrderProductListUI.a(this.pci).get(i);
        if (productSectionItem != null) {
            MallOrderProductListUI.a(this.pci, productSectionItem);
            c.a(Boolean.valueOf(false), MallOrderProductListUI.b(this.pci), MallOrderProductListUI.c(this.pci), productSectionItem.name, productSectionItem.pbO);
        }
    }
}
