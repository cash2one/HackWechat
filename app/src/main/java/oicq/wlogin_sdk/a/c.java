package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class c extends a {
    int AwX;
    int AwY;
    int AwZ;

    public c() {
        this.AwX = 1;
        this.AwY = util.Ayd;
        this.AwZ = 22;
        this.Awh = 256;
    }

    public final byte[] a(long j, long j2, int i, int i2) {
        byte[] bArr = new byte[this.AwZ];
        util.A(bArr, 0, this.AwX);
        util.B(bArr, 2, this.AwY);
        util.B(bArr, 6, (int) j);
        util.B(bArr, 10, 1);
        util.B(bArr, 14, i);
        util.B(bArr, 18, i2);
        super.Jn(this.Awh);
        super.U(bArr, this.AwZ);
        super.cJQ();
        return super.cJM();
    }
}
