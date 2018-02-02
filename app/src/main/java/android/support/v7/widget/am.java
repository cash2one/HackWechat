package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.app.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class am extends ContextWrapper {
    private static final ArrayList<WeakReference<am>> Zp = new ArrayList();
    private Resources mResources;
    private final Theme mTheme;

    public static Context r(Context context) {
        Object obj = ((context instanceof am) || (context.getResources() instanceof ao) || (context.getResources() instanceof ar)) ? null : (!e.cU() || VERSION.SDK_INT <= 20) ? 1 : null;
        if (obj == null) {
            return context;
        }
        Context context2;
        int size = Zp.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) Zp.get(i);
            context2 = weakReference != null ? (am) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new am(context);
        Zp.add(new WeakReference(context2));
        return context2;
    }

    private am(Context context) {
        super(context);
        if (ar.hc()) {
            this.mTheme = getResources().newTheme();
            this.mTheme.setTo(context.getTheme());
            return;
        }
        this.mTheme = null;
    }

    public final Theme getTheme() {
        return this.mTheme == null ? super.getTheme() : this.mTheme;
    }

    public final void setTheme(int i) {
        if (this.mTheme == null) {
            super.setTheme(i);
        } else {
            this.mTheme.applyStyle(i, true);
        }
    }

    public final Resources getResources() {
        if (this.mResources == null) {
            this.mResources = this.mTheme == null ? new ao(this, super.getResources()) : new ar(this, super.getResources());
        }
        return this.mResources;
    }
}
