package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.y.g.a;

class c$2 implements OnClickListener {
    final /* synthetic */ a jrh;
    final /* synthetic */ c yqf;
    final /* synthetic */ String yqh;
    final /* synthetic */ int yqi;

    c$2(c cVar, a aVar, String str, int i) {
        this.yqf = cVar;
        this.jrh = aVar;
        this.yqh = str;
        this.yqi = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.a(this.yqf, new x(2, new aj(this.jrh.appId, 0, "1")));
        j jVar = q.a.vcu;
        if (jVar != null) {
            c.a(this.yqf).thisActivity();
            jVar.a(this.yqh, this.jrh.appId, this.jrh.type, this.yqi, this.jrh.mediaTagName, 1);
        }
    }
}
