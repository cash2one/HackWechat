package com.tencent.mm.ui.chatting.e;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.cf;
import java.util.List;

class e$4 implements OnClickListener {
    final /* synthetic */ List juo;
    final /* synthetic */ e yHA;
    final /* synthetic */ cf ytY;

    e$4(e eVar, cf cfVar, List list) {
        this.yHA = eVar;
        this.ytY = cfVar;
        this.juo = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.ytY.fqp.type != 14 || this.ytY.fqp.fqr.weU.size() != 0) {
            e.a(this.yHA, this.ytY);
            e.dq(this.juo);
        }
    }
}
