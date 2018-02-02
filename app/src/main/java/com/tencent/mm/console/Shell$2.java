package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;

class Shell$2 implements Shell$a {
    Shell$2() {
    }

    public final void m(Intent intent) {
        if (ac.cfw()) {
            String stringExtra = intent.getStringExtra("sql");
            String stringExtra2 = intent.getStringExtra("file");
            if (stringExtra != null && stringExtra.length() > 0) {
                g.Dm().F(new 1(this, stringExtra));
            } else if (stringExtra2 != null && stringExtra2.length() > 0) {
                g.Dm().F(new 2(this, stringExtra2));
            }
        }
    }
}
