package com.tencent.mm.v;

import android.util.Log;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

class g$1 implements Runnable {
    g$1() {
    }

    public final void run() {
        a aVar = b.gNk;
        c fn = a.fn("100295");
        if (fn == null) {
            x.i("MicroMsg.JSONFactory", "JSON lib type ABTest item is null.");
        } else if (fn.isValid()) {
            try {
                g.gy(bh.getInt((String) fn.chI().get("jsonLibType"), 1));
                x.i("MicroMsg.JSONFactory", "current jsonLibType is : %d", new Object[]{Integer.valueOf(g.bl())});
            } catch (Throwable e) {
                x.w("MicroMsg.JSONFactory", "parse jsonLibType error : %s", new Object[]{Log.getStackTraceString(e)});
            }
        } else {
            g.gy(1);
        }
    }
}
