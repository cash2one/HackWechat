package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.Map;

public class o$b extends b {
    private String yLu;
    private String yLv;
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != 42) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.dds);
        view.setTag(new o$a().q(view, true));
        return view;
    }

    protected final boolean r(a aVar) {
        return aVar.ypn;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        String hQ;
        byte b;
        this.yqa = aVar2;
        o$a com_tencent_mm_ui_chatting_viewitems_o_a = (o$a) aVar;
        if (aVar2.ypn) {
            hQ = ba.hQ(auVar.field_content);
        } else {
            hQ = auVar.field_content;
        }
        ar.Hg();
        au.a EK = c.Fa().EK(hQ);
        if (EK.rYX == null || EK.rYX.length() <= 0) {
            x.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.yLu = EK.rYX;
        this.yLv = "";
        if (!t.ov(hQ)) {
            Map y = bi.y(hQ, "msg");
            if (y.containsKey(".msg.$wechatid")) {
                this.yLv = (String) y.get(".msg.$wechatid");
            }
        }
        b.I(this.yLu, EK.xzi);
        b.a.O(com_tencent_mm_ui_chatting_viewitems_o_a.yIy, com_tencent_mm_ui_chatting_viewitems_o_a.yJw);
        if (s.gM(EK.tmE)) {
            com_tencent_mm_ui_chatting_viewitems_o_a.yLs.setText(R.l.dQC);
            com_tencent_mm_ui_chatting_viewitems_o_a.yLt.setVisibility(8);
            if (d.fM(16)) {
                com_tencent_mm_ui_chatting_viewitems_o_a.yLr.setBackground(null);
            } else {
                com_tencent_mm_ui_chatting_viewitems_o_a.yLr.setBackgroundDrawable(null);
            }
            b.r(com_tencent_mm_ui_chatting_viewitems_o_a.yLr, this.yLu);
        } else {
            com_tencent_mm_ui_chatting_viewitems_o_a.yLs.setText(R.l.dSo);
            com_tencent_mm_ui_chatting_viewitems_o_a.yLr.setBackgroundResource(R.g.bBB);
            b.q(com_tencent_mm_ui_chatting_viewitems_o_a.yLr, this.yLu);
        }
        String str2 = this.yLv;
        if (t.ov(str2) || com.tencent.mm.storage.x.WB(str2) || s.gD(str2)) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        boolean gM = s.gM(EK.tmE);
        if (b != (byte) 0 || gM) {
            CharSequence charSequence = "";
        } else {
            Object obj = str2;
        }
        if (t.ov(charSequence)) {
            com_tencent_mm_ui_chatting_viewitems_o_a.yLt.setVisibility(8);
        } else {
            com_tencent_mm_ui_chatting_viewitems_o_a.yLt.setVisibility(0);
            com_tencent_mm_ui_chatting_viewitems_o_a.yLt.setText(charSequence);
        }
        com_tencent_mm_ui_chatting_viewitems_o_a.kBH.setText(i.c(aVar2.getContext(), EK.fpL, (int) com_tencent_mm_ui_chatting_viewitems_o_a.kBH.getTextSize()));
        com_tencent_mm_ui_chatting_viewitems_o_a.yIy.setTag(new ar(auVar, aVar2.ypn, i, str, (byte) 0));
        com_tencent_mm_ui_chatting_viewitems_o_a.yIy.setOnClickListener(t(aVar2));
        com_tencent_mm_ui_chatting_viewitems_o_a.yIy.setOnLongClickListener(s(aVar2));
        com_tencent_mm_ui_chatting_viewitems_o_a.yIy.setOnTouchListener(aVar2.ysf.ysV);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        ar.Hg();
        au.a EK = c.Fa().EK(auVar.field_content);
        if (EK.rYX == null || EK.rYX.length() <= 0) {
            x.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.yLu = EK.rYX;
        if (s.gM(EK.tmE)) {
            contextMenu.add(i, 118, 0, view.getContext().getString(R.l.eEC));
        }
        if (!this.yqa.csV()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRH));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 118:
                Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", aVar.dk(auVar.field_content, auVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 8);
                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        o.a(aVar, arVar.userName, auVar.field_content, arVar.ypn, auVar.field_isSend == 0);
        return true;
    }
}
