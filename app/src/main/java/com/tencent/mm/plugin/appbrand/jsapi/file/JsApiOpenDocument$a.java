package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.OpenResult;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.platformtools.x;

final class JsApiOpenDocument$a extends AppBrandProxyUIProcessTask {
    private static final int jjE = (JsApiOpenDocument$a.class.hashCode() & 65535);

    private JsApiOpenDocument$a() {
    }

    static /* synthetic */ boolean a(JsApiOpenDocument$a jsApiOpenDocument$a) {
        return jsApiOpenDocument$a.jbq == null ? true : jsApiOpenDocument$a.jbq.aff();
    }

    protected final void a(AppBrandProxyUIProcessTask$ProcessRequest appBrandProxyUIProcessTask$ProcessRequest) {
        String str = ((JsApiOpenDocument$OpenRequest) appBrandProxyUIProcessTask$ProcessRequest).filePath;
        String str2 = ((JsApiOpenDocument$OpenRequest) appBrandProxyUIProcessTask$ProcessRequest).iHF;
        int a = s.a(afe(), str, str2, Integer.toString(afe().hashCode()), new 1(this));
        x.i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, ret = %d", new Object[]{Integer.valueOf(a)});
        if (a == -102) {
            try {
                Intent k = ((a) g.h(a.class)).k(afe(), str, str2);
                int i = jjE;
                afe().jwN = this;
                afe().startActivityForResult(k, i);
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.JsApiOpenDocument", e, " fallback to AppChooserUI ", new Object[0]);
            }
        }
        ProcessResult openResult = new OpenResult();
        openResult.ret = a;
        if (openResult.ret != 0) {
            a(openResult);
        } else if (this.jbq != null) {
            this.jbq.b(openResult);
        }
    }

    protected final void afk() {
        super.afk();
        afe().getWindow().setBackgroundDrawableResource(d.transparent);
    }

    public final void b(int i, int i2, Intent intent) {
        if (jjE == i) {
            ProcessResult openResult = new OpenResult();
            if (-1 == i2) {
                openResult.ret = 0;
            } else {
                openResult.ret = Integer.MAX_VALUE;
            }
            a(openResult);
            return;
        }
        a(null);
    }
}
