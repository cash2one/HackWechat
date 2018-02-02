package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aa extends a {
    int Axr;

    public aa() {
        this.Axr = 0;
        this.Awh = 296;
    }

    private static int V(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > i) {
            return i;
        }
        return bArr.length;
    }

    public final byte[] a(int i, int i2, int i3, byte[] bArr, byte[] bArr2) {
        int V = V(bArr, 32);
        int V2 = V(bArr2, 16);
        this.Axr = (((V + 11) + 2) + V2) + 2;
        Object obj = new byte[this.Axr];
        util.A(obj, 0, 0);
        util.z(obj, 2, i);
        util.z(obj, 3, i2);
        util.z(obj, 4, i3);
        util.B(obj, 5, 0);
        util.A(obj, 9, V);
        System.arraycopy(bArr, 0, obj, 11, V);
        V += 11;
        util.A(obj, V, V2);
        V += 2;
        System.arraycopy(bArr2, 0, obj, V, V2);
        util.A(obj, V + V2, 0);
        super.Jn(this.Awh);
        super.U(obj, this.Axr);
        super.cJQ();
        return super.cJM();
    }
}
