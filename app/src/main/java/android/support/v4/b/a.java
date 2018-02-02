package android.support.v4.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class a {
    static final b tT;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            tT = new e();
        } else if (i >= 18) {
            tT = new d();
        } else if (i >= 12) {
            tT = new c();
        } else {
            tT = new a();
        }
    }

    public static int b(Bitmap bitmap) {
        return tT.b(bitmap);
    }
}
