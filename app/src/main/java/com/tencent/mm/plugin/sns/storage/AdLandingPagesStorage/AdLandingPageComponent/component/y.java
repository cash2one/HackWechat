package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.bv.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class y extends x {
    private Context context;
    af hae;
    View jWc;
    String jio;
    int lXR = 0;
    long oKL = 0;
    ab rkM = null;
    OfflineVideoView rkN;
    VideoPlayerSeekBar rkO;
    private ProgressBar rkP;
    int rkQ;
    private ImageView rkR;
    boolean rkS = true;
    boolean rkT;
    private TextView rkU;
    int rkV = 0;
    private int rkW = 0;
    int rkX = 0;
    int rkY = 0;
    boolean rla = false;
    ImageView rlb;
    int rlc = 0;
    boolean rle = true;
    int rlf = 0;
    int rlg = 0;
    boolean rlh = true;
    boolean rli = false;
    private boolean rlj = false;
    private boolean rlk = true;
    private boolean rll = false;
    boolean rlm = true;
    boolean rln = true;
    boolean rlo;
    boolean rlp = false;
    boolean rlr = false;

    public y(Context context, w wVar, ViewGroup viewGroup) {
        super(context, wVar, viewGroup);
        this.context = context;
        this.hae = new af(Looper.getMainLooper());
        this.rkM = new 1(this, context);
    }

    public final int bxw() {
        if (this.rkO.getVisibility() != 0) {
            return -1;
        }
        int[] iArr = new int[2];
        this.rkO.getLocationOnScreen(iArr);
        return (this.kDQ - iArr[1]) - (this.rkO.getHeight() >>> 1);
    }

    protected final int bjK() {
        return g.qGT;
    }

    public final View bwW() {
        LayoutParams layoutParams;
        ViewParent parent;
        boolean z = true;
        if (!e.bO(d.ei("adId", ((w) this.rji).rhn))) {
            this.rlm = false;
        }
        if (!e.bO(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + ab.UZ(((w) this.rji).rgD))) {
            this.rln = false;
        }
        View findViewById = this.contentView.findViewById(f.qDR);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.qDK);
        this.rkN = new OfflineVideoView(this.context);
        viewGroup.addView(this.rkN, 0, new LinearLayout.LayoutParams(-1, -1));
        int i;
        LayoutParams layoutParams2;
        if (((w) this.rji).rho != 1) {
            i = this.kDQ;
            layoutParams2 = new RelativeLayout.LayoutParams(this.kDP, i);
            findViewById.setPadding((int) ((w) this.rji).rgO, (int) ((w) this.rji).rgM, (int) ((w) this.rji).rgP, (int) ((w) this.rji).rgN);
            viewGroup.setLayoutParams(layoutParams2);
            findViewById.setLayoutParams(layoutParams2);
            findViewById.setMinimumHeight(i);
        } else if (((int) ((w) this.rji).width) > 0) {
            i = (this.kDP * ((int) ((w) this.rji).height)) / ((int) ((w) this.rji).width);
            layoutParams2 = new RelativeLayout.LayoutParams(this.kDP, i);
            findViewById.setPadding((int) ((w) this.rji).rgO, (int) ((w) this.rji).rgM, (int) ((w) this.rji).rgP, (int) ((w) this.rji).rgN);
            viewGroup.setLayoutParams(layoutParams2);
            findViewById.setLayoutParams(layoutParams2);
            findViewById.setMinimumHeight(i);
        } else {
            viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(this.kDP, this.kDQ));
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.kDP, this.kDQ));
            findViewById.setMinimumHeight(this.kDQ);
        }
        String ei = d.ei("adId", ((w) this.rji).rhn);
        if (FileOp.bO(ei)) {
            this.rkN.LS(ei);
        } else {
            d.a("adId", ((w) this.rji).rhn, false, 1000000001, 0, new 4(this));
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
        layoutParams = new RelativeLayout.LayoutParams(this.kDP - a.fromDPToPix(this.context, 30), -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = b.b(this.context, this.context.getResources().getDimension(i.d.qyJ));
        this.rkO = new VideoPlayerSeekBar(this.context);
        this.rkO.setVisibility(4);
        if (this.rkM != null) {
            this.rkM.iD(this.rkO.getVisibility() == 0);
        }
        this.rkO.quk = new 5(this);
        this.rkO.i(new 6(this));
        this.rkO.db(this.rkN.isPlaying());
        this.rkO.seek(0);
        ((ViewGroup) findViewById).addView(this.rkO, layoutParams);
        this.rlb = (ImageView) findViewById.findViewById(f.qDX);
        this.rlb.setVisibility(0);
        this.rlb.setOnClickListener(new 7(this));
        this.rlb.setPadding(0, 0, a.fromDPToPix(this.context, 8), a.fromDPToPix(this.context, 13));
        parent = this.rlb.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.rlb);
        }
        ((ViewGroup) findViewById).addView(this.rlb);
        this.rkR = (ImageView) findViewById.findViewById(f.cPl);
        this.rkR.setImageDrawable(a.b(this.context, i.i.dAI));
        this.rkR.setVisibility(8);
        this.rkR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ y rlv;

            {
                this.rlv = r1;
            }

            public final void onClick(View view) {
                this.rlv.rkS = true;
                this.rlv.ayL();
                this.rlv.rlh = false;
                if (!this.rlv.rla) {
                    this.rlv.bwJ();
                    this.rlv.rlr = true;
                    this.rlv.rla = true;
                } else if (this.rlv.rle) {
                    this.rlv.bwF();
                } else {
                    this.rlv.bwJ();
                    this.rlv.rlr = true;
                }
                this.rlv.rlg = 3;
                this.rlv.rkO.setVisibility(0);
                this.rlv.rlb.setVisibility(0);
                this.rlv.jWc.setVisibility(0);
                if (this.rlv.rkM != null) {
                    this.rlv.rkM.iD(true);
                }
                ag.h(new 1(this), 10000);
            }
        });
        this.rkN.ruJ = new 9(this);
        this.rkO.setVisibility(4);
        this.rlb.setVisibility(8);
        this.jWc.setVisibility(4);
        if (this.rkM != null) {
            ab abVar = this.rkM;
            if (this.rkO.getVisibility() != 0) {
                z = false;
            }
            abVar.iD(z);
        }
        this.rkN.setOnClickListener(new 10(this));
        this.rkP = (ProgressBar) findViewById.findViewById(f.cEd);
        this.rkP.setVisibility(8);
        return this.contentView;
    }

    final void ayL() {
        if (this.rlp) {
            x.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "last download fail ,try again");
            this.rkN.bzG();
            return;
        }
        x.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "starting play");
        if (!(this.rlo || TextUtils.isEmpty(this.jio))) {
            this.rkN.Au(this.jio);
            this.rlo = true;
        }
        this.rkR.setVisibility(8);
        this.hae.post(new 11(this));
        this.oKL = System.currentTimeMillis();
        this.rkW++;
    }

    final void bxv() {
        x.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "pause play");
        if (!this.rkS) {
            this.rkR.setVisibility(0);
        }
        this.hae.post(new 2(this));
        if (this.oKL != 0) {
            this.rkV = (int) (((long) this.rkV) + (System.currentTimeMillis() - this.oKL));
            this.oKL = 0;
        }
    }

    public final void bwF() {
        super.bwF();
        this.rlb.setImageDrawable(a.b(this.context, i$e.qzg));
        this.rkN.setMute(true);
        this.rle = true;
    }

    public final void bwJ() {
        super.bwJ();
        this.rlb.setImageDrawable(a.b(this.context, i$e.qzh));
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
        x.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "height " + i2);
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
                        this.rkO.setVisibility(0);
                        this.rlb.setVisibility(0);
                        this.jWc.setVisibility(0);
                    }
                    ag.h(new Runnable(this) {
                        final /* synthetic */ y rlv;

                        {
                            this.rlv = r1;
                        }

                        public final void run() {
                            if (!this.rlv.rli) {
                                if (this.rlv.rkM != null) {
                                    this.rlv.rkM.iD(false);
                                }
                                this.rlv.rkO.setVisibility(4);
                                this.rlv.rlb.setVisibility(8);
                                this.rlv.jWc.setVisibility(4);
                            }
                        }
                    }, 3000);
                }
                if (this.rlh) {
                    if (activeNetworkInfo == null || !(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                        this.rkR.setVisibility(0);
                        this.rkS = false;
                        this.rll = false;
                    } else {
                        this.rll = true;
                        this.rlh = false;
                    }
                }
                if (this.rlg == 0) {
                    if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
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
            jSONObject.put("streamVideoDuraion", this.rkQ * 1000);
            jSONObject.put("playTimeInterval", this.rkV);
            jSONObject.put("playCount", this.rkW);
            jSONObject.put("playCompletedCount", this.rkX);
            jSONObject.put("clickPlayControlCount", this.rkY);
            jSONObject.put("clickVoiceControlCount", this.rlc);
            jSONObject.put("isAutoPlay", this.rll ? "1" : "0");
            if (!this.rlm) {
                UZ = ab.UZ(((w) this.rji).rhn);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", UZ);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("thumbUrlInfo", jSONObject2);
            }
            if (!this.rln) {
                UZ = ab.UZ(((w) this.rji).rgD);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", UZ);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("streamVideoUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", e, "", new Object[0]);
            return false;
        }
    }

    protected final void bxa() {
        x.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", getClass().getName() + "not support update now");
    }
}
