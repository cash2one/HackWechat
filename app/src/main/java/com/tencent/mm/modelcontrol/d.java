package com.tencent.mm.modelcontrol;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.s.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import com.tencent.rtmp.TXLivePushConfig;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d implements ap {
    private static final int htS = c.ak("dscp");
    private a htT = new a();
    private byte[] htU = null;
    private b htV;
    private e[] htW;
    private e[] htX;
    private e[] htY;
    private e[] htZ;
    private e[] hua;

    public static d MU() {
        return (d) p.s(d.class);
    }

    private e[] kL(String str) {
        int i = 0;
        String value = ((a) g.h(a.class)).zY().getValue(str);
        if (bh.ov(value)) {
            x.i("MicroMsg.SubCoreVideoControl", "key %s config is null", new Object[]{str});
            return null;
        }
        if (!value.startsWith("[")) {
            value = "[" + value;
        }
        if (!value.endsWith("]")) {
            value = value + "]";
        }
        x.i("MicroMsg.SubCoreVideoControl", "%s=%s ", new Object[]{str, value});
        try {
            JSONArray jSONArray = new JSONArray(value);
            int length = jSONArray.length();
            x.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", new Object[]{Integer.valueOf(length)});
            e[] eVarArr = new e[length];
            while (i < length) {
                eVarArr[i] = c(jSONArray.getJSONObject(i));
                i++;
            }
            return eVarArr;
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + e.toString());
            return null;
        }
    }

    private static e c(JSONObject jSONObject) {
        e eVar = new e();
        try {
            String str;
            String string = jSONObject.isNull("time") ? "" : jSONObject.getString("time");
            String string2 = jSONObject.getString("abr");
            String string3 = jSONObject.getString("intval");
            String string4 = jSONObject.getString("prof");
            String string5 = jSONObject.getString("preset");
            if (jSONObject.isNull("stepbr")) {
                str = "0";
            } else {
                str = jSONObject.getString("stepbr");
            }
            x.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", new Object[]{string, string2, string3, string4, string5, str});
            eVar.a(string, string2, string3, string4, string5, str);
            JSONArray jSONArray = jSONObject.getJSONArray("conf");
            List arrayList = new ArrayList();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            PInt pInt5 = new PInt();
            PInt pInt6 = new PInt();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (a(!jSONObject2.isNull("dura") ? jSONObject2.getString("dura") : "", jSONObject2.getString("wh"), jSONObject2.getString("fps"), jSONObject2.getString("vbr"), pInt, pInt2, pInt3, pInt4, pInt5, pInt6)) {
                    arrayList.add(new f(pInt.value, pInt2.value, pInt3.value, pInt4.value, pInt5.value, pInt6.value, pInt6.value));
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2 && !eVar.hug) {
                int i2 = ((f) arrayList.get(0)).huo;
                for (int i3 = 1; i3 < arrayList.size(); i3++) {
                    f fVar = (f) arrayList.get(i3);
                    fVar.hun = i2;
                    i2 = fVar.huo;
                }
            }
            eVar.huh = new f[arrayList.size()];
            arrayList.toArray(eVar.huh);
            x.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", new Object[]{eVar});
            return eVar;
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + e.toString());
            return null;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5, PInt pInt6) {
        if (bh.ov(str2) || bh.ov(str3) || bh.ov(str4)) {
            return false;
        }
        try {
            String[] split;
            if (bh.ov(str)) {
                pInt2.value = 0;
                pInt.value = 0;
            } else {
                split = str.split("~");
                pInt.value = bh.getInt(split[0], -1);
                pInt2.value = bh.getInt(split[1], -1);
                if (pInt.value < 0 || pInt2.value < 0) {
                    return false;
                }
            }
            split = str2.split("x");
            pInt3.value = bh.getInt(split[0], -1);
            pInt4.value = bh.getInt(split[1], -1);
            if (pInt3.value < 0 || pInt4.value < 0) {
                return false;
            }
            pInt5.value = bh.getInt(str3, -1);
            pInt6.value = bh.getInt(str4, -1);
            if (pInt5.value < 0 || pInt6.value < 0) {
                return false;
            }
            pInt6.value *= 1000;
            x.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", new Object[]{str, str2, str3, str4, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value), Integer.valueOf(pInt5.value), Integer.valueOf(pInt6.value)});
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreVideoControl", "parse video para error." + e.toString());
        }
    }

    public final byte[] getWeixinMeta() {
        if (bh.bw(this.htU)) {
            try {
                this.htU = ("{\"WXVer\":" + com.tencent.mm.protocal.d.vAz + "}").getBytes("UTF-8");
                x.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", new Object[]{r0});
            } catch (Exception e) {
                x.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", new Object[]{e.toString()});
            }
        }
        return this.htU;
    }

    public final boolean kM(String str) {
        Exception e;
        Throwable th;
        if (this.htV == null) {
            this.htV = new b();
        }
        b bVar = this.htV;
        bVar.ieC = -1;
        bVar.ieE = -1;
        bVar.ieF = null;
        long Wq = bh.Wq();
        long ox = this.htV.ox(str);
        if (ox <= 0) {
            return false;
        }
        String str2 = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "r");
            try {
                randomAccessFile.seek(ox);
                byte[] bArr = new byte[8];
                com.tencent.mm.plugin.a.a aVar = null;
                for (com.tencent.mm.plugin.a.a a = c.a(randomAccessFile, bArr, com.tencent.mm.plugin.a.a.akN); a != null; a = c.a(randomAccessFile, bArr, com.tencent.mm.plugin.a.a.akN)) {
                    aVar = c.a(randomAccessFile, bArr, htS);
                    if (aVar != null) {
                        break;
                    }
                    randomAccessFile.seek(a.Wv());
                }
                if (aVar != null) {
                    byte[] bArr2 = new byte[(((int) aVar.getSize()) - 8)];
                    randomAccessFile.seek(aVar.ieB + 8);
                    if (randomAccessFile.read(bArr2) > 0) {
                        str2 = new String(bArr2, "UTF-8");
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", new Object[]{str, e.toString()});
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    x.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", new Object[]{str2, Long.valueOf(ox), Long.valueOf(bh.bA(Wq)), str});
                    if (bh.ov(str2)) {
                        return str2.contains("WXVer");
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            x.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", new Object[]{str, e.toString()});
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            x.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", new Object[]{str2, Long.valueOf(ox), Long.valueOf(bh.bA(Wq)), str});
            if (bh.ov(str2)) {
                return str2.contains("WXVer");
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
        x.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", new Object[]{str2, Long.valueOf(ox), Long.valueOf(bh.bA(Wq)), str});
        if (bh.ov(str2)) {
            return str2.contains("WXVer");
        }
        return false;
    }

    public final VideoTransPara MV() {
        VideoTransPara Ne;
        boolean z;
        VideoTransPara videoTransPara;
        long Wq = bh.Wq();
        if (this.htW == null) {
            this.htW = kL("C2CRecordVideoConfig");
        }
        if (this.htW != null) {
            for (e eVar : this.htW) {
                if (eVar != null && eVar.Nd()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
                    Ne = eVar.Ne();
                    z = eVar.hug;
                    break;
                }
            }
        }
        Ne = null;
        z = true;
        if (Ne == null) {
            Ne = new VideoTransPara();
            Ne.isDefault = true;
            Ne.width = 540;
            Ne.height = 960;
            Ne.fps = 30;
            Ne.videoBitrate = 1200000;
            Ne.hud = 1;
            Ne.huc = 64000;
            Ne.hue = 2;
            Ne.huf = 1;
            videoTransPara = Ne;
        } else {
            videoTransPara = Ne;
        }
        videoTransPara.audioSampleRate = 44100;
        videoTransPara.hud = 1;
        videoTransPara.duration = 10;
        if (z) {
            com.tencent.mm.plugin.report.service.g.pQN.a(422, 12, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(422, 11, 1, false);
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(422, (long) bh.e((Integer) com.tencent.mm.plugin.report.service.g.a(videoTransPara.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 13, 18)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", new Object[]{Long.valueOf(bh.bA(Wq)), videoTransPara, Integer.valueOf(r0)});
        return videoTransPara;
    }

    public final VideoTransPara MW() {
        VideoTransPara Ne;
        boolean z;
        VideoTransPara MY;
        long Wq = bh.Wq();
        if (this.htX == null) {
            this.htX = kL("SnsRecordVideoConfig");
        }
        if (this.htX != null) {
            for (e eVar : this.htX) {
                if (eVar != null && eVar.Nd()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
                    Ne = eVar.Ne();
                    z = eVar.hug;
                    break;
                }
            }
        }
        Ne = null;
        z = true;
        if (Ne == null) {
            MY = MY();
        } else {
            MY = Ne;
        }
        MY.audioSampleRate = 44100;
        MY.hud = 1;
        MY.duration = 10;
        MY.hup = 200;
        if (z) {
            com.tencent.mm.plugin.report.service.g.pQN.a(422, 32, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(422, 31, 1, false);
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(422, (long) bh.e((Integer) com.tencent.mm.plugin.report.service.g.a(MY.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 33, 38)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", new Object[]{Long.valueOf(bh.bA(Wq)), MY, Integer.valueOf(r0)});
        return MY;
    }

    public final VideoTransPara MX() {
        VideoTransPara Ne;
        boolean z;
        VideoTransPara MY;
        long Wq = bh.Wq();
        if (this.htY == null) {
            this.htY = kL("SnsAlbumVideoConfig");
        }
        if (this.htY != null) {
            for (e eVar : this.htY) {
                if (eVar != null && eVar.Nd()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
                    Ne = eVar.Ne();
                    z = eVar.hug;
                    break;
                }
            }
        }
        Ne = null;
        z = true;
        if (Ne == null) {
            MY = MY();
        } else {
            MY = Ne;
        }
        MY.audioSampleRate = 44100;
        MY.hud = 1;
        MY.hup = 200;
        if (z) {
            com.tencent.mm.plugin.report.service.g.pQN.a(422, 22, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(422, 21, 1, false);
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(422, (long) bh.e((Integer) com.tencent.mm.plugin.report.service.g.a(MY.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 23, 28)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", new Object[]{Long.valueOf(bh.bA(Wq)), MY, Integer.valueOf(r0)});
        return MY;
    }

    public final VideoTransPara a(VideoTransPara videoTransPara) {
        if (videoTransPara.duration >= 300) {
            x.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", new Object[]{Integer.valueOf(300)});
            return null;
        }
        e[] eVarArr;
        boolean z;
        int i;
        long Wq = bh.Wq();
        VideoTransPara hw = hw(videoTransPara.duration);
        int i2 = 1;
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100157");
        if (fn.isValid()) {
            i2 = bh.getInt((String) fn.chI().get("VideoEncodeStep"), 1);
        }
        x.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", new Object[]{Integer.valueOf(i2)});
        if ((i2 > 0 ? 1 : null) != null) {
            if (this.hua == null) {
                this.hua = kL("C2CAlbumVideoStepConfig");
            }
            eVarArr = this.hua;
        } else {
            if (this.htZ == null) {
                this.htZ = kL("C2CAlbumVideoConfig");
            }
            eVarArr = this.htZ;
        }
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                if (eVar != null && eVar.Nd()) {
                    x.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
                    int a = a.a(eVar.huh, videoTransPara, hw);
                    z = eVar.hug;
                    i = a;
                    break;
                }
            }
            z = true;
            i = 0;
        } else {
            x.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
            i = a.a(null, videoTransPara, hw);
            z = true;
        }
        if (i <= 0) {
            hw = hw(videoTransPara.duration);
        } else {
            hw.isDefault = false;
        }
        if (z) {
            com.tencent.mm.plugin.report.service.g.pQN.a(422, 2, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(422, 1, 1, false);
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(422, (long) bh.e((Integer) com.tencent.mm.plugin.report.service.g.a(hw.videoBitrate / 1000, new int[]{350, 544, 800, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, 1600}, 3, 8)), 1, false);
        x.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", new Object[]{Long.valueOf(bh.bA(Wq)), Integer.valueOf(i2), Integer.valueOf(i), hw, videoTransPara});
        return hw;
    }

    private static VideoTransPara MY() {
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.width = 540;
        videoTransPara.height = 960;
        videoTransPara.fps = 30;
        videoTransPara.videoBitrate = 1600000;
        videoTransPara.hud = 1;
        videoTransPara.huc = 64000;
        videoTransPara.hue = 2;
        videoTransPara.huf = 1;
        return videoTransPara;
    }

    private static VideoTransPara hw(int i) {
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.hud = 1;
        videoTransPara.huc = 48000;
        videoTransPara.hue = 2;
        videoTransPara.huf = 1;
        if (i <= 120) {
            videoTransPara.fps = 30;
            videoTransPara.width = 540;
            videoTransPara.height = 960;
            videoTransPara.videoBitrate = 1200000;
        } else {
            videoTransPara.fps = 24;
            videoTransPara.width = 360;
            videoTransPara.height = 640;
            videoTransPara.videoBitrate = 544000;
        }
        return videoTransPara;
    }

    public static boolean MZ() {
        int i;
        int intValue = ((Integer) g.Dj().CU().get(w.a.xso, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100136");
        if (fn.isValid()) {
            i = bh.getInt((String) fn.chI().get("streamingDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !Nb()) ? false : intValue > 0 ? true : i > 0;
        x.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i)});
        return z;
    }

    public static boolean Na() {
        int i;
        int intValue = ((Integer) g.Dj().CU().get(w.a.xso, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100153");
        if (fn.isValid()) {
            i = bh.getInt((String) fn.chI().get("snsStreamDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !Nb()) ? false : intValue > 0 ? true : i > 0;
        x.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i)});
        return z;
    }

    public static boolean Nb() {
        int i;
        String str;
        boolean z;
        String str2 = null;
        long Wq = bh.Wq();
        int intValue = ((Integer) g.Dj().CU().get(w.a.xso, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100190");
        if (fn.isValid()) {
            Map chI = fn.chI();
            i = bh.getInt((String) chI.get("player"), 1);
            str = (String) chI.get("apilevel");
            str2 = (String) chI.get("devices");
        } else {
            str = null;
            i = 1;
        }
        int i2 = VERSION.SDK_INT;
        String str3 = Build.BRAND + Build.MODEL;
        if (!bh.ov(str)) {
            for (String str4 : str.split(";")) {
                if (bh.getInt(str4, 0) == i2) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (!bh.ov(str2)) {
            for (String equalsIgnoreCase : str2.split(";")) {
                if (equalsIgnoreCase.equalsIgnoreCase(str3)) {
                    z = false;
                    break;
                }
            }
        }
        if (com.tencent.mm.compatible.util.d.fN(18)) {
            z = false;
        }
        if (Build.BRAND.equalsIgnoreCase("meizu")) {
            g.Dj().CU().a(w.a.xtK, Boolean.valueOf(true));
        }
        if (intValue == 0) {
            z = false;
        }
        if (i <= 0) {
            z = false;
        }
        x.i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, str3, str2, Integer.valueOf(i), Long.valueOf(bh.bA(Wq))});
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int i, r rVar) {
        int i2;
        String str = null;
        switch (i) {
            case 0:
                i2 = 1;
                break;
            case 1:
            case 2:
                boolean z;
                String str2;
                i2 = ((Integer) g.Dj().CU().get(w.a.xvu, Integer.valueOf(-1))).intValue();
                if (i2 == -1) {
                    i2 = e.aZB() ? 1 : 0;
                    g.Dj().CU().a(w.a.xvu, Integer.valueOf(-1));
                }
                x.d("MicroMsg.SubCoreVideoControl", "check device support hevc[%d]", new Object[]{Integer.valueOf(i2)});
                if (i2 <= 0) {
                    z = false;
                } else {
                    int i3;
                    String str3;
                    String[] split;
                    int length;
                    int i4;
                    com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100253");
                    if (fn.isValid()) {
                        Map chI = fn.chI();
                        i3 = bh.getInt((String) chI.get("openHevc"), 0);
                        str2 = (String) chI.get("brands");
                        str = (String) chI.get("devices");
                    } else {
                        str2 = null;
                        i3 = 0;
                    }
                    String str4 = Build.BRAND;
                    if (!bh.ov(str2)) {
                        String[] split2 = str2.split(";");
                        int length2 = split2.length;
                        int i5 = 0;
                        while (i5 < length2) {
                            if (split2[i5].equalsIgnoreCase(str4)) {
                                z = false;
                                str3 = Build.BRAND + Build.MODEL;
                                if (!bh.ov(str)) {
                                    split = str.split(";");
                                    length = split.length;
                                    i4 = 0;
                                    while (i4 < length) {
                                        if (split[i4].equalsIgnoreCase(str3)) {
                                            i4++;
                                        } else {
                                            z = false;
                                        }
                                    }
                                }
                                if (i3 <= 0) {
                                    z = false;
                                }
                                x.i("MicroMsg.SubCoreVideoControl", "check support hevc [%b] abtestFlag[%d] brands[%s, %s] device[%s, %s]", new Object[]{Boolean.valueOf(z), Integer.valueOf(i3), str4, str2, str3, str});
                            } else {
                                i5++;
                            }
                        }
                    }
                    z = true;
                    str3 = Build.BRAND + Build.MODEL;
                    if (bh.ov(str)) {
                        split = str.split(";");
                        length = split.length;
                        i4 = 0;
                        while (i4 < length) {
                            if (split[i4].equalsIgnoreCase(str3)) {
                                i4++;
                            } else {
                                z = false;
                            }
                        }
                    }
                    if (i3 <= 0) {
                        z = false;
                    }
                    x.i("MicroMsg.SubCoreVideoControl", "check support hevc [%b] abtestFlag[%d] brands[%s, %s] device[%s, %s]", new Object[]{Boolean.valueOf(z), Integer.valueOf(i3), str4, str2, str3, str});
                }
                if (z) {
                    o.TU();
                    str2 = s.nt(rVar.getFileName());
                    if (com.tencent.mm.a.e.bO(str2)) {
                        if (q.no(str2)) {
                            i2 = 2;
                            break;
                        }
                    }
                    i2 = 2;
                    break;
                }
            default:
                i2 = 1;
                break;
        }
        x.i("MicroMsg.SubCoreVideoControl", "check c2c video format[%d]", new Object[]{Integer.valueOf(i2)});
        if (i2 == 2) {
            com.tencent.mm.plugin.report.service.g.pQN.a(354, 130, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(354, 131, 1, false);
        }
        return i2;
    }

    public static boolean Nc() {
        String str = null;
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100253");
        if (fn.isValid()) {
            str = (String) fn.chI().get("noCompleteRange");
        }
        if (bh.ov(str)) {
            str = "20:00-23:30";
        }
        g.Dh();
        x.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", new Object[]{Boolean.valueOf(b.L(str, h.aJ(com.tencent.mm.kernel.a.Cg(), 30))), str, Integer.valueOf(r3)});
        return !b.L(str, h.aJ(com.tencent.mm.kernel.a.Cg(), 30));
    }

    public final HashMap<Integer, com.tencent.mm.by.h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        this.htW = null;
        this.hua = null;
        this.htZ = null;
        this.htX = null;
        this.htY = null;
    }
}
