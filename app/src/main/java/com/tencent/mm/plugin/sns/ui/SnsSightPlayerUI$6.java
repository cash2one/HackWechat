package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.po;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class SnsSightPlayerUI$6 implements d {
    final /* synthetic */ SnsSightPlayerUI rGv;

    SnsSightPlayerUI$6(SnsSightPlayerUI snsSightPlayerUI) {
        this.rGv = snsSightPlayerUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 1:
                intent = new Intent();
                m Lm = ae.bvv().Lm(SnsSightPlayerUI.d(this.rGv));
                if (Lm != null) {
                    x.i("MicroMsg.SnsSightPlayerUI", "expose id " + Lm.bxW());
                }
                intent.putExtra("k_expose_msg_id", Lm == null ? Integer.valueOf(0) : Lm.bxW());
                intent.putExtra("k_username", Lm == null ? "" : Lm.field_userName);
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                com.tencent.mm.bm.d.b(this.rGv, "webview", ".ui.tools.WebViewUI", intent);
                return;
            case 2:
                m Lm2 = ae.bvv().Lm(SnsSightPlayerUI.d(this.rGv));
                if (Lm2 != null) {
                    b cfVar = new cf();
                    a.a(cfVar, Lm2);
                    cfVar.fqp.activity = this.rGv;
                    cfVar.fqp.fqw = 17;
                    com.tencent.mm.sdk.b.a.xef.m(cfVar);
                    if (SnsSightPlayerUI.i(this.rGv)) {
                        k cVar = new c(Lm2.byz(), 11, 5, "", 2, SnsSightPlayerUI.a(this.rGv).bxW());
                        g.Dk();
                        g.Di().gPJ.a(cVar, 0);
                        j.a(j.d.qQf, j.c.qQa, e.qQm, 0, Lm2);
                    }
                    if (SnsSightPlayerUI.e(this.rGv) == 0) {
                        cfVar = new po();
                        cfVar.fHr.frH = Lm2.byq();
                        cfVar.fHr.fzW = i.g(Lm2);
                        com.tencent.mm.sdk.b.a.xef.m(cfVar);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                SnsSightPlayerUI.u(this.rGv);
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_Type", 3);
                intent2.putExtra("select_is_ret", true);
                intent2.putExtra("mutil_select_is_ret", true);
                intent2.putExtra("image_path", SnsSightPlayerUI.c(this.rGv));
                intent2.putExtra("Retr_Msg_Type", 11);
                com.tencent.mm.bm.d.a(this.rGv, ".ui.transmit.SelectConversationUI", intent2, 4097);
                return;
            case 4:
                m Lm3 = ae.bvv().Lm(SnsSightPlayerUI.d(this.rGv));
                if (Lm3 != null) {
                    intent = new Intent();
                    if (Lm3.bxV().wQo.vYc == 15 && ((aqr) Lm3.bxV().wQo.vYd.get(0)) == null) {
                        x.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
                        return;
                    }
                    intent.putExtra("exdevice_open_scene_type", 2);
                    intent.putExtra("sns_local_id", SnsSightPlayerUI.d(this.rGv));
                    intent.putExtra("sns_send_data_ui_activity", true);
                    com.tencent.mm.bm.d.a(this.rGv, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
