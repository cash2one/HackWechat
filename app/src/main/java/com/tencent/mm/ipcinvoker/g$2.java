package com.tencent.mm.ipcinvoker;

import com.tencent.mm.sdk.platformtools.x;

class g$2 implements Runnable {
    final /* synthetic */ String gMo;

    g$2(String str) {
        this.gMo = str;
    }

    public final void run() {
        b Bs = b.Bs();
        String str = this.gMo;
        if (e.fh(str)) {
            x.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", new Object[]{str});
            return;
        }
        Bs.ff(str);
    }
}
