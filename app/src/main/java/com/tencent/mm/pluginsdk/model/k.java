package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.a.e;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.appbrand.jsapi.f.c$a;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class k extends Thread {
    private static int hEF;
    private static HashMap<String, b> tSW = new HashMap();
    private static Object tSX = new byte[0];
    private static as tSY;
    private Context context;
    private Intent intent;
    private boolean isStop;
    private List<String> tSM;
    private List<Integer> tSN = new ArrayList();
    private List<String> tSO = new ArrayList();
    private List<String> tSP = new ArrayList();
    private List<Integer> tSQ = new ArrayList();
    private String talker;
    private int vds;
    private a vdt;

    public interface a {
        void bYr();
    }

    private static final class b implements com.tencent.mm.sdk.platformtools.as.a {
        String fileName;
        String hTp;
        private int owu;
        private int owv;
        String tTb;
        int tTc;
        VideoTransPara tTd;
        private boolean tTe;
        private int tTf;
        String toUser;
        int vds;

        private b() {
            this.tTf = 0;
        }

        public final boolean JB() {
            synchronized (k.tSX) {
                Object obj = !k.tSW.containsKey(this.fileName) ? 1 : null;
            }
            if (obj == null) {
                obj = t.nF(this.fileName) == null ? 1 : null;
            }
            if (obj != null) {
                x.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", new Object[]{this.fileName});
                return true;
            }
            k.hEF = HardCoderJNI.startPerformance(HardCoderJNI.hcEncodeVideoEnable, HardCoderJNI.hcEncodeVideoDelay, HardCoderJNI.hcEncodeVideoCPU, HardCoderJNI.hcEncodeVideoIO, HardCoderJNI.hcEncodeVideoThr ? Process.myTid() : 0, HardCoderJNI.hcEncodeVideoTimeout, 603, HardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo");
            x.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", new Object[]{Integer.valueOf(k.hEF)});
            if (this.tTd == null || this.tTd.isDefault) {
                int[] iArr = new int[2];
                k.d(this.hTp, iArr);
                this.owu = iArr[0];
                this.owv = iArr[1];
            } else {
                this.owu = this.tTd.width;
                this.owv = this.tTd.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            if (((com.tencent.mm.plugin.r.a.a) g.h(com.tencent.mm.plugin.r.a.a.class)).Ff().a(this.hTp, pString, pInt) && com.tencent.mm.sdk.platformtools.k.fp(pString.value, this.tTb)) {
                x.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
                this.tTc = pInt.value;
                this.tTe = true;
                return true;
            }
            long Wq = bh.Wq();
            if (this.tTd != null) {
                x.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", new Object[]{this.tTd});
                if (com.tencent.mm.plugin.sight.base.b.qsV) {
                    this.tTd.videoBitrate = (int) (((double) this.tTd.videoBitrate) * 0.915d);
                }
                this.tTc = SightVideoJNI.remuxing(this.hTp, this.tTb, this.owu, this.owv, this.tTd.videoBitrate, this.tTd.huf, 8, this.tTd.hue, 25.0f, (float) this.tTd.fps, null, 0, com.tencent.mm.plugin.sight.base.b.qsV);
            } else {
                x.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", new Object[]{this.fileName});
                if (com.tencent.mm.plugin.sight.base.b.qsV) {
                    com.tencent.mm.plugin.sight.base.b.qsX = (int) (((double) com.tencent.mm.plugin.sight.base.b.qsX) * 0.915d);
                }
                this.tTc = SightVideoJNI.remuxing(this.hTp, this.tTb, this.owu, this.owv, com.tencent.mm.plugin.sight.base.b.qsX, com.tencent.mm.plugin.sight.base.b.qsW, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.qsY, null, 0, com.tencent.mm.plugin.sight.base.b.qsV);
            }
            this.tTf = (int) bh.bA(Wq);
            x.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{this.hTp, this.tTb, Integer.valueOf(this.tTc), Integer.valueOf(this.owu), Integer.valueOf(this.owv)});
            this.tTe = this.tTc >= 0;
            PInt pInt2 = new PInt();
            if (t.a(this.tTb, pInt2, new PInt())) {
                this.tTc = pInt2.value;
            }
            if (this.tTe) {
                x.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
                try {
                    String name = new File(this.tTb).getName();
                    String str = this.tTb + ".tmp";
                    PInt pInt3 = new PInt(0);
                    if (d.b(this.tTb, str, pInt3)) {
                        boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(this.tTb);
                        File file = new File(str);
                        boolean g = e.g(file.getParent() + File.separator, file.getName(), name);
                        x.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[]{Boolean.valueOf(deleteFile), Boolean.valueOf(g), file.getAbsolutePath(), this.tTb});
                        com.tencent.mm.plugin.report.service.g.pQN.a(354, 30, 1, false);
                    } else {
                        if (pInt3.value != 1) {
                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 31, 1, false);
                        } else {
                            com.tencent.mm.plugin.report.service.g.pQN.a(354, 32, 1, false);
                            com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(600), Long.valueOf(bh.Wo()), this.tTb});
                        }
                        x.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[]{Integer.valueOf(pInt3.value), this.hTp, this.tTb});
                    }
                    ((com.tencent.mm.plugin.r.a.a) g.h(com.tencent.mm.plugin.r.a.a.class)).Ff().G(this.hTp, this.tTb, this.tTc);
                } catch (Exception e) {
                    x.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", new Object[]{e.toString()});
                }
            } else {
                x.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
                com.tencent.mm.loader.stub.b.deleteFile(this.tTb);
                com.tencent.mm.sdk.platformtools.k.q(this.hTp, this.tTb, false);
            }
            if (k.hEF != 0) {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcEncodeVideoEnable, k.hEF);
                x.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformace %s", new Object[]{Integer.valueOf(k.hEF)});
                k.hEF = 0;
            }
            return true;
        }

        public final boolean JC() {
            int i;
            int i2;
            synchronized (k.tSX) {
                k.tSW.remove(this.fileName);
            }
            if (this.tTe) {
                k.cN(this.tTb, this.vds);
            } else {
                k.cM(this.tTb, this.vds);
            }
            k.d(this.tTe, this.hTp, this.tTb);
            if (com.tencent.mm.plugin.sight.base.b.qsV) {
                i = 1;
            } else {
                i = 0;
            }
            k.a(i, this.tTf, this.hTp, this.tTb, this.tTc);
            if (this.vds == 1) {
                i2 = 8;
            } else {
                i2 = 1;
            }
            n.TS().a(this.hTp, this.tTb, this.toUser, "", "", i2, this.tTe ? 1 : 3);
            t.j(this.fileName, this.tTc, 43);
            t.nA(this.fileName);
            return false;
        }
    }

    static /* synthetic */ void a(int i, int i2, String str, String str2, int i3) {
        long bN = (long) e.bN(str);
        if (bN > 0) {
            int bN2 = (int) ((100 * ((long) e.bN(str2))) / bN);
            x.i("MicroMsg.ImportMultiVideo", "kv report video compression isNew[%d], oriSize[%d], remuxingSize[%d], compressionRatio[%d], bitrate[%d], preset[%d], retDuration[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(bN), Long.valueOf((long) e.bN(str2)), Integer.valueOf(bN2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3)});
            com.tencent.mm.plugin.report.service.g.pQN.h(13432, new Object[]{Integer.valueOf(i), Long.valueOf(bN), Long.valueOf(r2), Integer.valueOf(bN2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3)});
            return;
        }
        x.e("MicroMsg.ImportMultiVideo", "file canot be empty");
    }

    static /* synthetic */ void cN(String str, int i) {
        if (i == 2) {
            long bN = (long) e.bN(str);
            int e = bh.e((Integer) com.tencent.mm.plugin.report.service.g.a((int) (bN / 1024), new int[]{WXMediaMessage.TITLE_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, 8192, 10240, 15360, 20480}, an.CTRL_INDEX, 255));
            com.tencent.mm.plugin.report.service.g.pQN.a(106, (long) e, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.a(106, 246, 1, false);
            x.d("MicroMsg.ImportMultiVideo", "report compress video report id : " + e + " file len : " + (bN / 1024) + "K");
        }
    }

    public k(Context context, List<String> list, Intent intent, String str, int i, a aVar) {
        this.context = context;
        this.tSM = list;
        this.intent = intent;
        this.vdt = aVar;
        this.talker = str;
        this.vds = i;
    }

    public final void run() {
        if (this.tSM == null || this.tSM.size() <= 0) {
            v(this.context, this.intent);
        } else {
            for (int i = 0; i < this.tSM.size() && !this.isStop; i++) {
                x.i("MicroMsg.ImportMultiVideo", "start to import %s", new Object[]{this.tSM.get(i)});
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://" + ((String) this.tSM.get(i))));
                v(this.context, intent);
            }
        }
        if (this.vdt != null && !this.isStop) {
            ag.y(new 1(this));
        }
    }

    private void v(Context context, Intent intent) {
        String ns = s.ns((String) g.Dj().CU().get(2, ""));
        o.TU();
        String nu = s.nu(ns);
        o.TU();
        String nt = s.nt(ns);
        boolean is2G = com.tencent.mm.sdk.platformtools.an.is2G(ac.getContext());
        String i = com.tencent.mm.compatible.i.a.i(context, intent);
        if (bh.ov(i)) {
            x.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, ns, i, 0, null, intent);
            return;
        }
        VideoTransPara videoTransPara;
        int i2;
        Object obj;
        int i3;
        com.tencent.mm.compatible.i.a.a j;
        boolean oy = c.oy(i);
        int bN = e.bN(i);
        if (oy) {
            VideoTransPara videoTransPara2;
            PInt pInt = new PInt();
            if (com.tencent.mm.modelcontrol.d.MU().kM(i)) {
                x.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[]{i});
                pInt.value = 1;
                com.tencent.mm.plugin.report.service.g.pQN.a(422, 51, 1, false);
                videoTransPara2 = null;
            } else {
                VideoTransPara videoTransPara3 = new VideoTransPara();
                PInt pInt2 = new PInt();
                PInt pInt3 = new PInt();
                PInt pInt4 = new PInt();
                PInt pInt5 = new PInt();
                PInt pInt6 = new PInt();
                com.tencent.mm.plugin.sight.base.d.a(i, pInt2, pInt3, pInt4, pInt5, pInt6);
                videoTransPara3.duration = pInt2.value / 1000;
                videoTransPara3.width = pInt3.value;
                videoTransPara3.height = pInt4.value;
                videoTransPara3.fps = pInt5.value;
                videoTransPara3.videoBitrate = pInt6.value;
                x.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", new Object[]{videoTransPara3});
                videoTransPara2 = com.tencent.mm.modelcontrol.d.MU().a(videoTransPara3);
                if (videoTransPara2 == null) {
                    x.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", new Object[]{videoTransPara3});
                    pInt.value = -5;
                    videoTransPara2 = null;
                } else {
                    x.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", new Object[]{videoTransPara2});
                    if (videoTransPara3.videoBitrate <= 640000 || videoTransPara2.videoBitrate > videoTransPara3.videoBitrate) {
                        x.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", new Object[]{videoTransPara2, videoTransPara3});
                        pInt.value = 1;
                        videoTransPara2 = null;
                    } else if (videoTransPara3.fps < 45 || videoTransPara3.duration * 1000 < 180000) {
                        boolean is2G2 = com.tencent.mm.sdk.platformtools.an.is2G(ac.getContext());
                        pInt.value = SightVideoJNI.shouldRemuxing(i, videoTransPara2.width, videoTransPara2.height, is2G2 ? 10485760 : 26214400, is2G2 ? 60000.0d : 300000.0d, Constants.MAX_BUFFER_SIZE);
                    } else {
                        pInt.value = -6;
                        videoTransPara2 = null;
                    }
                }
            }
            videoTransPara = videoTransPara2;
            i2 = pInt.value;
        } else {
            if (bN > (is2G ? 10485760 : 26214400)) {
                i2 = -5;
                videoTransPara = null;
            } else {
                i2 = 1;
                videoTransPara = null;
            }
        }
        x.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", new Object[]{Integer.valueOf(i2), Boolean.valueOf(oy), Integer.valueOf(bN)});
        switch (i2) {
            case -6:
            case -4:
            case -3:
            case -2:
                a(-50002, ns, i, 0, null, intent);
                return;
            case -5:
                a(-50008, ns, i, 0, null, intent);
                return;
            case -1:
                a(-50007, ns, i, 0, null, intent);
                return;
            case 0:
                obj = 1;
                i3 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (bN <= 26214400) {
                    obj = null;
                    i3 = 0;
                    break;
                }
                a(-50002, ns, i, 0, null, intent);
                obj = null;
                i3 = -50002;
                break;
            default:
                x.e("MicroMsg.ImportMultiVideo", "unknown check type");
                a(-50001, ns, i, 0, null, intent);
                return;
        }
        com.tencent.mm.compatible.i.a.a aVar = null;
        try {
            j = com.tencent.mm.compatible.i.a.j(context, intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            j = aVar;
        }
        if (j == null) {
            x.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, ns, i, 0, null, intent);
            return;
        }
        if (obj == null) {
            com.tencent.mm.sdk.platformtools.k.q(i, nt, false);
            cM(nt, this.vds);
            d(false, i, nt);
        } else {
            i3 = -50006;
        }
        int fM = bh.fM((long) j.duration);
        Object obj2 = 1;
        if (j.bitmap != null) {
            try {
                com.tencent.mm.sdk.platformtools.d.a(j.bitmap, 60, CompressFormat.JPEG, nu, true);
                obj2 = null;
                kP(true);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.ImportMultiVideo", e2, "", new Object[0]);
            }
        }
        if (obj2 != null) {
            try {
                kP(false);
                com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.ag(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, nu, true);
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.ImportMultiVideo", e22, "", new Object[0]);
            }
        }
        if (obj == null && !e.bO(nt)) {
            i3 = -50003;
        }
        if (!e.bO(nu)) {
            i3 = -50004;
        }
        a(i3, ns, i, fM, videoTransPara, intent);
    }

    public final void bYp() {
        this.isStop = true;
        interrupt();
    }

    private void a(int i, String str, String str2, int i2, VideoTransPara videoTransPara, Intent intent) {
        x.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i2)});
        e(i, str, str2, i2);
        int i3;
        if (i == -50002) {
            i3 = this.vds == 1 ? bs.CTRL_INDEX : 245;
            x.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i3 + " importType : " + this.vds);
            com.tencent.mm.plugin.report.service.g.pQN.a(106, (long) i3, 1, false);
            a(this.talker, str, str2, intent, i2, (int) j.CTRL_INDEX);
        } else if (i == -50008) {
            com.tencent.mm.plugin.report.service.g.pQN.a(106, 210, 1, false);
            a(this.talker, str, str2, intent, i2, (int) com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
        } else if (i == -50006) {
            if (t.a(str, 1, this.talker, str2, 43) < 0) {
                a(this.talker, str, str2, intent, i2, 142);
                x.e("MicroMsg.ImportMultiVideo", "prepare");
                return;
            }
            if (tSY == null) {
                tSY = new as(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            com.tencent.mm.sdk.platformtools.as.a bVar = new b();
            synchronized (tSX) {
                tSW.put(str, bVar);
            }
            bVar.fileName = str;
            bVar.hTp = str2;
            o.TU();
            bVar.tTb = s.nt(str);
            bVar.vds = this.vds;
            bVar.toUser = this.talker;
            bVar.tTd = videoTransPara;
            tSY.c(bVar);
        } else if (i < 0) {
            i3 = this.vds == 1 ? be.CTRL_INDEX : c$a.CTRL_INDEX;
            x.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i3 + " importType : " + this.vds);
            com.tencent.mm.plugin.report.service.g.pQN.a(106, (long) i3, 1, false);
            a(this.talker, str, str2, intent, i2, 142);
        } else {
            t.b(str, i2, this.talker, str2);
            t.nA(str);
            int i4 = this.vds == 1 ? 8 : 1;
            o.TU();
            n.TS().a(str2, s.nt(str), this.talker, "", "", i4, 2);
        }
    }

    private void a(String str, String str2, String str3, Intent intent, int i, int i2) {
        cf auVar = new au();
        auVar.eQ(5);
        auVar.dS(str);
        auVar.aq(ba.hR(str));
        auVar.eR(1);
        auVar.dT(str2);
        auVar.setType(43);
        long Q = ((h) g.h(h.class)).aZi().Q(auVar);
        x.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[]{Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_talker, Integer.valueOf(auVar.getType()), Integer.valueOf(auVar.field_isSend), auVar.field_imgPath, Integer.valueOf(auVar.field_status), Long.valueOf(auVar.field_createTime)});
        if (-1 == Q) {
            x.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", new Object[]{str});
        } else if (t.nF(str2) == null) {
            o.TU();
            String nu = s.nu(str2);
            try {
                com.tencent.mm.compatible.i.a.a j = com.tencent.mm.compatible.i.a.j(this.context, intent);
                int nv;
                int nv2;
                r rVar;
                if (j == null || j.bitmap == null) {
                    com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.ag(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, nu, true);
                    nv = s.nv(nu);
                    o.TU();
                    nv2 = s.nv(s.nt(str2));
                    rVar = new r();
                    rVar.fileName = str2;
                    if (nv2 <= 0) {
                        nv2 = 0;
                    }
                    rVar.hlp = nv2;
                    rVar.hVD = nv;
                    rVar.hVH = i;
                    rVar.fDC = str;
                    rVar.hVz = (String) g.Dj().CU().get(2, "");
                    rVar.hVE = bh.Wo();
                    rVar.hVF = bh.Wo();
                    rVar.hVN = null;
                    rVar.hTp = str3;
                    if (!bh.ov(str3)) {
                        rVar.hVL = 1;
                    }
                    rVar.hVO = -1;
                    rVar.status = i2;
                    rVar.hVI = (int) Q;
                    if (!o.TU().a(rVar)) {
                        x.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", new Object[]{Long.valueOf(Q)});
                    }
                }
                i = bh.fM((long) j.duration);
                com.tencent.mm.sdk.platformtools.d.a(j.bitmap, 60, CompressFormat.JPEG, nu, true);
                nv = s.nv(nu);
                o.TU();
                nv2 = s.nv(s.nt(str2));
                rVar = new r();
                rVar.fileName = str2;
                if (nv2 <= 0) {
                    nv2 = 0;
                }
                rVar.hlp = nv2;
                rVar.hVD = nv;
                rVar.hVH = i;
                rVar.fDC = str;
                rVar.hVz = (String) g.Dj().CU().get(2, "");
                rVar.hVE = bh.Wo();
                rVar.hVF = bh.Wo();
                rVar.hVN = null;
                rVar.hTp = str3;
                if (bh.ov(str3)) {
                    rVar.hVL = 1;
                }
                rVar.hVO = -1;
                rVar.status = i2;
                rVar.hVI = (int) Q;
                if (!o.TU().a(rVar)) {
                    x.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", new Object[]{Long.valueOf(Q)});
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            }
        }
    }

    public static void d(String str, int[] iArr) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable th;
        int i = 0;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                int i2 = bh.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i3 = bh.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                iArr[0] = i2;
                iArr[1] = i3;
                while (i < 3) {
                    if (i2 % 2 == 0 && i3 % 2 == 0) {
                        if ((i2 >= i3 && (i2 <= 640 || i3 <= 480)) || (i2 <= i3 && (i2 <= 480 || i3 <= 640))) {
                            break;
                        }
                        i2 /= 2;
                        i3 /= 2;
                        i++;
                    } else {
                        mediaMetadataRetriever.release();
                        return;
                    }
                }
                iArr[0] = i2;
                iArr[1] = i3;
                mediaMetadataRetriever.release();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }

    private synchronized void e(int i, String str, String str2, int i2) {
        this.tSN.add(Integer.valueOf(i));
        this.tSO.add(str);
        this.tSP.add(str2);
        this.tSQ.add(Integer.valueOf(i2));
    }

    public static void bYq() {
        synchronized (tSX) {
            int size = tSW.size();
            tSW.clear();
        }
        if (tSY == null) {
            x.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", new Object[]{Integer.valueOf(size)});
            return;
        }
        x.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", new Object[]{Integer.valueOf(size), Integer.valueOf(tSY.xhp.size())});
        tSY.xhp.clear();
        tSY = null;
    }

    public static boolean Rv(String str) {
        boolean containsKey;
        synchronized (tSX) {
            containsKey = tSW.containsKey(str);
        }
        x.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", new Object[]{str, Boolean.valueOf(containsKey)});
        return containsKey;
    }

    public static void Rw(String str) {
        boolean z = true;
        synchronized (tSX) {
            if (tSW.remove(str) == null) {
                z = false;
            }
            x.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", new Object[]{str, Boolean.valueOf(z)});
        }
    }

    private void kP(boolean z) {
        int i;
        if (this.vds == 1) {
            if (z) {
                i = com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX;
            } else {
                i = 218;
            }
        } else if (z) {
            i = 231;
        } else {
            i = 232;
        }
        x.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + z + " importType : " + this.vds);
        com.tencent.mm.plugin.report.service.g.pQN.a(106, (long) i, 1, false);
    }

    private static void cM(String str, int i) {
        int i2;
        int i3;
        int i4;
        if (i == 1) {
            i2 = 219;
            i3 = JsApiOpenWeRunSetting.CTRL_INDEX;
            i4 = 220;
        } else {
            i2 = 233;
            i3 = 242;
            i4 = 234;
        }
        long bN = (long) e.bN(str);
        i3 = bh.e((Integer) com.tencent.mm.plugin.report.service.g.a((int) (bN / 1024), new int[]{WXMediaMessage.TITLE_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, 8192, 10240, 15360, 20480}, i4, i3));
        com.tencent.mm.plugin.report.service.g.pQN.a(106, (long) i3, 1, false);
        com.tencent.mm.plugin.report.service.g.pQN.a(106, (long) i2, 1, false);
        x.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i3 + " file len : " + (bN / 1024) + "K");
    }

    private static void d(boolean z, String str, String str2) {
        int i = 1;
        if (!z) {
            i = 0;
        }
        if (bh.ov(str) || bh.ov(str2)) {
            x.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
            return;
        }
        try {
            long bN = (long) e.bN(str);
            long bN2 = (long) e.bN(str2);
            int i2 = (int) ((100 * bN2) / bN);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i).append(";").append(bN).append(";");
            stringBuilder.append(bN2).append(";").append(i2);
            x.d("MicroMsg.AtomStatUtil", "report video remuxing : " + stringBuilder.toString());
            com.tencent.mm.plugin.report.service.g.pQN.h(11098, new Object[]{Integer.valueOf(8001), r0});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AtomStatUtil", e, "", new Object[0]);
            x.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + e.toString());
        }
    }
}
