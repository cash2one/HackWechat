package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ao extends a {
    int AxG;
    int AxH;

    public ao() {
        this.AxG = 0;
        this.AxH = 0;
        this.Awh = 2;
    }

    public final byte[] n(byte[] bArr, byte[] bArr2) {
        this.AxG = (bArr.length + 6) + bArr2.length;
        Object obj = new byte[this.AxG];
        util.A(obj, 0, this.AxH);
        util.A(obj, 2, bArr.length);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        int length = bArr.length + 4;
        util.A(obj, length, bArr2.length);
        System.arraycopy(bArr2, 0, obj, length + 2, bArr2.length);
        super.Jn(this.Awh);
        super.U(obj, this.AxG);
        super.cJQ();
        return super.cJM();
    }
}
