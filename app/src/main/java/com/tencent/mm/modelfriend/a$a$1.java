package com.tencent.mm.modelfriend;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Iterator;

class a$a$1 extends af {
    a$a$1(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (ar.Hj()) {
            a aVar = new a();
            int size = a.huY.size();
            boolean parseBoolean = Boolean.parseBoolean(message.obj.toString());
            Iterator it = a.huY.iterator();
            while (it.hasNext()) {
                ((b) it.next()).bM(parseBoolean);
            }
            a.huY.clear();
            x.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", Integer.valueOf(size), Long.valueOf(aVar.zi()));
        }
    }
}
