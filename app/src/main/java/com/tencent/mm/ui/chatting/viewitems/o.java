package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.e;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;

public final class o {
    public static void a(a aVar, String str, String str2, boolean z, boolean z2) {
        if (z && z2) {
            str2 = ba.hQ(str2);
        }
        ar.Hg();
        au.a EK = c.Fa().EK(str2);
        if (EK != null) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", EK.rYX);
            intent.putExtra("Contact_Alias", EK.gfN);
            intent.putExtra("Contact_Nick", EK.fpL);
            intent.putExtra("Contact_QuanPin", EK.hwV);
            intent.putExtra("Contact_PyInitial", EK.hwU);
            intent.putExtra("Contact_Uin", EK.pjS);
            intent.putExtra("Contact_Mobile_MD5", EK.xzj);
            intent.putExtra("Contact_full_Mobile_MD5", EK.xzk);
            intent.putExtra("Contact_QQNick", EK.cjG());
            intent.putExtra("User_From_Fmessage", false);
            intent.putExtra("Contact_Scene", EK.scene);
            intent.putExtra("Contact_FMessageCard", true);
            intent.putExtra("Contact_RemarkName", EK.hwZ);
            intent.putExtra("Contact_VUser_Info_Flag", EK.tmE);
            intent.putExtra("Contact_VUser_Info", EK.fWu);
            intent.putExtra("Contact_BrandIconURL", EK.phJ);
            intent.putExtra("Contact_Province", EK.getProvince());
            intent.putExtra("Contact_City", EK.getCity());
            intent.putExtra("Contact_Sex", EK.fWf);
            intent.putExtra("Contact_Signature", EK.signature);
            intent.putExtra("Contact_ShowUserName", true);
            intent.putExtra("Contact_KSnsIFlag", 0);
            intent.putExtra("Contact_Source_FMessage", 17);
            intent.putExtra("source_from_user_name", str);
            intent.putExtra("source_from_nick_name", r.gt(str));
            intent.putExtra(e.a.xEi, EK.vtc);
            if ((EK.tmE & 8) > 0) {
                if (!t.ov(str)) {
                    ar.Hg();
                    if (c.EY().WO(str).cia()) {
                        intent.putExtra("Contact_Scene", 41);
                        g.pQN.k(10298, EK.rYX + ",41");
                    }
                }
                intent.putExtra("Contact_Scene", 17);
                g.pQN.k(10298, EK.rYX + ",17");
            }
            d.b(aVar.getContext(), "profile", ".ui.ContactInfoUI", intent);
            com.tencent.mm.bn.a.CC(EK.scene);
        }
    }
}
