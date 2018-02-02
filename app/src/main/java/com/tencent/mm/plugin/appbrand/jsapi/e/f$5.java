package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.g;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class f$5 extends AppBrandInputInvokeHandler {
    final /* synthetic */ int gOK;
    final /* synthetic */ WeakReference jjX;
    final /* synthetic */ String jjY;
    final /* synthetic */ f jkd;

    f$5(f fVar, WeakReference weakReference, int i, String str) {
        this.jkd = fVar;
        this.jjX = weakReference;
        this.gOK = i;
        this.jjY = str;
    }

    public final void onInputDone(String str, int i, boolean z, boolean z2) {
        if (this.jkd.agn()) {
            c.bk(this);
        }
        if (this.jjX.get() != null) {
            try {
                String jSONObject = new JSONObject().put(DownloadSettingTable$Columns.VALUE, c.uF(str)).put("inputId", getInputId()).put("cursor", i).toString();
                if (z) {
                    ((p) this.jjX.get()).h("onKeyboardConfirm", jSONObject, 0);
                }
                if (!z2) {
                    ((p) this.jjX.get()).h("onKeyboardComplete", jSONObject, 0);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", new Object[]{bh.i(e)});
            }
            if (!z2) {
                ago();
            }
        }
    }

    public final void onInputInitialized() {
        if (this.jjX.get() != null) {
            int inputId = getInputId();
            Map hashMap = new HashMap(1);
            hashMap.put("inputId", Integer.valueOf(inputId));
            ((p) this.jjX.get()).E(this.gOK, this.jkd.e("ok", hashMap));
            f.J(inputId, this.jjY);
            f.a(inputId, (p) this.jjX.get());
        }
    }

    public final void onRuntimeFail() {
        c.bk(this);
        if (this.jjX.get() != null) {
            ((p) this.jjX.get()).E(this.gOK, this.jkd.e("fail", null));
            ago();
        }
    }

    public final void ky(int i) {
        try {
            p pVar = (p) this.jjX.get();
            if (pVar != null) {
                pVar.h("onKeyboardShow", g.Cd().C("inputId", getInputId()).C("height", f.lH(i)).toString(), 0);
            }
        } catch (Exception e) {
        }
    }

    private void ago() {
        p pVar = (p) this.jjX.get();
        if (pVar != null && pVar.jDS != null) {
            com.tencent.mm.plugin.appbrand.widget.input.g.amA().p(pVar.jDS);
        }
    }
}
