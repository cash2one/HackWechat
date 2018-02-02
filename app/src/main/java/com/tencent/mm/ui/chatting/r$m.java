package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.ar;

public class r$m extends r$d {
    public r$m(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        cf cfVar = ((ar) view.getTag()).fEJ;
        if (cfVar == null) {
            return;
        }
        if (cfVar == null || cfVar.gjE != 80) {
            h.a(this.yqa.getContext(), this.yqa.getString(R.l.dSH), "", this.yqa.getString(R.l.dGv), this.yqa.getString(R.l.dEn), new 1(this, cfVar), new 2(this));
            return;
        }
        x.w("MicroMsg.DesignerClickListener", "[dealClickStateBtn] %s", new Object[]{cfVar.field_imgPath});
        h.b(this.yqa.getContext(), this.yqa.getContext().getString(R.l.elz), this.yqa.getContext().getString(R.l.cRU), true);
    }
}
