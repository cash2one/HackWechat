package com.tencent.mm.plugin.normsg.a;

import android.view.View;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public enum d implements b {
    ;
    
    private static b oSv;

    private static class a implements b {
        private a() {
        }

        public final String t(boolean z, boolean z2) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final void T(int i, int i2, int i3) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
        }

        public final String GG(String str) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return str;
        }

        public final String a(Object[][] objArr) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String tX(int i) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String hc(boolean z) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String bfH() {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final boolean bfI() {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final boolean b(Object obj, Class cls) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final byte[] bfJ() {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return new byte[0];
        }

        public final boolean bA(Object obj) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final void a(View view, Class<? extends b> cls) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
        }

        public final void tY(int i) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
        }
    }

    private d(String str) {
    }

    static {
        oSv = new a();
    }

    public static void a(b bVar) {
        if (bVar != null) {
            oSv = bVar;
        }
    }

    public final String t(boolean z, boolean z2) {
        return oSv.t(z, z2);
    }

    public final void T(int i, int i2, int i3) {
        oSv.T(i, i2, i3);
    }

    public final String GG(String str) {
        return oSv.GG(str);
    }

    public final String a(Object[][] objArr) {
        return oSv.a(objArr);
    }

    public final String tX(int i) {
        return oSv.tX(i);
    }

    public final String hc(boolean z) {
        return oSv.hc(z);
    }

    public final String bfH() {
        return oSv.bfH();
    }

    public final boolean bfI() {
        return oSv.bfI();
    }

    public final boolean b(Object obj, Class cls) {
        return oSv.b(obj, cls);
    }

    public final byte[] bfJ() {
        return oSv.bfJ();
    }

    public final boolean bA(Object obj) {
        return oSv.bA(obj);
    }

    public final void a(View view, Class<? extends b> cls) {
        oSv.a(view, cls);
    }

    public final void tY(int i) {
        oSv.tY(i);
    }
}
