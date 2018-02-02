package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class f {
    public static final int tXW = R.i.dpg;
    public static final int tXX = R.i.dpf;
    public static final int tXY = R.i.dpd;
    public SparseArray<Integer> tXZ = new SparseArray();

    public f() {
        this.tXZ.put(1, Integer.valueOf(tXW));
        this.tXZ.put(2, Integer.valueOf(tXX));
        this.tXZ.put(4, Integer.valueOf(tXX));
        this.tXZ.put(3, Integer.valueOf(tXX));
        this.tXZ.put(5, Integer.valueOf(tXX));
        this.tXZ.put(6, Integer.valueOf(tXX));
        this.tXZ.put(0, Integer.valueOf(tXX));
        this.tXZ.put(-1, Integer.valueOf(tXX));
        this.tXZ.put(-3, Integer.valueOf(tXY));
        this.tXZ.put(-2, Integer.valueOf(tXX));
        this.tXZ.put(-4, Integer.valueOf(tXX));
    }

    public static a a(int i, View view, k kVar) {
        switch (i) {
            case -4:
                return new i(view, kVar);
            case -3:
                return new d(view, kVar);
            case -2:
                return new b(view, kVar);
            case -1:
                return new j(view, kVar);
            case 0:
                return new l(view, kVar);
            case 1:
                return new k(view, kVar);
            case 2:
                return new e(view, kVar);
            case 3:
                return new g(view, kVar);
            case 4:
                return new n(view, kVar);
            case 5:
                return new c(view, kVar);
            case 6:
                return new m(view, kVar);
            default:
                return null;
        }
    }
}
