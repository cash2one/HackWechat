package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.j.c;

public abstract class b$b {
    final /* synthetic */ b mPG;

    public abstract View a(Context context, ViewGroup viewGroup);

    public abstract void a(Context context, a aVar, b bVar, Object... objArr);

    public abstract boolean a(Context context, b bVar);

    public b$b(b bVar) {
        this.mPG = bVar;
    }

    public static void a(String str, j jVar) {
        ((m) g.k(m.class)).updateTopHitsRank(str, jVar, 0);
    }

    public final void cm(View view) {
        if (this.mPG.mPw) {
            view.setBackgroundResource(c.bBx);
        } else {
            view.setBackgroundResource(c.bBy);
        }
    }

    public final void cn(View view) {
        if (this.mPG.mPw) {
            view.setBackgroundResource(c.bDp);
        } else {
            view.setBackgroundResource(c.bDJ);
        }
    }
}
