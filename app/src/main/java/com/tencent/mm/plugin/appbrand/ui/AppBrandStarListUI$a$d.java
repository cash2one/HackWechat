package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a;

final class AppBrandStarListUI$a$d extends g {
    final /* synthetic */ a jMg;

    AppBrandStarListUI$a$d(a aVar) {
        this.jMg = aVar;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        rect.top = 0;
        rect.right = 0;
        rect.left = 0;
        if (recyclerView.aP(view).ge() >= (a.c(this.jMg).getItemCount() / a.d(this.jMg).Rw) * a.d(this.jMg).Rw) {
            rect.bottom = 0;
        } else {
            rect.bottom = this.jMg.getResources().getDimensionPixelSize(e.isP);
        }
    }
}
