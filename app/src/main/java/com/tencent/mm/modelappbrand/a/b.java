package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static final String hjR;
    private final Map<h, String> hjL;
    private final Map<String, h> hjM;
    private final Map<Integer, String> hjN;
    private final d hjO;
    private final i hjP;
    private final g hjQ;

    public interface e extends c {
        Bitmap f(InputStream inputStream);
    }

    public interface g {
        OutputStream iE(String str);

        boolean iF(String str);

        InputStream openRead(String str);
    }

    private static final class a implements g {
        private a() {
        }

        public final OutputStream iE(String str) {
            try {
                return new FileOutputStream(b.hjR + str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", e, "openWrite fileName %s", new Object[]{str});
                return null;
            }
        }

        public final InputStream openRead(String str) {
            try {
                return new FileInputStream(b.hjR + str);
            } catch (IOException e) {
                x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", new Object[]{str, e});
                return null;
            }
        }

        public final boolean iF(String str) {
            return !bh.ov(str) && com.tencent.mm.loader.stub.b.deleteFile(b.hjR + str);
        }
    }

    public static b Jj() {
        return l.hkq;
    }

    private b() {
        this.hjL = new ConcurrentHashMap();
        this.hjM = new ConcurrentHashMap();
        this.hjN = new ConcurrentHashMap();
        this.hjP = new c();
        this.hjQ = new a();
        this.hjO = new d(new af(new ag("AppBrandSimpleImageLoaderDiskIOHandlerThread").oAt.getLooper()), (byte) 0);
    }

    public final Bitmap iC(String str) {
        Bitmap iG = this.hjP.iG(str);
        if (iG == null || iG.isRecycled()) {
            return null;
        }
        return iG;
    }

    public final Bitmap a(String str, e eVar) {
        Closeable fileInputStream;
        Throwable e;
        Throwable th;
        if (bh.ov(str)) {
            return null;
        }
        String a = a(str, null, eVar);
        Bitmap iG = this.hjP.iG(a);
        if (iG != null) {
            return iG;
        }
        try {
            if (str.startsWith("file://")) {
                try {
                    fileInputStream = new FileInputStream(str.replaceFirst("file://", ""));
                } catch (FileNotFoundException e2) {
                    x.e("MicroMsg.AppBrandSimpleImageLoader", "findCachedLocal: load from local file, file not found ");
                    bh.d(null);
                    return null;
                }
            }
            fileInputStream = this.hjQ.openRead(iD(str));
            if (eVar != null) {
                try {
                    iG = eVar.f(fileInputStream);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
                        bh.d(fileInputStream);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bh.d(fileInputStream);
                        throw th;
                    }
                }
            }
            iG = d.decodeStream(fileInputStream);
            if (iG != null) {
                this.hjP.c(a, iG);
            }
            bh.d(fileInputStream);
            return iG;
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
            bh.d(fileInputStream);
            return null;
        } catch (Throwable e5) {
            fileInputStream = null;
            th = e5;
            bh.d(fileInputStream);
            throw th;
        }
    }

    public final String a(h hVar, String str, f fVar, e eVar) {
        String str2 = null;
        if (hVar != null) {
            if (bh.ov(str)) {
                hVar.Jn();
            } else {
                x.d("MicroMsg.AppBrandSimpleImageLoader", "load before start LoadTask url %s", new Object[]{str});
                k kVar = new k(str, fVar, this, this.hjP, this.hjQ, eVar, hVar.Jo(), (byte) 0);
                str2 = kVar.Ju();
                Runnable 1 = new 1(this, str2, hVar, str, kVar);
                if (ag.isMainThread()) {
                    1.run();
                } else {
                    ag.y(1);
                }
            }
        }
        return str2;
    }

    public final String a(h hVar, String str, f fVar) {
        return a(hVar, str, fVar, null);
    }

    public final String a(ImageView imageView, String str, Drawable drawable, f fVar) {
        return a(imageView, str, drawable, fVar, null);
    }

    public final String a(ImageView imageView, String str, Drawable drawable, f fVar, e eVar) {
        if (imageView == null) {
            return null;
        }
        String str2;
        if (imageView != null) {
            str2 = (String) this.hjN.get(Integer.valueOf(imageView.hashCode()));
            if (str2 != null) {
                h hVar = (h) this.hjM.get(str2);
                if (hVar != null) {
                    str2 = (String) this.hjL.get(hVar);
                    if (!bh.ov(str2)) {
                        this.hjM.remove(str2);
                    }
                }
            }
        }
        if (bh.ov(str)) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
            return null;
        }
        h 2 = new 2(this, imageView, this, drawable);
        str2 = a(2, str, fVar, eVar);
        if (2.hkf) {
            return str2;
        }
        this.hjN.put(Integer.valueOf(imageView.hashCode()), Z(2.aAM, str2));
        return str2;
    }

    private static String Z(String str, String str2) {
        return str + str2;
    }

    private static String a(String str, f fVar, e eVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (fVar != null) {
            stringBuilder.append("|transformation:");
            stringBuilder.append(fVar.Jo());
        }
        if (eVar != null) {
            stringBuilder.append("|decoder:");
            stringBuilder.append(eVar.Jo());
        }
        return stringBuilder.toString();
    }

    static {
        String str = com.tencent.mm.compatible.util.e.bnF;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        hjR = str;
        i.Qu(str);
    }

    private static String iD(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return com.tencent.mm.a.g.s(str.getBytes());
    }
}
