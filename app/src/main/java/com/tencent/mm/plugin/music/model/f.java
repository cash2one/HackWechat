package com.tencent.mm.plugin.music.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.av.a;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.music.model.b.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class f {
    public static long hkx;
    public static boolean oJN;
    public static boolean oJO;
    public static int oJP;
    public static int oJQ;
    private static a oJR;
    public static int scene;

    public static final void S(int i, int i2, int i3) {
        if (h.bdz().bdo() != null) {
            x.v("MicroMsg.Music.MusicReportUtil", "kvReportShakeReport: %d, %d, %d, %s, %s, %s, %s, %d %s, %s", new Object[]{Integer.valueOf(13042), Integer.valueOf(i), Integer.valueOf(i2), h.bdz().bdo().field_musicId, h.bdz().bdo().field_songName, h.bdz().bdo().field_songAlbum, Integer.valueOf(h.bdz().bdo().field_songId), Integer.valueOf(i3), h.bdz().bdo().field_songSinger, h.bdz().bdo().field_appId});
            g.pQN.h(13042, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i3), r0.field_songSinger, r0.field_appId});
        }
    }

    public static final void cS(int i, int i2) {
        if (h.bdz().bdo() != null) {
            x.v("MicroMsg.Music.MusicReportUtil", "kvReportAction: %d, %s, %s, %s, %s, %d, %d, %s, %s", new Object[]{Integer.valueOf(13232), h.bdz().bdo().field_musicId, h.bdz().bdo().field_songName, h.bdz().bdo().field_songAlbum, Integer.valueOf(h.bdz().bdo().field_songId), Integer.valueOf(i2), Integer.valueOf(i), h.bdz().bdo().field_songSinger, h.bdz().bdo().field_appId});
            g.pQN.h(13232, new Object[]{r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i2), Integer.valueOf(i), r0.field_songSinger, r0.field_appId});
        }
    }

    public static synchronized void c(a aVar) {
        synchronized (f.class) {
            oJR = aVar;
        }
    }

    public static final synchronized void bdw() {
        int i = 1;
        synchronized (f.class) {
            if (oJR != null) {
                int i2;
                xS();
                String str = "MicroMsg.Music.MusicReportUtil";
                String str2 = "kvReportMusicPlayInfo: %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s";
                Object[] objArr = new Object[12];
                objArr[0] = Integer.valueOf(13044);
                objArr[1] = oJR.field_musicId;
                objArr[2] = oJR.field_songName;
                objArr[3] = oJR.field_songAlbum;
                objArr[4] = Integer.valueOf(oJR.field_songId);
                objArr[5] = Integer.valueOf(oJP);
                objArr[6] = Integer.valueOf(oJQ);
                objArr[7] = Integer.valueOf(oJN ? 1 : 2);
                objArr[8] = Integer.valueOf(oJO ? 1 : 2);
                objArr[9] = Integer.valueOf(scene);
                objArr[10] = oJR.field_songSinger;
                objArr[11] = oJR.field_appId;
                x.v(str, str2, objArr);
                g gVar = g.pQN;
                objArr = new Object[11];
                objArr[0] = oJR.field_musicId;
                objArr[1] = oJR.field_songName;
                objArr[2] = oJR.field_songAlbum;
                objArr[3] = Integer.valueOf(oJR.field_songId);
                objArr[4] = Integer.valueOf(oJP);
                objArr[5] = Integer.valueOf(oJQ);
                if (oJN) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                objArr[6] = Integer.valueOf(i2);
                if (!oJO) {
                    i = 2;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = Integer.valueOf(scene);
                objArr[9] = oJR.field_songSinger;
                objArr[10] = oJR.field_appId;
                gVar.h(13044, objArr);
            }
            oJR = null;
            oJN = false;
            oJO = false;
            oJP = 0;
            oJQ = 0;
            hkx = 0;
            scene = 0;
        }
    }

    public static final void xS() {
        if (hkx > 0) {
            oJQ = (int) (((long) oJQ) + ((System.currentTimeMillis() - hkx) / 1000));
            hkx = 0;
        }
    }

    public static final void bdx() {
        g.pQN.a(285, 4, 1, false);
    }

    public static final void tn(int i) {
        if (i == 2) {
            g.pQN.h(10651, new Object[]{Integer.valueOf(7), Integer.valueOf(1), Integer.valueOf(0)});
        }
    }

    public static final void to(int i) {
        if (i == 2) {
            g.pQN.h(10651, new Object[]{Integer.valueOf(7), Integer.valueOf(0), Integer.valueOf(0)});
        }
    }

    public static final void a(a aVar, boolean z) {
        if (aVar == null) {
            x.e("MicroMsg.Music.MusicReportUtil", "idKeyReportMusicPlayerSum music is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(558);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(558);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(558);
        iDKey3.SetValue(1);
        asv Qn = aVar.Qn();
        if (z) {
            iDKey3.SetKey(10);
        } else if (g.m(Qn)) {
            r0 = Qn.wAi;
            x.i("MicroMsg.Music.MusicReportUtil", "idKeyReportExoMusicPlayerSum scene:%d", new Object[]{Integer.valueOf(r0)});
            arrayList = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(797);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            iDKey2 = new IDKey();
            iDKey2.SetID(797);
            x.i("MicroMsg.ExoPlayerErrorHandler", "getExoMusicPlayerSumidKeyByMusicType, musicType:" + r0);
            switch (r0) {
                case 0:
                    r0 = 50;
                    break;
                case 1:
                    r0 = 51;
                    break;
                case 4:
                    r0 = 52;
                    break;
                case 6:
                    r0 = 53;
                    break;
                case 7:
                    r0 = 54;
                    break;
                case 8:
                    r0 = 55;
                    break;
                case 9:
                    r0 = 56;
                    break;
                case 10:
                    r0 = 57;
                    break;
                case 11:
                    r0 = 58;
                    break;
                default:
                    r0 = 59;
                    break;
            }
            iDKey2.SetKey(r0);
            iDKey2.SetValue(1);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g.pQN.a(arrayList, true);
            return;
        } else if (g.tr(aVar.field_musicType)) {
            iDKey3.SetKey(2);
            r0 = aVar.field_musicType;
            x.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerSumidKeyByMusicType, musicType:" + r0);
            switch (r0) {
                case 0:
                    r0 = 117;
                    break;
                case 1:
                    r0 = 118;
                    break;
                case 4:
                    r0 = 119;
                    break;
                case 5:
                    r0 = 120;
                    break;
                case 6:
                    r0 = 121;
                    break;
                case 7:
                    r0 = 122;
                    break;
                case 8:
                    r0 = 123;
                    break;
                case 9:
                    r0 = 124;
                    break;
                case 10:
                    r0 = 125;
                    break;
                case 11:
                    r0 = 126;
                    break;
                default:
                    r0 = 127;
                    break;
            }
            iDKey2.SetKey(r0);
            arrayList.add(iDKey2);
            g.pQN.h(14174, new Object[]{Integer.valueOf(1), Integer.valueOf(aVar.field_musicType)});
            if (d.Gj(aVar.hHQ)) {
                r0 = new IDKey();
                r0.SetID(558);
                r0.SetKey(com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX);
                r0.SetValue(1);
                arrayList.add(r0);
            }
        } else {
            iDKey3.SetKey(1);
            r0 = aVar.field_musicType;
            x.i("MicroMsg.PlayerErrorHandler", "getMusicPlayerSumidKeyByMusicType, musicType:" + r0);
            switch (r0) {
                case 0:
                    r0 = 105;
                    break;
                case 1:
                    r0 = 106;
                    break;
                case 4:
                    r0 = 107;
                    break;
                case 5:
                    r0 = 108;
                    break;
                case 6:
                    r0 = 109;
                    break;
                case 7:
                    r0 = 110;
                    break;
                case 8:
                    r0 = 111;
                    break;
                case 9:
                    r0 = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                    break;
                default:
                    r0 = 113;
                    break;
            }
            iDKey2.SetKey(r0);
            arrayList.add(iDKey2);
            g.pQN.h(14174, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType)});
            if (d.Gj(aVar.hHQ)) {
                r0 = new IDKey();
                r0.SetID(558);
                r0.SetKey(bp.CTRL_INDEX);
                r0.SetValue(1);
                arrayList.add(r0);
            }
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey3);
        g.pQN.a(arrayList, true);
    }

    public static final void tp(int i) {
        x.i("MicroMsg.Music.MusicReportUtil", "idKeyReportQQAudioPlayerSum scene:%d", new Object[]{Integer.valueOf(i)});
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(688);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(688);
        x.i("MicroMsg.PlayerErrorHandler", "getQQAudioPlayerSumIdKeyByScene, scene:" + i);
        switch (i) {
        }
        iDKey2.SetKey(2);
        iDKey2.SetValue(1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        g.pQN.a(arrayList, true);
    }

    public static final void tq(int i) {
        if (h.bdz().bdo() != null) {
            x.i("MicroMsg.Music.MusicReportUtil", "ReportMusicPlayerShareStat ShareType:%d, MusicId:%s, MusicTitle:%s, Singer:%s, AppId:%s", new Object[]{Integer.valueOf(i), h.bdz().bdo().field_musicId, h.bdz().bdo().field_songName, h.bdz().bdo().field_songSinger, h.bdz().bdo().field_appId});
            g.pQN.h(12836, new Object[]{Integer.valueOf(i), r0.field_musicId, r0.field_songName, r0.field_songSinger, r0.field_appId});
        }
    }

    public static void a(int i, a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat music is null, err");
            return;
        }
        x.i("MicroMsg.Music.MusicReportUtil", "kvReportMusicNotificationStat scene:%d, action:%d, src:%s, title:%s, singer:%s", new Object[]{Integer.valueOf(aVar.field_musicType), Integer.valueOf(i), aVar.field_songWifiUrl, aVar.field_songName, aVar.field_songSinger});
        g.pQN.h(15106, new Object[]{Integer.valueOf(aVar.field_musicType), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()), aVar.field_songWifiUrl, aVar.field_songName, aVar.field_songSinger});
    }
}
