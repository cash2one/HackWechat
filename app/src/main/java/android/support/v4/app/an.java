package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

public final class an implements Iterable<Intent> {
    private static final b ts;
    public final ArrayList<Intent> tt = new ArrayList();
    public final Context tu;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    interface b {
    }

    static class c implements b {
        c() {
        }
    }

    static class d implements b {
        d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            ts = new d();
        } else {
            ts = new c();
        }
    }

    private an(Context context) {
        this.tu = context;
    }

    public static an l(Context context) {
        return new an(context);
    }

    public final an a(ComponentName componentName) {
        int size = this.tt.size();
        try {
            Intent a = v.a(this.tu, componentName);
            while (a != null) {
                this.tt.add(size, a);
                a = v.a(this.tu, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final Iterator<Intent> iterator() {
        return this.tt.iterator();
    }
}
