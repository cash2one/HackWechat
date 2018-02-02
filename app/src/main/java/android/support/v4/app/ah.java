package android.support.v4.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.aj.a;

public final class ah extends a {
    private static final b to;
    public static final a.a tp = new 1();
    private final Bundle mExtras;
    private final String tk;
    private final CharSequence tl;
    private final CharSequence[] tm;
    private final boolean tn;

    interface b {
        Bundle getResultsFromIntent(Intent intent);
    }

    static class c implements b {
        c() {
        }

        public final Bundle getResultsFromIntent(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    private ah(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.tk = str;
        this.tl = charSequence;
        this.tm = charSequenceArr;
        this.tn = z;
        this.mExtras = bundle;
    }

    public final String getResultKey() {
        return this.tk;
    }

    public final CharSequence getLabel() {
        return this.tl;
    }

    public final CharSequence[] getChoices() {
        return this.tm;
    }

    public final boolean getAllowFreeFormInput() {
        return this.tn;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return to.getResultsFromIntent(intent);
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            to = new c();
        } else if (VERSION.SDK_INT >= 16) {
            to = new e();
        } else {
            to = new d();
        }
    }
}
