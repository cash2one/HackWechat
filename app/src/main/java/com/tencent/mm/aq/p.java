package com.tencent.mm.aq;

import android.graphics.Bitmap;
import com.tencent.mm.aq.c.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class p implements c {
    List<c> hCK = new LinkedList();
    c hCL = null;
    boolean hCM = false;

    public final void a(String str, a aVar) {
        if (bh.ov(str) || aVar == null) {
            x.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
        } else if (this.hCL != null && this.hCL.url.equals(str) && this.hCL.hCO == aVar) {
            x.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        } else {
            for (c cVar : this.hCK) {
                if (cVar.url.equals(str) && cVar.hCO == aVar) {
                    x.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
                    return;
                }
            }
            this.hCK.add(new c(str, aVar));
            PD();
        }
    }

    final void PD() {
        while (this.hCL == null && this.hCK.size() != 0) {
            this.hCL = (c) this.hCK.get(0);
            this.hCK.remove(0);
            this.hCM = false;
            o.Pv();
            Bitmap iG = c.iG(this.hCL.url);
            if (iG != null) {
                x.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.hCL.url);
                if (!this.hCM) {
                    this.hCL.hCO.h(this.hCL.url, iG);
                }
                this.hCL = null;
            } else {
                new 1(this).execute(new String[]{this.hCL.url});
                return;
            }
        }
        x.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
    }

    static String lu(String str) {
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            if (bh.ov(encode)) {
                x.e("MicroMsg.UrlImageCacheService", "encode result is null: " + str);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(e.gHt);
            int length = encode.length();
            int i = 0;
            while (i < length) {
                stringBuilder.append('/');
                if (i + 20 < length) {
                    stringBuilder.append(encode.substring(i, i + 20));
                    i += 20;
                } else {
                    stringBuilder.append(encode.substring(i, length));
                    i = length;
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: " + str);
            return null;
        }
    }

    public final void n(Bitmap bitmap) {
        if (bitmap == null) {
            x.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.hCL.url);
            this.hCL = null;
            PD();
            return;
        }
        x.i("MicroMsg.UrlImageCacheService", "load from %s successed", new Object[]{this.hCL.url});
        new 2(this).execute(new b[]{new b(lu(this.hCL.url), bitmap)});
        if (!this.hCM) {
            o.Pv();
            c.g(this.hCL.url, bitmap);
            this.hCL.hCO.h(this.hCL.url, bitmap);
        }
        this.hCL = null;
        PD();
    }
}
