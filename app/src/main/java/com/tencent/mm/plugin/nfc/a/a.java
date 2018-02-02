package com.tencent.mm.plugin.nfc.a;

import java.io.Serializable;
import java.util.Arrays;

public final class a implements Serializable {
    private byte[] oRI;
    private transient int oRJ;
    private transient int oRK;
    private transient int oRL;

    public a(byte[] bArr) {
        this.oRI = (byte[]) bArr.clone();
        bfs();
    }

    public a(String str) {
        this.oRI = com.tencent.mm.plugin.nfc.d.a.hexStringToByteArray(str);
        bfs();
    }

    private void bfs() {
        int i = 65536;
        int i2 = 256;
        if (this.oRI.length < 4) {
            throw new IllegalArgumentException("apdu must be at least 4 bytes long");
        } else if (this.oRI.length != 4) {
            int i3 = this.oRI[4] & 255;
            if (this.oRI.length == 5) {
                if (i3 != 0) {
                    i2 = i3;
                }
                this.oRK = i2;
            } else if (i3 != 0) {
                if (this.oRI.length == i3 + 5) {
                    this.oRJ = i3;
                    this.oRL = 5;
                } else if (this.oRI.length == i3 + 6) {
                    this.oRJ = i3;
                    this.oRL = 5;
                    i3 = this.oRI[this.oRI.length - 1] & 255;
                    if (i3 != 0) {
                        i2 = i3;
                    }
                    this.oRK = i2;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.oRI.length + ", b1=" + i3);
                }
            } else if (this.oRI.length < 7) {
                throw new IllegalArgumentException("Invalid APDU: length=" + this.oRI.length + ", b1=" + i3);
            } else {
                i2 = ((this.oRI[5] & 255) << 8) | (this.oRI[6] & 255);
                if (this.oRI.length == 7) {
                    if (i2 == 0) {
                        i2 = 65536;
                    }
                    this.oRK = i2;
                } else if (i2 == 0) {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.oRI.length + ", b1=" + i3 + ", b2||b3=" + i2);
                } else if (this.oRI.length == i2 + 7) {
                    this.oRJ = i2;
                    this.oRL = 7;
                } else if (this.oRI.length == i2 + 9) {
                    this.oRJ = i2;
                    this.oRL = 7;
                    i2 = this.oRI.length - 2;
                    i2 = (this.oRI[i2 + 1] & 255) | ((this.oRI[i2] & 255) << 8);
                    if (i2 != 0) {
                        i = i2;
                    }
                    this.oRK = i;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.oRI.length + ", b1=" + i3 + ", b2||b3=" + i2);
                }
            }
        }
    }

    public final void tV(int i) {
        this.oRK = i;
        this.oRI[this.oRI.length - 1] = (byte) i;
    }

    public final byte[] getBytes() {
        return (byte[]) this.oRI.clone();
    }

    public final String toString() {
        return com.tencent.mm.plugin.nfc.d.a.byteArrayToHexString(this.oRI);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return Arrays.equals(this.oRI, ((a) obj).oRI);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.oRI);
    }
}
