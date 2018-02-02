package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AppBrandSmileyGrid$1 implements OnItemClickListener {
    final /* synthetic */ AppBrandSmileyGrid kaW;

    AppBrandSmileyGrid$1(AppBrandSmileyGrid appBrandSmileyGrid) {
        this.kaW = appBrandSmileyGrid;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == AppBrandSmileyGrid.a(this.kaW).getCount() - 1) {
            if (AppBrandSmileyGrid.b(this.kaW).kbe != null) {
                AppBrandSmileyGrid.b(this.kaW).kbe.amZ();
            }
        } else if ((AppBrandSmileyGrid.c(this.kaW) * (AppBrandSmileyGrid.d(this.kaW) - 1)) + i < AppBrandSmileyGrid.e(this.kaW)) {
            int c = (AppBrandSmileyGrid.c(this.kaW) * (AppBrandSmileyGrid.d(this.kaW) - 1)) + i;
            if (AppBrandSmileyGrid.b(this.kaW).kbe != null) {
                AppBrandSmileyGrid.b(this.kaW).kbe.append(AppBrandSmileyGrid.b(this.kaW).ank().mh(c));
            }
        }
    }
}
