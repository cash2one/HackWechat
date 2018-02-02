package com.tencent.mm.plugin.card.a;

import android.content.IntentFilter;
import android.location.LocationManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public final class i implements e {
    public volatile float gyA = -1000.0f;
    public volatile float gyz = -85.0f;
    public volatile boolean isInit = false;
    private b kIK;
    public MMActivity kIV;
    private volatile boolean kIW = false;
    public Object kIX = new Object();
    private boolean kIY = false;
    boolean kIZ = false;
    String kIw;
    private boolean kJa = false;
    ih kJb;
    private b kJc;
    public a kJd;
    private int kJe = 60;
    private long kJf = 0;
    private long kJg = 0;
    private long kJh = 10000;
    public ak kJi = new ak(new 1(this), false);

    public final void a(MMActivity mMActivity, String str, b bVar, float f, float f2) {
        int i;
        boolean z;
        this.isInit = true;
        this.kIV = mMActivity;
        this.kIw = str;
        this.kIK = bVar;
        this.gyz = f;
        this.gyA = f2;
        this.kIY = bVar.atB().vSr;
        this.kIZ = bVar.atC().vRu;
        this.kJb = bVar.atB().vSs;
        if (bVar.atB().vSs == null) {
            i = 60;
        } else {
            i = bVar.atB().vSs.vOt;
        }
        this.kJe = i;
        if (bVar.atB().vSs == null || bh.ov(bVar.atB().vSs.name)) {
            z = false;
        } else {
            z = true;
        }
        this.kJa = z;
        x.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", new Object[]{str, Boolean.valueOf(this.kIY), Boolean.valueOf(this.kIZ), Boolean.valueOf(this.kJa), Integer.valueOf(this.kJe)});
        if (this.kIY && !this.kIZ) {
            String str2 = bh.ov(this.kIK.atB().vSt) ? this.kIK.atB().title : this.kIK.atB().vSt;
            h.a(this.kIV, this.kIV.getString(R.l.dOV, new Object[]{str2}), this.kIV.getString(R.l.dGO), new 2(this), new 3(this));
        }
        if (this.kJa) {
            x.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", new Object[]{this.kJb.name});
            this.kJd = new a(this, (byte) 0);
            a aVar = this.kJd;
            x.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
            aVar.jjH = new 2(aVar);
            ac.getContext().registerReceiver(aVar.jjH, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
        start();
        wW();
    }

    public final void start() {
        if (auf()) {
            x.i("MicroMsg.CardLbsOrBluetooth", "start");
            if (this.isInit) {
                if (this.kIY) {
                    LocationManager locationManager = (LocationManager) ac.getContext().getSystemService("location");
                    if (locationManager != null) {
                        boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                        boolean isProviderEnabled2 = locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
                        x.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", new Object[]{Boolean.valueOf(isProviderEnabled), Boolean.valueOf(isProviderEnabled2)});
                    }
                }
                if (this.kJd != null && this.kJa) {
                    this.kJd.auh();
                }
                auc();
                ar.CG().a(2574, this);
                return;
            }
            x.e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", new Object[]{Boolean.valueOf(this.isInit)});
        }
    }

    public final void auc() {
        aud();
        if (this.kJe > 0) {
            long j = (long) (this.kJe * 1000);
            this.kJi.J(j, j);
            x.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
            return;
        }
        x.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
    }

    public final void aud() {
        x.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
        if (!this.kJi.cfK()) {
            this.kJi.TG();
        }
    }

    public final void wW() {
        if (!auf()) {
            x.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
        } else if (this.kIW) {
            x.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
        } else {
            boolean z;
            boolean aue;
            b aug;
            this.kIW = true;
            if (this.kJa) {
                if (this.kJd == null) {
                    x.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
                } else if (!this.kJd.aug().ffq.equals("") && System.currentTimeMillis() - this.kJf >= this.kJh) {
                    z = true;
                    aue = aue();
                    x.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[]{Boolean.valueOf(this.kIY), Boolean.valueOf(this.kIZ), Boolean.valueOf(this.kJd.kJl), Boolean.valueOf(z), Boolean.valueOf(aue)});
                    if (!z && aue) {
                        aug = this.kJd.aug();
                        x.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", new Object[]{aug});
                        x.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", new Object[]{Float.valueOf(this.gyA), Float.valueOf(this.gyz)});
                        a(this.kIw, aug.kJr, this.gyA, this.gyz, aug.ftq, this.kJd.kJl, this.kIZ);
                        this.kJg = System.currentTimeMillis();
                        this.kJf = System.currentTimeMillis();
                        this.kJd.reset();
                        this.kJc = aug;
                        return;
                    } else if (z) {
                        aug = this.kJd.aug();
                        x.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[]{aug});
                        a(this.kIw, aug.kJr, -1000.0f, -85.0f, aug.ftq, this.kJd.kJl, this.kIZ);
                        this.kJf = System.currentTimeMillis();
                        this.kJd.reset();
                        this.kJc = aug;
                    } else if (aue) {
                        x.e("MicroMsg.CardLbsOrBluetooth", "not report");
                        this.kIW = false;
                    } else {
                        x.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
                        x.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[]{Float.valueOf(this.gyA), Float.valueOf(this.gyz)});
                        a(this.kIw, new byte[0], this.gyA, this.gyz, 0, false, this.kIZ);
                        this.kJg = System.currentTimeMillis();
                    }
                }
            }
            z = false;
            aue = aue();
            x.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", new Object[]{Boolean.valueOf(this.kIY), Boolean.valueOf(this.kIZ), Boolean.valueOf(this.kJd.kJl), Boolean.valueOf(z), Boolean.valueOf(aue)});
            if (!z) {
            }
            if (z) {
                aug = this.kJd.aug();
                x.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", new Object[]{aug});
                a(this.kIw, aug.kJr, -1000.0f, -85.0f, aug.ftq, this.kJd.kJl, this.kIZ);
                this.kJf = System.currentTimeMillis();
                this.kJd.reset();
                this.kJc = aug;
            } else if (aue) {
                x.e("MicroMsg.CardLbsOrBluetooth", "not report");
                this.kIW = false;
            } else {
                x.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
                x.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", new Object[]{Float.valueOf(this.gyA), Float.valueOf(this.gyz)});
                a(this.kIw, new byte[0], this.gyA, this.gyz, 0, false, this.kIZ);
                this.kJg = System.currentTimeMillis();
            }
        }
    }

    private boolean aue() {
        boolean z = true;
        synchronized (this.kIX) {
            boolean z2;
            if (System.currentTimeMillis() - this.kJg >= this.kJh) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z3;
            if (Float.compare(this.gyz, -85.0f) == 0 || Float.compare(this.gyA, -1000.0f) == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!(this.kIZ && this.kIY && r2 && r3)) {
                z = false;
            }
        }
        return z;
    }

    static void a(String str, byte[] bArr, float f, float f2, int i, boolean z, boolean z2) {
        ar.CG().a(new ai(str, bArr, f, f2, (float) i, z, z2), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.kIW = false;
    }

    public final boolean auf() {
        return this.kIY || this.kJa;
    }
}
