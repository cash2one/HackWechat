package com.tencent.mm.plugin.favorite.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.favorite.a.a.a;
import com.tencent.mm.sdk.platformtools.af;
import java.util.Iterator;

class a$2 extends af {
    final /* synthetic */ a mpx;

    a$2(a aVar, Looper looper) {
        this.mpx = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        Iterator it = this.mpx.mpt.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.onFinish();
            }
        }
        this.mpx.mpt.clear();
    }
}
