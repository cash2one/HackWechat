package com.tencent.mm.plugin.appbrand.ui.recents;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;

final class a$f extends g {
    final /* synthetic */ a jPj;

    private a$f(a aVar) {
        this.jPj = aVar;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        rect.left = 0;
        rect.right = 0;
        rect.bottom = 0;
        rect.top = 0;
        if (recyclerView instanceof MRecyclerView) {
            RecyclerView$t aP = recyclerView.aP(view);
            if (aP instanceof d) {
                j.s(((d) aP).iiS, ((MRecyclerView) recyclerView).G(aP) == a.b(this.jPj).getItemCount() + -1 ? 8 : 0);
            }
        }
    }
}
