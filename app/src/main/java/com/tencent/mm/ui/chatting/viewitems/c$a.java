package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.z.s;

final class c$a {
    static void a(Intent intent, a aVar, au auVar, b bVar) {
        String str;
        int i;
        Bundle bundle;
        String crz = aVar.crz();
        String a = bVar.a(aVar, auVar);
        Bundle bundle2 = new Bundle();
        if (aVar.ysk) {
            str = "stat_scene";
            i = 2;
            bundle = bundle2;
        } else {
            str = "stat_scene";
            if (s.gF(crz)) {
                i = 7;
                bundle = bundle2;
            } else {
                i = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
        bundle2.putString("stat_chat_talker_username", crz);
        bundle2.putString("stat_send_msg_user", a);
        intent.putExtra("_stat_obj", bundle2);
    }
}
