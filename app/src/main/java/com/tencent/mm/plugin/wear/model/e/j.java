package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.bq.b;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.byr;
import com.tencent.mm.protocal.c.bys;
import com.tencent.mm.protocal.c.byw;
import com.tencent.mm.protocal.c.byx;
import com.tencent.mm.protocal.c.byz;
import com.tencent.mm.protocal.c.bza;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends a {
    public String tiQ = "";

    public final List<Integer> bOG() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11019));
        arrayList.add(Integer.valueOf(11020));
        arrayList.add(Integer.valueOf(11021));
        arrayList.add(Integer.valueOf(11031));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        boolean z = true;
        switch (i) {
            case 11019:
                List J;
                boolean z2;
                byr com_tencent_mm_protocal_c_byr = new byr();
                try {
                    com_tencent_mm_protocal_c_byr.aF(bArr);
                } catch (IOException e) {
                }
                bys com_tencent_mm_protocal_c_bys = new bys();
                com_tencent_mm_protocal_c_bys.wYP = com_tencent_mm_protocal_c_byr.wYP;
                if (com_tencent_mm_protocal_c_bys.wYP) {
                    ar.Hg();
                    J = c.Fa().J(com_tencent_mm_protocal_c_byr.vIy, com_tencent_mm_protocal_c_byr.wFp);
                } else {
                    ar.Hg();
                    J = c.Fa().I(com_tencent_mm_protocal_c_byr.vIy, com_tencent_mm_protocal_c_byr.wFp);
                }
                int i2 = 0;
                while (i2 < 10 && i2 < J.size()) {
                    com_tencent_mm_protocal_c_bys.woc.add(h.W((au) J.get(i2)));
                    i2++;
                }
                if (J.size() > 10) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                com_tencent_mm_protocal_c_bys.wYx = z2;
                try {
                    return com_tencent_mm_protocal_c_bys.toByteArray();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e2, "", new Object[0]);
                    break;
                }
            case 11020:
                a.ee(9, 0);
                a.zA(8);
                byw com_tencent_mm_protocal_c_byw = new byw();
                try {
                    com_tencent_mm_protocal_c_byw.aF(bArr);
                    this.tiQ = com_tencent_mm_protocal_c_byw.vIy;
                    byx com_tencent_mm_protocal_c_byx = new byx();
                    ar.Hg();
                    List I = c.Fa().I(com_tencent_mm_protocal_c_byw.vIy, com_tencent_mm_protocal_c_byw.wFp);
                    int i3 = 0;
                    while (i3 < 10 && i3 < I.size()) {
                        com_tencent_mm_protocal_c_byx.woc.add(h.W((au) I.get(i3)));
                        i3++;
                    }
                    if (I.size() <= 10) {
                        z = false;
                    }
                    com_tencent_mm_protocal_c_byx.wYx = z;
                    try {
                        return com_tencent_mm_protocal_c_byx.toByteArray();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e22, "", new Object[0]);
                        break;
                    }
                } catch (IOException e3) {
                    return null;
                }
                break;
            case 11021:
                this.tiQ = "";
                break;
            case 11031:
                a.ee(12, 0);
                a.zA(14);
                byz com_tencent_mm_protocal_c_byz = new byz();
                try {
                    com_tencent_mm_protocal_c_byz.aF(bArr);
                } catch (IOException e4) {
                }
                ar.Hg();
                cf dH = c.Fa().dH(com_tencent_mm_protocal_c_byz.wYH);
                bza com_tencent_mm_protocal_c_bza = new bza();
                String fullPath = q.getFullPath(dH.field_imgPath);
                com_tencent_mm_protocal_c_bza.wZa = o.e(fullPath, 0, true);
                com_tencent_mm_protocal_c_bza.wYH = com_tencent_mm_protocal_c_byz.wYH;
                com_tencent_mm_protocal_c_bza.vIA = new b(FileOp.d(fullPath, 0, -1));
                q.E(dH);
                try {
                    return com_tencent_mm_protocal_c_bza.toByteArray();
                } catch (IOException e5) {
                    return null;
                }
        }
        return null;
    }

    protected final boolean zC(int i) {
        switch (i) {
            case 11021:
            case 11031:
                return false;
            default:
                return true;
        }
    }

    protected final boolean zB(int i) {
        switch (i) {
            case 11021:
            case 11031:
                return false;
            default:
                return true;
        }
    }
}
