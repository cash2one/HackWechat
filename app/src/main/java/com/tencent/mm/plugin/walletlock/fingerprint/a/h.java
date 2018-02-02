package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.d.a.c.i;
import com.tencent.d.b.a.e;
import com.tencent.d.b.c.a;
import com.tencent.d.b.c.b;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    public a mzB = null;

    class AnonymousClass1 implements b {
        final /* synthetic */ com.tencent.mm.plugin.walletlock.b.b tfB;
        final /* synthetic */ h tfC;

        public AnonymousClass1(h hVar, com.tencent.mm.plugin.walletlock.b.b bVar) {
            this.tfC = hVar;
            this.tfB = bVar;
        }

        public final void aKB() {
            x.v("MicroMsg.SoterFingerprintAuthManager", "alvinluo onStartAuthentication");
            if (this.tfB != null) {
                this.tfB.bNM();
            }
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationHelp errCode: %d, errMsg: %s and do nothing", new Object[]{Integer.valueOf(i), charSequence});
        }

        public final void aKC() {
            x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationSucceed");
            this.tfC.mzB = null;
        }

        public final void onAuthenticationFailed() {
            x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationFailed");
            if (this.tfB != null) {
                this.tfB.K(1, "not match");
            }
        }

        public final void aKD() {
            x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationCancelled");
            this.tfC.mzB = null;
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), charSequence});
            this.tfC.mzB = null;
        }
    }

    class AnonymousClass2 implements com.tencent.d.b.a.b<com.tencent.d.b.a.a> {
        final /* synthetic */ com.tencent.mm.plugin.walletlock.b.b tfB;
        final /* synthetic */ h tfC;

        public AnonymousClass2(h hVar, com.tencent.mm.plugin.walletlock.b.b bVar) {
            this.tfC = hVar;
            this.tfB = bVar;
        }

        public final /* synthetic */ void a(e eVar) {
            com.tencent.d.b.a.a aVar = (com.tencent.d.b.a.a) eVar;
            x.i("MicroMsg.SoterFingerprintAuthManager", "request auth onResult errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(aVar.errCode), aVar.fnL});
            if (aVar.isSuccess()) {
                g.tho.thq = (i) aVar.AcB;
                if (this.tfB != null) {
                    this.tfB.K(0, "authenticate ok");
                    return;
                }
                return;
            }
            com.tencent.mm.plugin.walletlock.b.h.ed(3, aVar.errCode);
            if (aVar.errCode == 25) {
                x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo too many trial");
                if (this.tfB != null) {
                    this.tfB.K(3, "too many trial");
                }
            } else if (aVar.errCode == 24) {
                x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo user cancelled");
                if (this.tfB != null) {
                    this.tfB.K(4, "user cancelled");
                }
            } else if (aVar.errCode == 18) {
                if (this.tfB != null) {
                    this.tfB.K(8, "no fingerprint enrolled in system");
                }
            } else if (this.tfB != null) {
                this.tfB.K(2, aVar.fnL);
            }
        }
    }
}
