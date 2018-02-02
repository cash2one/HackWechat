package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.signin.internal.i.a;

class i$a$2 implements Runnable {
    final /* synthetic */ String baP;
    final /* synthetic */ f baQ;
    final /* synthetic */ a baR;
    final /* synthetic */ String baS;

    i$a$2(a aVar, String str, String str2, f fVar) {
        this.baR = aVar;
        this.baP = str;
        this.baS = str2;
        this.baQ = fVar;
    }

    public final void run() {
        try {
            this.baQ.au(a.a(this.baR).oe());
        } catch (RemoteException e) {
        }
    }
}
