package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.g.a.tm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.ArrayList;
import java.util.List;

public final class o extends a {
    public final List<Integer> bOG() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11028));
        arrayList.add(Integer.valueOf(11027));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        switch (i) {
            case 11027:
                yD(1);
                break;
            case 11028:
                yD(2);
                break;
        }
        return null;
    }

    private static void yD(int i) {
        b tmVar = new tm();
        tmVar.fMb.fpr = i;
        a.xef.m(tmVar);
    }
}
