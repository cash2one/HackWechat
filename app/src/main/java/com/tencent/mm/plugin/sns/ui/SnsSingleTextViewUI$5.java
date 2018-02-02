package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class SnsSingleTextViewUI$5 implements d {
    final /* synthetic */ SnsSingleTextViewUI rGK;

    SnsSingleTextViewUI$5(SnsSingleTextViewUI snsSingleTextViewUI) {
        this.rGK = snsSingleTextViewUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                if (SnsSingleTextViewUI.c(this.rGK) != null && SnsSingleTextViewUI.c(this.rGK).getText() != null) {
                    SnsSingleTextViewUI.d(this.rGK).setText(SnsSingleTextViewUI.c(this.rGK).getText());
                    h.bu(this.rGK.mController.xIM, this.rGK.mController.xIM.getString(j.dEt));
                    if (SnsSingleTextViewUI.a(this.rGK) != null) {
                        int i2 = a.qff;
                        a.d(2, bh.fL(SnsSingleTextViewUI.a(this.rGK).field_snsId), bh.Vy(SnsSingleTextViewUI.c(this.rGK).getText().toString()));
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (SnsSingleTextViewUI.c(this.rGK) != null && SnsSingleTextViewUI.c(this.rGK).getText() != null) {
                    b cfVar = new cf();
                    com.tencent.mm.plugin.sns.i.a.a(cfVar, SnsSingleTextViewUI.e(this.rGK), SnsSingleTextViewUI.c(this.rGK).getText());
                    cfVar.fqp.activity = this.rGK;
                    cfVar.fqp.fqw = 18;
                    com.tencent.mm.sdk.b.a.xef.m(cfVar);
                    return;
                }
                return;
            case 6:
                if (SnsSingleTextViewUI.c(this.rGK) != null && SnsSingleTextViewUI.c(this.rGK).getText() != null) {
                    Intent intent = new Intent();
                    m Lm = ae.bvv().Lm(SnsSingleTextViewUI.e(this.rGK));
                    intent.putExtra("k_username", Lm == null ? "" : Lm.field_userName);
                    intent.putExtra("k_expose_msg_id", Lm == null ? Integer.valueOf(0) : Lm.bxW());
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    com.tencent.mm.bm.d.b(this.rGK, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                return;
            case 14:
                if (SnsSingleTextViewUI.c(this.rGK) != null && SnsSingleTextViewUI.c(this.rGK).getText() != null) {
                    ao.o(ae.bvv().Lm(SnsSingleTextViewUI.e(this.rGK)));
                    return;
                }
                return;
            case 16:
                if (SnsSingleTextViewUI.c(this.rGK) != null && SnsSingleTextViewUI.c(this.rGK).getText() != null) {
                    ao.p(ae.bvv().Lm(SnsSingleTextViewUI.e(this.rGK)));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
