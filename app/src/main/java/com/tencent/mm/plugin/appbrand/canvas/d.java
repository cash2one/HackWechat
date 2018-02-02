package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import android.graphics.Paint.Style;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d implements a {
    a iKA;
    public volatile String iKB;
    public volatile boolean iKC;
    private Runnable iKD = new 1(this);
    private Runnable iKE = new 2(this);
    public volatile long iKF;
    protected long iKG;
    protected long iKH;
    protected volatile long iKI;
    volatile boolean iKw;
    JSONArray iKx;
    public f iKy;
    private e iKz;
    protected int mCount;

    public d(a aVar) {
        this.iKA = aVar;
        this.iKy = new f(new a(aVar));
        this.iKz = new e();
    }

    public final boolean d(Canvas canvas) {
        this.iKw = false;
        if (this.iKx == null || this.iKx.length() == 0) {
            return false;
        }
        long nanoTime;
        long j = this.iKF;
        long nanoTime2 = System.nanoTime();
        String str = this.iKB;
        if (j != 0) {
            c.aR(str, "before_draw_actions");
        }
        f fVar = this.iKy;
        fVar.iKQ.clear();
        fVar.iKR.clear();
        fVar.iKO.reset();
        fVar.iKP.reset();
        fVar.iKO.setStyle(Style.STROKE);
        fVar.iKP.setStyle(Style.FILL);
        fVar.iKO.setAntiAlias(true);
        fVar.iKP.setAntiAlias(true);
        fVar.iKO.setStrokeWidth((float) f.lI(1));
        fVar.iKP.setStrokeWidth((float) f.lI(1));
        for (int i = 0; i < this.iKx.length(); i++) {
            JSONObject optJSONObject = this.iKx.optJSONObject(i);
            if (optJSONObject != null) {
                try {
                    e eVar = this.iKz;
                    f fVar2 = this.iKy;
                    String optString = optJSONObject.optString("method");
                    JSONArray optJSONArray = optJSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                    com.tencent.mm.plugin.appbrand.canvas.a.d dVar = (com.tencent.mm.plugin.appbrand.canvas.a.d) eVar.iKN.get(optString);
                    if (dVar != null) {
                        dVar.a(fVar2, canvas, optJSONArray);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", e);
                }
            }
        }
        if (j != 0) {
            c.aR(str, "after_draw_actions");
            c.print(str);
            nanoTime = System.nanoTime();
            this.iKH = (nanoTime - nanoTime2) + this.iKH;
            this.iKG = (nanoTime - j) + this.iKG;
            this.mCount++;
        }
        nanoTime = this.iKI;
        j = System.currentTimeMillis();
        if (nanoTime != 0) {
            com.tencent.mm.plugin.appbrand.collector.f.bE(j - nanoTime);
        }
        if (!this.iKC) {
            this.iKI = j;
        }
        return true;
    }

    public final void abh() {
    }

    public final void a(JSONArray jSONArray, a.a aVar) {
        this.iKA.l(new 3(this, jSONArray, aVar));
    }

    public final void b(JSONArray jSONArray, a.a aVar) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.iKA.l(new 4(this, jSONArray, aVar));
        }
    }

    public final void abi() {
        this.iKA.l(new 5(this));
    }

    public final void qe(String str) {
        this.iKy.gOP = str;
    }

    public final int getType() {
        return this.iKA.getType();
    }

    public final void onPause() {
        this.iKF = 0;
        this.iKA.l(this.iKD);
    }

    public final void onResume() {
        this.iKA.l(this.iKE);
    }

    public final void l(Runnable runnable) {
        if (!equals(this.iKA)) {
            this.iKA.l(runnable);
        }
    }

    public final boolean isPaused() {
        return this.iKC;
    }

    public final void qf(String str) {
        this.iKB = str;
    }

    public final int abj() {
        if (equals(this.iKA)) {
            return 0;
        }
        return this.iKA.abj();
    }

    public final int abk() {
        if (equals(this.iKA)) {
            return 0;
        }
        return this.iKA.abk();
    }

    public final void setStartTime(long j) {
        this.iKF = j;
    }

    public final void abl() {
        int i = this.mCount;
        long j = this.iKH;
        long j2 = this.iKG;
        if (i > 0 && j > 0 && j2 > 0) {
            int abj = this.iKA.abj();
            long j3 = j / ((long) i);
            int i2 = j3 <= 500000 ? 0 : j3 <= 1000000 ? 1 : j3 <= 2000000 ? 2 : j3 <= 3000000 ? 3 : j3 <= 4000000 ? 4 : j3 <= 5000000 ? 5 : 6;
            g.pQN.a((long) abj, (long) i2, 1, false);
            abj = this.iKA.abk();
            j3 = j2 / ((long) i);
            i2 = j3 <= 20000000 ? 0 : j3 <= 25000000 ? 1 : j3 <= 30000000 ? 2 : j3 <= 35000000 ? 3 : j3 <= 40000000 ? 4 : j3 <= 50000000 ? 5 : j3 <= 60000000 ? 6 : j3 <= 70000000 ? 7 : j3 <= 80000000 ? 8 : 9;
            g.pQN.a((long) abj, (long) i2, 1, false);
            int type = getType();
            if (j > 0 && j2 > 0 && i > 0) {
                ArrayList arrayList = new ArrayList();
                IDKey iDKey = new IDKey();
                iDKey.SetID(703);
                iDKey.SetKey(type == 1 ? 3 : 0);
                iDKey.SetValue(j);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(703);
                iDKey.SetKey(type == 1 ? 4 : 1);
                iDKey.SetValue(j2);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(703);
                iDKey.SetKey(type == 1 ? 5 : 2);
                iDKey.SetValue((long) i);
                arrayList.add(iDKey);
                g.pQN.a(arrayList, false);
            }
        }
    }
}
