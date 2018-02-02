package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.i.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d extends Thread {
    private static HashMap<String, b> tSW = new HashMap();
    private static Object tSX = new byte[0];
    private static as tSY;
    public boolean isStop;
    private List<String> tSM;
    private List<Integer> tSN;
    private List<String> tSO;
    private List<String> tSP;
    private List<Integer> tSQ;
    private a tSR;
    private j tSS;
    private String tST;
    private String tSU;
    private boolean tSV = false;

    public d(List<String> list, String str, String str2, j jVar, a aVar) {
        this.tSM = list;
        this.tSN = new ArrayList();
        this.tSO = new ArrayList();
        this.tSQ = new ArrayList();
        this.tSP = new ArrayList();
        this.tSR = aVar;
        this.tSS = jVar;
        this.tSU = str2;
        this.tST = str;
    }

    public final void run() {
        if (this.tSM != null && this.tSM.size() > 0) {
            for (int i = 0; i < this.tSM.size() && !this.isStop; i++) {
                String nt;
                String str;
                x.i("MicroMsg.NoteVideoCompress", "start to import %s", new Object[]{this.tSM.toString()});
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://" + ((String) this.tSM.get(i))));
                Context context = ac.getContext();
                StringBuilder stringBuilder = new StringBuilder("note_");
                ar.Hg();
                String stringBuilder2 = stringBuilder.append(s.ns((String) c.CU().get(2, ""))).toString();
                String nu;
                if (bh.ov(this.tST) || bh.ov(this.tSU)) {
                    o.TU();
                    nu = s.nu(stringBuilder2);
                    o.TU();
                    nt = s.nt(stringBuilder2);
                    str = nu;
                } else {
                    nu = this.tST;
                    stringBuilder2 = this.tSU.substring(this.tSU.lastIndexOf("/") + 1, this.tSU.length());
                    nt = this.tSU;
                    str = nu;
                }
                boolean is2G = an.is2G(ac.getContext());
                String i2 = a.i(context, intent);
                if (bh.ov(i2)) {
                    x.e("MicroMsg.NoteVideoCompress", "GetVideoMetadata filed.");
                    a(-50005, stringBuilder2, i2, 0, null, context, null);
                } else {
                    VideoTransPara videoTransPara;
                    int i3;
                    Object obj;
                    int i4;
                    a.a j;
                    boolean oy = com.tencent.mm.plugin.a.c.oy(i2);
                    int bN = e.bN(i2);
                    if (oy) {
                        VideoTransPara videoTransPara2;
                        PInt pInt = new PInt();
                        if (com.tencent.mm.modelcontrol.d.MU().kM(i2)) {
                            x.i("MicroMsg.NoteVideoCompress", "check remuxing, this video had wx meta do not remuxing. %s ", new Object[]{i2});
                            pInt.value = 1;
                            videoTransPara2 = null;
                        } else {
                            VideoTransPara videoTransPara3 = new VideoTransPara();
                            PInt pInt2 = new PInt();
                            PInt pInt3 = new PInt();
                            PInt pInt4 = new PInt();
                            PInt pInt5 = new PInt();
                            PInt pInt6 = new PInt();
                            com.tencent.mm.plugin.sight.base.d.a(i2, pInt2, pInt3, pInt4, pInt5, pInt6);
                            videoTransPara3.duration = pInt2.value / 1000;
                            videoTransPara3.width = pInt3.value;
                            videoTransPara3.height = pInt4.value;
                            videoTransPara3.fps = pInt5.value;
                            videoTransPara3.videoBitrate = pInt6.value;
                            x.d("MicroMsg.NoteVideoCompress", "check remuxing old para %s", new Object[]{videoTransPara3});
                            videoTransPara2 = com.tencent.mm.modelcontrol.d.MU().a(videoTransPara3);
                            if (videoTransPara2 == null) {
                                x.i("MicroMsg.NoteVideoCompress", "get C2C album video para is null. old para %s", new Object[]{videoTransPara3});
                                pInt.value = -5;
                                videoTransPara2 = null;
                            } else {
                                x.d("MicroMsg.NoteVideoCompress", "check remuxing new para %s", new Object[]{videoTransPara2});
                                if (videoTransPara3.videoBitrate <= 640000 || videoTransPara2.videoBitrate > videoTransPara3.videoBitrate) {
                                    x.i("MicroMsg.NoteVideoCompress", "new bitrate is bigger than old bitrate %s %s", new Object[]{videoTransPara2, videoTransPara3});
                                    pInt.value = 1;
                                    videoTransPara2 = null;
                                } else if (videoTransPara3.fps < 45 || videoTransPara3.duration * 1000 < 180000) {
                                    boolean is2G2 = an.is2G(ac.getContext());
                                    pInt.value = SightVideoJNI.shouldRemuxing(i2, videoTransPara2.width, videoTransPara2.height, is2G2 ? 10485760 : 26214400, is2G2 ? 60000.0d : 300000.0d, Constants.MAX_BUFFER_SIZE);
                                } else {
                                    pInt.value = -6;
                                    videoTransPara2 = null;
                                }
                            }
                        }
                        videoTransPara = videoTransPara2;
                        i3 = pInt.value;
                    } else {
                        if (bN > (is2G ? 10485760 : 26214400)) {
                            i3 = -5;
                            videoTransPara = null;
                        } else {
                            i3 = 1;
                            videoTransPara = null;
                        }
                    }
                    x.i("MicroMsg.NoteVideoCompress", "check remuxing, ret %d isMp4 %b length %d", new Object[]{Integer.valueOf(i3), Boolean.valueOf(oy), Integer.valueOf(bN)});
                    switch (i3) {
                        case -6:
                        case -4:
                        case -3:
                        case -2:
                            a(-50002, stringBuilder2, i2, 0, null, context, null);
                            continue;
                        case -5:
                            a(-50008, stringBuilder2, i2, 0, null, context, null);
                            continue;
                        case -1:
                            a(-50007, stringBuilder2, i2, 0, null, context, null);
                            continue;
                        case 0:
                            obj = 1;
                            i4 = 0;
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            if (bN <= 26214400) {
                                obj = null;
                                i4 = 0;
                                break;
                            }
                            a(-50002, stringBuilder2, i2, 0, null, context, null);
                            obj = null;
                            i4 = -50002;
                            break;
                        default:
                            x.e("MicroMsg.NoteVideoCompress", "unknown check type");
                            a(-50001, stringBuilder2, i2, 0, null, context, null);
                            continue;
                    }
                    a.a aVar = null;
                    try {
                        j = a.j(context, intent);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.NoteVideoCompress", e, "", new Object[0]);
                        j = aVar;
                    }
                    if (j == null) {
                        x.e("MicroMsg.NoteVideoCompress", "GetVideoMetadata filed.");
                        a(-50005, stringBuilder2, i2, 0, null, context, null);
                    } else {
                        Object obj2;
                        if (obj == null) {
                            k.q(i2, nt, false);
                        } else {
                            i4 = -50006;
                        }
                        int fM = bh.fM((long) j.duration);
                        if (j.bitmap != null) {
                            try {
                                com.tencent.mm.sdk.platformtools.d.a(j.bitmap, 60, CompressFormat.JPEG, str, true);
                                obj2 = null;
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.NoteVideoCompress", e2, "", new Object[0]);
                            }
                            if (obj2 != null) {
                                try {
                                    com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.ag(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, str, true);
                                } catch (Throwable e22) {
                                    x.printErrStackTrace("MicroMsg.NoteVideoCompress", e22, "", new Object[0]);
                                }
                            }
                            if (obj == null && !e.bO(nt)) {
                                i4 = -50003;
                            }
                            if (!e.bO(str)) {
                                i4 = -50004;
                            }
                            a(i4, stringBuilder2, i2, fM, videoTransPara, context, str);
                        }
                        int i5 = 1;
                        if (obj2 != null) {
                            com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.ag(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, str, true);
                        }
                        i4 = -50003;
                        if (e.bO(str)) {
                            i4 = -50004;
                        }
                        a(i4, stringBuilder2, i2, fM, videoTransPara, context, str);
                    }
                }
            }
        }
    }

    private void a(int i, String str, String str2, int i2, VideoTransPara videoTransPara, Context context, String str3) {
        x.i("MicroMsg.NoteVideoCompress", "finish to import %s to %s | ret %d | duration %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i2)});
        e(i, str, str2, i2);
        if (i == -50002) {
            aS(context, context.getString(R.l.eSY));
        } else if (i == -50008) {
            aS(context, context.getString(R.l.eSW));
        } else if (i == -50006) {
            if (bh.ov(str)) {
                x.w("MicroMsg.NoteVideoCompress", "do insertVideoStorage, but file name is null");
            } else {
                r rVar = new r();
                rVar.fileName = str;
                rVar.hVH = 1;
                rVar.fDC = null;
                ar.Hg();
                rVar.hVz = (String) c.CU().get(2, "");
                rVar.hVE = bh.Wo();
                rVar.hVF = bh.Wo();
                rVar.hVN = null;
                rVar.hTp = str2;
                if (!bh.ov(str2)) {
                    rVar.hVL = 1;
                }
                rVar.hlp = 0;
                o.TU().a(rVar);
            }
            if (tSY == null) {
                tSY = new as(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            as.a bVar = new b((byte) 0);
            synchronized (tSX) {
                tSW.put(str, bVar);
            }
            bVar.fileName = str;
            bVar.hTp = str2;
            bVar.tTb = this.tSU;
            bVar.tTd = videoTransPara;
            bVar.tSR = this.tSR;
            bVar.tSS = this.tSS;
            tSY.c(bVar);
        } else if (i < 0) {
            aS(context, context.getString(R.l.eSX));
        } else {
            this.tSV = true;
        }
        if (this.tSR != null && !this.isStop) {
            ag.y(new 1(this, str3, i));
        }
    }

    private void aS(Context context, String str) {
        ag.y(new 2(this, context, str));
    }

    public static void d(String str, int[] iArr) {
        MediaMetadataRetriever mediaMetadataRetriever;
        int i;
        int i2;
        Throwable e;
        Throwable th;
        int i3;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                i = bh.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                try {
                    i2 = bh.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                    mediaMetadataRetriever.release();
                } catch (Throwable e2) {
                    Throwable th2 = e2;
                    i2 = i;
                    th = th2;
                    try {
                        x.printErrStackTrace("MicroMsg.NoteVideoCompress", th, "getImportProperRemuxingResolution error", new Object[0]);
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        i = i2;
                        i2 = 0;
                        iArr[0] = i;
                        iArr[1] = i2;
                        i3 = 0;
                        while (i3 < 3) {
                            if (i % 2 == 0) {
                                return;
                            }
                            return;
                        }
                        iArr[0] = i;
                        iArr[1] = i2;
                    } catch (Throwable th3) {
                        e2 = th3;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw e2;
                    }
                }
            } catch (Throwable e22) {
                th = e22;
                i2 = 0;
                x.printErrStackTrace("MicroMsg.NoteVideoCompress", th, "getImportProperRemuxingResolution error", new Object[0]);
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                i = i2;
                i2 = 0;
                iArr[0] = i;
                iArr[1] = i2;
                i3 = 0;
                while (i3 < 3) {
                    if (i % 2 == 0) {
                        return;
                    }
                    return;
                }
                iArr[0] = i;
                iArr[1] = i2;
            }
        } catch (Throwable e222) {
            mediaMetadataRetriever = null;
            th = e222;
            i2 = 0;
            x.printErrStackTrace("MicroMsg.NoteVideoCompress", th, "getImportProperRemuxingResolution error", new Object[0]);
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            i = i2;
            i2 = 0;
            iArr[0] = i;
            iArr[1] = i2;
            i3 = 0;
            while (i3 < 3) {
                if (i % 2 == 0) {
                    return;
                }
                return;
            }
            iArr[0] = i;
            iArr[1] = i2;
        } catch (Throwable th4) {
            e222 = th4;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw e222;
        }
        iArr[0] = i;
        iArr[1] = i2;
        i3 = 0;
        while (i3 < 3) {
            if (i % 2 == 0 && i2 % 2 == 0) {
                if ((i >= i2 && (i <= 640 || i2 <= 480)) || (i <= i2 && (i <= 480 || i2 <= 640))) {
                    break;
                }
                i /= 2;
                i2 /= 2;
                i3++;
            } else {
                return;
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private synchronized void e(int i, String str, String str2, int i2) {
        this.tSN.add(Integer.valueOf(i));
        this.tSO.add(str);
        this.tSP.add(str2);
        this.tSQ.add(Integer.valueOf(i2));
    }
}
