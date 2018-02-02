package com.tencent.mm.plugin.sns.ui;

import android.support.v4.content.d;
import android.text.TextUtils;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SnsAdNativeLandingPagesUI$15 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

    SnsAdNativeLandingPagesUI$15(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.ryv = snsAdNativeLandingPagesUI;
    }

    public final void run() {
        AdlandingRemoteServiceConnectedReceiver.b(d.m(this.ryv));
        SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = this.ryv;
        snsAdNativeLandingPagesUI.ryi = AdLandingPagesProxy.getInstance().getSnsInfo(snsAdNativeLandingPagesUI.fzW);
        AdLandingPagesProxy.getInstance().asyncCacheXml(snsAdNativeLandingPagesUI.fzW);
        if (snsAdNativeLandingPagesUI.values == null) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + snsAdNativeLandingPagesUI.rxI);
        } else {
            String valueOf;
            if (snsAdNativeLandingPagesUI.cOY == 1 || snsAdNativeLandingPagesUI.cOY == 2 || snsAdNativeLandingPagesUI.cOY == 14 || snsAdNativeLandingPagesUI.cOY == 9 || snsAdNativeLandingPagesUI.cOY == 10) {
                long j = 0;
                if (snsAdNativeLandingPagesUI.ryi != null) {
                    j = snsAdNativeLandingPagesUI.ryi.field_snsId;
                    if (TextUtils.isEmpty(snsAdNativeLandingPagesUI.reb)) {
                        snsAdNativeLandingPagesUI.reb = AdLandingPagesProxy.getInstance().getSnsAid(snsAdNativeLandingPagesUI.fzW);
                    }
                    if (TextUtils.isEmpty(snsAdNativeLandingPagesUI.iUN)) {
                        snsAdNativeLandingPagesUI.iUN = AdLandingPagesProxy.getInstance().getSnsTraceid(snsAdNativeLandingPagesUI.fzW);
                    }
                    snsAdNativeLandingPagesUI.hOz = AdLandingPagesProxy.getInstance().getSnsAdType(snsAdNativeLandingPagesUI.fzW);
                    snsAdNativeLandingPagesUI.rec = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(snsAdNativeLandingPagesUI.fzW);
                }
                valueOf = snsAdNativeLandingPagesUI.rxQ != null ? snsAdNativeLandingPagesUI.rxQ : String.valueOf(j);
                snsAdNativeLandingPagesUI.values.put("." + snsAdNativeLandingPagesUI.rxJ + ".originSnsId", valueOf);
                snsAdNativeLandingPagesUI.values.put("." + snsAdNativeLandingPagesUI.rxJ + ".originUxInfo", snsAdNativeLandingPagesUI.qZM);
                CharSequence charSequence = ((((("<" + snsAdNativeLandingPagesUI.rxJ + ">") + String.format("<originSnsId>%s</originSnsId>", new Object[]{valueOf})) + String.format("<originUxInfo>%s</originUxInfo>", new Object[]{snsAdNativeLandingPagesUI.qZM})) + String.format("<originAdType>%d</originAdType>", new Object[]{Integer.valueOf(snsAdNativeLandingPagesUI.hOz)})) + String.format("<originAid>%s</originAid>", new Object[]{snsAdNativeLandingPagesUI.reb})) + String.format("<originTraceId>%s</originTraceId>", new Object[]{snsAdNativeLandingPagesUI.iUN});
                if (!bh.ov(snsAdNativeLandingPagesUI.rec)) {
                    charSequence = charSequence + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[]{snsAdNativeLandingPagesUI.rec});
                }
                snsAdNativeLandingPagesUI.rxI = snsAdNativeLandingPagesUI.rxI.replace("<" + snsAdNativeLandingPagesUI.rxJ + ">", charSequence);
                snsAdNativeLandingPagesUI.rxT.qZM = snsAdNativeLandingPagesUI.qZM;
                snsAdNativeLandingPagesUI.rxT.fzW = valueOf;
            } else {
                snsAdNativeLandingPagesUI.rxT.fzW = (String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".originSnsId");
                snsAdNativeLandingPagesUI.rxT.qZM = (String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".originUxInfo");
                snsAdNativeLandingPagesUI.qZM = snsAdNativeLandingPagesUI.rxT.qZM;
                snsAdNativeLandingPagesUI.hOz = bh.VI((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".originAdType"));
                Matcher matcher = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(snsAdNativeLandingPagesUI.rxI);
                if (matcher.find()) {
                    valueOf = matcher.group();
                    if (!bh.ov(valueOf)) {
                        snsAdNativeLandingPagesUI.rec = valueOf.replaceAll("</?originAdCanvasExt>", "");
                    }
                }
            }
            if (bh.ov(snsAdNativeLandingPagesUI.rxT.fzW)) {
                snsAdNativeLandingPagesUI.rxT.fzW = snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_rawSnsId");
            }
            snsAdNativeLandingPagesUI.rxT.rou = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(bh.VJ(snsAdNativeLandingPagesUI.rxT.fzW));
            snsAdNativeLandingPagesUI.lOY = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.shareTitle"), "");
            snsAdNativeLandingPagesUI.lOX = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.shareWebUrl"), "");
            snsAdNativeLandingPagesUI.rfu = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.shareDesc"), "");
            snsAdNativeLandingPagesUI.rha = bh.VI(bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.bizId"), ""));
            snsAdNativeLandingPagesUI.rxX = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.shareAppId"), "");
            snsAdNativeLandingPagesUI.rxY = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.shareType"), "");
            snsAdNativeLandingPagesUI.rxZ = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.userInfo"), "");
            snsAdNativeLandingPagesUI.ryc = bh.VI(bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.disableShareBitSet"), ""));
            snsAdNativeLandingPagesUI.ryd = bh.VI(bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.statusBarStyle"), ""));
            Map map = snsAdNativeLandingPagesUI.values;
            String str = "." + snsAdNativeLandingPagesUI.rxJ;
            valueOf = (String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
            if (TextUtils.isEmpty(valueOf)) {
                snsAdNativeLandingPagesUI.rmT = null;
            } else {
                if (snsAdNativeLandingPagesUI.rmT == null) {
                    snsAdNativeLandingPagesUI.rmT = new z();
                }
                snsAdNativeLandingPagesUI.rmT.iconUrl = valueOf;
                int VI = bh.VI((String) map.get(str + ".adCanvasInfo.sizeType"));
                int VI2 = bh.VI((String) map.get(str + ".adCanvasInfo.basicRootFontSize"));
                int VI3 = bh.VI((String) map.get(str + ".adCanvasInfo.basicWidth"));
                int i = (VI2 == 0 && VI == 1) ? e.rnY : VI2;
                VI2 = (VI3 == 0 && VI == 1) ? e.rnX : VI3;
                snsAdNativeLandingPagesUI.rmT.rgN = e.a(bh.VK((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), VI, VI2, i);
                snsAdNativeLandingPagesUI.rmT.width = e.a(bh.VK((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), VI, VI2, i);
                snsAdNativeLandingPagesUI.rmT.height = e.a(bh.VK((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), VI, VI2, i);
            }
            snsAdNativeLandingPagesUI.uin = AdLandingPagesProxy.getInstance().getUin();
            snsAdNativeLandingPagesUI.rya = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.officialSyncBuffer"), "");
            snsAdNativeLandingPagesUI.bAd();
            snsAdNativeLandingPagesUI.getIntent().putExtra("sns_landing_pages_adType", snsAdNativeLandingPagesUI.hOz);
            snsAdNativeLandingPagesUI.getIntent().putExtra("sns_landing_pages_rawSnsId", snsAdNativeLandingPagesUI.rxT.fzW);
            if (bh.ov(snsAdNativeLandingPagesUI.reb)) {
                snsAdNativeLandingPagesUI.reb = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".originAid"), "");
            }
            if (bh.ov(snsAdNativeLandingPagesUI.iUN)) {
                snsAdNativeLandingPagesUI.iUN = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".originTraceId"), "");
            }
            snsAdNativeLandingPagesUI.rxB = e.m(snsAdNativeLandingPagesUI.rxI, snsAdNativeLandingPagesUI.rxJ, snsAdNativeLandingPagesUI.reb, snsAdNativeLandingPagesUI.iUN);
            if (snsAdNativeLandingPagesUI.rxB.size() > 0) {
                String str2 = "";
                c cVar = (c) snsAdNativeLandingPagesUI.rxB.get(0);
                if (cVar.rnP.size() > 0) {
                    s sVar = (s) cVar.rnP.get(0);
                    if (sVar instanceof p) {
                        snsAdNativeLandingPagesUI.rxP = ((p) sVar).rgz;
                    } else if (sVar instanceof o) {
                        snsAdNativeLandingPagesUI.rxP = ((o) sVar).rgz;
                    } else if (sVar instanceof q) {
                        snsAdNativeLandingPagesUI.rxP = ((q) sVar).rgC;
                        str2 = ((q) sVar).rgB;
                    } else if (sVar instanceof n) {
                        n nVar = (n) sVar;
                        if (!nVar.rgv.isEmpty()) {
                            m mVar = (m) nVar.rgv.getFirst();
                            if (!mVar.rgv.isEmpty()) {
                                sVar = (s) mVar.rgv.getFirst();
                                if (sVar instanceof p) {
                                    snsAdNativeLandingPagesUI.rxP = ((p) sVar).rgz;
                                }
                            }
                        }
                    }
                }
                if (snsAdNativeLandingPagesUI.ryi != null) {
                    bnp bxV = snsAdNativeLandingPagesUI.ryi.bxV();
                    if (!(bxV == null || bxV.wQo == null || bxV.wQo.vYd == null || bxV.wQo.vYd.isEmpty())) {
                        aqr com_tencent_mm_protocal_c_aqr = (aqr) bxV.wQo.vYd.getFirst();
                        String str3 = am.r(AdLandingPagesProxy.getInstance().getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.j(com_tencent_mm_protocal_c_aqr);
                        valueOf = com_tencent_mm_protocal_c_aqr.nfX;
                        if (str2.equals(valueOf)) {
                            valueOf = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.ej("adId", valueOf);
                            if (!FileOp.bO(valueOf) && FileOp.bO(str3)) {
                                x.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", new Object[]{str3, valueOf});
                                FileOp.x(str3, valueOf);
                            }
                        }
                    }
                }
            }
            snsAdNativeLandingPagesUI.rxL = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.rightBarTitle"), "");
            snsAdNativeLandingPagesUI.rxM = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.rightBarCanvasId"), "");
            snsAdNativeLandingPagesUI.rxN = bh.az((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rxJ + ".adCanvasInfo.rightBarCanvasExt"), "");
        }
        SnsAdNativeLandingPagesUI.b(this.ryv);
        this.ryv.initView();
        SnsAdNativeLandingPagesUI.m(this.ryv);
        this.ryv.iG(true);
        SnsAdNativeLandingPagesUI.n(this.ryv);
    }
}
