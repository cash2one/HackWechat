package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.design.widget.u.d;
import android.view.View;

final class aa {
    static final d lR = new 1();
    private static final a lS;

    static {
        if (VERSION.SDK_INT >= 21) {
            lS = new c((byte) 0);
        } else {
            lS = new b((byte) 0);
        }
    }

    static void u(View view) {
        lS.u(view);
    }

    static u ay() {
        return lR.ay();
    }
}
