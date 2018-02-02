package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
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
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ba;

public final class u extends b {
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (i == -1879048185) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddG);
        view.setTag(new a(this).dC(view));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        g.a aVar3;
        this.yqa = aVar2;
        a aVar4 = (a) aVar;
        g fp = an.bYS().fp(auVar.field_msgId);
        String str2 = auVar.field_content;
        if (fp == null || str2 == null) {
            String str3 = "MicroMsg.ChattingItemHardDeviceMsg";
            String str4 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(fp == null);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(auVar.field_msgId);
            objArr[3] = str;
            x.e(str3, str4, objArr);
            aVar3 = null;
        } else {
            aVar3 = g.a.I(str2, auVar.field_reserved);
        }
        ar arVar = new ar(auVar, aVar2.ypn, i, null, (byte) 0);
        HardDeviceChattingItemView hardDeviceChattingItemView = (HardDeviceChattingItemView) aVar.yIy;
        if (aVar3 != null && (aVar3.showType == 1 || aVar3.hbV == 1)) {
            int i2;
            if (t.ov(aVar3.hbQ)) {
                str3 = aVar3.hbM;
                str2 = aVar3.hbN;
                if (bh.ov(str3) || bh.ov(str2)) {
                    x.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", new Object[]{str3, str2});
                    str3 = "#ffffff";
                    str2 = "#ffffff";
                }
                Drawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.parseColor(str2)));
                stateListDrawable.addState(new int[]{16842908}, new ColorDrawable(Color.parseColor(str2)));
                stateListDrawable.addState(new int[]{16842766}, new ColorDrawable(Color.parseColor(str3)));
                stateListDrawable.addState(new int[0], new ColorDrawable(Color.parseColor(str3)));
                hardDeviceChattingItemView.setBackgroundDrawable(stateListDrawable);
                aVar3.hbQ = "#ffffff";
                str3 = aVar3.hbO;
                str4 = aVar3.hbP;
                int i3 = R.e.white;
                i2 = R.e.white;
                if (!(t.ov(str3) || t.ov(str4))) {
                    try {
                        i3 = Color.parseColor(str3);
                        i2 = Color.parseColor(str4);
                    } catch (IllegalArgumentException e) {
                        x.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
                    }
                }
                Drawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[]{16842919}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842908}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842766}, new ColorDrawable(i3));
                stateListDrawable2.addState(new int[0], new ColorDrawable(i3));
                aVar4.yMu.setBackgroundDrawable(stateListDrawable2);
            }
            str2 = aVar3.hbQ;
            if (aVar4 != null) {
                i2 = R.e.white;
                if (!t.ov(str2)) {
                    try {
                        i2 = Color.parseColor(str2);
                    } catch (IllegalArgumentException e2) {
                        x.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
                    }
                }
                aVar4.yMr.setTextColor(i2);
                aVar4.yMs.setTextColor(i2);
                aVar4.yMp.setTextColor(i2);
                aVar4.yMq.setTextColor(i2);
                aVar4.yMt.setTextColor(i2);
            }
            aVar4.yMr.setText(aVar3.hbI);
            aVar4.yMs.setText(aVar3.hbG);
            aVar4.yMp.setText(aVar3.hbK);
            aVar4.yMq.setText(aVar3.hbJ);
            aVar4.yMt.setText(aVar3.hbL);
            if (t.ov(aVar3.hbR)) {
                aVar4.yMv.setVisibility(8);
            } else {
                aVar4.yMv.setVisibility(0);
                b.p(aVar4.yMv, aVar3.hbR);
            }
        }
        aVar.yIy.setOnLongClickListener(s(aVar2));
        aVar.yIy.setOnTouchListener(aVar2.ysf.ysV);
        aVar.yIy.setTag(arVar);
        aVar.yIy.setOnClickListener(t(aVar2));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((ar) view.getTag()).position, 100, 0, this.yqa.getString(R.l.dRH));
        return false;
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
                }
                ba.aK(auVar.field_msgId);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        boolean z = false;
        String str = auVar.field_content;
        g.a I = g.a.I(str, auVar.field_reserved);
        if (I == null) {
            x.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
            return false;
        }
        x.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", new Object[]{I.url});
        if (t.ov(I.url)) {
            if (!t.ov(I.hbH)) {
                if (System.currentTimeMillis() - (((long) I.hbX) * 1000) >= 2592000000L) {
                    z = true;
                }
                if (!z) {
                    Intent intent = new Intent();
                    intent.putExtra("key_rank_info", str);
                    intent.putExtra("key_rank_semi", auVar.field_reserved);
                    intent.putExtra("key_rank_title", I.hbS);
                    intent.putExtra("key_champion_info", I.hbT);
                    intent.putExtra("key_champion_coverimg", I.hbT);
                    intent.putExtra("rank_id", I.hbH);
                    intent.putExtra("app_username", I.appName);
                    intent.putExtra("device_type", I.hbW);
                    intent.putExtra("key_champioin_username", I.hbR);
                    d.b(aVar.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                    com.tencent.mm.plugin.sport.b.d.pY(28);
                    return true;
                }
            }
            d.y(aVar.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
            return true;
        }
        intent = new Intent();
        intent.putExtra("rawUrl", I.url);
        d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }
}
