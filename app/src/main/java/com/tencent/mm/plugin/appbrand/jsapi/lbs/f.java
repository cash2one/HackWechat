package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.appbrand.b.b.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q.b.a.b;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;

final class f extends d implements a {
    final j jcM;
    final b jkD;
    int jkE = 0;
    final c jkF = new c(this) {
        final /* synthetic */ f jkI;

        {
            this.jkI = r1;
        }

        public final String getName() {
            return this.jkI.mName + "$StateNotListening";
        }

        public final boolean j(Message message) {
            if (1 != message.what) {
                return super.j(message);
            }
            this.jkI.b(this.jkI.jkG);
            return true;
        }

        public final void enter() {
            super.enter();
            b.alN().b(this.jkI.jkD);
            com.tencent.mm.plugin.appbrand.page.a.q(this.jkI.jcM.irP).la(this.jkI.jkE);
        }
    };
    final c jkG = new c(this) {
        final /* synthetic */ f jkI;

        {
            this.jkI = r1;
        }

        public final String getName() {
            return this.jkI.mName + "$StateListening";
        }

        public final void enter() {
            super.enter();
            b.alN().a(this.jkI.jkD);
            this.jkI.jkE = com.tencent.mm.plugin.appbrand.page.a.q(this.jkI.jcM.irP).a(com.tencent.mm.plugin.appbrand.page.a.a.jCp);
        }

        public final void exit() {
            super.exit();
            b.alN().b(this.jkI.jkD);
        }

        public final boolean j(Message message) {
            if (2 == message.what) {
                this.jkI.b(this.jkI.jkF);
                return true;
            } else if (3 != message.what) {
                return super.j(message);
            } else {
                this.jkI.b(this.jkI.jkH);
                return true;
            }
        }
    };
    final c jkH = new c(this) {
        final /* synthetic */ f jkI;

        {
            this.jkI = r1;
        }

        public final String getName() {
            return this.jkI.mName + "$StateListeningButSuspend";
        }

        public final boolean j(Message message) {
            if (2 == message.what) {
                this.jkI.b(this.jkI.jkF);
                return true;
            } else if (4 != message.what) {
                return super.j(message);
            } else {
                this.jkI.b(this.jkI.jkG);
                return true;
            }
        }
    };

    f(j jVar) {
        super("AppBrand$RuntimeLocationUpdateStateManager[" + jVar.mAppId + "]", Looper.getMainLooper());
        this.jcM = jVar;
        this.jkD = new b(jVar);
        jVar.irP.iqO.a(this);
        a(this.jkF);
        a(this.jkG);
        a(this.jkH);
        b(this.jkF);
    }

    public final void a(com.tencent.mm.plugin.appbrand.b.a aVar) {
        if (aVar == com.tencent.mm.plugin.appbrand.b.a.iGT) {
            quit();
        } else if (aVar == com.tencent.mm.plugin.appbrand.b.a.iGS) {
            Dh(3);
        } else if (aVar == com.tencent.mm.plugin.appbrand.b.a.iGQ) {
            Dh(4);
        }
    }
}
