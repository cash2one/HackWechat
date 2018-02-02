package com.tencent.mm.aq.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.aq.a.c.a;
import com.tencent.mm.aq.a.c.e;
import com.tencent.mm.aq.a.c.f;
import com.tencent.mm.aq.a.c.h;
import com.tencent.mm.aq.a.c.j;
import com.tencent.mm.aq.a.c.k;
import com.tencent.mm.aq.a.c.m;
import java.util.concurrent.Executor;

public final class b {
    public static final int hDj = Runtime.getRuntime().availableProcessors();
    public final Resources hDk;
    public final int hDl;
    public final int hDm;
    public final c hDn;
    public final m hDo;
    public final a hDp;
    public final com.tencent.mm.aq.a.c.b hDq;
    public final f hDr;
    public final j hDs;
    public final k hDt;
    public final e hDu;
    public final h hDv;
    public final Executor hDw;
    public final String packageName;

    public b(a aVar) {
        this.packageName = aVar.context.getPackageName();
        this.hDk = aVar.context.getResources();
        this.hDl = aVar.hDl;
        this.hDm = aVar.hDm;
        this.hDn = aVar.hDn;
        this.hDo = aVar.hDo;
        this.hDp = aVar.hDp;
        this.hDq = aVar.hDq;
        this.hDr = aVar.hDr;
        this.hDs = aVar.hDs;
        this.hDv = aVar.hDv;
        this.hDw = aVar.hDw;
        this.hDt = aVar.hDx;
        this.hDu = aVar.hDu;
    }

    public static b bl(Context context) {
        return new a(context).PJ();
    }
}
