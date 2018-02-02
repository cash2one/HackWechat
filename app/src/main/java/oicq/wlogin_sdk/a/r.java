package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class r extends a {
    int Axl;
    int Axm;

    public r() {
        this.Axl = 0;
        this.Axm = 0;
        this.Awh = 278;
    }

    public final byte[] a(int i, int i2, long[] jArr) {
        this.Axl = 10;
        byte[] bArr = new byte[this.Axl];
        util.z(bArr, 0, this.Axm);
        util.B(bArr, 1, i);
        util.B(bArr, 5, i2);
        util.z(bArr, 9, 0);
        super.Jn(this.Awh);
        super.U(bArr, this.Axl);
        super.cJQ();
        return super.cJM();
    }
}
