package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.v;

class AppBrandSmileyGrid$a extends BaseAdapter {
    final /* synthetic */ AppBrandSmileyGrid kaW;

    private AppBrandSmileyGrid$a(AppBrandSmileyGrid appBrandSmileyGrid) {
        this.kaW = appBrandSmileyGrid;
    }

    public final int getCount() {
        return AppBrandSmileyGrid.d(this.kaW);
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppBrandSmileyGrid$b appBrandSmileyGrid$b;
        if (view == null || view.getTag() == null) {
            view = v.fv(this.kaW.getContext()).inflate(h.ixD, null);
            view.setLayoutParams(new LayoutParams(-1, ((AppBrandSmileyGrid.b(this.kaW).kbf - a.aa(this.kaW.getContext(), e.bvz)) - a.aa(this.kaW.getContext(), e.bxh)) / AppBrandSmileyGrid.f(this.kaW)));
            appBrandSmileyGrid$b = new AppBrandSmileyGrid$b(view);
            view.setTag(appBrandSmileyGrid$b);
        } else {
            appBrandSmileyGrid$b = (AppBrandSmileyGrid$b) view.getTag();
        }
        if (i == getCount() - 1) {
            appBrandSmileyGrid$b.jCP.setImageResource(f.bBE);
            appBrandSmileyGrid$b.jCP.setContentDescription(this.kaW.getContext().getString(j.dYq));
        } else {
            int d = ((AppBrandSmileyGrid.d(this.kaW) - 1) * AppBrandSmileyGrid.c(this.kaW)) + i;
            if (d > AppBrandSmileyGrid.e(this.kaW) - 1) {
                appBrandSmileyGrid$b.jCP.setImageDrawable(null);
            } else {
                appBrandSmileyGrid$b.jCP.setImageDrawable(AppBrandSmileyGrid.b(this.kaW).ank().mf(d));
            }
        }
        return view;
    }
}
