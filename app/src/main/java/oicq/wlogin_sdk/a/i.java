package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class i extends a {
    int Axi;

    public i() {
        this.Axi = 6;
        this.Awh = 263;
    }

    public final byte[] z(int i, int i2, int i3, int i4) {
        byte[] bArr = new byte[this.Axi];
        util.A(bArr, 0, 0);
        util.z(bArr, 2, 1);
        util.A(bArr, 3, 102400);
        util.z(bArr, 5, 1);
        super.Jn(this.Awh);
        super.U(bArr, this.Axi);
        super.cJQ();
        return super.cJM();
    }
}
