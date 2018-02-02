package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.b.4;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b.a;
import com.tencent.mm.sdk.platformtools.x;

class a$b$4$1 implements a {
    final /* synthetic */ 4 iTg;

    a$b$4$1(4 4) {
        this.iTg = 4;
    }

    public final void d(int i, Bundle bundle) {
        x.i("MicroMsg.IPCInvoke_DoAuthorize", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
        Bundle bundle2 = new Bundle();
        switch (i) {
            case 1:
            case 2:
                bundle2.putInt("retCode", 0);
                bundle2.putInt("resultCode", i);
                bundle2.putBundle("resultData", bundle);
                break;
            default:
                x.d("MicroMsg.IPCInvoke_DoAuthorize", "press back button!");
                bundle2.putInt("retCode", -1);
                break;
        }
        this.iTg.iTd.i(bundle2);
    }
}
