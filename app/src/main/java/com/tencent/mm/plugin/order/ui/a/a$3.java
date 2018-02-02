package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class a$3 implements OnClickListener {
    final /* synthetic */ MallTransactionObject pag;
    final /* synthetic */ a pcI;
    final /* synthetic */ Context val$context;

    a$3(a aVar, Context context, MallTransactionObject mallTransactionObject) {
        this.pcI = aVar;
        this.val$context = context;
        this.pag = mallTransactionObject;
    }

    public final void onClick(View view) {
        h.a(this.val$context, this.val$context.getString(i.uNe), this.val$context.getString(i.dGt), this.val$context.getString(i.uOb), this.val$context.getString(i.dEn), new 1(this), new 2(this));
    }
}
