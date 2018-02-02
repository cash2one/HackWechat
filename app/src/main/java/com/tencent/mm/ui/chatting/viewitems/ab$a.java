package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.af.a;

public class ab$a extends a {
    private ChattingUI.a yqa;

    public final boolean aj(int i, boolean z) {
        if (z || (i != 55 && i != 57)) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddL);
        view.setTag(new ab$c().dB(view));
        return view;
    }

    public final void a(b.a aVar, int i, ChattingUI.a aVar2, au auVar, String str) {
        this.yqa = aVar2;
        ab$c com_tencent_mm_ui_chatting_viewitems_ab_c = (ab$c) aVar;
        com.tencent.mm.ah.a.a ky = com.tencent.mm.ah.a.a.ky(auVar.field_content);
        String str2 = ky.fzO;
        a(com_tencent_mm_ui_chatting_viewitems_ab_c, aVar2, auVar, str2);
        a(com_tencent_mm_ui_chatting_viewitems_ab_c, aVar2, str2, auVar);
        i.a(com_tencent_mm_ui_chatting_viewitems_ab_c.yMh.getContext(), com.tencent.mm.ah.a.a(ky), (int) com_tencent_mm_ui_chatting_viewitems_ab_c.yMh.getTextSize(), null, "");
        com_tencent_mm_ui_chatting_viewitems_ab_c.yMh.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
        com_tencent_mm_ui_chatting_viewitems_ab_c.yMh.setOnLongClickListener(s(aVar2));
    }

    protected final boolean cvx() {
        return false;
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
