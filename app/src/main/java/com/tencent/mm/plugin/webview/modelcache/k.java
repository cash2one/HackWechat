package com.tencent.mm.plugin.webview.modelcache;

import android.database.Cursor;
import com.tencent.mm.plugin.webview.modelcache.d.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.LinkedList;
import java.util.List;

public final class k extends i<f> {
    private static volatile k ttE = null;
    private final e gJP;
    public final boolean iYd;

    public final /* synthetic */ boolean b(c cVar) {
        return a((f) cVar);
    }

    public static List<a> bRl() {
        List linkedList = new LinkedList();
        linkedList.add(new a("WEBVIEW_RESOURCE_CACHE_TABLE".hashCode(), new String[]{i.a(f.gJc, "WebViewResourceCache")}));
        return linkedList;
    }

    public static k bRm() {
        if (!ar.Hj()) {
            return new k(null);
        }
        if (ttE == null) {
            synchronized (k.class) {
                if (ttE == null || !ttE.iYd) {
                    ar.Hg();
                    ttE = new k(com.tencent.mm.z.c.EV());
                }
            }
        }
        return ttE;
    }

    private k(e eVar) {
        super(eVar, f.gJc, "WebViewResourceCache", null);
        this.gJP = eVar;
        this.iYd = eVar != null;
        if (!this.iYd) {
            x.e("MicroMsg.WebViewCacheResStorage", "storage can not work!!!");
        }
    }

    static String Ao(int i) {
        String str = "1=1";
        if (b$a.Ak(i) && b$a.Aj(i)) {
            return str;
        }
        return String.format(" %s=%s ", new Object[]{"protocol", Integer.valueOf(i)});
    }

    public final List<f> m(String str, String... strArr) {
        List<f> list = null;
        Cursor rawQuery = rawQuery(str, strArr);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                list = new LinkedList();
                do {
                    f fVar = new f();
                    fVar.b(rawQuery);
                    list.add(fVar);
                } while (rawQuery.moveToNext());
                rawQuery.close();
            } else {
                rawQuery.close();
            }
        }
        return list;
    }

    public final boolean checkIsCached(String str, int i) {
        if (!this.iYd || bh.ov(str)) {
            return false;
        }
        String Ao = Ao(i);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", Ao}), new String[]{String.valueOf(ab.UZ(str).hashCode())});
        if (rawQuery == null) {
            return false;
        }
        if (rawQuery.getCount() > 0) {
            rawQuery.close();
            return true;
        }
        rawQuery.close();
        return false;
    }

    private boolean a(f fVar) {
        if (!this.iYd) {
            return false;
        }
        if (bh.ov(fVar.field_url)) {
            x.d("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, url is null or nil");
            return false;
        }
        String UZ = ab.UZ(fVar.field_url);
        if (bh.ov(UZ)) {
            x.e("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, get md5 is null or nil , url = %s", new Object[]{fVar.field_url});
            return false;
        }
        fVar.field_urlMd5Hashcode = UZ.hashCode();
        long Wo = bh.Wo();
        fVar.field_accessTime = Wo;
        fVar.field_createTime = Wo;
        return a(fVar, false);
    }

    public final boolean insert(f fVar, int i, int i2) {
        return a(fVar);
    }

    public final boolean update(f fVar, int i, int i2) {
        return b(fVar);
    }

    public final boolean b(f fVar) {
        if (!this.iYd) {
            return false;
        }
        if (bh.ov(fVar.field_url)) {
            x.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, url is null or nil");
            return false;
        }
        long Wo = bh.Wo();
        fVar.field_accessTime = Wo;
        fVar.field_createTime = Wo;
        x.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, record = " + fVar);
        return b(fVar, false, new String[]{"urlMd5Hashcode", "appId", "domain", "cacheType", "packageId"});
    }
}
