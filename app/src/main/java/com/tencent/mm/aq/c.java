package com.tencent.mm.aq;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class c {
    private HashMap<String, c> hzB = new HashMap();

    static class a implements Runnable {
        private HashMap<String, c> hzB;
        private Bitmap hzC;
        private String url;

        public a(String str, Bitmap bitmap, HashMap<String, c> hashMap) {
            this.url = str;
            this.hzC = bitmap;
            this.hzB = hashMap;
        }

        public final void run() {
            o.Pv();
            c.g(this.url, this.hzC);
            if (this.hzB != null) {
                c cVar = (c) this.hzB.remove(this.url);
                if (cVar != null) {
                    cVar.n(this.hzC);
                }
            }
            String str = "MicroMsg.CdnImageService";
            String str2 = "finish download post job, url[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = this.url == null ? "null" : this.url;
            x.i(str, str2, objArr);
        }
    }

    public interface c {
        void n(Bitmap bitmap);
    }

    protected final void finalize() {
        super.finalize();
    }

    public static void g(String str, Bitmap bitmap) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.CdnImageService", "push fail, key is null");
        } else {
            com.tencent.mm.cache.e.a.a("local_cdn_img_cache", str, bitmap);
        }
    }

    public static Bitmap iG(String str) {
        if (str != null && str.length() != 0) {
            return (Bitmap) com.tencent.mm.cache.e.a.D("local_cdn_img_cache", str);
        }
        x.e("MicroMsg.CdnImageService", "get fail, key is null");
        return null;
    }

    public final void le(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
        } else {
            this.hzB.remove(str);
        }
    }

    public final void a(String str, c cVar) {
        if (bh.ov(str)) {
            x.w("MicroMsg.CdnImageService", "do load fail, url is empty");
            return;
        }
        Bitmap iG = iG(str);
        if (iG == null || iG.isRecycled()) {
            boolean z;
            String str2 = "MicroMsg.CdnImageService";
            String str3 = "try to download: url[%s], src bitmap is null[%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (iG == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            x.w(str2, str3, objArr);
            if (this.hzB.containsKey(str)) {
                x.w("MicroMsg.CdnImageService", "contains url[%s]", new Object[]{str});
                return;
            }
            this.hzB.put(str, cVar);
            e.post(new b(str, this.hzB), "CdnImageService_download");
            return;
        }
        x.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", new Object[]{str});
        if (cVar != null) {
            cVar.n(iG);
        }
    }
}
