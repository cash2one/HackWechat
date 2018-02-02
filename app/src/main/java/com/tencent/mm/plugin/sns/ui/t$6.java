package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class t$6 implements d {
    final /* synthetic */ int kI;
    final /* synthetic */ aqr qSH;
    final /* synthetic */ t rtq;
    final /* synthetic */ m rtr;

    t$6(t tVar, m mVar, aqr com_tencent_mm_protocal_c_aqr, int i) {
        this.rtq = tVar;
        this.rtr = mVar;
        this.qSH = com_tencent_mm_protocal_c_aqr;
        this.kI = i;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int itemId = menuItem.getItemId();
        x.d("MicroMsg.GalleryTitleManager", "showAlert " + itemId);
        switch (itemId) {
            case 2:
                if (this.rtr != null && this.rtr.bxV().wQo != null) {
                    if (this.rtr.field_type != 15) {
                        k.h(am.r(ae.getAccSnsPath(), this.qSH.nGJ) + i.l(this.qSH), this.rtq.context);
                        return;
                    } else {
                        t.LQ(this.rtr.byq());
                        return;
                    }
                }
                return;
            case 3:
                if (this.rtr != null && this.rtr.bxV().wQo != null) {
                    if (this.rtr.bxV().wQo.vYc == 1) {
                        this.rtq.LP(am.r(ae.getAccSnsPath(), this.qSH.nGJ) + i.l(this.qSH));
                        return;
                    }
                    t.LR(this.rtr.byq());
                    return;
                }
                return;
            case 4:
                t tVar = this.rtq;
                long j = this.rtr.field_snsId;
                m eR = ae.bvv().eR(j);
                if (j != 0 && eR != null) {
                    Intent intent = new Intent();
                    intent.putExtra("k_username", eR.field_userName);
                    intent.putExtra("k_expose_msg_id", j);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    com.tencent.mm.bm.d.b(tVar.context, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                return;
            case 6:
                if (this.rtr != null && this.rtr.bxV().wQo != null) {
                    t.a(this.rtq, this.rtr, this.qSH);
                    return;
                }
                return;
            case 7:
                Bundle bundle = new Bundle();
                bundle.putString("stat_msg_id", "sns_" + i.eq(this.rtr.field_snsId));
                bundle.putString("stat_send_msg_user", this.rtr.field_userName);
                bundle.putInt("stat_scene", 3);
                t.a(this.rtq, bundle);
                return;
            case 8:
                t.a(this.rtq, this.rtr, this.qSH, this.kI);
                return;
            default:
                return;
        }
    }
}
