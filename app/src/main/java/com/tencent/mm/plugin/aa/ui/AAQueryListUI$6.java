package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.j.d;
import java.util.List;

class AAQueryListUI$6 implements a<Object, d<List, String, Boolean>> {
    final /* synthetic */ AAQueryListUI iih;
    final /* synthetic */ boolean iij;

    AAQueryListUI$6(AAQueryListUI aAQueryListUI, boolean z) {
        this.iih = aAQueryListUI;
        this.iij = z;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        List list = (List) dVar.get(0);
        x.i("MicroMsg.AAQueryListUI", "record list size: %s, h5Url: %s, lastFlag: %s", new Object[]{Integer.valueOf(list.size()), dVar.get(1), dVar.get(2)});
        if (!bh.ov((String) dVar.get(1))) {
            AAQueryListUI.a(this.iih, (String) dVar.get(1));
        }
        if (this.iij) {
            AAQueryListUI.f(this.iih).WP();
        }
        b f = AAQueryListUI.f(this.iih);
        x.i("MicroMsg.AAQueryListAdapter", "addNewRecord: %s", new Object[]{list});
        if (list != null && list.size() > 0) {
            x.i("MicroMsg.AAQueryListAdapter", "addNewRecord size: %s", new Object[]{Integer.valueOf(list.size())});
            f.dataList.addAll(list);
            f.notifyDataSetChanged();
        }
        if (AAQueryListUI.g(this.iih) != null) {
            AAQueryListUI.g(this.iih).dismiss();
            AAQueryListUI.h(this.iih);
        }
        if (AAQueryListUI.a(this.iih).getVisibility() != 0) {
            AAQueryListUI.a(this.iih).setVisibility(0);
        }
        AAQueryListUI.i(this.iih);
        if (!((Boolean) dVar.get(2)).booleanValue()) {
            AAQueryListUI.j(this.iih);
        }
        if (AAQueryListUI.a(this.iih).getFooterViewsCount() > 0) {
            AAQueryListUI.a(this.iih).removeFooterView(AAQueryListUI.d(this.iih));
        }
        if (AAQueryListUI.b(this.iih)) {
            AAQueryListUI.k(this.iih);
            if (AAQueryListUI.l(this.iih).getVisibility() == 0) {
                AAQueryListUI.a(this.iih).addFooterView(AAQueryListUI.l(this.iih), null, false);
            }
        }
        return zBS;
    }
}
