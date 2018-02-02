package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.u.d.a {
    private static final int iTK = (-bh.getInt(r.ido, 0));
    private byte[] iTL;
    private String id;

    public a(String str, byte[] bArr) {
        this.id = str;
        this.iTL = bArr;
    }

    public final boolean gn(int i) {
        byte b;
        int i2 = iTK;
        if (i2 == -1) {
            x.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm on", new Object[]{this.id, Integer.valueOf(i)});
            b = (byte) 1;
        } else if (i2 == -2) {
            x.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm off", new Object[]{this.id, Integer.valueOf(i)});
            b = (byte) 0;
        } else {
            b = i == -2 ? (byte) 1 : i == -1 ? (byte) 0 : (this.iTL == null || i < 0 || i >= this.iTL.length) ? (byte) 0 : this.iTL[i];
        }
        return b == (byte) 1;
    }
}
