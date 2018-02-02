package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.po;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.p$d;

class FlipView$4 implements p$d {
    final /* synthetic */ String jjz;
    final /* synthetic */ String jqK;
    final /* synthetic */ FlipView rsJ;
    final /* synthetic */ String uS;

    FlipView$4(FlipView flipView, String str, String str2, String str3) {
        this.rsJ = flipView;
        this.jjz = str;
        this.jqK = str2;
        this.uS = str3;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        m Lm = ae.bvv().Lm(this.jjz);
        if (Lm == null) {
            x.i("MicroMsg.FlipView", "error beacause info null");
            return;
        }
        m Lm2;
        switch (menuItem.getItemId()) {
            case 0:
                if (Lm.field_type != 15) {
                    k.h(this.jqK, FlipView.e(this.rsJ));
                    return;
                } else {
                    FlipView.LM(this.jjz);
                    return;
                }
            case 1:
                if (Lm.field_type != 15) {
                    Intent intent = new Intent();
                    intent.putExtra("Retr_File_Name", this.jqK);
                    intent.putExtra("Retr_Compress_Type", 0);
                    intent.putExtra("Retr_Msg_Type", 0);
                    if (Lm != null) {
                        intent.putExtra("Retr_FromMainTimeline", this.rsJ.bzn());
                        intent.putExtra("Retr_KSnsId", i.g(Lm));
                    }
                    a.ifs.l(intent, FlipView.e(this.rsJ));
                    return;
                }
                new StringBuilder().append(am.r(ae.getAccSnsPath(), this.uS)).append(i.e((aqr) Lm.bxV().wQo.vYd.get(0)));
                FlipView.LN(this.jjz);
                return;
            case 2:
                cf cfVar;
                b poVar;
                if (Lm.field_type != 15) {
                    cfVar = new cf();
                    String str = this.jjz;
                    String str2 = this.uS;
                    if (str2 == null || bh.ov(str)) {
                        x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                        cfVar.fqp.fqv = j.efh;
                    } else if (ae.bve()) {
                        x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                        cfVar.fqp.fqv = j.qJx;
                    } else {
                        Lm2 = ae.bvv().Lm(str);
                        if (Lm2 == null) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                            cfVar.fqp.fqv = j.efi;
                        } else {
                            com.tencent.mm.plugin.sns.i.a.a(cfVar, Lm2, str2);
                        }
                    }
                    cfVar.fqp.fqw = 13;
                    cfVar.fqp.activity = (Activity) FlipView.e(this.rsJ);
                    com.tencent.mm.sdk.b.a.xef.m(cfVar);
                    if (this.rsJ.bzn()) {
                        poVar = new po();
                        poVar.fHr.fzW = i.g(Lm);
                        poVar.fHr.frH = Lm.byq();
                        com.tencent.mm.sdk.b.a.xef.m(poVar);
                        return;
                    }
                    return;
                } else if (Lm != null) {
                    if (Lm.xl(32)) {
                        cfVar = new cf();
                        com.tencent.mm.plugin.sns.i.a.a(cfVar, Lm);
                        cfVar.fqp.fqw = 14;
                        cfVar.fqp.activity = (Activity) FlipView.e(this.rsJ);
                        com.tencent.mm.sdk.b.a.xef.m(cfVar);
                    } else {
                        FlipView.j(this.rsJ.bzn(), Lm.byq());
                    }
                    if (this.rsJ.bzn()) {
                        poVar = new po();
                        poVar.fHr.fzW = i.g(Lm);
                        poVar.fHr.frH = Lm.byq();
                        com.tencent.mm.sdk.b.a.xef.m(poVar);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 3:
                Intent intent2 = new Intent();
                intent2.putExtra("k_expose_msg_id", this.rsJ.bzm());
                Lm2 = ae.bvv().eR(this.rsJ.bzm());
                intent2.putExtra("k_username", Lm2 == null ? "" : Lm2.field_userName);
                intent2.putExtra("showShare", false);
                intent2.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect33");
                intent2.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                d.b(FlipView.e(this.rsJ), "webview", ".ui.tools.WebViewUI", intent2);
                return;
            case 4:
                x.i("MicroMsg.FlipView", "request deal QBAR string");
                b bzVar = new bz();
                bzVar.fqa.activity = (Activity) FlipView.e(this.rsJ);
                bzVar.fqa.fov = FlipView.f(this.rsJ);
                bzVar.fqa.fqb = FlipView.g(this.rsJ);
                bzVar.fqa.fqc = FlipView.h(this.rsJ);
                aqr a = ai.a(Lm, this.uS);
                if (a != null) {
                    bzVar.fqa.imagePath = a.nfX;
                    bzVar.fqa.fqg = a.wxV;
                }
                bzVar.fqa.scene = 38;
                if (FlipView.e(this.rsJ) instanceof Activity) {
                    bzVar.fqa.fqh = ((Activity) FlipView.e(this.rsJ)).getIntent().getBundleExtra("_stat_obj");
                }
                if (this.rsJ instanceof SnsInfoFlip) {
                    SnsInfoFlip snsInfoFlip = (SnsInfoFlip) this.rsJ;
                    an anVar = snsInfoFlip.qQS;
                    x.d("MicroMsg.FlipView", "from Scene: %s", new Object[]{anVar.tag});
                    if (anVar.tag.equals(an.xyR.tag) || anVar.tag.equals(an.xyS.tag) || anVar.tag.equals(an.xyT.tag)) {
                        bzVar.fqa.fqd = 5;
                        if (bh.ov(snsInfoFlip.username)) {
                            x.i("MicroMsg.FlipView", "empty username");
                            snsInfoFlip.username = "";
                        }
                        bzVar.fqa.bhd = snsInfoFlip.username;
                    } else if (anVar.tag.equals(an.xyQ.tag)) {
                        bzVar.fqa.fqd = 3;
                    } else {
                        x.i("MicroMsg.FlipView", "other scene_from: %s", new Object[]{anVar.tag});
                    }
                }
                com.tencent.mm.sdk.b.a.xef.m(bzVar);
                return;
            case 5:
                if (Lm.bxV().wQo.vYd.size() != 0) {
                    Intent intent3 = new Intent();
                    if (Lm.field_type == 1) {
                        int position = this.rsJ.getPosition();
                        int size = Lm.bxV().wQo.vYd.size();
                        if (size <= 1 || position <= 1 || position > size) {
                            position = 0;
                        } else {
                            position--;
                        }
                        String f = FlipView.f(this.jqK, FlipView.e(this.rsJ));
                        if (f != null) {
                            intent3.putExtra("sns_send_data_ui_image_path", f);
                            intent3.putExtra("sns_send_data_ui_image_position", position);
                        } else {
                            return;
                        }
                    }
                    intent3.putExtra("sns_send_data_ui_activity", true);
                    intent3.putExtra("sns_local_id", this.jjz);
                    d.a(FlipView.e(this.rsJ), ".ui.chatting.ChattingSendDataToDeviceUI", intent3);
                    return;
                }
                return;
            case 6:
                this.rsJ.LL(this.jqK);
                return;
            default:
                return;
        }
    }
}
