package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class b extends a {
    int AwS;
    int AwT;
    int AwU;
    int AwV;
    byte[] AwW;

    public b() {
        this.AwS = 4;
        this.AwT = 14;
        this.AwU = 1;
        this.AwV = 20;
        this.AwW = new byte[2];
        this.Awh = 1;
    }

    public final Boolean cJR() {
        if (this.AwR < 20) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public final byte[] g(long j, byte[] bArr) {
        Object obj = new byte[this.AwV];
        util.A(obj, 0, this.AwU);
        util.B(obj, 2, util.cJW());
        util.B(obj, 6, (int) j);
        util.d(obj, 10, util.cJY());
        System.arraycopy(bArr, 0, obj, 14, bArr.length);
        util.A(obj, bArr.length + 14, 0);
        super.Jn(this.Awh);
        super.U(obj, this.AwV);
        super.cJQ();
        return super.cJM();
    }
}
