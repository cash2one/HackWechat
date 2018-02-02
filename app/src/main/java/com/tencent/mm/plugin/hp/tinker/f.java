package com.tencent.mm.plugin.hp.tinker;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.protocal.c.bnr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tinkerboots.sdk.a.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f extends a {
    public final boolean aSF() {
        return super.aSF();
    }

    public final void C(Map<String, String> map) {
        super.C(map);
        b.rh(2);
        String str = "tinker_id_" + BaseBuildInfo.baseRevision();
        String str2 = BaseBuildInfo.PATCH_REV == null ? "" : "tinker_id_" + BaseBuildInfo.PATCH_REV;
        List linkedList = new LinkedList();
        for (String str3 : map.keySet()) {
            bnr com_tencent_mm_protocal_c_bnr = new bnr();
            com_tencent_mm_protocal_c_bnr.aAM = str3;
            com_tencent_mm_protocal_c_bnr.value = (String) map.get(str3);
            linkedList.add(com_tencent_mm_protocal_c_bnr);
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bnr com_tencent_mm_protocal_c_bnr2 = (bnr) it.next();
            stringBuilder.append(com_tencent_mm_protocal_c_bnr2.aAM).append(":").append(com_tencent_mm_protocal_c_bnr2.value).append("\n");
        }
        x.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", new Object[]{str, str2, stringBuilder.toString()});
        ar.CG().a(new com.tencent.mm.plugin.hp.c.a(str, str2, linkedList), 0);
    }

    public final void aSG() {
        super.aSG();
        com.tinkerboots.sdk.a.cJn().gi(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(((long) com.tencent.mm.kernel.a.CA()) & 4294967295L)).gi(TencentLocation.NETWORK_PROVIDER, String.valueOf(an.isWifi(ac.getContext()) ? 3 : 2));
    }
}
