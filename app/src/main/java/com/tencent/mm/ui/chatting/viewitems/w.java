package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ba;

public final class w extends b {
    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (i == -1879048176) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddH);
        view.setTag(new a(this).dE(view));
        return view;
    }

    public final void a(a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
        g$a com_tencent_mm_y_g_a;
        a aVar2 = (a) aVar;
        g fp = an.bYS().fp(auVar.field_msgId);
        String str2 = auVar.field_content;
        if (fp == null || str2 == null) {
            String str3 = "MicroMsg.ChattingItemHardDeviceMsgPush";
            String str4 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(fp == null);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(auVar.field_msgId);
            objArr[3] = str;
            x.e(str3, str4, objArr);
            com_tencent_mm_y_g_a = null;
        } else {
            com_tencent_mm_y_g_a = g$a.I(str2, auVar.field_reserved);
        }
        ar arVar = new ar(auVar, chattingUI$a.ypn, i, null, (byte) 0);
        if (com_tencent_mm_y_g_a != null && (com_tencent_mm_y_g_a.showType == 3 || com_tencent_mm_y_g_a.hbV == 3)) {
            aVar2.hvY.setImageResource(R.g.bCR);
            aVar2.yMz.setText(com_tencent_mm_y_g_a.hca);
        }
        aVar.yIy.setOnLongClickListener(s(chattingUI$a));
        aVar.yIy.setOnTouchListener(chattingUI$a.ysf.ysV);
        aVar.yIy.setTag(arVar);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((ar) view.getTag()).position, 100, 0, view.getContext().getString(R.l.dRH));
        return false;
    }

    public final boolean a(MenuItem menuItem, ChattingUI$a chattingUI$a, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = auVar.field_content;
                g$a com_tencent_mm_y_g_a = null;
                if (str != null) {
                    com_tencent_mm_y_g_a = g$a.fT(str);
                }
                if (com_tencent_mm_y_g_a != null) {
                    l.fq(auVar.field_msgId);
                }
                ba.aK(auVar.field_msgId);
                break;
        }
        return false;
    }

    public final boolean b(View view, ChattingUI$a chattingUI$a, au auVar) {
        return false;
    }
}
