package com.tencent.mm.ag;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public final class m {
    public static Bitmap kf(String str) {
        boolean z = false;
        if (bh.ov(str) || !g.Dj().isSDCardAvailable() || !g.Dh().Cy()) {
            return null;
        }
        Bitmap bitmap;
        a Mn = y.Mn();
        String format = String.format("%s%f", new Object[]{str, Float.valueOf(DownloadHelper.SAVE_FATOR)});
        if (Mn.hqb.containsKey(format)) {
            bitmap = (Bitmap) ((WeakReference) Mn.hqb.get(format)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = b.b(str, DownloadHelper.SAVE_FATOR);
                Mn.hqb.remove(format);
                Mn.hqb.put(format, new WeakReference(bitmap));
            }
        } else {
            bitmap = b.b(str, DownloadHelper.SAVE_FATOR);
            Mn.hqb.put(format, new WeakReference(bitmap));
        }
        String str2 = "MicroMsg.BrandLogic";
        format = "get verify user icon = %s, is null ? %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (bitmap == null) {
            z = true;
        }
        objArr[1] = String.valueOf(z);
        x.i(str2, format, objArr);
        return bitmap;
    }

    public static Bitmap d(String str, String str2, int i) {
        if (!g.Dj().isSDCardAvailable()) {
            return ht(i);
        }
        if (str == null || !g.Dh().Cy()) {
            return null;
        }
        Bitmap bitmap;
        if (str2 == null) {
            str2 = ag(str, null);
            if (str2 == null) {
                return null;
            }
        }
        a Mn = y.Mn();
        WeakReference weakReference;
        if (Mn.hqb.containsKey(str)) {
            bitmap = (Bitmap) ((WeakReference) Mn.hqb.get(str)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = d.UN(a.kh(str + ag(str, str2)));
                if (bitmap == null) {
                    x.i("MicroMsg.BrandLogic", "not found brand icon local");
                } else {
                    Mn.f(str, bitmap);
                }
            }
            weakReference = (WeakReference) Mn.hqb.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null) {
                    return bitmap;
                }
                ag.y(new 1(str, str2));
                return null;
            }
        }
        bitmap = d.UN(a.kh(str + ag(str, str2)));
        if (bitmap == null) {
            x.i("MicroMsg.BrandLogic", "not found brand icon local");
        } else {
            Mn.f(str, bitmap);
            weakReference = (WeakReference) Mn.hqb.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null) {
                    return bitmap;
                }
                ag.y(new 1(str, str2));
                return null;
            }
        }
        bitmap = null;
        if (bitmap == null) {
            return bitmap;
        }
        ag.y(new 1(str, str2));
        return null;
    }

    public static Bitmap kg(String str) {
        if (!g.Dj().isSDCardAvailable()) {
            return ht(0);
        }
        if (str == null || !g.Dh().Cy()) {
            return null;
        }
        Bitmap bitmap;
        a Mn = y.Mn();
        if (Mn.hqb.containsKey(str)) {
            bitmap = (Bitmap) ((WeakReference) Mn.hqb.get(str)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
        }
        bitmap = null;
        return bitmap;
    }

    private static Bitmap ht(int i) {
        Throwable th;
        if (i <= 0) {
            return null;
        }
        Options options = new Options();
        d.c(options);
        InputStream openRawResource;
        try {
            openRawResource = ac.getContext().getResources().openRawResource(i);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(openRawResource, null, options);
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.BrandLogic", e, "", new Object[0]);
                    }
                }
                if (decodeStream != null) {
                    return d.a(decodeStream, false, (float) (decodeStream.getWidth() >> 1));
                }
                return decodeStream;
            } catch (Throwable th2) {
                th = th2;
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.BrandLogic", e2, "", new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Throwable e22) {
            Throwable th3 = e22;
            openRawResource = null;
            th = th3;
            if (openRawResource != null) {
                openRawResource.close();
            }
            throw th;
        }
    }

    static String ag(String str, String str2) {
        if (str == null || !g.Dh().Cy()) {
            return null;
        }
        d jK = y.Mf().jK(str);
        if (jK.field_brandIconURL != null) {
            return jK.field_brandIconURL;
        }
        return str2;
    }
}
