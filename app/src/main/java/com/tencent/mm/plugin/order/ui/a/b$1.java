package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;

class b$1 implements OnClickListener {
    final /* synthetic */ MallTransactionObject pag;
    final /* synthetic */ b pcM;
    final /* synthetic */ Context val$context;

    b$1(b bVar, MallTransactionObject mallTransactionObject, Context context) {
        this.pcM = bVar;
        this.pag = mallTransactionObject;
        this.val$context = context;
    }

    public final void onClick(View view) {
        if (!bh.ov(this.pag.paA)) {
            e.S(this.val$context, this.pag.paA);
        }
    }
}
