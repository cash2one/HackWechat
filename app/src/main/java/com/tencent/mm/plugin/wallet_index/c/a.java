package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public String mMessage;
    public int nAh;
    public int tal = 0;

    private a(int i, String str) {
        this.nAh = i;
        this.mMessage = str;
    }

    public static a aL(int i, String str) {
        int i2 = 6;
        int i3 = i.uYt;
        if (i > -15001) {
            switch (i) {
                case 0:
                    i3 = i.uYs;
                    i2 = i;
                    break;
                case 1:
                    i3 = i.uYu;
                    i2 = i;
                    break;
                case 3:
                case 105:
                    i2 = 3;
                    str = "Google Play not install";
                    break;
                case 6:
                    return new a(6, str);
                case 103:
                case 104:
                case 100000002:
                    i2 = 100000002;
                    i3 = i.uYr;
                    break;
                case 106:
                case 100000001:
                    i3 = i.uYt;
                    break;
                case 109:
                    i3 = i.uYv;
                    i2 = i;
                    break;
                case 110:
                    i3 = i.uYx;
                    i2 = i;
                    break;
                case 111:
                    i3 = i.uYy;
                    i2 = i;
                    break;
                case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                    i3 = i.uYw;
                    i2 = i;
                    break;
                case 113:
                    i3 = i.uYt;
                    i2 = i;
                    break;
                default:
                    i3 = i.uYt;
                    break;
            }
        }
        i2 = i;
        x.i("MicroMsg.IapResult", "code : " + i + ", errMsg : " + str + ", convert to errCode : " + i2);
        if (bh.ov(str)) {
            return new a(i2, ac.getContext().getString(i3));
        }
        return new a(i2, str);
    }

    public final boolean bNl() {
        return this.nAh == 104 || this.nAh == 100000002;
    }

    public final boolean isFailure() {
        return ((this.nAh == 0) || bNl()) ? false : true;
    }

    public final String toString() {
        return "IapResult: " + this.mMessage;
    }
}
