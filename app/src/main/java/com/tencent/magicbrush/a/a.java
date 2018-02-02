package com.tencent.magicbrush.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.magicbrush.a.c.f;
import java.io.InputStream;

public final class a {
    private static a bnl = new a() {
        public final Bitmap a(String str, InputStream inputStream) {
            Bitmap bitmap = null;
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            try {
                bitmap = BitmapFactory.decodeStream(inputStream, null, options);
            } catch (Exception e) {
                f.e("MB.BitmapDelegate", "Decode Image error", new Object[0]);
            }
            com.tencent.magicbrush.a.d(inputStream);
            return bitmap;
        }
    };

    public static void a(a aVar) {
        bnl = aVar;
    }

    public static a sA() {
        return bnl;
    }
}
