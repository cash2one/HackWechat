package com.tencent.mm.plugin.brandservice.ui.base;

import android.view.MenuItem;
import com.tencent.mm.ag.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class BrandServiceSortView$3 implements d {
    final /* synthetic */ BrandServiceSortView kHq;

    BrandServiceSortView$3(BrandServiceSortView brandServiceSortView) {
        this.kHq = brandServiceSortView;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (bh.ov(BrandServiceSortView.d(this.kHq))) {
            x.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
        } else if (menuItem.getItemId() == 0) {
            x.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", new Object[]{Integer.valueOf(i)});
            ar.Hg();
            com.tencent.mm.storage.x WO = c.EY().WO(BrandServiceSortView.d(this.kHq));
            BrandServiceSortView.a(this.kHq, f.jS(BrandServiceSortView.d(this.kHq)), this.kHq.getContext(), WO, menuItem.getGroupId());
        }
    }
}
