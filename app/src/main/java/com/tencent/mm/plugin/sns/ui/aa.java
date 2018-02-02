package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.aq.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqt;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.protocal.c.bme;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;

public final class aa implements z {
    private String appId;
    private String appName;
    private String fGE;
    private String fGF;
    private String fGz;
    final MMActivity fmM;
    private int h = -1;
    String hOf = "";
    public String hdu = "";
    public String hdv = "";
    private Bitmap hkT = null;
    private String iKB;
    private TextView ihS = null;
    private View kpZ = null;
    private boolean oqy = false;
    private bzu qYw = null;
    private String rsg = "";
    private byte[] rsh = null;
    private String rsi;
    private int rsj;
    private CdnImageView rsk = null;
    private TextView rsl = null;
    private b rsp = null;
    private String rtA;
    private boolean rtB = false;
    private boolean rtC = false;
    private boolean rtD = false;
    private boolean rtE = false;
    private WXMediaMessage rtF = null;
    private String rtG = "";
    private String rtH = "";
    private String rtI;
    private String rtJ;
    private int rtK = 0;
    private b rtL = null;
    private int rtM = 0;
    private String rtN = "";
    private String rtO = "";
    private int rtP = 0;
    private String rtQ = "";
    private String rtR = "";
    String rtS = "";
    private boolean rty = false;
    private String rtz;
    private String title = "";
    private String videoUrl = "";
    private int w = -1;

    public aa(MMActivity mMActivity) {
        this.fmM = mMActivity;
    }

    public final void F(Bundle bundle) {
        this.rsp = b.q(this.fmM.getIntent());
        this.rtM = this.fmM.getIntent().getIntExtra("Ksnsupload_type", 0);
        this.rtP = this.fmM.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
        this.rtQ = bh.az(this.fmM.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
        this.rtR = bh.az(this.fmM.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
        this.hdu = bh.az(this.fmM.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
        this.hdv = bh.az(this.fmM.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
        this.w = this.fmM.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.h = this.fmM.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.rsj = this.fmM.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.rtA = bh.az(this.fmM.getIntent().getStringExtra("key_snsad_statextstr"), "");
        this.hOf = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.rsg = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.rsh = this.fmM.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (this.rsh == null && this.rtF != null && this.rtF.mediaObject != null && (this.rtF.mediaObject instanceof WXImageObject)) {
            this.rsh = ((WXImageObject) this.rtF.mediaObject).imageData;
        }
        this.oqy = this.fmM.getIntent().getBooleanExtra("ksnsis_video", false);
        this.rtB = this.fmM.getIntent().getBooleanExtra("ksnsis_music", false);
        this.rtC = this.fmM.getIntent().getBooleanExtra("ksnsis_appbrand", false);
        this.fGz = bh.az(this.fmM.getIntent().getStringExtra("src_username"), "");
        this.rsi = bh.az(this.fmM.getIntent().getStringExtra("src_displayname"), "");
        this.appId = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rtD = this.fmM.getIntent().getBooleanExtra("KThrid_app", false);
        this.rtE = this.fmM.getIntent().getBooleanExtra("KSnsAction", false);
        this.rtI = bh.az(this.fmM.getIntent().getStringExtra("ShareUrlOriginal"), "");
        this.rtJ = bh.az(this.fmM.getIntent().getStringExtra("ShareUrlOpen"), "");
        this.fGE = bh.az(this.fmM.getIntent().getStringExtra("JsAppId"), "");
        this.fGF = bh.az(this.fmM.getIntent().getStringExtra("KPublisherId"), "");
        this.iKB = bh.az(this.fmM.getIntent().getStringExtra("reportSessionId"), "");
        this.rtK = this.fmM.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
        this.rtS = this.fmM.getIntent().getStringExtra("fav_note_xml");
        this.rtN = bh.az(this.fmM.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
        this.rtO = bh.az(this.fmM.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
        this.rtz = bh.az(this.fmM.getIntent().getStringExtra("KlinkThumb_url"), "");
        if (this.rtz.startsWith("http://mmsns.qpic.cn") || this.rtz.startsWith("https://mmsns.qpic.cn")) {
            this.rsg = this.rtz;
            this.rsh = null;
            x.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[]{this.rtz});
        }
        Bundle bundleExtra = this.fmM.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rtF = new Req(bundleExtra).message;
            if (bh.ov(this.title)) {
                this.title = this.rtF.title;
            }
            if (bh.ov(this.rtH)) {
                this.rtH = this.rtF.description;
            }
            if (bh.bw(this.rsh)) {
                this.rsh = this.rtF.thumbData;
            }
        }
        byte[] byteArrayExtra = this.fmM.getIntent().getByteArrayExtra("KWebSearchInfo");
        if (byteArrayExtra != null) {
            this.qYw = new bzu();
            try {
                this.qYw.aF(byteArrayExtra);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.LinkWidget", e, "parse web search info failed", new Object[0]);
                this.qYw = null;
            }
        }
        String stringExtra = this.fmM.getIntent().getStringExtra("KSnsStrId");
        m Lm = ae.bvv().Lm(bh.az(this.fmM.getIntent().getStringExtra("KSnsLocalId"), ""));
        if (!bh.ov(stringExtra)) {
            this.rtL = b.iu(706);
            this.rtL.iy(this.rtL.hOF).mC(System.currentTimeMillis()).iy(this.rtL.hOH).iy(1).mC(stringExtra);
            if (Lm != null) {
                this.rtL.ix(Lm.field_type);
                this.rtL.bU(Lm.xl(32)).mB(Lm.byA()).mB(this.hOf);
            }
            f.rdF.b(this.rtL);
        }
    }

    public final void G(Bundle bundle) {
    }

    public final boolean bzj() {
        return true;
    }

    public final View bzk() {
        this.kpZ = v.fv(this.fmM).inflate(g.qIp, null);
        if (!bh.ov(this.hOf)) {
            this.kpZ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ aa rtT;

                {
                    this.rtT = r1;
                }

                public final void onClick(View view) {
                    if (bh.ov(this.rtT.rtS)) {
                        x.i("MicroMsg.LinkWidget", "adlink url " + this.rtT.hOf);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", this.rtT.hOf);
                        a.ifs.j(intent, this.rtT.fmM);
                    }
                }
            });
        }
        this.rsk = (CdnImageView) this.kpZ.findViewById(i.f.qCp);
        this.ihS = (TextView) this.kpZ.findViewById(i.f.qFN);
        this.rsl = (TextView) this.kpZ.findViewById(i.f.qDj);
        if (!(this.oqy || this.rtB)) {
            boolean z = (this.qYw == null || bh.ov(this.qYw.tnm)) ? false : true;
            if (!z) {
                this.kpZ.findViewById(i.f.state).setVisibility(8);
                if (bh.ov(this.title)) {
                    this.ihS.setText(this.title);
                } else {
                    this.ihS.setText(av.Mc(this.hOf));
                }
                if (!bh.ov(this.rsg)) {
                    this.rsk.setVisibility(0);
                    this.rsk.setUrl(this.rsg);
                } else if (!bh.bw(this.rsh)) {
                    this.rsk.setVisibility(0);
                    this.hkT = d.bl(this.rsh);
                    this.rsk.setImageBitmap(this.hkT);
                    this.rty = true;
                } else if (bh.ov(this.rtS)) {
                    this.rsk.setImageResource(i.i.qIP);
                    this.rsk.setVisibility(0);
                } else {
                    this.rsk.setImageResource(i.i.dvD);
                    this.rsk.setVisibility(0);
                }
                com.tencent.mm.plugin.sns.data.i.b(this.rsk, this.fmM);
                return this.kpZ;
            }
        }
        this.kpZ.findViewById(i.f.state).setVisibility(0);
        if (bh.ov(this.title)) {
            this.ihS.setText(av.Mc(this.hOf));
        } else {
            this.ihS.setText(this.title);
        }
        if (!bh.ov(this.rsg)) {
            this.rsk.setVisibility(0);
            this.rsk.setUrl(this.rsg);
        } else if (!bh.bw(this.rsh)) {
            this.rsk.setVisibility(0);
            this.hkT = d.bl(this.rsh);
            this.rsk.setImageBitmap(this.hkT);
            this.rty = true;
        } else if (bh.ov(this.rtS)) {
            this.rsk.setImageResource(i.i.dvD);
            this.rsk.setVisibility(0);
        } else {
            this.rsk.setImageResource(i.i.qIP);
            this.rsk.setVisibility(0);
        }
        com.tencent.mm.plugin.sns.data.i.b(this.rsk, this.fmM);
        return this.kpZ;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, aoy com_tencent_mm_protocal_c_aoy, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        aw awVar;
        String str3;
        if (this.rtB) {
            awVar = new aw(4);
        } else if (this.oqy) {
            awVar = new aw(5);
        } else if (this.rtC) {
            awVar = new aw(25);
            awVar.qYq.wQu.username = this.rtN;
            awVar.qYq.wQu.path = this.rtO;
        } else if (this.rtM == 11) {
            awVar = new aw(18);
            bme com_tencent_mm_protocal_c_bme = new bme();
            com_tencent_mm_protocal_c_bme.hdr = this.rtQ;
            com_tencent_mm_protocal_c_bme.hdq = this.title;
            com_tencent_mm_protocal_c_bme.hdo = this.hOf;
            com_tencent_mm_protocal_c_bme.hds = this.rtR;
            com_tencent_mm_protocal_c_bme.hdp = this.rtP;
            com_tencent_mm_protocal_c_bme.hdt = this.rsg;
            com_tencent_mm_protocal_c_bme.hdu = this.hdu;
            com_tencent_mm_protocal_c_bme.hdv = this.hdv;
            awVar.qYv = com_tencent_mm_protocal_c_bme;
            awVar.qYq.wQt = com_tencent_mm_protocal_c_bme;
        } else if (this.rtM == 15) {
            awVar = new aw(26);
            awVar.qYq.wQo.vYf = this.rtS;
        } else if (this.rtM != 16 || this.qYw == null) {
            awVar = new aw(3);
        } else {
            awVar = new aw(3);
            bzu com_tencent_mm_protocal_c_bzu = this.qYw;
            if (com_tencent_mm_protocal_c_bzu != null) {
                awVar.qYw = com_tencent_mm_protocal_c_bzu;
            }
        }
        pInt.value = awVar.afu;
        if (i3 > a.qQF) {
            awVar.wM(4);
        }
        if (this.rsh == null) {
            o.Pv();
            Bitmap iG = c.iG(this.rsg);
            if (!(iG == null || iG.isRecycled())) {
                x.i("MicroMsg.LinkWidget", "create bitmap %d %d", new Object[]{Integer.valueOf(d.a(iG, 150, 150, false, false).getHeight()), Integer.valueOf(d.a(iG, 150, 150, false, false).getWidth())});
                this.rsh = d.Q(iG);
            }
        }
        awVar.KE(this.title).KC(this.hOf).KD(this.hOf).Kz(str);
        if (this.rtM == 15) {
            awVar.KC(bh.az(this.fmM.getIntent().getStringExtra("fav_note_link_description"), ""));
        }
        if (!this.rtB) {
            if (this.oqy) {
                WXVideoObject wXVideoObject;
                if (this.rtF != null) {
                    wXVideoObject = (WXVideoObject) this.rtF.mediaObject;
                } else {
                    wXVideoObject = null;
                }
                awVar.a(this.rsh, this.hOf, wXVideoObject == null ? this.hOf : bh.az(wXVideoObject.videoLowBandUrl, this.hOf), wXVideoObject == null ? this.hOf : bh.az(wXVideoObject.videoUrl, this.hOf), 4, bh.az(this.title, ""), bh.az(this.rtH, ""));
            } else if (!bh.ov(this.rtz)) {
                str3 = this.rtz;
                String str4 = "";
                String str5 = "";
                int i6 = this.w;
                int i7 = this.h;
                aqr V = aw.V("", str3, str3);
                if (V == null) {
                    x.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
                } else {
                    V.nfe = str4;
                    if (i6 > 0 && i7 > 0) {
                        aqt com_tencent_mm_protocal_c_aqt = new aqt();
                        com_tencent_mm_protocal_c_aqt.wyv = (float) i7;
                        com_tencent_mm_protocal_c_aqt.wyu = (float) i6;
                        V.wxH = com_tencent_mm_protocal_c_aqt;
                    }
                    if (!bh.ov(str5)) {
                        V.fon = str5;
                    }
                    if (!bh.ov(str4)) {
                        V.nfe = str4;
                    }
                    awVar.qYq.wQo.vYd.add(V);
                }
            } else if (this.rsh != null) {
                if (this.rtC) {
                    Object obj;
                    byte[] bArr = this.rsh;
                    if (bArr == null) {
                        obj = null;
                    } else if (bArr.length < 4) {
                        obj = null;
                    } else {
                        obj = 1;
                        byte[] bArr2 = new byte[]{(byte) -119, (byte) 80, (byte) 78, (byte) 71};
                        for (int i8 = 0; i8 < 4; i8++) {
                            if (bArr[i8] != bArr2[i8]) {
                                obj = null;
                            }
                        }
                    }
                    if (obj != null) {
                        x.i("MicroMsg.LinkWidget", "isPngThumbData");
                        byte[] aK = f.aK(this.rsh);
                        if (aK != null && aK.length > 0) {
                            x.i("MicroMsg.LinkWidget", "use covert data");
                            this.rsh = f.aK(aK);
                        }
                    }
                }
                awVar.b(this.rsh, "", "");
            }
        }
        awVar.wQ(this.rsj);
        awVar.KH(this.fGz);
        awVar.KI(this.rsi);
        awVar.qYq.rtA = bh.ou(this.rtA);
        x.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", new Object[]{str3});
        awVar.wO(i);
        if (z) {
            awVar.wR(1);
        } else {
            awVar.wR(0);
        }
        awVar.bM(list2);
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List GI = s.GI();
            for (String str32 : list) {
                if (!GI.contains(str32)) {
                    bld com_tencent_mm_protocal_c_bld = new bld();
                    com_tencent_mm_protocal_c_bld.ksU = str32;
                    linkedList.add(com_tencent_mm_protocal_c_bld);
                }
            }
        }
        if (iVar != null) {
            awVar.ed(iVar.token, iVar.wyk);
        }
        awVar.ai(linkedList);
        if (!bh.ov(this.appId)) {
            awVar.KF(this.appId);
        }
        if (!bh.ov(this.appName)) {
            awVar.KG(bh.az(this.appName, ""));
        }
        if (this.rtD) {
            awVar.wQ(5);
        }
        awVar.a(com_tencent_mm_protocal_c_aoy);
        if (this.rtE && this.rtF != null) {
            awVar.KA(this.rtF.mediaTagName);
            awVar.U(this.appId, this.rtF.messageExt, this.rtF.messageAction);
        }
        awVar.KB(str2);
        awVar.e(this.rtI, this.rtJ, this.fGE, i4, i5);
        awVar.qYr.fGF = this.fGF;
        awVar.qf(this.iKB);
        awVar.qYq.hbg = this.rtK;
        int commit = awVar.commit();
        if (this.rsp != null) {
            this.rsp.iw(commit);
            e.rdF.c(this.rsp);
        }
        if (this.rtL != null) {
            this.rtL.iw(commit);
            f.rdF.c(this.rtL);
            this.rtL.Sx();
        }
        ae.bvr().buj();
        this.fmM.finish();
        return false;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bzl() {
        if (!(this.hkT == null || this.hkT.isRecycled() || !this.rty)) {
            this.hkT.recycle();
        }
        return false;
    }
}
