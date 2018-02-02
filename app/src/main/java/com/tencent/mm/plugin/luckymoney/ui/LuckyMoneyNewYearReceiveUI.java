package com.tencent.mm.plugin.luckymoney.ui;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.q;
import java.io.File;

@a(3)
public class LuckyMoneyNewYearReceiveUI extends LuckyMoneyBaseUI {
    private String imagePath = "";
    private TextView jCB;
    private ImageView lkk;
    private af mHandler = new af();
    private int odl = 0;
    private String ogE;
    private View ogZ;
    private TextView ogu;
    private ImageView oiA;
    private ImageView oiB;
    private View oiC;
    private ImageView oiD;
    private boolean oiE = false;
    private boolean oiF = false;
    private String oiG = "";
    private String oiH = "";
    private int oiI;
    private j oiJ;
    private boolean oiK = false;
    private LuckyMoneyAutoScrollView oiw;
    private TextView oix;
    private TextView oiy;
    private LinearLayout oiz;
    private r tipDialog = null;

    static /* synthetic */ void a(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doPreviewImage");
        if (TextUtils.isEmpty(luckyMoneyNewYearReceiveUI.imagePath)) {
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "image path is empty!");
            return;
        }
        g.pQN.h(13079, new Object[]{Integer.valueOf(7), Integer.valueOf(2)});
        new h(luckyMoneyNewYearReceiveUI, q.FS(), luckyMoneyNewYearReceiveUI.imagePath).n(true, 2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_native_url");
        this.oiG = getIntent().getStringExtra("key_image_id");
        this.oiH = getIntent().getStringExtra("key_image_aes_key");
        this.oiI = getIntent().getIntExtra("key_image_length", 0);
        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageId:" + this.oiG + ", imageLength:" + this.oiI);
        Uri parse = Uri.parse(bh.ou(stringExtra));
        try {
            this.ogE = parse.getQueryParameter("sendid");
        } catch (Exception e) {
        }
        initView();
        if (bh.ov(this.ogE)) {
            finish();
            x.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
            return;
        }
        b(new com.tencent.mm.plugin.luckymoney.b.af(bh.getInt(parse.getQueryParameter("channelid"), 1), this.ogE, stringExtra, 1, "v1.0"), false);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.oiK) {
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }

    protected final void initView() {
        this.ogZ = findViewById(f.uoL);
        this.oiw = (LuckyMoneyAutoScrollView) findViewById(f.uoG);
        this.oix = (TextView) findViewById(f.umE);
        this.ogu = (TextView) findViewById(f.uoR);
        this.lkk = (ImageView) findViewById(f.uoH);
        this.oiz = (LinearLayout) findViewById(f.uoP);
        this.jCB = (TextView) findViewById(f.uoN);
        this.oiA = (ImageView) findViewById(f.uoO);
        this.oiy = (TextView) findViewById(f.uoQ);
        this.oiB = (ImageView) findViewById(f.uoF);
        this.oiC = findViewById(f.uoB);
        this.oiD = (ImageView) findViewById(f.uoA);
        this.oiD.setOnClickListener(new 1(this));
        ((ImageView) findViewById(f.uoI)).setOnClickListener(new 2(this));
        uD(8);
        this.tipDialog = h.a(this.mController.xIM, getString(i.ctB), true, new 3(this));
    }

    private void aXL() {
        com.tencent.mm.kernel.g.Dm().F(new 5(this));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.luckymoney.b.af)) {
            if (kVar instanceof ac) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                if (i == 0 && i2 == 0) {
                    ac acVar = (ac) kVar;
                    e eVar = acVar.ocQ;
                    this.jCB.setText(acVar.ocQ.obL);
                    this.oiw.DX(com.tencent.mm.wallet_core.ui.e.t(((double) acVar.ocQ.fLR) / 100.0d));
                    this.oiw.a(new 7(this, acVar));
                    if (eVar.fLD == 4 && !TextUtils.isEmpty(acVar.ocQ.obL)) {
                        this.oiA.setVisibility(8);
                    }
                    uD(0);
                    n.a(this.ogZ, null);
                    return true;
                } else if (i2 == 416) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.hide();
                    }
                    this.oiK = true;
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    return n.a(this, i2, kVar, bundle, true, null, null, 1004);
                }
            }
            return false;
        } else if (i == 0 && i2 == 0) {
            LayoutParams layoutParams;
            com.tencent.mm.plugin.luckymoney.b.af afVar = (com.tencent.mm.plugin.luckymoney.b.af) kVar;
            this.odl = afVar.odl;
            if (this.odl == 1) {
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image data!");
                if (TextUtils.isEmpty(this.oiH)) {
                    x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageaeskey is empty!");
                }
                if (TextUtils.isEmpty(this.oiG) || TextUtils.isEmpty(this.oiH) || this.oiI <= 0) {
                    x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage() the parameter is illegeal!");
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage()!");
                    if (this.oiJ == null) {
                        this.oiJ = new j();
                    }
                    this.imagePath = n.DW(this.oiG) + ".temp";
                    if (new File(this.imagePath).exists()) {
                        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:imagePath file is exist! update image");
                        aXL();
                    } else {
                        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + this.imagePath + " is not exist!");
                        this.oiJ.a(this.oiG, this.oiH, this.oiI, this.imagePath, new 4(this));
                    }
                }
            } else {
                x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "not to download image data!");
            }
            if (afVar.aXj()) {
                this.oiE = true;
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
                b.o(this.lkk, q.FS());
                findViewById(f.uoM).setVisibility(8);
                findViewById(f.uoF).setVisibility(0);
            } else {
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
                if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username"))) {
                    b.o(this.lkk, getIntent().getStringExtra("key_username"));
                } else if (!TextUtils.isEmpty(afVar.obP)) {
                    n.a(this.lkk, afVar.obP, afVar.ocj);
                }
                n.a(this.mController.xIM, this.oiy, afVar.odA);
                this.oiE = false;
            }
            if (afVar.aXj() || afVar.fLE != 0 || afVar.fLD == 4 || afVar.fLD == 5 || afVar.fLD == 1) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                if (afVar.fLD != 5) {
                    this.oiw.DX(com.tencent.mm.wallet_core.ui.e.t(((double) afVar.odB) / 100.0d));
                    LuckyMoneyAutoScrollView luckyMoneyAutoScrollView = this.oiw;
                    luckyMoneyAutoScrollView.ogd.setVisibility(8);
                    luckyMoneyAutoScrollView.oge.setVisibility(8);
                    luckyMoneyAutoScrollView.ogf.setVisibility(8);
                    luckyMoneyAutoScrollView.ogg.setVisibility(0);
                    luckyMoneyAutoScrollView.ogh.setVisibility(0);
                    luckyMoneyAutoScrollView.ogi.setVisibility(0);
                    n.a(this.mController.xIM, this.ogu, afVar.obN);
                    this.jCB.setText(afVar.obL);
                    if (afVar.fLD == 4 && !TextUtils.isEmpty(afVar.obL)) {
                        this.oiA.setVisibility(8);
                    }
                } else {
                    findViewById(f.uoJ).setVisibility(8);
                    ((TextView) findViewById(f.uoK)).setText(afVar.obL);
                    ((TextView) findViewById(f.uoK)).setVisibility(0);
                }
                uD(0);
                n.a(this.ogZ, null);
            } else if ("0".equals(afVar.ocW)) {
                new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, this.ogp, afVar.ocX, afVar.ocY, afVar.ocZ, afVar.oda, new 6(this, afVar), true, 1005);
            } else {
                a(afVar.msgType, afVar.fdS, afVar.nZa, afVar.fLC, afVar.odE);
            }
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "scenePicSwitch:" + this.odl + ", imageId:" + this.oiG + ", imageLength:" + this.oiI);
            if (this.odl != 1 || TextUtils.isEmpty(this.oiG) || TextUtils.isEmpty(this.oiH) || this.oiI <= 0) {
                this.oiF = false;
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "don't show the picture!");
            } else {
                this.oiF = true;
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "show the picture!");
            }
            boolean z = true;
            if (afVar.fLD == 5 || afVar.fLD == 1) {
                z = false;
            }
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + afVar.fLD + ", isValidStatus is " + z);
            if (this.oiF && z) {
                this.oiC.setVisibility(0);
                this.oiB.setVisibility(8);
            } else {
                this.oiC.setVisibility(8);
                this.oiB.setVisibility(0);
            }
            if (this.oiF && z) {
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
            } else {
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
            }
            if (this.oiE) {
                layoutParams = (LayoutParams) this.oiz.getLayoutParams();
                if (this.oiF) {
                    layoutParams.topMargin = getResources().getDimensionPixelOffset(d.ucq);
                } else {
                    layoutParams.topMargin = getResources().getDimensionPixelOffset(d.ucr);
                }
                this.oiz.setLayoutParams(layoutParams);
                this.oiz.invalidate();
                this.jCB.setTextSize(1, 18.0f);
            } else {
                layoutParams = (LayoutParams) this.oiz.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(d.ucp);
                this.oiz.setLayoutParams(layoutParams);
                this.oiz.invalidate();
                this.jCB.setTextSize(1, 12.0f);
            }
            return true;
        } else {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.hide();
            }
            return false;
        }
    }

    private void a(int i, int i2, String str, String str2, String str3) {
        b(new ac(i, i2, str, str2, n.aXg(), q.FU(), getIntent().getStringExtra("key_username"), "v1.0", str3), false);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uCC;
    }
}
