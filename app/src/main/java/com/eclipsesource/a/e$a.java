package com.eclipsesource.a;

class e$a {
    final byte[] abI = new byte[32];

    final void h(String str, int i) {
        int T = T(str);
        if (i < 255) {
            this.abI[T] = (byte) (i + 1);
        } else {
            this.abI[T] = (byte) 0;
        }
    }

    public final void remove(int i) {
        for (int i2 = 0; i2 < this.abI.length; i2++) {
            if (this.abI[i2] == i + 1) {
                this.abI[i2] = (byte) 0;
            } else if (this.abI[i2] > i + 1) {
                byte[] bArr = this.abI;
                bArr[i2] = (byte) (bArr[i2] - 1);
            }
        }
    }

    final int T(Object obj) {
        return obj.hashCode() & (this.abI.length - 1);
    }
}
