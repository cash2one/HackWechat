package com.tencent.liteav.screencapture;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection.Callback;
import android.media.projection.MediaProjectionManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.basic.c.a;
import com.tencent.rtmp.video.TXScreenCapture$TXScreenCaptureAssistantActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@TargetApi(21)
public class b {
    private static final String b = b.class.getSimpleName();
    private static b c = new b();
    Callback a;
    private HashMap<Surface, VirtualDisplay> d;
    private Context e;
    private MediaProjectionManager f;
    private MediaProjection g;
    private HashSet<a> h;
    private int i;
    private Handler j;
    private HashSet<Object> k;
    private boolean l;
    private WeakReference<a> m;
    private BroadcastReceiver n;

    private b() {
        this.d = new HashMap();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = new HashSet();
        this.i = 1;
        this.j = null;
        this.k = new HashSet();
        this.l = false;
        this.m = null;
        this.a = new 1(this);
        this.n = new 4(this);
        this.j = new Handler(Looper.getMainLooper());
    }

    public static b a() {
        return c;
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.m = null;
        } else {
            this.m = new WeakReference(aVar);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(Context context) {
        synchronized (this) {
            if (this.e != context) {
                b();
                this.f = null;
                this.e = context;
                if (this.e == null) {
                } else if (this.f == null) {
                    this.f = (MediaProjectionManager) this.e.getSystemService("media_projection");
                }
            }
        }
    }

    @TargetApi(21)
    public boolean a(Surface surface, int i, int i2) {
        synchronized (this) {
            try {
                if (this.i != 3 && this.i != 4) {
                    a aVar = new a(this, null);
                    aVar.c = i2;
                    aVar.b = i;
                    aVar.a = surface;
                    this.h.add(aVar);
                    boolean e = e();
                    return e;
                } else if (this.g == null) {
                    return false;
                } else {
                    this.l = true;
                    VirtualDisplay createVirtualDisplay = this.g.createVirtualDisplay("TXCScreenCapture", i, i2, 1, 1, surface, null, null);
                    if (createVirtualDisplay == null) {
                        return false;
                    }
                    this.i = 3;
                    this.d.put(surface, createVirtualDisplay);
                    return true;
                }
            } catch (Exception e2) {
                return false;
            }
        }
    }

    public void a(Surface surface) {
        synchronized (this) {
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null && aVar.a != null && aVar.b != 0 && aVar.c != 0 && aVar.a == surface) {
                    this.h.remove(aVar);
                    break;
                }
            }
            if (this.d.containsKey(surface)) {
                ((VirtualDisplay) this.d.get(surface)).release();
                this.d.remove(surface);
                c();
                return;
            }
        }
    }

    public void b() {
        synchronized (this) {
            d();
        }
    }

    private void c() {
        this.i = 4;
        this.j.postDelayed(new 2(this), 1000);
    }

    private void d() {
        for (VirtualDisplay virtualDisplay : this.d.values()) {
            if (virtualDisplay != null) {
                virtualDisplay.release();
            }
        }
        this.d.clear();
        this.k.clear();
        f();
    }

    @TargetApi(21)
    private boolean e() {
        if (this.i != 1) {
            return true;
        }
        if (this.e == null || this.f == null) {
            return false;
        }
        this.i = 2;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("TXScreenCapture.OnAssistantActivityResult");
        this.e.registerReceiver(this.n, intentFilter);
        Intent intent = new Intent(this.e, TXScreenCapture$TXScreenCaptureAssistantActivity.class);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("TXScreenCapture.ScreenCaptureIntent", this.f.createScreenCaptureIntent());
        this.e.startActivity(intent);
        return true;
    }

    @TargetApi(21)
    private void f() {
        if (this.k.isEmpty()) {
            this.l = false;
            if (this.g != null) {
                this.g.stop();
                this.g.unregisterCallback(this.a);
            }
            try {
                if (this.e != null) {
                    this.e.unregisterReceiver(this.n);
                }
            } catch (Exception e) {
            }
            this.g = null;
            this.i = 1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(21)
    private void a(int i, int i2, Intent intent) {
        try {
            synchronized (this) {
                try {
                    if (this.e != null) {
                        this.e.unregisterReceiver(this.n);
                    }
                } catch (Exception e) {
                }
                if (i != 1001) {
                } else if (i2 != -1) {
                } else if (this.i != 2) {
                } else {
                    this.g = this.f.getMediaProjection(i2, intent);
                    this.g.registerCallback(this.a, this.j);
                    this.l = true;
                    if (this.h.size() == 0) {
                        return;
                    }
                    Iterator it = this.h.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        if (!(aVar == null || aVar.a == null || aVar.b == 0 || aVar.c == 0)) {
                            VirtualDisplay createVirtualDisplay = this.g.createVirtualDisplay("TXCScreenCapture", aVar.b, aVar.c, 1, 1, aVar.a, null, null);
                            if (createVirtualDisplay == null) {
                                return;
                            }
                            this.d.put(aVar.a, createVirtualDisplay);
                        }
                    }
                    this.h.clear();
                    this.i = 3;
                }
            }
        } catch (Exception e2) {
        }
    }
}
