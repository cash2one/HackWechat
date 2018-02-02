package com.tencent.mm.plugin.wallet_core.e;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.view.View;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.view.b;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.bh;

class a$4 implements Runnable {
    final /* synthetic */ e sYA;
    final /* synthetic */ View sYB;
    final /* synthetic */ a sYx;
    final /* synthetic */ a$a sYy;

    a$4(a aVar, View view, e eVar, a$a com_tencent_mm_plugin_wallet_core_e_a_a) {
        this.sYx = aVar;
        this.sYB = view;
        this.sYA = eVar;
        this.sYy = com_tencent_mm_plugin_wallet_core_e_a_a;
    }

    public final void run() {
        this.sYB.invalidate();
        String str = this.sYA.sLu;
        int i = "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png".equals(str) ? a.e.udG : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png".equals(str) ? a.e.udI : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png".equals(str) ? a.e.udJ : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png".equals(str) ? a.e.udK : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png".equals(str) ? a.e.udL : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png".equals(str) ? a.e.udP : -1;
        if (i != -1) {
            this.sYB.setBackgroundResource(i);
        } else if (!bh.ov(this.sYA.sLu)) {
            Object cVar = new c(this.sYA.sLu);
            Bitmap a = j.a(cVar);
            j.a(this.sYy);
            if (a != null) {
                try {
                    byte[] ninePatchChunk = a.getNinePatchChunk();
                    if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                        FileOp.deleteFile(cVar.Wf());
                    }
                } catch (Exception e) {
                }
            }
            if (a != null) {
                this.sYB.setBackgroundDrawable(b.c(this.sYB.getContext(), a));
            }
        } else if (this.sYA.sLx > 0) {
            this.sYB.setBackgroundResource(this.sYA.sLx);
        }
    }
}
