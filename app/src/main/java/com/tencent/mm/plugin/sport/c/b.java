package com.tencent.mm.plugin.sport.c;

import android.os.Looper;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import java.util.Calendar;
import org.json.JSONObject;

public final class b {
    public c<qo> rTE = new c<qo>(this) {
        final /* synthetic */ b rTO;

        {
            this.rTO = r2;
            this.xen = qo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qo qoVar = (qo) bVar;
            switch (qoVar.fIh.action) {
                case 1:
                case 2:
                case 3:
                    if (n.bDy()) {
                        boolean fc;
                        long cgt = bh.cgt() / 10000;
                        long K = i.K(513, 0);
                        long K2 = i.K(WXMediaMessage.TITLE_LENGTH_LIMIT, 0);
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(K);
                        instance.set(11, 0);
                        instance.set(12, 0);
                        instance.set(13, 0);
                        if (cgt != instance.getTimeInMillis() / 10000) {
                            K2 = 0;
                        }
                        if (qoVar.fIh.action == 1) {
                            fc = this.rTO.fc(K2);
                            com.tencent.mm.sdk.b.b feVar = new fe();
                            feVar.fui.action = 1;
                            a.xef.a(feVar, Looper.getMainLooper());
                        } else {
                            fc = n.F(this.rTO.bDo(), K2) ? this.rTO.fc(K2) : false;
                        }
                        x.i("MicroMsg.Sport.ExtApiStepManager", "upload step %d %d %b", new Object[]{Integer.valueOf(qoVar.fIh.action), Long.valueOf(K2), Boolean.valueOf(fc)});
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    public f rTF;
    public c rTL = new 1(this);
    private long rTM;
    private long rTN;

    public b() {
        this.rTL.ceO();
        this.rTE.ceO();
    }

    final boolean i(com.tencent.mm.sdk.b.b bVar) {
        fe feVar = (fe) bVar;
        switch (feVar.fui.action) {
            case 2:
                int i;
                long j = feVar.fui.ful;
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = feVar.fui.fum;
                com.tencent.mm.g.a.fe.b bVar2 = feVar.fuj;
                if (!n.bDd()) {
                    i = 3906;
                } else if (n.bDy()) {
                    long K = i.K(513, 0);
                    long K2 = i.K(WXMediaMessage.TITLE_LENGTH_LIMIT, 0);
                    x.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[]{Long.valueOf(K), Long.valueOf(K2), Long.valueOf(currentTimeMillis), Long.valueOf(j)});
                    if (currentTimeMillis - K < 300000) {
                        x.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
                        i = 3903;
                    } else {
                        JSONObject bDr = g.bDr();
                        if (!bh.u(currentTimeMillis, K)) {
                            K = bh.cgt();
                            K2 = 0;
                        }
                        long j3 = currentTimeMillis - K;
                        x.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", new Object[]{Long.valueOf((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0))), Long.valueOf(j3), Long.valueOf(currentTimeMillis), Long.valueOf(K), Long.valueOf(((long) bDr.optInt("stepCounterMaxStep5m")) * ((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0))))});
                        K2 = j - K2;
                        if (K2 < 0 || K2 > r14) {
                            x.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[]{Long.valueOf(K2), Long.valueOf(r14)});
                            i = 3904;
                        } else {
                            x.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[]{n.bp(currentTimeMillis), Long.valueOf(j)});
                            i.L(513, currentTimeMillis);
                            i.L(WXMediaMessage.TITLE_LENGTH_LIMIT, j);
                            i.L(514, j2);
                            i = 1;
                        }
                    }
                } else {
                    i = 3902;
                }
                bVar2.fup = i;
                if (feVar.fuj.fup == 1) {
                    if (this.rTM == 0) {
                        this.rTM = i.K(515, 0);
                    }
                    boolean E = n.E(this.rTM, System.currentTimeMillis());
                    boolean F = n.F(bDo(), j);
                    if (E && F) {
                        fc(j);
                    }
                }
                feVar.fuj.fuo = true;
                break;
            case 3:
                try {
                    JSONObject optJSONObject = g.bDr().optJSONObject("extStepApiConfig");
                    if (optJSONObject != null) {
                        feVar.fuj.fun = optJSONObject.toString();
                    }
                    if (bh.ov(feVar.fuj.fun)) {
                        feVar.fuj.fup = 3905;
                    } else {
                        feVar.fuj.fup = 1;
                    }
                } catch (Exception e) {
                    feVar.fuj.fup = 3905;
                }
                feVar.fuj.fuo = true;
                break;
        }
        return true;
    }

    final boolean fc(long j) {
        if (this.rTF != null) {
            g.CG().c(this.rTF);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        x.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[]{n.bp(currentTimeMillis), Long.valueOf(j)});
        this.rTF = new f("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (currentTimeMillis / 1000), (int) j, be.cjW(), 2);
        g.CG().a(this.rTF, 0);
        this.rTM = currentTimeMillis;
        i.L(515, currentTimeMillis);
        this.rTN = j;
        i.K(516, this.rTN);
        return true;
    }

    public final long bDo() {
        if (this.rTN == 0) {
            this.rTN = i.K(516, 0);
        }
        return this.rTN;
    }
}
