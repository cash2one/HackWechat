package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ay.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.viewitems.l.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;

public class l$c extends b {
    private ChattingUI$a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == 16777265) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddV);
        view.setTag(new a().dy(view));
        return view;
    }

    public final void a(b.a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
        g$a I;
        a aVar2 = (a) aVar;
        this.yqa = chattingUI$a;
        chattingUI$a.yvP.aT(auVar);
        String str2 = auVar.field_content;
        if (str2 != null) {
            I = g$a.I(str2, auVar.field_reserved);
        } else {
            I = null;
        }
        if (I != null && I.type == 1) {
            aVar2.yKB.V(i.a(aVar2.yKB.getContext(), I.title, (int) aVar2.yKB.gu.getTextSize(), 1));
            aVar2.yKB.setClickable(true);
            f aZ = g.aZ(I.appId, true);
            String str3 = (aZ == null || aZ.field_appName == null || aZ.field_appName.trim().length() <= 0) ? I.appName : aZ.field_appName;
            if (I.appId == null || I.appId.length() <= 0 || !g.cz(str3)) {
                aVar2.mxT.setVisibility(8);
            } else {
                aVar2.mxT.setText(chattingUI$a.getString(R.l.dTb, new Object[]{g.a(chattingUI$a.getContext(), aZ, str3)}));
                aVar2.mxT.setVisibility(0);
                a(chattingUI$a, aVar2.mxT, I.appId);
                a(chattingUI$a, aVar2.mxT, I.appId);
            }
            if (auVar.field_status == 2 || auVar.field_status == 5) {
                aVar2.psA.setVisibility(8);
            } else {
                aVar2.psA.setVisibility(0);
            }
            a(i, aVar2, auVar, chattingUI$a.ysf.hlJ, chattingUI$a.ypn, chattingUI$a);
        }
        aVar2.yKB.setTag(new ar(auVar, chattingUI$a.ypn, i, null, (byte) 0));
        ar.Hg();
        if (c.isSDCardAvailable()) {
            aVar2.yKB.setOnLongClickListener(s(chattingUI$a));
            if (I != null && I.type != 1) {
                aVar2.yKB.setOnTouchListener(chattingUI$a.ysf.ysV);
            }
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        contextMenu.add(i, 111, 0, this.yqa.getString(R.l.eEC));
        if (d.OQ("favorite")) {
            contextMenu.add(i, 116, 0, this.yqa.getString(R.l.eAd));
        }
        if (!auVar.ciV() && ((auVar.field_status == 2 || auVar.gjJ == 1) && a(auVar, this.yqa) && Zq(auVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
        }
        if (!this.yqa.csV()) {
            contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, ChattingUI$a chattingUI$a, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                ba.aK(auVar.field_msgId);
                ar.Hg();
                c.EX().b(new e(auVar.field_talker, auVar.field_msgSvrId));
                break;
            case 102:
                ClipboardManager clipboardManager = (ClipboardManager) chattingUI$a.getContext().getSystemService("clipboard");
                Object dk = chattingUI$a.dk(g$a.fT(auVar.field_content).title, auVar.field_isSend);
                clipboardManager.setText(dk);
                int i = com.tencent.mm.plugin.secinforeport.a.a.qff;
                com.tencent.mm.plugin.secinforeport.a.a.d(1, auVar.field_msgSvrId, bh.Vy(dk));
                break;
            case 111:
                Intent intent = new Intent(chattingUI$a.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", auVar.field_content);
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                chattingUI$a.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean b(View view, ChattingUI$a chattingUI$a, au auVar) {
        return false;
    }
}
