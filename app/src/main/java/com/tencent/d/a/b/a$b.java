package com.tencent.d.a.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec.Builder;
import java.security.spec.AlgorithmParameterSpec;

@TargetApi(23)
class a$b extends a {
    private Builder AbQ = null;

    public a$b(String str, int i) {
        this.AbQ = new Builder(str, 4);
    }

    public final AlgorithmParameterSpec cFQ() {
        return this.AbQ.build();
    }

    @SuppressLint({"WrongConstant"})
    public final a M(String... strArr) {
        this.AbQ.setDigests(strArr);
        return this;
    }

    @SuppressLint({"WrongConstant"})
    public final a N(String... strArr) {
        this.AbQ.setSignaturePaddings(strArr);
        return this;
    }

    public final a cFR() {
        this.AbQ.setUserAuthenticationRequired(true);
        return this;
    }
}
