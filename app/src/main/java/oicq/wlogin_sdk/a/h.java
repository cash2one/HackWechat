package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h extends a {
    int Axf;
    int Axg;
    int Axh;

    public h() {
        this.Axf = 1;
        this.Axg = 1;
        this.Axh = 69;
        this.Awh = 262;
        this.Axg = util.Ayd;
        if (util.Ayd <= 2) {
            this.Axf = 1;
            this.Axh = 69;
            return;
        }
        this.Axf = 2;
        this.Axh = 90;
    }

    public final byte[] a(long j, int i, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i2, byte[] bArr5) {
        if (util.Ayd <= 2) {
            Object obj = new byte[this.Axh];
            util.A(obj, 0, this.Axf);
            util.B(obj, 2, util.cJW());
            util.B(obj, 6, this.Axg);
            util.B(obj, 10, (int) j);
            util.B(obj, 14, i);
            util.c(obj, 18, j2);
            System.arraycopy(bArr, 0, obj, 26, bArr.length);
            int length = bArr.length + 26;
            System.arraycopy(bArr2, 0, obj, length, bArr2.length);
            length += bArr2.length;
            util.z(obj, length, 1);
            length++;
            System.arraycopy(bArr3, 0, obj, length, bArr3.length);
            System.arraycopy(bArr4, 0, obj, length + bArr3.length, bArr4.length);
            Object obj2 = new byte[24];
            System.arraycopy(bArr3, 0, obj2, 0, bArr3.length);
            util.c(obj2, 16, j2);
            byte[] b = d.b(obj, obj.length, c.cd(obj2));
            this.Axh = b.length;
            super.Jn(this.Awh);
            super.U(b, this.Axh);
            super.cJQ();
            return super.cJM();
        }
        obj = new byte[this.Axh];
        util.A(obj, 0, this.Axf);
        util.B(obj, 2, util.cJW());
        util.B(obj, 6, this.Axg);
        util.B(obj, 10, (int) j);
        util.B(obj, 14, i);
        util.c(obj, 18, j2);
        System.arraycopy(bArr, 0, obj, 26, bArr.length);
        length = bArr.length + 26;
        System.arraycopy(bArr2, 0, obj, length, bArr2.length);
        length += bArr2.length;
        util.z(obj, length, 1);
        length++;
        System.arraycopy(bArr3, 0, obj, length, bArr3.length);
        length += bArr3.length;
        System.arraycopy(bArr4, 0, obj, length, bArr4.length);
        length += bArr4.length;
        util.B(obj, length, 0);
        length += 4;
        util.z(obj, length, i2);
        length++;
        if (bArr5 == null || bArr5.length <= 0) {
            byte[] bArr6 = new byte[16];
            util.B(bArr6, 0, util.cJW());
            util.B(bArr6, 4, util.cJW());
            util.B(bArr6, 8, util.cJW());
            util.B(bArr6, 12, util.cJW());
        } else {
            System.arraycopy(bArr5, 0, obj, length, bArr5.length);
        }
        obj2 = new byte[24];
        System.arraycopy(bArr3, 0, obj2, 0, bArr3.length);
        util.c(obj2, 16, j2);
        b = d.b(obj, obj.length, c.cd(obj2));
        this.Axh = b.length;
        super.Jn(this.Awh);
        super.U(b, this.Axh);
        super.cJQ();
        return cJM();
    }
}
