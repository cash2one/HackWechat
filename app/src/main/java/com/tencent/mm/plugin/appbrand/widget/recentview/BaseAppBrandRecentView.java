package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.r;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.plugin.appbrand.widget.k$b;
import com.tencent.mm.plugin.appbrand.widget.k.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.2;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAppBrandRecentView extends AppBrandRecentView implements a {
    private float YR;
    private float YS;
    protected float kfn;
    AppBrandRecentView.a kfo;
    private List<a> kfp;
    private c kfq;
    private a kfr;
    e kfs = new e();
    private float kft = 1.0f;
    private boolean kfu = false;
    private Context mContext;

    protected class b extends t {
        protected View VU;
        protected TextView ihS;
        protected ImageView jCP;
        final /* synthetic */ BaseAppBrandRecentView kfw;
        protected ImageView kfx;
        protected TextView kfy;

        public b(BaseAppBrandRecentView baseAppBrandRecentView, View view) {
            this.kfw = baseAppBrandRecentView;
            super(view);
            this.VU = view;
            view.setOnClickListener(new 1(this, baseAppBrandRecentView));
            view.setOnLongClickListener(new 2(this, baseAppBrandRecentView));
            view.getLayoutParams().width = baseAppBrandRecentView.getResources().getDisplayMetrics().widthPixels / 4;
            this.jCP = (ImageView) view.findViewById(k$b.icon);
            this.kfx = (ImageView) view.findViewById(k$b.jVf);
            this.ihS = (TextView) view.findViewById(k$b.title);
            this.kfy = (TextView) view.findViewById(k$b.jVg);
        }
    }

    protected abstract int anX();

    protected abstract String getType();

    public BaseAppBrandRecentView(Context context) {
        super(context);
        init(context);
    }

    public BaseAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    protected void init(Context context) {
        this.mContext = context;
        this.kfn = context.getResources().getDimension(k.a.buI);
        if (g.h(r.class) != null) {
            ((r) g.h(r.class)).c(this);
        } else {
            x.e("MicroMsg.BaseAppBrandRecentView", "[init] IAppBrandLocalUsageStorage get null!");
        }
        h linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        a(linearLayoutManager);
        RecyclerView.a aVar = new a(this, (byte) 0);
        this.kfr = aVar;
        a(aVar);
        RecyclerView.k kVar = this.kfs;
        kVar.Va = this;
        kVar.kfO = 4;
        kVar.Va.a(kVar);
        kVar.Vb = new e$1(kVar, kVar.Va.getContext());
        kVar.kfN = new 2(kVar, kVar.Va.getContext());
    }

    public final boolean Q(int i, int i2) {
        e eVar = this.kfs;
        int mt = eVar.mt(eVar.kfL + i);
        if (eVar.Va != null && eVar.kfR) {
            eVar.kfN.Vv = mt;
            eVar.Va.TV.a(eVar.kfN);
        }
        return super.Q(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.YR = motionEvent.getRawX();
            this.YS = motionEvent.getRawY();
        } else if (motionEvent.getAction() == 2 && this.kfu) {
            return true;
        }
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.kfu = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean canScrollHorizontally(int i) {
        return true;
    }

    public void a(AppBrandRecentView.a aVar) {
        this.kfo = aVar;
    }

    public final void refresh() {
        if (this.kfq != null) {
            e.remove(this.kfq);
        }
        Runnable cVar = new c(this, (byte) 0);
        this.kfq = cVar;
        e.post(cVar, "MicroMsg.BaseAppBrandRecentView");
    }

    public final void release() {
        if (g.h(r.class) != null) {
            ((r) g.h(r.class)).j(this);
        } else {
            x.e("MicroMsg.BaseAppBrandRecentView", "[release] IAppBrandLocalUsageStorage get null!");
        }
        if (this.kfq != null) {
            e.remove(this.kfq);
        }
        anY().clear();
    }

    public void af(List<a> list) {
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s", new Object[]{((com.tencent.mm.kernel.b.h) g.Dg().CN()).toString(), Integer.valueOf(lVar.iYZ)});
        if (lVar.iYZ == 5 && anW()) {
            x.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
        } else {
            refresh();
        }
    }

    protected boolean anW() {
        return false;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.BaseAppBrandRecentView", "[onConfigurationChanged] orientation:%s", new Object[]{Integer.valueOf(configuration.orientation)});
        if (this.kft != ((float) configuration.orientation)) {
            this.kfr.UR.notifyChanged();
        }
        this.kft = (float) configuration.orientation;
    }

    public final RecyclerView.a fm() {
        return this.kfr;
    }

    protected void a(b bVar, a aVar) {
        int width = getWidth() / 4;
        if (width <= 0) {
            width = getResources().getDisplayMetrics().widthPixels / 4;
        }
        bVar.VU.getLayoutParams().width = width;
        if (aVar.kfb != null && aVar.type == 1) {
            if (bh.ov(aVar.kfb.fpL)) {
                bVar.jCP.setImageResource(d.bBB);
                return;
            }
            bVar.kfx.setVisibility(0);
            bVar.ihS.setVisibility(0);
            bVar.ihS.setText(vi(aVar.kfb.fpL));
            com.tencent.mm.modelappbrand.a.b.Jj().a(bVar.jCP, aVar.kfb.iKm, com.tencent.mm.modelappbrand.a.a.Ji(), f.hkr);
        }
    }

    private static String vi(String str) {
        int i = 0;
        if (str != null) {
            try {
                if (com.tencent.mm.ui.tools.h.ZY(str) > 12) {
                    char[] toCharArray = str.toCharArray();
                    int length = toCharArray.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (i < length) {
                        i3 += com.tencent.mm.ui.tools.h.ZY(String.valueOf(toCharArray[i]));
                        if (i3 >= 12) {
                            str = str.substring(0, i2) + '…';
                            break;
                        }
                        i2++;
                        i++;
                    }
                }
            } catch (Exception e) {
            }
        }
        return str;
    }

    public final int getCount() {
        return anY().size();
    }

    protected final List<a> anY() {
        if (this.kfp == null) {
            this.kfp = new ArrayList();
        }
        return this.kfp;
    }
}
