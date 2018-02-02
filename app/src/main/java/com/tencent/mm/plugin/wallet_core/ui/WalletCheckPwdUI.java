package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.a.na;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.c.b;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.protocal.c.bny;
import com.tencent.mm.protocal.c.ni;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.wcdb.database.SQLiteDatabase;

@a(3)
public class WalletCheckPwdUI extends WalletBaseUI {
    private String fuH;
    private int fxG = 0;
    private TextView ihX;
    private ScrollView jjn;
    private String mzr;
    public EditHintPasswdView sBG;
    private boolean sTg = false;
    private LinearLayout sTh;
    private ImageView sTi;
    private TextView sTj;
    private boolean sTk = false;
    private boolean sTl = false;
    private String sTm;
    private int sTn = 0;
    private int sTo;
    private String sTp;
    private String sTq;
    private Animation sTr;

    static /* synthetic */ void a(WalletCheckPwdUI walletCheckPwdUI) {
        c cCc = walletCheckPwdUI.cCc();
        x.i("Micromsg.WalletCheckPwdUI", "onbackbtn click");
        if (cCc != null) {
            if (cCc instanceof com.tencent.mm.plugin.wallet_core.id_verify.a) {
                cCc.d(walletCheckPwdUI, 0);
            } else if (walletCheckPwdUI.sTl) {
                cCc.msB.putInt("key_process_result_code", 0);
                cCc.b(walletCheckPwdUI, cCc.msB);
            } else if (cCc.aKG().equals("OpenECardProcess")) {
                walletCheckPwdUI.vf.putInt("key_process_result_code", 0);
                walletCheckPwdUI.setResult(-1);
                cCc.ah(walletCheckPwdUI.mController.xIM);
            }
        }
        walletCheckPwdUI.finish();
    }

    static /* synthetic */ void b(WalletCheckPwdUI walletCheckPwdUI, String str) {
        x.i("Micromsg.WalletCheckPwdUI", "do check pwd by fp");
        walletCheckPwdUI.b(new s(walletCheckPwdUI.sTm, str), true);
        g.pQN.h(15021, Integer.valueOf(2));
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uEO;
    }

    public final void uD(int i) {
        this.mController.contentView.setVisibility(i);
    }

    public void onCreate(Bundle bundle) {
        int i = -1;
        super.onCreate(bundle);
        CharSequence um = um(1);
        if (bh.M(um)) {
            setMMTitle(u.gg(this));
        } else {
            setMMTitle(um.toString());
        }
        Intent intent = getIntent();
        if (intent == null || !getIntent().hasExtra("scene")) {
            c ag = com.tencent.mm.wallet_core.a.ag(this);
            if (ag != null) {
                int i2 = ag.msB.getInt("scene", -1);
                boolean z = i2 == 1 && "UnbindProcess".equals(ag.aKG());
                this.sTl = z;
                i = i2;
            }
        } else {
            i = intent.getIntExtra("scene", -1);
        }
        if (i == 1) {
            this.sTk = true;
            x.d("Micromsg.WalletCheckPwdUI", "check pwd jsapi");
            uD(4);
            this.mController.hideTitleView();
            Bundle bundle2 = null;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            int i3;
            k bVar;
            if (this.sTl) {
                c ag2 = com.tencent.mm.wallet_core.a.ag(this);
                if (ag2 != null) {
                    bundle2 = ag2.msB;
                }
                if (bundle2 == null) {
                    x.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] process.getContextData null");
                    setResult(1);
                    finish();
                }
                string = bundle2.getString("appId");
                string2 = bundle2.getString("timeStamp");
                string3 = bundle2.getString("nonceStr");
                string4 = bundle2.getString("packageExt");
                string5 = bundle2.getString("signtype");
                string6 = bundle2.getString("paySignature");
                string7 = bundle2.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                i3 = bundle2.getInt("pay_channel", 0);
                if (this.sTl) {
                    bVar = new b(string, string2, string3, string4, string5, string6, string7, "verifyWCPayPassword", i3);
                } else {
                    x.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bh.ov(string));
                    bVar = new com.tencent.mm.plugin.wallet_core.c.a(string, string2, string3, string4, string5, string6, string7, 10, "verifyWCPayPassword", i3);
                }
                r(bVar);
            } else if (getIntent() == null) {
                x.d("Micromsg.WalletCheckPwdUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
            } else {
                bundle2 = getIntent().getExtras();
                string = bundle2.getString("appId");
                string2 = bundle2.getString("timeStamp");
                string3 = bundle2.getString("nonceStr");
                string4 = bundle2.getString("packageExt");
                string5 = bundle2.getString("signtype");
                string6 = bundle2.getString("paySignature");
                string7 = bundle2.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                i3 = bundle2.getInt("pay_channel", 0);
                if (this.sTl) {
                    bVar = new b(string, string2, string3, string4, string5, string6, string7, "verifyWCPayPassword", i3);
                } else {
                    x.i("Micromsg.WalletCheckPwdUI", "appId is null? " + bh.ov(string));
                    bVar = new com.tencent.mm.plugin.wallet_core.c.a(string, string2, string3, string4, string5, string6, string7, 10, "verifyWCPayPassword", i3);
                }
                r(bVar);
            }
            initView();
        } else {
            uD(0);
            this.mController.showTitleView();
            if (!this.vf.getBoolean("key_is_expired_bankcard", false)) {
                initView();
            }
        }
        setBackBtn(new 1(this));
        findViewById(a$f.uhN).setOnClickListener(new 2(this));
    }

    protected final void aXc() {
        x.d("Micromsg.WalletCheckPwdUI", "check pwd ");
        this.zIY.aXc();
    }

    public void onResume() {
        if (this.sBG != null) {
            this.sBG.bmK();
        }
        ji(580);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        jj(580);
    }

    public void onDestroy() {
        super.onDestroy();
        bMz();
    }

    protected final void initView() {
        TextView textView = (TextView) findViewById(a$f.ula);
        CharSequence um = um(0);
        if (bh.M(um)) {
            textView.setText(i.uQW);
        } else {
            textView.setText(um);
            if (um instanceof SpannableString) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        this.sBG = (EditHintPasswdView) findViewById(a$f.ukY);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sBG);
        this.sBG.zJC = new EditHintPasswdView.a(this) {
            final /* synthetic */ WalletCheckPwdUI sTs;

            {
                this.sTs = r1;
            }

            public final void hx(boolean z) {
                if (z) {
                    this.sTs.mzr = this.sTs.sBG.getText();
                    c ag = com.tencent.mm.wallet_core.a.ag(this.sTs);
                    Object obj = null;
                    if (ag != null) {
                        obj = ag.aKG();
                    }
                    if (!this.sTs.sTk || "UnbindProcess".equals(r0)) {
                        if (!this.sTs.cCd().k(new Object[]{this.sTs.mzr, this.sTs.bJQ()})) {
                            this.sTs.l(new r(this.sTs.mzr, 1, this.sTs.bJQ()));
                            return;
                        }
                        return;
                    }
                    this.sTs.l(new s(this.sTs.mzr, this.sTs.sTm, (byte) 0));
                    g.pQN.h(15021, Integer.valueOf(1));
                }
            }
        };
        this.jjn = (ScrollView) findViewById(a$f.uAG);
        this.sTh = (LinearLayout) findViewById(a$f.ukD);
        this.sTi = (ImageView) findViewById(a$f.ukC);
        this.sTj = (TextView) findViewById(a$f.ukE);
        this.ihX = (TextView) findViewById(a$f.uAF);
        this.ihX.setOnClickListener(new 4(this));
        this.ofE = new 5(this);
        e(this.sBG, 0, false);
    }

    private void a(awg com_tencent_mm_protocal_c_awg) {
        findViewById(a$f.uzX).setVisibility(0);
        findViewById(a$f.ula).setVisibility(8);
        if (com_tencent_mm_protocal_c_awg == null || bh.ov(com_tencent_mm_protocal_c_awg.title)) {
            ((TextView) findViewById(a$f.uzY)).setText(i.uQS);
        } else {
            ((TextView) findViewById(a$f.uzY)).setText(com_tencent_mm_protocal_c_awg.title);
        }
        if (com_tencent_mm_protocal_c_awg == null || bh.ov(com_tencent_mm_protocal_c_awg.wDW)) {
            ((TextView) findViewById(a$f.uzW)).setText(i.uQR);
        } else {
            ((TextView) findViewById(a$f.uzW)).setText(com_tencent_mm_protocal_c_awg.wDW);
        }
        if (this.sBG.getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) this.sBG.getLayoutParams();
            layoutParams.leftMargin = BackwardSupportUtil.b.b((Context) this, 47.0f);
            layoutParams.rightMargin = BackwardSupportUtil.b.b((Context) this, 47.0f);
            this.sBG.setLayoutParams(layoutParams);
        }
        this.mController.hideTitleView();
    }

    private void bMx() {
        x.i("Micromsg.WalletCheckPwdUI", "change mode: %s", Integer.valueOf(this.fxG));
        if (this.fxG == 1) {
            this.sTh.setVisibility(0);
            this.sBG.setVisibility(8);
            this.ihX.setText(i.uQP);
            Xa();
            if (bh.ov(this.sTq)) {
                ((TextView) findViewById(a$f.uzW)).setText(i.uQR);
                return;
            } else {
                ((TextView) findViewById(a$f.uzW)).setText(this.sTq);
                return;
            }
        }
        this.sTh.setVisibility(8);
        this.sBG.bmK();
        this.sBG.setVisibility(0);
        this.ihX.setText(i.uQO);
        cCb();
        if (bh.ov(this.sTp)) {
            ((TextView) findViewById(a$f.uzW)).setText(i.uQR);
        } else {
            ((TextView) findViewById(a$f.uzW)).setText(this.sTp);
        }
    }

    public boolean d(int i, int i2, String str, k kVar) {
        x.d("Micromsg.WalletCheckPwdUI", " errCode: " + i2 + " errMsg :" + str);
        c ag;
        if (i != 0 || i2 != 0) {
            if (this.sBG != null) {
                this.sBG.bmK();
            }
            if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) && !(kVar instanceof b)) {
                return false;
            }
            x.i("Micromsg.WalletCheckPwdUI", "check jsapi fail");
            ag = com.tencent.mm.wallet_core.a.ag(this);
            if (ag == null || !ag.aKG().equals("UnbindProcess")) {
                setResult(0);
                finish();
                return true;
            }
            setResult(1);
            ag.msB.putInt("key_process_result_code", 1);
            com.tencent.mm.wallet_core.a.j(this, ag.msB);
            return true;
        } else if (kVar instanceof r) {
            Bundle bundle = this.vf;
            bundle.putString("key_pwd1", this.sBG.getText());
            com.tencent.mm.wallet_core.a.j(this, bundle);
            if (this.sBG != null) {
                this.sBG.bmK();
            }
            finish();
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
            h.bu(this, getString(i.uRa));
            ag = com.tencent.mm.wallet_core.a.ag(this);
            if (ag != null) {
                ag.msB.putInt("key_process_result_code", -1);
            }
            com.tencent.mm.wallet_core.a.j(this, ag.msB);
            if (this.sBG != null) {
                this.sBG.bmK();
            }
            finish();
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            f.Ta(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bKH());
            this.sTm = ((com.tencent.mm.plugin.wallet_core.c.a) kVar).bhV();
            setResult(-1);
            awg com_tencent_mm_protocal_c_awg = ((ni) ((com.tencent.mm.plugin.wallet_core.c.a) kVar).gJQ.hmh.hmo).vWo;
            if (((com.tencent.mm.plugin.wallet_core.c.a) kVar).sIh == 5) {
                a(com_tencent_mm_protocal_c_awg);
            } else {
                this.mController.showTitleView();
                findViewById(a$f.uzX).setVisibility(8);
            }
            uD(0);
            return true;
        } else if (kVar instanceof b) {
            b bVar = (b) kVar;
            this.sTm = bVar.sIi.token;
            this.fuH = bVar.sIi.vzI;
            f.Ta(bVar.sIi.vzI);
            if (bVar.sIi.vWo != null) {
                this.sTp = bVar.sIi.vWo.wDW;
                this.sTq = bVar.sIi.vWo.wDX;
            }
            setResult(-1);
            a(bVar.sIi.vWo);
            bny com_tencent_mm_protocal_c_bny = bVar.sIi.vWB;
            if (com_tencent_mm_protocal_c_bny != null) {
                l lVar = (l) com.tencent.mm.kernel.g.h(l.class);
                if (com_tencent_mm_protocal_c_bny.wQJ == 1 && lVar.aKe() && lVar.aKd() && !lVar.aJY()) {
                    x.i("Micromsg.WalletCheckPwdUI", "can use touch pay");
                    this.fxG = 1;
                    com.tencent.mm.plugin.wallet_core.model.s.sPp.mzI = com_tencent_mm_protocal_c_bny.wQK.cdp();
                    com.tencent.mm.plugin.wallet_core.model.s.sPp.mzJ = com_tencent_mm_protocal_c_bny.wQL == 1;
                    bMy();
                    this.ihX.setVisibility(0);
                }
            }
            bMx();
            uD(0);
            return true;
        } else if (!(kVar instanceof s)) {
            return true;
        } else {
            s sVar = (s) kVar;
            if (sVar.bKI()) {
                x.i("Micromsg.WalletCheckPwdUI", "need free sms");
                Bundle bundle2 = new Bundle();
                bundle2.putString("key_pwd1", this.mzr);
                bundle2.putString("key_jsapi_token", this.sTm);
                bundle2.putString("key_relation_key", sVar.sIG);
                bundle2.putString("key_mobile", sVar.sIF);
                com.tencent.mm.wallet_core.a.a(this, k.class, bundle2, new c.a(this) {
                    final /* synthetic */ WalletCheckPwdUI sTs;

                    {
                        this.sTs = r1;
                    }

                    public final Intent l(int i, Bundle bundle) {
                        Intent intent = new Intent();
                        intent.putExtra("token", bundle.getString("key_jsapi_token"));
                        intent.putExtra("key_process_result_code", i);
                        intent.setClass(this.sTs.mController.xIM, WalletCheckPwdUI.class);
                        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                        intent.putExtra("key_process_is_stay", false);
                        return intent;
                    }
                });
                return true;
            }
            Intent intent = new Intent();
            intent.putExtra("token", ((s) kVar).sID);
            setResult(-1, intent);
            finish();
            return true;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.ofs == null || !this.ofs.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.ofs.setVisibility(8);
        return true;
    }

    public boolean bKa() {
        if (this.vf.getInt("key_pay_flag", 0) != 0) {
            return true;
        }
        return false;
    }

    public final void uw(int i) {
        if (this.sTg) {
            finish();
        } else if (this.sBG != null) {
            this.sBG.bmK();
        }
    }

    public final boolean aYf() {
        return this.sTg;
    }

    public int getForceOrientation() {
        return 1;
    }

    private void bMy() {
        com.tencent.mm.plugin.soter.c.a.bCN();
        final com.tencent.mm.sdk.b.b lfVar = new lf();
        lfVar.fCw.fwY = this.fuH;
        lfVar.fCw.fCy = 1;
        lfVar.fCw.fCA = new Runnable(this) {
            final /* synthetic */ WalletCheckPwdUI sTs;

            public final void run() {
                x.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
                lf.b bVar = lfVar.fCx;
                if (bVar == null) {
                    x.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
                    return;
                }
                int i = bVar.errCode;
                x.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), bVar.fnL);
                if (i == 0) {
                    x.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", bVar.fCB);
                    this.sTs.sTj.setVisibility(8);
                    WalletCheckPwdUI.b(this.sTs, bVar.fCB);
                    com.tencent.mm.plugin.soter.c.a.ya(0);
                    return;
                }
                boolean z;
                x.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int j = currentTimeMillis - this.sTs.sTo;
                if (j > 1) {
                    this.sTs.sTo = currentTimeMillis;
                    this.sTs.sTn = this.sTs.sTn + 1;
                }
                boolean z2 = i == 2 || i == 10308;
                if (bVar.fCC == 2) {
                    z = true;
                } else {
                    z = false;
                }
                x.v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(this.sTs.sTn), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (this.sTs.sTn < 3 && j > 1)) && !z2) {
                    x.v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
                    if (this.sTs.sTr == null) {
                        this.sTs.sTr = com.tencent.mm.ui.c.a.fA(this.sTs.mController.xIM);
                    }
                    this.sTs.sTj.setVisibility(0);
                    this.sTs.sTj.startAnimation(this.sTs.sTr);
                    this.sTs.sTr.setFillAfter(true);
                    com.tencent.mm.plugin.soter.c.a.ya(1);
                } else if (this.sTs.sTn >= 3 || z2) {
                    x.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
                    WalletCheckPwdUI.bMz();
                    this.sTs.fxG = 0;
                    this.sTs.bMx();
                    this.sTs.ihX.setVisibility(8);
                    com.tencent.mm.plugin.soter.c.a.ya(2);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xef.a(lfVar, Looper.getMainLooper());
    }

    private static void bMz() {
        x.i("Micromsg.WalletCheckPwdUI", "hy: send release FPManager");
        com.tencent.mm.sdk.b.a.xef.m(new na());
    }
}
