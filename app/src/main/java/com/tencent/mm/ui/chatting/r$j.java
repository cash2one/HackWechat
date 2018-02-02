package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.ui.chatting.viewitems.ar;

public class r$j extends d {
    public r$j(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        Object obj = arVar.fqV;
        if (TextUtils.isEmpty(obj)) {
            obj = ((c) g.k(c.class)).getEmojiMgr().yh(arVar.gjD);
        }
        if (TextUtils.isEmpty(obj)) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", aVar.crz());
            intent.putExtra("rawUrl", arVar.gjD);
            com.tencent.mm.bm.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("extra_id", obj);
        intent2.putExtra("extra_name", arVar.title);
        if (arVar.yOF) {
            intent2.putExtra("download_entrance_scene", 20);
            intent2.putExtra("preceding_scence", 3);
            intent2.putExtra("reward_tip", true);
            com.tencent.mm.plugin.report.service.g.pQN.h(12953, Integer.valueOf(1), obj);
        } else if (arVar.yOG) {
            intent2.putExtra("download_entrance_scene", 25);
            intent2.putExtra("preceding_scence", 9);
            intent2.putExtra("reward_tip", true);
        } else {
            intent2.putExtra("download_entrance_scene", 22);
            intent2.putExtra("preceding_scence", 122);
            com.tencent.mm.plugin.report.service.g.pQN.h(10993, Integer.valueOf(2), obj);
        }
        com.tencent.mm.bm.d.b(aVar.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent2);
    }
}
