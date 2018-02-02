package com.tencent.mm.plugin.wallet_core.model;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.c.b;

public final class h {
    public int sLY = 0;
    public String sLZ = "";
    public int sMa = 0;
    public String sMb = "";
    public int sMc = 0;
    public b sMd = new b();

    public h(Bundle bundle) {
        this.sLY = bundle.getInt("key_is_gen_cert", 0);
        this.sMa = bundle.getInt("key_is_hint_crt", 0);
        this.sMc = bundle.getInt("key_is_ignore_cert", 0);
        this.sLZ = bundle.getString("key_crt_token", "");
        this.sMb = bundle.getString("key_crt_wording", "");
        this.sMd = new b(this.sMb);
    }

    public final boolean bKY() {
        if (this.sMa == 0 || bh.ov(this.sMb)) {
            return false;
        }
        return true;
    }

    public final boolean bKZ() {
        if (this.sLY == 1) {
            return true;
        }
        return false;
    }

    public final boolean bLa() {
        if (bKZ() && this.sMc == 0) {
            return true;
        }
        return false;
    }
}
