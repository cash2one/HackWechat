package com.tencent.d.a.a;

import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class a$d {
    final Signature AbL;
    final Cipher AbM;
    final Mac AbN;

    public a$d(Signature signature) {
        this.AbL = signature;
        this.AbM = null;
        this.AbN = null;
    }

    public a$d(Cipher cipher) {
        this.AbM = cipher;
        this.AbL = null;
        this.AbN = null;
    }

    public a$d(Mac mac) {
        this.AbN = mac;
        this.AbM = null;
        this.AbL = null;
    }
}
