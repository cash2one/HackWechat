package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bk.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class NearbyFriendsUI$10 implements OnItemClickListener {
    final /* synthetic */ NearbyFriendsUI oOS;

    NearbyFriendsUI$10(NearbyFriendsUI nearbyFriendsUI) {
        this.oOS = nearbyFriendsUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (NearbyFriendsUI.o(this.oOS) > 0 || NearbyFriendsUI.p(this.oOS) > 0) {
            i--;
        }
        if (a.bXU() && NearbyFriendsUI.m(this.oOS) != null) {
            i--;
        }
        if (NearbyFriendsUI.q(this.oOS)) {
            i--;
        }
        if (i >= 0 && i < NearbyFriendsUI.r(this.oOS).size()) {
            aoe com_tencent_mm_protocal_c_aoe = (aoe) NearbyFriendsUI.r(this.oOS).get(i);
            Intent intent;
            if (NearbyFriendsUI$c.tP(com_tencent_mm_protocal_c_aoe.hvt)) {
                String b = NearbyFriendsUI$c.b(com_tencent_mm_protocal_c_aoe);
                x.d("MicroMsg.NearbyFriend", "poi item click, go:" + bh.ou(b));
                if (!bh.ov(b)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", b);
                    intent.putExtra("geta8key_scene", 25);
                    intent.putExtra("stastic_scene", 12);
                    d.b(this.oOS.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                return;
            }
            String str = com_tencent_mm_protocal_c_aoe.ksU;
            ar.Hg();
            af WO = c.EY().WO(str);
            if (com.tencent.mm.l.a.fZ(WO.field_type)) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", str);
                intent2.putExtra("Contact_Scene", 18);
                intent2.putExtra("Sns_from_Scene", 18);
                intent2.putExtra("lbs_ticket", com_tencent_mm_protocal_c_aoe.whR);
                intent2.putExtra("Contact_IsLbsGotoChatting", true);
                if (str != null && str.length() > 0) {
                    if (WO.cia()) {
                        g.pQN.k(10298, str + ",18");
                    }
                    b oxVar = new ox();
                    oxVar.fGO.intent = intent2;
                    oxVar.fGO.username = str;
                    com.tencent.mm.sdk.b.a.xef.m(oxVar);
                    com.tencent.mm.plugin.nearby.a.ifs.d(intent2, this.oOS);
                    return;
                }
                return;
            }
            intent = new Intent();
            intent.putExtra("Contact_User", com_tencent_mm_protocal_c_aoe.ksU);
            intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_aoe.hvy);
            intent.putExtra("Contact_Nick", com_tencent_mm_protocal_c_aoe.kub);
            intent.putExtra("Contact_Distance", com_tencent_mm_protocal_c_aoe.wve);
            intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_aoe.hvw);
            intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(com_tencent_mm_protocal_c_aoe.hvC, com_tencent_mm_protocal_c_aoe.hvu, com_tencent_mm_protocal_c_aoe.hvv));
            intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_aoe.hvt);
            intent.putExtra("Contact_IsLBSFriend", true);
            intent.putExtra("Contact_Scene", 18);
            intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_aoe.wvg);
            intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_aoe.wvf);
            intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_aoe.wvj);
            intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_aoe.wvh);
            intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_aoe.wvi);
            intent.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_aoe.wvl.hvE);
            intent.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_aoe.wvl.hvG);
            intent.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_aoe.wvl.hvF);
            intent.putExtra("lbs_ticket", com_tencent_mm_protocal_c_aoe.whR);
            intent.putExtra("Contact_IsLbsGotoChatting", true);
            if (com_tencent_mm_protocal_c_aoe.hvD != null) {
                com.tencent.mm.sdk.e.c dVar = new com.tencent.mm.ag.d();
                dVar.field_brandList = com_tencent_mm_protocal_c_aoe.hvD;
                dVar.field_brandFlag = com_tencent_mm_protocal_c_aoe.wvm.hvH;
                dVar.field_brandIconURL = com_tencent_mm_protocal_c_aoe.wvm.hvK;
                dVar.field_extInfo = com_tencent_mm_protocal_c_aoe.wvm.hvI;
                dVar.field_brandInfo = com_tencent_mm_protocal_c_aoe.wvm.hvJ;
                intent.putExtra("KBrandInfo_item", new MCacheItem(dVar));
            }
            intent.putExtra("Sns_from_Scene", 18);
            com.tencent.mm.plugin.nearby.a.ifs.d(intent, this.oOS);
        }
    }
}
