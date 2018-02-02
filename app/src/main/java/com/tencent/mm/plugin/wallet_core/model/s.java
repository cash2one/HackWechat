package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.d.a.c.i;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Signature;

public enum s {
    ;
    
    public String mzI;
    public boolean mzJ;
    private Signature sPq;
    public i sPr;

    private s(String str) {
        this.mzI = null;
        this.mzJ = false;
        this.sPq = null;
        this.sPr = null;
    }

    public final void reset() {
        x.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
        this.sPq = null;
        this.mzI = null;
        this.mzJ = false;
    }
}
