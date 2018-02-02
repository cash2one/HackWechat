package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.in;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.c.m;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.n.b;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import org.xwalk.core.R$styleable;

@a(3)
public class WalletBindCardResultUI extends WalletBaseUI {
    private c oYB = new 1(this);
    private String pOF;
    private TextView pPo;
    private String pbR = null;
    private PayInfo sEO;
    private int sND;
    private HashMap<String, WalletOrderInfoNewUI.a> sRA = new HashMap();
    private String sRB;
    private BindCardOrder sRC = null;
    private String sRD = "-1";
    private Button sRE;
    private ImageView sRF;
    private ViewGroup sRG;
    private CdnImageView sRH;
    private TextView sRI;
    private TextView sRJ;
    private View sRK;
    private Button sRL;
    private ViewGroup sRM;
    private boolean sRN = false;
    private boolean sRO = false;
    private boolean sRP = false;
    private com.tencent.mm.wallet_core.c sRQ;
    private BindCardOrder sRu;
    private boolean sRv = false;
    private String sRw;
    private String sRx;
    private b sRy;
    private WalletOrderInfoNewUI.b sRz;

    static /* synthetic */ void b(WalletBindCardResultUI walletBindCardResultUI) {
        String str = "MicroMsg.WalletBindCardResultUI";
        String str2 = "onClickActivity, activityId: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletBindCardResultUI.sRC != null ? walletBindCardResultUI.sRC.sLS.sIr : 0);
        x.i(str, str2, objArr);
        if (walletBindCardResultUI.sRC != null && walletBindCardResultUI.sRC.sLS.sIr > 0) {
            walletBindCardResultUI.gI(2);
            walletBindCardResultUI.sRO = true;
            if (!walletBindCardResultUI.sRD.equals("-1") && !walletBindCardResultUI.sRD.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                return;
            }
            if (walletBindCardResultUI.sRu.bKW()) {
                BindCardOrder bindCardOrder = walletBindCardResultUI.sRC;
                walletBindCardResultUI.r(new m(bindCardOrder, bindCardOrder.sLS.sIr, bindCardOrder.sLS.sNt, bindCardOrder.sLS.sNu, bindCardOrder.sLS.sNv, bindCardOrder.sLS.sNw, bindCardOrder.sLS.sNs, walletBindCardResultUI.sRu.oZz, walletBindCardResultUI.sRu.sLP, walletBindCardResultUI.sRu.sLQ, walletBindCardResultUI.sRu.sLR));
            } else if (!walletBindCardResultUI.sRu.bKV() || bh.ov(walletBindCardResultUI.sRC.sLT.url)) {
                x.e("MicroMsg.WalletBindCardResultUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
            } else if (walletBindCardResultUI.sRA.containsKey(walletBindCardResultUI.sRC.sLS.sIr)) {
                WalletOrderInfoNewUI.a aVar = (WalletOrderInfoNewUI.a) walletBindCardResultUI.sRA.get(walletBindCardResultUI.sRC.sLS.sIr);
                x.i("MicroMsg.WalletBindCardResultUI", "go to new url %s", new Object[]{aVar.url});
                if (bh.ov(aVar.url)) {
                    walletBindCardResultUI.Nn(walletBindCardResultUI.sRC.sLT.url);
                } else {
                    walletBindCardResultUI.Nn(aVar.url);
                }
            } else {
                walletBindCardResultUI.sRB = walletBindCardResultUI.sRC.sLT.url;
                String str3 = walletBindCardResultUI.sRC.sLT.url;
                WalletOrderInfoNewUI.b bVar = new WalletOrderInfoNewUI.b(walletBindCardResultUI.sRC.sLS.sIr, walletBindCardResultUI.sRC.sLS.sNt, walletBindCardResultUI.sRC.sLS.sNu, walletBindCardResultUI.sRC.sLS.sNv, walletBindCardResultUI.bJQ(), walletBindCardResultUI.pOF, walletBindCardResultUI.sRC.sLS.sNw, walletBindCardResultUI.sRC.sLS.sNs);
                walletBindCardResultUI.bMu();
                walletBindCardResultUI.sRz = bVar;
                e.r(walletBindCardResultUI, str3, 1);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d.fM(21)) {
            if (d.fM(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        uD(4);
        com.tencent.mm.wallet_core.a.ag(this);
        this.sEO = (PayInfo) this.vf.getParcelable("key_pay_info");
        this.vf.getInt("key_pay_type", -1);
        BindCardOrder bindCardOrder = (BindCardOrder) this.vf.getParcelable("key_bindcard_value_result");
        if (bindCardOrder == null) {
            bindCardOrder = new BindCardOrder();
        }
        this.sRu = bindCardOrder;
        uD(0);
        initView();
        this.sRQ = cCc();
        bMs();
        gI(1);
        ji(1979);
        com.tencent.mm.sdk.b.a.xef.b(this.oYB);
        this.sRP = true;
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[]{Boolean.valueOf(this.sRP), this.sRC, Boolean.valueOf(this.sRN), Boolean.valueOf(this.sRO), this.sRy});
        if (this.sRP) {
            this.sRP = false;
        } else if (this.sRC != null && this.sRO) {
            l(new w(this.sRC.sLS.sIr, this.sRC.sLS.sNt, this.sRC.sLS.sNu, this.sRC.sLS.sNv, this.sRC.sLS.sNs, this.sRC.sLS.sNw, this.sRu.oZz, this.sRu.sLP, this.sRu.sLQ, this.sRu.sLQ));
        } else if (this.sRN && this.sRy != null) {
            l(new w(this.sRu.sLS.sIr, this.sRu.sLS.sNt, this.sRu.sLS.sNu, this.sRu.sLS.sNv, this.sRu.sLS.sNw, this.sRu.sLS.sNs, this.sRu.oZz, this.sRu.sLP, this.sRu.sLQ, this.sRu.sLQ));
        }
    }

    protected final void initView() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.sRF = (ImageView) findViewById(f.uAN);
        this.pPo = (TextView) findViewById(f.usS);
        this.sRE = (Button) findViewById(f.usP);
        showHomeBtn(false);
        enableBackMenu(false);
        CharSequence string = getString(a$i.dFl);
        if (this.sRu == null || bh.ov(this.sRu.sLL)) {
            this.sRE.setText(string);
        } else {
            this.sRE.setText(this.sRu.sLL);
        }
        this.sRE.setOnClickListener(new 2(this));
        this.sRM = (ViewGroup) findViewById(f.uzi);
        this.sRG = (ViewGroup) findViewById(f.uwX);
        this.sRH = (CdnImageView) findViewById(f.uwZ);
        this.sRH.vng = true;
        this.sRI = (TextView) findViewById(f.uwW);
        this.sRJ = (TextView) findViewById(f.uxb);
        this.sRL = (Button) findViewById(f.uwU);
        this.sRK = findViewById(f.uwY);
        this.sRM.setVisibility(4);
        bMs();
        bMt();
        bMr();
        if (!bh.ov(this.sRu.sLN) && !bh.ov(this.sRu.sLO)) {
            ((TextView) findViewById(f.usT)).setText(getString(a$i.uPO, new Object[]{this.sRu.sLN, this.sRu.sLO}));
        }
    }

    private void bMr() {
        this.sRM.setVisibility(0);
    }

    private void bMs() {
        this.pPo.setText(this.sRu.sLM);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bMt() {
        boolean z = true;
        this.sRG.setVisibility(4);
        this.sRO = false;
        this.sRN = false;
        if (this.sRu != null) {
            if (this.sRu.sLS != null) {
                x.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", new Object[]{this.sRC});
                WalletOrderInfoNewUI.a aVar;
                CharSequence text;
                if (this.sRu != null && ((this.sRu.bKV() || this.sRu.bKW()) && this.sRu.sLS.sIr > 0 && !bh.ov(this.sRu.sLT.sNx))) {
                    this.sRC = this.sRu;
                    this.sRK.setVisibility(8);
                    this.sRH.vnf = true;
                    this.sRL.setEnabled(true);
                    this.sRL.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bAb);
                    this.sRJ.setCompoundDrawables(null, null, null, null);
                    aVar = (WalletOrderInfoNewUI.a) this.sRA.get(this.sRC.sLS.sIr);
                    if (aVar != null) {
                        if (!bh.ov(aVar.fDI)) {
                            this.sRH.setUrl(aVar.fDI);
                        }
                        if (!bh.ov(aVar.fyY)) {
                            this.sRI.setText(aVar.fyY);
                        }
                        if (!bh.ov(aVar.sUr)) {
                            this.sRL.setText(aVar.sUr);
                            this.sRL.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.udT);
                        }
                    } else {
                        this.sRH.setUrl(this.sRu.sLT.peY);
                        this.sRI.setText(this.sRu.sLT.name);
                        this.sRL.setText(this.sRu.sLT.sNx);
                    }
                    LayoutParams layoutParams = (LayoutParams) this.sRJ.getLayoutParams();
                    if (aVar != null && !bh.ov(aVar.title)) {
                        this.sRJ.setText(aVar.title);
                        layoutParams.addRule(15, 0);
                    } else if (bh.ov(this.sRu.sLT.title)) {
                        this.sRJ.setVisibility(8);
                        layoutParams.addRule(15, -1);
                    } else {
                        this.sRJ.setText(this.sRu.sLT.title);
                        layoutParams.addRule(15, 0);
                    }
                    this.sRJ.setLayoutParams(layoutParams);
                    this.sRL.setVisibility(0);
                    this.sRL.setOnClickListener(new 3(this));
                    if (this.sRC.sLS.sNs != 1) {
                        this.sRG.setOnClickListener(new 4(this));
                    }
                    String str = this.sRD;
                    switch (str.hashCode()) {
                        case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                            if (str.equals("0")) {
                                z = false;
                                break;
                            }
                        case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                            if (str.equals("1")) {
                                z = true;
                                break;
                            }
                        case 50:
                            if (str.equals("2")) {
                                z = true;
                                break;
                            }
                        case 51:
                            if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                z = true;
                                break;
                            }
                        case 52:
                            if (str.equals("4")) {
                                z = true;
                                break;
                            }
                        case 1444:
                            if (str.equals("-1")) {
                                break;
                            }
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            this.sRL.setEnabled(false);
                            break;
                    }
                    text = this.sRI.getText();
                    if (!bh.M(text) && text.length() > 9) {
                        this.sRI.setText(text.subSequence(0, 9));
                        this.sRI.append("...");
                    }
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.sRG.getLayoutParams();
                    marginLayoutParams.topMargin = com.tencent.mm.bv.a.fromDPToPix(this, 50);
                    this.sRG.setLayoutParams(marginLayoutParams);
                } else if (!(this.sRu.sLU == null || bh.ov(this.sRu.sLU.sAb))) {
                    BindCardOrder bindCardOrder = this.sRu;
                    boolean z2 = bindCardOrder.jumpType == BindCardOrder.sLI && bindCardOrder.sLU != null;
                    if (z2) {
                        this.sRw = this.sRu.sLU.sAb;
                        this.sRx = this.sRu.sLU.sAc;
                        this.sND = this.sRu.sLU.sND;
                        this.sRy = this.sRu.sLU;
                        this.sRH.setUrl(this.sRu.sLU.sNA);
                        this.sRI.setText(this.sRu.sLU.sNB);
                        this.sRJ.setText(getString(a$i.uON));
                        this.sRJ.setVisibility(0);
                        this.sRH.vnf = true;
                        this.sRL.setEnabled(true);
                        this.sRL.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bAb);
                        LayoutParams layoutParams2 = (LayoutParams) this.sRJ.getLayoutParams();
                        layoutParams2.addRule(15, 0);
                        this.sRJ.setLayoutParams(layoutParams2);
                        if (this.sRu.sLS.sIr > 0) {
                            if (!bh.ov(this.sRu.sLU.sNC)) {
                                this.sRL.setVisibility(0);
                                this.sRL.setText(this.sRu.sLU.sNC);
                                this.sRK.setVisibility(8);
                            }
                            aVar = (WalletOrderInfoNewUI.a) this.sRA.get(this.sRu.sLS.sIr);
                            if (aVar != null) {
                                if (!bh.ov(aVar.sNA)) {
                                    this.sRH.setUrl(aVar.sNA);
                                }
                                if (!bh.ov(aVar.sNB)) {
                                    this.sRI.setText(aVar.sNB);
                                }
                                if (!bh.ov(aVar.sNC)) {
                                    this.sRL.setText(aVar.sNC);
                                    this.sRL.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.udT);
                                }
                                if (!bh.ov(aVar.sAb)) {
                                    this.sRw = aVar.sAb;
                                }
                                if (!bh.ov(aVar.sAc)) {
                                    this.sRx = aVar.sAc;
                                }
                            }
                        } else {
                            this.sRL.setVisibility(8);
                            this.sRK.setVisibility(8);
                        }
                        OnClickListener 5 = new 5(this);
                        this.sRG.setOnClickListener(5);
                        this.sRL.setOnClickListener(5);
                        text = this.sRI.getText();
                        if (!bh.M(text) && text.length() > 9) {
                            this.sRI.setText(text.subSequence(0, 9));
                            this.sRI.append("...");
                        }
                    }
                }
                this.sRG.setVisibility(0);
            }
            if (this.sRI.getVisibility() == 0) {
                this.sRI.post(new 6(this));
            }
        }
        if (this.sRG.getVisibility() == 8) {
            marginLayoutParams = (MarginLayoutParams) this.sRF.getLayoutParams();
            marginLayoutParams.topMargin = com.tencent.mm.bv.a.fromDPToPix(this, 91);
            this.sRF.setLayoutParams(marginLayoutParams);
        }
    }

    private void Nn(String str) {
        bMu();
        e.l(this, str, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            x.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
            l(new w(this.sRz.sIN, this.sRz.sUt, this.sRz.sUu, this.sRz.sUv, this.sRz.sOP, this.sRz.sUw, this.sRu.oZz, this.sRu.sLP, this.sRu.sLQ, this.sRu.sLQ));
        }
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return h.a(this.mController.xIM, getString(a$i.uTB), getResources().getStringArray(com.tencent.mm.plugin.wxpay.a.b.uau), "", new h.c(this) {
            final /* synthetic */ WalletBindCardResultUI sRR;

            {
                this.sRR = r1;
            }

            public final void jl(int i) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(this.sRR.pbR).toString()));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        this.sRR.startActivity(intent);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    protected final int getLayoutId() {
        return a$g.uEG;
    }

    public final void done() {
        Bundle bundle = new Bundle();
        if (this.sRQ != null) {
            this.sRQ.a(this, 0, bundle);
        } else {
            finish();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        done();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xef.c(this.oYB);
        jj(1979);
    }

    private void bMu() {
        int i = 0;
        if (!this.sRv) {
            com.tencent.mm.sdk.b.b inVar = new in();
            inVar.fyU.fyV = 4;
            in.a aVar = inVar.fyU;
            if (this.vf.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            aVar.bjW = i;
            com.tencent.mm.sdk.b.a.xef.m(inVar);
            this.sRv = true;
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof w) {
            if (i == 0 && i2 == 0) {
                w wVar = (w) kVar;
                WalletOrderInfoNewUI.a aVar = new WalletOrderInfoNewUI.a(wVar.orF);
                if (this.sRz != null) {
                    this.sRA.put(wVar.sIN, aVar);
                    bMt();
                    bMr();
                } else if (this.sRN) {
                    this.sRA.put(wVar.sIN, aVar);
                    bMt();
                    bMr();
                }
            }
        } else if (kVar instanceof m) {
            if (i == 0 && i2 == 0) {
                m mVar = (m) kVar;
                String str2 = mVar.sIy;
                if (this.sRC != null && this.sRC.sLS.sIr == mVar.sIA.sLS.sIr) {
                    x.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", new Object[]{this.sRC});
                    this.sRD = str2;
                    bMt();
                    bMr();
                    if (!(bh.ov(mVar.kZo) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2))) {
                        this.sRL.setText(mVar.kZo);
                    }
                }
                if (!"-1".equals(str2) && !"0".equals(str2) && !bh.ov(mVar.sIz)) {
                    h.b(this, mVar.sIz, "", true);
                } else if ("0".equals(str2)) {
                    CharSequence string;
                    if (bh.ov(mVar.sIz)) {
                        string = getString(a$i.uUr);
                    } else {
                        string = mVar.sIz;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                return true;
            }
            if (bh.ov(str)) {
                str = getString(a$i.uXa);
            }
            h.a(this, str, null, false, new 8(this));
            return true;
        }
        return false;
    }

    public final void uD(int i) {
        this.mController.contentView.setVisibility(i);
    }

    public final void gI(int i) {
        g gVar = g.pQN;
        Object[] objArr = new Object[4];
        objArr[0] = this.sRu.sLS == null ? "" : bh.az(this.sRu.sLS.sIr, "");
        objArr[1] = this.sRu.sLP;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = this.sRu.oZz;
        gVar.h(14877, objArr);
    }
}
