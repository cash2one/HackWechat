package com.tencent.mm.pluginsdk.wallet;

import com.tencent.mm.R;
import com.tencent.mm.g.a.td;
import com.tencent.mm.g.a.te;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.List;

public final class e {
    public static String SZ(String str) {
        ar.Hg();
        List<au> EW = c.Fa().EW(str);
        if (EW != null) {
            x.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", new Object[]{Integer.valueOf(EW.size())});
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (au auVar : EW) {
                int i4;
                if (ab(auVar)) {
                    if (auVar.getType() == 419430449) {
                        i++;
                    } else if (auVar.getType() == 436207665) {
                        g$a fT;
                        String str2 = auVar.field_content;
                        if (str2 != null) {
                            fT = g$a.fT(str2);
                        } else {
                            fT = null;
                        }
                        if (fT != null) {
                            if ("1001".equals(fT.hcG)) {
                                i2++;
                            } else {
                                i4 = i3 + 1;
                                i3 = i4;
                            }
                        }
                    }
                }
                i4 = i3;
                i3 = i4;
            }
            if (i3 > 0 || i2 > 0 || i > 0) {
                if (s.eV(str)) {
                    return ac.getContext().getString(R.l.eWk, new Object[]{Integer.valueOf(i2)});
                } else if (i3 > 0 && i <= 0) {
                    return ac.getContext().getString(R.l.eWm, new Object[]{Integer.valueOf(i3)});
                } else if (i > 0 && i3 <= 0) {
                    return ac.getContext().getString(R.l.eWn, new Object[]{Integer.valueOf(i)});
                } else if (i > 0 && i3 > 0) {
                    return ac.getContext().getString(R.l.eWl, new Object[]{Integer.valueOf(i3), Integer.valueOf(i)});
                }
            }
        }
        return null;
    }

    public static boolean ab(au auVar) {
        g$a com_tencent_mm_y_g_a = null;
        String str;
        int i;
        if (auVar.getType() == 419430449) {
            if (auVar.field_isSend == 0) {
                g$a I;
                str = auVar.field_content;
                if (str != null) {
                    I = g$a.I(str, auVar.field_reserved);
                } else {
                    I = null;
                }
                if (I != null) {
                    b teVar = new te();
                    teVar.fLF.fEs = I.hcg;
                    a.xef.m(teVar);
                    i = teVar.fLG.status;
                    if (i <= 0) {
                        i = I.hcd;
                    }
                    if (i >= 0 && (i == 1 || i == 7)) {
                        return true;
                    }
                }
            }
        } else if (auVar.getType() == 436207665 && auVar.field_isSend == 0) {
            str = auVar.field_content;
            if (str != null) {
                com_tencent_mm_y_g_a = g$a.fT(str);
            }
            if (com_tencent_mm_y_g_a != null) {
                if (!"1001".equals(com_tencent_mm_y_g_a.hcG) && !s.eV(auVar.field_talker)) {
                    b tdVar = new td();
                    if (!bh.ov(com_tencent_mm_y_g_a.hcH)) {
                        tdVar.fLA.fLC = com_tencent_mm_y_g_a.hcH;
                        a.xef.m(tdVar);
                        if (tdVar.fLB.fLE == 0) {
                            return true;
                        }
                    }
                } else if (s.eV(auVar.field_talker)) {
                    int i2;
                    str = q.FS();
                    if (!bh.cA(com_tencent_mm_y_g_a.hcW)) {
                        for (String split : com_tencent_mm_y_g_a.hcW) {
                            String[] split2 = split.split(",");
                            if (split2.length == 3 && split2[0].equals(str)) {
                                i = bh.getInt(split2[2], -1);
                                i2 = 1;
                                break;
                            }
                        }
                    }
                    i = 0;
                    i2 = 0;
                    if (i2 != 0 && r0 == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
