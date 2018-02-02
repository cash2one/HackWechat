package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.e.f.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class d$1 implements h {
    final /* synthetic */ WeakReference jjX;
    final /* synthetic */ WeakReference kat;

    d$1(WeakReference weakReference, WeakReference weakReference2) {
        this.kat = weakReference;
        this.jjX = weakReference2;
    }

    public final void a(String str, h$a com_tencent_mm_plugin_appbrand_widget_input_autofill_h_a) {
        EditText editText = (EditText) this.kat.get();
        p pVar = (p) this.jjX.get();
        if (editText != null && pVar != null) {
            int inputId = ((z) editText).getInputId();
            a aVar = new a();
            Map hashMap = new HashMap();
            hashMap.put(SlookAirButtonFrequentContactAdapter.ID, str);
            hashMap.put(DownloadSettingTable$Columns.TYPE, com_tencent_mm_plugin_appbrand_widget_input_autofill_h_a.name().toLowerCase());
            hashMap.put("inputId", Integer.valueOf(inputId));
            aVar.az(pVar.mAppId, pVar.hashCode()).v(hashMap).f(new int[]{pVar.hashCode()});
        }
    }
}
