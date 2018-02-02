package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WebviewScanImageActivity$1 extends c<kg> {
    final /* synthetic */ WebviewScanImageActivity tvV;

    WebviewScanImageActivity$1(WebviewScanImageActivity webviewScanImageActivity) {
        this.tvV = webviewScanImageActivity;
        super(0);
        this.xen = kg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kg kgVar = (kg) bVar;
        if (kgVar != null && (kgVar instanceof kg)) {
            a.xef.c(WebviewScanImageActivity.a(this.tvV));
            x.i("MicroMsg.WebviewScanImageActivity", "notify Event: %d", new Object[]{Integer.valueOf(kgVar.fBC.fBA)});
            x.d("MicroMsg.WebviewScanImageActivity", "%s, %s", new Object[]{kgVar.fBC.activity, this.tvV});
            if (kgVar.fBC.activity == this.tvV && kgVar.fBC.fov.equals(WebviewScanImageActivity.b(this.tvV))) {
                Bundle bundle = kgVar.fBC.fBD;
                int i;
                switch (kgVar.fBC.fBA) {
                    case 0:
                    case 1:
                    case 2:
                        this.tvV.finish();
                        break;
                    case 3:
                        if (bundle != null) {
                            i = bundle.getInt("geta8key_action_code", 0);
                            g.pQN.h(13329, new Object[]{WebviewScanImageActivity.c(this.tvV), WebviewScanImageActivity.b(this.tvV), Integer.valueOf(i)});
                        }
                        this.tvV.finish();
                        break;
                    case 4:
                        if (bundle != null) {
                            i = bundle.getInt("geta8key_action_code", 0);
                            g.pQN.h(13329, new Object[]{WebviewScanImageActivity.c(this.tvV), WebviewScanImageActivity.b(this.tvV), Integer.valueOf(i)});
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            x.e("MicroMsg.WebviewScanImageActivity", "not the same, eventStr: %s, origin: %s", new Object[]{kgVar.fBC.fov, WebviewScanImageActivity.b(this.tvV)});
        } else {
            x.e("MicroMsg.WebviewScanImageActivity", "event is null or not a instant of NotifyDealQBarStrResultEvent");
        }
        return false;
    }
}
