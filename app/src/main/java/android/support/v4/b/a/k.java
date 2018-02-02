package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class k {
    public static i a(Resources resources, Bitmap bitmap) {
        if (VERSION.SDK_INT >= 21) {
            return new j(resources, bitmap);
        }
        return new a(resources, bitmap);
    }
}
