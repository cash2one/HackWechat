package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

final class e extends b {
    private static final Map<String, e> jzc = new ConcurrentHashMap();
    private final String jzd;
    private final String jze;

    private static final class a extends ak {

        class AnonymousClass1 implements com.tencent.mm.sdk.platformtools.ak.a {
            final /* synthetic */ String jzf;

            AnonymousClass1(String str) {
                this.jzf = str;
            }

            public final boolean uF() {
                e.tc(this.jzf);
                return false;
            }
        }

        a(String str) {
            super(Looper.getMainLooper(), new AnonymousClass1(str), false);
        }
    }

    static e tc(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return (e) jzc.remove(str);
    }

    e(Context context, String str) {
        this.jzd = str;
        this.jze = context.getClass().getName();
        jzc.put(str, this);
        ak aVar = new a(str);
        long toMillis = TimeUnit.SECONDS.toMillis(300);
        aVar.J(toMillis, toMillis);
    }

    protected final String aih() {
        return this.jze;
    }
}
