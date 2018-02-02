package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.plugin.appbrand.widget.h;
import com.tencent.mm.sdk.platformtools.bh;

public final class b {

    private static class a implements j<Bundle, ContentValues> {
        private a() {
        }

        public final /* synthetic */ Object at(Object obj) {
            g gVar;
            String string = ((Bundle) obj).getString(SlookAirButtonFrequentContactAdapter.ID);
            h Zp = ((com.tencent.mm.plugin.appbrand.widget.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.widget.a.a.class)).Zp();
            if (bh.ov(string)) {
                gVar = null;
            } else {
                gVar = new g();
                gVar.field_id = string;
                if (!Zp.b(gVar, new String[]{SlookAirButtonFrequentContactAdapter.ID})) {
                    gVar = null;
                }
            }
            return gVar == null ? null : gVar.vI();
        }
    }

    public static g rC(String str) {
        Parcelable bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        return a((ContentValues) f.a("com.tencent.mm", bundle, a.class));
    }

    static g a(ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        g gVar = new g();
        gVar.field_id = contentValues.getAsString(SlookAirButtonFrequentContactAdapter.ID);
        gVar.field_appId = contentValues.getAsString("appId");
        gVar.field_cacheKey = contentValues.getAsString("cacheKey");
        gVar.field_updateTime = bh.c(contentValues.getAsLong("updateTime"));
        gVar.field_interval = bh.e(contentValues.getAsInteger("interval"));
        gVar.xjy = bh.c(contentValues.getAsLong("rowid"));
        return gVar;
    }
}
