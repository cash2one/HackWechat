package com.tencent.mm.plugin.remittance.bankcard.model;

import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Comparator;

public final class b implements Comparator<ez> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        ez ezVar = (ez) obj;
        ez ezVar2 = (ez) obj2;
        if (bh.ov(ezVar.nBM) || bh.ov(ezVar2.nBM)) {
            if (!(bh.ov(ezVar.nBM) && bh.ov(ezVar2.nBM))) {
                if (bh.ov(ezVar.nBM)) {
                    return 1;
                }
                if (bh.ov(ezVar2.nBM)) {
                    return -1;
                }
            }
            return 0;
        }
        char charAt = !bh.ov(ezVar.vKN) ? ezVar.vKN.toUpperCase().charAt(0) : a.In(ezVar.nBM);
        char charAt2 = !bh.ov(ezVar2.vKN) ? ezVar2.vKN.toUpperCase().charAt(0) : a.In(ezVar2.nBM);
        if (charAt < charAt2) {
            return -1;
        }
        return charAt > charAt2 ? 1 : 0;
    }
}
