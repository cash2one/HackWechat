package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.ae.a;
import android.support.v4.app.z.d;

class z$p extends z$l {
    z$p() {
    }

    public Notification b(d dVar) {
        y aVar = new a(dVar.mContext, dVar.sx, dVar.rY, dVar.rZ, dVar.sf, dVar.sd, dVar.sg, dVar.sa, dVar.sc, dVar.se, dVar.sl, dVar.sm, dVar.sn, dVar.si, dVar.mPriority, dVar.sk, dVar.ss, dVar.mExtras, dVar.so, dVar.sp, dVar.sq);
        z.a(aVar, dVar.sr);
        z.a(aVar, dVar.sj);
        return aVar.build();
    }

    public Bundle a(Notification notification) {
        return ae.a(notification);
    }
}
