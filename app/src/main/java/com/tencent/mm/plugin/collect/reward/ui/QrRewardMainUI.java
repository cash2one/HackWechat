package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.l;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.plugin.collect.reward.a.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;
import java.io.File;
import java.util.HashMap;

@a(1)
public class QrRewardMainUI extends QrRewardBaseUI {
    private String desc;
    private String fKM;
    private String iIb;
    private final int lke = com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, 200);
    private Button lkf;
    private ViewGroup lkg;
    private ViewGroup lkh;
    private RelativeLayout lki;
    private CdnImageView lkj;
    private ImageView lkk;
    private ImageView lkl;
    private MMEditText lkm;
    private TextView lkn;
    private TextView lko;
    private TextView lkp;
    private TextView lkq;
    private ScrollView lkr;
    private String lks;
    private String lkt;
    private String lku;
    private int lkv;
    private int lkw;
    private boolean lkx;
    private boolean lky;
    private boolean mIsOpen = false;
    private String username;

    static /* synthetic */ void a(QrRewardMainUI qrRewardMainUI) {
        g gVar = new g(qrRewardMainUI, g.ztp, false);
        gVar.rKC = new p$c(qrRewardMainUI) {
            final /* synthetic */ QrRewardMainUI lkA;

            {
                this.lkA = r1;
            }

            public final void a(n nVar) {
                nVar.a(1, this.lkA.getString(i.uMD), bh.ov(this.lkA.lks) ? this.lkA.getString(i.uMH) : "");
                nVar.a(2, this.lkA.getString(i.uME), !bh.ov(this.lkA.lks) ? this.lkA.getString(i.uMH) : "");
            }
        };
        gVar.rKD = new 5(qrRewardMainUI);
        gVar.bUk();
    }

    static /* synthetic */ void a(QrRewardMainUI qrRewardMainUI, boolean z) {
        x.i("MicroMsg.QrRewardMainUI", "goto set money");
        Intent intent = new Intent(qrRewardMainUI.mController.xIM, QrRewardSetMoneyUI.class);
        intent.putExtra("key_first_flag", z);
        qrRewardMainUI.startActivityForResult(intent, 1);
    }

    static /* synthetic */ void azd() {
    }

    static /* synthetic */ void b(QrRewardMainUI qrRewardMainUI) {
        if (!qrRewardMainUI.lkx) {
            qrRewardMainUI.lkr = (ScrollView) ((ViewStub) qrRewardMainUI.findViewById(f.uud)).inflate();
            TextView textView = (TextView) qrRewardMainUI.lkr.findViewById(f.uuh);
            String dC = e.dC(e.gu(qrRewardMainUI.username), 10);
            textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(qrRewardMainUI, qrRewardMainUI.getString(i.uMG, new Object[]{dC}), textView.getTextSize()));
            qrRewardMainUI.lkx = true;
        }
        ImageView imageView = (ImageView) qrRewardMainUI.lkr.findViewById(f.uuf);
        ViewGroup viewGroup = (ViewGroup) qrRewardMainUI.lkr.findViewById(f.uux);
        if (!bh.ov(qrRewardMainUI.desc)) {
            ((TextView) qrRewardMainUI.lkr.findViewById(f.uug)).setText(com.tencent.mm.pluginsdk.ui.d.i.b(qrRewardMainUI, qrRewardMainUI.getString(i.uML, new Object[]{qrRewardMainUI.desc}), qrRewardMainUI.lkn.getTextSize()));
        }
        qrRewardMainUI.lkr.setVisibility(4);
        ag.h(new 8(qrRewardMainUI, viewGroup, imageView), 250);
    }

    static /* synthetic */ void g(QrRewardMainUI qrRewardMainUI) {
        x.i("MicroMsg.QrRewardMainUI", "show first guide view");
        qrRewardMainUI.lkh.setVisibility(8);
        qrRewardMainUI.lkg.setVisibility(0);
        qrRewardMainUI.lkf.setOnClickListener(new 9(qrRewardMainUI));
    }

    static /* synthetic */ void o(QrRewardMainUI qrRewardMainUI) {
        qrRewardMainUI.lkm.setCursorVisible(true);
        qrRewardMainUI.lkm.requestFocus();
        qrRewardMainUI.lkm.requestFocusFromTouch();
        qrRewardMainUI.showVKB();
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        ji(1323);
        ji(1649);
        this.lkv = ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwP, Integer.valueOf(900))).intValue();
        this.lkw = ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwQ, Integer.valueOf(l.CTRL_INDEX))).intValue();
        this.desc = (String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwS, "");
        this.lks = (String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwR, "");
        this.lkt = (String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwW, "");
        this.lku = (String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwX, "");
        this.iIb = (String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwY, "");
        if (!bh.ov((String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwV, ""))) {
            this.lky = true;
        }
        this.username = q.FS();
        setMMTitle(i.uMC);
        initView();
        if (com.tencent.mm.plugin.collect.reward.b.a.ayT().ayU() && this.lky) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.QrRewardMainUI", "do get code: %s", new Object[]{Boolean.valueOf(z)});
        k bVar = new b(z);
        bVar.m(this);
        if (z) {
            b(bVar, false);
        } else {
            b(bVar, true);
        }
    }

    protected final void initView() {
        this.lkf = (Button) findViewById(f.uub);
        this.lkg = (ViewGroup) findViewById(f.uua);
        this.lkh = (ViewGroup) findViewById(f.utZ);
        this.lkj = (CdnImageView) findViewById(f.utV);
        this.lkn = (TextView) findViewById(f.utY);
        this.lkk = (ImageView) findViewById(f.utU);
        this.lkl = (ImageView) findViewById(f.utT);
        this.lki = (RelativeLayout) findViewById(f.utW);
        this.lkm = (MMEditText) findViewById(f.utX);
        this.lko = (TextView) findViewById(f.uuc);
        this.lkq = (TextView) findViewById(f.uue);
        this.lkp = (TextView) findViewById(f.utS);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.lkk, this.username, 0.03f, true);
        try {
            this.lkm.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.mController.xIM, this.lks, this.lkm.getTextSize()));
            this.lkm.setSelection(this.lks.length());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.QrRewardMainUI", e, "", new Object[0]);
        }
        this.lkm.addTextChangedListener(new 1(this));
        this.lkm.setOnEditorActionListener(new 10(this));
        this.lkl.setOnClickListener(new 11(this));
        this.lko.setClickable(true);
        this.lko.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.l(this));
        com.tencent.mm.plugin.wallet_core.ui.l lVar = new com.tencent.mm.plugin.wallet_core.ui.l(new 12(this));
        CharSequence spannableString = new SpannableString(getString(i.uMF));
        spannableString.setSpan(lVar, 0, spannableString.length(), 18);
        this.lko.setText(spannableString);
        this.lkq.setClickable(true);
        this.lkq.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.l(this));
        lVar = new com.tencent.mm.plugin.wallet_core.ui.l(new 13(this));
        spannableString = new SpannableString(getString(i.uMK));
        spannableString.setSpan(lVar, 0, spannableString.length(), 18);
        this.lkq.setText(spannableString);
        ayY();
        ayZ();
        azb();
        aza();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            final b bVar = (b) kVar;
            bVar.a(new com.tencent.mm.plugin.collect.reward.a.a.a(this) {
                final /* synthetic */ QrRewardMainUI lkA;

                public final void i(k kVar) {
                    this.lkA.lks = bVar.ljs.kHm;
                    this.lkA.lkv = bVar.ljs.vUb;
                    this.lkA.lkw = bVar.ljs.vTX;
                    this.lkA.desc = bVar.ljs.desc;
                    this.lkA.fKM = bVar.ljs.sKt;
                    this.lkA.mIsOpen = !bVar.ljs.vTV;
                    this.lkA.lkt = bVar.ljs.kLA;
                    this.lkA.lku = bVar.ljs.vTZ;
                    this.lkA.lky = true;
                    this.lkA.aza();
                    if (this.lkA.mIsOpen) {
                        this.lkA.g(bVar.ljs.pKb, bVar.ljs.vTW, false);
                        this.lkA.ayZ();
                        this.lkA.azb();
                    } else {
                        QrRewardMainUI.g(this.lkA);
                    }
                    this.lkA.iIb = bVar.ljs.pKb;
                    QrRewardMainUI.azd();
                    x.d("MicroMsg.QrRewardMainUI", "url: %s", new Object[]{this.lkA.iIb});
                }
            }).b(new 15(this, bVar)).c(new 14(this, bVar));
        } else if (kVar instanceof h) {
            final h hVar = (h) kVar;
            hVar.a(new 3(this, hVar)).b(new com.tencent.mm.plugin.collect.reward.a.a.a(this) {
                final /* synthetic */ QrRewardMainUI lkA;

                public final void i(k kVar) {
                    x.e("MicroMsg.QrRewardMainUI", "set word error: %s, %s", new Object[]{Integer.valueOf(hVar.ljz.liH), hVar.ljz.liI});
                    this.lkA.lks = (String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwR, "");
                    this.lkA.em(bh.ov(this.lkA.lks));
                    this.lkA.lkm.setText("");
                    this.lkA.azb();
                    if (!bh.ov(hVar.ljz.liI)) {
                        Toast.makeText(this.lkA, hVar.ljz.liI, 0).show();
                    }
                }
            }).c(new 17(this));
            this.lkm.clearFocus();
            this.lkm.setCursorVisible(false);
        }
        return true;
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        x.i("MicroMsg.QrRewardMainUI", "key board changed: %s", new Object[]{Integer.valueOf(this.mController.xJg)});
        if (this.mController.xJg == 2) {
            this.lks = this.lkm.getText().toString();
            azc();
            if (bh.ov(this.lks)) {
                em(true);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            this.desc = intent.getStringExtra("key_desc");
            this.lkv = intent.getIntExtra("key_photo_width", 900);
            this.lkw = intent.getIntExtra("key_icon_width", l.CTRL_INDEX);
            x.i("MicroMsg.QrRewardMainUI", "return from first: %s", new Object[]{Boolean.valueOf(intent.getBooleanExtra("key_return_from_first", true))});
            if (intent.getBooleanExtra("key_return_from_first", true)) {
                this.lkh.setVisibility(0);
                this.lkg.setVisibility(8);
            }
            this.lky = true;
            ayZ();
            String stringExtra = intent.getStringExtra("key_photo_url");
            g(stringExtra, intent.getStringExtra("key_photo_aeskey"), true);
            this.iIb = stringExtra;
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uDK;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1323);
        jj(1649);
        com.tencent.mm.plugin.collect.reward.b.a ayT = com.tencent.mm.plugin.collect.reward.b.a.ayT();
        x.d("MicroMsg.QrRewardCdnDownloadHelper", "do clear callback");
        if (ayT.gKa != null) {
            x.i("MicroMsg.QrRewardCdnDownloadHelper", "callback size: %s", new Object[]{Integer.valueOf(ayT.gKa.size())});
            ayT.gKa.clear();
        }
    }

    protected final boolean Xd() {
        return false;
    }

    private void g(String str, String str2, boolean z) {
        boolean z2 = this.iIb != null && this.iIb.equals(str);
        x.i("MicroMsg.QrRewardMainUI", "do download photo: %s, same url: %s, pic exist: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(com.tencent.mm.plugin.collect.reward.b.a.ayT().ayU())});
        if (z || !z2 || !r3) {
            com.tencent.mm.plugin.collect.reward.b.a ayT = com.tencent.mm.plugin.collect.reward.b.a.ayT();
            AnonymousClass6 anonymousClass6 = new com.tencent.mm.plugin.collect.reward.b.a.a(this) {
                final /* synthetic */ QrRewardMainUI lkA;

                {
                    this.lkA = r1;
                }

                public final void C(String str, int i, int i2) {
                    x.i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i == 0 && i2 == 0) {
                        ag.y(new 1(this));
                    }
                }
            };
            x.i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", new Object[]{str});
            File file = new File(com.tencent.mm.plugin.collect.reward.b.a.ljA);
            if (!file.exists()) {
                file.mkdirs();
            }
            com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
            iVar.fLH = false;
            iVar.htt = ayT;
            iVar.field_fullpath = com.tencent.mm.plugin.collect.reward.b.a.ljA + ayT.ayV();
            iVar.field_mediaId = bh.ou(d.a("QrRewardImg", bh.Wp(), q.Gy().field_username, ""));
            iVar.field_fileId = str;
            iVar.field_aesKey = str2;
            iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
            iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
            iVar.field_needStorage = false;
            iVar.field_isStreamMedia = false;
            iVar.field_appType = 0;
            iVar.field_bzScene = 0;
            if (ayT.gKa == null) {
                ayT.gKa = new HashMap();
            }
            ayT.gKa.put(iVar.field_mediaId, anonymousClass6);
            if (!com.tencent.mm.modelcdntran.g.MJ().b(iVar, -1)) {
                x.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", new Object[]{str});
            }
        }
    }

    private void ayY() {
        if (com.tencent.mm.plugin.collect.reward.b.a.ayT().ayU()) {
            this.lkj.V(com.tencent.mm.plugin.collect.reward.b.a.ljA + com.tencent.mm.plugin.collect.reward.b.a.ayT().ayV(), this.lke, this.lke);
            this.lki.setVisibility(0);
            return;
        }
        this.lki.setVisibility(4);
    }

    private void ayZ() {
        int round = Math.round(((float) this.lke) * ((((float) this.lkw) * 1.0f) / ((float) this.lkv)));
        if (round <= 0) {
            round = 248;
        }
        ViewGroup.LayoutParams layoutParams = this.lkl.getLayoutParams();
        layoutParams.width = round;
        layoutParams.height = round;
        this.lkl.setLayoutParams(layoutParams);
        layoutParams = this.lkk.getLayoutParams();
        layoutParams.width = round;
        layoutParams.height = round;
        this.lkk.setLayoutParams(layoutParams);
        layoutParams = this.lkm.getLayoutParams();
        layoutParams.width = round - 30;
        layoutParams.height = round - 30;
        this.lkm.setLayoutParams(layoutParams);
        this.lkm.setTextSize(0, (float) ((round * 2) / 3));
        this.lkh.requestLayout();
        if (bh.ov(this.desc)) {
            this.lkn.setText("");
        } else {
            this.lkn.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, getString(i.uML, new Object[]{this.desc}), this.lkn.getTextSize()));
        }
        em(bh.ov(this.lks));
    }

    private void aza() {
        if (bh.ov(this.lkt)) {
            this.lkp.setVisibility(8);
            return;
        }
        this.lkp.setClickable(true);
        this.lkp.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.l(this));
        com.tencent.mm.plugin.wallet_core.ui.l lVar = new com.tencent.mm.plugin.wallet_core.ui.l(new 7(this));
        CharSequence spannableString = new SpannableString(this.lkt);
        spannableString.setSpan(lVar, 0, spannableString.length(), 18);
        this.lkp.setText(spannableString);
        this.lkp.setVisibility(0);
    }

    private void em(boolean z) {
        x.i("MicroMsg.QrRewardMainUI", "switch mode: %s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.lkk.setVisibility(0);
            this.lkm.setVisibility(4);
            com.tencent.mm.pluginsdk.ui.a.b.a(this.lkk, this.username, 0.03f, true);
            return;
        }
        this.lkk.setVisibility(4);
        this.lkm.setVisibility(0);
    }

    private void azb() {
        if (!bh.ov(this.lks)) {
            this.lkm.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.mController.xIM, this.lks, this.lkm.getTextSize()));
            this.lkm.setSelection(this.lks.length());
        }
    }

    private void azc() {
        x.i("MicroMsg.QrRewardMainUI", "do set photo word");
        k hVar = new h(this.lks);
        hVar.m(this);
        b(hVar, true);
    }
}
