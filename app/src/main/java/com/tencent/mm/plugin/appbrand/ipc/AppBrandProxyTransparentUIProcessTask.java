package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AppBrandProxyTransparentUIProcessTask implements Parcelable {
    public static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> jaM = new ConcurrentHashMap();
    private static final Set<Object> jbl = new HashSet();
    public int jbm = -1;
    public a jbn = new a(this) {
        final /* synthetic */ AppBrandProxyTransparentUIProcessTask jbp;

        {
            this.jbp = r1;
        }

        public final void b(int i, int i2, Intent intent) {
            if (i == (this.jbp.hashCode() & 65535) && intent != null) {
                AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask) intent.getParcelableExtra("task_object");
                AppBrandProxyTransparentUIProcessTask rY = AppBrandProxyTransparentUIProcessTask.rY(intent.getStringExtra("task_id"));
                if (rY == null) {
                    x.e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
                    return;
                }
                AppBrandProxyTransparentUIProcessTask.a(appBrandProxyTransparentUIProcessTask, rY);
                rY.afj();
                rY.Ys();
                this.jbp.mContext = null;
            }
        }
    };
    public String jbo = (Process.myPid() + hashCode());
    public Context mContext;

    public abstract void a(Context context, a aVar);

    static /* synthetic */ void a(AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask, AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask2) {
        Parcel obtain = Parcel.obtain();
        appBrandProxyTransparentUIProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        appBrandProxyTransparentUIProcessTask2.f(obtain);
        obtain.recycle();
    }

    static /* synthetic */ AppBrandProxyTransparentUIProcessTask rY(String str) {
        if (jaM.containsKey(str)) {
            return ((WeakReference) jaM.get(str)).get() == null ? null : (AppBrandProxyTransparentUIProcessTask) ((WeakReference) jaM.get(str)).get();
        } else {
            return null;
        }
    }

    public AppBrandProxyTransparentUIProcessTask(Context context) {
        this.mContext = context;
    }

    public void Ys() {
    }

    public void f(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final void afi() {
        jbl.add(this);
    }

    public final void afj() {
        jbl.remove(this);
    }
}
