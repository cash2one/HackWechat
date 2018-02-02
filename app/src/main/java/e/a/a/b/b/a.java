package e.a.a.b.b;

import com.tencent.wcdb.FileUtils;
import java.io.UnsupportedEncodingException;

public final class a {
    private final int asN;
    private final byte[] buffer;
    private int position = 0;

    public a(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.asN = i2 + 0;
    }

    public static int h(int i, String str) {
        if (str == null) {
            return 0;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + (dX(i) + dZ(bytes.length));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported.");
        }
    }

    public final void dW(int i) {
        byte b = (byte) i;
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b;
    }

    public final void o(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            if (bArr == null) {
                return;
            }
            if (this.asN - this.position >= length) {
                System.arraycopy(bArr, 0, this.buffer, this.position, length);
                this.position = length + this.position;
                return;
            }
            int i = this.asN - this.position;
            System.arraycopy(bArr, 0, this.buffer, this.position, i);
            int i2 = i + 0;
            length -= i;
            this.position = this.asN;
            if (length <= this.asN) {
                System.arraycopy(bArr, i2, this.buffer, 0, length);
                this.position = length;
            }
        }
    }

    public final void aF(int i, int i2) {
        dY(e.a.a.b.a.aG(i, i2));
    }

    public static int dX(int i) {
        return dZ(e.a.a.b.a.aG(i, 0));
    }

    public final void dY(int i) {
        while ((i & -128) != 0) {
            dW((i & 127) | FileUtils.S_IWUSR);
            i >>>= 7;
        }
        dW(i);
    }

    public static int dZ(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    public final void ad(long j) {
        while ((-128 & j) != 0) {
            dW((((int) j) & 127) | FileUtils.S_IWUSR);
            j >>>= 7;
        }
        dW((int) j);
    }
}
