package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class d {
    private static d bbD;
    final ad bbA;
    final ConcurrentMap<am, Boolean> bbB;
    private final an bbC;
    private final a bby;
    private final c bbz;
    private final Context mContext;

    private d(Context context, a aVar, c cVar, ad adVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.bbA = adVar;
        this.bby = aVar;
        this.bbB = new ConcurrentHashMap();
        this.bbz = cVar;
        this.bbz.a(new 1(this));
        this.bbz.a(new ag(this.mContext));
        this.bbC = new an();
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new 3(this));
        }
    }

    public static d T(Context context) {
        d dVar;
        synchronized (d.class) {
            if (bbD == null) {
                if (context == null) {
                    m.qC();
                    throw new NullPointerException();
                }
                bbD = new d(context, new 2(), new c(new ap(context)), ae.rb());
            }
            dVar = bbD;
        }
        return dVar;
    }

    static /* synthetic */ void a(d dVar, String str) {
        for (am bg : dVar.bbB.keySet()) {
            bg.bg(str);
        }
    }

    final synchronized boolean e(Uri uri) {
        boolean z;
        w qX = w.qX();
        if (qX.e(uri)) {
            String str = qX.bbk;
            switch (4.bbF[qX.bbO - 1]) {
                case 1:
                    for (am amVar : this.bbB.keySet()) {
                        if (amVar.rf().equals(str)) {
                            amVar.rg();
                            amVar.refresh();
                        }
                    }
                    break;
                case 2:
                case 3:
                    for (am amVar2 : this.bbB.keySet()) {
                        String str2;
                        if (amVar2.rf().equals(str)) {
                            str2 = qX.bbP;
                            amVar2.rg();
                            amVar2.refresh();
                        } else {
                            if (amVar2.bcU) {
                                m.qC();
                                str2 = "";
                            } else {
                                str2 = amVar2.bcT.rh();
                            }
                            if (str2 != null) {
                                amVar2.rg();
                                amVar2.refresh();
                            }
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
