package com.tencent.d.a.a;

import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class b$c {
    final Signature AbL;
    final Cipher AbM;
    final Mac AbN;

    public b$c(Signature signature) {
        this.AbL = signature;
        this.AbM = null;
        this.AbN = null;
    }

    public b$c(Cipher cipher) {
        this.AbM = cipher;
        this.AbL = null;
        this.AbN = null;
    }

    public b$c(Mac mac) {
        this.AbN = mac;
        this.AbM = null;
        this.AbL = null;
    }
}
