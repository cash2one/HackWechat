package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.canvas.g;
import com.tencent.mm.plugin.appbrand.canvas.g.a;

final class c implements g {
    c() {
    }

    public final Bitmap aQ(String str, String str2) {
        return a(str, str2, null);
    }

    public final Bitmap a(String str, String str2, a aVar) {
        return a(str, str2, null, aVar);
    }

    public final Bitmap a(String str, String str2, Rect rect, a aVar) {
        if (str2.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, str2);
            if (itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.hhZ)) {
                return null;
            }
            String str3 = itemByLocalId.hhZ;
            if (!str3.startsWith("file://")) {
                str3 = "file://" + str3;
            }
            return b.Jj().a(str3, null);
        } else if (!str2.startsWith("https://") && !str2.startsWith("http://")) {
            return a.aQ(str, str2);
        } else {
            Bitmap a = b.Jj().a(str2, null);
            if (a != null) {
                return a;
            }
            b.Jj().a(new 1(this, aVar, str, str2), str2, null, null);
            return a;
        }
    }
}
