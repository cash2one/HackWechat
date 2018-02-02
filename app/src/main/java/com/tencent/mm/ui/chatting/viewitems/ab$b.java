package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.af.b;
import com.tencent.mm.ui.chatting.viewitems.af.e;

public class ab$b extends b {
    private a yqa;

    public final boolean aj(int i, boolean z) {
        if (z && (i == 55 || i == 57)) {
            return true;
        }
        return false;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        this.yqa = aVar2;
        aVar = (e) aVar;
        com.tencent.mm.ah.a.a ky = com.tencent.mm.ah.a.a.ky(auVar.field_content);
        if (auVar.field_status >= 2) {
            aVar.psA.setVisibility(8);
        } else {
            aVar.psA.setVisibility(0);
        }
        i.a(aVar.yNq.getContext(), com.tencent.mm.ah.a.a(ky), (int) aVar.yNq.gu.getTextSize(), null, "");
        aVar.yNq.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
        aVar.yNq.setOnLongClickListener(s(aVar2));
        a(i, aVar, auVar, aVar2.ysf.hlJ, aVar2.ypn, aVar2);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (auVar.cjq()) {
            int i = ((ar) view.getTag()).position;
            if (auVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dSI));
            }
            if (!this.yqa.csV()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRH));
            }
        }
        return true;
    }
}
