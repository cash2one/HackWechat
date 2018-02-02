package oicq.wlogin_sdk.a;

public final class ah extends a {
    public int Axy;

    public ah() {
        this.Axy = 0;
        this.Awh = 325;
    }

    public final byte[] cb(byte[] bArr) {
        int length;
        if (bArr != null) {
            length = bArr.length + 0;
        } else {
            length = 0;
        }
        Object obj = new byte[length];
        if (obj.length > 0) {
            System.arraycopy(bArr, 0, obj, 0, length);
        }
        this.Axy = obj.length;
        super.Jn(this.Awh);
        super.U(obj, obj.length);
        super.cJQ();
        return super.cJM();
    }
}
