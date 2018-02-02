package com.tencent.mm.plugin.location.model;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.Set;

public class a$a {
    Set<Long> nQD;
    private a nQE = new a(this) {
        final /* synthetic */ a$a nQF;

        {
            this.nQF = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(Addr addr) {
            a$a com_tencent_mm_plugin_location_model_a_a = this.nQF;
            if (addr.tag != null && (addr.tag instanceof Long)) {
                long longValue = ((Long) addr.tag).longValue();
                ar.Hg();
                cf dH = c.Fa().dH(longValue);
                if (!bh.ov(addr.hxu)) {
                    int i;
                    String trim;
                    String str = dH.field_content;
                    if (dH.field_isSend == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    boolean eV = s.eV(dH.field_talker);
                    if (eV && r0 != 0) {
                        int hO = ba.hO(str);
                        if (hO != -1) {
                            str = str.substring(hO + 1).trim();
                        }
                    }
                    b Xs = b.Xs(str);
                    Xs.label = addr.OM();
                    str = "";
                    if (eV && r0 != 0) {
                        i = ba.hO(dH.field_content);
                        if (i != -1) {
                            trim = dH.field_content.substring(0, i).trim();
                        }
                    }
                    trim = str;
                    if (Xs.xzq == null || Xs.xzq.equals("")) {
                        Xs.xzq = "";
                    }
                    if (Xs.xzp == null || Xs.xzp.equals("")) {
                        Xs.xzq = "";
                    }
                    if (Xs.xzo == null || Xs.xzo.equals("")) {
                        Xs.xzo = "";
                    }
                    if (Xs.rYX == null || Xs.rYX.equals("")) {
                        Xs.rYX = "";
                    }
                    if (Xs.label == null || Xs.label.equals("")) {
                        Xs.label = "";
                    }
                    if (Xs.xzn == null || Xs.xzn.equals("")) {
                        Xs.xzn = "";
                    }
                    String str2 = "<msg><location x=\"" + Xs.nQx + "\" y=\"" + Xs.nQy + "\" scale=\"" + Xs.fzv + "\" label=\"" + Xs.label + "\" maptype=\"" + Xs.xzn + "\"  fromusername=\"" + Xs.rYX + "\" /></msg>";
                    trim = (!eV || trim.equals("")) ? str2 : trim + ":\n" + str2;
                    x.d("MicroMsg.LocationServer", "xml: " + trim);
                    dH.setContent(trim);
                    ar.Hg();
                    c.Fa().a(dH.field_msgId, dH);
                    com_tencent_mm_plugin_location_model_a_a.nQD.remove(Long.valueOf(dH.field_msgId));
                }
            }
        }
    };

    public final void aVm() {
        if (this.nQD != null) {
            this.nQD.clear();
        }
        com.tencent.mm.modelgeo.b.ON().a(this.nQE);
    }

    public final String[] N(au auVar) {
        int i = 1;
        String[] strArr = new String[2];
        String str = auVar.field_content;
        if (bh.ov(str)) {
            strArr[0] = "";
            strArr[1] = "";
            return strArr;
        }
        String trim;
        b EL;
        long j;
        int i2 = auVar.field_isSend == 0 ? 1 : 0;
        if (s.eV(auVar.field_talker) && i2 != 0) {
            i2 = ba.hO(str);
            if (i2 != -1) {
                trim = str.substring(i2 + 1).trim();
                ar.Hg();
                EL = c.Fa().EL(trim);
                if (EL.cjH()) {
                    strArr[0] = EL.label;
                    strArr[1] = "";
                } else {
                    str = EL.label;
                    trim = EL.nTe;
                    strArr[0] = str;
                    strArr[1] = trim;
                }
                if (bh.ov(strArr[0]) && bh.ov(strArr[1])) {
                    x.i("MicroMsg.LocationServer", "pull from sever");
                    j = auVar.field_msgId;
                    if (!(this.nQD == null || this.nQD.contains(Long.valueOf(j)))) {
                        trim = auVar.field_content;
                        if (auVar.field_isSend != 0) {
                            i = 0;
                        }
                        if (s.eV(auVar.field_talker) && r1 != 0) {
                            i = ba.hO(trim);
                            if (i != -1) {
                                trim = trim.substring(i + 1).trim();
                            }
                        }
                        EL = b.Xs(trim);
                        this.nQD.add(Long.valueOf(j));
                        com.tencent.mm.modelgeo.b.ON().a(EL.nQx, EL.nQy, this.nQE, Long.valueOf(auVar.field_msgId));
                    }
                }
                return strArr;
            }
        }
        trim = str;
        ar.Hg();
        EL = c.Fa().EL(trim);
        if (EL.cjH()) {
            strArr[0] = EL.label;
            strArr[1] = "";
        } else {
            str = EL.label;
            trim = EL.nTe;
            strArr[0] = str;
            strArr[1] = trim;
        }
        x.i("MicroMsg.LocationServer", "pull from sever");
        j = auVar.field_msgId;
        trim = auVar.field_content;
        if (auVar.field_isSend != 0) {
            i = 0;
        }
        i = ba.hO(trim);
        if (i != -1) {
            trim = trim.substring(i + 1).trim();
        }
        EL = b.Xs(trim);
        this.nQD.add(Long.valueOf(j));
        com.tencent.mm.modelgeo.b.ON().a(EL.nQx, EL.nQy, this.nQE, Long.valueOf(auVar.field_msgId));
        return strArr;
    }
}
