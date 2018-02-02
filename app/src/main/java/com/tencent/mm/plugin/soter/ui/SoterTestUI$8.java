package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.d.a.a;
import com.tencent.d.a.a.a.b;
import com.tencent.d.a.a.a.d;
import com.tencent.d.a.c.i;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Signature;
import java.security.SignatureException;

class SoterTestUI$8 implements OnClickListener {
    final /* synthetic */ SoterTestUI rSE;

    SoterTestUI$8(SoterTestUI soterTestUI) {
        this.rSE = soterTestUI;
    }

    public final void onClick(View view) {
        final Signature abw = a.abw("sample_auth_key_name");
        if (abw != null) {
            try {
                abw.update("challenge".getBytes());
                abw.sign();
                x.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
                SoterTestUI.a(this.rSE).setText("not passed: signature success without fingerprint authentication");
                return;
            } catch (SignatureException e) {
                x.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                r0 = com.tencent.d.a.a.a.if(this.rSE);
                com.tencent.d.a.a.a aVar;
                if (aVar.isHardwareDetected() && aVar.hasEnrolledFingerprints()) {
                    aVar.a(new d(abw), null, new b(this) {
                        final /* synthetic */ SoterTestUI$8 rSG;

                        public final void onAuthenticationError(int i, CharSequence charSequence) {
                            x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
                        }

                        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                            x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
                        }

                        public final void bCU() {
                            x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
                            try {
                                abw.update("challenge".getBytes());
                                i bN = a.bN(abw.sign());
                                SoterTestUI.a(this.rSG.rSE).setText(bN == null ? "not pass: exception occurs" : bN.toString());
                            } catch (SignatureException e) {
                                x.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                            }
                        }

                        public final void onAuthenticationFailed() {
                            x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
                        }

                        public final void aKD() {
                            super.aKD();
                        }
                    });
                    return;
                } else {
                    x.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
                    return;
                }
            }
        }
        x.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
    }
}
