package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;

class c$b extends android.support.v7.widget.RecyclerView.a<a> {
    final /* synthetic */ c riI;

    class a extends t {
        private f riJ;
        final /* synthetic */ c$b riK;

        public a(c$b com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_component_c_b, View view, f fVar) {
            this.riK = com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_component_c_b;
            super(view);
            this.riJ = fVar;
        }
    }

    private c$b(c cVar) {
        this.riI = cVar;
    }

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        f fVar = new f(viewGroup.getContext(), viewGroup);
        return new a(this, fVar.getView(), fVar);
    }

    public final /* synthetic */ void a(t tVar, int i) {
        a aVar = (a) tVar;
        s sVar = (s) c.b(this.riI).rgv.get(i);
        if (sVar instanceof p) {
            aVar.riJ.a((p) sVar);
            if (!aVar.riJ.rjb) {
                this.riI.riG.add(Integer.valueOf(i));
            }
            View view = aVar.riJ.contentView;
            int paddingRight = view.getPaddingRight();
            if (i != c.b(this.riI).rgv.size() - 1) {
                paddingRight += this.riI.riB;
            }
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + this.riI.riB, paddingRight, view.getPaddingBottom() + this.riI.riB);
        }
    }

    public final int getItemCount() {
        return c.b(this.riI).rgv.size();
    }
}
