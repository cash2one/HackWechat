package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.ui.chatting.viewitems.ar;

public class r$g extends d {
    public r$g(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        Intent intent = new Intent();
        intent.putExtra("geta8key_username", aVar.crz());
        intent.putExtra("rawUrl", arVar.gjD);
        com.tencent.mm.bm.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }
}
