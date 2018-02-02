package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.d;

class g$8 implements OnClickListener {
    final /* synthetic */ g nKt;

    g$8(g gVar) {
        this.nKt = gVar;
    }

    public final void onClick(View view) {
        this.nKt.dismiss();
        Intent intent = new Intent();
        intent.putExtra("IPCallShareCouponCardUI_KFrom", 2);
        intent.setClass(g.i(this.nKt), IPCallShareCouponCardUI.class);
        g.i(this.nKt).startActivity(intent);
        d.a(1, -1, g.h(this.nKt), g.b(this.nKt, g.h(this.nKt)), 1, 1, -1, g.e(this.nKt), g.f(this.nKt));
    }
}
