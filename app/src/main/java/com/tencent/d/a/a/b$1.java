package com.tencent.d.a.a;

import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import com.tencent.d.a.c.c;

class b$1 extends AuthenticationCallback {
    final /* synthetic */ b$a AbO;

    b$1(b$a com_tencent_d_a_a_b_a) {
        this.AbO = com_tencent_d_a_a_b_a;
    }

    public final void onAuthenticationError(int i, CharSequence charSequence) {
        c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationError", new Object[0]);
        this.AbO.onAuthenticationError(i, charSequence);
    }

    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationHelp", new Object[0]);
        this.AbO.onAuthenticationHelp(i, charSequence);
    }

    public final void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        b$c com_tencent_d_a_a_b_c;
        c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
        b$a com_tencent_d_a_a_b_a = this.AbO;
        CryptoObject cryptoObject = authenticationResult.getCryptoObject();
        if (cryptoObject != null) {
            if (cryptoObject.getCipher() != null) {
                com_tencent_d_a_a_b_c = new b$c(cryptoObject.getCipher());
            } else if (cryptoObject.getSignature() != null) {
                com_tencent_d_a_a_b_c = new b$c(cryptoObject.getSignature());
            } else if (cryptoObject.getMac() != null) {
                com_tencent_d_a_a_b_c = new b$c(cryptoObject.getMac());
            }
            com_tencent_d_a_a_b_a.a(new b$b(com_tencent_d_a_a_b_c));
        }
        com_tencent_d_a_a_b_c = null;
        com_tencent_d_a_a_b_a.a(new b$b(com_tencent_d_a_a_b_c));
    }

    public final void onAuthenticationFailed() {
        c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationFailed", new Object[0]);
        this.AbO.onAuthenticationFailed();
    }
}
