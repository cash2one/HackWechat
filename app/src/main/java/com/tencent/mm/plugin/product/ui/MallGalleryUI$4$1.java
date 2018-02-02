package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.product.ui.MallGalleryUI.4;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.z.q;

class MallGalleryUI$4$1 implements c {
    final /* synthetic */ 4 pfv;

    MallGalleryUI$4$1(4 4) {
        this.pfv = 4;
    }

    public final void jl(int i) {
        Context context;
        switch (i) {
            case 0:
                context = this.pfv.pfu;
                Intent intent = new Intent();
                intent.putExtra("Retr_Msg_content", "");
                intent.putExtra("Retr_Msg_Type", 0);
                if (bh.ov(context.bjj())) {
                    x.e("MicroMsg.MallGalleryUI", "url is null or nil");
                    return;
                }
                intent.putExtra("Retr_File_Name", context.bjj());
                intent.putExtra("Retr_go_to_chattingUI", false);
                intent.putExtra("Retr_show_success_tips", true);
                d.a(context, ".ui.transmit.MsgRetransmitUI", intent);
                return;
            case 1:
                context = this.pfv.pfu;
                String bjj = context.bjj();
                if (bh.ov(bjj)) {
                    x.w("MicroMsg.MallGalleryUI", "save error.");
                    return;
                }
                x.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[]{bjj});
                k.h(bjj, context);
                return;
            case 2:
                Activity activity = this.pfv.pfu;
                String bjj2 = activity.bjj();
                if (bh.ov(bjj2)) {
                    x.w("MicroMsg.MallGalleryUI", "file path invalid");
                    return;
                }
                x.d("MicroMsg.MallGalleryUI", "file path valid");
                b cfVar = new cf();
                if (bh.ov(bjj2)) {
                    x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    cfVar.fqp.fqv = i.efh;
                } else {
                    x.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[]{bjj2, Integer.valueOf(9)});
                    ve veVar = new ve();
                    vk vkVar = new vk();
                    uq uqVar = new uq();
                    uqVar.CJ(2);
                    uqVar.TE(bjj2);
                    uqVar.TD(g.s((uqVar.toString() + 2 + System.currentTimeMillis()).getBytes()));
                    b fvVar = new fv();
                    fvVar.fvq.type = 27;
                    fvVar.fvq.fvs = uqVar;
                    a.xef.m(fvVar);
                    String str = fvVar.fvr.fvC;
                    com.tencent.mm.sdk.platformtools.d.b(bjj2, 150, 150, CompressFormat.JPEG, 90, str);
                    uqVar.TF(str);
                    vkVar.Ui(q.FS());
                    vkVar.Uj(q.FS());
                    vkVar.CS(9);
                    vkVar.fC(bh.Wp());
                    veVar.a(vkVar);
                    veVar.weU.add(uqVar);
                    cfVar.fqp.title = uqVar.title;
                    cfVar.fqp.fqr = veVar;
                    cfVar.fqp.type = 2;
                }
                cfVar.fqp.fqw = 4;
                cfVar.fqp.activity = activity;
                a.xef.m(cfVar);
                return;
            default:
                return;
        }
    }
}
