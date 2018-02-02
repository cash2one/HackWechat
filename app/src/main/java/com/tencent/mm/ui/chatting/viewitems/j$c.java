package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.b.aa;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ba;

public class j$c extends b {
    private a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == -1879048186) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddT);
        view.setTag(new j.a().dw(view));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        g.a I;
        j.a aVar3 = (j.a) aVar;
        this.yqa = aVar2;
        String str2 = auVar.field_content;
        if (str2 != null) {
            I = g.a.I(str2, auVar.field_reserved);
        } else {
            I = null;
        }
        if (I != null) {
            aVar3.yIy.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
            aVar3.yIy.setOnClickListener(t(aVar2));
            if (this.vzn) {
                aVar3.yIy.setOnLongClickListener(s(aVar2));
                aVar3.yIy.setOnTouchListener(aVar2.ysf.ysV);
            }
            aVar3.yKt.setText(I.title);
        }
        if (q.a.vcw == null || !q.a.vcw.DC(aVar2.crz())) {
            aVar3.yKt.setTextColor(-8750470);
            aVar3.yIy.setClickable(false);
            aVar3.yIy.setEnabled(false);
            return;
        }
        aVar3.yKt.setTextColor(aVar2.thisActivity().getResources().getColor(R.e.btv));
        aVar3.yIy.setClickable(true);
        aVar3.yIy.setEnabled(true);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        l.RH(this.yqa.dk(auVar.field_content, auVar.field_isSend));
        g.a fT = g.a.fT(this.yqa.dk(auVar.field_content, auVar.field_isSend));
        f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false);
        if (d.OQ("favorite") && (aZ == null || !aZ.Yz())) {
            switch (fT.type) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 10:
                case 13:
                case 20:
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
                    break;
            }
        }
        if (!auVar.ciV() && auVar.aNe() && ((auVar.field_status == 2 || auVar.gjJ == 1) && a(auVar, this.yqa) && Zq(auVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
        }
        if (!this.yqa.csV()) {
            contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = auVar.field_content;
                g.a aVar2 = null;
                if (str != null) {
                    aVar2 = g.a.fT(str);
                }
                if (aVar2 != null) {
                    l.fq(auVar.field_msgId);
                    ba.aK(auVar.field_msgId);
                    f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(aVar2.appId, false);
                    if (aZ != null && aZ.Yz()) {
                        a(aVar, aVar2, auVar, aZ);
                        break;
                    }
                }
                break;
            case 111:
                Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", aVar.dk(auVar.field_content, auVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        aa aaVar = aVar.yvM;
        aVar.crz();
        aaVar.bm("fromMessage", true);
        return true;
    }
}
