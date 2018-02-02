package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.n;
import com.tencent.mm.plugin.appbrand.p.b;
import com.tencent.mm.plugin.appbrand.p.d;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference extends Preference {
    private ThreeDotsLoadingView jJq;
    private int jPZ;
    private int jQa;
    private int jQb;
    private final int jQc = -1;
    private f jQp;
    private AppBrandNearbyShowcaseView jRu;
    private View jRv;
    public String jRw;
    private boolean jRx = false;
    private int jRy = -1;
    private LinkedList<d> jRz = new LinkedList();
    private Context mContext;
    private View mView = null;

    static /* synthetic */ void a(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        b.reset();
        b.a(appBrandLoadIconPreference.jRw, new 2(appBrandLoadIconPreference));
    }

    static /* synthetic */ void b(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        appBrandLoadIconPreference.jJq.ajm();
        appBrandLoadIconPreference.bL(appBrandLoadIconPreference.jJq);
        if (appBrandLoadIconPreference.jRz.size() > 0) {
            appBrandLoadIconPreference.jRu.setVisibility(0);
            appBrandLoadIconPreference.jRu.lP(Math.min(appBrandLoadIconPreference.jRz.size(), 3));
            boolean z = appBrandLoadIconPreference.jRv.getVisibility() != 0;
            if (z) {
                appBrandLoadIconPreference.jRu.ame();
            }
            if (appBrandLoadIconPreference.jQp == null) {
                appBrandLoadIconPreference.jQp = new a(appBrandLoadIconPreference.jPZ, appBrandLoadIconPreference.jQb);
            }
            int i = 0;
            while (i < appBrandLoadIconPreference.jRu.getChildCount()) {
                com.tencent.mm.modelappbrand.a.b.Jj().a(appBrandLoadIconPreference.jRu.lQ(i), appBrandLoadIconPreference.jRz.size() > i ? ((d) appBrandLoadIconPreference.jRz.get(i)).imagePath : null, a.Ji(), appBrandLoadIconPreference.jQp);
                i++;
            }
            b(appBrandLoadIconPreference.jRv, new 3(appBrandLoadIconPreference, z));
            return;
        }
        appBrandLoadIconPreference.jRu.setVisibility(8);
    }

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ch(context);
    }

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ch(context);
    }

    private void ch(Context context) {
        setLayoutResource(n.b.iMx);
        this.mContext = context;
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.jPZ = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 21);
        this.jQa = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 11);
        this.jQb = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 2);
        this.jRv = view.findViewById(n.a.iMv);
        this.jJq = (ThreeDotsLoadingView) view.findViewById(n.a.iuv);
        this.jRu = (AppBrandNearbyShowcaseView) view.findViewById(n.a.iMw);
        this.jRu.lN(this.jPZ + (this.jQb * 2));
        this.jRu.lO(this.jQa);
        if (this.jRw == null || this.jJq == null) {
            x.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
        } else if (this.jRx) {
            x.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
        } else {
            this.jRx = true;
            bL(this.jRv);
            b(this.jJq, null);
            this.jJq.cze();
            g.Dm().F(new 1(this));
        }
    }

    public static void onDestroy() {
        b.reset();
    }

    private static void b(View view, Runnable runnable) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
    }

    private void bL(View view) {
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new 4(this, view)).start();
        }
    }
}
