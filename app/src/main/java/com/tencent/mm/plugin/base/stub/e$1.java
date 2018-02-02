package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.net.Uri;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.rtmp.TXLivePushConfig;
import java.net.URLDecoder;

class e$1 implements e {
    final /* synthetic */ Runnable kuW;
    final /* synthetic */ Activity oZ;

    e$1(Activity activity, Runnable runnable) {
        this.oZ = activity;
        this.kuW = runnable;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
        x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", new Object[]{((ak) kVar).Sp()});
            try {
                Uri parse = Uri.parse(((ak) kVar).Sp());
                if (parse == null) {
                    x.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
                    e.l(this.oZ);
                    return;
                }
                String queryParameter = parse.getQueryParameter("result");
                if (queryParameter != null) {
                    x.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", new Object[]{URLDecoder.decode(queryParameter)});
                    b bzVar = new bz();
                    bzVar.fqa.activity = this.oZ;
                    bzVar.fqa.fov = queryParameter;
                    bzVar.fqa.fqb = 19;
                    bzVar.fqa.fqe = 3;
                    bzVar.fqa.fqf = parse.getQueryParameter("appid");
                    bzVar.fqa.fqh = this.oZ.getIntent().getBundleExtra("_stat_obj");
                    a.xef.m(bzVar);
                    if (this.kuW != null) {
                        this.kuW.run();
                    }
                    ag.h(new Runnable(this) {
                        final /* synthetic */ e$1 kuX;

                        {
                            this.kuX = r1;
                        }

                        public final void run() {
                            this.kuX.oZ.finish();
                        }
                    }, 100);
                    return;
                }
                return;
            } catch (Exception e) {
                x.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", new Object[]{e});
                e.l(this.oZ);
                return;
            }
        }
        x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
        e.l(this.oZ);
    }
}
