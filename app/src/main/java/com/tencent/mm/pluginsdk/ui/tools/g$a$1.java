package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.pluginsdk.ui.tools.g.a;
import com.tencent.mm.sdk.platformtools.af;

class g$a$1 extends af {
    final /* synthetic */ g vxs;
    final /* synthetic */ a vxt;

    g$a$1(a aVar, Looper looper, g gVar) {
        this.vxt = aVar;
        this.vxs = gVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        a aVar = this.vxt;
        Object obj = message.obj;
        if (obj != null && aVar.vxr.size() < aVar.vxq) {
            aVar.vxr.add(obj);
        }
    }
}
