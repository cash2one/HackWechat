package com.tencent.mm.ui.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.b.d.i;
import org.b.d.k;
import org.b.e.b;
import org.b.g.d;

@SuppressLint({"HandlerLeak"})
public final class a implements com.tencent.mm.ui.i.b.a {
    Context context = null;
    af rqY = new 1(this);
    b zpU = null;
    public i zpV = null;
    i zpW = null;
    private boolean zpX = false;
    boolean zpY = false;
    public b zpZ = null;
    public a zqa = null;

    public a() {
        i iVar;
        org.b.a.a aVar = new org.b.a.a();
        aVar.Ayk = org.b.a.a.S(org.b.a.a.c.a.class);
        String str = "XMr2y8FEVEqZBcZ1TU3gLA";
        d.go(str, "Invalid Api key");
        aVar.Ayh = str;
        str = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
        d.go(str, "Invalid Api secret");
        aVar.Ayi = str;
        str = "wechatapp://sign-in-twitter.wechatapp.com/";
        d.j(str, "Callback can't be null");
        aVar.Ayj = str;
        d.j(aVar.Ayk, "You must specify a valid api through the provider() method");
        d.go(aVar.Ayh, "You must provide an api key");
        d.go(aVar.Ayi, "You must provide an api secret");
        this.zpU = aVar.Ayk.a(new org.b.d.a(aVar.Ayh, aVar.Ayi, aVar.Ayj, aVar.Ayl, aVar.scope, aVar.Aym));
        if (g.Dh().Cy()) {
            str = (String) g.Dj().CU().get(69377, null);
            String str2 = (String) g.Dj().CU().get(69378, null);
            iVar = (bh.ov(str) || bh.ov(str2)) ? null : new i(str, str2);
        } else {
            x.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
            iVar = null;
        }
        this.zpV = iVar;
    }

    public final void a(b bVar, Context context) {
        if (!this.zpX) {
            com.tencent.mm.plugin.report.service.g.pQN.a(583, 0, 1, false);
            this.zpZ = bVar;
            this.context = context;
            this.zpX = true;
            e.post(new Runnable(this) {
                final /* synthetic */ a zqb;

                {
                    this.zqb = r1;
                }

                public final void run() {
                    Object b;
                    try {
                        this.zqb.zpW = this.zqb.zpU.cKm();
                        b = this.zqb.zpU.b(this.zqb.zpW);
                    } catch (org.b.b.a e) {
                        b = null;
                    }
                    this.zqb.rqY.sendMessage(this.zqb.rqY.obtainMessage(1000, b));
                }
            }, "Twitter_doOAuth");
        }
    }

    public final boolean cyv() {
        return this.zpV != null;
    }

    public final void a(a aVar) {
        if (!this.zpY) {
            this.zqa = aVar;
            this.zpY = true;
            e.post(new 3(this), "Twitter_validationAccessToken");
        }
    }

    static void a(i iVar) {
        ac.getContext().getSharedPreferences(ac.cfs(), 0);
        if (iVar == null) {
            g.Dj().CU().set(69377, "");
            g.Dj().CU().set(69378, "");
            return;
        }
        g.Dj().CU().set(69377, iVar.token);
        g.Dj().CU().set(69378, iVar.wyk);
    }

    final void c(c cVar) {
        this.zpX = false;
        this.zpW = null;
        if (this.zpZ != null) {
            this.zpZ.a(cVar);
        }
    }

    public final void k(final Bundle bundle) {
        g.Dm().F(new Runnable(this) {
            final /* synthetic */ a zqb;

            public final void run() {
                i iVar = null;
                if (this.zqb.zpW != null) {
                    a.nx(true);
                    String string = bundle.getString("oauth_verifier");
                    if (string != null) {
                        try {
                            iVar = this.zqb.zpU.a(this.zqb.zpW, new k(string));
                        } catch (org.b.b.a e) {
                        }
                    }
                    if (iVar != null) {
                        this.zqb.zpV = iVar;
                        a.a(this.zqb.zpV);
                        new af(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 zqd;

                            {
                                this.zqd = r1;
                            }

                            public final void run() {
                                this.zqd.zqb.c(c.zqe);
                                com.tencent.mm.plugin.report.service.g.pQN.a(583, 1, 1, false);
                            }
                        });
                        return;
                    }
                    new af(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 zqd;

                        {
                            this.zqd = r1;
                        }

                        public final void run() {
                            this.zqd.zqb.c(c.zqf);
                            com.tencent.mm.plugin.report.service.g.pQN.a(583, 4, 1, false);
                        }
                    });
                }
            }

            public final String toString() {
                return super.toString() + "|onComplete";
            }
        });
    }

    public final void cyw() {
        nx(false);
        c(c.zqf);
        com.tencent.mm.plugin.report.service.g.pQN.a(583, 2, 1, false);
    }

    public final void onCancel() {
        nx(false);
        c(c.zqg);
        com.tencent.mm.plugin.report.service.g.pQN.a(583, 3, 1, false);
    }

    static void nx(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.ay.i.a(10251, z ? "1" : "2"));
        ((h) g.h(h.class)).EX().b(new com.tencent.mm.ay.i(arrayList));
    }
}
