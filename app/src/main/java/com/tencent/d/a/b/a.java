package com.tencent.d.a.b;

import android.os.Build.VERSION;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public abstract class a {

    static class c extends a {
        private final String AbR;
        private int AbS;
        private int AbT = -1;
        private AlgorithmParameterSpec AbU;
        private X500Principal AbV;
        private BigInteger AbW;
        private Date AbX;
        private Date AbY;
        private Date AbZ;
        private Date Aca;
        private Date Acb;
        private String[] Acc;
        private String[] Acd;
        private String[] Ace;
        private String[] Acf;
        private boolean Acg = true;
        private boolean Ach;
        private int Aci = -1;

        public c(String str, int i) {
            if (str == null) {
                throw new NullPointerException("keystoreAlias == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("keystoreAlias must not be empty");
            } else {
                this.AbR = str;
                this.AbS = 4;
            }
        }

        public final a M(String... strArr) {
            this.Acc = a.O(strArr);
            return this;
        }

        public final a N(String... strArr) {
            this.Ace = a.O(strArr);
            return this;
        }

        public final a cFR() {
            this.Ach = true;
            return this;
        }

        public final AlgorithmParameterSpec cFQ() {
            return (AlgorithmParameterSpec) Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[]{String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, String[].class, String[].class, String[].class, String[].class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE}).newInstance(new Object[]{this.AbR, Integer.valueOf(this.AbT), this.AbU, this.AbV, this.AbW, this.AbX, this.AbY, this.AbZ, this.Aca, this.Acb, Integer.valueOf(this.AbS), this.Acc, this.Acd, this.Ace, this.Acf, Boolean.valueOf(this.Acg), Boolean.valueOf(this.Ach), Integer.valueOf(this.Aci)});
        }
    }

    public abstract a M(String... strArr);

    public abstract a N(String... strArr);

    public abstract AlgorithmParameterSpec cFQ();

    public abstract a cFR();

    public static a aby(String str) {
        if (!com.tencent.d.a.a.cFI()) {
            com.tencent.d.a.c.c.e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
            return new a();
        } else if (VERSION.SDK_INT >= 23) {
            return new b(str, 4);
        } else {
            return new c(str, 4);
        }
    }

    public static String[] O(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? strArr : (String[]) strArr.clone();
    }
}
