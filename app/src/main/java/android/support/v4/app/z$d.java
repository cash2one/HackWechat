package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.z.a;
import android.support.v4.app.z.e;
import android.support.v4.app.z.i;
import android.support.v4.app.z.r;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class z$d {
    public Context mContext;
    Bundle mExtras;
    int mPriority;
    public CharSequence rY;
    public CharSequence rZ;
    public PendingIntent sa;
    PendingIntent sc;
    RemoteViews sd;
    public Bitmap se;
    public CharSequence sf;
    public int sg;
    boolean sh = true;
    public boolean si;
    public r sj;
    public CharSequence sk;
    int sl;
    int sm;
    boolean sn;
    String so;
    boolean sp;
    String sq;
    public ArrayList<a> sr = new ArrayList();
    public boolean ss = false;
    public String st;
    int su = 0;
    int sv = 0;
    Notification sw;
    public Notification sx = new Notification();
    public ArrayList<String> sy;

    public z$d(Context context) {
        this.mContext = context;
        this.sx.when = System.currentTimeMillis();
        this.sx.audioStreamType = -1;
        this.mPriority = 0;
        this.sy = new ArrayList();
    }

    public final z$d c(long j) {
        this.sx.when = j;
        return this;
    }

    public final z$d U(int i) {
        this.sx.icon = i;
        return this;
    }

    public final z$d a(CharSequence charSequence) {
        this.rY = d(charSequence);
        return this;
    }

    public final z$d b(CharSequence charSequence) {
        this.rZ = d(charSequence);
        return this;
    }

    public final z$d a(int i, int i2, boolean z) {
        this.sl = i;
        this.sm = i2;
        this.sn = z;
        return this;
    }

    public final z$d c(CharSequence charSequence) {
        this.sx.tickerText = d(charSequence);
        return this;
    }

    public final z$d n(boolean z) {
        c(16, z);
        return this;
    }

    public final void c(int i, boolean z) {
        if (z) {
            Notification notification = this.sx;
            notification.flags |= i;
            return;
        }
        notification = this.sx;
        notification.flags &= i ^ -1;
    }

    public final z$d a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this.sr.add(new a(i, charSequence, pendingIntent));
        return this;
    }

    @Deprecated
    public final Notification getNotification() {
        return build();
    }

    public final Notification build() {
        i bh = z.bh();
        e eVar = new e();
        return bh.b(this);
    }

    protected static CharSequence d(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }
}
