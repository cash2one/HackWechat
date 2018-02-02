package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.bxy;
import com.tencent.mm.protocal.c.bye;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.bzb;
import com.tencent.mm.protocal.c.bzc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends a {
    public final List<Integer> bOG() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11008));
        arrayList.add(Integer.valueOf(11009));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        int i2 = 5;
        if (i == 11008) {
            a.zA(6);
            bzb com_tencent_mm_protocal_c_bzb = new bzb();
            try {
                com_tencent_mm_protocal_c_bzb.aF(bArr);
                List linkedList = new LinkedList();
                linkedList.addAll(s.cwj());
                linkedList.addAll(s.cwk());
                ar.Hg();
                Cursor j = com.tencent.mm.z.c.Fd().j(linkedList, com_tencent_mm_protocal_c_bzb.vNW);
                if (com_tencent_mm_protocal_c_bzb.vNW != 0) {
                    i2 = 20;
                }
                bzc com_tencent_mm_protocal_c_bzc = new bzc();
                com_tencent_mm_protocal_c_bzc.vNW = com_tencent_mm_protocal_c_bzb.vNW;
                while (j != null && j.moveToNext()) {
                    String string = j.getString(j.getColumnIndex("username"));
                    ar.Hg();
                    af WO = com.tencent.mm.z.c.EY().WO(string);
                    com_tencent_mm_protocal_c_bzc.vNW++;
                    if (!(WO.cia() || WO.AF())) {
                        bxy com_tencent_mm_protocal_c_bxy = new bxy();
                        com_tencent_mm_protocal_c_bxy.kub = r.c(WO);
                        com_tencent_mm_protocal_c_bxy.ksU = WO.field_username;
                        com_tencent_mm_protocal_c_bzc.wkl.add(com_tencent_mm_protocal_c_bxy);
                        if (com_tencent_mm_protocal_c_bzc.wkl.size() >= i2) {
                            com_tencent_mm_protocal_c_bzc.wYx = j.moveToNext();
                            break;
                        }
                    }
                }
                x.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", Integer.valueOf(com_tencent_mm_protocal_c_bzb.vNW), Integer.valueOf(com_tencent_mm_protocal_c_bzc.vNW), Integer.valueOf(com_tencent_mm_protocal_c_bzc.wkl.size()));
                if (j != null) {
                    j.close();
                }
                try {
                    return com_tencent_mm_protocal_c_bzc.toByteArray();
                } catch (IOException e) {
                    return null;
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e2, "", new Object[0]);
                return null;
            }
        } else if (i != 11009) {
            return null;
        } else {
            a.zA(7);
            bye com_tencent_mm_protocal_c_bye = new bye();
            try {
                com_tencent_mm_protocal_c_bye.aF(bArr);
                byf com_tencent_mm_protocal_c_byf = new byf();
                ar.Hg();
                Cursor cP = com.tencent.mm.z.c.EY().cP(null);
                int i3 = com_tencent_mm_protocal_c_bye.vNW;
                while (cP != null && cP.moveToNext()) {
                    if (i3 > 0) {
                        i3--;
                    } else {
                        String string2 = cP.getString(0);
                        ar.Hg();
                        af WO2 = com.tencent.mm.z.c.EY().WO(string2);
                        bxy com_tencent_mm_protocal_c_bxy2 = new bxy();
                        com_tencent_mm_protocal_c_bxy2.kub = r.c(WO2);
                        com_tencent_mm_protocal_c_bxy2.ksU = WO2.field_username;
                        com_tencent_mm_protocal_c_byf.wkl.add(com_tencent_mm_protocal_c_bxy2);
                        if (com_tencent_mm_protocal_c_byf.wkl.size() >= 5) {
                            com_tencent_mm_protocal_c_byf.wYx = cP.moveToNext();
                            break;
                        }
                    }
                }
                if (cP != null) {
                    cP.close();
                }
                com_tencent_mm_protocal_c_byf.vNW = com_tencent_mm_protocal_c_bye.vNW + com_tencent_mm_protocal_c_byf.wkl.size();
                try {
                    return com_tencent_mm_protocal_c_byf.toByteArray();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e22, "", new Object[0]);
                    return null;
                }
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e222, "", new Object[0]);
                return null;
            }
        }
    }

    protected final boolean zC(int i) {
        if (i == 11008 || i == 11009) {
            return true;
        }
        return super.zC(i);
    }

    protected final boolean zB(int i) {
        if (i == 11008 || i == 11009) {
            return true;
        }
        return super.zB(i);
    }
}
