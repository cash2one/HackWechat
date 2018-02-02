package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.utils.V8ObjectUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

final class e extends b {
    final AtomicInteger jwc = new AtomicInteger(0);
    final HashMap<Integer, a> jwd = new HashMap();

    private final class a {
        int id;
        final /* synthetic */ e jwe;
        V8Function jwi;
        V8Array jwj;
        Timer jwk;
        boolean jwl = false;

        public a(e eVar, Timer timer, int i, V8Function v8Function, V8Array v8Array) {
            this.jwe = eVar;
            this.jwi = v8Function;
            this.jwj = v8Array;
            this.id = i;
            this.jwk = timer;
        }

        public final void dc(boolean z) {
            if (!this.jwi.isReleased()) {
                this.jwi.call(null, this.jwj);
            }
            if (z) {
                cleanup();
            }
        }

        final void cleanup() {
            this.jwe.jwd.remove(Integer.valueOf(this.id));
            this.jwi.release();
            this.jwj.release();
        }
    }

    e() {
    }

    static /* synthetic */ void a(e eVar, int i) {
        if (eVar.jwd.containsKey(Integer.valueOf(i))) {
            a aVar = (a) eVar.jwd.get(Integer.valueOf(i));
            aVar.jwk.cancel();
            aVar.cleanup();
        }
    }

    protected final void a(final f fVar, V8Object v8Object) {
        v8Object.registerJavaMethod(new JavaCallback(this) {
            final /* synthetic */ e jwe;

            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                if (v8Array.length() <= 0 || v8Array.getType(0) != 7) {
                    return null;
                }
                int i;
                V8Array toV8Array;
                V8Function v8Function = (V8Function) v8Array.getObject(0);
                if (v8Array.length() <= 1) {
                    i = 0;
                } else if (v8Array.getType(1) != 1) {
                    return null;
                } else {
                    i = v8Array.getInteger(1);
                }
                if (v8Array.length() > 2) {
                    List toList = V8ObjectUtils.toList(v8Array);
                    toV8Array = V8ObjectUtils.toV8Array(fVar.jwm, toList.subList(2, toList.size() - 1));
                } else {
                    toV8Array = new V8Array(fVar.jwm);
                }
                e eVar = this.jwe;
                f fVar = fVar;
                Timer timer = new Timer();
                Integer valueOf = Integer.valueOf(eVar.jwc.addAndGet(1));
                a aVar = new a(eVar, timer, valueOf.intValue(), v8Function, toV8Array);
                timer.schedule(new 5(eVar, fVar, aVar), (long) i);
                eVar.jwd.put(valueOf, aVar);
                return Integer.valueOf(valueOf.intValue());
            }
        }, "setTimeout");
        v8Object.registerJavaMethod(new 2(this, fVar), "setInterval");
        v8Object.registerJavaMethod(new 3(this), "clearTimeout");
        v8Object.registerJavaMethod(new 4(this), "clearInterval");
    }
}
