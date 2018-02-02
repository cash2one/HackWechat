package com.tencent.mm.plugin.mmsight.model;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class k {
    public static void baf() {
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
        g.pQN.a(440, 0, 1, false);
        int i = 36;
        if (j.osX.gGj == 1) {
            i = 39;
        }
        if (j.osX.orw == 720) {
            i++;
        } else if (j.osX.ban()) {
            i += 2;
        }
        g.pQN.a(440, (long) i, 1, false);
    }

    public static void bag() {
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
        g.pQN.a(440, 7, 1, false);
    }

    public static void bah() {
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
        g.pQN.a(440, 8, 1, false);
    }

    public static void bai() {
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
        g.pQN.a(440, 16, 1, false);
    }

    public static void baj() {
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
        g.pQN.a(440, 21, 1, false);
    }

    public static void d(boolean z, long j) {
        int i;
        x.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
        a.aZT().orD = j;
        a aZT = a.aZT();
        d dVar = new d();
        d dVar2 = new d();
        dVar.p("model", aZT.model + ",");
        dVar.p("apiLevel", aZT.ord + ",");
        dVar.p("memoryClass", aZT.mfU + ",");
        dVar.p("totalMemory", aZT.ore + ",");
        dVar.p("maxCpu", aZT.orf + ",");
        dVar.p("screenW", aZT.org + ",");
        dVar.p("screenH", aZT.orh + ",");
        dVar2.p("model", aZT.model + ",");
        dVar2.p("apiLevel", aZT.ord + ",");
        dVar2.p("memoryClass", aZT.mfU + ",");
        dVar2.p("totalMemory", aZT.ore + ",");
        dVar2.p("maxCpu", aZT.orf + ",");
        dVar2.p("screenW", aZT.org + ",");
        dVar2.p("screenH", aZT.orh + ",");
        dVar.p("cropx", aZT.orm + ",");
        dVar.p("cropy", aZT.orn + ",");
        dVar.p("previewx", aZT.oro + ",");
        dVar.p("previewy", aZT.orp + ",");
        dVar.p("encoderx", aZT.orq + ",");
        dVar.p("encodery", aZT.orr + ",");
        dVar.p(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, aZT.fFy + ",");
        dVar.p("deviceoutfps", aZT.ors + ",");
        dVar.p("recordfps", aZT.ort + ",");
        dVar.p("recordertype", aZT.oru + ",");
        dVar.p("videoBitrate", aZT.videoBitrate + ",");
        dVar.p("needRotateEachFrame", aZT.gGk + ",");
        dVar.p("isNeedRealtimeScale", aZT.orv + ",");
        dVar.p("resolutionLimit", aZT.orw + ",");
        dVar.p("outfps", aZT.orx + ",");
        dVar.p("recordTime", aZT.ory + ",");
        dVar.p("avgcpu", aZT.orz + ",");
        dVar.p("outx", aZT.orA + ",");
        dVar.p("outy", aZT.orB + ",");
        dVar.p("outbitrate", aZT.orC + ",");
        dVar.p("fileSize", aZT.fileSize + ",");
        dVar.p("wait2playtime", aZT.orD + ",");
        dVar.p("useback", aZT.orE + ",");
        int i2 = 0;
        int i3 = 0;
        Intent registerReceiver = ac.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            i3 = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            i3 = (i3 == 2 || i3 == 5) ? 1 : 0;
            i2 = registerReceiver.getIntExtra("level", -1);
            i = i3;
            i3 = registerReceiver.getIntExtra("scale", -1);
        } else {
            i = 0;
        }
        x.i("MicroMsg.CaptureStatistics", "battery %s %s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        dVar.p("mIsCharging", i + ",");
        dVar.p("level", i2 + ",");
        dVar.p("scale", i3 + ",");
        dVar.p("createTime", System.currentTimeMillis() + ",");
        dVar2.p("prewViewlist1", aZT.ori + ",");
        dVar2.p("pictureSize1", aZT.orj + ",");
        dVar2.p("prewViewlist2", aZT.ork + ",");
        dVar2.p("pictureSize2", aZT.orl + ",");
        x.i("MicroMsg.CaptureStatistics", "report " + dVar.Sz());
        x.v("MicroMsg.CaptureStatistics", "report " + dVar2.Sz());
        g.pQN.k(13947, dVar.toString());
        g.pQN.k(13949, dVar2.toString());
        if (z) {
            g.pQN.a(440, 119, 1, false);
            g.pQN.a(440, 120, j, false);
            if (j.osX.orw == 720) {
                g.pQN.a(440, 122, j, false);
                return;
            } else if (j.osX.ban()) {
                g.pQN.a(440, 123, j, false);
                return;
            } else {
                g.pQN.a(440, 121, j, false);
                return;
            }
        }
        g.pQN.a(440, 124, 1, false);
        g.pQN.a(440, 125, j, false);
        if (j.osX.gGj == 1) {
            g.pQN.a(440, 127, j, false);
            g.pQN.a(440, 131, j, false);
            return;
        }
        g.pQN.a(440, 126, j, false);
        g.pQN.a(440, 130, j, false);
    }
}
