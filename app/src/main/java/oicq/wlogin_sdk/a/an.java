package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class an extends a {
    int AxD;
    int AxE;
    int AxF;

    public an() {
        this.AxD = 22;
        this.AxE = 1;
        this.AxF = 1536;
        this.Awh = 24;
    }

    public final byte[] a(long j, int i, long j2, int i2) {
        byte[] bArr = new byte[this.AxD];
        util.A(bArr, 0, this.AxE);
        util.B(bArr, 2, this.AxF);
        util.B(bArr, 6, (int) j);
        util.B(bArr, 10, i);
        util.B(bArr, 14, (int) j2);
        util.A(bArr, 18, 0);
        util.A(bArr, 20, 0);
        super.Jn(this.Awh);
        super.U(bArr, this.AxD);
        super.cJQ();
        return super.cJM();
    }
}
