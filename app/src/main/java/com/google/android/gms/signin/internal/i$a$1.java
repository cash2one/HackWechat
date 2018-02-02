package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.c$d$a;
import com.google.android.gms.common.api.c.d;
import com.google.android.gms.signin.internal.i.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class i$a$1 implements Runnable {
    final /* synthetic */ List baO;
    final /* synthetic */ String baP;
    final /* synthetic */ f baQ;
    final /* synthetic */ a baR;

    i$a$1(a aVar, List list, String str, f fVar) {
        this.baR = aVar;
        this.baO = list;
        this.baP = str;
        this.baQ = fVar;
    }

    public final void run() {
        try {
            d a = a.a(this.baR);
            Collections.unmodifiableSet(new HashSet(this.baO));
            c$d$a od = a.od();
            this.baQ.a(new CheckServerAuthResult(od.aKn, od.aKo));
        } catch (RemoteException e) {
        }
    }
}
