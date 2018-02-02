package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.av.b;
import com.tencent.mm.av.c;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class ShakeItemListUI$3 implements OnItemClickListener {
    final /* synthetic */ ShakeItemListUI qqB;
    final /* synthetic */ int qqD;

    ShakeItemListUI$3(ShakeItemListUI shakeItemListUI, int i) {
        this.qqB = shakeItemListUI;
        this.qqD = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar = (d) ShakeItemListUI.b(this.qqB).getItem(i);
        if (dVar != null) {
            e brC = m.brC();
            if (dVar == null) {
                x.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
            } else {
                dVar.field_insertBatch = 1;
                dVar.fDt = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                if (-1 != brC.gJP.update("shakeitem1", dVar.vI(), "shakeItemID=? and insertBatch=?", new String[]{dVar.field_shakeItemID, "2"})) {
                    brC.doNotify();
                }
            }
            int i2 = dVar.field_type;
            Intent intent;
            if (i2 == 4) {
                intent = new Intent();
                if (c.Qz()) {
                    b.b(i.c(dVar.field_lvbuffer, 0));
                } else {
                    b.Qo();
                    intent.putExtra("key_mode", 1);
                    intent.putExtra("KGlobalShakeMusic", true);
                    b.c(i.c(dVar.field_lvbuffer, 0));
                }
                intent.putExtra("key_scene", 3);
                com.tencent.mm.bm.d.b(this.qqB, "music", ".ui.MusicMainUI", intent);
            } else if (i2 == 11) {
                if (System.currentTimeMillis() - this.qqB.qqy > 2000) {
                    this.qqB.qqy = System.currentTimeMillis();
                    if (dVar.field_reserved3 == null || dVar.field_reserved3.split(",").length != 3 || dVar.field_reserved3.split(",")[0] == null || dVar.field_reserved3.split(",")[0].equals("")) {
                        intent = new Intent();
                        intent.putExtra("rawUrl", dVar.getCity());
                        intent.putExtra("scene", 27);
                        intent.putExtra("stastic_scene", 5);
                        com.tencent.mm.bm.d.b(ac.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    } else {
                        String[] split = dVar.field_reserved3.split(",");
                        com.tencent.mm.sdk.b.b qpVar = new qp();
                        qpVar.fIi.userName = split[0];
                        qpVar.fIi.fIk = bh.az(split[1], "");
                        qpVar.fIi.fIl = Integer.parseInt(split[2]);
                        qpVar.fIi.scene = 1077;
                        a.xef.m(qpVar);
                    }
                    if (ShakeItemListUI.d(this.qqB)) {
                        h.a(dVar);
                        h.b(dVar);
                    }
                }
            } else if (k.we(i2)) {
                k.a(dVar, this.qqB, true);
            } else {
                String str = dVar.field_username;
                ar.Hg();
                af WO = com.tencent.mm.z.c.EY().WO(str);
                x.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + WO.field_username);
                x.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.l.a.fZ(WO.field_type) + "  contact:" + WO);
                if (com.tencent.mm.l.a.fZ(WO.field_type)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Contact_Scene", this.qqD == dVar.field_sex ? 23 : 24);
                    intent2.putExtra("Sns_from_Scene", 22);
                    if (str != null && str.length() > 0) {
                        if (WO.cia()) {
                            g.pQN.k(10298, dVar.field_username + "," + intent2.getIntExtra("Contact_Scene", 23));
                            intent2.putExtra("Contact_Scene", 23);
                        }
                        com.tencent.mm.plugin.shake.a.ifs.d(intent2, this.qqB);
                        return;
                    }
                    return;
                }
                x.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + WO.field_username);
                Intent intent3 = new Intent();
                intent3.putExtra("Contact_User", dVar.field_username);
                intent3.putExtra("Contact_Nick", dVar.field_nickname);
                intent3.putExtra("Contact_Distance", dVar.field_distance);
                intent3.putExtra("Contact_Signature", dVar.field_signature);
                intent3.putExtra("Contact_Province", dVar.getProvince());
                intent3.putExtra("Contact_City", dVar.getCity());
                intent3.putExtra("Contact_Sex", dVar.field_sex);
                intent3.putExtra("Contact_IsLBSFriend", true);
                intent3.putExtra("Contact_VUser_Info", dVar.field_reserved3);
                intent3.putExtra("Contact_VUser_Info_Flag", dVar.field_reserved1);
                intent3.putExtra("Contact_Scene", this.qqD == dVar.field_sex ? 23 : 24);
                intent3.putExtra("Sns_from_Scene", 22);
                intent3.putExtra("Contact_KSnsIFlag", dVar.field_snsFlag);
                intent3.putExtra("Contact_KSnsBgUrl", dVar.field_sns_bgurl);
                if ((dVar.field_reserved1 & 8) > 0) {
                    g.pQN.k(10298, dVar.field_username + "," + intent3.getIntExtra("Contact_Scene", 23));
                }
                com.tencent.mm.plugin.shake.a.ifs.d(intent3, this.qqB);
            }
        }
    }
}
