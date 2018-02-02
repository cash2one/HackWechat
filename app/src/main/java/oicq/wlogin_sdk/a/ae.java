package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ae extends a {
    int Axu;
    int Axv;

    public ae() {
        this.Axu = 0;
        this.Axv = 0;
        this.Awh = 322;
    }

    public final byte[] ca(byte[] bArr) {
        this.Axv = bArr.length + 4;
        Object obj = new byte[this.Axv];
        util.A(obj, 0, this.Axu);
        util.A(obj, 2, bArr.length);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        super.Jn(this.Awh);
        super.U(obj, obj.length);
        super.cJQ();
        return super.cJM();
    }
}
