package com.tencent.mm.z;

import com.tencent.mm.a.e;
import com.tencent.mm.bq.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.asj;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.wcdb.FileUtils;

public final class bi {
    public String countryCode = "";
    public int fWf = 0;
    public int fWo = 0;
    public String fWt = "";
    private String hhu = "";
    private String hhv = "";
    public String hhw = "";
    public String hhx = "";
    public String signature = "";

    public static bi HQ() {
        bi biVar = new bi();
        biVar.fWo = 1;
        biVar.fWf = bh.a((Integer) g.Dj().CU().get(12290, null), 0);
        biVar.hhu = (String) g.Dj().CU().get(12293, null);
        biVar.hhv = (String) g.Dj().CU().get(12292, null);
        biVar.signature = (String) g.Dj().CU().get(12291, null);
        biVar.fWt = (String) g.Dj().CU().get(12307, null);
        biVar.countryCode = (String) g.Dj().CU().get(12324, null);
        biVar.hhx = (String) g.Dj().CU().get(12325, null);
        biVar.hhw = (String) g.Dj().CU().get(12326, null);
        return biVar;
    }

    public static bi HR() {
        if (bh.a((Integer) g.Dj().CU().get(12289, null), 0) == 0) {
            return null;
        }
        return HQ();
    }

    public static asj a(bi biVar) {
        g.Dj().CU().set(12289, Integer.valueOf(biVar.fWo));
        g.Dj().CU().set(12290, Integer.valueOf(biVar.fWf));
        if (a.U((String) g.Dj().CU().get(12293, null), biVar.getProvince())) {
            g.Dj().CU().set(12293, biVar.getProvince());
        }
        if (a.U((String) g.Dj().CU().get(12292, null), biVar.getCity())) {
            g.Dj().CU().set(12292, biVar.getCity());
        }
        if (a.U((String) g.Dj().CU().get(12291, null), biVar.signature)) {
            g.Dj().CU().set(12291, biVar.signature);
        }
        if (a.U((String) g.Dj().CU().get(12307, null), biVar.fWt)) {
            g.Dj().CU().set(12307, biVar.fWt);
        }
        if (a.U((String) g.Dj().CU().get(12324, null), biVar.countryCode)) {
            g.Dj().CU().set(12324, biVar.countryCode);
        }
        if (a.U((String) g.Dj().CU().get(12325, null), biVar.hhx)) {
            g.Dj().CU().set(12325, biVar.hhx);
        }
        if (a.U((String) g.Dj().CU().get(12326, null), biVar.hhw)) {
            g.Dj().CU().set(12326, biVar.hhw);
        }
        asj com_tencent_mm_protocal_c_asj = new asj();
        com_tencent_mm_protocal_c_asj.wzS = FileUtils.S_IWUSR;
        com_tencent_mm_protocal_c_asj.vYI = new bdo().UA("");
        com_tencent_mm_protocal_c_asj.wsB = new bdo().UA("");
        com_tencent_mm_protocal_c_asj.vFr = 0;
        com_tencent_mm_protocal_c_asj.wzT = new bdo().UA("");
        com_tencent_mm_protocal_c_asj.wzU = new bdo().UA("");
        com_tencent_mm_protocal_c_asj.ktm = 0;
        byte[] d = e.d("", 0, -1);
        com_tencent_mm_protocal_c_asj.wzQ = new b(d == null ? new byte[0] : d);
        com_tencent_mm_protocal_c_asj.wzP = d == null ? 0 : d.length;
        com_tencent_mm_protocal_c_asj.hvt = biVar.fWf;
        com_tencent_mm_protocal_c_asj.hvx = biVar.fWo;
        com_tencent_mm_protocal_c_asj.hvw = bh.ou(biVar.signature);
        com_tencent_mm_protocal_c_asj.hvv = bh.ou(biVar.hhw);
        com_tencent_mm_protocal_c_asj.hvu = bh.ou(biVar.hhx);
        com_tencent_mm_protocal_c_asj.vFu = 0;
        com_tencent_mm_protocal_c_asj.wvh = bh.ou(biVar.fWt);
        com_tencent_mm_protocal_c_asj.wzZ = 0;
        com_tencent_mm_protocal_c_asj.hvy = "";
        com_tencent_mm_protocal_c_asj.wvj = 0;
        com_tencent_mm_protocal_c_asj.wvi = "";
        com_tencent_mm_protocal_c_asj.hvC = bh.ou(biVar.countryCode);
        return com_tencent_mm_protocal_c_asj;
    }

    public final String getCity() {
        if (!bh.ov(this.countryCode)) {
            if (bh.ov(this.hhx)) {
                this.hhv = "";
            } else if (bh.ov(this.hhw)) {
                this.hhv = RegionCodeDecoder.cjP().fE(this.countryCode, this.hhx);
            } else {
                this.hhv = RegionCodeDecoder.cjP().ai(this.countryCode, this.hhx, this.hhw);
            }
        }
        if (bh.ov(this.hhv)) {
            return bh.ou(this.hhw);
        }
        return this.hhv;
    }

    public final String getProvince() {
        if (!bh.ov(this.countryCode)) {
            if (bh.ov(this.hhx) || bh.ov(this.hhw) || !RegionCodeDecoder.XE(this.countryCode)) {
                this.hhu = RegionCodeDecoder.cjP().XF(this.countryCode);
            } else {
                this.hhu = RegionCodeDecoder.cjP().fE(this.countryCode, this.hhx);
            }
        }
        return bh.ov(this.hhu) ? bh.ou(this.hhx) : this.hhu;
    }
}
