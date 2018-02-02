package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.b.e;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class c extends f {
    private static final int CTRL_INDEX = 110;
    private static final String NAME = "insertTextArea";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        super.a(pVar, jSONObject, i);
    }

    protected final boolean agl() {
        return false;
    }

    protected final boolean agm() {
        return false;
    }

    protected final boolean a(e eVar, JSONObject jSONObject, p pVar, int i) {
        if (!super.a(eVar, jSONObject, pVar, i)) {
            return false;
        }
        eVar.kca = Boolean.valueOf(true);
        eVar.kbC = "emoji";
        eVar.kbD = false;
        eVar.kbE = false;
        eVar.kcg = Boolean.valueOf(false);
        eVar.kcb = Boolean.valueOf(jSONObject.optBoolean("confirm", true));
        return true;
    }

    protected final void a(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        super.a(appBrandInputInvokeHandler);
        appBrandInputInvokeHandler.setOnLineHeightChangeListener(new 1(this, appBrandInputInvokeHandler));
        appBrandInputInvokeHandler.setOnInputFocusChangeListener(new 2(this, appBrandInputInvokeHandler));
    }

    protected final AppBrandInputInvokeHandler a(WeakReference<p> weakReference, String str, int i) {
        return new 3(this, weakReference, i, str);
    }

    protected final boolean agn() {
        return false;
    }
}
