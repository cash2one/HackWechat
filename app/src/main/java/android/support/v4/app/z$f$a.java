package android.support.v4.app;

import android.app.PendingIntent;
import android.support.v4.app.ac.b;
import android.support.v4.app.ac.b.a;

public class z$f$a extends b {
    static final a sG = new 1();
    private final String[] sA;
    private final ah sB;
    private final PendingIntent sC;
    private final PendingIntent sD;
    private final String[] sE;
    private final long sF;

    public final /* bridge */ /* synthetic */ aj.a bk() {
        return this.sB;
    }

    public z$f$a(String[] strArr, ah ahVar, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
        this.sA = strArr;
        this.sB = ahVar;
        this.sD = pendingIntent2;
        this.sC = pendingIntent;
        this.sE = strArr2;
        this.sF = j;
    }

    public final String[] getMessages() {
        return this.sA;
    }

    public final PendingIntent getReplyPendingIntent() {
        return this.sC;
    }

    public final PendingIntent getReadPendingIntent() {
        return this.sD;
    }

    public final String[] getParticipants() {
        return this.sE;
    }

    public final long getLatestTimestamp() {
        return this.sF;
    }
}
