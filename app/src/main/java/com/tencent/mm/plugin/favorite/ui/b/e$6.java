package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.ui.base.i$a.a;

class e$6 implements a {
    final /* synthetic */ ux mxZ;
    final /* synthetic */ Context val$context;

    e$6(ux uxVar, Context context) {
        this.mxZ = uxVar;
        this.val$context = context;
    }

    public final void aJL() {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 1);
        intent.putExtra("kwebmap_slat", this.mxZ.lat);
        intent.putExtra("kwebmap_lng", this.mxZ.lng);
        intent.putExtra("Kwebmap_locaion", this.mxZ.label);
        intent.putExtra("kShowshare", false);
        d.b(this.val$context, "location", ".ui.RedirectUI", intent);
    }
}
