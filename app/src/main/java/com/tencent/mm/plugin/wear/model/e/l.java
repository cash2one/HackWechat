package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.protocal.c.bzj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class l extends a {
    public final List<Integer> bOG() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11032));
        arrayList.add(Integer.valueOf(11034));
        return arrayList;
    }

    protected final boolean zB(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }

    protected final byte[] n(int i, byte[] bArr) {
        switch (i) {
            case 11032:
                byy com_tencent_mm_protocal_c_byy = new byy();
                if (g.zY().getInt("WearPayBlock", 0) == 0) {
                    a.ee(13, 0);
                    a.zA(15);
                    b tjVar = new tj();
                    tjVar.fLO.action = 3;
                    com.tencent.mm.sdk.b.a.xef.m(tjVar);
                    switch (tjVar.fLP.fLQ) {
                        case 1:
                            com_tencent_mm_protocal_c_byy.wPs = 0;
                            com_tencent_mm_protocal_c_byy.wXG = "";
                            com_tencent_mm_protocal_c_byy.wYW = new com.tencent.mm.bq.b(tjVar.fLP.fLU);
                            com_tencent_mm_protocal_c_byy.wYX = new com.tencent.mm.bq.b(tjVar.fLP.fLV);
                            com_tencent_mm_protocal_c_byy.wYY = tjVar.fLP.fLW;
                            com_tencent_mm_protocal_c_byy.wYZ = tjVar.fLP.fLX;
                            break;
                        case 2:
                            com_tencent_mm_protocal_c_byy.wPs = 196611;
                            com_tencent_mm_protocal_c_byy.wXG = ac.getContext().getString(R.l.eWp);
                            break;
                        case 3:
                            com_tencent_mm_protocal_c_byy.wPs = 196609;
                            com_tencent_mm_protocal_c_byy.wXG = ac.getContext().getString(R.l.eWo);
                            break;
                        case 4:
                            com_tencent_mm_protocal_c_byy.wPs = 196610;
                            com_tencent_mm_protocal_c_byy.wXG = ac.getContext().getString(R.l.eWs);
                            break;
                        case 5:
                            com_tencent_mm_protocal_c_byy.wPs = 196612;
                            com_tencent_mm_protocal_c_byy.wXG = ac.getContext().getString(R.l.eWq);
                            break;
                        default:
                            break;
                    }
                }
                com_tencent_mm_protocal_c_byy.wPs = 16777215;
                com_tencent_mm_protocal_c_byy.wXG = ac.getContext().getString(R.l.eWr);
                try {
                    return com_tencent_mm_protocal_c_byy.toByteArray();
                } catch (IOException e) {
                    break;
                }
            case 11034:
                bzj com_tencent_mm_protocal_c_bzj = new bzj();
                try {
                    com_tencent_mm_protocal_c_bzj.aF(bArr);
                } catch (IOException e2) {
                }
                d.y(ac.getContext(), com_tencent_mm_protocal_c_bzj.wZd, com_tencent_mm_protocal_c_bzj.wZe);
                break;
        }
        return new byte[0];
    }

    public final boolean zD(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }
}
