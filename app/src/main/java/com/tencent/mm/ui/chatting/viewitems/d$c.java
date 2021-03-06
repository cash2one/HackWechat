package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.td;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.f;
import com.tencent.mm.y.c;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;

public class d$c extends b {
    private a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == 436207665) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddP);
        view.setTag(new d$a().dt(view));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        g.a I;
        this.yqa = aVar2;
        d$a com_tencent_mm_ui_chatting_viewitems_d_a = (d$a) aVar;
        String str2 = auVar.field_content;
        if (str2 != null) {
            I = g.a.I(str2, auVar.field_reserved);
        } else {
            I = null;
        }
        if (I != null) {
            TextView textView;
            int i2;
            int a;
            boolean equals = "1001".equals(I.hcG);
            b tdVar = new td();
            if (!(bh.ov(I.hcH) || equals)) {
                tdVar.fLA.fLC = I.hcH;
                com.tencent.mm.sdk.b.a.xef.m(tdVar);
            }
            d$a.O(com_tencent_mm_ui_chatting_viewitems_d_a.yIy, com_tencent_mm_ui_chatting_viewitems_d_a.yJw);
            if ("1001".equals(I.hcG)) {
                com_tencent_mm_ui_chatting_viewitems_d_a.yIy.setBackgroundResource(f.c(I, auVar.field_isSend == 1));
                com_tencent_mm_ui_chatting_viewitems_d_a.yJL.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                com_tencent_mm_ui_chatting_viewitems_d_a.yIy.setBackgroundResource(f.q(tdVar.fLB.fLD, tdVar.fLB.fLE, auVar.field_isSend == 1));
                com_tencent_mm_ui_chatting_viewitems_d_a.yJL.setTypeface(Typeface.defaultFromStyle(0));
                com_tencent_mm_ui_chatting_viewitems_d_a.yJO = com_tencent_mm_ui_chatting_viewitems_d_a.yJO > com_tencent_mm_ui_chatting_viewitems_d_a.maxSize ? com_tencent_mm_ui_chatting_viewitems_d_a.maxSize : com_tencent_mm_ui_chatting_viewitems_d_a.yJO;
            }
            com_tencent_mm_ui_chatting_viewitems_d_a.yIy.setPadding(aVar2.getContext().getResources().getDimensionPixelSize(R.f.bvB), 0, com.tencent.mm.bv.a.fromDPToPix(aVar2.getContext(), 13), 0);
            CharSequence charSequence = auVar.field_isSend == 1 ? I.hcB : I.hcA;
            if (bh.ov(charSequence)) {
                charSequence = I.description;
                com_tencent_mm_ui_chatting_viewitems_d_a.yJL.setSingleLine(false);
                com_tencent_mm_ui_chatting_viewitems_d_a.yJL.setMaxLines(3);
            } else {
                com_tencent_mm_ui_chatting_viewitems_d_a.yJL.setSingleLine(true);
            }
            com_tencent_mm_ui_chatting_viewitems_d_a.yJL.setText(i.c(aVar2.getContext(), charSequence, com_tencent_mm_ui_chatting_viewitems_d_a.yJO));
            com_tencent_mm_ui_chatting_viewitems_d_a.yJL.setTextSize(0, (float) com_tencent_mm_ui_chatting_viewitems_d_a.yJO);
            if (equals) {
                textView = com_tencent_mm_ui_chatting_viewitems_d_a.yJM;
                charSequence = i.b(aVar2.getContext(), f.b(I, auVar.field_isSend == 1), com_tencent_mm_ui_chatting_viewitems_d_a.yJM.getTextSize());
            } else if (bh.ov(I.hcH)) {
                textView = com_tencent_mm_ui_chatting_viewitems_d_a.yJM;
                charSequence = auVar.field_isSend == 1 ? I.hcC : I.hcD;
            } else {
                textView = com_tencent_mm_ui_chatting_viewitems_d_a.yJM;
                charSequence = f.a(tdVar.fLB.fLD, tdVar.fLB.fLE, auVar.field_isSend == 1, I);
            }
            textView.setText(charSequence);
            charSequence = I.hcE;
            if (bh.ov(charSequence)) {
                charSequence = I.title;
            }
            com_tencent_mm_ui_chatting_viewitems_d_a.yJN.setText(charSequence);
            c cVar = (c) I.r(c.class);
            if (bh.ov(cVar.haV)) {
                i2 = 0;
            } else {
                o.PA().a("", com_tencent_mm_ui_chatting_viewitems_d_a.yJK);
                i2 = aVar2.getResources().getIdentifier(cVar.haV, "drawable", ac.getPackageName());
            }
            x.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", new Object[]{Integer.valueOf(i2)});
            if (i2 > 0) {
                x.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
                com_tencent_mm_ui_chatting_viewitems_d_a.yJK.setImageResource(i2);
            }
            if ("1001".equals(I.hcG)) {
                a = f.a(I, auVar.field_isSend == 1);
            } else {
                a = f.r(tdVar.fLB.fLD, tdVar.fLB.fLE, auVar.field_isSend == 1);
            }
            if (a > 0) {
                x.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
                com_tencent_mm_ui_chatting_viewitems_d_a.yJK.setImageResource(a);
            } else if (i2 <= 0) {
                x.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
                String str3 = I.hcz;
                if (bh.ov(str3)) {
                    str3 = I.thumburl;
                }
                com_tencent_mm_ui_chatting_viewitems_d_a.yJK.setImageBitmap(null);
                if (!bh.ov(str3)) {
                    c$a com_tencent_mm_aq_a_a_c_a = new c$a();
                    ar.Hg();
                    com_tencent_mm_aq_a_a_c_a.hDD = com.tencent.mm.z.c.Fj();
                    com_tencent_mm_aq_a_a_c_a.hDA = true;
                    com_tencent_mm_aq_a_a_c_a.hDX = true;
                    o.PA().a(str3, com_tencent_mm_ui_chatting_viewitems_d_a.yJK, com_tencent_mm_aq_a_a_c_a.PK());
                }
            }
        }
        aVar.yIy.setOnClickListener(t(aVar2));
        aVar.yIy.setOnLongClickListener(s(aVar2));
        aVar.yIy.setOnTouchListener(aVar2.ysf.ysV);
        aVar.yIy.setTag(new ar(auVar, this.yqa.ypn, i, null, (byte) 0));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((ar) view.getTag()).position, 100, 0, this.yqa.getString(R.l.dRH));
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                ba.aK(auVar.field_msgId);
                return true;
            case 103:
                String str = auVar.field_content;
                g.a aVar2 = null;
                if (str != null) {
                    aVar2 = g.a.I(str, auVar.field_reserved);
                }
                if (aVar2 != null) {
                    String str2 = auVar.field_talker;
                    String str3 = aVar2.hcA;
                    String str4 = aVar2.hcB;
                    String str5 = aVar2.hcC;
                    String str6 = aVar2.hcD;
                    String str7 = aVar2.hcy;
                    String str8 = aVar2.hcF;
                    String str9 = aVar2.hcG;
                    Context context = aVar.getContext();
                    String string = aVar.getString(R.l.dSH);
                    String string2 = aVar.getString(R.l.dGt);
                    String string3 = aVar.getString(R.l.dSI);
                    String string4 = aVar.getString(R.l.dEn);
                    1 1 = new 1(this, str2, str3, str4, str5, str6, str7, str8, str9, aVar);
                    h.a(context, string, string2, string3, string4, (OnClickListener) 1, new 2(this));
                }
                return true;
            default:
                return false;
        }
    }

    public final boolean b(View view, a aVar, au auVar) {
        g.a I;
        String str = auVar.field_content;
        if (str != null) {
            I = g.a.I(str, auVar.field_reserved);
        } else {
            I = null;
        }
        if (I != null) {
            String str2 = bh.ov(I.hcy) ? I.url : I.hcy;
            x.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", new Object[]{Boolean.valueOf(bh.ov(str2)), Boolean.valueOf(bh.ov(I.hcP))});
            Intent intent;
            Intent intent2;
            if (bh.ov(I.hcH)) {
                if (!bh.ov(I.hcP)) {
                    x.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[]{I.hcP, Integer.valueOf(I.hcQ), I.fzO});
                    intent = new Intent();
                    intent.putExtra("bill_no", I.hcP);
                    intent.putExtra("launcher_user_name", I.fzO);
                    intent.putExtra("enter_scene", 1);
                    intent.putExtra("chatroom", aVar.crz());
                    d.b(aVar.getContext(), "aa", ".ui.PaylistAAUI", intent);
                    com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
                } else if (!(bh.ov(str2) || bh.ov(str2))) {
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str2);
                    d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                }
            } else if (I.hcH.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                intent = new Intent();
                intent.putExtra("key_way", 1);
                intent.putExtra("key_native_url", I.hcH);
                intent.putExtra("key_username", aVar.crz());
                intent.putExtra("key_static_from_scene", 100002);
                d.b(aVar.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
            } else if (I.hcH.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                int i;
                Intent intent3 = new Intent();
                String str3 = "key_way";
                if (aVar.ysk) {
                    i = 0;
                } else {
                    i = 1;
                }
                intent3.putExtra(str3, i);
                intent3.putExtra("key_native_url", I.hcH);
                intent3.putExtra("key_username", aVar.crz());
                d.b(aVar.getContext(), "luckymoney", ".ui.LuckyMoneyReceiveUI", intent3);
            } else {
                x.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + I.hcH + ", go webview:" + str2);
                if (!bh.ov(str2)) {
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str2);
                    d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                }
            }
        }
        return true;
    }
}
