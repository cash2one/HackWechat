package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.n;
import com.tencent.mm.z.d;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import com.tencent.wcdb.FileUtils;

@a(19)
public class VideoAdPlayerUI extends MMActivity implements b.a, b.b {
    private String bssid;
    private String fGG;
    private String fvC = "";
    private String hDC = "";
    private String hdr = "";
    private String hds = "";
    private String iTh = "";
    private d jtl;
    private boolean lio = false;
    private String mediaId = "";
    private boolean qQH = false;
    private h rGn = new h("VideoAdPlayerUI");
    private VideoPlayView rNb;
    private com.tencent.mm.modelsns.b rNc = null;
    private String rNd = "";
    private int rNe = 0;
    private String rNf = "";
    public String rNg = "";
    public String rNh = "";
    private int rNi = 0;
    private int rNj = 0;
    private String rNk = "";
    private String rNl;
    private String rNm = "";
    private long rNn = 0;
    private int rNo = 0;
    private int rNp = 0;
    private boolean rNq = false;
    private boolean rNr = false;
    private aqr rNs = null;
    private String rNt;
    private int rNu;
    private String[] rNv = null;
    private String[] rNw = null;
    private String rgK = "";
    private m ryi;
    private String ssid;
    private String thumbUrl = "";
    private String url = "";

    static /* synthetic */ void o(VideoAdPlayerUI videoAdPlayerUI) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_link", videoAdPlayerUI.rNd);
        intent.putExtra("Ksnsupload_type", 11);
        intent.putExtra("Ksnsupload_title", videoAdPlayerUI.rNf);
        intent.putExtra("Ksnsupload_imgurl", videoAdPlayerUI.thumbUrl);
        intent.putExtra("KSnsStreamVideoTotalTime", videoAdPlayerUI.rNs.rNe);
        intent.putExtra("KSnsStreamVideoWroding", videoAdPlayerUI.hdr);
        intent.putExtra("KSnsStreamVideoWebUrl", videoAdPlayerUI.hds);
        intent.putExtra("KSnsStreamVideoAduxInfo", videoAdPlayerUI.rNg);
        intent.putExtra("KSnsStreamVideoPublishId", videoAdPlayerUI.rNh);
        intent.putExtra("need_result", true);
        intent.putExtra("key_snsad_statextstr", videoAdPlayerUI.fGG);
        String str = "sns_";
        if (videoAdPlayerUI.rNj == j.b.qPU.value || videoAdPlayerUI.rNj == j.b.qPV.value) {
            str = "sns_" + videoAdPlayerUI.rNm;
        } else if (videoAdPlayerUI.rNj == j.b.qPW.value || videoAdPlayerUI.rNj == j.b.qPX.value) {
            str = "msg_" + videoAdPlayerUI.rNn;
        } else if (videoAdPlayerUI.rNj == j.b.qPY.value) {
            str = "fav_" + q.FS() + "_" + videoAdPlayerUI.rNo;
        }
        String hz = u.hz(str);
        u.GK().t(hz, true).o("prePublishId", str);
        intent.putExtra("reportSessionId", hz);
        com.tencent.mm.bm.d.b(videoAdPlayerUI, "sns", ".ui.SnsUploadUI", intent, 4098);
        if (videoAdPlayerUI.rNu != 0) {
            int i = videoAdPlayerUI.rGn.qPt.qQr;
            if (videoAdPlayerUI.lio && videoAdPlayerUI.rGn.qPt.qQv != 0) {
                i += (int) (bh.bA(videoAdPlayerUI.rGn.qPt.qQv) / 1000);
            }
            k iVar = new i(13228, "1,4," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + bh.Wo() + "," + videoAdPlayerUI.rNt + "," + videoAdPlayerUI.rNe, (int) bh.Wo());
            g.Dk();
            g.Di().gPJ.a(iVar, 0);
        }
    }

    static /* synthetic */ void p(VideoAdPlayerUI videoAdPlayerUI) {
        com.tencent.mm.sdk.b.b cfVar = new cf();
        ((com.tencent.mm.plugin.fav.a.q) g.h(com.tencent.mm.plugin.fav.a.q.class)).a(cfVar, videoAdPlayerUI.rNs.rNe, videoAdPlayerUI.rNf, "", videoAdPlayerUI.rNs.wxL, videoAdPlayerUI.hdr, videoAdPlayerUI.hds, videoAdPlayerUI.thumbUrl, videoAdPlayerUI.fvC, videoAdPlayerUI.rNk, videoAdPlayerUI.rNg, videoAdPlayerUI.rNh, videoAdPlayerUI.fGG);
        cfVar.fqp.activity = videoAdPlayerUI;
        cfVar.fqp.fqw = 24;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
        if (cfVar.fqq.ret == 0 && videoAdPlayerUI.rNj != 0) {
            j.a(c.qQa, videoAdPlayerUI.rNh, videoAdPlayerUI.rNg, videoAdPlayerUI.rNi, videoAdPlayerUI.rNj, videoAdPlayerUI.rNk, videoAdPlayerUI.rNl, videoAdPlayerUI.rNm, videoAdPlayerUI.rNn, videoAdPlayerUI.rNo, videoAdPlayerUI.rNp, 0);
        }
        if (videoAdPlayerUI.qQH) {
            k cVar = new com.tencent.mm.plugin.sns.a.b.c(videoAdPlayerUI.iTh, 11, 6, "", 2, videoAdPlayerUI.ryi.bxW());
            g.Dk();
            g.Di().gPJ.a(cVar, 0);
        }
        if (videoAdPlayerUI.rNu != 0) {
            int i = videoAdPlayerUI.rGn.qPt.qQr;
            if (videoAdPlayerUI.lio && videoAdPlayerUI.rGn.qPt.qQv != 0) {
                i += (int) (bh.bA(videoAdPlayerUI.rGn.qPt.qQv) / 1000);
            }
            k iVar = new i(13228, "1,5," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + bh.Wo() + "," + videoAdPlayerUI.rNt + "," + videoAdPlayerUI.rNe, (int) bh.Wo());
            g.Dk();
            g.Di().gPJ.a(iVar, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.rNv = new String[]{getString(com.tencent.mm.plugin.sns.i.j.qKc), getString(com.tencent.mm.plugin.sns.i.j.qKd), getString(com.tencent.mm.plugin.sns.i.j.qKb)};
        this.rNw = new String[]{getString(com.tencent.mm.plugin.sns.i.j.qKc), getString(com.tencent.mm.plugin.sns.i.j.qKd)};
        this.ryi = ae.bvv().Ll(com.tencent.mm.plugin.sns.data.i.lS(getIntent().getStringExtra("KSta_SnSId")));
        this.jtl = new d();
        this.rNc = com.tencent.mm.modelsns.b.q(getIntent());
        this.hDC = getIntent().getStringExtra("KFullVideoPath");
        this.rNd = getIntent().getStringExtra("KStremVideoUrl");
        this.thumbUrl = getIntent().getStringExtra("KThumUrl");
        this.mediaId = getIntent().getStringExtra("KMediaId");
        this.qQH = getIntent().getBooleanExtra("IsAd", false);
        this.url = getIntent().getStringExtra("KUrl");
        this.rNf = bh.az(getIntent().getStringExtra("KMediaTitle"), "");
        this.rNe = getIntent().getIntExtra("KMediaVideoTime", 0);
        this.rNq = getIntent().getBooleanExtra("KBlockFav", false);
        this.rNr = getIntent().getBooleanExtra("ForceLandscape", false);
        this.hdr = getIntent().getStringExtra("StreamWording");
        this.hds = getIntent().getStringExtra("StremWebUrl");
        this.rgK = getIntent().getStringExtra("KComponentCid");
        this.rNg = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
        this.rNh = getIntent().getStringExtra("KSta_StremVideoPublishId");
        this.rNi = getIntent().getIntExtra("KSta_SourceType", 0);
        this.rNj = getIntent().getIntExtra("KSta_Scene", 0);
        this.rNk = getIntent().getStringExtra("KSta_FromUserName");
        this.rNl = getIntent().getStringExtra("KSta_ChatName");
        this.rNm = getIntent().getStringExtra("KSta_SnSId");
        this.rNn = getIntent().getLongExtra("KSta_MsgId", 0);
        this.rNo = getIntent().getIntExtra("KSta_FavID", 0);
        this.rNp = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
        this.fGG = getIntent().getStringExtra("KSta_SnsStatExtStr");
        this.iTh = bh.az(getIntent().getStringExtra("KViewId"), "");
        this.rNt = bh.az(getIntent().getStringExtra("ReportArgs"), "");
        this.rNu = getIntent().getIntExtra("NeedReportData", 0);
        if (this.rNu != 0) {
            WifiInfo connectionInfo = ((WifiManager) getSystemService("wifi")).getConnectionInfo();
            this.ssid = connectionInfo.getSSID();
            this.bssid = connectionInfo.getBSSID();
        }
        this.rNs = new aqr();
        this.rNs.wxE = this.thumbUrl;
        this.rNs.wxL = this.rNd;
        this.rNs.nGJ = this.mediaId;
        this.rNs.nfX = this.url;
        this.rNs.wxD = 1;
        this.rNs.rNe = this.rNe;
        this.rGn.qPn = bh.Wq();
        x.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.rNs.nGJ + " attachurl:" + this.rNs.wxL + " videoattachTotalTime:" + this.rNs.rNe + " streamvideowording: " + this.hdr + " streamvideoweburl: " + this.hds + " mediaTitle: " + this.rNf + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.rNg + " streamvideopublishid " + this.rNh);
        if (bh.ov(this.hDC)) {
            String r = am.r(ae.getAccSnsPath(), this.rNs.nGJ);
            this.hDC = r + com.tencent.mm.plugin.sns.data.i.k(this.rNs);
        }
        if (bh.ov(this.fvC) || !e.bO(this.fvC)) {
            r = "attach" + this.rNs.nGJ;
            this.fvC = am.r(ae.getAccSnsPath(), r) + com.tencent.mm.plugin.sns.data.i.JD(r);
        }
        if (!e.bO(this.fvC)) {
            try {
                aqr com_tencent_mm_protocal_c_aqr = new aqr();
                com_tencent_mm_protocal_c_aqr.aF(this.rNs.toByteArray());
                com_tencent_mm_protocal_c_aqr.nGJ = "attach" + com_tencent_mm_protocal_c_aqr.nGJ;
                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(this.rNs);
                eVar.qQR = 1;
                eVar.hKZ = this.rNs.nGJ;
                ae.bvq().a(com_tencent_mm_protocal_c_aqr, 7, eVar, an.xyY);
            } catch (Exception e) {
                x.e("MicroMsg.VideoPlayerUI", "error for download thumb");
            }
            getWindow().addFlags(FileUtils.S_IWUSR);
        }
        this.rNb = (VideoPlayView) findViewById(f.qGd);
        VideoPlayView videoPlayView = this.rNb;
        com.tencent.mm.plugin.sight.decode.ui.a adVideoPlayerLoadingBar = new AdVideoPlayerLoadingBar(this.mController.xIM);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BackwardSupportUtil.b.b(videoPlayView.getContext(), videoPlayView.getContext().getResources().getDimension(com.tencent.mm.plugin.ah.a.c.qyJ));
        videoPlayView.qvd = adVideoPlayerLoadingBar;
        videoPlayView.kTe.id(true);
        videoPlayView.addView((View) videoPlayView.qvd, layoutParams);
        videoPlayView.qvd.a(new 5(videoPlayView));
        videoPlayView.qvd.i(new 6(videoPlayView));
        videoPlayView.qvd.db(videoPlayView.kTe.isPlaying());
        if (videoPlayView.qvd != null) {
            ((View) videoPlayView.qvd).setVisibility(8);
        }
        adVideoPlayerLoadingBar.seek(0);
        this.rNb.qvb = new 1(this);
        VideoPlayView videoPlayView2 = this.rNb;
        int i = this.rNs.rNe;
        if (videoPlayView2.qvd.bsW() != i) {
            videoPlayView2.qvd.wl(i);
        }
        if (e.bO(this.hDC)) {
            this.rGn.qPl = 1;
            this.rNb.setVideoPath(this.hDC);
        } else {
            this.rNb.btd();
            this.rNb.ib(true);
            ae.bvq().a(this.rNs, 6, null, an.xyY);
        }
        videoPlayView2 = this.rNb;
        videoPlayView2.qvh.setOnClickListener(new 2(this));
        videoPlayView2 = this.rNb;
        videoPlayView2.qvi.setOnClickListener(new 3(this));
        videoPlayView2 = this.rNb;
        CharSequence charSequence = this.hdr;
        OnClickListener 4 = new 4(this);
        videoPlayView2.qvg = charSequence;
        videoPlayView2.qvf.setText(charSequence);
        videoPlayView2.qvf.setOnClickListener(4);
        this.rNb.btf();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0) {
            videoPlayView2 = this.rNb;
            if (videoPlayView2.qvi != null) {
                videoPlayView2.qvj = false;
                videoPlayView2.qvi.setVisibility(8);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", Integer.valueOf(i));
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : bh.F(stringExtra.split(","))) {
                    int i3;
                    x.i("MicroMsg.VideoPlayerUI", "send sight to %s", str);
                    com.tencent.mm.y.g.a aVar = new com.tencent.mm.y.g.a();
                    aVar.title = this.rNf;
                    aVar.type = 4;
                    if (bh.ov(this.rNs.nfX)) {
                        aVar.url = this.rNs.wxL;
                    } else {
                        aVar.url = this.rNs.nfX;
                    }
                    if (bh.ov(this.rNs.wxO)) {
                        stringExtra = this.rNs.wxE;
                    } else {
                        stringExtra = this.rNs.wxO;
                    }
                    aVar.thumburl = stringExtra;
                    aVar.hdo = this.rNs.wxL;
                    aVar.hdp = this.rNs.rNe;
                    aVar.hdq = this.rNf;
                    aVar.hds = this.hds;
                    aVar.hdr = this.hdr;
                    aVar.hdt = this.thumbUrl;
                    aVar.hdu = this.rNg;
                    aVar.hdv = this.rNh;
                    aVar.fGG = this.fGG;
                    byte[] d = FileOp.d(this.fvC, 0, -1);
                    String str2 = "MicroMsg.VideoPlayerUI";
                    String str3 = "read buf size %d";
                    Object[] objArr = new Object[1];
                    if (d == null) {
                        i3 = 0;
                    } else {
                        i3 = d.length;
                    }
                    objArr[0] = Integer.valueOf(i3);
                    x.i(str2, str3, objArr);
                    if (n.a.EN() != null) {
                        n.a.EN().a(aVar, "", "", str, "", d);
                    }
                    if (this.rNu != 0) {
                        i3 = this.rGn.qPt.qQr;
                        if (this.lio && this.rGn.qPt.qQv != 0) {
                            i3 += (int) (bh.bA(this.rGn.qPt.qQv) / 1000);
                        }
                        k iVar = new i(13228, "1,3," + i3 + "," + this.ssid + "," + this.bssid + "," + bh.Wo() + "," + this.rNt + "," + this.rNe, (int) bh.Wo());
                        g.Dk();
                        g.Di().gPJ.a(iVar, 0);
                    }
                    com.tencent.mm.plugin.messenger.a.f.aZh().dj(stringExtra2, str);
                    if (this.qQH) {
                        k cVar = new com.tencent.mm.plugin.sns.a.b.c(this.iTh, 12, 6, "", 2, this.ryi.bxW());
                        g.Dk();
                        g.Di().gPJ.a(cVar, 0);
                    }
                    if (this.rNj != 0) {
                        c cVar2;
                        int gl;
                        boolean eV = s.eV(str);
                        if (eV) {
                            cVar2 = c.qQc;
                        } else {
                            cVar2 = c.qQb;
                        }
                        String str4 = this.rNh;
                        str2 = this.rNg;
                        int i4 = this.rNi;
                        int i5 = this.rNj;
                        String str5 = this.rNk;
                        String str6 = this.rNl;
                        String str7 = this.rNm;
                        long j = this.rNn;
                        int i6 = this.rNo;
                        int i7 = this.rNp;
                        if (eV) {
                            gl = com.tencent.mm.z.m.gl(str);
                        } else {
                            gl = 0;
                        }
                        j.a(cVar2, str4, str2, i4, i5, str5, str6, str7, j, i6, i7, gl);
                    }
                }
                com.tencent.mm.ui.snackbar.a.h(this, getString(com.tencent.mm.plugin.sns.i.j.epb));
            } else if (this.qQH) {
                k cVar3 = new com.tencent.mm.plugin.sns.a.b.c(this.iTh, 13, 6, "", 2, this.ryi.bxW());
                g.Dk();
                g.Di().gPJ.a(cVar3, 0);
            }
        }
        if (4098 == i) {
            if (this.rNj != 0) {
                j.a(c.qQd, this.rNh, this.rNg, this.rNi, this.rNj, this.rNk, this.rNl, this.rNm, this.rNn, this.rNo, this.rNp, 0);
            }
            if (-1 == i2) {
                if (this.qQH) {
                    cVar3 = new com.tencent.mm.plugin.sns.a.b.c(this.iTh, 15, 6, "", 2, this.ryi.bxW());
                    g.Dk();
                    g.Di().gPJ.a(cVar3, 0);
                }
            } else if (this.qQH) {
                cVar3 = new com.tencent.mm.plugin.sns.a.b.c(this.iTh, 16, 6, "", 2, this.ryi.bxW());
                g.Dk();
                g.Di().gPJ.a(cVar3, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(FileUtils.S_IWUSR);
        if (this.rNj != 0) {
            j.a(j.a.qPQ, this.rNh, this.rNg, this.rNi, this.rNj, this.rNk, this.rNl, this.rNm, this.rNn, this.rNo, this.rNp);
        }
        if (this.qQH) {
            int byC = this.ryi == null ? 0 : this.ryi.byC();
            String btZ = this.rGn.btZ();
            long j = ((long) this.rGn.qPm) - this.rGn.hOD;
            if (j < 0) {
                x.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", Integer.valueOf(this.rGn.qPm), Long.valueOf(this.rGn.hOD));
                j = (long) this.rGn.qPm;
            }
            int i = (int) j;
            g.Dk();
            g.Di().gPJ.a(new com.tencent.mm.plugin.sns.a.b.d(this.iTh, 6, 2, this.rGn.qPm, null, null, 2, btZ, -1, byC, i, i, 0), 0);
        }
        if (this.rNu != 0) {
            int i2 = this.rGn.qPt.qQr;
            if (this.lio && this.rGn.qPt.qQv != 0) {
                i2 += (int) (bh.bA(this.rGn.qPt.qQv) / 1000);
            }
            k iVar = new i(13228, "1,2," + i2 + "," + this.ssid + "," + this.bssid + "," + bh.Wo() + "," + this.rNt + "," + this.rNe, (int) bh.Wo());
            g.Dk();
            g.Di().gPJ.a(iVar, 0);
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", cmZ()));
    }

    public void finish() {
        if (this.lio) {
            this.rNb.pause();
        }
        if (!(this.rGn == null || this.rgK == null || this.rgK.length() <= 0)) {
            this.rGn.bua();
            Intent intent = new Intent();
            intent.putExtra("KComponentCid", this.rgK);
            intent.putExtra("KStreamVideoPlayCount", this.rGn.qPp);
            intent.putExtra("KStreamVideoPlayCompleteCount", this.rGn.qPq);
            intent.putExtra("KStreamVideoTotalPlayTimeInMs", this.rGn.qPr);
            setResult(-1, intent);
        }
        super.finish();
    }

    protected void onPause() {
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        x.i("MicroMsg.VideoPlayerUI", "onpause  " + i);
        xL(i);
        if (this.rNb != null && this.rNb.isPlaying()) {
            this.rNb.pause();
        }
        if (this.rNb != null) {
            x.i("MicroMsg.VideoPlayerUI", "onDetach");
            this.rNb.onDetach();
        }
        ae.bvq().qSC.remove(this);
        ae.bvq().b(this);
        if (this.rGn != null) {
            this.rGn.hOC = bh.Wq();
        }
    }

    protected void onResume() {
        super.onResume();
        ae.bvq().qSC.add(this);
        ae.bvq().a(this);
        if (this.rGn != null) {
            this.rGn.onResume();
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.qIt;
    }

    public final void dY(String str, String str2) {
        x.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.rNb.isPlaying());
        if (!this.rNb.isPlaying()) {
            this.rNb.cP(false);
            if (str2.equals(this.rNb.hDC)) {
                this.rNb.q(this.rNb.btg());
                this.rNb.start();
                x.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + str + " path: " + str2);
                return;
            }
            this.rNb.setVideoPath(str2);
            this.rNb.q(this.rNb.btg());
            x.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + str + " path: " + str2);
        }
    }

    public final void JT(String str) {
    }

    public final void aE(String str, boolean z) {
    }

    public final void bun() {
    }

    public final void aF(String str, boolean z) {
        x.i("MicroMsg.VideoPlayerUI", "onSightFinish " + str);
        this.rNb.ib(false);
        this.rNb.setVideoPath(this.hDC);
        this.rNb.q(this.rNb.btg());
        this.rNb.cP(false);
        if (this.qQH && !bh.ov(str) && this.rNs != null && str.equals(this.rNs.nGJ) && FileOp.bO(this.hDC)) {
            this.rGn.qPl = 1;
        }
    }

    protected final int getForceOrientation() {
        if (this.rNr) {
            return 0;
        }
        return 4;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VideoPlayView videoPlayView = this.rNb;
        x.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + configuration.orientation + " " + videoPlayView.qvs);
        if (videoPlayView.qvs != configuration.orientation) {
            if (configuration.orientation == 1) {
                videoPlayView.update(1);
            } else {
                videoPlayView.update(2);
            }
            videoPlayView.qvs = configuration.orientation;
            if (videoPlayView.qvs == 2) {
                videoPlayView.jWc.setVisibility(8);
            }
        }
        xL(configuration.orientation);
    }

    private void xL(int i) {
        if (this.qQH) {
            this.rGn.wr(this.rNb.getDuration());
            this.rGn.qPt.qQv = bh.Wq();
            this.rGn.qPt.qQu = i == 2 ? 2 : 1;
            this.rGn.qPt.qQt = 2;
            x.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.rGn.qPt.qQu);
        }
    }
}
