package com.tencent.d.a.c;

import junit.framework.Assert;

public final class g {
    private static volatile a Acn = new a() {
        private boolean Aco = false;

        public final void cFV() {
            c.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
            this.Aco = true;
        }

        public final boolean cFU() {
            return this.Aco;
        }
    };

    public interface a {
        boolean cFU();

        void cFV();
    }

    public static void a(a aVar) {
        Assert.assertNotNull(aVar);
        Acn = aVar;
    }

    public static void cFT() {
        Acn.cFV();
    }

    public static boolean cFU() {
        return Acn.cFU();
    }
}
