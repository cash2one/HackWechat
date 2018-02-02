package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.d.b;
import com.qq.taf.jce.JceStruct;
import java.nio.charset.Charset;

public final class j {
    public int asN;
    public byte[] data;
    public int position;

    public j(int i) {
        this.data = new byte[i];
        this.asN = i;
    }

    public j(byte[] bArr) {
        this.data = bArr;
        this.asN = bArr.length;
    }

    public j(byte[] bArr, int i) {
        this.data = bArr;
        this.asN = i;
    }

    public final void reset(int i) {
        l(capacity() < i ? new byte[i] : this.data, i);
    }

    public final void l(byte[] bArr, int i) {
        this.data = bArr;
        this.asN = i;
        this.position = 0;
    }

    public final int lF() {
        return this.asN - this.position;
    }

    public final void cU(int i) {
        boolean z = i >= 0 && i <= this.data.length;
        a.am(z);
        this.asN = i;
    }

    public final int capacity() {
        return this.data == null ? 0 : this.data.length;
    }

    public final void cR(int i) {
        boolean z = true;
        if (i < 0 || i > this.asN) {
            b.i("ExoPlayer", "position%d, limit:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.asN)});
        }
        if (i < 0 || i > this.asN) {
            z = false;
        }
        a.am(z);
        this.position = i;
    }

    public final void cV(int i) {
        cR(this.position + i);
    }

    public final void c(i iVar, int i) {
        readBytes(iVar.data, 0, i);
        iVar.cR(0);
    }

    public final void readBytes(byte[] bArr, int i, int i2) {
        System.arraycopy(this.data, this.position, bArr, i, i2);
        this.position += i2;
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & 255;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final int lG() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 16;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final long aK() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & 255);
    }

    public final long readLong() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public final int lH() {
        return (((readUnsignedByte() << 21) | (readUnsignedByte() << 14)) | (readUnsignedByte() << 7)) | readUnsignedByte();
    }

    public final int lI() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readInt);
    }

    public final long lJ() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        throw new IllegalStateException("Top bit not zero: " + readLong);
    }

    public final String readString(int i) {
        return a(i, Charset.forName("UTF-8"));
    }

    public final String a(int i, Charset charset) {
        String str = new String(this.data, this.position, i, charset);
        this.position += i;
        return str;
    }

    public final String lK() {
        if (lF() == 0) {
            return null;
        }
        int i = this.position;
        while (i < this.asN && this.data[i] != (byte) 0) {
            i++;
        }
        String str = new String(this.data, this.position, i - this.position);
        this.position = i;
        if (this.position < this.asN) {
            this.position++;
        }
        return str;
    }

    public final String readLine() {
        if (lF() == 0) {
            return null;
        }
        int i = this.position;
        while (i < this.asN && !t.cY(this.data[i])) {
            i++;
        }
        if (i - this.position >= 3 && this.data[this.position] == (byte) -17 && this.data[this.position + 1] == (byte) -69 && this.data[this.position + 2] == (byte) -65) {
            this.position += 3;
        }
        String str = new String(this.data, this.position, i - this.position);
        this.position = i;
        if (this.position == this.asN) {
            return str;
        }
        if (this.data[this.position] == JceStruct.SIMPLE_LIST) {
            this.position++;
            if (this.position == this.asN) {
                return str;
            }
        }
        if (this.data[this.position] == (byte) 10) {
            this.position++;
        }
        return str;
    }
}
