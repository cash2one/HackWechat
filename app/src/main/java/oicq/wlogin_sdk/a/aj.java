package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aj extends a {
    public aj() {
        this.Awh = 327;
    }

    private static int cc(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > 32) {
            return 32;
        }
        return bArr.length;
    }

    public final byte[] a(long j, byte[] bArr, byte[] bArr2) {
        int cc = cc(bArr);
        int cc2 = cc(bArr2);
        Object obj = new byte[(((cc + 6) + 2) + cc2)];
        util.d(obj, 0, j);
        util.A(obj, 4, cc);
        System.arraycopy(bArr, 0, obj, 6, cc);
        cc += 6;
        util.A(obj, cc, cc2);
        System.arraycopy(bArr2, 0, obj, cc + 2, cc2);
        super.Jn(this.Awh);
        super.U(obj, obj.length);
        super.cJQ();
        return super.cJM();
    }
}
