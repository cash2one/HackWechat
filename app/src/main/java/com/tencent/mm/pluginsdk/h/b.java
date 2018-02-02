package com.tencent.mm.pluginsdk.h;

import android.app.Activity;
import com.tencent.mm.ae.e;
import java.util.HashSet;
import java.util.Set;

public abstract class b implements e {
    public Activity activity;
    Set<Integer> vfO = new HashSet();

    public abstract boolean b(o oVar);

    public abstract boolean c(o oVar);

    public abstract boolean d(o oVar);

    public abstract boolean e(o oVar);

    public b(Activity activity) {
        this.activity = activity;
    }

    public final boolean a(o oVar) {
        if (oVar.action == 0) {
            return false;
        }
        switch (oVar.action) {
            case 1:
                return b(oVar);
            case 2:
                return c(oVar);
            case 4:
                return d(oVar);
            case 5:
                return e(oVar);
            default:
                return false;
        }
    }
}
