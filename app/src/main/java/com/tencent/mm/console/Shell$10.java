package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;

class Shell$10 implements Shell$a {
    Shell$10() {
    }

    public final void m(Intent intent) {
        r.idZ = intent.getIntExtra("flag", 0);
        x.w("MicroMsg.Shell", "dkwt shell [%d]", new Object[]{Integer.valueOf(r.idZ)});
    }
}
