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
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;

public class l$b extends b {
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != 16777265) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddq);
        view.setTag(new l.a().dy(view));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        g.a I;
        this.yqa = aVar2;
        aVar2.yvP.aT(auVar);
        l.a aVar3 = (l.a) aVar;
        String str2 = auVar.field_content;
        if (aVar2.ysk) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = auVar.field_content.substring(indexOf + 1);
            }
        }
        if (str2 != null) {
            I = g.a.I(str2, auVar.field_reserved);
        } else {
            I = null;
        }
        if (I != null && I.type == 1) {
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(I.appId, true);
            String str3 = (aZ == null || aZ.field_appName == null || aZ.field_appName.trim().length() <= 0) ? I.appName : aZ.field_appName;
            if (I.appId == null || I.appId.length() <= 0 || !com.tencent.mm.pluginsdk.model.app.g.cz(str3)) {
                aVar3.mxT.setVisibility(8);
            } else {
                aVar3.mxT.setText(aVar2.getString(R.l.dTb, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(aVar2.getContext(), aZ, str3)}));
                aVar3.mxT.setVisibility(0);
                a(aVar2, aVar3.mxT, I.appId);
                a(aVar2, aVar3.mxT, I.appId);
            }
            if (I.gjD == null || I.gjD.length() <= 0) {
                aVar3.yIW.setVisibility(8);
            } else {
                b(aVar2, aVar3.yIW, ar.Zx(I.gjD));
                aVar3.yIW.setVisibility(0);
            }
            aVar3.yKB.setClickable(true);
            aVar3.yKB.V(i.a(aVar3.yKB.getContext(), I.title, (int) aVar3.yKB.gu.getTextSize(), 1));
        }
        aVar3.yKB.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
        ar.Hg();
        if (c.isSDCardAvailable()) {
            aVar3.yKB.setOnLongClickListener(s(aVar2));
            if (I != null && I.type != 1) {
                aVar3.yKB.setOnTouchListener(aVar2.ysf.ysV);
            }
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        contextMenu.add(i, 111, 0, this.yqa.getString(R.l.eEC));
        if (d.OQ("favorite")) {
            contextMenu.add(i, 116, 0, this.yqa.getString(R.l.eAd));
        }
        if (!this.yqa.csV()) {
            contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                ba.aK(auVar.field_msgId);
                ar.Hg();
                c.EX().b(new e(auVar.field_talker, auVar.field_msgSvrId));
                break;
            case 102:
                ClipboardManager clipboardManager = (ClipboardManager) aVar.getContext().getSystemService("clipboard");
                Object dk = aVar.dk(g.a.fT(aVar.dk(auVar.field_content, auVar.field_isSend)).title, auVar.field_isSend);
                clipboardManager.setText(dk);
                int i = com.tencent.mm.plugin.secinforeport.a.a.qff;
                com.tencent.mm.plugin.secinforeport.a.a.d(1, auVar.field_msgSvrId, bh.Vy(dk));
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
        return false;
    }
}
