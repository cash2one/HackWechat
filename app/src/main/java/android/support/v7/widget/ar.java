package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.e;
import java.lang.ref.WeakReference;

public final class ar extends Resources {
    private final WeakReference<Context> Zt;

    public static boolean hc() {
        return e.cU() && VERSION.SDK_INT <= 20;
    }

    public ar(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.Zt = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) {
        Context context = (Context) this.Zt.get();
        if (context == null) {
            return super.getDrawable(i);
        }
        h ey = h.ey();
        Drawable e = ey.e(context, i);
        if (e == null) {
            e = super.getDrawable(i);
        }
        return e != null ? ey.a(context, i, false, e) : null;
    }
}
