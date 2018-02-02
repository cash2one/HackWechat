package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.ui.base.p.a;

class i$1 implements a {
    final /* synthetic */ i nai;

    i$1(i iVar) {
        this.nai = iVar;
    }

    public final void a(ImageView imageView, MenuItem menuItem) {
        if (i.h(menuItem)) {
            imageView.setVisibility(8);
        }
    }
}
