package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.d.b.c.b;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements b {
    final /* synthetic */ c mzC;
    final /* synthetic */ k mzD;

    k$1(k kVar, c cVar) {
        this.mzD = kVar;
        this.mzC = cVar;
    }

    public final void aKB() {
        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo onStartAuthentication");
    }

    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationHelp helpCode: %d, helpString: %s", new Object[]{Integer.valueOf(i), charSequence});
        if (this.mzC != null) {
            this.mzC.aH(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, -1);
        }
    }

    public final void aKC() {
        k.a(this.mzD);
        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationSucceed");
    }

    public final void onAuthenticationFailed() {
        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationFailed");
        if (this.mzC != null) {
            this.mzC.aH(2002, -1);
        }
    }

    public final void aKD() {
        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationCancelled");
        k.a(this.mzD);
    }

    public final void onAuthenticationError(int i, CharSequence charSequence) {
        x.e("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), charSequence});
        k.a(this.mzD);
    }
}
