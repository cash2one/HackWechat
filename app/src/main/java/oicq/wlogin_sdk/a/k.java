package oicq.wlogin_sdk.a;

public final class k extends a {
    int Axk;

    public k() {
        this.Axk = 0;
        this.Awh = 265;
    }

    public final byte[] bZ(byte[] bArr) {
        this.Axk = bArr.length;
        Object obj = new byte[this.Axk];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.Jn(this.Awh);
        super.U(obj, this.Axk);
        super.cJQ();
        return super.cJM();
    }
}
