package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.d;
import com.tencent.mm.plugin.appbrand.widget.input.b.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.b.e;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.h;
import com.tencent.mm.plugin.appbrand.widget.input.h.1;
import com.tencent.mm.plugin.appbrand.widget.input.h.2;
import com.tencent.mm.plugin.appbrand.widget.input.h.a;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends a<e> {
    public static final int CTRL_INDEX = 1;
    static final String NAME = "showKeyboard";

    static /* synthetic */ void a(f fVar, p pVar, int i, int i2, String str, e eVar, int i3) {
        Object obj;
        h amB = a.amB();
        c a = c$a.a(eVar.kbC, pVar, eVar);
        if (a == null) {
            obj = null;
        } else {
            boolean z;
            if (eVar.kbH != null) {
                a.uW(eVar.kbH);
            }
            a.a(eVar);
            if (eVar.kbG != null) {
                com.tencent.mm.plugin.appbrand.widget.input.b.a.a aVar = eVar.kbG;
                p pVar2 = (p) a.jWK.get();
                if (!(pVar2 == null || a.amv() == null)) {
                    d.a(pVar2, a.amv(), aVar);
                }
            }
            int intValue = eVar.kbI.intValue();
            int intValue2 = eVar.kbJ.intValue();
            int intValue3 = eVar.kbL.intValue();
            int intValue4 = eVar.kbK.intValue();
            p pVar3 = (p) a.jWK.get();
            if (pVar3 == null || pVar3.jDS == null) {
                z = false;
            } else {
                View amv = a.amv();
                if (amv == null) {
                    z = false;
                } else {
                    com.tencent.mm.plugin.appbrand.widget.input.f fVar2 = pVar3.jDR;
                    if (fVar2 == null) {
                        z = false;
                    } else {
                        boolean a2 = fVar2.a(pVar3.jDS, amv, intValue, intValue2, intValue3, intValue4);
                        if (a2) {
                            ((z) amv).a(a.jWL);
                            amv.addTextChangedListener(a);
                        }
                        z = a2;
                    }
                }
            }
            if (!z) {
                obj = null;
            } else if (a.showKeyboard(i, i2)) {
                WeakReference weakReference = new WeakReference(pVar);
                int inputId = a.getInputId();
                a.jWH = new 2(amB, weakReference, inputId, str);
                a.jWI = new h$3(amB, weakReference, inputId);
                if (!(pVar == null || a == null)) {
                    int inputId2 = a.getInputId();
                    pVar.a(new 1(amB, inputId2));
                    amB.jXh.put(Integer.valueOf(inputId2), a);
                }
                obj = Integer.valueOf(inputId);
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            Map hashMap = new HashMap(1);
            hashMap.put("inputId", obj);
            pVar.E(i3, fVar.e("ok", hashMap));
            return;
        }
        String str2 = pVar.mAppId;
        inputId = pVar.hashCode();
        WeakReference weakReference2 = new WeakReference(pVar);
        eVar.jWK = weakReference2;
        AppBrandInputInvokeHandler a3 = fVar.a(weakReference2, str, i3);
        a3.setOnValueChangeListener(new 3(fVar, a3, str2, inputId));
        fVar.a(a3);
        com.tencent.mm.plugin.appbrand.q.c.runOnUiThread(new 4(fVar, weakReference2, a3, eVar, i, i2));
    }

    public void a(p pVar, JSONObject jSONObject, int i) {
        int optInt;
        int optInt2 = jSONObject.optInt("cursor", -2);
        if (jSONObject.has("selectionStart") || jSONObject.has("selectionEnd")) {
            optInt = jSONObject.optInt("selectionStart", -2);
            optInt2 = jSONObject.optInt("selectionEnd", -2);
        } else {
            optInt = optInt2;
        }
        try {
            int i2 = jSONObject.getInt("inputId");
            if (agl()) {
                ag.y(new 1(this, pVar, i2, optInt, optInt2, i));
                return;
            }
        } catch (JSONException e) {
        }
        e eVar = new e();
        if (a(eVar, jSONObject, pVar, i)) {
            if (!jSONObject.has("inputId")) {
                eVar.jWO = (pVar.hashCode() + "#" + System.currentTimeMillis() + "#" + System.nanoTime()).hashCode();
            }
            com.tencent.mm.plugin.appbrand.q.c.runOnUiThread(new 2(this, pVar, optInt, optInt2, jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA), eVar, i));
        }
    }

    protected boolean agl() {
        return true;
    }

    protected boolean agm() {
        return true;
    }

    protected void a(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
    }

    protected boolean agn() {
        return true;
    }

    protected AppBrandInputInvokeHandler a(WeakReference<p> weakReference, String str, int i) {
        return new 5(this, weakReference, i, str);
    }

    protected boolean a(e eVar, JSONObject jSONObject, p pVar, int i) {
        int i2 = 0;
        if (!super.a(eVar, jSONObject, pVar, i)) {
            return false;
        }
        int i3;
        eVar.kbB = jSONObject.optInt("parentId");
        eVar.jWO = jSONObject.optInt("inputId");
        eVar.kbI = Integer.valueOf(Math.max(0, eVar.kbI.intValue()));
        if (eVar.kbJ == null) {
            i3 = 0;
        } else {
            i3 = Math.max(0, eVar.kbJ.intValue());
        }
        eVar.kbJ = Integer.valueOf(i3);
        eVar.kbC = jSONObject.optString(DownloadSettingTable$Columns.TYPE, "text");
        if (m.jXO.contains(eVar.kbC)) {
            if (eVar.kch == null) {
                eVar.kch = Boolean.valueOf(true);
            }
            eVar.kbD = jSONObject.optBoolean("password");
            eVar.kcp = Boolean.valueOf(jSONObject.optBoolean("password"));
            if (agm()) {
                JSONObject optJSONObject = jSONObject.optJSONObject("dropdown");
                if (optJSONObject != null) {
                    com.tencent.mm.plugin.appbrand.widget.input.b.a.a aVar = new com.tencent.mm.plugin.appbrand.widget.input.b.a.a();
                    aVar.kbn = optJSONObject.optInt("marginLeft");
                    aVar.kbo = optJSONObject.optInt("marginRight");
                    aVar.kbp = optJSONObject.optString("width");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("options");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        aVar.kbq = new ArrayList();
                        while (i2 < optJSONArray.length()) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                String optString = optJSONObject2.optString(SlookAirButtonFrequentContactAdapter.ID);
                                String optString2 = optJSONObject2.optString("title");
                                String optString3 = optJSONObject2.optString("content");
                                if (!(bh.ov(optString) || bh.ov(optString2))) {
                                    b bVar = new b();
                                    bVar.id = optString;
                                    bVar.title = optString2;
                                    bVar.content = optString3;
                                    aVar.kbq.add(bVar);
                                }
                            }
                            i2++;
                        }
                        eVar.kbG = aVar;
                    }
                }
            }
            return true;
        }
        pVar.E(i, e("fail:unsupported input type", null));
        return false;
    }
}
