package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class w extends a {
    public static int rlq = 999;
    private Context context;
    private af hae;
    private View jWc;
    private String jio;
    int lXR = 0;
    private long oKL = 0;
    public int qPp = 0;
    public int qPq = 0;
    public int qPr = 0;
    ab rkM = null;
    private OfflineVideoView rkN;
    VideoPlayerSeekBar rkO;
    private ProgressBar rkP;
    private int rkQ;
    private ImageView rkR;
    private boolean rkS = true;
    private boolean rkT;
    private TextView rkU;
    private int rkV = 0;
    private int rkW = 0;
    private int rkX = 0;
    private int rkY = 0;
    private int rkZ = 0;
    private boolean rla = false;
    ImageView rlb;
    int rlc = 0;
    int rld = 0;
    boolean rle = true;
    int rlf = 0;
    private int rlg = 0;
    private boolean rlh = true;
    private boolean rli = false;
    private boolean rlj = false;
    private boolean rlk = true;
    private boolean rll = false;
    boolean rlm = true;
    boolean rln = true;
    private boolean rlo;
    private boolean rlp = false;
    private boolean rlr = false;

    static /* synthetic */ void o(w wVar) {
        wVar.rkO.seek(0);
        wVar.bxu();
    }

    public w(Context context, q qVar, ViewGroup viewGroup) {
        super(context, qVar, viewGroup);
        this.context = context;
        this.hae = new af(Looper.getMainLooper());
        this.rkM = new 1(this, context);
    }

    protected final int bjK() {
        return g.qGT;
    }

    public final View bwW() {
        LayoutParams layoutParams;
        ViewParent parent;
        boolean z = true;
        if (!e.bO(d.ei("adId", ((q) this.rji).rgC))) {
            this.rlm = false;
        }
        if (!e.bO(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + ab.UZ(((q) this.rji).rgB))) {
            this.rln = false;
        }
        View findViewById = this.contentView.findViewById(f.qDR);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.qDK);
        this.rkN = new OfflineVideoView(this.context);
        viewGroup.addView(this.rkN, 0, new LinearLayout.LayoutParams(-1, -1));
        LayoutParams layoutParams2;
        if (((q) this.rji).rgH != 1) {
            int i = (int) ((q) this.rji).width;
            int i2 = (int) ((q) this.rji).height;
            viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
            layoutParams2 = new RelativeLayout.LayoutParams(i, i2);
            layoutParams2.leftMargin = (int) ((q) this.rji).rgO;
            layoutParams2.rightMargin = (int) ((q) this.rji).rgP;
            layoutParams2.topMargin = (int) ((q) this.rji).rgM;
            layoutParams2.bottomMargin = (int) ((q) this.rji).rgN;
            findViewById.setLayoutParams(layoutParams2);
        } else if (((int) ((q) this.rji).width) > 0) {
            layoutParams2 = new RelativeLayout.LayoutParams(this.kDP, (this.kDP * ((int) ((q) this.rji).height)) / ((int) ((q) this.rji).width));
            findViewById.setPadding((int) ((q) this.rji).rgO, (int) ((q) this.rji).rgM, (int) ((q) this.rji).rgP, (int) ((q) this.rji).rgN);
            viewGroup.setLayoutParams(layoutParams2);
            findViewById.setLayoutParams(layoutParams2);
        } else {
            viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(this.kDP, this.kDQ));
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.kDP, this.kDQ));
            findViewById.setMinimumHeight(this.kDQ);
        }
        String ei = d.ei("adId", ((q) this.rji).rgC);
        if (FileOp.bO(ei)) {
            this.rkN.LS(ei);
        } else {
            d.a("adId", ((q) this.rji).rgC, false, 1000000001, 0, new 5(this));
        }
        this.rkU = (TextView) findViewById.findViewById(f.qCb);
        this.rkU.setText(this.context.getString(j.dYZ));
        this.jWc = findViewById.findViewById(f.qDW);
        if (this.jWc != null) {
            layoutParams = new RelativeLayout.LayoutParams(this.kDP, this.kDQ);
            parent = this.jWc.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.jWc);
            }
            ((ViewGroup) findViewById).addView(this.jWc, layoutParams);
        }
        layoutParams = new RelativeLayout.LayoutParams(this.kDP - com.tencent.mm.bv.a.fromDPToPix(this.context, 30), -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = b.b(this.context, this.context.getResources().getDimension(i.d.qyJ));
        this.rkO = new VideoPlayerSeekBar(this.context);
        this.rkO.setVisibility(4);
        if (this.rkM != null) {
            this.rkM.iD(this.rkO.getVisibility() == 0);
        }
        this.rkO.quk = new com.tencent.mm.plugin.sight.decode.ui.b(this) {
            final /* synthetic */ w rls;

            {
                this.rls = r1;
            }

            public final void agX() {
                if (this.rls.rkN != null) {
                    this.rls.rkN.bzH();
                }
            }

            public final void kH(int i) {
                x.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onSeek time " + i);
                if (this.rls.rle) {
                    this.rls.bwF();
                } else {
                    this.rls.bwJ();
                }
                this.rls.rkN.M(i, this.rls.rkO.fvG);
            }
        };
        this.rkO.i(new 7(this));
        this.rkO.db(this.rkN.isPlaying());
        this.rkO.seek(0);
        ((ViewGroup) findViewById).addView(this.rkO, layoutParams);
        this.rlb = (ImageView) findViewById.findViewById(f.qDX);
        this.rlb.setVisibility(0);
        this.rlb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ w rls;

            {
                this.rls = r1;
            }

            public final void onClick(View view) {
                w wVar = this.rls;
                wVar.rlc++;
                if (this.rls.rle) {
                    this.rls.bwK();
                    this.rls.bwJ();
                    this.rls.rlr = true;
                } else {
                    this.rls.bwF();
                }
                this.rls.rla = true;
            }
        });
        this.rlb.setPadding(0, 0, com.tencent.mm.bv.a.fromDPToPix(this.context, 8), com.tencent.mm.bv.a.fromDPToPix(this.context, 13));
        parent = this.rlb.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.rlb);
        }
        ((ViewGroup) findViewById).addView(this.rlb);
        this.rkR = (ImageView) findViewById.findViewById(f.cPl);
        this.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this.context, i.i.dAI));
        this.rkR.setVisibility(8);
        this.rkR.setOnClickListener(new 9(this));
        this.rkN.ruJ = new 10(this);
        this.rkO.setVisibility(4);
        this.rlb.setVisibility(8);
        this.jWc.setVisibility(4);
        if (this.rkM != null) {
            this.rkM.iD(this.rkO.getVisibility() == 0);
        }
        this.rkN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ w rls;

            {
                this.rls = r1;
            }

            public final void onClick(View view) {
                boolean z = false;
                if (this.rls.rkT) {
                    w wVar = this.rls;
                    wVar.rld++;
                    if (!this.rls.bxt()) {
                        this.rls.rli = true;
                        if (this.rls.rkO.getVisibility() == 0) {
                            this.rls.rkO.setVisibility(4);
                            this.rls.rlb.setVisibility(8);
                            this.rls.jWc.setVisibility(4);
                        } else {
                            this.rls.rkO.setVisibility(4);
                            this.rls.rlb.setVisibility(0);
                            this.rls.jWc.setVisibility(0);
                        }
                        if (this.rls.rkM != null) {
                            ab abVar = this.rls.rkM;
                            if (this.rls.rkO.getVisibility() == 0) {
                                z = true;
                            }
                            abVar.iD(z);
                        }
                    }
                }
            }
        });
        this.rkP = (ProgressBar) findViewById.findViewById(f.cEd);
        this.rkP.setVisibility(8);
        q qVar = (q) this.rji;
        if (qVar.fpn != 1 || qVar.rgE.length() <= 0 || qVar.rgD.length() <= 0) {
            z = false;
        }
        if (z) {
            View findViewById2 = this.contentView.findViewById(f.qDL);
            findViewById2.setVisibility(0);
            Button button = (Button) findViewById2.findViewById(f.qDM);
            button.setTextColor(((q) this.rji).rgF);
            button.setText(((q) this.rji).rgE);
            button.setOnClickListener(new 12(this));
            findViewById2.findViewById(f.qDN).setBackgroundColor(((q) this.rji).rgG);
        }
        return this.contentView;
    }

    public final void bxs() {
        q qVar = (q) this.rji;
        if (bh.ov(qVar.rgD)) {
            x.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
        } else if (this.context instanceof Activity) {
            x.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", new Object[]{qVar.rgD});
            Intent intent = new Intent();
            intent.setClass(this.context, VideoAdPlayerUI.class);
            intent.putExtra("IsAd", true);
            intent.putExtra("KMediaId", ab.UZ(qVar.rgD));
            intent.putExtra("KThumUrl", qVar.rgC);
            intent.putExtra("KStremVideoUrl", qVar.rgD);
            intent.putExtra("ForceLandscape", true);
            intent.putExtra("ShareBtnHidden", 1);
            intent.putExtra("KComponentCid", bxf());
            ((Activity) this.context).startActivityForResult(intent, rlq);
            this.rkZ++;
        } else {
            x.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
        }
    }

    private boolean bxt() {
        if (bh.ov(((q) this.rji).rga)) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", ((q) this.rji).rgY);
        intent.putExtra("sns_landing_pages_ux_info", ((q) this.rji).qZM);
        intent.putExtra("sns_landing_pages_xml", "");
        intent.putExtra("sns_landing_pages_canvasid", ((q) this.rji).rga);
        intent.putExtra("sns_landing_pages_canvas_ext", ((q) this.rji).rgb);
        intent.putExtra("sns_landing_pages_no_store", ((q) this.rji).rgc);
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        if ((this.context instanceof Activity) && ((q) this.rji).rha == 2) {
            String stringExtra = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
            String stringExtra2 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!bh.ov(stringExtra)) {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", valueOf);
                    jSONObject.put("cid", ((q) this.rji).rgK);
                    jSONObject.put("adBuffer", !bh.ov(stringExtra2) ? stringExtra2 : "");
                    jSONObject.put("preSessionId", stringExtra);
                } catch (Exception e) {
                }
                intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
                intent.putExtra("sns_landing_pages_sessionId", valueOf);
                intent.putExtra("sns_landing_pages_ad_buffer", stringExtra2);
            }
        }
        int[] iArr = new int[2];
        this.rkN.getLocationOnScreen(iArr);
        intent.putExtra("img_gallery_top", iArr[1]);
        intent.putExtra("img_gallery_left", iArr[0]);
        intent.putExtra("img_gallery_width", this.rkN.getWidth());
        intent.putExtra("img_gallery_height", this.rkN.getHeight());
        com.tencent.mm.bm.d.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        return true;
    }

    private void ayL() {
        if (this.rlp) {
            x.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
            this.rkN.bzG();
            return;
        }
        x.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
        if (!(this.rlo || TextUtils.isEmpty(this.jio))) {
            this.rkN.Au(this.jio);
            this.rlo = true;
        }
        this.rkR.setVisibility(8);
        this.hae.post(new 2(this));
        this.oKL = System.currentTimeMillis();
        this.rkW++;
    }

    public final void bxu() {
        if (this.rkN != null && this.rkO != null && Math.abs(this.rkN.getCurrentPosition() - this.rkO.mPosition) > 1) {
            this.rkN.F(this.rkO.mPosition, true);
        }
    }

    private void bxv() {
        x.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
        if (!this.rkS) {
            this.rkR.setVisibility(0);
        }
        this.hae.post(new 3(this));
        if (this.oKL != 0) {
            this.rkV = (int) (((long) this.rkV) + (System.currentTimeMillis() - this.oKL));
            this.oKL = 0;
        }
    }

    public final void bwF() {
        super.bwF();
        this.rlb.setImageDrawable(com.tencent.mm.bv.a.b(this.context, i$e.qzg));
        this.rkN.setMute(true);
        this.rle = true;
    }

    public final void bwJ() {
        super.bwJ();
        this.rlb.setImageDrawable(com.tencent.mm.bv.a.b(this.context, i$e.qzh));
        this.rkN.setMute(false);
        this.rle = false;
    }

    public final void bwH() {
        super.bwH();
    }

    public final void bwI() {
        super.bwI();
        bxv();
        this.rlr = false;
        if (this.rlj || this.rlk) {
            this.rlk = false;
            this.rlj = false;
            if (this.rlg == 1) {
                this.rlg = 2;
            }
        }
    }

    public final void bwG() {
        super.bwG();
        this.rkN.onDestroy();
    }

    public final void X(int i, int i2, int i3) {
        super.X(i, i2, i3);
        x.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "height " + i2);
        if (i != 0 && i2 != 0) {
            this.rlf = i;
            this.lXR = i2;
            if (i < 0) {
                return;
            }
            if (((float) i) < 0.5f * ((float) i2)) {
                this.rlr = false;
                this.rlk = false;
                this.rlj = false;
                bxv();
                if (this.rlg == 1) {
                    this.rlg = 2;
                }
            } else if (!this.rlj || this.rlk) {
                this.rlr = false;
                this.rlk = false;
                this.rlj = true;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) ac.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (!this.rlh || (this.rlh && activeNetworkInfo != null && activeNetworkInfo.getType() == 1)) {
                    if (this.rkM != null) {
                        this.rkM.iD(true);
                    }
                    if (this.rkO.qur > 0) {
                        this.rkO.setVisibility(4);
                        this.rlb.setVisibility(0);
                        this.jWc.setVisibility(0);
                    }
                    ag.h(new 4(this), 3000);
                }
                if (this.rlh) {
                    if (activeNetworkInfo == null) {
                        this.rkR.setVisibility(0);
                        this.rkS = false;
                        this.rll = false;
                    } else {
                        this.rll = true;
                        this.rlh = false;
                    }
                }
                if (this.rlg == 0) {
                    if (activeNetworkInfo != null) {
                        if (this.rle) {
                            bwF();
                        } else {
                            bwJ();
                            this.rlr = true;
                        }
                        this.rlg = 1;
                    } else {
                        return;
                    }
                } else if (this.rlg == 2) {
                    if (this.rle) {
                        bwF();
                    } else {
                        bwJ();
                        this.rlr = true;
                    }
                    ayL();
                    this.rlg = 1;
                    return;
                } else if (this.rlg != 3) {
                    return;
                } else {
                    if (this.rle) {
                        bwF();
                    } else {
                        bwJ();
                        this.rlr = true;
                    }
                }
                ayL();
            }
        }
    }

    public final boolean S(JSONObject jSONObject) {
        if (!super.S(jSONObject)) {
            return false;
        }
        try {
            String UZ;
            JSONObject jSONObject2;
            jSONObject.put("sightDuration", this.rkQ * 1000);
            jSONObject.put("playTimeInterval", this.rkV);
            jSONObject.put("playCount", this.rkW);
            jSONObject.put("playCompletedCount", this.rkX);
            jSONObject.put("clickVoiceControlCount", this.rlc);
            jSONObject.put("isAutoPlay", this.rll ? "1" : "0");
            if (((q) this.rji).type == 61) {
                jSONObject.put("clickSightCount", this.rld);
            }
            if (!this.rln) {
                UZ = ab.UZ(((q) this.rji).rgB);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", UZ);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("sightUrlInfo", jSONObject2);
            }
            if (!this.rlm) {
                UZ = ab.UZ(((q) this.rji).rgC);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", UZ);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("thumbUrlInfo", jSONObject2);
            }
            jSONObject.put("streamVideoEnterCount", this.rkZ);
            jSONObject.put("streamVideoPlayCount", this.qPp);
            jSONObject.put("streamVideoPlayCompleteCount", this.qPq);
            jSONObject.put("streamVideoTotalPlayTimeInMs", this.qPr);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", e, "", new Object[0]);
            return false;
        }
    }

    protected final void bxa() {
        x.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    }
}
