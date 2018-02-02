package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.utils.V8ObjectUtils;
import com.tencent.mm.plugin.appbrand.g.a.e.6;
import com.tencent.mm.plugin.appbrand.g.a.e.a;
import java.util.List;
import java.util.Timer;

class e$2 implements JavaCallback {
    final /* synthetic */ f jwa;
    final /* synthetic */ e jwe;

    e$2(e eVar, f fVar) {
        this.jwe = eVar;
        this.jwa = fVar;
    }

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        if (v8Array.length() < 2 || v8Array.getType(0) != 7 || v8Array.getType(1) != 1) {
            return null;
        }
        V8Array toV8Array;
        V8Function v8Function = (V8Function) v8Array.getObject(0);
        int integer = v8Array.getInteger(1);
        if (v8Array.length() > 2) {
            List toList = V8ObjectUtils.toList(v8Array);
            toV8Array = V8ObjectUtils.toV8Array(this.jwa.jwm, toList.subList(2, toList.size() - 1));
        } else {
            toV8Array = new V8Array(this.jwa.jwm);
        }
        e eVar = this.jwe;
        f fVar = this.jwa;
        Timer timer = new Timer();
        Integer valueOf = Integer.valueOf(eVar.jwc.addAndGet(1));
        a aVar = new a(eVar, timer, valueOf.intValue(), v8Function, toV8Array);
        timer.scheduleAtFixedRate(new 6(eVar, fVar, aVar), (long) integer, (long) integer);
        eVar.jwd.put(valueOf, aVar);
        return Integer.valueOf(valueOf.intValue());
    }
}
