package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public class o$c extends b {
    private String yLu;
    private a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == 42) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddX);
        view.setTag(new o$a().q(view, false));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        String str2;
        Object obj;
        String str3;
        boolean gM;
        this.yqa = aVar2;
        aVar = (o$a) aVar;
        ar.Hg();
        au.a EK = c.Fa().EK(auVar.field_content);
        if (EK.rYX == null || EK.rYX.length() <= 0) {
            x.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
        }
        this.yLu = EK.rYX;
        x.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", Boolean.valueOf(s.gF(this.yLu)), this.yLu);
        b.a.O(aVar.yIy, aVar.yJw);
        if (s.gM(EK.tmE)) {
            aVar.yLs.setText(R.l.dQC);
            aVar.yLt.setVisibility(8);
            if (d.fM(16)) {
                aVar.yLr.setBackground(null);
            } else {
                aVar.yLr.setBackgroundDrawable(null);
            }
            b.r(aVar.yLr, this.yLu);
        } else {
            aVar.yLs.setText(R.l.dSo);
            aVar.yLr.setBackgroundResource(R.g.bBB);
            b.q(aVar.yLr, this.yLu);
        }
        aVar.kBH.setText(i.b(aVar2.getContext(), EK.fpL, aVar.kBH.getTextSize()));
        Object obj2 = null;
        CharSequence charSequence = EK.gfN;
        if (!t.ov(this.yLu)) {
            ar.Hg();
            af WO = c.EY().WO(this.yLu);
            if (WO != null && com.tencent.mm.l.a.fZ(WO.field_type)) {
                com.tencent.mm.storage.x.chZ();
                if (obj2 == null && t.ov(charSequence)) {
                    str2 = this.yLu;
                    obj = (t.ov(str2) || com.tencent.mm.storage.x.WB(str2) || s.gD(str2)) ? 1 : null;
                    str3 = str2;
                    obj2 = obj;
                    charSequence = str3;
                }
                gM = s.gM(EK.tmE);
                if (obj2 != null || gM) {
                    charSequence = "";
                }
                if (t.ov(charSequence)) {
                    aVar.yLt.setVisibility(0);
                    aVar.yLt.setText(charSequence);
                } else {
                    aVar.yLt.setVisibility(8);
                }
                aVar.yIy.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
                aVar.yIy.setOnClickListener(t(aVar2));
                aVar.yIy.setOnLongClickListener(s(aVar2));
                aVar.yIy.setOnTouchListener(aVar2.ysf.ysV);
                if (b.cvy()) {
                    if (aVar.psA != null) {
                        aVar.psA.setVisibility(8);
                    }
                    if (auVar.field_status == 2 || !b.a(aVar2.ysf, auVar.field_msgId)) {
                        if (aVar.yJk != null) {
                            aVar.yJk.setVisibility(8);
                        }
                    } else if (aVar.yJk != null) {
                        aVar.yJk.setVisibility(0);
                    }
                } else if (aVar.psA != null) {
                    aVar.psA.setVisibility(0);
                    if (auVar.field_status >= 2) {
                        aVar.psA.setVisibility(8);
                    }
                }
                a(i, aVar, auVar, aVar2.ysf.hlJ, aVar2.ypn, aVar2);
            }
        }
        obj2 = 1;
        str2 = this.yLu;
        if (!t.ov(str2)) {
        }
        str3 = str2;
        obj2 = obj;
        charSequence = str3;
        gM = s.gM(EK.tmE);
        charSequence = "";
        if (t.ov(charSequence)) {
            aVar.yLt.setVisibility(8);
        } else {
            aVar.yLt.setVisibility(0);
            aVar.yLt.setText(charSequence);
        }
        aVar.yIy.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
        aVar.yIy.setOnClickListener(t(aVar2));
        aVar.yIy.setOnLongClickListener(s(aVar2));
        aVar.yIy.setOnTouchListener(aVar2.ysf.ysV);
        if (b.cvy()) {
            if (aVar.psA != null) {
                aVar.psA.setVisibility(8);
            }
            if (auVar.field_status == 2) {
            }
            if (aVar.yJk != null) {
                aVar.yJk.setVisibility(8);
            }
        } else if (aVar.psA != null) {
            aVar.psA.setVisibility(0);
            if (auVar.field_status >= 2) {
                aVar.psA.setVisibility(8);
            }
        }
        a(i, aVar, auVar, aVar2.ysf.hlJ, aVar2.ypn, aVar2);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        ar.Hg();
        au.a EK = c.Fa().EK(auVar.field_content);
        if (EK.rYX == null || EK.rYX.length() <= 0) {
            x.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
        }
        this.yLu = EK.rYX;
        if (s.gM(EK.tmE)) {
            contextMenu.add(i, 118, 0, view.getContext().getString(R.l.eEC));
        }
        if (!auVar.ciV() && ((auVar.field_status == 2 || auVar.gjJ == 1) && auVar.cjf() && b.a(auVar, this.yqa) && b.Zq(auVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
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
