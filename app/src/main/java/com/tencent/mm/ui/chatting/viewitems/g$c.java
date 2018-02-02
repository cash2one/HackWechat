package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.plugin.card.a.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ba;

public class g$c extends b {
    private a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && (i == 452984881 || i == 520093745)) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddY);
        view.setTag(new g.a().r(view, false));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        g.a I;
        this.yqa = aVar2;
        g.a aVar3 = (g.a) aVar;
        String str2 = auVar.field_content;
        if (str2 != null) {
            I = g.a.I(str2, auVar.field_reserved);
        } else {
            I = null;
        }
        if (!(aVar3 == null || I == null)) {
            aVar3.a(aVar2.getContext(), I, auVar.field_imgPath, this.vzn);
        }
        aVar.yIy.setTag(new ar(auVar, aVar2.ypn, i, null, (byte) 0));
        aVar.yIy.setOnClickListener(t(aVar2));
        if (this.vzn) {
            aVar.yIy.setOnLongClickListener(s(aVar2));
            aVar.yIy.setOnTouchListener(aVar2.ysf.ysV);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        String str = auVar.field_content;
        if (str == null) {
            return true;
        }
        g.a fT = g.a.fT(this.yqa.dk(str, auVar.field_isSend));
        if (fT == null) {
            return true;
        }
        switch (fT.type) {
            case 16:
                if (fT.hcl == 5 || fT.hcl == 6 || fT.hcl == 2) {
                    if (fT.hcl != 2) {
                        contextMenu.clear();
                    }
                    contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
                    return false;
                }
            case 34:
                contextMenu.clear();
                contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
                return false;
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        g.a aVar2;
        String str;
        switch (menuItem.getItemId()) {
            case 100:
                String str2 = auVar.field_content;
                aVar2 = null;
                if (str2 != null) {
                    aVar2 = g.a.fT(str2);
                }
                if (aVar2 != null) {
                    l.fq(auVar.field_msgId);
                }
                ba.aK(auVar.field_msgId);
                break;
            case 103:
                str = auVar.field_content;
                if (str != null) {
                    aVar2 = g.a.fT(str);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 16:
                                b hyVar = new hy();
                                hyVar.fyr.fys = aVar2.fys;
                                hyVar.fyr.fpG = auVar.field_msgId;
                                hyVar.fyr.fyt = auVar.field_talker;
                                com.tencent.mm.sdk.b.a.xef.m(hyVar);
                                break;
                            default:
                                break;
                        }
                    }
                }
                break;
            case 111:
                str = aVar.dk(auVar.field_content, auVar.field_isSend);
                Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", str);
                aVar2 = g.a.fT(str);
                if (aVar2 == null || 16 != aVar2.type) {
                    intent.putExtra("Retr_Msg_Type", 2);
                } else {
                    intent.putExtra("Retr_Msg_Type", 14);
                }
                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        String str = auVar.field_content;
        if (str == null) {
            return false;
        }
        g.a fT = g.a.fT(str);
        if (fT == null) {
            return false;
        }
        switch (fT.type) {
            case 16:
                if (bh.ov(fT.fys)) {
                    return false;
                }
                Intent intent = new Intent();
                intent.setFlags(65536);
                intent.putExtra("key_card_app_msg", fT.fys);
                intent.putExtra("key_from_scene", fT.hcl);
                d.b(aVar.getContext(), "card", ".ui.CardDetailUI", intent);
                return true;
            case 34:
                h b = h.b(fT);
                if (1 < b.ver) {
                    String str2;
                    int i;
                    String A = p.A(fT.hba, "message");
                    PackageInfo packageInfo = getPackageInfo(aVar.getContext(), fT.appId);
                    if (packageInfo == null) {
                        str2 = null;
                    } else {
                        str2 = packageInfo.versionName;
                    }
                    if (packageInfo == null) {
                        i = 0;
                    } else {
                        i = packageInfo.versionCode;
                    }
                    a(aVar, A, A, str2, i, fT.appId, true, auVar.field_msgId, auVar.field_msgSvrId, auVar);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_from_user_name", a(aVar, auVar));
                    intent2.putExtra("key_biz_uin", b.hcn);
                    intent2.putExtra("key_order_id", b.hco);
                    if (!(auVar.field_talker == null || auVar.field_talker.equals("") || !auVar.field_talker.endsWith("@chatroom"))) {
                        intent2.putExtra("key_chatroom_name", auVar.field_talker);
                    }
                    d.b(aVar.getContext(), "card", ".ui.CardGiftAcceptUI", intent2);
                }
                return true;
            default:
                return false;
        }
    }
}
