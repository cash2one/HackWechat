package com.tencent.mm.y;

import com.tencent.mm.a.f;
import com.tencent.mm.a.o;
import com.tencent.mm.cd.c;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class g$a extends d {
    private static final f<Integer, g$a> hdO = new f(100);
    public String action;
    public String appId;
    public String appName;
    public String canvasPageXml = "";
    public String content;
    public String desc;
    public String description;
    public String designerName;
    public String designerRediretctUrl;
    public String extInfo;
    public int fEZ;
    public String fGA;
    public String fGC;
    public String fGD;
    public String fGE;
    public String fGF;
    public String fGG;
    public String fGz;
    public int fIm;
    public String filemd5;
    public String fny;
    public String fpP;
    public String fys;
    public String fzO;
    public String gjD;
    public a haY;
    public Map<String, String> haZ;
    public String hbA;
    public String hbB;
    public int hbC;
    public String hbD;
    public String hbE;
    public int hbF;
    public String hbG;
    public String hbH;
    public String hbI;
    public String hbJ;
    public String hbK;
    public String hbL;
    public String hbM;
    public String hbN;
    public String hbO;
    public String hbP;
    public String hbQ;
    public String hbR;
    public String hbS;
    public String hbT;
    public String hbU;
    public int hbV;
    public int hbW;
    public int hbX;
    public String hbY;
    public String hbZ;
    public String hba;
    public int hbb;
    public String hbc;
    public String hbd;
    public int hbe;
    public int hbf;
    public int hbg;
    public String hbh;
    public String hbi;
    public String hbj;
    public int hbk;
    public int hbl;
    public int hbm;
    public int hbn;
    public int hbo;
    public String hbp;
    public String hbq;
    public int hbr;
    public String hbs;
    public String hbt;
    public int hbu;
    public int hbv;
    public int hbw;
    public String hbx;
    public String hby;
    public int hbz;
    public String hcA;
    public String hcB;
    public String hcC;
    public String hcD;
    public String hcE;
    public String hcF;
    public String hcG;
    public String hcH;
    public int hcI;
    public String hcJ;
    public String hcK;
    public String hcL;
    public int hcM;
    public boolean hcN = false;
    public int hcO = 0;
    public String hcP;
    public int hcQ;
    public String hcR;
    public String hcS;
    public String hcT;
    public List<String> hcU;
    public String hcV;
    public List<String> hcW;
    public String hcX;
    public int hcY;
    public String hcZ;
    public String hca;
    public String hcb;
    public String hcc;
    public int hcd;
    public String hce;
    public String hcf;
    public String hcg;
    public int hch;
    public int hci;
    public String hcj;
    public String hck;
    public int hcl;
    public int hcm;
    public int hcn;
    public String hco;
    public String hcp;
    public String hcq;
    public String hcr;
    public String hcs;
    public String hct;
    public String hcu;
    public int hcv;
    public String hcw;
    public String hcx;
    public String hcy;
    public String hcz;
    public String hdA;
    public int hdB;
    public String hdC;
    public String hdD;
    public int hdE;
    public int hdF;
    public String hdG;
    public String hdH = null;
    public int hdI = 0;
    private final HashMap<Class<? extends d>, d> hdJ = new HashMap();
    public Map<String, String> hdK;
    private String hdL;
    private String hdM;
    private String hdN;
    public String hda;
    public String hdb;
    public String hdc;
    public String hdd;
    public String hde;
    public String hdf;
    public String hdg;
    public String hdh;
    public String hdi;
    public String hdj;
    public String hdk;
    public int hdl;
    public String hdm;
    public String hdn;
    public String hdo;
    public int hdp = 0;
    public String hdq = "";
    public String hdr = "";
    public String hds = "";
    public String hdt = "";
    public String hdu = "";
    public String hdv = "";
    public String hdw;
    public String hdx;
    public String hdy;
    public int hdz;
    public String iconUrl;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int pageType;
    public int sdkVer;
    public String secondUrl;
    public int showType;
    public String thumburl;
    public int tid;
    public String title;
    public int type;
    public String url;
    public String username;

    public final /* synthetic */ d EJ() {
        return EL();
    }

    public final <T extends d> T r(Class<T> cls) {
        return (d) this.hdJ.get(cls);
    }

    public final void a(d dVar) {
        if (dVar == null) {
            x.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
            return;
        }
        dVar.haW = this;
        this.hdJ.put(dVar.getClass(), dVar);
    }

    public static final g$a fS(String str) {
        if (bh.ov(str)) {
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        int hashCode = ("parseImg_" + str).hashCode();
        g$a com_tencent_mm_y_g_a = (g$a) hdO.get(Integer.valueOf(hashCode));
        if (com_tencent_mm_y_g_a != null) {
            return com_tencent_mm_y_g_a;
        }
        Map y = bi.y(str, "msg");
        if (y == null) {
            x.e("MicroMsg.AppMessage", "parseImg failed");
            return null;
        }
        g$a com_tencent_mm_y_g_a2 = new g$a();
        com_tencent_mm_y_g_a2.type = 2;
        com_tencent_mm_y_g_a2.appId = (String) y.get(".msg.appinfo.appid");
        com_tencent_mm_y_g_a2.fIm = bh.getInt((String) y.get(".msg.appinfo.version"), 0);
        com_tencent_mm_y_g_a2.appName = (String) y.get(".msg.appinfo.appname");
        com_tencent_mm_y_g_a2.mediaTagName = (String) y.get(".msg.appinfo.mediatagname");
        com_tencent_mm_y_g_a2.messageExt = (String) y.get(".msg.appinfo.messageext");
        com_tencent_mm_y_g_a2.messageAction = (String) y.get(".msg.appinfo.messageaction");
        hdO.l(Integer.valueOf(hashCode), com_tencent_mm_y_g_a2);
        return com_tencent_mm_y_g_a2;
    }

    public static final g$a fT(String str) {
        return I(str, null);
    }

    public static final g$a I(String str, String str2) {
        if (bh.ov(str)) {
            return null;
        }
        String substring;
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            substring = str.substring(indexOf);
        } else {
            substring = str;
        }
        int hashCode = substring.hashCode();
        g$a com_tencent_mm_y_g_a = (g$a) hdO.get(Integer.valueOf(hashCode));
        if (com_tencent_mm_y_g_a != null) {
            return com_tencent_mm_y_g_a;
        }
        Map map;
        Map y;
        long currentTimeMillis = System.currentTimeMillis();
        if (bh.ov(str2)) {
            map = null;
        } else {
            map = ax.Vo(str2);
        }
        if (map == null) {
            y = bi.y(substring, "msg");
        } else {
            y = map;
        }
        if (y == null) {
            x.e("MicroMsg.AppMessage", "parse msg failed");
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        g$a com_tencent_mm_y_g_a2 = new g$a();
        com_tencent_mm_y_g_a2.hdK = y;
        com_tencent_mm_y_g_a2.hdL = str;
        com_tencent_mm_y_g_a2.hdM = substring;
        com_tencent_mm_y_g_a2.hdN = str2;
        try {
            d dVar;
            com_tencent_mm_y_g_a2.a(y, com_tencent_mm_y_g_a2);
            Iterator it = b.EM().iterator();
            while (it.hasNext()) {
                dVar = (d) ((c) it.next()).get();
                dVar.a(y, com_tencent_mm_y_g_a2);
                com_tencent_mm_y_g_a2.a(dVar);
            }
            dVar = b.gJ(com_tencent_mm_y_g_a2.type);
            if (dVar != null) {
                dVar.a(y, com_tencent_mm_y_g_a2);
                com_tencent_mm_y_g_a2.a(dVar);
            }
            hdO.l(Integer.valueOf(hashCode), com_tencent_mm_y_g_a2);
            x.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[]{Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(bh.ou(str2).hashCode())});
            return com_tencent_mm_y_g_a2;
        } catch (Throwable e) {
            x.e("MicroMsg.AppMessage", "parse amessage xml failed");
            x.e("MicroMsg.AppMessage", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }

    public static String a(g$a com_tencent_mm_y_g_a, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        x.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", new Object[]{bh.VT(com_tencent_mm_y_g_a.hbp), com_tencent_mm_y_g_a.filemd5});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msg>");
        if (com_tencent_mm_y_g_a.hbo == 0 || com_tencent_mm_y_g_a.hbn == 0) {
            x.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
            stringBuilder.append(a(com_tencent_mm_y_g_a, str, com_tencent_mm_modelcdntran_keep_SceneResult, 0, 0));
        } else {
            x.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", new Object[]{Integer.valueOf(com_tencent_mm_y_g_a.hbo), Integer.valueOf(com_tencent_mm_y_g_a.hbn)});
            stringBuilder.append(a(com_tencent_mm_y_g_a, str, com_tencent_mm_modelcdntran_keep_SceneResult, com_tencent_mm_y_g_a.hbo, com_tencent_mm_y_g_a.hbn));
        }
        stringBuilder.append("</msg>");
        hdO.l(Integer.valueOf(stringBuilder.toString().hashCode()), com_tencent_mm_y_g_a);
        return stringBuilder.toString();
    }

    public static String a(g$a com_tencent_mm_y_g_a, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<appmsg appid=\"" + bh.VG(com_tencent_mm_y_g_a.appId) + "\" sdkver=\"" + com_tencent_mm_y_g_a.sdkVer + "\">");
        com_tencent_mm_y_g_a.a(stringBuilder, com_tencent_mm_y_g_a, str, com_tencent_mm_modelcdntran_keep_SceneResult, i, i2);
        d gJ = b.gJ(com_tencent_mm_y_g_a.type);
        if (gJ != null) {
            gJ.a(stringBuilder, com_tencent_mm_y_g_a, str, com_tencent_mm_modelcdntran_keep_SceneResult, i, i2);
        }
        stringBuilder.append("</appmsg>");
        if (2 == com_tencent_mm_y_g_a.showType) {
            stringBuilder.append("<ShakePageResult>").append(com_tencent_mm_y_g_a.hbh).append("</ShakePageResult>");
        }
        x.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static g$a a(g$a com_tencent_mm_y_g_a) {
        if (com_tencent_mm_y_g_a == null) {
            return new g$a();
        }
        return com_tencent_mm_y_g_a.EL();
    }

    public final void a(Map<String, String> map, g$a com_tencent_mm_y_g_a) {
        try {
            this.haZ = map;
            this.appId = (String) map.get(".msg.appmsg.$appid");
            this.sdkVer = bh.getInt((String) map.get(".msg.appmsg.$sdkver"), 0);
            this.title = bh.Vp((String) map.get(".msg.appmsg.title"));
            this.description = (String) map.get(".msg.appmsg.des");
            this.username = (String) map.get(".msg.appmsg.username");
            this.action = (String) map.get(".msg.appmsg.action");
            this.type = bh.getInt((String) map.get(".msg.appmsg.type"), 0);
            this.content = (String) map.get(".msg.appmsg.content");
            this.url = (String) map.get(".msg.appmsg.url");
            this.hba = (String) map.get(".msg.appmsg.lowurl");
            this.hbs = (String) map.get(".msg.appmsg.dataurl");
            this.hbt = (String) map.get(".msg.appmsg.lowdataurl");
            this.hbb = bh.getInt((String) map.get(".msg.appmsg.appattach.totallen"), 0);
            this.fny = (String) map.get(".msg.appmsg.appattach.attachid");
            this.hbc = bh.Vp((String) map.get(".msg.appmsg.appattach.fileext"));
            this.hbd = (String) map.get(".msg.appmsg.appattach.emoticonmd5");
            this.extInfo = (String) map.get(".msg.appmsg.extinfo");
            this.hbe = bh.getInt((String) map.get(".msg.appmsg.androidsource"), 0);
            this.fGz = (String) map.get(".msg.appmsg.sourceusername");
            this.fGA = (String) map.get(".msg.appmsg.sourcedisplayname");
            this.gjD = (String) map.get(".msg.commenturl");
            this.thumburl = (String) map.get(".msg.appmsg.thumburl");
            this.mediaTagName = (String) map.get(".msg.appmsg.mediatagname");
            this.messageAction = (String) map.get(".msg.appmsg.messageaction");
            this.messageExt = (String) map.get(".msg.appmsg.messageext");
            this.fIm = bh.getInt((String) map.get(".msg.appinfo.version"), 0);
            this.appName = (String) map.get(".msg.appinfo.appname");
            this.fzO = (String) map.get(".msg.fromusername");
            this.hbi = (String) map.get(".msg.appmsg.appattach.cdnattachurl");
            this.hbj = (String) map.get(".msg.appmsg.appattach.cdnthumburl");
            this.hbk = bh.getInt((String) map.get(".msg.appmsg.appattach.cdnthumblength"), 0);
            this.hbl = bh.getInt((String) map.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
            this.hbm = bh.getInt((String) map.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
            this.hbn = bh.getInt((String) map.get(".msg.appmsg.appattach.thumbheight"), 0);
            this.hbo = bh.getInt((String) map.get(".msg.appmsg.appattach.thumbwidth"), 0);
            this.hbp = (String) map.get(".msg.appmsg.appattach.aeskey");
            this.hbr = bh.getInt((String) map.get(".msg.appmsg.appattach.encryver"), 1);
            this.hbq = (String) map.get(".msg.appmsg.appattach.cdnthumbaeskey");
            this.hbf = bh.getInt((String) map.get(".msg.appmsg.appattach.islargefilemsg"), 0);
            if (this.hbf == 0 && this.hbb > 26214400) {
                this.hbf = 1;
                x.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[]{Integer.valueOf(this.hbb)});
            }
            this.hbw = bh.getInt((String) map.get(".msg.appmsg.productitem.$type"), 0);
            this.hbx = (String) map.get(".msg.appmsg.productitem.productinfo");
            this.hbz = bh.getInt((String) map.get(".msg.appmsg.emoticongift.packageflag"), 0);
            this.hby = (String) map.get(".msg.appmsg.emoticongift.packageid");
            this.hbE = (String) map.get(".msg.appmsg.emoticonshared.packageid");
            this.hbF = bh.getInt((String) map.get(".msg.appmsg.emoticonshared.packageflag"), 0);
            this.hbA = (String) map.get(".msg.appmsg.tvinfo");
            this.hbB = (String) map.get(".msg.appmsg.recorditem");
            this.fGC = (String) map.get(".msg.appmsg.webviewshared.shareUrlOriginal");
            this.fGD = (String) map.get(".msg.appmsg.webviewshared.shareUrlOpen");
            this.fGE = (String) map.get(".msg.appmsg.webviewshared.jsAppId");
            this.fGF = (String) map.get(".msg.appmsg.webviewshared.publisherId");
            this.hdl = o.bY((String) map.get(".msg.appmsg.designershared.designeruin"));
            this.designerName = (String) map.get(".msg.appmsg.designershared.designername");
            this.designerRediretctUrl = (String) map.get(".msg.appmsg.designershared.designerrediretcturl");
            this.tid = bh.VI((String) map.get(".msg.appmsg.emotionpageshared.tid"));
            this.hdm = (String) map.get(".msg.appmsg.emotionpageshared.title");
            this.desc = (String) map.get(".msg.appmsg.emotionpageshared.desc");
            this.iconUrl = (String) map.get(".msg.appmsg.emotionpageshared.iconUrl");
            this.secondUrl = bh.az((String) map.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
            this.pageType = bh.VI((String) map.get(".msg.appmsg.emotionpageshared.pageType"));
            this.hdo = bh.az((String) map.get(".msg.appmsg.streamvideo.streamvideourl"), "");
            this.hdp = bh.VI((String) map.get(".msg.appmsg.streamvideo.streamvideototaltime"));
            this.hdq = bh.az((String) map.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
            this.hdr = bh.az((String) map.get(".msg.appmsg.streamvideo.streamvideowording"), "");
            this.hds = bh.az((String) map.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
            this.hdt = bh.az((String) map.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
            this.hdu = bh.az((String) map.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
            this.hdv = bh.az((String) map.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
            this.canvasPageXml = bh.az((String) map.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
            this.hdx = (String) map.get(".msg.appmsg.weappinfo.username");
            this.hdw = (String) map.get(".msg.appmsg.weappinfo.pagepath");
            this.hdy = (String) map.get(".msg.appmsg.weappinfo.appid");
            this.hdF = bh.getInt((String) map.get(".msg.appmsg.weappinfo.version"), 0);
            this.hdz = bh.getInt((String) map.get(".msg.appmsg.weappinfo.type"), 0);
            this.hdE = bh.getInt((String) map.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
            this.hdA = (String) map.get(".msg.appmsg.weappinfo.pkginfo.md5");
            this.hdG = (String) map.get(".msg.appmsg.weappinfo.weappiconurl");
            this.hdC = (String) map.get(".msg.appmsg.weappinfo.shareId");
            this.hdD = (String) map.get(".msg.appmsg.weappinfo.sharekey");
            String str = "<cache";
            String str2 = "</cache>";
            int indexOf = com_tencent_mm_y_g_a.hdL.indexOf(str);
            int indexOf2 = com_tencent_mm_y_g_a.hdL.indexOf(str2);
            if (indexOf2 - indexOf > str.length()) {
                this.hdH = com_tencent_mm_y_g_a.hdL.substring(indexOf, str2.length() + indexOf2);
            }
            this.hdI = bh.getInt((String) map.get(".msg.appmsg.soundtype"), 0);
            switch (this.type) {
                case 1:
                    if (!(map.get(".msg.alphainfo.url") == null || map.get(".msg.alphainfo.md5") == null)) {
                        this.hcN = true;
                        break;
                    }
                case 13:
                    this.hbC = bh.getInt((String) map.get(".msg.appmsg.mallproductitem.$type"), 0);
                    this.hbD = (String) map.get(".msg.appmsg.mallproductitem.mallproductinfo");
                    break;
                case 16:
                    this.fys = com_tencent_mm_y_g_a.hdL;
                    this.hcj = "";
                    this.hcl = bh.getInt((String) map.get(".msg.appmsg.carditem.from_scene"), 2);
                    this.hck = (String) map.get(".msg.appmsg.carditem.brand_name");
                    this.hcm = bh.getInt((String) map.get(".msg.appmsg.carditem.card_type"), -1);
                    break;
                case 34:
                    this.hco = bh.az((String) map.get(".msg.appmsg.giftcard_info.order_id"), "");
                    this.hcn = o.bY((String) map.get(".msg.appmsg.giftcard_info.biz_uin"));
                    this.hcp = bh.az((String) map.get(".msg.appmsg.giftcard_info.app_name"), "");
                    this.hcq = bh.az((String) map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
                    this.hcr = bh.az((String) map.get(".msg.appmsg.giftcard_info.send_digest"), "");
                    this.hcs = bh.az((String) map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
                    this.hct = bh.az((String) map.get(".msg.appmsg.giftcard_info.title_color"), "");
                    this.hcu = bh.az((String) map.get(".msg.appmsg.giftcard_info.des_color"), "");
                    break;
                case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                    this.hcd = bh.getInt((String) map.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
                    this.hce = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.feedesc"));
                    this.hcf = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.transcationid"));
                    this.hcg = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.transferid"));
                    this.hch = bh.getInt((String) map.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
                    this.hci = bh.getInt((String) map.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
                    this.fEZ = bh.getInt((String) map.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
                    this.fpP = bh.az((String) map.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
                    this.hdn = bh.az((String) map.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
                    break;
                case 2001:
                    String[] split;
                    this.hcz = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.iconurl"));
                    this.hcE = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.scenetext"));
                    this.hcy = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.url"));
                    this.hcA = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.receivertitle"));
                    this.hcB = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.sendertitle"));
                    this.hcD = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.receiverdes"));
                    this.hcC = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.senderdes"));
                    this.hcF = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.templateid"));
                    this.hcG = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.sceneid"));
                    this.hcH = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.nativeurl"));
                    this.hcI = bh.getInt((String) map.get(".msg.appmsg.wcpayinfo.localtype"), 0);
                    this.hcJ = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.paymsgid"));
                    this.hcK = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.imageid"));
                    this.hcL = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.imageaeskey"));
                    this.hcM = bh.getInt((String) map.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
                    this.hcO = bh.getInt((String) map.get(".msg.appmsg.wcpayinfo.droptips"), 0);
                    this.hcP = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.newaa.billno"));
                    this.hcQ = bh.getInt((String) map.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
                    this.hcR = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
                    this.hcS = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
                    this.hcT = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
                    str = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
                    if (!bh.ov(str)) {
                        split = str.split("\\|");
                        if (split != null && split.length > 0) {
                            this.hcU = new ArrayList();
                            this.hcU.addAll(Arrays.asList(split));
                        }
                    }
                    this.hcV = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
                    str = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
                    if (!bh.ov(str)) {
                        split = str.split("\\|");
                        if (split != null && split.length > 0) {
                            this.hcW = new ArrayList();
                            this.hcW.addAll(Arrays.asList(split));
                        }
                    }
                    this.hcX = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
                    this.hcY = bh.getInt((String) map.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
                    this.hcZ = bh.ou((String) map.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
                    break;
                case 2002:
                    this.hda = bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo.url"));
                    this.hdb = bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo.templateid"));
                    this.hdc = bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
                    this.hdd = bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
                    this.hde = bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
                    this.hdf = bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
                    this.hdg = bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
                    this.hdh = bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
                    this.hdi = bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
                    this.hdj = bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
                    this.hdk = bh.ou((String) map.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
                    break;
            }
            if (this.type != 21) {
                if (this.type != 2001) {
                    this.showType = bh.getInt((String) map.get(".msg.appmsg.showtype"), 0);
                    switch (this.showType) {
                        case 1:
                            if (bh.getInt((String) map.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
                                this.content = ax.at(map);
                                break;
                            }
                            break;
                        case 2:
                            str = com_tencent_mm_y_g_a.hdL.toLowerCase();
                            this.hbh = com_tencent_mm_y_g_a.hdL.substring(str.indexOf("<ShakePageResult>".toLowerCase()) + 17, str.indexOf("</ShakePageResult>".toLowerCase()));
                            break;
                        default:
                            break;
                    }
                }
                this.showType = bh.getInt((String) map.get(".msg.appmsg.wcpayinfo.innertype"), 0);
            } else {
                this.showType = bh.getInt((String) map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
            }
            this.fGG = (String) map.get(".msg.appmsg.statextstr");
            this.hbu = bh.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
            if (this.hbu == 5 && bh.getInt((String) map.get(".msg.appmsg.mmreader.category.$count"), 0) > 1) {
                this.hbu = 0;
            }
            this.hbv = bh.getInt((String) map.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
            this.hbG = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle");
            this.hbH = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid");
            if (bh.ov(this.hbH)) {
                this.hbH = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid");
            }
            this.hbI = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay");
            this.hbJ = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle");
            this.hbK = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay");
            this.hbL = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay");
            this.hbM = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color");
            this.hbN = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor");
            this.hbO = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor");
            this.hbQ = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor");
            this.hbP = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor");
            this.hbS = (String) map.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle");
            this.hbR = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername");
            this.hbV = bh.getInt((String) map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
            this.hbX = bh.getInt((String) map.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
            this.hbW = bh.getInt((String) map.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
            this.hbT = (String) map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto");
            this.hbU = (String) map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl");
            str = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
            this.hcb = str;
            this.hbZ = str;
            str = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
            this.hca = str;
            this.hbY = str;
            this.hcc = bh.ou((String) map.get(".msg.appmsg.template_id"));
            this.filemd5 = (String) map.get(".msg.appmsg.md5");
            this.hcv = bh.getInt((String) map.get(".msg.appmsg.jumpcontrol.enable"), 0);
            this.hcw = (String) map.get(".msg.appmsg.jumpcontrol.jumpurl");
            this.hcx = (String) map.get(".msg.appmsg.jumpcontrol.pushcontent");
            Map y = bi.y(com_tencent_mm_y_g_a.hdM, "msgoperation");
            if (this != null && y != null) {
                this.haY = new a();
                this.haY.gjO = (String) y.get(".msgoperation.expinfo.expidstr");
                this.haY.hdP = bh.getInt((String) y.get(".msgoperation.appmsg.usedefaultthumb"), 0);
                this.haY.hdQ = bh.getInt((String) y.get(".msgoperation.appmsg.isupdatetitle"), 0);
                this.haY.title = (String) y.get(".msgoperation.appmsg.title");
                this.haY.hdR = bh.getInt((String) y.get(".msgoperation.appmsg.isupdatedesc"), 0);
                this.haY.desc = (String) y.get(".msgoperation.appmsg.desc");
                this.haY.hdS = bh.getInt((String) y.get(".msgoperation.appmsg.ishiddentail"), 0);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.AppMessage", "parse amessage xml failed");
            x.e("MicroMsg.AppMessage", "exception:%s", new Object[]{bh.i(e)});
            throw e;
        }
    }

    private g$a EL() {
        g$a com_tencent_mm_y_g_a = new g$a();
        if (this == null) {
            return com_tencent_mm_y_g_a;
        }
        x.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", new Object[]{bh.VT(this.hbp), this.filemd5, com_tencent_mm_y_g_a.appId});
        com_tencent_mm_y_g_a.action = this.action;
        com_tencent_mm_y_g_a.appId = this.appId;
        com_tencent_mm_y_g_a.appName = this.appName;
        com_tencent_mm_y_g_a.fIm = this.fIm;
        com_tencent_mm_y_g_a.fny = this.fny;
        com_tencent_mm_y_g_a.hbb = this.hbb;
        com_tencent_mm_y_g_a.content = this.content;
        com_tencent_mm_y_g_a.description = this.description;
        com_tencent_mm_y_g_a.username = this.username;
        com_tencent_mm_y_g_a.extInfo = this.extInfo;
        com_tencent_mm_y_g_a.mediaTagName = this.mediaTagName;
        com_tencent_mm_y_g_a.messageAction = this.messageAction;
        com_tencent_mm_y_g_a.messageExt = this.messageExt;
        com_tencent_mm_y_g_a.hbe = this.hbe;
        com_tencent_mm_y_g_a.hbc = this.hbc;
        com_tencent_mm_y_g_a.fzO = this.fzO;
        com_tencent_mm_y_g_a.hba = this.hba;
        com_tencent_mm_y_g_a.sdkVer = this.sdkVer;
        com_tencent_mm_y_g_a.title = this.title;
        com_tencent_mm_y_g_a.type = this.type;
        com_tencent_mm_y_g_a.showType = this.showType;
        com_tencent_mm_y_g_a.hbu = this.hbu;
        com_tencent_mm_y_g_a.hbv = this.hbv;
        com_tencent_mm_y_g_a.url = this.url;
        com_tencent_mm_y_g_a.hbd = this.hbd;
        com_tencent_mm_y_g_a.fGz = this.fGz;
        com_tencent_mm_y_g_a.fGA = this.fGA;
        com_tencent_mm_y_g_a.gjD = this.gjD;
        com_tencent_mm_y_g_a.thumburl = this.thumburl;
        com_tencent_mm_y_g_a.hbh = this.hbh;
        com_tencent_mm_y_g_a.hbs = this.hbs;
        com_tencent_mm_y_g_a.hbt = this.hbt;
        com_tencent_mm_y_g_a.hbw = this.hbw;
        com_tencent_mm_y_g_a.hbx = this.hbx;
        com_tencent_mm_y_g_a.hbz = this.hbz;
        com_tencent_mm_y_g_a.hby = this.hby;
        com_tencent_mm_y_g_a.hbC = this.hbC;
        com_tencent_mm_y_g_a.hbD = this.hbD;
        com_tencent_mm_y_g_a.hbF = this.hbF;
        com_tencent_mm_y_g_a.hbE = this.hbE;
        com_tencent_mm_y_g_a.hbA = this.hbA;
        com_tencent_mm_y_g_a.hbB = this.hbB;
        com_tencent_mm_y_g_a.hcc = this.hcc;
        com_tencent_mm_y_g_a.fys = this.fys;
        com_tencent_mm_y_g_a.hcj = this.hcj;
        com_tencent_mm_y_g_a.hck = this.hck;
        com_tencent_mm_y_g_a.hcl = this.hcl;
        com_tencent_mm_y_g_a.hcm = this.hcl;
        com_tencent_mm_y_g_a.hce = this.hce;
        com_tencent_mm_y_g_a.hch = this.hch;
        com_tencent_mm_y_g_a.hcd = this.hcd;
        com_tencent_mm_y_g_a.hcf = this.hcf;
        com_tencent_mm_y_g_a.hcg = this.hcg;
        com_tencent_mm_y_g_a.hcv = this.hcv;
        com_tencent_mm_y_g_a.hcw = this.hcw;
        com_tencent_mm_y_g_a.hcx = this.hcx;
        com_tencent_mm_y_g_a.hbg = this.hbg;
        com_tencent_mm_y_g_a.fGC = this.fGC;
        com_tencent_mm_y_g_a.fGD = this.fGD;
        com_tencent_mm_y_g_a.fGE = this.fGE;
        com_tencent_mm_y_g_a.fGF = this.fGF;
        com_tencent_mm_y_g_a.hdn = this.hdn;
        com_tencent_mm_y_g_a.hdl = this.hdl;
        com_tencent_mm_y_g_a.designerName = this.designerName;
        com_tencent_mm_y_g_a.designerRediretctUrl = this.designerName;
        com_tencent_mm_y_g_a.tid = this.tid;
        com_tencent_mm_y_g_a.hdm = this.hdm;
        com_tencent_mm_y_g_a.desc = this.desc;
        com_tencent_mm_y_g_a.iconUrl = this.iconUrl;
        com_tencent_mm_y_g_a.secondUrl = this.secondUrl;
        com_tencent_mm_y_g_a.pageType = this.pageType;
        com_tencent_mm_y_g_a.hdo = this.hdo;
        com_tencent_mm_y_g_a.hdp = this.hdp;
        com_tencent_mm_y_g_a.hdq = this.hdq;
        com_tencent_mm_y_g_a.hdr = this.hdr;
        com_tencent_mm_y_g_a.hds = this.hds;
        com_tencent_mm_y_g_a.hdt = this.hdt;
        com_tencent_mm_y_g_a.hdu = this.hdu;
        com_tencent_mm_y_g_a.hdv = this.hdv;
        com_tencent_mm_y_g_a.canvasPageXml = this.canvasPageXml;
        com_tencent_mm_y_g_a.fGG = this.fGG;
        com_tencent_mm_y_g_a.hbi = this.hbi;
        com_tencent_mm_y_g_a.hbp = this.hbp;
        com_tencent_mm_y_g_a.filemd5 = this.filemd5;
        com_tencent_mm_y_g_a.hbf = this.hbf;
        com_tencent_mm_y_g_a.haY = this.haY;
        com_tencent_mm_y_g_a.hdw = this.hdw;
        com_tencent_mm_y_g_a.hdx = this.hdx;
        com_tencent_mm_y_g_a.hdz = this.hdz;
        com_tencent_mm_y_g_a.hdA = this.hdA;
        com_tencent_mm_y_g_a.hdE = this.hdE;
        com_tencent_mm_y_g_a.hdy = this.hdy;
        com_tencent_mm_y_g_a.hdF = this.hdF;
        com_tencent_mm_y_g_a.hdG = this.hdG;
        com_tencent_mm_y_g_a.hdC = this.hdC;
        com_tencent_mm_y_g_a.hdM = this.hdM;
        com_tencent_mm_y_g_a.hdN = this.hdN;
        com_tencent_mm_y_g_a.hdL = this.hdL;
        com_tencent_mm_y_g_a.hdK = this.hdK;
        for (Entry value : this.hdJ.entrySet()) {
            d EJ = ((d) value.getValue()).EJ();
            if (EJ != null) {
                com_tencent_mm_y_g_a.a(EJ);
            }
        }
        return com_tencent_mm_y_g_a;
    }

    public final void a(StringBuilder stringBuilder, g$a com_tencent_mm_y_g_a, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
        String str2;
        stringBuilder.append("<title>" + bh.VG(com_tencent_mm_y_g_a.title) + "</title>");
        stringBuilder.append("<des>" + bh.VG(com_tencent_mm_y_g_a.description) + "</des>");
        stringBuilder.append("<username>" + bh.VG(com_tencent_mm_y_g_a.username) + "</username>");
        StringBuilder stringBuilder2 = new StringBuilder("<action>");
        if (bh.ov(com_tencent_mm_y_g_a.action)) {
            str2 = "view";
        } else {
            str2 = bh.VG(com_tencent_mm_y_g_a.action);
        }
        stringBuilder.append(stringBuilder2.append(str2).append("</action>").toString());
        stringBuilder.append("<type>" + com_tencent_mm_y_g_a.type + "</type>");
        stringBuilder.append("<showtype>").append(com_tencent_mm_y_g_a.showType).append("</showtype>");
        stringBuilder.append("<content>" + bh.VG(com_tencent_mm_y_g_a.content) + "</content>");
        stringBuilder.append("<url>" + bh.VG(com_tencent_mm_y_g_a.url) + "</url>");
        stringBuilder.append("<lowurl>" + bh.VG(com_tencent_mm_y_g_a.hba) + "</lowurl>");
        stringBuilder.append("<dataurl>" + bh.VG(com_tencent_mm_y_g_a.hbs) + "</dataurl>");
        stringBuilder.append("<lowdataurl>" + bh.VG(com_tencent_mm_y_g_a.hbt) + "</lowdataurl>");
        stringBuilder.append("<contentattr>").append(com_tencent_mm_y_g_a.hbg).append("</contentattr>");
        stringBuilder.append("<streamvideo>");
        stringBuilder.append("<streamvideourl>").append(bh.VG(com_tencent_mm_y_g_a.hdo)).append("</streamvideourl>");
        stringBuilder.append("<streamvideototaltime>").append(com_tencent_mm_y_g_a.hdp).append("</streamvideototaltime>");
        stringBuilder.append("<streamvideotitle>").append(bh.VG(com_tencent_mm_y_g_a.hdq)).append("</streamvideotitle>");
        stringBuilder.append("<streamvideowording>").append(bh.VG(com_tencent_mm_y_g_a.hdr)).append("</streamvideowording>");
        stringBuilder.append("<streamvideoweburl>").append(bh.VG(com_tencent_mm_y_g_a.hds)).append("</streamvideoweburl>");
        stringBuilder.append("<streamvideothumburl>").append(bh.VG(com_tencent_mm_y_g_a.hdt)).append("</streamvideothumburl>");
        stringBuilder.append("<streamvideoaduxinfo>").append(bh.VG(com_tencent_mm_y_g_a.hdu)).append("</streamvideoaduxinfo>");
        stringBuilder.append("<streamvideopublishid>").append(bh.VG(com_tencent_mm_y_g_a.hdv)).append("</streamvideopublishid>");
        stringBuilder.append("</streamvideo>");
        stringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[]{com_tencent_mm_y_g_a.canvasPageXml}));
        switch (com_tencent_mm_y_g_a.type) {
            case 10:
                stringBuilder.append("<productitem type=\"" + com_tencent_mm_y_g_a.hbw + "\">");
                stringBuilder.append("<productinfo>" + bh.VG(com_tencent_mm_y_g_a.hbx) + "</productinfo>");
                stringBuilder.append("</productitem>");
                break;
            case 13:
                stringBuilder.append("<mallproductitem type=\"" + com_tencent_mm_y_g_a.hbC + "\">");
                stringBuilder.append("<mallproductinfo>" + bh.VG(com_tencent_mm_y_g_a.hbD) + "</mallproductinfo>");
                stringBuilder.append("</mallproductitem>");
                break;
            case 16:
                stringBuilder.append("<carditem>" + com_tencent_mm_y_g_a.hcj + "</carditem>");
                break;
            case 19:
            case 24:
                stringBuilder.append("<recorditem>" + bh.VG(com_tencent_mm_y_g_a.hbB) + "</recorditem>");
                break;
            case 20:
                stringBuilder.append("<tvinfo>" + bh.VG(com_tencent_mm_y_g_a.hbA) + "</tvinfo>");
                break;
            case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                stringBuilder.append("<wcpayinfo>");
                stringBuilder.append("<paysubtype>" + com_tencent_mm_y_g_a.hcd + "</paysubtype>");
                stringBuilder.append("<feedesc>" + com_tencent_mm_y_g_a.hce + "</feedesc>");
                stringBuilder.append("<transcationid>" + com_tencent_mm_y_g_a.hcf + "</transcationid>");
                stringBuilder.append("<transferid>" + com_tencent_mm_y_g_a.hcg + "</transferid>");
                stringBuilder.append("<invalidtime>" + com_tencent_mm_y_g_a.hch + "</invalidtime>");
                stringBuilder.append("<pay_memo>" + com_tencent_mm_y_g_a.hdn + "</pay_memo>");
                stringBuilder.append("</wcpayinfo>");
                break;
            case 2001:
                stringBuilder.append("<wcpayinfo>");
                stringBuilder.append("<iconurl>" + bh.VG(com_tencent_mm_y_g_a.hcz) + "</iconurl>");
                stringBuilder.append("<scenetext>" + bh.VG(com_tencent_mm_y_g_a.hcE) + "</scenetext>");
                stringBuilder.append("<url>" + bh.VG(com_tencent_mm_y_g_a.hcy) + "</url>");
                stringBuilder.append("<receivertitle>" + bh.VG(com_tencent_mm_y_g_a.hcA) + "</receivertitle>");
                stringBuilder.append("<sendertitle>" + bh.VG(com_tencent_mm_y_g_a.hcB) + "</sendertitle>");
                stringBuilder.append("<receiverdes>" + bh.VG(com_tencent_mm_y_g_a.hcD) + "</receiverdes>");
                stringBuilder.append("<senderdes>" + bh.VG(com_tencent_mm_y_g_a.hcC) + "</senderdes>");
                stringBuilder.append("<templateid>" + bh.VG(com_tencent_mm_y_g_a.hcF) + "</templateid>");
                stringBuilder.append("<sceneid>" + bh.VG(com_tencent_mm_y_g_a.hcG) + "</sceneid>");
                stringBuilder.append("<nativeurl>" + bh.VG(com_tencent_mm_y_g_a.hcH) + "</nativeurl>");
                stringBuilder.append("<innertype>" + bh.VG(com_tencent_mm_y_g_a.showType) + "</innertype>");
                stringBuilder.append("<localtype>" + bh.VG(com_tencent_mm_y_g_a.hcI) + "</localtype>");
                stringBuilder.append("<paymsgid>" + bh.VG(com_tencent_mm_y_g_a.hcJ) + "</paymsgid>");
                stringBuilder.append("<imageid>" + bh.VG(com_tencent_mm_y_g_a.hcK) + "</imageid>");
                stringBuilder.append("<imageaeskey>" + bh.VG(com_tencent_mm_y_g_a.hcL) + "</imageaeskey>");
                stringBuilder.append("<imagelength>" + bh.VG(com_tencent_mm_y_g_a.hcM) + "</imagelength>");
                stringBuilder.append("<droptips>" + bh.VG(com_tencent_mm_y_g_a.hcO) + "</droptips>");
                stringBuilder.append("</wcpayinfo>");
                break;
        }
        stringBuilder.append("<appattach>");
        if (com_tencent_mm_modelcdntran_keep_SceneResult == null || (bh.ov(str) && i == 0 && i2 == 0)) {
            stringBuilder.append("<totallen>" + com_tencent_mm_y_g_a.hbb + "</totallen>");
            stringBuilder.append("<attachid>" + bh.VG(com_tencent_mm_y_g_a.fny) + "</attachid>");
            stringBuilder.append("<cdnattachurl>" + bh.VG(com_tencent_mm_y_g_a.hbi) + "</cdnattachurl>");
            stringBuilder.append("<emoticonmd5>" + bh.VG(com_tencent_mm_y_g_a.hbd) + "</emoticonmd5>");
            stringBuilder.append("<aeskey>" + bh.VG(com_tencent_mm_y_g_a.hbp) + "</aeskey>");
            if (!(i == 0 || i2 == 0)) {
                stringBuilder.append("<thumbheight>" + i2 + "</thumbheight>");
                stringBuilder.append("<thumbwidth>" + i + "</thumbwidth>");
            }
        } else {
            stringBuilder.append("<attachid>" + bh.VG(str) + "</attachid>");
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength > 0 && !bh.ov(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId)) {
                stringBuilder.append("<cdnattachurl>" + bh.VG(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId) + "</cdnattachurl>");
                if (com_tencent_mm_y_g_a.type == 19 || com_tencent_mm_y_g_a.type == 24 || com_tencent_mm_y_g_a.type == 4 || com_tencent_mm_y_g_a.type == 3 || com_tencent_mm_y_g_a.type == 7 || com_tencent_mm_y_g_a.type == 27 || com_tencent_mm_y_g_a.type == 26) {
                    x.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[]{Integer.valueOf(com_tencent_mm_y_g_a.type), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength)});
                } else {
                    stringBuilder.append("<totallen>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "</totallen>");
                }
            }
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength > 0) {
                stringBuilder.append("<cdnthumburl>" + bh.VG(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId) + "</cdnthumburl>");
                if (!bh.ov(com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbfilemd5)) {
                    stringBuilder.append("<cdnthumbmd5>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbfilemd5 + "</cdnthumbmd5>");
                }
                stringBuilder.append("<cdnthumblength>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength + "</cdnthumblength>");
                stringBuilder.append("<cdnthumbheight>" + i2 + "</cdnthumbheight>");
                stringBuilder.append("<cdnthumbwidth>" + i + "</cdnthumbwidth>");
                stringBuilder.append("<cdnthumbaeskey>" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "</cdnthumbaeskey>");
            }
            stringBuilder.append("<aeskey>" + bh.VG(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey) + "</aeskey>");
            stringBuilder.append("<encryver>1</encryver>");
        }
        stringBuilder.append("<fileext>" + bh.VG(com_tencent_mm_y_g_a.hbc) + "</fileext>");
        stringBuilder.append("<islargefilemsg>" + com_tencent_mm_y_g_a.hbf + "</islargefilemsg>");
        stringBuilder.append("</appattach>");
        stringBuilder.append("<extinfo>" + bh.VG(com_tencent_mm_y_g_a.extInfo) + "</extinfo>");
        stringBuilder.append("<androidsource>" + com_tencent_mm_y_g_a.hbe + "</androidsource>");
        if (!bh.ov(com_tencent_mm_y_g_a.fGz)) {
            stringBuilder.append("<sourceusername>" + bh.VG(com_tencent_mm_y_g_a.fGz) + "</sourceusername>");
            stringBuilder.append("<sourcedisplayname>" + bh.VG(com_tencent_mm_y_g_a.fGA) + "</sourcedisplayname>");
            stringBuilder.append("<commenturl>" + bh.VG(com_tencent_mm_y_g_a.gjD) + "</commenturl>");
        }
        stringBuilder.append("<thumburl>" + bh.VG(com_tencent_mm_y_g_a.thumburl) + "</thumburl>");
        stringBuilder.append("<mediatagname>" + bh.VG(com_tencent_mm_y_g_a.mediaTagName) + "</mediatagname>");
        stringBuilder.append("<messageaction>" + fU(bh.VG(com_tencent_mm_y_g_a.messageAction)) + "</messageaction>");
        stringBuilder.append("<messageext>" + fU(bh.VG(com_tencent_mm_y_g_a.messageExt)) + "</messageext>");
        stringBuilder.append("<emoticongift>");
        stringBuilder.append("<packageflag>" + com_tencent_mm_y_g_a.hbz + "</packageflag>");
        stringBuilder.append("<packageid>" + bh.VG(com_tencent_mm_y_g_a.hby) + "</packageid>");
        stringBuilder.append("</emoticongift>");
        stringBuilder.append("<emoticonshared>");
        stringBuilder.append("<packageflag>" + com_tencent_mm_y_g_a.hbF + "</packageflag>");
        stringBuilder.append("<packageid>" + bh.VG(com_tencent_mm_y_g_a.hbE) + "</packageid>");
        stringBuilder.append("</emoticonshared>");
        stringBuilder.append("<designershared>");
        stringBuilder.append("<designeruin>" + com_tencent_mm_y_g_a.hdl + "</designeruin>");
        stringBuilder.append("<designername>" + com_tencent_mm_y_g_a.designerName + "</designername>");
        stringBuilder.append("<designerrediretcturl>" + com_tencent_mm_y_g_a.designerRediretctUrl + "</designerrediretcturl>");
        stringBuilder.append("</designershared>");
        stringBuilder.append("<emotionpageshared>");
        stringBuilder.append("<tid>" + com_tencent_mm_y_g_a.tid + "</tid>");
        stringBuilder.append("<title>" + com_tencent_mm_y_g_a.hdm + "</title>");
        stringBuilder.append("<desc>" + com_tencent_mm_y_g_a.desc + "</desc>");
        stringBuilder.append("<iconUrl>" + com_tencent_mm_y_g_a.iconUrl + "</iconUrl>");
        stringBuilder.append("<secondUrl>" + com_tencent_mm_y_g_a.secondUrl + "</secondUrl>");
        stringBuilder.append("<pageType>" + com_tencent_mm_y_g_a.pageType + "</pageType>");
        stringBuilder.append("</emotionpageshared>");
        stringBuilder.append("<webviewshared>");
        stringBuilder.append("<shareUrlOriginal>" + bh.VG(com_tencent_mm_y_g_a.fGC) + "</shareUrlOriginal>");
        stringBuilder.append("<shareUrlOpen>" + bh.VG(com_tencent_mm_y_g_a.fGD) + "</shareUrlOpen>");
        stringBuilder.append("<jsAppId>" + bh.VG(com_tencent_mm_y_g_a.fGE) + "</jsAppId>");
        stringBuilder.append("<publisherId>" + bh.VG(com_tencent_mm_y_g_a.fGF) + "</publisherId>");
        stringBuilder.append("</webviewshared>");
        stringBuilder.append("<template_id>" + bh.VG(com_tencent_mm_y_g_a.hcc) + "</template_id>");
        x.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[]{com_tencent_mm_y_g_a.filemd5});
        stringBuilder.append("<md5>" + bh.VG(com_tencent_mm_y_g_a.filemd5) + "</md5>");
        Iterator it = b.EM().iterator();
        while (it.hasNext()) {
            d dVar = (d) ((c) it.next()).get();
            d r = com_tencent_mm_y_g_a.r(dVar.getClass());
            if (r != null) {
                dVar = r;
            }
            dVar.a(stringBuilder, com_tencent_mm_y_g_a, str, com_tencent_mm_modelcdntran_keep_SceneResult, i, i2);
        }
    }

    public final void a(g gVar) {
        gVar.field_appId = this.appId;
        gVar.field_title = this.title;
        gVar.field_description = this.description;
        gVar.field_type = this.type;
        gVar.field_source = this.appName;
    }

    public static String fU(String str) {
        return "<![CDATA[" + str + "]]>";
    }

    public final String getTitle() {
        if (this.haY == null || this.haY.hdQ == 0) {
            return this.title;
        }
        return this.haY.title;
    }

    public final String getDescription() {
        if (this.haY == null || this.haY.hdR == 0) {
            return this.description;
        }
        return this.haY.desc;
    }
}
