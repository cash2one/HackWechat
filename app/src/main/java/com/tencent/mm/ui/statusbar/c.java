package com.tencent.mm.ui.statusbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public class c {
    static final boolean zga;
    @SuppressLint({"StaticFieldLeak"})
    private static final c zgf = new 2();
    private static final WeakHashMap<Activity, c> zgg = new WeakHashMap();
    private final WeakReference<Activity> zgb;
    private final Set<WeakReference<a>> zgc;
    private boolean zgd;
    int zge;

    static /* synthetic */ void b(c cVar, int i) {
        for (WeakReference weakReference : cVar.zgc) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.lA(i);
            }
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT < 21 || d.anj()) {
            z = false;
        } else {
            z = true;
        }
        zga = z;
    }

    private c(Activity activity) {
        this.zgc = new HashSet();
        this.zgd = false;
        this.zge = 0;
        this.zgb = new WeakReference(activity);
    }

    public void a(a aVar) {
        if (!this.zgd) {
            this.zgd = true;
            Activity activity = (Activity) this.zgb.get();
            if (!(activity == null || activity.getWindow() == null)) {
                try {
                    ((ViewGroup) activity.getWindow().getDecorView()).getChildAt(0).setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                        final /* synthetic */ c zgh;

                        {
                            this.zgh = r1;
                        }

                        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                            c.b(this.zgh, this.zgh.zge = windowInsets.getSystemWindowInsetTop());
                            return windowInsets.consumeSystemWindowInsets();
                        }
                    });
                } catch (Exception e) {
                    x.e("MicroMsg.StatusBarHeightWatcher", "setOnApplyWindowInsetsListener e=%s", new Object[]{e});
                }
            }
        }
        if (aVar != null) {
            this.zgc.add(new WeakReference(aVar));
            if (this.zge > 0) {
                aVar.lA(this.zge);
            }
        }
    }

    public static c ac(Activity activity) {
        if (!zga || activity == null) {
            return zgf;
        }
        c cVar = (c) zgg.get(activity);
        if (cVar != null) {
            return cVar;
        }
        cVar = new c(activity);
        zgg.put(activity, cVar);
        return cVar;
    }
}
