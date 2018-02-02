package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;

class Shell$8 implements Shell$a {
    Shell$8() {
    }

    public final void m(Intent intent) {
        r.idw = intent.getStringExtra("errmsg");
        x.w("MicroMsg.Shell", "tiger set tigerIDCErrMsg =%s", new Object[]{r.idw});
    }
}
