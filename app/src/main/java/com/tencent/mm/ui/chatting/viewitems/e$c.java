package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ba;

public class e$c extends b {
    private ChattingUI$a yqa;

    public final boolean aXj() {
        return true;
    }

    public final boolean aj(int i, boolean z) {
        if (z && i == 469762097) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddQ);
        view.setTag(new e$a().du(view));
        return view;
    }

    public final void a(a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
        g$a I;
        this.yqa = chattingUI$a;
        String str2 = auVar.field_content;
        if (str2 != null) {
            I = g$a.I(str2, auVar.field_reserved);
        } else {
            I = null;
        }
        e$a com_tencent_mm_ui_chatting_viewitems_e_a = (e$a) aVar;
        if (I != null) {
            com_tencent_mm_ui_chatting_viewitems_e_a.yJW.setText(auVar.field_isSend == 1 ? I.hcC : I.hcD);
        }
        aVar.yIy.setOnClickListener(t(chattingUI$a));
        aVar.yIy.setOnLongClickListener(s(chattingUI$a));
        aVar.yIy.setOnTouchListener(chattingUI$a.ysf.ysV);
        aVar.yIy.setTag(new ar(auVar, this.yqa.ypn, i, null, (byte) 0));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((ar) view.getTag()).position, 100, 0, this.yqa.getString(R.l.dRH));
        return false;
    }

    public final boolean a(MenuItem menuItem, ChattingUI$a chattingUI$a, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                ba.aK(auVar.field_msgId);
                return true;
            default:
                return false;
        }
    }

    public final boolean b(View view, ChattingUI$a chattingUI$a, au auVar) {
        String str = auVar.field_content;
        if (str != null) {
            g$a I = g$a.I(str, auVar.field_reserved);
            if (!(I == null || bh.ov(I.hcH))) {
                Intent intent = new Intent();
                intent.putExtra("key_native_url", I.hcH);
                intent.putExtra("key_image_id", I.hcK);
                intent.putExtra("key_image_aes_key", I.hcL);
                intent.putExtra("key_image_length", I.hcM);
                intent.putExtra("key_username", chattingUI$a.crz());
                d.b(chattingUI$a.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
            }
        }
        return true;
    }
}
