package oicq.wlogin_sdk.a;

public final class j extends a {
    int Axj;

    public j() {
        this.Axj = 0;
        this.Awh = 264;
    }

    public final byte[] bY(byte[] bArr) {
        this.Axj = bArr.length;
        Object obj = new byte[this.Axj];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.Jn(this.Awh);
        super.U(obj, this.Axj);
        super.cJQ();
        return super.cJM();
    }
}
