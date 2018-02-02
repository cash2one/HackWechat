package com.tencent.mm.plugin.favorite.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements OnClickListener {
    final /* synthetic */ a mxN;

    a$2(a aVar) {
        this.mxN = aVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.FavBaseListItem", "manual restart upload");
        if (view.getTag() instanceof f) {
            j.n((f) view.getTag());
        }
    }
}
