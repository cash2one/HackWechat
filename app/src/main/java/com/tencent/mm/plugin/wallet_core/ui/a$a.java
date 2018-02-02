package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet.a.h;

public final class a$a {
    public String pax;
    public h sQX;
    public double sQY;
    public String sQZ;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.sQX != null) {
            stringBuffer.append("|faovrComposeId: " + this.sQX.sDE);
        }
        stringBuffer.append("|bankName: " + this.pax);
        stringBuffer.append("|bankFavorAmount: " + this.sQY);
        stringBuffer.append("|bankType: " + this.sQZ);
        return stringBuffer.toString();
    }
}
