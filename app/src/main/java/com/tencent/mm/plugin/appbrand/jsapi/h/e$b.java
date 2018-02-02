package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

final class e$b extends c implements Runnable {
    private final AtomicReference<a[]> jpx;
    final /* synthetic */ e jpy;

    private e$b(e eVar) {
        this.jpy = eVar;
        this.jpx = new AtomicReference();
    }

    final void r(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("current");
        if (optJSONArray == null || optJSONArray2 == null || optJSONArray.length() != optJSONArray2.length()) {
            f("fail:invalid data", null);
        } else if (optJSONArray.length() <= 0) {
            f("fail empty range", null);
        } else {
            try {
                Object obj = new a[optJSONArray.length()];
                int i = 1;
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    int i3;
                    JSONArray jSONArray = optJSONArray.getJSONArray(i2);
                    int i4 = optJSONArray2.getInt(i2);
                    String[] strArr = new String[jSONArray.length()];
                    for (i3 = 0; i3 < strArr.length; i3++) {
                        strArr[i3] = jSONArray.getString(i3);
                    }
                    obj[i2] = new a(strArr, i4);
                    if (jSONArray.length() <= 0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    i &= i3;
                }
                if (i != 0) {
                    f("fail empty range", null);
                    return;
                }
                this.jpx.set(obj);
                c.runOnUiThread(this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", e, "opt params", new Object[0]);
                f("fail:invalid data", null);
            }
        }
    }

    public final void run() {
        AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) y(AppBrandMultiOptionsPicker.class);
        if (appBrandMultiOptionsPicker == null) {
            f("fail cant init view", null);
            return;
        }
        a[] aVarArr = (a[]) this.jpx.get();
        if (aVarArr == null || aVarArr.length <= 0) {
            f("fail error data", null);
            return;
        }
        if (aVarArr != null && aVarArr.length > 0) {
            int anK = appBrandMultiOptionsPicker.anK();
            appBrandMultiOptionsPicker.R(true);
            if (anK < aVarArr.length) {
                anK = aVarArr.length - anK;
                if (anK > 0) {
                    for (int i = anK; i > 0; i--) {
                        View 2 = new 2(appBrandMultiOptionsPicker, appBrandMultiOptionsPicker.getContext());
                        2.kez = appBrandMultiOptionsPicker.kde;
                        String str = "end";
                        String[] strArr = new String[]{"end", "middle", "start"};
                        for (anK = 0; anK < 3; anK++) {
                            if (strArr[anK].equals(str)) {
                                2.kec = str;
                                break;
                            }
                        }
                        2.kec = "end";
                        2.setDividerHeight(com.tencent.mm.bv.a.fromDPToPix(appBrandMultiOptionsPicker.getContext(), 1));
                        2.setTag(g.iuw, Integer.valueOf(appBrandMultiOptionsPicker.kdc.getChildCount()));
                        appBrandMultiOptionsPicker.kdc.addView(2, new LayoutParams(0, -1, 1.0f));
                    }
                }
            } else if (anK > aVarArr.length) {
                appBrandMultiOptionsPicker.mm(anK - aVarArr.length);
            }
            for (anK = 0; anK < aVarArr.length; anK++) {
                YANumberPicker ml = appBrandMultiOptionsPicker.ml(anK);
                a aVar = aVarArr[anK];
                ml.j(aVar.kdg);
                ml.setValue(aVar.kdh);
                ml.kez = appBrandMultiOptionsPicker.kde;
            }
            appBrandMultiOptionsPicker.kdc.setWeightSum((float) appBrandMultiOptionsPicker.anK());
            appBrandMultiOptionsPicker.R(false);
        }
        this.kcP.kdp = new 1(this);
        this.kcP.kdr = new 2(this);
        this.kcP.show();
    }
}
