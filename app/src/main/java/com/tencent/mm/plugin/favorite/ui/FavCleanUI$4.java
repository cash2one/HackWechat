package com.tencent.mm.plugin.favorite.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class FavCleanUI$4 implements OnItemClickListener {
    final /* synthetic */ FavCleanUI msh;

    FavCleanUI$4(FavCleanUI favCleanUI) {
        this.msh = favCleanUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (FavCleanUI.e(this.msh) != null) {
            FavCleanUI.e(this.msh).onItemClick(adapterView, view, i, j);
        }
    }
}
