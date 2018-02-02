package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.booter.c;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;

public final class h extends g {
    public MMApplicationLike gSK;
    public a<ApplicationLifeCycle> gSL = new a();
    public c gyS;
    public e mProfileCompat;

    class AnonymousClass3 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ h gSM;
        final /* synthetic */ int gSN;

        public AnonymousClass3(h hVar, int i) {
            this.gSM = hVar;
            this.gSN = i;
        }

        public final /* synthetic */ void az(Object obj) {
            ((ApplicationLifeCycle) obj).onTrimMemory(this.gSN);
        }
    }

    class AnonymousClass5 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ h gSM;
        final /* synthetic */ Configuration gSO;

        public AnonymousClass5(h hVar, Configuration configuration) {
            this.gSM = hVar;
            this.gSO = configuration;
        }

        public final /* synthetic */ void az(Object obj) {
            ((ApplicationLifeCycle) obj).onConfigurationChanged(this.gSO);
        }
    }

    class AnonymousClass6 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ h gSM;
        final /* synthetic */ Context val$context;

        public AnonymousClass6(h hVar, Context context) {
            this.gSM = hVar;
            this.val$context = context;
        }

        public final /* synthetic */ void az(Object obj) {
            ((ApplicationLifeCycle) obj).onBaseContextAttached(this.val$context);
        }
    }

    public final String getPackageName() {
        return ac.getPackageName();
    }

    public h(String str, Application application, MMApplicationLike mMApplicationLike) {
        super(str, application);
        ac.Va(str);
        this.gSK = mMApplicationLike;
    }
}
