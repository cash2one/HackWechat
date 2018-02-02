package com.tencent.mm.console;

import com.tencent.mm.network.a.c;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bd.a;

class b$17 implements a {
    b$17() {
    }

    public final void a(e eVar) {
        if (eVar != null) {
            int i;
            String[] iPsString = eVar.getIPsString(true);
            for (i = 0; i < iPsString.length; i++) {
                x.d("MicroMsg.CommandProcessor", "dkip long:%d  %s", new Object[]{Integer.valueOf(i), iPsString[i]});
                x.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[]{Integer.valueOf(i), c.oj(iPsString[i]).toString()});
            }
            iPsString = eVar.getIPsString(false);
            for (i = 0; i < iPsString.length; i++) {
                x.d("MicroMsg.CommandProcessor", "dkip short:%d %s", new Object[]{Integer.valueOf(i), iPsString[i]});
                x.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[]{Integer.valueOf(i), c.oj(iPsString[i]).toString()});
            }
        }
    }
}
