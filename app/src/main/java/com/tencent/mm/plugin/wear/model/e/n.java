package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.h;
import java.util.ArrayList;
import java.util.List;

public final class n extends a {
    public final List<Integer> bOG() {
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11033));
        arrayList.add(Integer.valueOf(11030));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        switch (i) {
            case 11030:
                if (new String(bArr).equals("arm_v7")) {
                    return h.NN("wechatvoicesilk_v7a");
                }
                return h.NN("wechatvoicesilk");
            case 11033:
                return h.NN("stlport_shared");
            default:
                return null;
        }
    }
}
