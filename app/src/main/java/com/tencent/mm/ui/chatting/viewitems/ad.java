package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.ac.a;

final class ad implements a {
    ad() {
    }

    public final void b(b.a aVar, int i, ChattingUI.a aVar2, au auVar) {
        ac$b com_tencent_mm_ui_chatting_viewitems_ac_b = (ac$b) aVar;
        com_tencent_mm_ui_chatting_viewitems_ac_b.yMh.setText(auVar.field_content);
        Bundle bundle = new Bundle();
        bundle.putString("chatroom_name", aVar2.crz());
        bundle.putLong("msg_id", auVar.field_msgId);
        if ((auVar.field_flag & 8) != 0) {
            i.a(com_tencent_mm_ui_chatting_viewitems_ac_b.yMh, 1, false, bundle);
            com_tencent_mm_ui_chatting_viewitems_ac_b.yMh.setClickable(true);
        } else {
            i.a(com_tencent_mm_ui_chatting_viewitems_ac_b.yMh, bundle);
        }
        com_tencent_mm_ui_chatting_viewitems_ac_b.yMh.invalidate();
    }
}
