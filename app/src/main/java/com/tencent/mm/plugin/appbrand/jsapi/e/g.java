package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.graphics.Rect;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.widget.input.b.f;
import com.tencent.mm.plugin.appbrand.widget.input.b.h;
import com.tencent.mm.plugin.appbrand.widget.input.h.a;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends a<h> {
    private static final int CTRL_INDEX = 112;
    private static final String NAME = "updateInput";

    public void a(p pVar, JSONObject jSONObject, int i) {
        final f hVar = new h();
        if (a(hVar, jSONObject, pVar, i)) {
            try {
                final int i2 = jSONObject.getInt("inputId");
                if (hVar.kbI != null && hVar.kbI.intValue() < 0) {
                    hVar.kbI = Integer.valueOf(0);
                }
                if (hVar.kbJ != null && hVar.kbJ.intValue() < 0) {
                    hVar.kbJ = Integer.valueOf(0);
                }
                String optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA, null);
                if (optString != null) {
                    J(i2, optString);
                }
                final p pVar2 = pVar;
                final int i3 = i;
                c.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ g jkj;

                    public final void run() {
                        Object obj;
                        com.tencent.mm.plugin.appbrand.widget.input.h amB = a.amB();
                        int i = i2;
                        h hVar = hVar;
                        com.tencent.mm.plugin.appbrand.widget.input.c cVar = (com.tencent.mm.plugin.appbrand.widget.input.c) amB.jXh.get(Integer.valueOf(i));
                        if (cVar != null) {
                            if (hVar.kbH != null) {
                                cVar.uW(hVar.kbH);
                            }
                            cVar.a(hVar);
                            View amv = cVar.amv();
                            if (amv != null) {
                                p pVar = (p) cVar.jWK.get();
                                if (!(pVar == null || pVar.jDS == null)) {
                                    com.tencent.mm.plugin.appbrand.widget.input.f fVar = pVar.jDR;
                                    if (fVar != null) {
                                        Rect amw = cVar.amw();
                                        fVar.b(pVar.jDS, amv, amw.width(), amw.height(), amw.left, amw.top);
                                    }
                                }
                            }
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            pVar2.E(i3, this.jkj.e("ok", null));
                        } else if (m.a(hVar, i2)) {
                            pVar2.E(i3, this.jkj.e("ok", null));
                        } else {
                            pVar2.E(i3, this.jkj.e("fail", null));
                        }
                    }
                });
            } catch (JSONException e) {
                pVar.E(i, e("fail:invalid data", null));
            }
        }
    }

    protected final boolean agk() {
        return true;
    }
}
