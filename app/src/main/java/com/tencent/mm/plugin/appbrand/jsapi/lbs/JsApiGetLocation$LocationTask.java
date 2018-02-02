package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class JsApiGetLocation$LocationTask extends MainProcessTask {
    public static final Creator<JsApiGetLocation$LocationTask> CREATOR = new 5();
    private double bhF;
    private double bhG;
    private double bhI;
    private j iqB;
    private int jcs;
    private int jfh = 0;
    private long jkA = 0;
    private JsApiGetLocation jko;
    private boolean jkp = false;
    private String jkq;
    private boolean jkr;
    private boolean jks;
    private float jkt;
    private float jku;
    private double jkv;
    private double jkw;
    private int jkx;
    private volatile a jky = null;
    private int jkz = 0;
    private WeakReference<p> mPageRef;

    static /* synthetic */ void a(JsApiGetLocation$LocationTask jsApiGetLocation$LocationTask) {
        c.bj(jsApiGetLocation$LocationTask);
        ag.y(new Runnable(jsApiGetLocation$LocationTask) {
            final /* synthetic */ JsApiGetLocation$LocationTask jkB;

            {
                this.jkB = r1;
            }

            public final void run() {
                JsApiGetLocation$LocationTask.b(this.jkB);
            }
        });
        jsApiGetLocation$LocationTask.jkz = 1;
        AppBrandMainProcessService.a(jsApiGetLocation$LocationTask);
    }

    static /* synthetic */ void b(JsApiGetLocation$LocationTask jsApiGetLocation$LocationTask) {
        if (jsApiGetLocation$LocationTask.mPageRef != null) {
            p pVar = (p) jsApiGetLocation$LocationTask.mPageRef.get();
            if (pVar != null) {
                jsApiGetLocation$LocationTask.jfh = com.tencent.mm.plugin.appbrand.page.a.q(pVar.irP).a(com.tencent.mm.plugin.appbrand.page.a.a.jCp);
                jsApiGetLocation$LocationTask.jkA = System.currentTimeMillis();
            }
        }
    }

    static /* synthetic */ void e(JsApiGetLocation$LocationTask jsApiGetLocation$LocationTask) {
        com.tencent.mm.modelgeo.c.OP().c(jsApiGetLocation$LocationTask.jky);
        JsApiGetLocation.agp().remove(jsApiGetLocation$LocationTask.jky);
        jsApiGetLocation$LocationTask.jky = null;
    }

    static /* synthetic */ boolean h(JsApiGetLocation$LocationTask jsApiGetLocation$LocationTask) {
        return jsApiGetLocation$LocationTask.jky != null && JsApiGetLocation.agp().contains(jsApiGetLocation$LocationTask.jky);
    }

    public final void Ys() {
        super.Ys();
        agq();
        c.bk(this);
        if (this.iqB != null) {
            if (this.jks) {
                Map hashMap = new HashMap(4);
                hashMap.put("latitude", Float.valueOf(this.jkt));
                hashMap.put("longitude", Float.valueOf(this.jku));
                hashMap.put("speed", Double.valueOf(this.bhI));
                hashMap.put("accuracy", Double.valueOf(this.bhG));
                if (this.jkr) {
                    hashMap.put("altitude", Double.valueOf(this.bhF));
                }
                if (b.ceK()) {
                    hashMap.put("provider", Integer.valueOf(this.jkx));
                }
                hashMap.put("verticalAccuracy", Double.valueOf(this.jkv));
                hashMap.put("horizontalAccuracy", Double.valueOf(this.jkw));
                this.iqB.E(this.jcs, this.jko.e("ok", hashMap));
            } else {
                this.iqB.E(this.jcs, this.jko.e("fail", null));
            }
            this.jkp = true;
        }
    }

    public final void Yr() {
        c.bj(this);
        switch (this.jkz) {
            case 1:
                this.jky = new 2(this);
                new af(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ JsApiGetLocation$LocationTask jkB;

                    {
                        this.jkB = r1;
                    }

                    public final void run() {
                        x.i("MicroMsg.JsApiGetLocation", "Timeout, callback running? %b", new Object[]{Boolean.valueOf(JsApiGetLocation$LocationTask.h(this.jkB))});
                        if (JsApiGetLocation$LocationTask.h(this.jkB)) {
                            JsApiGetLocation$LocationTask.e(this.jkB);
                            this.jkB.jks = false;
                            this.jkB.afp();
                        }
                    }
                }, 20000);
                if (this.jkq.equalsIgnoreCase("gcj02")) {
                    com.tencent.mm.modelgeo.c.OP().b(this.jky, false);
                } else if (this.jkq.equalsIgnoreCase("wgs84")) {
                    com.tencent.mm.modelgeo.c.OP().a(this.jky, false);
                }
                JsApiGetLocation.agp().add(this.jky);
                return;
            case 2:
                Iterator it = JsApiGetLocation.agp().iterator();
                while (it.hasNext()) {
                    com.tencent.mm.modelgeo.c.OP().c((a) it.next());
                }
                JsApiGetLocation.agp().clear();
                x.i("MicroMsg.JsApiGetLocation", "Stop All Location Callbacks");
                return;
            default:
                this.jks = false;
                afp();
                return;
        }
    }

    private void agq() {
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.jkA;
                if (currentTimeMillis < 3000) {
                    pVar.getContentView().postDelayed(new 4(this), 3000 - currentTimeMillis);
                    return;
                } else {
                    com.tencent.mm.plugin.appbrand.page.a.q(pVar.irP).la(this.jfh);
                    return;
                }
            }
        }
        if (this.iqB != null) {
            com.tencent.mm.plugin.appbrand.page.a.q(this.iqB.irP).la(this.jfh);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.jkq);
        parcel.writeByte(this.jkr ? (byte) 1 : (byte) 0);
        if (!this.jks) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeFloat(this.jkt);
        parcel.writeFloat(this.jku);
        parcel.writeDouble(this.bhI);
        parcel.writeDouble(this.bhG);
        parcel.writeDouble(this.bhF);
        parcel.writeDouble(this.jkv);
        parcel.writeDouble(this.jkw);
        parcel.writeInt(this.jkz);
        parcel.writeInt(this.jkx);
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        super.f(parcel);
        this.jkq = parcel.readString();
        this.jkr = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.jks = z;
        this.jkt = parcel.readFloat();
        this.jku = parcel.readFloat();
        this.bhI = parcel.readDouble();
        this.bhG = parcel.readDouble();
        this.bhF = parcel.readDouble();
        this.jkv = parcel.readDouble();
        this.jkw = parcel.readDouble();
        this.jkz = parcel.readInt();
        this.jkx = parcel.readInt();
    }

    JsApiGetLocation$LocationTask() {
    }

    JsApiGetLocation$LocationTask(Parcel parcel) {
        f(parcel);
    }
}
