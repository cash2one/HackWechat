package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class a$1 implements OnClickListener {
    final /* synthetic */ MallTransactionObject pag;
    final /* synthetic */ Context val$context;

    a$1(MallTransactionObject mallTransactionObject, Context context) {
        this.pag = mallTransactionObject;
        this.val$context = context;
    }

    public final void onClick(View view) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        if (!bh.ov(this.pag.paA)) {
            linkedList2.add(Integer.valueOf(0));
            linkedList.add(this.val$context.getString(a$i.uTL));
        }
        if (!bh.ov(this.pag.pac)) {
            linkedList2.add(Integer.valueOf(1));
            linkedList.add(this.val$context.getString(a$i.uTM));
        }
        if (!bh.ov(this.pag.paJ)) {
            linkedList2.add(Integer.valueOf(2));
            linkedList.add(this.val$context.getString(a$i.uTO));
        }
        if (linkedList2.size() == 1) {
            a.a(((Integer) linkedList2.get(0)).intValue(), this.val$context, this.pag);
            return;
        }
        h.a(this.val$context, null, linkedList, linkedList2, null, true, new 1(this));
    }
}
