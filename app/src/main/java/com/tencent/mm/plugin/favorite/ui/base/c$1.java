package com.tencent.mm.plugin.favorite.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements OnClickListener {
    final /* synthetic */ c mve;

    c$1(c cVar) {
        this.mve = cVar;
    }

    public final void onClick(View view) {
        if (c.a(this.mve) == 1 || c.a(this.mve) == 3) {
            x.i("MicroMsg.FavHeaderView", "click clear fav item");
            if (c.b(this.mve) != null) {
                c.b(this.mve).aJn();
            }
        }
    }
}
