package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.design.widget.u.d;

class aa$1 implements d {
    aa$1() {
    }

    public final u ay() {
        return new u(VERSION.SDK_INT >= 12 ? new w() : new v());
    }
}
