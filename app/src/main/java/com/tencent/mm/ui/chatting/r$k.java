package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.ui.chatting.viewitems.ar;

public class r$k extends d {
    public r$k(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        int i = arVar.tid;
        String str = arVar.hdm;
        String str2 = arVar.desc;
        String str3 = arVar.iconUrl;
        String str4 = arVar.secondUrl;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", aVar.crz());
            intent.putExtra("rawUrl", arVar.gjD);
            intent.putExtra("topic_id", i);
            intent.putExtra("topic_name", str);
            intent.putExtra("topic_desc", str2);
            intent.putExtra("topic_icon_url", str3);
            intent.putExtra("topic_ad_url", str4);
            intent.putExtra("extra_scence", 22);
            com.tencent.mm.bm.d.b(aVar.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
            return;
        }
        x.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    }
}
