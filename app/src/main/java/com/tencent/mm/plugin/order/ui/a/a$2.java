package com.tencent.mm.plugin.order.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.ui.base.preference.f;

class a$2 implements OnClickListener {
    final /* synthetic */ f jKv;
    final /* synthetic */ MallTransactionObject pag;
    final /* synthetic */ a pcI;
    final /* synthetic */ f pcJ;

    a$2(a aVar, MallTransactionObject mallTransactionObject, f fVar, f fVar2) {
        this.pcI = aVar;
        this.pag = mallTransactionObject;
        this.pcJ = fVar;
        this.jKv = fVar2;
    }

    public final void onClick(View view) {
        this.pcJ.setContent(this.pag.desc + "\n" + this.pag.pap);
        this.jKv.notifyDataSetChanged();
    }
}
