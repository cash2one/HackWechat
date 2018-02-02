package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.a.b.d;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.a.b.g;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.d.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

final class b$k implements b$d$a {
    final g hjQ;
    final b hke;
    final String hkg;
    private final f hkh;
    private final b$i hki;
    private final e hkj;
    private final String hkk;
    boolean hkl;

    private b$k(String str, f fVar, b bVar, b$i com_tencent_mm_modelappbrand_a_b_i, g gVar, e eVar, String str2) {
        this.hkl = true;
        this.hkg = str;
        this.hkh = fVar;
        this.hke = bVar;
        this.hki = com_tencent_mm_modelappbrand_a_b_i;
        this.hjQ = gVar;
        this.hkj = eVar;
        this.hkk = str2;
    }

    final String Jt() {
        return b.aa(this.hkk, Ju());
    }

    final String Ju() {
        return b.b(this.hkg, this.hkh, this.hkj);
    }

    final void Jv() {
        try {
            Bitmap Jw = Jw();
            if (Jw != null && !Jw.isRecycled()) {
                b.d(this.hke).iI(b.access$1500(this.hkg));
                b.d(this.hke).a(b.access$1500(this.hkg), this);
                l(Jw);
                b.d(this.hke).iH(b.access$1500(this.hkg));
            }
        } catch (d e) {
            x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", new Object[]{e});
            b.d(this.hke).iI(b.access$1500(this.hkg));
            b.d(this.hke).iJ(b.access$1500(this.hkg));
            l(null);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " doIOJobImpl, io exp ", new Object[0]);
            b.d(this.hke).iI(b.access$1500(this.hkg));
            b.d(this.hke).a(b.access$1500(this.hkg), this);
            b.d(this.hke).iH(b.access$1500(this.hkg));
        }
    }

    public final void Jp() {
        Bitmap iG = this.hki.iG(Ju());
        if (iG == null || iG.isRecycled()) {
            d d = b.d(this.hke);
            String access$1500 = b.access$1500(this.hkg);
            if (bh.ov(access$1500) ? false : d.hkc.containsKey(access$1500)) {
                d d2 = b.d(this.hke);
                String access$15002 = b.access$1500(this.hkg);
                if (!(bh.ov(access$15002) || this == null)) {
                    List list = (List) d2.hkb.get(access$15002);
                    if (list == null) {
                        list = new LinkedList();
                        d2.hkb.put(access$15002, list);
                    }
                    list.add(this);
                }
                x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", new Object[]{b.access$1500(this.hkg)});
                return;
            }
            d = b.d(this.hke);
            String access$15003 = b.access$1500(this.hkg);
            if (!bh.ov(access$15003)) {
                d.hkc.put(access$15003, Boolean.valueOf(true));
            }
            Jv();
            return;
        }
        x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", new Object[]{Ju()});
        ag.y(new 1(this, iG));
    }

    public final void Jq() {
        h hVar = (h) b.b(this.hke).remove(Jt());
        if (hVar != null) {
            b.a(this.hke).remove(hVar);
        }
    }

    final void j(Bitmap bitmap) {
        h hVar = (h) b.b(this.hke).remove(Jt());
        if (hVar != null) {
            hVar.j(bitmap);
            b.a(this.hke).remove(hVar);
        }
    }

    private void l(Bitmap bitmap) {
        boolean z = false;
        String str = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
        String str2 = "postLoadInWorkerThread bitmap ok %b";
        Object[] objArr = new Object[1];
        boolean z2 = (bitmap == null || bitmap.isRecycled()) ? false : true;
        objArr[0] = Boolean.valueOf(z2);
        x.d(str, str2, objArr);
        if (!(this.hkh == null || bitmap == null || bitmap.isRecycled())) {
            Bitmap k = this.hkh.k(bitmap);
            x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", new Object[]{bitmap, k});
            if (k != bitmap) {
                this.hki.g(bitmap);
            }
            bitmap = k;
        }
        this.hki.c(Ju(), bitmap);
        String str3 = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
        str = "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b";
        Object[] objArr2 = new Object[2];
        objArr2[0] = bitmap;
        if (!(bitmap == null || bitmap.isRecycled())) {
            z = true;
        }
        objArr2[1] = Boolean.valueOf(z);
        x.d(str3, str, objArr2);
        ag.y(new 3(this, bitmap));
    }

    private Bitmap Jw() {
        Bitmap bitmap = null;
        if (b.Jl()) {
            InputStream openRead;
            if (this.hkg == null || !this.hkg.startsWith("file://")) {
                openRead = this.hjQ.openRead(b.access$1500(this.hkg));
                if (openRead == null) {
                    x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", new Object[]{Boolean.valueOf(this.hkl)});
                    if (this.hkl) {
                        com.tencent.mm.sdk.f.e.post(new 4(this), "AppBrandSimpleImageLoaderDownloadThread");
                    } else {
                        b.d(this.hke).iJ(b.access$1500(this.hkg));
                        b.d(this.hke).iI(b.access$1500(this.hkg));
                    }
                }
            } else {
                try {
                    openRead = new FileInputStream(this.hkg.replaceFirst("file://", ""));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "load from local file ", new Object[0]);
                }
            }
            if (openRead != null) {
                try {
                    bitmap = g(openRead);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " decode ", new Object[0]);
                }
                if (bitmap == null || bitmap.isRecycled()) {
                    x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", new Object[]{bitmap});
                    throw new a();
                }
                x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", new Object[]{bitmap, Integer.valueOf(android.support.v4.b.a.b(bitmap) / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), this.hkg});
            }
            return bitmap;
        }
        x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
        throw new d$b();
    }

    private Bitmap g(InputStream inputStream) {
        try {
            Bitmap f;
            if (this.hkj != null) {
                f = this.hkj.f(inputStream);
            } else {
                f = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                bh.d(inputStream);
            }
            return f;
        } finally {
            bh.d(inputStream);
        }
    }
}
