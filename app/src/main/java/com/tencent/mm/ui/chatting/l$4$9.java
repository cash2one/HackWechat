package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.l.4;
import java.util.List;

class l$4$9 implements OnClickListener {
    final /* synthetic */ 4 yrQ;
    final /* synthetic */ MenuItem yrR;

    l$4$9(4 4, MenuItem menuItem) {
        this.yrQ = 4;
        this.yrR = menuItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        List<au> list = this.yrQ.yrD;
        if (list != null && !list.isEmpty()) {
            for (au auVar : list) {
                if (!i.an(auVar)) {
                    if (!auVar.ciW() && !i.ai(auVar) && !auVar.cjf() && !i.ak(auVar) && !i.al(auVar) && auVar.getType() != -1879048186 && !i.as(auVar) && !i.am(auVar) && !i.ar(auVar) && !i.av(auVar)) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        x.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
        z = true;
        if (z) {
            x.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
            if (this.yrQ.yrP != null) {
                this.yrQ.yrP.crR();
                return;
            }
            return;
        }
        Context context = this.yrQ.val$context;
        this.yrQ.val$context.getString(R.l.dGO);
        l.a(h.a(context, this.yrQ.val$context.getString(R.l.eKa), false, null));
        s.ytO.c(new l$b(this.yrQ.yrN, this.yrQ.val$context, this.yrR.getTitle(), -1, l.crt()));
        if (this.yrQ.yrP != null) {
            this.yrQ.yrP.crR();
        }
    }
}
