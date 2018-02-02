package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.view.View;
import java.util.List;

public abstract class b implements i {
    public Context context;
    public com.tencent.mm.plugin.fts.d.i.b mOy;
    public int mOz;

    public b(Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i) {
        this.context = context;
        this.mOy = bVar;
        this.mOz = i;
    }

    public static boolean aU(List<? extends Object> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z) {
        return false;
    }
}
