package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.console.Shell.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;

class Shell$9 implements a {
    Shell$9() {
    }

    public final void m(Intent intent) {
        r.idx = intent.getStringExtra("acc");
        r.idy = intent.getStringExtra("pass");
        x.w("MicroMsg.Shell", "dkwt shell [%s %s]", new Object[]{r.idx, r.idy});
    }
}
