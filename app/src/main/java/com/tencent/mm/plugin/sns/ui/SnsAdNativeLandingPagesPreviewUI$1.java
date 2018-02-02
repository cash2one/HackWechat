package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.c.adu;
import com.tencent.mm.protocal.c.xp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingPagesPreviewUI$1 implements a {
    final /* synthetic */ long roD;
    final /* synthetic */ View rxp;
    final /* synthetic */ int rxq;
    final /* synthetic */ String rxr;
    final /* synthetic */ String rxs;
    final /* synthetic */ SnsAdNativeLandingPagesPreviewUI rxt;
    final /* synthetic */ Intent val$intent;

    SnsAdNativeLandingPagesPreviewUI$1(SnsAdNativeLandingPagesPreviewUI snsAdNativeLandingPagesPreviewUI, View view, int i, String str, String str2, long j, Intent intent) {
        this.rxt = snsAdNativeLandingPagesPreviewUI;
        this.rxp = view;
        this.rxq = i;
        this.rxr = str;
        this.rxs = str2;
        this.roD = j;
        this.val$intent = intent;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        this.rxp.setVisibility(8);
        if (i == 0 && i2 == 0) {
            if (this.rxq == 1) {
                Object cdp = ((adu) bVar.hmh.hmo).wmm.cdp();
                x.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo canvasid %s, canvasext %s, xml %s", new Object[]{this.rxr, this.rxs, cdp});
                if (!TextUtils.isEmpty(cdp)) {
                    this.val$intent.putExtra("sns_landing_pages_xml", cdp);
                    if (SnsAdNativeLandingPagesPreviewUI.h(this.val$intent, cdp)) {
                        SnsAdNativeLandingPagesPreviewUI.a(this.rxt, this.val$intent, cdp);
                        i bxQ = i.bxQ();
                        String str2 = this.rxr;
                        String str3 = this.rxs;
                        if (!(TextUtils.isEmpty(cdp) || TextUtils.isEmpty(str2))) {
                            Object obj;
                            if (bh.ov(str3)) {
                                String str4 = str2;
                            } else {
                                obj = str2 + str3;
                            }
                            bxQ.roB.put(obj, cdp);
                            w wVar = new w();
                            wVar.field_canvasId = str2;
                            wVar.field_canvasXml = cdp;
                            wVar.field_canvasExt = str3;
                            bxQ.roA.a(wVar);
                        }
                    } else {
                        this.rxt.finish();
                        return 0;
                    }
                }
            }
            xp xpVar = (xp) bVar.hmh.hmo;
            x.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", new Object[]{Long.valueOf(this.roD), xpVar.wih});
            if (!TextUtils.isEmpty(xpVar.wih)) {
                this.val$intent.putExtra("sns_landing_pages_xml", xpVar.wih);
                if (SnsAdNativeLandingPagesPreviewUI.h(this.val$intent, xpVar.wih)) {
                    SnsAdNativeLandingPagesPreviewUI.a(this.rxt, this.val$intent, xpVar.wih);
                    i.bxQ().o(this.roD, xpVar.wih);
                } else {
                    this.rxt.finish();
                    return 0;
                }
            }
        } else if (this.rxq == 1) {
            x.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail canvas id %s, canvas ext %s, errType %d,errCode %s", new Object[]{this.rxr, this.rxs, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            x.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", new Object[]{Long.valueOf(this.roD), Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.rxt.finish();
        return 0;
    }
}
