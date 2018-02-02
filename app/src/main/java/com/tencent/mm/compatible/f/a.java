package com.tencent.mm.compatible.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.TypedValue;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.io.InputStream;

public final class a extends BitmapFactory {
    private static a gHf = null;

    public interface a {
        Bitmap decodeResource(Resources resources, int i, Options options);
    }

    public static void a(a aVar) {
        gHf = aVar;
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        return decodeResource(resources, i, null);
    }

    public static Bitmap decodeResource(Resources resources, int i, Options options) {
        if (gHf != null) {
            Bitmap decodeResource = gHf.decodeResource(resources, i, options);
            if (decodeResource != null) {
                return decodeResource;
            }
        }
        return a(resources, i, options);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Bitmap a(Resources resources, int i, Options options) {
        InputStream openRawResource;
        Bitmap decodeResourceStream;
        Throwable th;
        InputStream inputStream = null;
        d.c(options);
        try {
            TypedValue typedValue = new TypedValue();
            openRawResource = resources.openRawResource(i, typedValue);
            try {
                decodeResourceStream = decodeResourceStream(resources, typedValue, openRawResource, null, options);
                if (decodeResourceStream == null) {
                    decodeResourceStream = decodeStream(openRawResource);
                }
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Exception e2) {
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (IOException e3) {
                    }
                }
                if (decodeResourceStream == null) {
                }
                return decodeResourceStream;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                inputStream = openRawResource;
                th = th3;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            openRawResource = inputStream;
            if (openRawResource != null) {
                openRawResource.close();
            }
            if (decodeResourceStream == null) {
            }
            return decodeResourceStream;
        } catch (Throwable th4) {
            th = th4;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        if (decodeResourceStream == null || options == null) {
            return decodeResourceStream;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    }
}
