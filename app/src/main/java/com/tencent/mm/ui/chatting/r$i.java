package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.ui.chatting.viewitems.ar;

public class r$i extends d {
    public r$i(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        int i = arVar.tid;
        String str = arVar.hdm;
        String str2 = arVar.desc;
        String str3 = arVar.iconUrl;
        String str4 = arVar.secondUrl;
        int i2 = arVar.pageType;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", aVar.crz());
            intent.putExtra("rawUrl", arVar.gjD);
            intent.putExtra("set_id", i);
            intent.putExtra("set_title", str);
            intent.putExtra("set_iconURL", str3);
            intent.putExtra("set_desc", str2);
            intent.putExtra("headurl", str4);
            intent.putExtra("pageType", i2);
            com.tencent.mm.bm.d.b(aVar.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            return;
        }
        x.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    }
}
