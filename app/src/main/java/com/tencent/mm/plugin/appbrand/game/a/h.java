package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.game.a.a.b;
import com.tencent.mm.plugin.fts.a.a.j;
import java.util.Comparator;

public final class h implements Comparator<j> {
    public static final h iXZ = new h();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        j jVar = (j) obj;
        if (f.Zv() != null) {
            b rH = f.Zv().rH(jVar.mLs);
            if (rH != null && rH.field_isSync) {
                return 1;
            }
        }
        return -1;
    }
}
