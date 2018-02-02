package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.search.ui.a.b.b;

public class p$a extends b {
    final /* synthetic */ p qeR;

    public p$a(p pVar) {
        this.qeR = pVar;
        super(pVar);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
        p pVar = (p) bVar;
        a(this.qeR.mMb.mLA, pVar.iVU);
        d.a(context, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", pVar.username).putExtra("finish_direct", true));
        return true;
    }
}
