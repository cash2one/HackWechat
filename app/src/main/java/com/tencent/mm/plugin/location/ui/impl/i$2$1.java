package com.tencent.mm.plugin.location.ui.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.plugin.location.ui.impl.i.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class i$2$1 implements OnClickListener {
    final /* synthetic */ 2 nYE;

    i$2$1(2 2) {
        this.nYE = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        long longExtra = this.nYE.nYD.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
        b caVar = new ca();
        caVar.fqi.fqk = longExtra;
        a.xef.m(caVar);
        x.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", new Object[]{Long.valueOf(longExtra), Boolean.valueOf(bh.a(Boolean.valueOf(caVar.fqj.fpW), false))});
        if (bh.a(Boolean.valueOf(caVar.fqj.fpW), false)) {
            this.nYE.nYD.activity.finish();
        }
    }
}
