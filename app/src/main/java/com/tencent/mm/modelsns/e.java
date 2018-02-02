package com.tencent.mm.modelsns;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.mm.a.g;
import com.tencent.mm.bv.a;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqt;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.bjs;
import com.tencent.mm.protocal.c.bme;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.bxv;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.protocal.c.cp;
import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.protocal.c.cv;
import com.tencent.mm.protocal.c.cw;
import com.tencent.mm.protocal.c.pb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class e {
    private static float mE(String str) {
        if (str == null) {
            return 0.0f;
        }
        return bh.getFloat(str, 0.0f);
    }

    private static String mF(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static bnp SA() {
        bnp com_tencent_mm_protocal_c_bnp = new bnp();
        pb pbVar = new pb();
        com_tencent_mm_protocal_c_bnp.wQn = new cu();
        com_tencent_mm_protocal_c_bnp.wQo = pbVar;
        com_tencent_mm_protocal_c_bnp.wxG = 0;
        com_tencent_mm_protocal_c_bnp.pbl = 0;
        com_tencent_mm_protocal_c_bnp.nGJ = "";
        aoy com_tencent_mm_protocal_c_aoy = new aoy();
        com_tencent_mm_protocal_c_aoy.vQu = 0.0f;
        com_tencent_mm_protocal_c_aoy.vQt = 0.0f;
        com_tencent_mm_protocal_c_bnp.wQm = com_tencent_mm_protocal_c_aoy;
        com_tencent_mm_protocal_c_bnp.rLO = "";
        com_tencent_mm_protocal_c_bnp.wQu = new bxv();
        return com_tencent_mm_protocal_c_bnp;
    }

    public static aqr SB() {
        aqr com_tencent_mm_protocal_c_aqr = new aqr();
        com_tencent_mm_protocal_c_aqr.nfe = "";
        com_tencent_mm_protocal_c_aqr.wxG = 0;
        return com_tencent_mm_protocal_c_aqr;
    }

    public static aqr a(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        aqr com_tencent_mm_protocal_c_aqr = new aqr();
        com_tencent_mm_protocal_c_aqr.nGJ = str;
        com_tencent_mm_protocal_c_aqr.ktN = i;
        com_tencent_mm_protocal_c_aqr.nfX = str2;
        com_tencent_mm_protocal_c_aqr.wxE = str3;
        com_tencent_mm_protocal_c_aqr.wxD = i2;
        com_tencent_mm_protocal_c_aqr.wxF = i3;
        com_tencent_mm_protocal_c_aqr.nfe = str4;
        aqt com_tencent_mm_protocal_c_aqt = new aqt();
        com_tencent_mm_protocal_c_aqt.wyv = 0.0f;
        com_tencent_mm_protocal_c_aqt.wyu = 0.0f;
        com_tencent_mm_protocal_c_aqt.wyw = 0.0f;
        com_tencent_mm_protocal_c_aqr.wxH = com_tencent_mm_protocal_c_aqt;
        com_tencent_mm_protocal_c_aqr.wxS = g.s(str2 == null ? "".getBytes() : str2.getBytes());
        return com_tencent_mm_protocal_c_aqr;
    }

    public static aqr a(String str, int i, String str2, String str3, int i2, int i3, int i4, String str4, aqt com_tencent_mm_protocal_c_aqt) {
        aqr com_tencent_mm_protocal_c_aqr = new aqr();
        com_tencent_mm_protocal_c_aqr.nGJ = mF(str);
        com_tencent_mm_protocal_c_aqr.ktN = i;
        com_tencent_mm_protocal_c_aqr.nfe = mF(str4);
        com_tencent_mm_protocal_c_aqr.nfX = mF(str2);
        com_tencent_mm_protocal_c_aqr.wxD = i2;
        com_tencent_mm_protocal_c_aqr.wxE = mF(str3);
        com_tencent_mm_protocal_c_aqr.wxF = i3;
        com_tencent_mm_protocal_c_aqr.wxG = i4;
        com_tencent_mm_protocal_c_aqr.wxH = com_tencent_mm_protocal_c_aqt;
        com_tencent_mm_protocal_c_aqr.wxS = g.s(str2 == null ? "".getBytes() : str2.getBytes());
        return com_tencent_mm_protocal_c_aqr;
    }

    public static bnp mG(String str) {
        Map y = bi.y(str, "TimelineObject");
        bnp SA = SA();
        if (y == null) {
            return SA;
        }
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int indexOf;
        int indexOf2;
        bnp com_tencent_mm_protocal_c_bnp;
        SA.nGJ = mF((String) y.get(".TimelineObject.id"));
        SA.ksU = mF((String) y.get(".TimelineObject.username"));
        SA.wxG = bh.getInt((String) y.get(".TimelineObject.private"), 0);
        SA.pbl = bh.getInt((String) y.get(".TimelineObject.createTime"), 0);
        SA.wQl = mF((String) y.get(".TimelineObject.contentDesc"));
        SA.wQq = bh.getInt((String) y.get(".TimelineObject.contentDescShowType"), 0);
        SA.wQr = bh.getInt((String) y.get(".TimelineObject.contentDescScene"), 0);
        SA.rtA = mF((String) y.get(".TimelineObject.statExtStr"));
        SA.wQv = bh.getInt((String) y.get(".TimelineObject.sightFolded"), 0);
        aoy com_tencent_mm_protocal_c_aoy = new aoy();
        com_tencent_mm_protocal_c_aoy.vQt = mE((String) y.get(".TimelineObject.location.$longitude"));
        com_tencent_mm_protocal_c_aoy.vQu = mE((String) y.get(".TimelineObject.location.$latitude"));
        com_tencent_mm_protocal_c_aoy.hvv = mF((String) y.get(".TimelineObject.location.$city"));
        com_tencent_mm_protocal_c_aoy.wvJ = bh.getInt((String) y.get(".TimelineObject.location.$poiScale"), 0);
        com_tencent_mm_protocal_c_aoy.wvH = mF((String) y.get(".TimelineObject.location.$poiClassifyId"));
        com_tencent_mm_protocal_c_aoy.rug = bh.getInt((String) y.get(".TimelineObject.location.$poiClassifyType"), 0);
        com_tencent_mm_protocal_c_aoy.rue = mF((String) y.get(".TimelineObject.location.$poiAddress"));
        com_tencent_mm_protocal_c_aoy.nTe = mF((String) y.get(".TimelineObject.location.$poiName"));
        com_tencent_mm_protocal_c_aoy.wvK = bh.getInt((String) y.get(".TimelineObject.location.$poiClickableStatus"), 0);
        com_tencent_mm_protocal_c_aoy.wvM = mF((String) y.get(".TimelineObject.location.$poiAddressName"));
        com_tencent_mm_protocal_c_aoy.country = mF((String) y.get(".TimelineObject.location.$country"));
        SA.wQm = com_tencent_mm_protocal_c_aoy;
        String str7 = ".TimelineObject.ContentObject.description";
        String str8 = ".TimelineObject.ContentObject.contentStyle";
        String str9 = ".TimelineObject.ContentObject.contentSubStyle";
        String str10 = ".TimelineObject.ContentObject.title";
        String str11 = ".TimelineObject.ContentObject.contentUrl";
        if (SA.wQo == null) {
            SA.wQo = new pb();
        }
        SA.wQo.nfe = mF((String) y.get(str7));
        SA.wQo.vYc = bh.getInt((String) y.get(str8), 0);
        SA.wQo.vYe = bh.getInt((String) y.get(str9), 0);
        SA.wQo.fon = mF((String) y.get(str10));
        SA.wQo.nfX = mF((String) y.get(str11));
        int i = 0;
        while (true) {
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            String str19;
            String str20;
            String str21;
            String str22;
            String str23;
            String str24;
            String str25;
            String str26;
            String str27;
            String str28;
            String str29;
            String str30;
            String str31;
            String str32;
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            Object obj10;
            Object obj11;
            if (i != 0) {
                str12 = ".TimelineObject.ContentObject.mediaList.media" + i + ".id";
                str13 = ".TimelineObject.ContentObject.mediaList.media" + i + ".type";
                str14 = ".TimelineObject.ContentObject.mediaList.media" + i + ".title";
                str15 = ".TimelineObject.ContentObject.mediaList.media" + i + ".description";
                str16 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url";
                str17 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$videomd5";
                str18 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb";
                str19 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$type";
                str20 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$type";
                str21 = ".TimelineObject.ContentObject.mediaList.media" + i + ".private";
                str22 = ".TimelineObject.ContentObject.mediaList.media" + i + ".subType";
                str23 = ".TimelineObject.ContentObject.mediaList.media" + i + ".userData";
                str24 = ".TimelineObject.ContentObject.mediaList.media" + i;
                str25 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl";
                str26 = ".TimelineObject.ContentObject.mediaList.media" + i + ".lowBandUrl.$type";
                str27 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl";
                str28 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachUrl.$md5";
                str29 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$md5";
                str30 = ".TimelineObject.ContentObject.mediaList.media" + i + ".videosize.$attachTotalTime";
                str2 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachThumbUrl";
                str3 = ".TimelineObject.ContentObject.mediaList.media" + i + ".attachShareTitle";
                str4 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc";
                str5 = ".TimelineObject.ContentObject.mediaList.media" + i + ".enc.$key";
                str6 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$token";
                str11 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$enc_idx";
                str10 = ".TimelineObject.ContentObject.mediaList.media" + i + ".url.$key";
                str9 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$token";
                str8 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$enc_idx";
                str31 = str14;
                str32 = str26;
                str26 = str15;
                str14 = ".TimelineObject.ContentObject.mediaList.media" + i + ".thumb.$key";
                str7 = str24;
                str15 = str8;
                str24 = str30;
                obj = str25;
                str25 = str29;
                obj2 = str16;
                str16 = str9;
                String str33 = str3;
                obj3 = str19;
                str19 = str4;
                obj4 = str17;
                str17 = str10;
                obj5 = str13;
                str13 = str5;
                obj6 = str18;
                str18 = str11;
                obj7 = str12;
                str12 = str6;
                obj8 = str21;
                str21 = str2;
                obj9 = str20;
                str20 = str33;
                String str34 = str22;
                str22 = str28;
                obj10 = str34;
                String str35 = str23;
                str23 = str27;
                obj11 = str35;
            } else {
                str31 = ".TimelineObject.ContentObject.mediaList.media.title";
                str32 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl.$type";
                str26 = ".TimelineObject.ContentObject.mediaList.media.description";
                str14 = ".TimelineObject.ContentObject.mediaList.media.thumb.$key";
                str7 = ".TimelineObject.ContentObject.mediaList.media";
                str15 = ".TimelineObject.ContentObject.mediaList.media.thumb.$enc_idx";
                str24 = ".TimelineObject.ContentObject.mediaList.media.videosize.$attachTotalTime";
                str30 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl";
                str25 = ".TimelineObject.ContentObject.mediaList.media.url.$md5";
                str29 = ".TimelineObject.ContentObject.mediaList.media.url";
                str16 = ".TimelineObject.ContentObject.mediaList.media.thumb.$token";
                str3 = ".TimelineObject.ContentObject.mediaList.media.url.$type";
                str19 = ".TimelineObject.ContentObject.mediaList.media.enc";
                str4 = ".TimelineObject.ContentObject.mediaList.media.url.$videomd5";
                str17 = ".TimelineObject.ContentObject.mediaList.media.url.$key";
                str10 = ".TimelineObject.ContentObject.mediaList.media.type";
                str13 = ".TimelineObject.ContentObject.mediaList.media.enc.$key";
                str5 = ".TimelineObject.ContentObject.mediaList.media.thumb";
                str18 = ".TimelineObject.ContentObject.mediaList.media.url.$enc_idx";
                str11 = ".TimelineObject.ContentObject.mediaList.media.id";
                str12 = ".TimelineObject.ContentObject.mediaList.media.url.$token";
                str6 = ".TimelineObject.ContentObject.mediaList.media.private";
                str21 = ".TimelineObject.ContentObject.mediaList.media.attachThumbUrl";
                str2 = ".TimelineObject.ContentObject.mediaList.media.thumb.$type";
                str20 = ".TimelineObject.ContentObject.mediaList.media.attachShareTitle";
                str22 = ".TimelineObject.ContentObject.mediaList.media.attachUrl.$md5";
                str28 = ".TimelineObject.ContentObject.mediaList.media.subType";
                str23 = ".TimelineObject.ContentObject.mediaList.media.attachUrl";
                str27 = ".TimelineObject.ContentObject.mediaList.media.userData";
            }
            str8 = str7 + ".size.$width";
            str9 = str7 + ".size.$height";
            String str36 = str7 + ".size.$totalSize";
            str7 = (String) y.get(str8);
            str8 = (String) y.get(str9);
            str9 = (String) y.get(str36);
            aqt com_tencent_mm_protocal_c_aqt = new aqt();
            com_tencent_mm_protocal_c_aqt.wyv = 0.0f;
            com_tencent_mm_protocal_c_aqt.wyu = 0.0f;
            com_tencent_mm_protocal_c_aqt.wyw = 0.0f;
            if (str7 != null) {
                com_tencent_mm_protocal_c_aqt.wyu = mE(str7);
            }
            if (str8 != null) {
                com_tencent_mm_protocal_c_aqt.wyv = mE(str8);
            }
            if (str9 != null) {
                com_tencent_mm_protocal_c_aqt.wyw = mE(str9);
            }
            str7 = (String) y.get(obj7);
            str8 = (String) y.get(obj5);
            str9 = (String) y.get(str31);
            str10 = (String) y.get(str26);
            str11 = (String) y.get(obj2);
            str6 = (String) y.get(obj8);
            str5 = (String) y.get(obj6);
            str4 = (String) y.get(obj4);
            str3 = (String) y.get(obj3);
            str2 = (String) y.get(obj9);
            str30 = (String) y.get(obj);
            str29 = (String) y.get(str32);
            str28 = (String) y.get(obj10);
            str27 = (String) y.get(obj11);
            str23 = (String) y.get(str23);
            str22 = (String) y.get(str22);
            str25 = (String) y.get(str25);
            str24 = (String) y.get(str24);
            str21 = (String) y.get(str21);
            str20 = (String) y.get(str20);
            str19 = (String) y.get(str19);
            str13 = (String) y.get(str13);
            str12 = (String) y.get(str12);
            str18 = (String) y.get(str18);
            str17 = (String) y.get(str17);
            str16 = (String) y.get(str16);
            str15 = (String) y.get(str15);
            str14 = (String) y.get(str14);
            if (str8 == null || str7 == null) {
                indexOf = str.indexOf("<noteinfo>");
                indexOf2 = str.indexOf("</noteinfo>");
            } else {
                aqr com_tencent_mm_protocal_c_aqr = new aqr();
                com_tencent_mm_protocal_c_aqr.nGJ = mF(str7);
                com_tencent_mm_protocal_c_aqr.ktN = bh.getInt(str8, 0);
                com_tencent_mm_protocal_c_aqr.fon = mF(str9);
                com_tencent_mm_protocal_c_aqr.nfe = mF(str10);
                com_tencent_mm_protocal_c_aqr.nfX = mF(str11);
                com_tencent_mm_protocal_c_aqr.wxD = bh.getInt(str3, 0);
                com_tencent_mm_protocal_c_aqr.wxE = mF(str5);
                com_tencent_mm_protocal_c_aqr.wxF = bh.getInt(str2, 0);
                com_tencent_mm_protocal_c_aqr.wxG = bh.getInt(str6, 0);
                com_tencent_mm_protocal_c_aqr.wxH = com_tencent_mm_protocal_c_aqt;
                com_tencent_mm_protocal_c_aqr.wxI = mF(str30);
                com_tencent_mm_protocal_c_aqr.wxJ = bh.getInt(str29, 0);
                com_tencent_mm_protocal_c_aqr.rsn = mF(str27);
                com_tencent_mm_protocal_c_aqr.fpn = bh.getInt(str28, 0);
                com_tencent_mm_protocal_c_aqr.wxL = mF(str23);
                com_tencent_mm_protocal_c_aqr.wxN = mF(str22);
                com_tencent_mm_protocal_c_aqr.wxM = mF(str25);
                com_tencent_mm_protocal_c_aqr.wxZ = mF(str4);
                com_tencent_mm_protocal_c_aqr.rNe = bh.getInt(str24, 0);
                com_tencent_mm_protocal_c_aqr.wxO = mF(str21);
                com_tencent_mm_protocal_c_aqr.wxP = mF(str20);
                com_tencent_mm_protocal_c_aqr.wxQ = bh.getInt(str19, 0);
                com_tencent_mm_protocal_c_aqr.wxR = bh.getLong(str13, 0);
                com_tencent_mm_protocal_c_aqr.wxS = g.s(com_tencent_mm_protocal_c_aqr.nfX == null ? "".getBytes() : com_tencent_mm_protocal_c_aqr.nfX.getBytes());
                com_tencent_mm_protocal_c_aqr.wxT = str12;
                com_tencent_mm_protocal_c_aqr.wxU = bh.getInt(str18, 0);
                com_tencent_mm_protocal_c_aqr.wxV = str17;
                com_tencent_mm_protocal_c_aqr.wxW = str16;
                com_tencent_mm_protocal_c_aqr.wxX = bh.getInt(str15, 0);
                com_tencent_mm_protocal_c_aqr.wxY = str14;
                SA.wQo.vYd.add(com_tencent_mm_protocal_c_aqr);
                i++;
            }
        }
        indexOf = str.indexOf("<noteinfo>");
        indexOf2 = str.indexOf("</noteinfo>");
        if (indexOf < 0 || indexOf2 < 0) {
            com_tencent_mm_protocal_c_bnp = SA;
        } else {
            SA.wQo.vYf = str.substring(indexOf, indexOf2 + 11);
            com_tencent_mm_protocal_c_bnp = SA;
        }
        cu cuVar = new cu();
        str10 = mF((String) y.get(".TimelineObject.appInfo.id"));
        str11 = mF((String) y.get(".TimelineObject.appInfo.version"));
        str6 = mF((String) y.get(".TimelineObject.appInfo.appName"));
        str5 = mF((String) y.get(".TimelineObject.appInfo.installUrl "));
        str7 = mF((String) y.get(".TimelineObject.appInfo.fromUrl "));
        cuVar.nGJ = str10;
        cuVar.niZ = str6;
        cuVar.vHL = str5;
        cuVar.vHM = str7;
        cuVar.ktA = str11;
        cuVar.vHN = bh.getInt((String) y.get(".TimelineObject.appInfo.clickable"), 0);
        com_tencent_mm_protocal_c_bnp.wQn = cuVar;
        bxv com_tencent_mm_protocal_c_bxv = new bxv();
        str10 = mF((String) y.get(".TimelineObject.weappInfo.appUserName"));
        str7 = mF((String) y.get(".TimelineObject.weappInfo.pagePath"));
        com_tencent_mm_protocal_c_bxv.username = str10;
        com_tencent_mm_protocal_c_bxv.path = str7;
        com_tencent_mm_protocal_c_bnp.wQu = com_tencent_mm_protocal_c_bxv;
        bme com_tencent_mm_protocal_c_bme = new bme();
        str10 = mF((String) y.get(".TimelineObject.streamvideo.streamvideotitle"));
        str11 = mF((String) y.get(".TimelineObject.streamvideo.streamvideototaltime"));
        str6 = mF((String) y.get(".TimelineObject.streamvideo.streamvideourl"));
        str5 = mF((String) y.get(".TimelineObject.streamvideo.streamvideoweburl"));
        str4 = mF((String) y.get(".TimelineObject.streamvideo.streamvideowording"));
        str3 = mF((String) y.get(".TimelineObject.streamvideo.streamvideothumburl"));
        str2 = mF((String) y.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
        str7 = mF((String) y.get(".TimelineObject.streamvideo.streamvideopublishid"));
        com_tencent_mm_protocal_c_bme.hdq = str10;
        com_tencent_mm_protocal_c_bme.hdp = bh.VI(str11);
        com_tencent_mm_protocal_c_bme.hdo = str6;
        com_tencent_mm_protocal_c_bme.hds = str5;
        com_tencent_mm_protocal_c_bme.hdr = str4;
        com_tencent_mm_protocal_c_bme.hdt = str3;
        com_tencent_mm_protocal_c_bme.hdu = str2;
        com_tencent_mm_protocal_c_bme.hdv = str7;
        com_tencent_mm_protocal_c_bnp.wQt = com_tencent_mm_protocal_c_bme;
        bjs com_tencent_mm_protocal_c_bjs = new bjs();
        str10 = mF((String) y.get(".TimelineObject.redEnvelopesInfo.sendId"));
        str7 = mF((String) y.get(".TimelineObject.redEnvelopesInfo.ticket"));
        com_tencent_mm_protocal_c_bjs.nZa = str10;
        com_tencent_mm_protocal_c_bjs.frP = str7;
        at atVar = new at();
        int i2 = bh.getInt((String) y.get(".TimelineObject.actionInfo.scene"), 0);
        str11 = mF((String) y.get(".TimelineObject.actionInfo.appid"));
        int i3 = bh.getInt((String) y.get(".TimelineObject.actionInfo.type"), 0);
        str5 = mF((String) y.get(".TimelineObject.actionInfo.url"));
        str4 = mF((String) y.get(".TimelineObject.actionInfo.mediaTagName"));
        str7 = mF((String) y.get(".TimelineObject.actionInfo.wordingKey"));
        atVar.vFF = str11;
        atVar.rYW = i2;
        atVar.ktN = i3;
        atVar.nfX = str5;
        atVar.vFG = str4;
        atVar.vFH = str7;
        ar arVar = new ar();
        str11 = mF((String) y.get(".TimelineObject.actionInfo.appMsg.appid"));
        str6 = mF((String) y.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
        str5 = mF((String) y.get(".TimelineObject.actionInfo.appMsg.messageExt"));
        str7 = mF((String) y.get(".TimelineObject.actionInfo.appMsg.messageAction"));
        arVar.ngo = str11;
        arVar.vFC = str6;
        arVar.vFD = str5;
        arVar.vFE = str7;
        atVar.vFI = arVar;
        i2 = bh.getInt((String) y.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
        int i4 = bh.getInt((String) y.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
        str6 = mF((String) y.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
        str5 = mF((String) y.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
        atVar.vFJ = mF((String) y.get(".TimelineObject.actionInfo.newWordingKey"));
        cp cpVar = new cp();
        cpVar.vHE = i2;
        cpVar.vHF = i4;
        cw cwVar = new cw();
        cwVar.vHR = str6;
        cwVar.vHS = str5;
        atVar.vFK = cpVar;
        atVar.vFL = cwVar;
        atVar.vFM = mH((String) y.get(".TimelineObject.actionInfo.installedWording"));
        atVar.vFN = mH((String) y.get(".TimelineObject.actionInfo.uninstalledWording"));
        com_tencent_mm_protocal_c_bnp.qYu = atVar;
        com_tencent_mm_protocal_c_bnp.vmS = mF((String) y.get(".TimelineObject.sourceUserName"));
        com_tencent_mm_protocal_c_bnp.vmT = mF((String) y.get(".TimelineObject.sourceNickName"));
        com_tencent_mm_protocal_c_bnp.wQp = mF((String) y.get(".TimelineObject.publicUserName"));
        com_tencent_mm_protocal_c_bnp.wQs = mF((String) y.get(".TimelineObject.statisticsData"));
        com_tencent_mm_protocal_c_bnp.rLO = mF((String) y.get(".TimelineObject.canvasInfoXml"));
        com_tencent_mm_protocal_c_bnp.hbg = bh.getInt((String) y.get(".TimelineObject.contentattr"), 0);
        bzu com_tencent_mm_protocal_c_bzu = new bzu();
        com_tencent_mm_protocal_c_bzu.tnm = mF((String) y.get(".TimelineObject.websearch.relevant_vid"));
        com_tencent_mm_protocal_c_bzu.tnn = mF((String) y.get(".TimelineObject.websearch.relevant_expand"));
        com_tencent_mm_protocal_c_bzu.tno = mF((String) y.get(".TimelineObject.websearch.relevant_pre_searchid"));
        com_tencent_mm_protocal_c_bzu.tnp = mF((String) y.get(".TimelineObject.websearch.relevant_shared_openid"));
        com_tencent_mm_protocal_c_bzu.tnq = bh.getLong((String) y.get(".TimelineObject.websearch.rec_category"), 0);
        com_tencent_mm_protocal_c_bzu.lOX = mF((String) y.get(".TimelineObject.websearch.shareUrl"));
        com_tencent_mm_protocal_c_bzu.lOY = mF((String) y.get(".TimelineObject.websearch.shareTitle"));
        com_tencent_mm_protocal_c_bzu.rfu = mF((String) y.get(".TimelineObject.websearch.shareDesc"));
        com_tencent_mm_protocal_c_bzu.sez = mF((String) y.get(".TimelineObject.websearch.shareImgUrl"));
        com_tencent_mm_protocal_c_bzu.seA = mF((String) y.get(".TimelineObject.websearch.shareString"));
        com_tencent_mm_protocal_c_bzu.seB = mF((String) y.get(".TimelineObject.websearch.shareStringUrl"));
        com_tencent_mm_protocal_c_bzu.bhd = mF((String) y.get(".TimelineObject.websearch.source"));
        com_tencent_mm_protocal_c_bzu.pes = mF((String) y.get(".TimelineObject.websearch.sourceUrl"));
        com_tencent_mm_protocal_c_bzu.seF = mF((String) y.get(".TimelineObject.websearch.strPlayCount"));
        com_tencent_mm_protocal_c_bzu.seG = mF((String) y.get(".TimelineObject.websearch.titleUrl"));
        com_tencent_mm_protocal_c_bnp.qYw = com_tencent_mm_protocal_c_bzu;
        return com_tencent_mm_protocal_c_bnp;
    }

    private static cv mH(String str) {
        if (bh.ov(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int i = 0;
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '&') {
                stringBuilder.append(charAt);
                i++;
            } else if (str.startsWith("&amp;", i)) {
                stringBuilder.append('&');
                i += 5;
            } else if (str.startsWith("&apos;", i)) {
                stringBuilder.append('\'');
                i += 6;
            } else if (str.startsWith("&quot;", i)) {
                stringBuilder.append('\"');
                i += 6;
            } else if (str.startsWith("&lt;", i)) {
                stringBuilder.append('<');
                i += 4;
            } else if (str.startsWith("&gt;", i)) {
                stringBuilder.append('>');
                i += 4;
            }
        }
        Map y = bi.y("<root>" + stringBuilder.toString() + "</root>", "root");
        cv cvVar = new cv();
        cvVar.vHO = mF((String) y.get(".root.en"));
        cvVar.vHP = mF((String) y.get(".root.zh-CN"));
        cvVar.vHQ = mF((String) y.get(".root.zh-TW"));
        return cvVar;
    }

    public static Pair<Integer, Integer> a(bnp com_tencent_mm_protocal_c_bnp, Context context, boolean z) {
        int i;
        int i2;
        int i3;
        DisplayMetrics displayMetrics;
        int i4;
        int fromDPToPix;
        int fromDPToPix2;
        if (!(com_tencent_mm_protocal_c_bnp == null || com_tencent_mm_protocal_c_bnp.wQo == null || com_tencent_mm_protocal_c_bnp.wQo.vYd == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.size() <= 0)) {
            aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
            if (com_tencent_mm_protocal_c_aqr != null && com_tencent_mm_protocal_c_aqr.wxH != null && com_tencent_mm_protocal_c_aqr.wxH.wyu > 0.0f && com_tencent_mm_protocal_c_aqr.wxH.wyv > 0.0f) {
                i = (int) com_tencent_mm_protocal_c_aqr.wxH.wyu;
                i2 = (int) com_tencent_mm_protocal_c_aqr.wxH.wyv;
                if (i <= 0) {
                    i = 320;
                }
                if (i2 > 0) {
                    i3 = 240;
                } else {
                    i3 = i2;
                }
                if (context != null) {
                    x.e("MicroMsg.TimeLineHelper", "the context is null");
                    return Pair.create(Integer.valueOf(i), Integer.valueOf(i3));
                }
                displayMetrics = context.getResources().getDisplayMetrics();
                if (displayMetrics == null) {
                    i2 = (int) Math.min(((float) displayMetrics.widthPixels) * 0.63f, ((float) displayMetrics.heightPixels) * 0.63f);
                } else {
                    i2 = i;
                }
                i4 = (i2 >> 5) << 5;
                if (i < i3 && context != null) {
                    i4 = Math.min(b.b(context, 160.0f), i4);
                }
                i2 = (int) (((((double) i4) * 1.0d) * ((double) i3)) / ((double) i));
                if (!z) {
                    fromDPToPix = a.fromDPToPix(context, 200);
                    fromDPToPix2 = a.fromDPToPix(context, 44);
                    if (i2 < i4) {
                        if (i2 > fromDPToPix) {
                            i2 = fromDPToPix;
                        }
                        i4 = (int) (((((float) i) * 1.0f) / ((float) i3)) * ((float) i2));
                        if (i4 < fromDPToPix2) {
                            i2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i3)) / ((double) i));
                            x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                            return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                        }
                    }
                    if (i4 > fromDPToPix) {
                        i4 = fromDPToPix;
                    }
                    i2 = (int) (((((float) i3) * 1.0f) / ((float) i)) * ((float) i4));
                    if (i2 < fromDPToPix2) {
                        int i5 = fromDPToPix2;
                        fromDPToPix2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i)) / ((double) i3));
                        i2 = i5;
                        x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                        return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                    }
                }
                fromDPToPix2 = i4;
                x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
            }
        }
        i2 = 0;
        i = 0;
        if (i <= 0) {
            i = 320;
        }
        if (i2 > 0) {
            i3 = i2;
        } else {
            i3 = 240;
        }
        if (context != null) {
            displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics == null) {
                i2 = i;
            } else {
                i2 = (int) Math.min(((float) displayMetrics.widthPixels) * 0.63f, ((float) displayMetrics.heightPixels) * 0.63f);
            }
            i4 = (i2 >> 5) << 5;
            i4 = Math.min(b.b(context, 160.0f), i4);
            i2 = (int) (((((double) i4) * 1.0d) * ((double) i3)) / ((double) i));
            if (z) {
                fromDPToPix = a.fromDPToPix(context, 200);
                fromDPToPix2 = a.fromDPToPix(context, 44);
                if (i2 < i4) {
                    if (i4 > fromDPToPix) {
                        i4 = fromDPToPix;
                    }
                    i2 = (int) (((((float) i3) * 1.0f) / ((float) i)) * ((float) i4));
                    if (i2 < fromDPToPix2) {
                        int i52 = fromDPToPix2;
                        fromDPToPix2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i)) / ((double) i3));
                        i2 = i52;
                        x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                        return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                    }
                }
                if (i2 > fromDPToPix) {
                    i2 = fromDPToPix;
                }
                i4 = (int) (((((float) i) * 1.0f) / ((float) i3)) * ((float) i2));
                if (i4 < fromDPToPix2) {
                    i2 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i3)) / ((double) i));
                    x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
                    return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
                }
            }
            fromDPToPix2 = i4;
            x.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(fromDPToPix2), Integer.valueOf(i2), Boolean.valueOf(z)});
            return Pair.create(Integer.valueOf(fromDPToPix2), Integer.valueOf(i2));
        }
        x.e("MicroMsg.TimeLineHelper", "the context is null");
        return Pair.create(Integer.valueOf(i), Integer.valueOf(i3));
    }
}
