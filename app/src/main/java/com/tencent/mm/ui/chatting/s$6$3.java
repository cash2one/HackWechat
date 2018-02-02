package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.s.6;
import java.util.List;

class s$6$3 implements OnClickListener {
    final /* synthetic */ List yrD;
    final /* synthetic */ 6 ytX;
    final /* synthetic */ cf ytY;

    s$6$3(6 6, List list, cf cfVar) {
        this.ytX = 6;
        this.yrD = list;
        this.ytY = cfVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        for (au auVar : this.yrD) {
            if (!auVar.cjk() && !auVar.cjj()) {
                if (this.ytY.fqp.type == 14 && this.ytY.fqp.fqr.weU.size() == 0) {
                    this.ytX.ytT.crR();
                    return;
                }
                6.a(this.ytX, this.ytY);
                6.dh(s.e(this.ytX.ytT));
                return;
            }
        }
    }
}
