package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ab.a;
import android.support.v4.app.ac.b;
import android.support.v4.app.z.d;
import android.support.v4.app.z.j;

class z$k extends j {
    z$k() {
    }

    public final Notification b(d dVar) {
        y aVar = new a(dVar.mContext, dVar.sx, dVar.rY, dVar.rZ, dVar.sf, dVar.sd, dVar.sg, dVar.sa, dVar.sc, dVar.se, dVar.sl, dVar.sm, dVar.sn, dVar.sh, dVar.si, dVar.mPriority, dVar.sk, dVar.ss, dVar.st, dVar.sy, dVar.mExtras, dVar.su, dVar.sv, dVar.sw, dVar.so, dVar.sp, dVar.sq);
        z.a(aVar, dVar.sr);
        z.a(aVar, dVar.sj);
        return aVar.build();
    }

    public final Bundle a(b bVar) {
        String str = null;
        int i = 0;
        if (bVar == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (bVar.getParticipants() != null && bVar.getParticipants().length > 1) {
            str = bVar.getParticipants()[0];
        }
        Parcelable[] parcelableArr = new Parcelable[bVar.getMessages().length];
        while (i < parcelableArr.length) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("text", bVar.getMessages()[i]);
            bundle2.putString("author", str);
            parcelableArr[i] = bundle2;
            i++;
        }
        bundle.putParcelableArray("messages", parcelableArr);
        aj.a bk = bVar.bk();
        if (bk != null) {
            bundle.putParcelable("remote_input", ab.a(bk));
        }
        bundle.putParcelable("on_reply", bVar.getReplyPendingIntent());
        bundle.putParcelable("on_read", bVar.getReadPendingIntent());
        bundle.putStringArray("participants", bVar.getParticipants());
        bundle.putLong("timestamp", bVar.getLatestTimestamp());
        return bundle;
    }
}
