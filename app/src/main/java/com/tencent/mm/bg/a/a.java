package com.tencent.mm.bg.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class a {
    int hYS = 0;
    int hYT = 0;
    int hYU = 0;
    short[] hYV;

    public a(int i) {
        if (i <= 1) {
            i = WXMediaMessage.TITLE_LENGTH_LIMIT;
        }
        this.hYV = new short[i];
    }

    final int b(short[] sArr, int i) {
        int length;
        if (i > sArr.length) {
            length = sArr.length;
        } else {
            length = i;
        }
        if (length == 0) {
            return 0;
        }
        int length2 = this.hYV.length;
        if (length >= this.hYU) {
            length = this.hYU;
        }
        if (length <= length2 - this.hYS) {
            System.arraycopy(this.hYV, this.hYS, sArr, 0, length);
            this.hYS += length;
            if (this.hYS >= length2) {
                this.hYS = 0;
            }
        } else {
            length2 -= this.hYS;
            System.arraycopy(this.hYV, this.hYS, sArr, 0, length2);
            int i2 = length - length2;
            System.arraycopy(this.hYV, 0, sArr, length2, i2);
            this.hYS = i2;
        }
        this.hYU -= length;
        return length;
    }
}
