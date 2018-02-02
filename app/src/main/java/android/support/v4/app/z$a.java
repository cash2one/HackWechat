package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.ac$a.a;
import android.support.v4.app.z.d;

public class z$a extends ac$a {
    public static final a rT = new a() {
    };
    public PendingIntent actionIntent;
    public int icon;
    private final Bundle mExtras;
    private final ah[] rS;
    public CharSequence title;

    public final /* bridge */ /* synthetic */ aj.a[] bj() {
        return this.rS;
    }

    public z$a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this(i, charSequence, pendingIntent, new Bundle());
    }

    private z$a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        this.icon = i;
        this.title = d.d(charSequence);
        this.actionIntent = pendingIntent;
        this.mExtras = bundle;
        this.rS = null;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final PendingIntent bi() {
        return this.actionIntent;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }
}
