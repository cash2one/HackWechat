package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l$b;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ShakeReportUI$18 implements OnClickListener {
    public long qqy = 0;
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$18(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onClick(View view) {
        if (!bh.ov((String) ShakeReportUI.p(this.qsi).getTag()) && ShakeReportUI.L(this.qsi) != null) {
            d L = ShakeReportUI.L(this.qsi);
            String str = L.field_username;
            Intent intent;
            if (11 != L.field_type) {
                ar.Hg();
                af WO = c.EY().WO(str);
                if (a.fZ(WO.field_type)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("Sns_from_Scene", 22);
                    if (str != null && str.length() > 0) {
                        if (WO.cia()) {
                            g.pQN.k(10298, str + "," + ShakeReportUI.M(this.qsi));
                            intent2.putExtra("Contact_Scene", ShakeReportUI.M(this.qsi));
                        }
                        com.tencent.mm.plugin.shake.a.ifs.d(intent2, this.qsi);
                        return;
                    }
                    return;
                }
                if ((L.field_reserved1 & 8) > 0) {
                    g.pQN.k(10298, L.field_username + "," + ShakeReportUI.M(this.qsi));
                }
                intent = new Intent();
                intent.putExtra("Contact_User", L.field_username);
                intent.putExtra("Contact_Nick", L.field_nickname);
                intent.putExtra("Contact_Distance", L.field_distance);
                intent.putExtra("Contact_Signature", L.field_signature);
                intent.putExtra("Contact_Province", L.getProvince());
                intent.putExtra("Contact_City", L.getCity());
                intent.putExtra("Contact_Sex", L.field_sex);
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Contact_VUser_Info", L.field_reserved3);
                intent.putExtra("Contact_VUser_Info_Flag", L.field_reserved1);
                intent.putExtra("Contact_KSnsIFlag", L.field_snsFlag);
                intent.putExtra("Contact_KSnsBgUrl", L.field_sns_bgurl);
                intent.putExtra("Contact_Scene", ShakeReportUI.M(this.qsi));
                intent.putExtra("Sns_from_Scene", 22);
                com.tencent.mm.plugin.shake.a.ifs.d(intent, this.qsi);
            } else if (System.currentTimeMillis() - this.qqy > 3000) {
                this.qqy = System.currentTimeMillis();
                if (L.field_reserved3 == null || L.field_reserved3.split(",").length != 3 || L.field_reserved3.split(",")[0] == null || L.field_reserved3.split(",")[0].equals("")) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", L.getCity());
                    intent.putExtra("scene", 27);
                    intent.putExtra("stastic_scene", 5);
                    com.tencent.mm.bm.d.b(ac.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                } else {
                    String[] split = L.field_reserved3.split(",");
                    b qpVar = new qp();
                    qpVar.fIi.userName = split[0];
                    qpVar.fIi.fIk = bh.az(split[1], "");
                    qpVar.fIi.fIl = bh.getInt(split[2], 0);
                    qpVar.fIi.scene = 1077;
                    com.tencent.mm.sdk.b.a.xef.m(qpVar);
                }
                l$b com_tencent_mm_plugin_shake_b_l_b = ShakeReportUI.C(this.qsi).qnQ;
                if (com_tencent_mm_plugin_shake_b_l_b != null && (com_tencent_mm_plugin_shake_b_l_b instanceof h)) {
                    h.a(L);
                    h.b(L);
                }
            }
        }
    }
}
