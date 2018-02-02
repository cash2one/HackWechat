package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class l {
    public static boolean a(String str, VideoTransPara videoTransPara, aqc com_tencent_mm_protocal_c_aqc, d dVar) {
        try {
            if (bh.ov(str) || videoTransPara == null) {
                return false;
            }
            if (com_tencent_mm_protocal_c_aqc == null) {
                com_tencent_mm_protocal_c_aqc = new aqc();
            }
            x.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", Boolean.valueOf(com_tencent_mm_protocal_c_aqc.wwP), str, videoTransPara, Boolean.valueOf(com_tencent_mm_protocal_c_aqc.wwT));
            if (com_tencent_mm_protocal_c_aqc.wwT) {
                x.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", str);
                return false;
            } else if (!com_tencent_mm_protocal_c_aqc.wwP || bh.ov(str)) {
                return false;
            } else {
                SightVideoJNI.tagMP4Dscp(str, d.MU().getWeixinMeta());
                if (!bh.ov(com_tencent_mm_protocal_c_aqc.wwS)) {
                    SightVideoJNI.tagMp4RecordInfo(str, com_tencent_mm_protocal_c_aqc.wwS);
                }
                long Wq = bh.Wq();
                SightVideoJNI.optimizeMP4(str);
                x.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", Long.valueOf(bh.bA(Wq)));
                dVar.aZb();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int i = bh.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i2 = bh.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                int i3 = bh.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                mediaMetadataRetriever.release();
                x.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                x.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s", Integer.valueOf(videoTransPara.width), Integer.valueOf(videoTransPara.height), Integer.valueOf(videoTransPara.videoBitrate));
                int min = Math.min(i, i2);
                x.i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", Boolean.valueOf(q.gGb.gGt == 1), Boolean.valueOf(bh.getInt(((a) g.h(a.class)).zY().getValue("MMSightCheckSendVideoBitrate"), 0) == 1), Float.valueOf(bh.getFloat(((a) g.h(a.class)).zY().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3f)));
                Object obj = ((q.gGb.gGt == 1) || (bh.getInt(((a) g.h(a.class)).zY().getValue("MMSightCheckSendVideoBitrate"), 0) == 1)) ? 1 : null;
                if (min > videoTransPara.width && ((min <= videoTransPara.width || min % 16 != 0 || Math.abs(min - videoTransPara.width) >= 16) && (obj == null || ((float) i3) < ((float) videoTransPara.videoBitrate) * r5))) {
                    return true;
                }
                if (com_tencent_mm_protocal_c_aqc.wwO) {
                    return true;
                }
                if (((double) i3) >= ((double) videoTransPara.videoBitrate) * 1.3d) {
                    return true;
                }
                com_tencent_mm_protocal_c_aqc.wwT = true;
                return false;
            }
        } catch (Exception e) {
            x.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", e.getMessage(), str);
            if (com_tencent_mm_protocal_c_aqc != null) {
                com_tencent_mm_protocal_c_aqc.wwT = true;
            }
            return false;
        }
    }

    public static int b(String str, VideoTransPara videoTransPara, aqc com_tencent_mm_protocal_c_aqc, d dVar) {
        if (com_tencent_mm_protocal_c_aqc == null || !com_tencent_mm_protocal_c_aqc.wwP || !FileOp.bO(str)) {
            return -1;
        }
        if (com_tencent_mm_protocal_c_aqc.wwT) {
            x.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", str);
        }
        try {
            String str2;
            String substring;
            String mg = FileOp.mg(str);
            if (mg.endsWith("/")) {
                str2 = mg;
            } else {
                str2 = mg + "/";
            }
            mg = new File(str).getName();
            int lastIndexOf = mg.lastIndexOf(46);
            if (lastIndexOf > 0) {
                substring = mg.substring(0, lastIndexOf);
            } else {
                substring = mg;
            }
            mg = str2 + substring + "_hd";
            if (str.endsWith(".mp4")) {
                mg = mg + ".mp4";
            }
            String str3 = str2 + substring + "tempRemuxing.mp4";
            FileOp.x(str, mg);
            x.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", str2, substring, mg, str3, Integer.valueOf(com_tencent_mm_protocal_c_aqc.wwQ));
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(mg);
            int i = bh.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            int i2 = bh.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            if (Math.min(i, i2) < videoTransPara.width) {
                return 0;
            }
            int i3;
            int min = Math.min(i, i2);
            if (min <= videoTransPara.width || (min > videoTransPara.width && min % 16 == 0 && Math.abs(min - videoTransPara.width) < 16)) {
                i3 = i2;
                min = i;
            } else {
                if (i < i2) {
                    min = videoTransPara.width;
                    i3 = (int) (((double) i2) / ((1.0d * ((double) i)) / ((double) min)));
                } else {
                    i3 = videoTransPara.width;
                    min = (int) (((double) i) / ((1.0d * ((double) i2)) / ((double) i3)));
                }
                if (i3 % 2 != 0) {
                    i3++;
                }
                if (min % 2 != 0) {
                    min++;
                }
            }
            x.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(min), Integer.valueOf(i3), videoTransPara);
            long Wq = bh.Wq();
            x.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(min), Integer.valueOf(i3), Integer.valueOf(SightVideoJNI.remuxing(mg, str3, min, i3, videoTransPara.videoBitrate, videoTransPara.huf, 8, videoTransPara.hue, 25.0f, 30.0f, null, 0, false)), Long.valueOf(bh.bA(Wq)));
            FileOp.at(str3, str);
            long Wq2 = bh.Wq();
            if (com_tencent_mm_protocal_c_aqc.wwP) {
                SightVideoJNI.tagMP4Dscp(str, d.MU().getWeixinMeta());
                if (!bh.ov(com_tencent_mm_protocal_c_aqc.wwS)) {
                    SightVideoJNI.tagMp4RecordInfo(str, com_tencent_mm_protocal_c_aqc.wwS);
                }
                SightVideoJNI.optimizeMP4(str);
            }
            dVar.aZb();
            x.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", Long.valueOf(bh.bA(Wq2)));
            return r2;
        } catch (Exception e) {
            x.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", e.getMessage());
            return -1;
        }
    }
}
