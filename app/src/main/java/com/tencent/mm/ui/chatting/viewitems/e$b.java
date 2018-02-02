package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import java.util.Map;

public class e$b extends b {
    private final int yJX = 1;
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != 469762097) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddl);
        view.setTag(new e.a().du(view));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        g.a I;
        this.yqa = aVar2;
        String str2 = auVar.field_content;
        if (str2 != null) {
            I = g.a.I(str2, auVar.field_reserved);
        } else {
            I = null;
        }
        e.a aVar3 = (e.a) aVar;
        if (I != null) {
            aVar3.yJW.setText(auVar.field_isSend == 1 ? I.hcC : I.hcD);
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
            default:
                return false;
        }
    }

    public final boolean b(View view, a aVar, au auVar) {
        String str = auVar.field_content;
        if (str != null) {
            g.a I = g.a.I(str, auVar.field_reserved);
            if (!bh.ov(I.hcH)) {
                Intent intent;
                if (I.hcI == 1) {
                    x.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick hasplay, skip");
                    intent = new Intent();
                    intent.putExtra("key_native_url", I.hcH);
                    intent.putExtra("key_username", aVar.crz());
                    intent.putExtra("key_image_id", I.hcK);
                    intent.putExtra("key_image_aes_key", I.hcL);
                    intent.putExtra("key_image_length", I.hcM);
                    d.b(aVar.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                } else {
                    x.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
                    intent = new Intent();
                    intent.putExtra("key_native_url", I.hcH);
                    intent.putExtra("key_username", aVar.crz());
                    intent.putExtra("key_image_id", I.hcK);
                    intent.putExtra("key_image_aes_key", I.hcL);
                    intent.putExtra("key_image_length", I.hcM);
                    d.b(aVar.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                    I.hcI = 1;
                    auVar.setContent(g.a.a(I, null, null));
                    if (auVar != null && auVar.aNc()) {
                        try {
                            str = auVar.field_content;
                            int indexOf = str.indexOf("<msg>");
                            if (indexOf > 0 && indexOf < str.length()) {
                                str = str.substring(indexOf).trim();
                            }
                            Map y = bi.y(str, "msg");
                            if (y != null && y.size() > 0) {
                                auVar.dU(ax.at(y));
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", e.getMessage());
                        }
                    }
                    ar.Hg();
                    c.Fa().a(auVar.field_msgId, auVar);
                }
            }
        }
        return true;
    }
}
