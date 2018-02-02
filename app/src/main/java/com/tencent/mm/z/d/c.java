package com.tencent.mm.z.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.m;
import com.tencent.mm.az.j;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class c implements e {
    private static c hjt;
    private ArrayList<a> gLv = new ArrayList();
    private SharedPreferences gZO = ac.cft();
    private final int hjp = 21;
    private final String hjq = "trace_config_last_update_time";
    private final long hjr = 86400000;
    private volatile boolean hjs = false;

    private c() {
    }

    public static c IR() {
        if (hjt == null) {
            synchronized (c.class) {
                if (hjt == null) {
                    hjt = new c();
                }
            }
        }
        return hjt;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        x.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(type));
        if (!(kVar instanceof m) || ((m) kVar).Kl() != 21) {
            x.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
        } else if (type == JsApiGetBackgroundAudioState.CTRL_INDEX) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.az.m[] ik = r.QH().ik(21);
                if (ik == null || ik.length == 0) {
                    x.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
                    release();
                    return;
                }
                com.tencent.mm.az.m mVar = ik[0];
                x.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + mVar.id + " version:" + mVar.version + " status:" + mVar.status + " type:" + mVar.fvM);
                if (5 == mVar.status) {
                    ar.CG().a(new j(mVar.id, 21), 0);
                    return;
                }
                x.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
                this.gZO.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
                release();
                return;
            }
            release();
        } else if (type == JsApiSetBackgroundAudioState.CTRL_INDEX) {
            if (i == 0 && i2 == 0) {
                he(((j) kVar).hJE);
            }
            release();
        }
    }

    private void he(int i) {
        r.QH();
        try {
            Map y = bi.y(com.tencent.mm.a.e.bT(new File(new File(n.QE()), r.QH().bg(i, 21)).getPath()), "TraceConfig");
            if (y == null) {
                x.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
                return;
            }
            int i2;
            String str = ".TraceConfig.Item";
            Map hashMap = new HashMap();
            int i3 = 0;
            while (true) {
                String str2 = str + (i3 == 0 ? "" : Integer.valueOf(i3));
                String str3 = (String) y.get(str2 + ".$key");
                if (str3 == null) {
                    break;
                }
                i2 = i3 + 1;
                long j = bh.getLong((String) y.get(str2), -1);
                if (j >= 0) {
                    x.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i2 + " key: " + str3 + "|value: " + j);
                    hashMap.put(str3, Long.valueOf(j));
                    i3 = i2;
                } else {
                    i3 = i2;
                }
            }
            Editor edit = this.gZO.edit();
            for (Entry entry : hashMap.entrySet()) {
                edit.putLong((String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
            edit.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
            x.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + hashMap.size());
            i2 = this.gLv.size();
            for (i3 = 0; i3 < i2; i3++) {
                ((a) this.gLv.get(i3)).IK();
            }
            com.tencent.mm.az.m be = r.QH().be(i, 21);
            be.status = 2;
            r.QH().b(be);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TraceConfigUpdater", e, "", new Object[0]);
        }
    }

    private void release() {
        x.i("MicroMsg.TraceConfigUpdater", "summer release");
        this.hjs = false;
        ar.CG().b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
        ar.CG().b((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
    }

    public final boolean a(a aVar) {
        if (aVar == null || this.gLv.contains(aVar)) {
            return false;
        }
        return this.gLv.add(aVar);
    }
}
