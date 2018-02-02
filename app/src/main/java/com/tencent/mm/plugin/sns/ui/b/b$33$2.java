package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.b.b.33;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p$d;

class b$33$2 implements p$d {
    final /* synthetic */ String gIT;
    final /* synthetic */ m rQb;
    final /* synthetic */ 33 rQf;
    final /* synthetic */ String rQg;

    b$33$2(33 33, m mVar, String str, String str2) {
        this.rQf = 33;
        this.rQb = mVar;
        this.gIT = str;
        this.rQg = str2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        long j = 0;
        Intent intent;
        switch (menuItem.getItemId()) {
            case 0:
                intent = new Intent();
                String str = "sns_permission_snsinfo_svr_id";
                if (this.rQb != null) {
                    j = this.rQb.field_snsId;
                }
                intent.putExtra(str, j);
                intent.putExtra("sns_permission_userName", this.gIT);
                intent.putExtra("sns_permission_anim", true);
                intent.putExtra("sns_permission_block_scene", 5);
                intent.setClass(this.rQf.rPY.activity, SnsPermissionUI.class);
                this.rQf.rPY.activity.startActivityForResult(intent, 11);
                return;
            case 1:
                intent = new Intent();
                m Lm = ae.bvv().Lm(this.rQg);
                if (Lm == null) {
                    x.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + this.rQg);
                    return;
                }
                x.i("MicroMsg.TimelineClickListener", "expose id " + Lm.bxW() + " " + Lm.field_userName);
                String str2 = "k_expose_msg_id";
                if (Lm != null) {
                    j = Lm.field_snsId;
                }
                intent.putExtra(str2, j);
                intent.putExtra("k_username", Lm == null ? "" : Lm.field_userName);
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                d.b(this.rQf.rPY.activity, "webview", ".ui.tools.WebViewUI", intent);
                return;
            default:
                return;
        }
    }
}
