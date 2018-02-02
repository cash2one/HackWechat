package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bh;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 120;
    private static final String NAME = "getImageInfo";
    private static final Collection<b> jnx;

    private static final class a implements b {
        private a() {
        }

        public final com.tencent.mm.vending.j.a i(e eVar, String str) {
            if (!str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                return null;
            }
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(eVar.mAppId, str);
            if (itemByLocalId == null || bh.ov(itemByLocalId.hhZ) || !com.tencent.mm.a.e.bO(itemByLocalId.hhZ)) {
                return com.tencent.mm.vending.j.a.cr(e.jnB);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(itemByLocalId.hhZ, options);
            c cVar = new c((byte) 0);
            cVar.width = options.outWidth;
            cVar.height = options.outHeight;
            cVar.type = com.tencent.mm.plugin.appbrand.q.a.b(options);
            cVar.iNT = com.tencent.mm.plugin.appbrand.q.a.a(options) ? com.tencent.mm.plugin.appbrand.q.a.lJ(com.tencent.mm.plugin.appbrand.q.a.uD(itemByLocalId.hhZ)) : "up";
            return com.tencent.mm.vending.j.a.v(e.jnD, cVar);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("src");
        if (bh.ov(optString)) {
            jVar.E(i, e("fail:invalid data", null));
            return;
        }
        com.tencent.mm.sdk.f.e.b(new 1(this, jVar, optString, new WeakReference(jVar), i), String.format(Locale.US, "AppBrandJsApiGetImageInfo[%s]", new Object[]{optString}), 10);
    }

    static {
        Collection linkedList = new LinkedList();
        linkedList.add(new a());
        linkedList.add(new d((byte) 0));
        jnx = Collections.unmodifiableCollection(linkedList);
    }
}
