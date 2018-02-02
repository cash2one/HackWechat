package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.dynamic.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.a.2;
import com.tencent.mm.plugin.appbrand.dynamic.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import org.json.JSONArray;

public class IPCDynamicPageView extends LinearLayout implements j, a, h {
    public static af iRH;
    private static LayoutParams iVt = new LayoutParams(-1, -1);
    public String gOP;
    private long iKI;
    private g iRM;
    private Bundle iVl;
    private com.tencent.mm.plugin.appbrand.dynamic.a iVm;
    public q iVn;
    public volatile boolean iVo;
    public long iVp;
    private a iVq;
    private Runnable iVr = new 1(this);
    private Runnable iVs = new Runnable(this) {
        final /* synthetic */ IPCDynamicPageView iVu;

        {
            this.iVu = r1;
        }

        public final void run() {
            String e = this.iVu.gOP;
            if (bh.ov(e)) {
                x.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
                return;
            }
            this.iVu.mDetached = true;
            com.tencent.mm.plugin.appbrand.dynamic.a f = this.iVu.iVm;
            if (e == null || e.length() == 0) {
                x.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[]{Integer.valueOf(f.hashCode())});
            } else {
                x.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[]{Integer.valueOf(f.hashCode()), e});
                Bundle bundle = new Bundle();
                bundle.putString(SlookAirButtonFrequentContactAdapter.ID, e);
                f.a("com.tencent.mm:support", bundle, b.class, new 2(f, e));
            }
            e acF = e.acF();
            if (bh.ov(e)) {
                x.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
            } else {
                WeakReference weakReference = (WeakReference) acF.iRZ.remove(e);
                if (weakReference != null) {
                    weakReference.get();
                }
            }
            this.iVu.cleanup();
            this.iVu.iRM = null;
            this.iVu.gOP = null;
            this.iVu.iVn = null;
            this.iVu.iVo = false;
            this.iVu.iVq.abl();
        }
    };
    private volatile boolean mDetached;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String fgU;
        final /* synthetic */ Bundle iRz;
        final /* synthetic */ IPCDynamicPageView iVu;
        final /* synthetic */ q iVv;
        final /* synthetic */ String uR;

        public AnonymousClass3(IPCDynamicPageView iPCDynamicPageView, String str, Bundle bundle, q qVar, String str2) {
            this.iVu = iPCDynamicPageView;
            this.uR = str;
            this.iRz = bundle;
            this.iVv = qVar;
            this.fgU = str2;
        }

        public final void run() {
            if (!(this.iVu.gOP == null || this.uR.equals(this.iVu.gOP))) {
                this.iVu.detach();
            }
            this.iVu.gOP = this.uR;
            this.iVu.iVl = this.iRz;
            this.iVu.iVn = new r(this.iVv);
            com.tencent.mm.plugin.appbrand.dynamic.a f = this.iVu.iVm;
            String str = this.uR;
            String str2 = this.fgU;
            Bundle bundle = this.iRz;
            f.gOP = str;
            String str3 = "Token#" + System.nanoTime();
            f.iRw = str3;
            Bundle bundle2 = new Bundle();
            bundle2.putString(SlookAirButtonFrequentContactAdapter.ID, str);
            bundle2.putString("appId", str2);
            if (bundle != null) {
                bundle2.putInt("scene", bundle.getInt("scene"));
                bundle2.putInt("widgetType", bundle.getInt("widget_type"));
                bundle2.putInt("serviceType", bundle.getInt("service_type"));
                bundle2.putInt("wxaPkgType", bundle.getInt("msg_pkg_type"));
                bundle2.putString("searchId", bundle.getString("search_id", ""));
                bundle2.putInt("pkgVersion", bundle.getInt("pkg_version"));
                bundle2.putString("preloadLaunchData", bundle.getString("preload_launch_data", ""));
            }
            f.a("com.tencent.mm:support", bundle2, c.class, new 1(f, str3, str, str2, bundle));
            this.iVu.mDetached = false;
        }
    }

    static /* synthetic */ Bundle b(IPCDynamicPageView iPCDynamicPageView, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("__page_view_id", iPCDynamicPageView.gOP);
        bundle2.putString("__process_name", ac.Br());
        int measuredWidth = iPCDynamicPageView.getMeasuredWidth();
        int measuredHeight = iPCDynamicPageView.getMeasuredHeight();
        if ((measuredWidth == 0 || measuredHeight == 0) && bundle != null) {
            measuredWidth = bundle.getInt("view_init_width");
            measuredHeight = bundle.getInt("view_init_height");
        }
        bundle2.putInt("__page_view_width", measuredWidth);
        bundle2.putInt("__page_view_height", measuredHeight);
        if (!(iPCDynamicPageView.iRM == null || iPCDynamicPageView.iRM.field_appId == null)) {
            bundle2.putString("__page_app_id", iPCDynamicPageView.iRM.field_appId);
        }
        return bundle2;
    }

    static {
        HandlerThread Wf = com.tencent.mm.sdk.f.e.Wf("WxaWidget#UIActionThread");
        Wf.start();
        iRH = new af(Wf.getLooper());
    }

    public IPCDynamicPageView(Context context) {
        super(context);
        init(context);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.iVm = new com.tencent.mm.plugin.appbrand.dynamic.a(this);
        View be = c.be(context);
        addView(be, iVt);
        this.iVq = (a) be;
    }

    public final void d(String str, String str2, Bundle bundle) {
        iRH.post(new 4(this, bundle, str, str2));
    }

    public final void detach() {
        if (Looper.myLooper() == iRH.getLooper()) {
            this.iVs.run();
        } else {
            iRH.post(this.iVs);
        }
    }

    public final void cleanup() {
        if (this.iRM != null) {
            x.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", new Object[]{this.gOP, this.iRM.field_id, this.iRM.field_appId, this.iRM.field_cacheKey});
        } else {
            x.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", new Object[]{this.gOP});
        }
        abi();
    }

    public final void jT(int i) {
        jY(i);
        detach();
    }

    public final void b(String str, p pVar) {
        if (this.iVn == null) {
            pVar.b(false, "listener is null", null);
            return;
        }
        s sVar = (s) this.iVn.iy(ai.NAME);
        if (sVar == null) {
            pVar.b(false, "listener is null", null);
        } else {
            sVar.iz(str);
        }
    }

    public final void c(String str, p pVar) {
        if (this.iVn == null) {
            pVar.b(false, "listener is null", null);
            return;
        }
        w wVar = (w) this.iVn.iy("onSearchWAWidgetReloadData");
        if (wVar == null) {
            pVar.b(false, "listener is null", null);
        } else {
            wVar.iB(str);
        }
    }

    public final void a(String str, p pVar) {
        if (this.iVn == null) {
            pVar.b(false, "listener is null", null);
            return;
        }
        v vVar = (v) this.iVn.iy("openApp");
        if (vVar == null) {
            pVar.b(false, "listener is null", null);
        } else {
            vVar.iA(str);
        }
    }

    public final void a(boolean z, String str, boolean z2, p pVar) {
        if (this.iVn == null) {
            pVar.b(false, "listener is null", null);
            return;
        }
        u uVar = (u) this.iVn.iy("OnTapCallback");
        if (uVar == null) {
            pVar.b(false, "listener is null", null);
        } else {
            uVar.b(z, str, z2);
        }
    }

    public final void b(int i, p pVar) {
        if (this.iVn == null) {
            pVar.b(false, "listener is null", null);
            return;
        }
        com.tencent.mm.modelappbrand.x xVar = (com.tencent.mm.modelappbrand.x) this.iVn.iy("setWidgetSize");
        if (xVar == null) {
            pVar.b(false, "listener is null", null);
        } else {
            xVar.a(i, pVar);
        }
    }

    public final boolean d(Canvas canvas) {
        return this.iVq.d(canvas);
    }

    public final void abh() {
        long currentTimeMillis = System.currentTimeMillis() - this.iKI;
        iRH.removeCallbacks(this.iVr);
        if (currentTimeMillis < 12) {
            iRH.postDelayed(this.iVr, currentTimeMillis);
        } else {
            this.iVr.run();
        }
    }

    public final void a(JSONArray jSONArray, a.a aVar) {
        this.iVq.a(jSONArray, aVar);
    }

    public final void b(JSONArray jSONArray, a.a aVar) {
        this.iVq.b(jSONArray, aVar);
    }

    public final void abi() {
        this.iVq.abi();
    }

    public final void qe(String str) {
        this.iVq.qe(str);
    }

    public final int getType() {
        return this.iVq.getType();
    }

    public final void l(Runnable runnable) {
        this.iVq.l(runnable);
    }

    public final void onPause() {
        x.v("MicroMsg.IPCDynamicPageView", "onPause(%s)", new Object[]{this.gOP});
        this.iVq.onPause();
        iRH.post(new Runnable(this) {
            final /* synthetic */ IPCDynamicPageView iVu;

            {
                this.iVu = r1;
            }

            public final void run() {
                this.iVu.iVm;
                String e = this.iVu.gOP;
                Bundle bundle = new Bundle();
                bundle.putString(SlookAirButtonFrequentContactAdapter.ID, e);
                f.a("com.tencent.mm:support", bundle, a$d.class, null);
            }
        });
    }

    public final void onResume() {
        x.v("MicroMsg.IPCDynamicPageView", "onResume(%s)", new Object[]{this.gOP});
        this.iVq.onResume();
        iRH.post(new 6(this));
    }

    public final boolean isPaused() {
        return this.iVq.isPaused();
    }

    public final void qf(String str) {
        this.iVq.qf(str);
    }

    public final int abj() {
        return this.iVq.abj();
    }

    public final int abk() {
        return this.iVq.abk();
    }

    public final void setStartTime(long j) {
        this.iVq.setStartTime(j);
    }

    public final void abl() {
        this.iVq.abl();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        x.i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        Bundle bundle = new Bundle();
        bundle.putInt("__page_view_width", i);
        bundle.putInt("__page_view_height", i2);
        String str = this.gOP;
        Bundle bundle2 = new Bundle();
        bundle2.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle2.putBundle("__env_args", bundle);
        f.a("com.tencent.mm:support", bundle2, a$g.class, null);
    }

    private void jY(int i) {
        if (this.iVn == null) {
            x.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", new Object[]{this.gOP, Integer.valueOf(i)});
            return;
        }
        com.tencent.mm.modelappbrand.f Jg = this.iVn.Jg();
        if (Jg == null) {
            x.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", new Object[]{this.gOP, Integer.valueOf(i)});
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            Jg.q(this, i);
        } else {
            com.tencent.mm.plugin.appbrand.dynamic.b.n(new 7(this, Jg, i));
        }
    }

    public final boolean X(String str, String str2) {
        com.tencent.mm.plugin.appbrand.dynamic.a aVar = this.iVm;
        String str3 = this.gOP;
        if (aVar.gOP == null || aVar.gOP.length() == 0 || str == null || str.length() == 0) {
            return false;
        }
        Parcelable bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str3);
        bundle.putString("event", str);
        bundle.putString(SlookAirButtonFrequentContactAdapter.DATA, str2);
        IPCBoolean iPCBoolean = (IPCBoolean) f.a("com.tencent.mm:support", bundle, com.tencent.mm.plugin.appbrand.dynamic.a.f.class);
        return iPCBoolean != null ? iPCBoolean.value : false;
    }

    public final void jZ(int i) {
        com.tencent.mm.plugin.appbrand.dynamic.a aVar = this.iVm;
        String str = this.gOP;
        if (aVar.gOP != null && aVar.gOP.length() != 0) {
            Bundle bundle = new Bundle();
            bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
            bundle.putInt("widgetState", i);
            f.a("com.tencent.mm:support", bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
        }
    }
}
