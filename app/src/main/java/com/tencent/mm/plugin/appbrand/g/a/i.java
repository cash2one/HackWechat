package com.tencent.mm.plugin.appbrand.g.a;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.g.a.f.4;
import com.tencent.mm.plugin.appbrand.g.a.f.5;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i {
    j isd;
    private final AtomicInteger jwB = new AtomicInteger(0);
    public final HashMap<Integer, f> jwC = new HashMap();
    private a jwD = new 4(this);

    public i(j jVar) {
        this.isd = jVar;
    }

    public final int a(Pair<String, String>... pairArr) {
        int addAndGet = this.jwB.addAndGet(1);
        f fVar = new f(this.jwD);
        fVar.jwo.p(new 5(fVar, new 2(this, addAndGet), "postMessage"));
        fVar.jwo.jwz = new 1(this, fVar);
        for (int i = 0; i < 5; i++) {
            Pair pair = pairArr[i];
            if (!(pair == null || pair.second == null || ((String) pair.second).length() == 0)) {
                String str = (String) pair.first;
                fVar.jwo.p(new 4(fVar, null, (String) pair.second, str));
            }
        }
        this.jwC.put(Integer.valueOf(addAndGet), fVar);
        return addAndGet;
    }
}
