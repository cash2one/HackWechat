package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.g.a.pl;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.w.a;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g {
    private static int[] qRV = new int[]{50, 66, 68, 88, 99, 121, 123, JsApiLaunchMiniProgram.CTRL_INDEX, JsApiSetClipboardData.CTRL_INDEX, n.CTRL_BYTE, 199, 233, 266, 268, 288, 299, 369, 419, 520, 666, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT};
    private static String qRp = "";
    private static g qRq = null;
    private StringBuffer kmW = new StringBuffer();
    public long ktZ = 0;
    public String qRA = "";
    public String qRB = "";
    public String qRC = "";
    public String qRD = "";
    public String qRE = "";
    public String qRF = "";
    public String qRG = "";
    public String qRH = "";
    public String qRI = "";
    public String qRJ = "";
    public String qRK = "";
    public String qRL = "";
    public String qRM = "";
    public String qRN = "";
    public String qRO = "";
    public String qRP = "";
    public String qRQ = "";
    public int qRR = -1;
    public String qRS = "";
    private List<List<Integer>> qRT = new LinkedList();
    private List<Integer> qRU = new LinkedList();
    private LinkedList<c> qRW = new LinkedList();
    public String qRm = "";
    public long qRn = 0;
    public String qRr = "";
    public int qRs = 0;
    public int qRt = 0;
    public long qRu = 0;
    public long qRv = 0;
    public String qRw = "";
    public long qRx = 0;
    public long qRy = 0;
    public String qRz = "";

    public static g buo() {
        com.tencent.mm.kernel.g.Dk();
        if (!com.tencent.mm.kernel.g.Dh().Cy()) {
            return new g();
        }
        c fn = com.tencent.mm.z.c.c.IF().fn("100068");
        String str = fn.field_rawXML;
        if (bh.ov(str)) {
            str = "";
        }
        String s = com.tencent.mm.a.g.s(str.getBytes());
        if (qRq == null || !s.equals(qRp)) {
            x.i("MicroMsg.NewYearSnsCtrlV2", "create newYearSnsCtrl");
            qRq = new g();
            try {
                Map chI = fn.chI();
                str = "";
                if (chI != null) {
                    str = (String) chI.get("SnsHBConfig");
                }
                if (bh.ov(str)) {
                    str = "";
                }
                str = URLDecoder.decode(str, "UTF-8");
                g gVar = qRq;
                gVar.kmW = new StringBuffer();
                gVar.qRW.clear();
                Map y = bi.y(str, "sysmsg");
                if (y == null) {
                    x.i("MicroMsg.NewYearSnsCtrlV2", "errr for paser %s", new Object[]{str});
                } else {
                    gVar.qRn = bh.VJ((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BeginTime"));
                    gVar.kmW.append("BeginTime:" + gVar.qRn + ";");
                    gVar.ktZ = bh.VJ((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EndTime"));
                    gVar.kmW.append("EndTime:" + gVar.ktZ + ";\n");
                    gVar.qRs = bh.VI((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMin"));
                    gVar.qRt = bh.VI((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.SvrDownReqLimitLevelMax"));
                    gVar.kmW.append("SvrDownReqLimitLevelMin:" + gVar.qRs + " SvrDownReqLimitLevelMax: " + gVar.qRt + ";\n");
                    gVar.qRx = bh.VJ((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseBeginTime"));
                    gVar.qRy = bh.VJ((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.BrowseEndTime"));
                    gVar.qRz = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenTitle"), "");
                    gVar.qRA = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenDescription"), "");
                    gVar.qRB = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenQueryTips"), "");
                    gVar.qRC = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenAcceptButtonText"), "");
                    gVar.qRD = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenRejectButtonText"), "");
                    gVar.qRE = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenTips"), "");
                    gVar.qRG = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenSuccTips"), "");
                    gVar.qRH = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetOpenFailTips"), "");
                    gVar.qRF = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseTips"), "");
                    gVar.qRI = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseSuccTips"), "");
                    gVar.qRJ = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.ActionSheetCloseFailTips"), "");
                    gVar.qRQ = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedID"), "");
                    gVar.qRR = bh.VI((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.MaxPostFeedCount"));
                    gVar.qRS = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.FullScreenID"), "");
                    if (gVar.qRR <= 0) {
                        x.i("MicroMsg.NewYearSnsCtrlV2", "svr MaxPostFeedCount error " + gVar.qRR);
                        gVar.qRR = 1;
                    }
                    gVar.kmW.append("FullScreenID:" + gVar.qRS + " BrowseBeginTime:" + gVar.qRx + " BrowseEndTime:" + gVar.qRy + " FullScreenTitle:" + gVar.qRz + " FullScreenDescription:" + gVar.qRA + " FullScreenQueryTips:" + gVar.qRB + " FullScreenAcceptButtonText: " + gVar.qRC);
                    gVar.kmW.append("FullScreenRejectButtonText:" + gVar.qRD + " ActionSheetOpenTips:" + gVar.qRE + " ActionSheetOpenSuccTips:" + gVar.qRG + " ActionSheetOpenFailTips:" + gVar.qRH + " ActionSheetCloseTips:" + gVar.qRF + " ActionSheetCloseSuccTips: " + gVar.qRI + " ActionSheetCloseFailTips: " + gVar.qRJ + "MaxPostFeedID: " + gVar.qRQ + " MaxPostFeedCount:" + gVar.qRR);
                    gVar.qRK = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForHasUsed"), "");
                    gVar.qRL = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForObtainUsedRight"), "");
                    gVar.qRM = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertTipForClosedBrowseSwitch"), "");
                    gVar.qRN = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.AlertButtonText"), "");
                    gVar.qRO = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTip"), "");
                    gVar.qRP = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.GoldenCameraTipID"), "");
                    gVar.kmW.append("AlertTipForHasUsed:" + gVar.qRK + " AlertTipForObtainUsedRight:" + gVar.qRL + " AlertTipForClosedBrowseSwitch:" + gVar.qRM + " AlertButtonText:" + gVar.qRN + " GoldenCameraTip:" + gVar.qRO + " GoldenCameraTipID:" + gVar.qRP);
                    int i = 0;
                    while (true) {
                        String str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "RedPointID";
                        gVar.qRm = bh.az((String) y.get(String.format(str2, objArr)), "");
                        gVar.kmW.append("RedPointID:" + gVar.qRm + ";");
                        if (bh.ov(gVar.qRm)) {
                            break;
                        }
                        str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "BeginTime";
                        gVar.qRu = bh.VJ((String) y.get(String.format(str2, objArr)));
                        gVar.kmW.append("RedPointID_BeginTime:" + gVar.qRu + ";");
                        str2 = ".sysmsg.NewYearSNSCtrl2016.Entrance.RedPoints%s.%s";
                        objArr = new Object[2];
                        objArr[0] = i == 0 ? "" : String.valueOf(i);
                        objArr[1] = "EndTime";
                        gVar.qRv = bh.VJ((String) y.get(String.format(str2, objArr)));
                        gVar.kmW.append("RedPointID_EndTime:" + gVar.qRv + ";\n");
                        c cVar = new c();
                        cVar.qRm = gVar.qRm;
                        cVar.qRn = gVar.qRu;
                        cVar.ktZ = gVar.qRv;
                        gVar.qRW.add(cVar);
                        i++;
                    }
                    gVar.qRw = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.PostTips"), "");
                    gVar.kmW.append("PostTips:" + gVar.qRw + ";");
                    gVar.qRr = bh.az((String) y.get(".sysmsg.NewYearSNSCtrl2016.Entrance.EntranceTips"), "");
                    gVar.kmW.append("EntranceTips:" + gVar.qRr + ";");
                    gVar.qRT.clear();
                    int i2 = 0;
                    while (true) {
                        int VI = bh.VI((String) y.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Count"));
                        gVar.kmW.append("count: " + i2 + " | " + VI + ";\n");
                        if (VI == 0) {
                            break;
                        }
                        List linkedList = new LinkedList();
                        i = 0;
                        while (i < VI) {
                            int VI2 = bh.VI((String) y.get(".sysmsg.NewYearSNSCtrl2016.AmountLevel" + i2 + ".Amount" + (i == 0 ? "" : Integer.valueOf(i))));
                            linkedList.add(Integer.valueOf(VI2));
                            gVar.kmW.append("AmountLevel : " + i2 + " index " + i + " val: " + VI2 + ";");
                            i++;
                        }
                        gVar.qRT.add(linkedList);
                        i2++;
                    }
                    x.i("MicroMsg.NewYearSnsCtrlV2", "dumpinfo " + gVar.kmW.toString());
                }
                qRp = s;
            } catch (Exception e) {
                x.e("MicroMsg.NewYearSnsCtrlV2", "createctrl error " + e.getMessage());
            }
        }
        return qRq;
    }

    public static boolean bup() {
        com.tencent.mm.kernel.g.Dk();
        return ((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(a.xqI, Boolean.valueOf(true))).booleanValue();
    }

    public final void buq() {
        i h = k.h(a.xqM);
        if (h.raW == null || bh.ov(h.raW.raT)) {
            h.raW = new com.tencent.mm.plugin.sns.g.g();
            h.raW.raT = this.qRQ;
            h.raW.raU = 0;
        }
        if (bh.ov(h.raW.raT) || !h.raW.raT.equals(this.qRQ)) {
            h.raW = new com.tencent.mm.plugin.sns.g.g();
            h.raW.raT = this.qRQ;
            h.raW.raU = 0;
        } else {
            com.tencent.mm.plugin.sns.g.g gVar = h.raW;
            gVar.raU--;
            if (h.raW.raU < 0) {
                h.raW.raU = 0;
            }
        }
        x.i("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 " + h.raW.raU + " postId: " + this.qRQ + " " + bh.cgy().toString());
        try {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dj().CU().a(a.xqM, new String(h.toByteArray(), Charset.forName("ISO-8859-1")));
        } catch (IOException e) {
            x.w("MicroMsg.NewYearSnsCtrlV2", "minusPostCountV2 save exception:" + e.getLocalizedMessage());
        }
        com.tencent.mm.sdk.b.a.xef.m(new pl());
    }
}
