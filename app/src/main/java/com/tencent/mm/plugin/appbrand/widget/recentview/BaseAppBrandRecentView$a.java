package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.view.ViewGroup;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.plugin.appbrand.widget.k.c;
import com.tencent.mm.plugin.appbrand.widget.k.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.v;

protected class BaseAppBrandRecentView$a extends RecyclerView$a<b> {
    a kfv;
    final /* synthetic */ BaseAppBrandRecentView kfw;

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        return new b(this.kfw, v.fv(BaseAppBrandRecentView.a(this.kfw)).inflate(c.jVh, viewGroup, false));
    }

    public final /* synthetic */ void a(t tVar, int i) {
        b bVar = (b) tVar;
        bVar.kfy.setVisibility(8);
        if (i < this.kfw.anY().size()) {
            bVar.VU.setVisibility(0);
            a aVar = (a) this.kfw.anY().get(i);
            aVar.position = i;
            bVar.VU.setTag(aVar);
            if (!(aVar.kfb == null || bh.ov(com.tencent.mm.plugin.appbrand.appcache.a.ju(aVar.kfb.iKd)))) {
                bVar.kfy.setVisibility(0);
                bVar.kfy.setText(com.tencent.mm.plugin.appbrand.appcache.a.ju(aVar.kfb.iKd));
            }
            this.kfw.a(bVar, aVar);
            return;
        }
        bVar.VU.setVisibility(4);
    }

    private BaseAppBrandRecentView$a(BaseAppBrandRecentView baseAppBrandRecentView) {
        this.kfw = baseAppBrandRecentView;
        this.kfv = new a();
        this.kfv.hDP = d.bBB;
    }

    public final int getItemCount() {
        if (this.kfw.anY().size() % 4 != 0) {
            return this.kfw.anY().size() + (4 - (this.kfw.anY().size() % 4));
        }
        return this.kfw.anY().size();
    }
}
