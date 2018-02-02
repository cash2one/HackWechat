package com.tencent.mm.plugin.order.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.order.c.b;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem$Skus;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.wallet_core.ui.e;

class MallOrderProductListUI$a extends BaseAdapter {
    final /* synthetic */ MallOrderProductListUI pci;

    private MallOrderProductListUI$a(MallOrderProductListUI mallOrderProductListUI) {
        this.pci = mallOrderProductListUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return uy(i);
    }

    public final int getCount() {
        return MallOrderProductListUI.a(this.pci).size();
    }

    private ProductSectionItem uy(int i) {
        return (ProductSectionItem) MallOrderProductListUI.a(this.pci).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.pci, g.uDf, null);
            MallOrderProductListUI$b mallOrderProductListUI$b = new MallOrderProductListUI$b(this.pci);
            mallOrderProductListUI$b.kUM = (ImageView) view.findViewById(a$f.ulo);
            mallOrderProductListUI$b.pcj = (TextView) view.findViewById(a$f.uln);
            mallOrderProductListUI$b.pck = (TextView) view.findViewById(a$f.ulk);
            mallOrderProductListUI$b.pcl = (TextView) view.findViewById(a$f.ulp);
            mallOrderProductListUI$b.pcm = (TextView) view.findViewById(a$f.ull);
            mallOrderProductListUI$b.pcn = (TextView) view.findViewById(a$f.ulq);
            view.setTag(mallOrderProductListUI$b);
            aVar = mallOrderProductListUI$b;
        } else {
            MallOrderProductListUI$b mallOrderProductListUI$b2 = (MallOrderProductListUI$b) view.getTag();
        }
        ProductSectionItem uy = uy(i);
        aVar.kJP = uy.iconUrl;
        if (TextUtils.isEmpty(aVar.kJP) || !e.aaz(aVar.kJP)) {
            aVar.kUM.setImageResource(h.uGA);
        } else {
            aVar.kUM.setImageBitmap(j.a(new b(aVar.kJP)));
        }
        aVar.pcj.setText(uy.name);
        aVar.pck.setText(ProductSectionItem$Skus.bk(uy.pbM));
        aVar.pcl.setText(uy.pbN);
        aVar.pcm.setText("+" + uy.count);
        j.a(aVar);
        aVar.pcn.setVisibility(8);
        return view;
    }
}
