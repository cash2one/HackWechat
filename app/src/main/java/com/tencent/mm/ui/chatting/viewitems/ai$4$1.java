package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.subapp.c.a;
import com.tencent.mm.protocal.c.bsz;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.viewitems.ai.4;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

class ai$4$1 implements OnClickListener {
    final /* synthetic */ 4 yOd;

    ai$4$1(4 4) {
        this.yOd = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.CG().a(331, ai.a(this.yOd.yOa, new 1(this)));
        LinkedList linkedList = new LinkedList();
        bsz com_tencent_mm_protocal_c_bsz = new bsz();
        com_tencent_mm_protocal_c_bsz.vHX = this.yOd.yOc.rWr;
        linkedList.add(com_tencent_mm_protocal_c_bsz);
        final k aVar = new a(linkedList, linkedList.size());
        ar.CG().a(aVar, 0);
        ai aiVar = this.yOd.yOa;
        Context context = ai.a(this.yOd.yOa).getContext();
        ai.a(this.yOd.yOa).getString(R.l.dGO);
        ai.a(aiVar, h.a(context, ai.a(this.yOd.yOa).getString(R.l.dRy), true, new OnCancelListener(this) {
            final /* synthetic */ ai$4$1 yOe;

            public final void onCancel(DialogInterface dialogInterface) {
                ar.CG().c(aVar);
                ar.CG().b(331, ai.b(this.yOe.yOd.yOa));
                ai.a(this.yOe.yOd.yOa, null);
                if (ai.c(this.yOe.yOd.yOa) != null) {
                    ai.c(this.yOe.yOd.yOa).dismiss();
                }
            }
        }));
    }
}
