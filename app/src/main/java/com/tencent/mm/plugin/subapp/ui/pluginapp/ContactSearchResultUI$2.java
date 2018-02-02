package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ContactSearchResultUI$2 implements OnItemClickListener {
    final /* synthetic */ ContactSearchResultUI rYq;
    final /* synthetic */ int rYr;

    ContactSearchResultUI$2(ContactSearchResultUI contactSearchResultUI, int i) {
        this.rYq = contactSearchResultUI;
        this.rYr = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - ContactSearchResultUI.a(this.rYq).getHeaderViewsCount();
        if (headerViewsCount >= 0 && headerViewsCount < ContactSearchResultUI.a(this.rYq).getCount()) {
            bek com_tencent_mm_protocal_c_bek = (bek) ContactSearchResultUI.a(this.rYq).getItemAtPosition(headerViewsCount);
            String str = com_tencent_mm_protocal_c_bek.vYI.wJF;
            ar.Hg();
            af WO = c.EY().WO(str);
            if (a.fZ(WO.field_type)) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Scene", 3);
                if (str != null && str.length() > 0) {
                    if (WO.cia()) {
                        g.pQN.k(10298, str + ",35");
                        intent.putExtra("Contact_Scene", 35);
                    }
                    d.b(this.rYq, "profile", ".ui.ContactInfoUI", intent);
                    return;
                }
                return;
            }
            if ((com_tencent_mm_protocal_c_bek.wvf & 8) > 0) {
                g.pQN.k(10298, com_tencent_mm_protocal_c_bek.vYI.wJF + ",35");
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_User", com_tencent_mm_protocal_c_bek.vYI.wJF);
            intent2.putExtra("Contact_Alias", com_tencent_mm_protocal_c_bek.hvy);
            intent2.putExtra("Contact_Nick", com_tencent_mm_protocal_c_bek.wsB.wJF);
            intent2.putExtra("Contact_Signature", com_tencent_mm_protocal_c_bek.hvw);
            intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(com_tencent_mm_protocal_c_bek.hvC, com_tencent_mm_protocal_c_bek.hvu, com_tencent_mm_protocal_c_bek.hvv));
            intent2.putExtra("Contact_Sex", com_tencent_mm_protocal_c_bek.hvt);
            intent2.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_bek.wvg);
            intent2.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_bek.wvf);
            intent2.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_bek.wvj);
            intent2.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_bek.wvh);
            intent2.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_bek.wvi);
            intent2.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_bek.wvl.hvE);
            intent2.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_bek.wvl.hvG);
            intent2.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_bek.wvl.hvF);
            intent2.putExtra("Contact_Scene", 35);
            if (this.rYr != 0) {
                intent2.putExtra("add_more_friend_search_scene", this.rYr);
            }
            if (com_tencent_mm_protocal_c_bek.wvm != null) {
                try {
                    intent2.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_bek.wvm.toByteArray());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
                }
            }
            if ((com_tencent_mm_protocal_c_bek.wvf & 8) > 0) {
                g.pQN.k(10298, com_tencent_mm_protocal_c_bek.vYI.wJF + ",35");
            }
            d.b(this.rYq, "profile", ".ui.ContactInfoUI", intent2);
        }
    }
}
