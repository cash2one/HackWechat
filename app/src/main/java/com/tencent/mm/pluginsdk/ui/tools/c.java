package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.y;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e$a;

public final class c {
    public static void a(Intent intent, bem com_tencent_mm_protocal_c_bem, int i) {
        String a = n.a(com_tencent_mm_protocal_c_bem.vYI);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", n.a(com_tencent_mm_protocal_c_bem.wsB));
        intent.putExtra("Contact_PyInitial", n.a(com_tencent_mm_protocal_c_bem.vYw));
        intent.putExtra("Contact_QuanPin", n.a(com_tencent_mm_protocal_c_bem.vYx));
        intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_bem.hvy);
        intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_bem.hvt);
        intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_bem.wvg);
        intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_bem.wvf);
        intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_bem.wvj);
        intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_bem.wvh);
        intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_bem.wvi);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(com_tencent_mm_protocal_c_bem.hvC, com_tencent_mm_protocal_c_bem.hvu, com_tencent_mm_protocal_c_bem.hvv));
        intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_bem.hvw);
        intent.putExtra("Contact_BrandList", com_tencent_mm_protocal_c_bem.hvD);
        intent.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_bem.wvl.hvE);
        intent.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_bem.wvl.hvG);
        intent.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_bem.wvl.hvF);
        intent.putExtra("Contact_BIZ_KF_WORKER_ID", com_tencent_mm_protocal_c_bem.wJX);
        intent.putExtra(e$a.xEi, com_tencent_mm_protocal_c_bem.whR);
        intent.putExtra("Contact_BIZ_PopupInfoMsg", com_tencent_mm_protocal_c_bem.wJZ);
        x.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[]{com_tencent_mm_protocal_c_bem.whR});
        d dVar = new d();
        dVar.field_username = a;
        dVar.field_brandList = com_tencent_mm_protocal_c_bem.hvD;
        dVar.field_kfWorkerId = com_tencent_mm_protocal_c_bem.wJX;
        pq pqVar = com_tencent_mm_protocal_c_bem.wvm;
        if (pqVar != null) {
            dVar.field_brandFlag = pqVar.hvH;
            dVar.field_brandInfo = pqVar.hvJ;
            dVar.field_extInfo = pqVar.hvI;
            dVar.field_brandIconURL = pqVar.hvK;
        }
        if (!y.Mf().e(dVar)) {
            y.Mf().d(dVar);
        }
    }

    public static void a(Intent intent, bek com_tencent_mm_protocal_c_bek, int i) {
        String a = n.a(com_tencent_mm_protocal_c_bek.vYI);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", n.a(com_tencent_mm_protocal_c_bek.wsB));
        intent.putExtra("Contact_PyInitial", n.a(com_tencent_mm_protocal_c_bek.vYw));
        intent.putExtra("Contact_QuanPin", n.a(com_tencent_mm_protocal_c_bek.vYx));
        intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_bek.hvy);
        intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_bek.hvt);
        intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_bek.wvg);
        intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_bek.wvf);
        intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_bek.wvj);
        intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_bek.wvh);
        intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_bek.wvi);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(com_tencent_mm_protocal_c_bek.hvC, com_tencent_mm_protocal_c_bek.hvu, com_tencent_mm_protocal_c_bek.hvv));
        intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_bek.hvw);
        intent.putExtra("Contact_BrandList", com_tencent_mm_protocal_c_bek.hvD);
        intent.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_bek.wvl.hvE);
        intent.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_bek.wvl.hvG);
        intent.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_bek.wvl.hvF);
        intent.putExtra(e$a.xEi, com_tencent_mm_protocal_c_bek.whR);
        x.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[]{com_tencent_mm_protocal_c_bek.whR});
        d dVar = new d();
        dVar.field_username = a;
        dVar.field_brandList = com_tencent_mm_protocal_c_bek.hvD;
        pq pqVar = com_tencent_mm_protocal_c_bek.wvm;
        if (pqVar != null) {
            dVar.field_brandFlag = pqVar.hvH;
            dVar.field_brandInfo = pqVar.hvJ;
            dVar.field_extInfo = pqVar.hvI;
            dVar.field_brandIconURL = pqVar.hvK;
        }
        if (!y.Mf().e(dVar)) {
            y.Mf().d(dVar);
        }
    }
}
