package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.c.bym;
import com.tencent.mm.protocal.c.byn;
import com.tencent.mm.z.r;
import java.util.List;

public final class h extends b {
    private long fLR;
    private String fLS;
    private List<String> fLT;
    private long fqm;

    public h(long j, long j2, String str, List<String> list) {
        this.fqm = j;
        this.fLR = j2;
        this.fLS = str;
        this.fLT = list;
    }

    protected final void send() {
        bym com_tencent_mm_protocal_c_bym = new bym();
        com_tencent_mm_protocal_c_bym.wYI = this.fLR;
        com_tencent_mm_protocal_c_bym.wYH = this.fqm;
        com_tencent_mm_protocal_c_bym.wYJ = this.fLS;
        try {
            if (this.fLT != null) {
                for (String split : this.fLT) {
                    String[] split2 = split.split("=");
                    byn com_tencent_mm_protocal_c_byn = new byn();
                    com_tencent_mm_protocal_c_byn.wYG = split2[0];
                    com_tencent_mm_protocal_c_byn.kub = split2[1];
                    if (com_tencent_mm_protocal_c_byn.kub.startsWith("wxid")) {
                        com_tencent_mm_protocal_c_byn.kub = r.gu(com_tencent_mm_protocal_c_byn.kub);
                    }
                    com_tencent_mm_protocal_c_byn.wYI = Long.valueOf(split2[2]).longValue();
                    com_tencent_mm_protocal_c_bym.wYK.add(com_tencent_mm_protocal_c_byn);
                }
            }
            a.bOt();
            com.tencent.mm.plugin.wear.model.e.r.a(20015, com_tencent_mm_protocal_c_bym.toByteArray(), true);
        } catch (Exception e) {
        }
        if (this.fLR > 0) {
            com.tencent.mm.plugin.wear.model.c.a.kd(true);
        } else {
            com.tencent.mm.plugin.wear.model.c.a.kd(false);
        }
    }

    public final String getName() {
        return "WearLuckyReceiveTask";
    }
}
