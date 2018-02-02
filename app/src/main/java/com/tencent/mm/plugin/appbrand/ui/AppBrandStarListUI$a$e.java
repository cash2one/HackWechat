package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

final class AppBrandStarListUI$a$e extends a<f> {
    final /* synthetic */ AppBrandStarListUI.a jMg;

    AppBrandStarListUI$a$e(AppBrandStarListUI.a aVar) {
        this.jMg = aVar;
    }

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        return new f(this.jMg, LayoutInflater.from(viewGroup.getContext()).inflate(h.ixr, viewGroup, false));
    }

    public final /* synthetic */ void a(t tVar, int i) {
        float f = 1.0f;
        f fVar = (f) tVar;
        i iVar = (i) AppBrandStarListUI.a.f(this.jMg).get(i);
        fVar.jMu = iVar;
        fVar.jMw.setText(iVar.appName);
        b.Jj().a(fVar.jMv, iVar.iJJ, com.tencent.mm.modelappbrand.a.a.Ji(), com.tencent.mm.modelappbrand.a.f.hkr);
        fVar.jMy.setVisibility(AppBrandStarListUI.a.e(fVar.jMg) ? 0 : 8);
        fVar.jMv.setScaleX(AppBrandStarListUI.a.e(fVar.jMg) ? 1.0f : 0.9f);
        ImageView imageView = fVar.jMv;
        if (!AppBrandStarListUI.a.e(fVar.jMg)) {
            f = 0.9f;
        }
        imageView.setScaleY(f);
        CharSequence ju = com.tencent.mm.plugin.appbrand.appcache.a.ju(iVar.iGA);
        if (bh.ov(ju)) {
            fVar.jMx.setVisibility(8);
            return;
        }
        fVar.jMx.setText(ju);
        fVar.jMx.setVisibility(0);
    }

    public final /* synthetic */ void a(t tVar, int i, List list) {
        f fVar = (f) tVar;
        if (list == null || list.size() != 1 || (!"enter_delete_mode_tag".equals(list.get(0)) && !"exit_delete_mode_tag".equals(list.get(0)))) {
            super.a(fVar, i, list);
        }
    }

    public final int getItemCount() {
        return AppBrandStarListUI.a.f(this.jMg).size();
    }
}
