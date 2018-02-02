package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.plugin.luckymoney.b.k;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

@a(3)
public class LuckyMoneyNewYearSendUI extends LuckyMoneyBaseUI {
    private Dialog ilS = null;
    private OnClickListener inN = new OnClickListener(this) {
        final /* synthetic */ LuckyMoneyNewYearSendUI ojc;

        {
            this.ojc = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == f.uoD) {
                g.pQN.h(13079, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                if (this.ojc.odl == 1 && this.ojc.oiF && !TextUtils.isEmpty(this.ojc.oja) && !TextUtils.isEmpty(this.ojc.oiG) && !TextUtils.isEmpty(this.ojc.oiH) && this.ojc.oiI > 0) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with last post image data!");
                    LuckyMoneyNewYearSendUI.g(this.ojc);
                } else if (this.ojc.odl == 1 && this.ojc.oiF && !TextUtils.isEmpty(this.ojc.oja)) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with new image data!");
                    this.ojc.aXM();
                    if (this.ojc.oiJ == null) {
                        this.ojc.oiJ = new j();
                    }
                    i.a i = this.ojc.oiJ;
                    String c = this.ojc.oja;
                    j.a 1 = new 1(this);
                    i.lON = j.aXf();
                    i.ocy = 1;
                    i.ocz = c;
                    x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: sendImg. imageId:%s", new Object[]{i.lON});
                    i iVar = new i();
                    iVar.fLH = true;
                    iVar.htt = i;
                    iVar.field_mediaId = r2;
                    iVar.field_fullpath = c;
                    iVar.field_thumbpath = "";
                    iVar.field_fileType = b.MediaType_FILE;
                    iVar.field_talker = "";
                    iVar.field_priority = b.hrK;
                    iVar.field_needStorage = false;
                    iVar.field_isStreamMedia = false;
                    iVar.field_appType = 0;
                    iVar.field_bzScene = 0;
                    if (!com.tencent.mm.modelcdntran.g.MJ().c(iVar)) {
                        x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. clientid:%s", new Object[]{r2});
                    }
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with not image data!");
                    this.ojc.oja = "";
                    this.ojc.oiG = "";
                    this.ojc.oiH = "";
                    this.ojc.oiI = 0;
                    LuckyMoneyNewYearSendUI.g(this.ojc);
                }
            } else if (view.getId() == f.uoy) {
                this.ojc.finish();
                g.pQN.h(13079, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
            } else if (view.getId() == f.uov || view.getId() == f.uox) {
                LuckyMoneyNewYearSendUI.l(this.ojc);
                g.pQN.h(13079, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
            } else if (view.getId() == f.uoz) {
                this.ojc.oiG = "";
                this.ojc.oiH = "";
                this.ojc.oiI = 0;
                LuckyMoneyNewYearSendUI.m(this.ojc);
                g.pQN.h(13079, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
            } else if (view.getId() == f.uoC) {
                LuckyMoneyAutoScrollView n = this.ojc.oiw;
                n.ogm = false;
                n.ogd.setVisibility(0);
                n.oge.setVisibility(0);
                n.ogf.setVisibility(0);
                n.ogg.setVisibility(4);
                n.ogh.setVisibility(4);
                n.ogi.setVisibility(4);
                this.ojc.aXN();
                g.pQN.h(13079, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
            } else if (view.getId() == f.uoA) {
                LuckyMoneyNewYearSendUI.p(this.ojc);
            }
        }
    };
    private Button lHb;
    private Bitmap mBitmap;
    private af mHandler = new af();
    private String ode;
    private int odg;
    private int odl = 0;
    private LinkedList<k> odm;
    private String ofC;
    private int ofD;
    private int ofy;
    private TextView ogu;
    private ImageView oiB;
    private View oiC;
    private ImageView oiD;
    private boolean oiF = false;
    private String oiG = "";
    private String oiH = "";
    private int oiI;
    private j oiJ;
    private View oiS;
    private View oiT;
    private ImageView oiU;
    private TextView oiV;
    private ImageView oiW;
    private LinearLayout oiX;
    private String oiY;
    private boolean oiZ = true;
    private LuckyMoneyAutoScrollView oiw;
    private TextView oix;
    private String oja = "";
    private int ojb = 0;

    static /* synthetic */ void g(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
        g.pQN.h(11701, new Object[]{Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1)});
        String FS = q.FS();
        luckyMoneyNewYearSendUI.b(new ae(luckyMoneyNewYearSendUI.odg, luckyMoneyNewYearSendUI.ode, n.DV(FS), luckyMoneyNewYearSendUI.oiY, FS, q.FU(), luckyMoneyNewYearSendUI.ofy, luckyMoneyNewYearSendUI.oiG, luckyMoneyNewYearSendUI.oiH, luckyMoneyNewYearSendUI.oiI), false);
        luckyMoneyNewYearSendUI.aXM();
    }

    static /* synthetic */ void l(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSelectPicture");
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "galleryMode %s", new Object[]{luckyMoneyNewYearSendUI.mController.xIM.getSharedPreferences(ac.cfs(), 0).getString("gallery", "1")});
        if (luckyMoneyNewYearSendUI.mController.xIM.getSharedPreferences(ac.cfs(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
            com.tencent.mm.pluginsdk.ui.tools.k.a(luckyMoneyNewYearSendUI, 2, null);
        } else {
            com.tencent.mm.pluginsdk.ui.tools.k.S(luckyMoneyNewYearSendUI);
        }
    }

    static /* synthetic */ void m(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "doDeletePic");
        luckyMoneyNewYearSendUI.oiF = false;
        luckyMoneyNewYearSendUI.oja = "";
        luckyMoneyNewYearSendUI.oiG = "";
        luckyMoneyNewYearSendUI.oiH = "";
        luckyMoneyNewYearSendUI.oiI = 0;
        luckyMoneyNewYearSendUI.au();
    }

    static /* synthetic */ void p(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:doPreviewImage");
        if (TextUtils.isEmpty(luckyMoneyNewYearSendUI.oja)) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "image path is empty!");
            return;
        }
        g.pQN.h(13079, new Object[]{Integer.valueOf(7), Integer.valueOf(1)});
        new h(luckyMoneyNewYearSendUI, q.FS(), luckyMoneyNewYearSendUI.oja).n(false, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
        this.oiY = getIntent().getStringExtra("key_username");
        this.ofy = getIntent().getIntExtra("key_way", 0);
        this.ofD = getIntent().getIntExtra("pay_channel", -1);
        if (bh.ov(this.oiY)) {
            x.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
            finish();
        }
        initView();
        l(new w("v1.0"));
        g.pQN.h(13079, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
    }

    protected void onDestroy() {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xra, this.oja);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xrb, this.oiG);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xrc, this.oiH);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xrd, Integer.valueOf(this.oiI));
        super.onDestroy();
        if (this.ilS != null && this.ilS.isShowing()) {
            this.ilS.dismiss();
        }
    }

    protected final void initView() {
        uD(8);
        this.oiS = findViewById(f.uoS);
        this.oix = (TextView) findViewById(f.umE);
        this.oiw = (LuckyMoneyAutoScrollView) findViewById(f.uou);
        this.ogu = (TextView) findViewById(f.uoE);
        this.lHb = (Button) findViewById(f.uoD);
        this.lHb.setOnClickListener(this.inN);
        ((ImageView) findViewById(f.uoy)).setOnClickListener(this.inN);
        this.oiT = findViewById(f.uow);
        this.oiU = (ImageView) findViewById(f.uov);
        this.oiU.setOnClickListener(this.inN);
        this.oiB = (ImageView) findViewById(f.uoF);
        this.oiV = (TextView) findViewById(f.uox);
        this.oiV.setOnClickListener(this.inN);
        this.oiC = findViewById(f.uoB);
        this.oiD = (ImageView) findViewById(f.uoA);
        this.oiD.setOnClickListener(this.inN);
        this.oiW = (ImageView) findViewById(f.uoz);
        this.oiW.setOnClickListener(this.inN);
        this.oiX = (LinearLayout) findViewById(f.uoC);
        this.oiX.setOnClickListener(this.inN);
        com.tencent.mm.kernel.g.Dk();
        this.oja = (String) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xra, "");
        com.tencent.mm.kernel.g.Dk();
        this.oiG = (String) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xrb, "");
        com.tencent.mm.kernel.g.Dk();
        this.oiH = (String) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xrc, "");
        com.tencent.mm.kernel.g.Dk();
        this.oiI = ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xrd, Integer.valueOf(0))).intValue();
        if (TextUtils.isEmpty(this.oja) || TextUtils.isEmpty(this.oiG) || TextUtils.isEmpty(this.oiH) || this.oiI <= 0) {
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "count not fetch last post image data!");
        } else {
            this.oiF = true;
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "last post image data is valid");
        }
        if (!this.oiF || TextUtils.isEmpty(this.oja)) {
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:initPictureImage() mIsShowPic:" + this.oiF + ", mImagePath:" + this.oja);
            return;
        }
        Bitmap aq = n.aq(this.oja, false);
        if (aq != null) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
            Bitmap bitmap = this.mBitmap;
            this.mBitmap = aq;
            this.oiD.setImageBitmap(this.mBitmap);
            if (bitmap != null && bitmap.isRecycled()) {
                bitmap.recycle();
                return;
            }
            return;
        }
        x.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
    }

    private void au() {
        LayoutParams layoutParams;
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if (this.oiF && this.odl == 1) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the picture!");
            this.oiT.setVisibility(8);
            this.oiC.setVisibility(0);
            this.oiB.setVisibility(8);
        } else if (this.odl == 1) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the camera btn!");
            this.oiT.setVisibility(0);
            this.oiC.setVisibility(8);
            this.oiB.setVisibility(0);
        } else {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the new year wording!");
            this.oiT.setVisibility(8);
            this.oiC.setVisibility(8);
            this.oiB.setVisibility(0);
        }
        if (this.odm == null || this.odm.size() <= 0) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
            this.oiX.setVisibility(8);
        } else {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
            this.oiX.setVisibility(0);
        }
        if (this.odl == 1) {
            layoutParams = (LayoutParams) this.oiB.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.uck);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.uci);
            this.oiB.setLayoutParams(layoutParams);
            this.oiB.invalidate();
        } else {
            layoutParams = (LayoutParams) this.oiB.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.ucj);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.uch);
            this.oiB.setLayoutParams(layoutParams);
            this.oiB.invalidate();
        }
        if (this.oiF) {
            layoutParams = (LayoutParams) this.ogu.getLayoutParams();
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.ucg);
            this.ogu.setLayoutParams(layoutParams);
            this.ogu.invalidate();
            this.ogu.setTextSize(1, 17.0f);
            this.oix.setTextSize(1, 16.0f);
            this.oiw.cL(getResources().getDimensionPixelOffset(d.uco), getResources().getDimensionPixelOffset(d.ucm));
            layoutParams = (LayoutParams) this.oiw.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.ucc);
            this.oiw.setLayoutParams(layoutParams);
            this.oiw.invalidate();
            layoutParams = (LayoutParams) this.oiX.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.uce);
            this.oiX.setLayoutParams(layoutParams);
            this.oiX.invalidate();
            return;
        }
        layoutParams = (LayoutParams) this.ogu.getLayoutParams();
        layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.ucf);
        this.ogu.setLayoutParams(layoutParams);
        this.ogu.invalidate();
        this.ogu.setTextSize(1, 20.0f);
        this.oix.setTextSize(1, 18.0f);
        this.oiw.cL(getResources().getDimensionPixelOffset(d.ucn), getResources().getDimensionPixelOffset(d.ucl));
        layoutParams = (LayoutParams) this.oiw.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelOffset(d.ucb);
        this.oiw.setLayoutParams(layoutParams);
        this.oiw.invalidate();
        layoutParams = (LayoutParams) this.oiX.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelOffset(d.ucd);
        this.oiX.setLayoutParams(layoutParams);
        this.oiX.invalidate();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uCB;
    }

    private void aXM() {
        if (this.ilS == null) {
            this.ilS = com.tencent.mm.wallet_core.ui.g.a(this.mController.xIM, true, new 2(this));
        } else if (!this.ilS.isShowing()) {
            this.ilS.show();
        }
    }

    private void aXN() {
        int i;
        if (this.odm == null || this.odm.size() <= 0) {
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
            i = -1;
        } else {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dh();
            i = com.tencent.mm.kernel.a.Cg();
            int size = this.odm.size();
            i = (new Random((long) i).nextInt(size) + ((int) (System.currentTimeMillis() % ((long) size)))) % size;
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:" + i);
        }
        this.ojb = i;
        if (this.ojb >= 0 && this.ojb < this.odm.size()) {
            this.odg = ((k) this.odm.get(this.ojb)).ocB;
            this.ode = ((k) this.odm.get(this.ojb)).ocC;
        }
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.ojb + " randomAmount:" + this.odg + " randomWishing:" + this.ode);
        this.oiw.DX(e.t(((double) this.odg) / 100.0d));
        this.oiw.a(new LuckyMoneyAutoScrollView.a(this) {
            final /* synthetic */ LuckyMoneyNewYearSendUI ojc;

            {
                this.ojc = r1;
            }

            public final void aXx() {
                if (this.ojc.oiZ) {
                    this.ojc.ogu.setVisibility(4);
                    n.a(this.ojc.mController.xIM, this.ojc.ogu, this.ojc.ode);
                    Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(500);
                    alphaAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass3 ojf;

                        {
                            this.ojf = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                            this.ojf.ojc.ogu.setVisibility(0);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                        }
                    });
                    this.ojc.ogu.startAnimation(alphaAnimation);
                    this.ojc.oiZ = false;
                    return;
                }
                n.a(this.ojc.mController.xIM, this.ojc.ogu, this.ojc.ode);
                this.ojc.ogu.invalidate();
            }
        });
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + kVar.getType());
        if (kVar instanceof w) {
            if (i == 0 && i2 == 0) {
                w wVar = (w) kVar;
                this.odg = wVar.odg;
                this.ode = wVar.ode;
                this.odl = wVar.odl;
                this.odm = wVar.odm;
                if (this.odl == 0) {
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "scenePicSwitch is 0, clear local picture data!");
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "cans how picture!");
                }
                aXN();
                au();
                uD(0);
                n.a(this.oiS, null);
                return true;
            }
            finish();
        } else if (kVar instanceof ad) {
            if (this.ilS != null && this.ilS.isShowing()) {
                this.ilS.hide();
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                ad adVar = (ad) kVar;
                this.ofC = adVar.odt;
                r1 = new PayInfo();
                r1.fuH = adVar.ods;
                r1.fCV = 37;
                r1.fCR = this.ofD;
                h.a(this, r1, 1);
                return true;
            }
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        } else if (kVar instanceof ae) {
            if (this.ilS != null && this.ilS.isShowing()) {
                this.ilS.hide();
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                ae aeVar = (ae) kVar;
                this.ofC = aeVar.odt;
                r1 = new PayInfo();
                r1.fuH = aeVar.ods;
                r1.fCV = 37;
                r1.fCR = this.ofD;
                h.a(this, r1, 1);
                return true;
            }
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
                    g.pQN.h(11701, new Object[]{Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2)});
                    if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                        RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                        if (realnameGuideHelper != null) {
                            boolean z2;
                            if (realnameGuideHelper.b(this, null, new 4(this))) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            z = z2;
                        }
                    }
                    com.tencent.mm.ui.base.h.bu(this, getString(com.tencent.mm.plugin.wxpay.a.i.epb));
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb!");
                    n.z(this.ofC, this.oiY, 3);
                    if (!z) {
                        finish();
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
                return;
            case 2:
                if (intent == null) {
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_PIC");
                    return;
                } else if (i2 == -1) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
                    CharSequence stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (!TextUtils.isEmpty(stringExtra) || (stringArrayListExtra != null && stringArrayListExtra.size() > 0)) {
                        if (TextUtils.isEmpty(stringExtra)) {
                            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePathList is valid!");
                            str = (String) stringArrayListExtra.get(0);
                        } else {
                            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePath is valid!");
                            str = stringExtra;
                        }
                        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "REQUEST_CODE_FROM_PIC filePath %s", new Object[]{stringExtra});
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.gHD + "temp.avatar");
                        intent2.putExtra("CropImage_ImgPath", str);
                        intent2.putExtra("CropImage_Filter", false);
                        intent2.putExtra("CropImage_from_scene", 1);
                        com.tencent.mm.plugin.luckymoney.a.ifs.a((Activity) this, intent2, 3);
                        return;
                    }
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture failed, imagePath and imagePathList is null!");
                    return;
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture cancel or failed!");
                    return;
                }
            case 3:
                if (intent == null) {
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_CROP");
                    return;
                } else if (i2 == -1) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
                    str = intent.getStringExtra("CropImage_OutputPath");
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "new crop image path:" + str);
                    if (TextUtils.isEmpty(str) || !str.equals(this.oja)) {
                        this.oiG = "";
                        this.oiH = "";
                        this.oiI = 0;
                    } else {
                        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "the path is same as last image");
                    }
                    this.oja = str;
                    Bitmap aq = n.aq(this.oja, false);
                    if (aq != null) {
                        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
                        Bitmap bitmap = this.mBitmap;
                        this.mBitmap = aq;
                        this.oiD.setImageBitmap(this.mBitmap);
                        this.oiF = true;
                        au();
                        if (bitmap != null && bitmap.isRecycled()) {
                            bitmap.recycle();
                            return;
                        }
                        return;
                    }
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
                    return;
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:do crop image fail for REQUEST_CODE_FROM_CROP");
                    return;
                }
            default:
                return;
        }
    }
}
