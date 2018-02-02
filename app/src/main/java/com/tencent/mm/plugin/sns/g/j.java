package com.tencent.mm.plugin.sns.g;

import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.blr;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class j {
    public static String kmR = "]]>";
    public static String kmS = "<TimelineObject>";
    public static String kmT = "</TimelineObject>";

    static class a {
        StringBuffer kmW = new StringBuffer();

        a() {
        }

        public final void vs(String str) {
            this.kmW.append("<" + str + ">");
        }

        public final void vt(String str) {
            this.kmW.append("</" + str + ">");
        }

        public final void setText(String str) {
            if (!bh.ov(str)) {
                if (str.contains(j.kmR)) {
                    this.kmW.append("<![CDATA[" + bh.VG(str) + "]]>");
                } else {
                    this.kmW.append("<![CDATA[" + str + "]]>");
                }
            }
        }

        public final void wS(int i) {
            this.kmW.append(i);
        }

        public final void g(String str, Map<String, String> map) {
            this.kmW.append("<" + str);
            for (String str2 : map.keySet()) {
                this.kmW.append(" " + str2 + "=\"" + ((String) map.get(str2)) + "\" ");
            }
            this.kmW.append(">");
            map.clear();
        }
    }

    private static String KR(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private static String KS(String str) {
        if (bh.ov(str)) {
            return "";
        }
        return (str.matches("\\d*") ? 1 : null) == null ? "" : str;
    }

    public static String b(bnp com_tencent_mm_protocal_c_bnp) {
        String replace;
        a aVar = new a();
        Map hashMap = new HashMap();
        aVar.vs("TimelineObject");
        aVar.vs(SlookAirButtonFrequentContactAdapter.ID);
        if (com_tencent_mm_protocal_c_bnp.nGJ == null || com_tencent_mm_protocal_c_bnp.nGJ.equals("")) {
            aVar.setText("0");
        } else {
            aVar.setText(com_tencent_mm_protocal_c_bnp.nGJ);
        }
        aVar.vt(SlookAirButtonFrequentContactAdapter.ID);
        if (com_tencent_mm_protocal_c_bnp.ksU != null) {
            aVar.vs("username");
            aVar.setText(com_tencent_mm_protocal_c_bnp.ksU);
            aVar.vt("username");
        }
        aVar.vs("createTime");
        aVar.setText(com_tencent_mm_protocal_c_bnp.pbl);
        aVar.vt("createTime");
        aVar.vs("contentDescShowType");
        aVar.wS(com_tencent_mm_protocal_c_bnp.wQq);
        aVar.vt("contentDescShowType");
        aVar.vs("contentDescScene");
        aVar.wS(com_tencent_mm_protocal_c_bnp.wQr);
        aVar.vt("contentDescScene");
        aVar.vs("private");
        aVar.setText(com_tencent_mm_protocal_c_bnp.wxG);
        aVar.vt("private");
        if (!(com_tencent_mm_protocal_c_bnp.wQn == null || bh.ov(com_tencent_mm_protocal_c_bnp.wQn.nGJ))) {
            aVar.vs("appInfo");
            aVar.vs(SlookAirButtonFrequentContactAdapter.ID);
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQn.nGJ));
            aVar.vt(SlookAirButtonFrequentContactAdapter.ID);
            aVar.vs("version");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQn.ktA));
            aVar.vt("version");
            aVar.vs("appName");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQn.niZ));
            aVar.vt("appName");
            aVar.vs("installUrl");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQn.vHL));
            aVar.vt("installUrl");
            aVar.vs("fromUrl");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQn.vHM));
            aVar.vt("fromUrl");
            aVar.vt("appInfo");
        }
        if (!(com_tencent_mm_protocal_c_bnp.wQt == null || bh.ov(com_tencent_mm_protocal_c_bnp.wQt.hdo))) {
            aVar.vs("streamvideo");
            aVar.vs("streamvideourl");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQt.hdo));
            aVar.vt("streamvideourl");
            aVar.vs("streamvideototaltime");
            aVar.wS(com_tencent_mm_protocal_c_bnp.wQt.hdp);
            aVar.vt("streamvideototaltime");
            aVar.vs("streamvideotitle");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQt.hdq));
            aVar.vt("streamvideotitle");
            aVar.vs("streamvideowording");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQt.hdr));
            aVar.vt("streamvideowording");
            aVar.vs("streamvideoweburl");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQt.hds));
            aVar.vt("streamvideoweburl");
            aVar.vs("streamvideothumburl");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQt.hdt));
            aVar.vt("streamvideothumburl");
            aVar.vs("streamvideoaduxinfo");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQt.hdu));
            aVar.vt("streamvideoaduxinfo");
            aVar.vs("streamvideopublishid");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQt.hdv));
            aVar.vt("streamvideopublishid");
            aVar.vt("streamvideo");
        }
        if (!(com_tencent_mm_protocal_c_bnp.qYw == null || bh.ov(com_tencent_mm_protocal_c_bnp.qYw.tnm))) {
            aVar.vs("websearch");
            aVar.vs("relevant_vid");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.tnm));
            aVar.vt("relevant_vid");
            aVar.vs("relevant_expand");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.tnn));
            aVar.vt("relevant_expand");
            aVar.vs("relevant_pre_searchid");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.tno));
            aVar.vt("relevant_pre_searchid");
            aVar.vs("relevant_shared_openid");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.tnp));
            aVar.vt("relevant_shared_openid");
            aVar.vs("rec_category");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.tnq));
            aVar.vt("rec_category");
            aVar.vs("shareUrl");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.lOX));
            aVar.vt("shareUrl");
            aVar.vs("shareTitle");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.lOY));
            aVar.vt("shareTitle");
            aVar.vs("shareDesc");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.rfu));
            aVar.vt("shareDesc");
            aVar.vs("shareImgUrl");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.sez));
            aVar.vt("shareImgUrl");
            aVar.vs("shareString");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.seA));
            aVar.vt("shareString");
            aVar.vs("shareStringUrl");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.seB));
            aVar.vt("shareStringUrl");
            aVar.vs("source");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.bhd));
            aVar.vt("source");
            aVar.vs("strPlayCount");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.seF));
            aVar.vt("strPlayCount");
            aVar.vs("titleUrl");
            aVar.setText(KR(com_tencent_mm_protocal_c_bnp.qYw.seG));
            aVar.vt("titleUrl");
            aVar.vt("websearch");
        }
        aVar.vs("contentDesc");
        aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQl));
        aVar.vt("contentDesc");
        aVar.vs("contentattr");
        aVar.setText(com_tencent_mm_protocal_c_bnp.hbg);
        aVar.vt("contentattr");
        aVar.vs("sourceUserName");
        aVar.setText(KR(com_tencent_mm_protocal_c_bnp.vmS));
        aVar.vt("sourceUserName");
        aVar.vs("sourceNickName");
        aVar.setText(KR(com_tencent_mm_protocal_c_bnp.vmT));
        aVar.vt("sourceNickName");
        aVar.vs("statisticsData");
        aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQs));
        aVar.vt("statisticsData");
        aVar.vs("weappInfo");
        aVar.vs("appUserName");
        aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQu.username));
        aVar.vt("appUserName");
        aVar.vs("pagePath");
        aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQu.path));
        aVar.vt("pagePath");
        aVar.vt("weappInfo");
        aVar.vs("canvasInfoXml");
        aVar.setText(KR(com_tencent_mm_protocal_c_bnp.rLO));
        aVar.vt("canvasInfoXml");
        if (com_tencent_mm_protocal_c_bnp.wQm != null) {
            float f = com_tencent_mm_protocal_c_bnp.wQm.vQt;
            float f2 = com_tencent_mm_protocal_c_bnp.wQm.vQu;
            if (!(f == -1000.0f || f2 == -1000.0f)) {
                hashMap.clear();
                hashMap.put("longitude", com_tencent_mm_protocal_c_bnp.wQm.vQt);
                hashMap.put("latitude", com_tencent_mm_protocal_c_bnp.wQm.vQu);
                hashMap.put("city", bh.VG(KR(com_tencent_mm_protocal_c_bnp.wQm.hvv)));
                hashMap.put("poiName", bh.VG(KR(com_tencent_mm_protocal_c_bnp.wQm.nTe)));
                hashMap.put("poiAddress", bh.VG(KR(com_tencent_mm_protocal_c_bnp.wQm.rue)));
                hashMap.put("poiScale", com_tencent_mm_protocal_c_bnp.wQm.wvJ);
                hashMap.put("poiClassifyId", KR(com_tencent_mm_protocal_c_bnp.wQm.wvH));
                hashMap.put("poiClassifyType", com_tencent_mm_protocal_c_bnp.wQm.rug);
                hashMap.put("poiClickableStatus", com_tencent_mm_protocal_c_bnp.wQm.wvK);
                aVar.g("location", hashMap);
                aVar.vt("location");
            }
        }
        aVar.vs("ContentObject");
        aVar.vs("contentStyle");
        aVar.setText(com_tencent_mm_protocal_c_bnp.wQo.vYc);
        aVar.vt("contentStyle");
        aVar.vs("contentSubStyle");
        aVar.setText(com_tencent_mm_protocal_c_bnp.wQo.vYe);
        aVar.vt("contentSubStyle");
        aVar.vs("title");
        aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQo.fon));
        aVar.vt("title");
        aVar.vs("description");
        aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQo.nfe));
        aVar.vt("description");
        aVar.vs("contentUrl");
        aVar.setText(KR(com_tencent_mm_protocal_c_bnp.wQo.nfX));
        aVar.vt("contentUrl");
        if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
            aVar.vs("mediaList");
            Iterator it = com_tencent_mm_protocal_c_bnp.wQo.vYd.iterator();
            while (it.hasNext()) {
                aqr com_tencent_mm_protocal_c_aqr = (aqr) it.next();
                aVar.vs("media");
                aVar.vs(SlookAirButtonFrequentContactAdapter.ID);
                if (KS(com_tencent_mm_protocal_c_aqr.nGJ).equals("")) {
                    aVar.setText("0");
                } else {
                    aVar.setText(KS(com_tencent_mm_protocal_c_aqr.nGJ));
                }
                aVar.vt(SlookAirButtonFrequentContactAdapter.ID);
                aVar.vs(DownloadSettingTable$Columns.TYPE);
                aVar.setText(com_tencent_mm_protocal_c_aqr.ktN);
                aVar.vt(DownloadSettingTable$Columns.TYPE);
                aVar.vs("title");
                aVar.setText(KR(com_tencent_mm_protocal_c_aqr.fon));
                aVar.vt("title");
                aVar.vs("description");
                aVar.setText(KR(com_tencent_mm_protocal_c_aqr.nfe));
                aVar.vt("description");
                aVar.vs("private");
                aVar.setText(com_tencent_mm_protocal_c_aqr.wxG);
                aVar.vt("private");
                hashMap.clear();
                hashMap.put(DownloadSettingTable$Columns.TYPE, com_tencent_mm_protocal_c_aqr.wxD);
                if (!bh.ov(com_tencent_mm_protocal_c_aqr.fqR)) {
                    hashMap.put("md5", com_tencent_mm_protocal_c_aqr.fqR);
                }
                if (!bh.ov(com_tencent_mm_protocal_c_aqr.wxZ)) {
                    hashMap.put("videomd5", com_tencent_mm_protocal_c_aqr.wxZ);
                }
                aVar.g(SlookSmartClipMetaTag.TAG_TYPE_URL, hashMap);
                aVar.setText(KR(com_tencent_mm_protocal_c_aqr.nfX));
                aVar.vt(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (!(com_tencent_mm_protocal_c_aqr.wxE == null || com_tencent_mm_protocal_c_aqr.wxE.equals(""))) {
                    hashMap.clear();
                    hashMap.put(DownloadSettingTable$Columns.TYPE, com_tencent_mm_protocal_c_aqr.wxF);
                    aVar.g("thumb", hashMap);
                    aVar.setText(KR(com_tencent_mm_protocal_c_aqr.wxE));
                    aVar.vt("thumb");
                }
                if (com_tencent_mm_protocal_c_aqr.fpn > 0) {
                    aVar.vs("subType");
                    aVar.setText(com_tencent_mm_protocal_c_aqr.fpn);
                    aVar.vt("subType");
                }
                if (!bh.ov(com_tencent_mm_protocal_c_aqr.rsn)) {
                    aVar.vs("userData");
                    aVar.setText(com_tencent_mm_protocal_c_aqr.rsn);
                    aVar.vt("userData");
                }
                if (!(com_tencent_mm_protocal_c_aqr.wxI == null || com_tencent_mm_protocal_c_aqr.wxI.equals(""))) {
                    hashMap.clear();
                    hashMap.put(DownloadSettingTable$Columns.TYPE, com_tencent_mm_protocal_c_aqr.wxJ);
                    aVar.g("lowBandUrl", hashMap);
                    aVar.setText(KR(com_tencent_mm_protocal_c_aqr.wxI));
                    aVar.vt("lowBandUrl");
                }
                if (com_tencent_mm_protocal_c_aqr.wxH != null) {
                    hashMap.clear();
                    if (com_tencent_mm_protocal_c_aqr.wxH.wyu > 0.0f) {
                        hashMap.put("width", com_tencent_mm_protocal_c_aqr.wxH.wyu);
                    }
                    if (com_tencent_mm_protocal_c_aqr.wxH.wyv > 0.0f) {
                        hashMap.put("height", com_tencent_mm_protocal_c_aqr.wxH.wyv);
                    }
                    if (com_tencent_mm_protocal_c_aqr.wxH.wyw > 0.0f) {
                        hashMap.put("totalSize", com_tencent_mm_protocal_c_aqr.wxH.wyw);
                    }
                    aVar.g("size", hashMap);
                    aVar.vt("size");
                }
                aVar.vt("media");
            }
            aVar.vt("mediaList");
        }
        aVar.kmW.append(KR(com_tencent_mm_protocal_c_bnp.wQo.vYf));
        aVar.vt("ContentObject");
        if (com_tencent_mm_protocal_c_bnp.qYu != null) {
            aVar.vs("actionInfo");
            if (com_tencent_mm_protocal_c_bnp.qYu.vFI != null) {
                aVar.vs("appMsg");
                aVar.vs("mediaTagName");
                aVar.setText(com_tencent_mm_protocal_c_bnp.qYu.vFI.vFC);
                aVar.vt("mediaTagName");
                aVar.vs("messageExt");
                aVar.setText(com_tencent_mm_protocal_c_bnp.qYu.vFI.vFD);
                aVar.vt("messageExt");
                aVar.vs("messageAction");
                aVar.setText(com_tencent_mm_protocal_c_bnp.qYu.vFI.vFE);
                aVar.vt("messageAction");
                aVar.vt("appMsg");
            }
            aVar.vt("actionInfo");
        }
        if (!(com_tencent_mm_protocal_c_bnp.wQn == null || bh.ov(com_tencent_mm_protocal_c_bnp.wQn.nGJ))) {
            String str = com_tencent_mm_protocal_c_bnp.rtA;
            blt com_tencent_mm_protocal_c_blt = new blt();
            if (str != null) {
                try {
                    com_tencent_mm_protocal_c_blt.aF(Base64.decode(str, 0));
                } catch (Exception e) {
                }
            }
            com_tencent_mm_protocal_c_blt.wPn = new blr();
            com_tencent_mm_protocal_c_blt.wPn.nbS = com_tencent_mm_protocal_c_bnp.wQn.nGJ;
            try {
                str = Base64.encodeToString(com_tencent_mm_protocal_c_blt.toByteArray(), 0);
                replace = str.replace("\n", "");
            } catch (Throwable e2) {
                Throwable th = e2;
                replace = str;
                x.printErrStackTrace("MicroMsg.TimelineConvert", th, "", new Object[0]);
            }
            com_tencent_mm_protocal_c_bnp.rtA = replace;
        }
        if (com_tencent_mm_protocal_c_bnp.rtA != null) {
            aVar.vs("statExtStr");
            aVar.setText(com_tencent_mm_protocal_c_bnp.rtA);
            aVar.vt("statExtStr");
        }
        aVar.vt("TimelineObject");
        replace = aVar.kmW.toString();
        x.d("MicroMsg.TimelineConvert", "xmlContent: " + replace);
        if (bi.y(replace, "TimelineObject") != null) {
            return replace;
        }
        x.e("MicroMsg.TimelineConvert", "xml is error");
        return "";
    }
}
