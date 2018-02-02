package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;

public final class v extends b {
    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (i == -1879048183) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddF);
        view.setTag(new a(this).dD(view));
        return view;
    }

    public final void a(a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
        g$a com_tencent_mm_y_g_a;
        a aVar2 = (a) aVar;
        g fp = an.bYS().fp(auVar.field_msgId);
        String str2 = auVar.field_content;
        if (fp == null || str2 == null) {
            String str3 = "MicrMsg.ChattingItemHardDeviceMsgLike";
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
        if (com_tencent_mm_y_g_a != null && (com_tencent_mm_y_g_a.showType == 2 || com_tencent_mm_y_g_a.hbV == 2 || com_tencent_mm_y_g_a.hbV == 4)) {
            b.p(aVar2.hvY, com_tencent_mm_y_g_a.hbZ);
            aVar2.yMx.O(chattingUI$a.getResources().getDimension(R.f.bvK));
            aVar2.yMx.setTextColor(Color.parseColor("#BF000000"));
            aVar2.yMx.setEllipsize(TruncateAt.END);
            aVar2.yMx.cpw();
            aVar2.yMx.ygb = true;
            aVar2.yMx.setText(i.a(chattingUI$a.getContext(), com_tencent_mm_y_g_a.hbY));
        }
        aVar.yIy.setOnLongClickListener(s(chattingUI$a));
        aVar.yIy.setOnTouchListener(chattingUI$a.ysf.ysV);
        aVar.yIy.setTag(arVar);
        aVar.yIy.setOnClickListener(t(chattingUI$a));
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
        x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
        if (auVar == null) {
            x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
            return false;
        }
        String str = auVar.field_content;
        g$a I = g$a.I(str, auVar.field_reserved);
        if (I == null) {
            x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
            return false;
        }
        x.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", new Object[]{I.url});
        if (t.ov(I.url)) {
            ar.Hg();
            if (c.EY().WO(I.hbZ).AG()) {
                x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
                return false;
            } else if (I.showType == 2) {
                if (t.ov(I.hbH)) {
                    Intent intent = new Intent();
                    intent.putExtra("key_is_latest", true);
                    intent.putExtra("app_username", I.appName);
                    intent.putExtra("device_type", I.hbW);
                    intent.putExtra("locate_to_username", I.hbZ);
                    d.b(chattingUI$a.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                } else {
                    r1 = new Intent();
                    r1.putExtra("key_rank_info", str);
                    r1.putExtra("key_rank_semi", auVar.field_reserved);
                    r1.putExtra("key_rank_title", I.hbS);
                    r1.putExtra("key_champion_info", I.hbT);
                    r1.putExtra("key_champion_coverimg", I.hbT);
                    r1.putExtra("rank_id", I.hbH);
                    r1.putExtra("app_username", I.appName);
                    r1.putExtra("device_type", I.hbW);
                    r1.putExtra("key_champioin_username", I.hbR);
                    r1.putExtra("locate_to_username", I.hbZ);
                    d.b(chattingUI$a.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", r1);
                }
                com.tencent.mm.plugin.sport.b.d.pY(30);
                return false;
            } else if (I.showType != 4) {
                return false;
            } else {
                r1 = new Intent();
                r1.putExtra("username", I.hbZ);
                r1.putExtra("app_username", "gh_43f2581f6fd6");
                d.b(chattingUI$a.getContext(), "exdevice", ".ui.ExdeviceProfileUI", r1);
                com.tencent.mm.plugin.sport.b.d.pY(29);
                return false;
            }
        }
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", I.url);
        d.b(chattingUI$a.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
        return true;
    }
}
