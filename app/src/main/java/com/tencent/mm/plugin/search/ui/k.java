package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.network.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.fts.d.g;
import com.tencent.mm.plugin.fts.d.g.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class k implements g {
    private static int qdp = 32;
    private af hae = new af(Looper.getMainLooper());
    private ConcurrentHashMap<String, a> qdq;
    private Vector<String> qdr;
    private boolean qds = true;
    private int qdt = 0;
    private af[] qdu = new af[2];
    private ConcurrentHashMap<Long, ByteArrayOutputStream> qdv = null;
    private ConcurrentHashMap<Long, byte[]> qdw = null;
    private af qdx = null;
    private Set<String> qdy;

    interface c {
        void ay(String str, boolean z);
    }

    static /* synthetic */ Bitmap Q(String str, int i, int i2) {
        if (bh.ov(str) || !new File(str).exists()) {
            return null;
        }
        return (i <= 0 || i2 <= 0) ? j.op(str) : j.m(str, i, i2);
    }

    static /* synthetic */ void a(k kVar, String str, String str2, Bitmap bitmap) {
        if (kVar.qdq.size() > qdp) {
            kVar.IV((String) kVar.qdr.lastElement());
        }
        a aVar = new a(kVar);
        aVar.fCa = str2;
        aVar.bitmap = bitmap;
        kVar.qdq.put(str, aVar);
        if (!new File(aVar.fCa).exists()) {
            kVar.qdx.postDelayed(new d(kVar, aVar), 200);
        }
    }

    public k() {
        int i = 0;
        x.i("MicroMsg.FTS.SearchImageLoader", "create SearchImageLoader");
        if (d.fM(19)) {
            qdp = 64;
        } else {
            qdp = 32;
        }
        this.qdq = new ConcurrentHashMap();
        this.qdr = new Vector();
        this.qdv = new ConcurrentHashMap();
        this.qdw = new ConcurrentHashMap();
        this.qdy = Collections.synchronizedSet(new HashSet());
        while (i < 2) {
            if (this.qdu[i] == null) {
                e.d(new Runnable(this) {
                    final /* synthetic */ k qdz;

                    public final void run() {
                        Looper.prepare();
                        this.qdz.qdu[i] = new af();
                        Looper.loop();
                    }
                }, "SearchImageLoader_loadImage_handler", 1).start();
            }
            i++;
        }
        e.d(new Runnable(this) {
            final /* synthetic */ k qdz;

            {
                this.qdz = r1;
            }

            public final void run() {
                Looper.prepare();
                this.qdz.qdx = new af();
                Looper.loop();
            }
        }, "SearchImageLoader_saveImage_handler", 1).start();
    }

    public final void a(final Context context, final ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        String a = a(imageView, str, str2, z, i, i2);
        if (this.qds) {
            Runnable bVar = new b(this, a, str, str2, z, i, i2, new c(this) {
                final /* synthetic */ k qdz;

                public final void ay(final String str, boolean z) {
                    x.v("MicroMsg.FTS.SearchImageLoader", "LoadBitmapJob finish: %s %b", new Object[]{str, Boolean.valueOf(z)});
                    this.qdz.qdy.remove(str);
                    if (z) {
                        final Bitmap a = this.qdz.lz(str);
                        if (str.equals(imageView.getTag())) {
                            this.qdz.hae.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 qdA;

                                public final void run() {
                                    if (str.equals(imageView.getTag())) {
                                        a.a(context.getResources(), a, imageView);
                                    }
                                }
                            });
                        }
                    }
                }
            });
            if (this.qdy.add(a)) {
                this.qdt++;
                this.qdt %= 2;
                this.qdu[this.qdt].post(bVar);
                return;
            }
            x.v("MicroMsg.FTS.SearchImageLoader", "cacheKey: %s | runningJobTask: %s", new Object[]{a, this.qdy.toString()});
        }
    }

    public final String a(ImageView imageView, String str, String str2, boolean z, int i, int i2) {
        String b = b(str, str2, z, i, i2);
        imageView.setTag(b);
        x.d("MicroMsg.FTS.SearchImageLoader", "update image view cache key: hashcode=%d | cacheKey=%s", new Object[]{Integer.valueOf(imageView.hashCode()), b});
        return b;
    }

    public final void aNq() {
        x.d("MicroMsg.FTS.SearchImageLoader", "stopLoadImageTask");
        for (int i = 0; i < 2; i++) {
            if (this.qdu[i] != null) {
                this.qdu[i].removeCallbacksAndMessages(null);
            }
        }
    }

    public final void aNr() {
        x.d("MicroMsg.FTS.SearchImageLoader", "stopLoadImage");
        this.qds = false;
        aNq();
    }

    public final boolean aNs() {
        return this.qds;
    }

    public final void aNt() {
        x.d("MicroMsg.FTS.SearchImageLoader", "startLoadImage");
        this.qds = true;
    }

    public final void aNu() {
        x.d("MicroMsg.FTS.SearchImageLoader", "clearCacheAndTask %s", new Object[]{Integer.valueOf(this.qdq.size())});
        aNq();
        for (Entry key : this.qdq.entrySet()) {
            IV((String) key.getKey());
        }
        this.qdr.clear();
        this.qdy.clear();
    }

    public final void aNv() {
        aNu();
        x.d("MicroMsg.FTS.SearchImageLoader", "destoryLoader");
        for (int i = 0; i < 2; i++) {
            if (this.qdu[i] != null) {
                this.qdu[i].getLooper().quit();
            }
        }
        for (ByteArrayOutputStream close : this.qdv.values()) {
            try {
                close.close();
            } catch (IOException e) {
            }
        }
        this.qdv.clear();
        this.qdw.clear();
        this.qdx.getLooper().quit();
    }

    public final Bitmap a(String str, String str2, boolean z, int i, int i2) {
        return lz(b(str, str2, z, i, i2));
    }

    private Bitmap lz(String str) {
        a aVar = (a) this.qdq.get(str);
        if (!(aVar == null || aVar.bitmap == null || aVar.bitmap.isRecycled())) {
            this.qdr.remove(str);
            this.qdr.add(0, str);
        }
        return aVar == null ? null : aVar.bitmap;
    }

    private synchronized byte[] getBuffer() {
        byte[] bArr;
        bArr = (byte[]) this.qdw.get(Long.valueOf(Thread.currentThread().getId()));
        if (bArr == null) {
            bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            this.qdw.put(Long.valueOf(Thread.currentThread().getId()), bArr);
        }
        return bArr;
    }

    private static String b(String str, String str2, boolean z, int i, int i2) {
        return "fts_search_" + com.tencent.mm.a.g.s((bh.az(str, "null") + bh.az(str2, "null") + z + i + "_" + i2).getBytes());
    }

    private Bitmap c(String str, boolean z, int i, int i2) {
        Throwable e;
        Bitmap bl;
        if (bh.ov(str)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.qdv.get(Long.valueOf(Thread.currentThread().getId()));
        if (byteArrayOutputStream == null) {
            byteArrayOutputStream = new ByteArrayOutputStream(WXMediaMessage.THUMB_LENGTH_LIMIT);
            this.qdv.put(Long.valueOf(Thread.currentThread().getId()), byteArrayOutputStream);
        }
        byteArrayOutputStream.reset();
        byte[] buffer = getBuffer();
        InputStream l;
        try {
            l = b.l(str, 10000, HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            if (l == null) {
                x.w("MicroMsg.FTS.SearchImageLoader", "download %s error, can not open http stream", new Object[]{str});
                if (l != null) {
                    try {
                        l.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e2, "", new Object[0]);
                    }
                }
                return null;
            }
            int i3 = 0;
            while (true) {
                try {
                    int read = l.read(buffer);
                    if (read == -1) {
                        break;
                    }
                    i3 += read;
                    byteArrayOutputStream.write(buffer, 0, read);
                } catch (Exception e3) {
                    e2 = e3;
                }
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (i <= 0 || i2 <= 0) {
                bl = com.tencent.mm.sdk.platformtools.d.bl(toByteArray);
            } else {
                bl = com.tencent.mm.sdk.platformtools.d.decodeByteArray(toByteArray, i, i2);
            }
            x.d("MicroMsg.FTS.SearchImageLoader", "get url[%s] ok, bufSize[%d], bitmap size %d * %d", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(bl.getWidth()), Integer.valueOf(bl.getHeight())});
            if (z) {
                bl = com.tencent.mm.sdk.platformtools.d.a(bl, true, (float) bl.getWidth());
                if (l == null) {
                    return bl;
                }
                try {
                    l.close();
                    return bl;
                } catch (Throwable e4) {
                    x.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e4, "", new Object[0]);
                    return bl;
                }
            } else if (l == null) {
                return bl;
            } else {
                try {
                    l.close();
                    return bl;
                } catch (Throwable e42) {
                    x.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e42, "", new Object[0]);
                    return bl;
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            l = null;
            try {
                x.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e2, "", new Object[0]);
                x.w("MicroMsg.FTS.SearchImageLoader", "get url:%s failed.", new Object[]{str});
                if (l != null) {
                    try {
                        l.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e22, "", new Object[0]);
                    }
                }
                return null;
            } catch (Throwable th) {
                e22 = th;
                if (l != null) {
                    try {
                        l.close();
                    } catch (Throwable e422) {
                        x.printErrStackTrace("MicroMsg.FTS.SearchImageLoader", e422, "", new Object[0]);
                    }
                }
                throw e22;
            }
        } catch (Throwable th2) {
            e22 = th2;
            l = null;
            if (l != null) {
                l.close();
            }
            throw e22;
        }
    }

    private void IV(String str) {
        a aVar = (a) this.qdq.get(str);
        this.qdr.remove(str);
        this.qdq.remove(str);
        if (aVar != null && aVar.bitmap != null) {
            if (!aVar.bitmap.isRecycled()) {
                x.i("MicroMsg.FTS.SearchImageLoader", "bitmap recycle %s", new Object[]{aVar.bitmap});
                aVar.bitmap.recycle();
            }
            aVar.bitmap = null;
        }
    }
}
