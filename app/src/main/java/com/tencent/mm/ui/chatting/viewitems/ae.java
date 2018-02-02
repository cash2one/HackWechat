package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.ac.a;
import com.tencent.mm.z.s;
import java.lang.ref.WeakReference;

final class ae implements a {
    ae() {
    }

    public final void b(b.a aVar, int i, ChattingUI.a aVar2, au auVar) {
        String str;
        int i2;
        Bundle bundle;
        String crz = aVar2.crz();
        ac$b com_tencent_mm_ui_chatting_viewitems_ac_b = (ac$b) aVar;
        Bundle bundle2 = new Bundle();
        bundle2.putString("conv_talker_username", crz);
        if (aVar2 instanceof AppBrandServiceChattingUI.a) {
            str = "scene";
            i2 = 10;
            bundle = bundle2;
        } else if (aVar2.ysk) {
            str = "scene";
            i2 = 2;
            bundle = bundle2;
        } else {
            str = "scene";
            if (s.gF(crz)) {
                i2 = 7;
                bundle = bundle2;
            } else {
                i2 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i2);
        bundle2.putLong("msg_id", auVar.field_msgId);
        bundle2.putLong("msg_sever_id", auVar.field_msgSvrId);
        bundle2.putString("send_msg_username", auVar.field_talker);
        e eVar = (e) g.h(e.class);
        long j = auVar.field_msgId;
        CharSequence a = eVar.a(auVar.field_content, bundle2, new WeakReference(aVar2.getContext()), new WeakReference(com_tencent_mm_ui_chatting_viewitems_ac_b.yMh));
        if (a == null || a.length() == 0) {
            com_tencent_mm_ui_chatting_viewitems_ac_b.mUL.setVisibility(8);
        } else {
            com_tencent_mm_ui_chatting_viewitems_ac_b.mUL.setVisibility(0);
            com_tencent_mm_ui_chatting_viewitems_ac_b.yMh.setText(a);
            com_tencent_mm_ui_chatting_viewitems_ac_b.yMh.setMovementMethod(av.getInstance());
        }
        com_tencent_mm_ui_chatting_viewitems_ac_b.yMh.setOnClickListener(new 1(this));
        com_tencent_mm_ui_chatting_viewitems_ac_b.yMh.invalidate();
    }
}
