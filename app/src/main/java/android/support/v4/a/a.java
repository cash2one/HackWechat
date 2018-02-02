package android.support.v4.a;

import android.os.Build.VERSION;
import android.view.View;

public final class a {
    private static final c oK;

    static {
        if (VERSION.SDK_INT >= 12) {
            oK = new f();
        } else {
            oK = new e();
        }
    }

    public static g aL() {
        return oK.aL();
    }

    public static void v(View view) {
        oK.v(view);
    }
}
