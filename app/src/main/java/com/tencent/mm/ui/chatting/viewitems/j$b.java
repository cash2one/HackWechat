package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.b.aa;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ba;

public class j$b extends b {
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != -1879048186) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddo);
        view.setTag(new j.a().dw(view));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        String substring;
        String str2;
        String str3;
        Object[] objArr;
        g.a aVar3;
        j.a aVar4 = (j.a) aVar;
        this.yqa = aVar2;
        g fp = an.bYS().fp(auVar.field_msgId);
        String str4 = auVar.field_content;
        if (aVar2.ysk) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                substring = auVar.field_content.substring(indexOf + 1);
                if (fp != null || substring == null) {
                    str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
                    str3 = "amessage:%b, %s, %s";
                    objArr = new Object[4];
                    objArr[0] = Boolean.valueOf(fp != null);
                    objArr[1] = substring;
                    objArr[2] = Long.valueOf(auVar.field_msgId);
                    objArr[3] = str;
                    x.e(str2, str3, objArr);
                    aVar3 = null;
                } else {
                    aVar3 = g.a.I(substring, auVar.field_reserved);
                }
                if (aVar3 != null) {
                    aVar4.yKt.setText(aVar3.title);
                    aVar4.yIy.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
                    aVar4.yIy.setOnClickListener(t(aVar2));
                    if (this.vzn) {
                        aVar4.yIy.setOnLongClickListener(s(aVar2));
                        aVar4.yIy.setOnTouchListener(aVar2.ysf.ysV);
                    }
                }
                if (q.a.vcw == null && q.a.vcw.DC(aVar2.crz())) {
                    aVar4.yKt.setTextColor(aVar2.thisActivity().getResources().getColor(R.e.btv));
                    aVar4.yIy.setClickable(true);
                    aVar4.yIy.setEnabled(true);
                    return;
                }
                aVar4.yKt.setTextColor(-8750470);
                aVar4.yIy.setClickable(false);
                aVar4.yIy.setEnabled(false);
            }
        }
        substring = str4;
        if (fp != null) {
        }
        str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
        str3 = "amessage:%b, %s, %s";
        objArr = new Object[4];
        if (fp != null) {
        }
        objArr[0] = Boolean.valueOf(fp != null);
        objArr[1] = substring;
        objArr[2] = Long.valueOf(auVar.field_msgId);
        objArr[3] = str;
        x.e(str2, str3, objArr);
        aVar3 = null;
        if (aVar3 != null) {
            aVar4.yKt.setText(aVar3.title);
            aVar4.yIy.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
            aVar4.yIy.setOnClickListener(t(aVar2));
            if (this.vzn) {
                aVar4.yIy.setOnLongClickListener(s(aVar2));
                aVar4.yIy.setOnTouchListener(aVar2.ysf.ysV);
            }
        }
        if (q.a.vcw == null) {
        }
        aVar4.yKt.setTextColor(-8750470);
        aVar4.yIy.setClickable(false);
        aVar4.yIy.setEnabled(false);
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
