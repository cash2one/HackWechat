package com.tencent.mm.plugin.favorite.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class c$2 implements OnClickListener {
    final /* synthetic */ c mve;

    c$2(c cVar) {
        this.mve = cVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.FavHeaderView", "click retry item");
        List<f> aIe = h.getFavItemInfoStorage().aIe();
        if (aIe != null && !aIe.isEmpty()) {
            for (f fVar : aIe) {
                if (fVar.aHM()) {
                    j.n(fVar);
                } else {
                    x.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", new Object[]{Integer.valueOf(fVar.field_id)});
                }
            }
            c.c(this.mve).setVisibility(8);
            c.d(this.mve).setVisibility(8);
        }
    }
}
