package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class c {
    public static aoh Je() {
        try {
            ar.Hg();
            String str = (String) com.tencent.mm.z.c.CU().get(67591, null);
            if (str != null) {
                aoh com_tencent_mm_protocal_c_aoh = new aoh();
                String[] split = str.split(",");
                com_tencent_mm_protocal_c_aoh.wcr = Integer.valueOf(split[0]).intValue();
                com_tencent_mm_protocal_c_aoh.wcu = Integer.valueOf(split[1]).intValue();
                com_tencent_mm_protocal_c_aoh.vQu = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                com_tencent_mm_protocal_c_aoh.vQt = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                x.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[]{Float.valueOf(com_tencent_mm_protocal_c_aoh.vQu), Float.valueOf(com_tencent_mm_protocal_c_aoh.vQt)});
                return com_tencent_mm_protocal_c_aoh;
            }
            x.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            x.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
