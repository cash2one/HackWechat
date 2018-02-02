package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a {
    static a orc;
    public int fFy = 0;
    public long fileSize;
    public int gGk;
    int mfU;
    String model = Build.MODEL;
    public int orA;
    public int orB;
    public int orC;
    public long orD;
    public int orE;
    JSONObject orF = null;
    String ord = (VERSION.SDK_INT);
    int ore;
    String orf;
    int org;
    int orh;
    public String ori;
    public String orj;
    public String ork;
    public String orl;
    public int orm;
    public int orn;
    public int oro;
    public int orp;
    public int orq;
    public int orr;
    public int ors;
    public int ort;
    public int oru;
    public int orv;
    public int orw;
    public int orx;
    public int ory;
    int orz;
    public int videoBitrate;

    public static a aZT() {
        if (orc == null) {
            reset();
        }
        return orc;
    }

    public static void reset() {
        a aVar = new a();
        orc = aVar;
        aVar.mfU = ((ActivityManager) ac.getContext().getSystemService("activity")).getLargeMemoryClass();
        orc.ore = d.dc(ac.getContext());
        orc.orf = m.yq();
        Point db = d.db(ac.getContext());
        orc.org = db.x;
        orc.orh = db.y;
    }

    public final String aZU() {
        if (this.orF == null) {
            try {
                this.orF = new JSONObject();
                JSONObject jSONObject = new JSONObject();
                this.orF.put("wxcamera", jSONObject);
                jSONObject.put("model", this.model);
                jSONObject.put("apiLevel", this.ord);
                jSONObject.put("screen", String.format("%dx%d", new Object[]{Integer.valueOf(this.org), Integer.valueOf(this.orh)}));
                jSONObject.put("crop", String.format("%dx%d", new Object[]{Integer.valueOf(this.orm), Integer.valueOf(this.orn)}));
                jSONObject.put("preview", String.format("%dx%d", new Object[]{Integer.valueOf(this.oro), Integer.valueOf(this.orp)}));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_ENCODER, String.format("%dx%d", new Object[]{Integer.valueOf(this.orq), Integer.valueOf(this.orr)}));
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, this.fFy);
                jSONObject.put("deviceoutfps", this.ors);
                jSONObject.put("recordfps", this.ort);
                jSONObject.put("recordertype", this.oru);
                jSONObject.put("needRotateEachFrame", this.gGk);
                jSONObject.put("isNeedRealtimeScale", this.orv);
                jSONObject.put("resolutionLimit", this.orw);
                jSONObject.put("videoBitrate", this.videoBitrate);
                jSONObject.put("wait2playtime", this.orD);
                jSONObject.put("useback", this.orE);
                jSONObject.put("presetIndex", j.osX != null ? j.osX.otg : -1);
                jSONObject.put("recorderOption", q.gGb.gGq);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CaptureStatistics", e, "buildJson error", new Object[0]);
            }
        }
        return this.orF.toString();
    }
}
