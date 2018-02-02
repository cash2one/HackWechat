package oicq.wlogin_sdk.a;

import com.tencent.wcdb.FileUtils;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a {
    public int AvV = FileUtils.S_IWUSR;
    public int AvW = 0;
    int AwP = 0;
    public int AwQ = 4;
    public int AwR = 0;
    public byte[] Awb = new byte[this.AvV];
    public int Awh = 0;

    public final byte[] cJM() {
        Object obj = new byte[this.AvW];
        System.arraycopy(this.Awb, 0, obj, 0, this.AvW);
        return obj;
    }

    public final byte[] cJP() {
        Object obj = new byte[this.AwR];
        System.arraycopy(this.Awb, this.AwQ, obj, 0, this.AwR);
        return obj;
    }

    public final void Jn(int i) {
        util.A(this.Awb, this.AvW, i);
        this.AvW += 2;
        util.A(this.Awb, this.AvW, 0);
        this.AvW += 2;
    }

    public final void cJQ() {
        util.A(this.Awb, 2, this.AvW - this.AwQ);
    }

    public final void U(byte[] bArr, int i) {
        if (i > this.AvV - this.AwQ) {
            this.AvV = (this.AwQ + i) + 64;
            Object obj = new byte[this.AvV];
            System.arraycopy(this.Awb, 0, obj, 0, this.AvW);
            this.Awb = obj;
        }
        this.AwR = i;
        System.arraycopy(bArr, 0, this.Awb, this.AvW, i);
        this.AvW += i;
    }

    private static int x(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int i3 = i;
        while (i3 < length && i3 + 2 <= length) {
            if (util.X(bArr, i3) != i2) {
                i3 += 2;
                if (i3 + 2 > length) {
                    break;
                }
                i3 += util.X(bArr, i3) + 2;
            } else {
                return i3;
            }
        }
        return -1;
    }

    public final int y(byte[] bArr, int i, int i2) {
        int x = x(bArr, i, this.Awh);
        if (x < 0) {
            return -1;
        }
        int i3 = i2 - (x - i);
        if (this.AwQ >= i3) {
            return -1;
        }
        this.AwR = util.X(bArr, x + 2);
        if (this.AwQ + this.AwR > i3) {
            return -1;
        }
        int i4 = this.AwQ + this.AwR;
        if (i4 > this.AvV) {
            this.AvV = i4 + FileUtils.S_IWUSR;
            this.Awb = new byte[this.AvV];
        }
        this.AvW = i4;
        System.arraycopy(bArr, x, this.Awb, 0, i4);
        this.Awh = util.X(bArr, x);
        this.AwR = i4 - this.AwQ;
        if (cJR().booleanValue()) {
            return (this.AwQ + x) + this.AwR;
        }
        return -1005;
    }

    public final int b(byte[] bArr, int i, int i2, byte[] bArr2) {
        int x = x(bArr, i, this.Awh);
        if (x < 0) {
            return -1;
        }
        int i3 = i2 - (x - i);
        Object obj = new byte[i3];
        System.arraycopy(bArr, x, obj, 0, i3);
        if (this.AwQ >= i3) {
            return -1;
        }
        this.AwR = util.X(obj, 2);
        if (this.AwQ + this.AwR > i3) {
            return -1;
        }
        Object decrypt = d.decrypt(obj, this.AwQ, this.AwR, bArr2);
        if (decrypt == null) {
            return -1015;
        }
        if (this.AwQ + decrypt.length > this.AvV) {
            this.AvV = this.AwQ + decrypt.length;
            this.Awb = new byte[this.AvV];
        }
        this.AvW = 0;
        System.arraycopy(obj, 0, this.Awb, 0, this.AwQ);
        this.AvW += this.AwQ;
        System.arraycopy(decrypt, 0, this.Awb, this.AvW, decrypt.length);
        this.AvW += decrypt.length;
        this.AwR = decrypt.length;
        return !cJR().booleanValue() ? -1005 : 0;
    }

    public Boolean cJR() {
        return Boolean.valueOf(true);
    }
}
