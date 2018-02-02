package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.c.h;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.ax;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.yk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import org.xwalk.core.R$styleable;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoNewUI extends WalletOrderInfoUI {
    private String jKk = null;
    private String mAppId = "";
    private String oWp;
    private c oYB = new c<sw>(this) {
        final /* synthetic */ WalletOrderInfoNewUI sUp;

        {
            this.sUp = r2;
            this.xen = sw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            sw swVar = (sw) bVar;
            if (!(swVar instanceof sw)) {
                return false;
            }
            if (!swVar.fLl.fLm.oXv) {
                x.i("MicroMsg.WalletOrderInfoNewUI", "block pass");
                return true;
            } else if (!"1".equals(swVar.fLl.fLm.fKP) && !"2".equals(swVar.fLl.fLm.fKP)) {
                return false;
            } else {
                Parcelable realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(swVar.fLl.fLm.fKP, swVar.fLl.fLm.fKQ, swVar.fLl.fLm.fKR, swVar.fLl.fLm.fKS, swVar.fLl.fLm.fKT, this.sUp.sEO == null ? 0 : this.sUp.sEO.fCV);
                x.i("MicroMsg.WalletOrderInfoNewUI", "receive guide");
                this.sUp.vf.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                return false;
            }
        }
    };
    private d.a.a.b pNe;
    private WalletSuccPageAwardWidget pNf;
    private ViewGroup pNk;
    private ViewGroup pNl;
    private ViewGroup pNm;
    private TextView pNn;
    private String pOF;
    private TextView pPo;
    private String pbR = null;
    private PayInfo sEO;
    private Orders sEs;
    private int sND;
    private HashMap<String, a> sRA = new HashMap();
    private String sRB;
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
    private boolean sRv = false;
    private String sRw;
    private String sRx;
    private b sRz;
    public Set<String> sTU = null;
    private List<Commodity> sTV = null;
    private RecommendTinyAppInfo sTW;
    private String sTX;
    private Promotions sTY = null;
    private TextView sTZ;
    private TextView sUa;
    private WalletTextView sUb;
    private ViewGroup sUc;
    private ViewGroup sUd;
    private ViewGroup sUe;
    private ViewGroup sUf;
    private TextView sUg;
    private CheckBox sUh;
    private ViewGroup sUi;
    private CdnImageView sUj;
    private TextView sUk;
    private TextView sUl;
    private Button sUm;
    private boolean sUn = false;
    private c sUo = new 10(this);

    static class a {
        public String fDI;
        public String fyY;
        public String sAb;
        public String sAc;
        public String sNA;
        public String sNB;
        public String sNC;
        public String sNz;
        public String sUr;
        public int sUs;
        public String title;
        public String url;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
                if (optJSONObject != null) {
                    this.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    this.fyY = optJSONObject.optString("wording");
                    this.fDI = optJSONObject.optString("icon");
                    this.sUr = optJSONObject.optString("btn_text");
                    this.title = optJSONObject.optString("title");
                    this.sNz = optJSONObject.optString("tinyapp_name");
                    this.sNA = optJSONObject.optString("tinyapp_logo");
                    this.sNB = optJSONObject.optString("tinyapp_desc");
                    this.sAb = optJSONObject.optString("tinyapp_username");
                    this.sAc = optJSONObject.optString("tinyapp_path");
                    this.sNC = optJSONObject.optString("activity_tinyapp_btn_text");
                }
            }
        }

        public a(azr com_tencent_mm_protocal_c_azr) {
            if (com_tencent_mm_protocal_c_azr != null && com_tencent_mm_protocal_c_azr.wGS != null) {
                ax axVar = com_tencent_mm_protocal_c_azr.wGS;
                this.url = axVar.url;
                this.fyY = axVar.fyY;
                this.fDI = axVar.fDI;
                this.sUr = axVar.sUr;
                this.title = axVar.title;
                this.sAb = axVar.sAb;
                this.sAc = axVar.sAc;
                this.sUs = axVar.sUs;
                this.sNz = this.title;
                this.sNA = this.fDI;
                this.sNB = this.fyY;
                this.sNC = this.sUr;
            }
        }

        public final String toString() {
            return this.url + " , " + this.fyY + " , " + this.fDI + " , " + this.sUr + " , " + this.title;
        }
    }

    static /* synthetic */ void p(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        String str = "MicroMsg.WalletOrderInfoNewUI";
        String str2 = "onClickActivity, activityId: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletOrderInfoNewUI.sTY != null ? walletOrderInfoNewUI.sTY.sIr : 0);
        x.i(str, str2, objArr);
        if (walletOrderInfoNewUI.sTY != null && walletOrderInfoNewUI.sTY.sIr > 0) {
            walletOrderInfoNewUI.sRO = true;
            if (walletOrderInfoNewUI.sRD.equals("-1") || walletOrderInfoNewUI.sRD.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                g.pQN.h(13472, new Object[]{walletOrderInfoNewUI.pOF, Integer.valueOf(walletOrderInfoNewUI.sTY.sOB), Integer.valueOf(1), Long.valueOf(walletOrderInfoNewUI.sTY.sIr), Long.valueOf(walletOrderInfoNewUI.sTY.sNw)});
                g.pQN.h(13033, new Object[]{Integer.valueOf(2), "", walletOrderInfoNewUI.sTY.url, walletOrderInfoNewUI.sTY.name, ""});
                if (!bh.ov(walletOrderInfoNewUI.sTY.sOE) && !bh.ov(walletOrderInfoNewUI.sTY.sOF)) {
                    x.i("MicroMsg.WalletOrderInfoNewUI", "promotion jump tiny app, username: %s, path: %s, version: %s", new Object[]{walletOrderInfoNewUI.sTY.sOE, walletOrderInfoNewUI.sTY.sOF, Integer.valueOf(walletOrderInfoNewUI.sTY.sOG)});
                    walletOrderInfoNewUI.sRz = new b(walletOrderInfoNewUI.sTY.sIr, walletOrderInfoNewUI.sTY.sOC, walletOrderInfoNewUI.sTY.sNu, walletOrderInfoNewUI.sTY.sNv, walletOrderInfoNewUI.bJQ(), walletOrderInfoNewUI.pOF, walletOrderInfoNewUI.sTY.sNw, walletOrderInfoNewUI.sTY.sOI);
                    b qpVar = new qp();
                    qpVar.fIi.userName = walletOrderInfoNewUI.sTY.sOE;
                    qpVar.fIi.fIk = bh.az(walletOrderInfoNewUI.sTY.sOF, "");
                    qpVar.fIi.scene = 1060;
                    qpVar.fIi.fnp = walletOrderInfoNewUI.oWp;
                    qpVar.fIi.fIl = 0;
                    if (walletOrderInfoNewUI.sTY.sOG > 0) {
                        qpVar.fIi.fIm = walletOrderInfoNewUI.sTY.sOG;
                    }
                    qpVar.fIi.context = walletOrderInfoNewUI;
                    com.tencent.mm.sdk.b.a.xef.m(qpVar);
                    g.pQN.h(14118, new Object[]{walletOrderInfoNewUI.oWp, walletOrderInfoNewUI.bJQ(), Integer.valueOf(2)});
                } else if (walletOrderInfoNewUI.sTY.sOB == 1) {
                    Promotions promotions = walletOrderInfoNewUI.sTY;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "doSceneSendPayAward, getAwardParams==null: %s", new Object[]{Boolean.valueOf(bh.ov(promotions.sOH))});
                    if (bh.ov(promotions.sOH)) {
                        walletOrderInfoNewUI.r(new n(promotions, walletOrderInfoNewUI.bJQ(), walletOrderInfoNewUI.oWp, promotions.sNw));
                    } else {
                        walletOrderInfoNewUI.r(new h(promotions.sOH, promotions.sIr));
                    }
                } else if (walletOrderInfoNewUI.sTY.sOB != 2 || bh.ov(walletOrderInfoNewUI.sTY.url)) {
                    x.e("MicroMsg.WalletOrderInfoNewUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                } else if (walletOrderInfoNewUI.sRA.containsKey(walletOrderInfoNewUI.sTY.sIr)) {
                    a aVar = (a) walletOrderInfoNewUI.sRA.get(walletOrderInfoNewUI.sTY.sIr);
                    x.i("MicroMsg.WalletOrderInfoNewUI", "go to new url %s", new Object[]{aVar.url});
                    if (bh.ov(aVar.url)) {
                        walletOrderInfoNewUI.Nn(walletOrderInfoNewUI.sTY.url);
                    } else {
                        walletOrderInfoNewUI.Nn(aVar.url);
                    }
                } else {
                    walletOrderInfoNewUI.sRB = walletOrderInfoNewUI.sTY.url;
                    String str3 = walletOrderInfoNewUI.sTY.url;
                    b bVar = new b(walletOrderInfoNewUI.sTY.sIr, walletOrderInfoNewUI.sTY.sOC, walletOrderInfoNewUI.sTY.sNu, walletOrderInfoNewUI.sTY.sNv, walletOrderInfoNewUI.bJQ(), walletOrderInfoNewUI.pOF, walletOrderInfoNewUI.sTY.sNw, walletOrderInfoNewUI.sTY.sOI);
                    x.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[]{str3});
                    walletOrderInfoNewUI.bMu();
                    walletOrderInfoNewUI.sRz = bVar;
                    e.r(walletOrderInfoNewUI, str3, 1);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
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
        this.sTU = new HashSet();
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        this.sEO = (PayInfo) this.vf.getParcelable("key_pay_info");
        this.oWp = this.vf.getString("key_trans_id");
        this.vf.getInt("key_pay_type", -1);
        x.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[]{this.oWp});
        this.sEs = bMF();
        if (this.sEs != null) {
            uD(0);
            b(this.sEs);
            if (!(ag == null || this.sEs == null || this.sEO == null)) {
                int i2;
                boolean z;
                int i3;
                this.mAppId = this.sEO.appId;
                boolean cBk = ag.cBk();
                com.tencent.mm.plugin.wallet_core.e.c.b(this, this.vf, 7);
                if (this.vf.getInt("key_support_bankcard", 1) == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                g gVar = g.pQN;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.sEO.fCV);
                if (this.sEO.fCV == 3) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                if (cBk) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                objArr[2] = Integer.valueOf(i3);
                objArr[3] = Integer.valueOf(p.cBx());
                objArr[4] = Integer.valueOf((int) (this.sEs.pNX * 100.0d));
                objArr[5] = this.sEs.paz;
                objArr[6] = Integer.valueOf(i2);
                gVar.h(10691, objArr);
            }
            if (!((o.bLq().bLM() || ag == null || !ag.cBk()) && q.Gb())) {
                q.Gc();
            }
            if (this.sEs == null || this.sEs.sNW == null || this.sEs.sNW.size() <= 0) {
                x.k("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
                com.tencent.mm.ui.base.h.a(this.mController.xIM, i.uTp, 0, new 15(this));
            } else {
                this.sTV = this.sEs.sNW;
                x.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[]{Integer.valueOf(this.sTV.size())});
                this.oWp = ((Commodity) this.sTV.get(0)).fuI;
                this.pOF = ((Commodity) this.sTV.get(0)).fuI;
                if (!(this.sEO == null || ag == null || (!ag.cBj() && !ag.cBk()))) {
                    l(new com.tencent.mm.plugin.wallet_core.c.x(bJQ(), 21));
                }
            }
            if (this.oWp == null) {
                boolean booleanValue;
                Object obj = com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xoL, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (booleanValue) {
                    x.i("MicroMsg.WalletOrderInfoNewUI", "has show the finger print auth guide!");
                } else {
                    com.tencent.mm.wallet_core.c ag2 = com.tencent.mm.wallet_core.a.ag(this);
                    Bundle bundle2 = new Bundle();
                    if (ag2 != null) {
                        bundle2 = ag2.msB;
                    }
                    if (TextUtils.isEmpty(bundle2.getString("key_pwd1"))) {
                        x.i("MicroMsg.WalletOrderInfoNewUI", "pwd is empty, not show the finger print auth guide!");
                    } else if (ag2 != null) {
                        ag2.a((Activity) this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle2);
                    }
                }
            }
        } else {
            x.k("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
            com.tencent.mm.ui.base.h.a(this.mController.xIM, i.uTp, 0, new 16(this));
        }
        initView();
        this.sRQ = cCc();
        bMs();
        ji(1979);
        ji(2948);
        ji(2710);
        com.tencent.mm.sdk.b.a.xef.b(this.sUo);
        com.tencent.mm.sdk.b.a.xef.b(this.oYB);
        this.sRP = true;
        if (this.sEO != null) {
            i = this.sEO.fCV;
        }
        t.d(i, this.sEO == null ? "" : this.sEO.fuH, 16, "");
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", new Object[]{Boolean.valueOf(this.sRP), this.sTY, Boolean.valueOf(this.sRN), Boolean.valueOf(this.sRO), this.sTW, this.pNe});
        if (WalletSuccPageAwardWidget.a(this.pNe)) {
            this.pNf.onResume();
        } else if (this.sRP) {
            this.sRP = false;
        } else if (this.sTY != null && this.sRO) {
            x.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s, isCallQueryPayAward: %s", new Object[]{Boolean.valueOf(bh.ov(this.sTY.sOI)), Boolean.valueOf(this.sUn)});
            if (!this.sUn) {
                this.sUn = true;
                if (bh.ov(this.sTY.sOI)) {
                    l(new z(this.sTY.sIr, this.sTY.sOC, this.sTY.sNu, this.sTY.sNv, bJQ(), this.pOF, this.sTY.sNw));
                } else {
                    l(new k(this.sTY.sOI, this.sTY.sIr));
                }
            }
        } else if (this.sRN && this.sTW != null) {
            l(new z(this.sTW.sOK, this.sTW.sOM, this.sTW.sON, this.sTW.sOO, bJQ(), this.pOF, this.sTW.sOP));
        }
    }

    protected final void initView() {
        Commodity commodity;
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.sRF = (ImageView) findViewById(f.uAN);
        this.pPo = (TextView) findViewById(f.usS);
        this.sTZ = (TextView) findViewById(f.ufR);
        this.sUa = (TextView) findViewById(f.ukv);
        this.sUb = (WalletTextView) findViewById(f.uxl);
        this.pNn = (TextView) findViewById(f.usL);
        this.sRE = (Button) findViewById(f.usP);
        showHomeBtn(false);
        enableBackMenu(false);
        CharSequence string = getString(i.dFl);
        if (this.sEO == null || this.sEO.fCV != 2) {
            if (!(this.sEs == null || bh.ov(this.sEs.sOh))) {
                string = this.sEs.sOh;
            }
        } else if (this.sEs != null && !bh.ov(this.sEs.sOh)) {
            string = this.sEs.sOh;
        } else if (!bh.ov(this.sEO.tan)) {
            string = getString(i.dDO) + this.sEO.tan;
        } else if (!(bh.ov(this.sEO.appId) || bh.ov(com.tencent.mm.pluginsdk.model.app.g.l(this, this.sEO.appId)))) {
            string = getString(i.dDO) + com.tencent.mm.pluginsdk.model.app.g.l(this, this.sEO.appId);
        }
        this.sRE.setText(string);
        this.sRE.setOnClickListener(new 12(this));
        this.sUc = (ViewGroup) findViewById(f.ujC);
        this.pNl = (ViewGroup) findViewById(f.ujB);
        this.sRM = (ViewGroup) findViewById(f.uzi);
        this.pNk = (ViewGroup) findViewById(f.ujD);
        this.pNm = (ViewGroup) findViewById(f.usM);
        this.sUd = (ViewGroup) findViewById(f.ulS);
        this.sUe = (ViewGroup) findViewById(f.ujE);
        this.sRG = (ViewGroup) findViewById(f.uwX);
        this.sRH = (CdnImageView) findViewById(f.uwZ);
        this.sRH.vng = true;
        this.sRI = (TextView) findViewById(f.uwW);
        this.sRJ = (TextView) findViewById(f.uxb);
        this.sRL = (Button) findViewById(f.uwU);
        this.sRK = findViewById(f.uwY);
        this.sUf = (ViewGroup) findViewById(f.uwD);
        this.sUg = (TextView) findViewById(f.ufO);
        this.sUh = (CheckBox) findViewById(f.uwC);
        this.sUi = (ViewGroup) findViewById(f.uen);
        this.sUj = (CdnImageView) findViewById(f.ueo);
        this.sUj.vng = true;
        this.sUl = (TextView) findViewById(f.uep);
        this.sUk = (TextView) findViewById(f.uem);
        this.sUm = (Button) findViewById(f.uel);
        this.sRM.setVisibility(4);
        this.pNf = (WalletSuccPageAwardWidget) findViewById(f.ueI);
        bMs();
        if (!(this.sEs == null || this.sTV == null || this.sTV.size() <= 0)) {
            Commodity commodity2 = (Commodity) this.sTV.get(0);
            this.sTZ.setText(commodity2.pao);
            this.sUa.setText(e.aax(commodity2.paz));
            this.sUb.setText(String.format("%.2f", new Object[]{Double.valueOf(commodity2.ljg)}));
        }
        bMC();
        bMD();
        this.sUe.setVisibility(8);
        this.sUd.setVisibility(8);
        if (!(this.sEs == null || this.sTV == null || this.sTV.size() <= 0)) {
            commodity2 = (Commodity) this.sTV.get(0);
            if (!bh.ov(commodity2.sOq)) {
                ((TextView) findViewById(f.ulT)).setText(commodity2.sOq);
                this.sUd.setVisibility(0);
                this.sUc.setVisibility(0);
            }
            if (!bh.ov(commodity2.sOo)) {
                ((TextView) findViewById(f.ujF)).setText(commodity2.sOo);
                this.sUe.setVisibility(0);
                this.sUc.setVisibility(0);
            }
        }
        if (this.sTV == null || this.sTV.size() <= 0) {
            commodity = null;
        } else {
            commodity2 = (Commodity) this.sTV.get(0);
            if (!(commodity2 == null || commodity2.sOs == null || commodity2.sOs.size() <= 0)) {
                for (Promotions promotions : commodity2.sOs) {
                    if (promotions.sOJ != null && promotions.sOB == 5) {
                        this.pNe = promotions.sOJ;
                        x.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", new Object[]{this.pNe, Integer.valueOf(promotions.sOB)});
                        commodity = commodity2;
                        break;
                    }
                }
            }
            commodity = commodity2;
        }
        if (WalletSuccPageAwardWidget.a(this.pNe)) {
            if (commodity != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.pNf.getLayoutParams();
                List list = commodity.sOn;
                if ((commodity.sOk < 0.0d || commodity.ljg >= commodity.sOk) && (list == null || list.size() <= 0)) {
                    marginLayoutParams.topMargin = com.tencent.mm.bv.a.fromDPToPix(this, 50);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
                this.pNf.setLayoutParams(marginLayoutParams);
            }
            this.pNf.a(this, this.pNe, this.oWp, false, (ImageView) findViewById(f.background));
            this.pNf.init();
            this.pNf.setVisibility(0);
            final ImageView imageView = (ImageView) findViewById(f.background);
            imageView.post(new Runnable(this) {
                final /* synthetic */ WalletOrderInfoNewUI sUp;

                public final void run() {
                    ViewGroup viewGroup = (ViewGroup) this.sUp.findViewById(f.uwk);
                    LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = viewGroup.getWidth();
                    layoutParams.height = viewGroup.getHeight();
                    imageView.setLayoutParams(layoutParams);
                }
            });
        } else {
            jN(true);
            this.pNf.setVisibility(8);
        }
        bMr();
    }

    private void bMr() {
        int i;
        int i2 = 0;
        if (this.sRG.getVisibility() == 0) {
            i2 = 1;
        }
        if (this.sUc.getVisibility() == 0) {
            i2++;
        }
        if (this.sUf.getVisibility() == 0) {
            i2++;
        }
        if (this.sUi.getVisibility() == 0) {
            i = i2 + 1;
        } else {
            i = i2;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.sRF.getLayoutParams();
        MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) this.sTZ.getLayoutParams();
        if (i >= 3) {
            i = com.tencent.mm.bv.a.fromDPToPix(this, 40);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        } else {
            i = com.tencent.mm.bv.a.fromDPToPix(this, 70);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        }
        this.sRF.setLayoutParams(marginLayoutParams);
        this.sTZ.setLayoutParams(marginLayoutParams2);
        this.sRM.post(new 14(this));
    }

    private void bMs() {
        if (this.sEs != null && this.sTV != null && this.sTV.size() > 0) {
            int i;
            for (Commodity commodity : this.sTV) {
                if ("1".equals(commodity.pas)) {
                    i = 0;
                    break;
                }
            }
            i = 1;
            this.pPo.setVisibility(0);
            if (i == 0) {
                this.pPo.setText(i.uTF);
            } else if (!bh.ov(this.sEs.sNP) && !bh.ov(this.sEs.sNP.trim())) {
                this.pPo.setText(this.sEs.sNP);
            } else if (this.sEs.sIJ != 1) {
                this.pPo.setText(i.uTE);
            } else {
                this.pPo.setText(i.uTD);
            }
        }
    }

    private void bMC() {
        this.sUc.setVisibility(8);
        this.pNl.setVisibility(8);
        this.pNk.setVisibility(8);
        this.pNm.setVisibility(8);
        if (this.sEs != null && this.sTV != null && this.sTV.size() > 0) {
            Commodity commodity = (Commodity) this.sTV.get(0);
            List list = commodity.sOn;
            String str = "MicroMsg.WalletOrderInfoNewUI";
            String str2 = "discountInfoList: %s, size: %s";
            Object[] objArr = new Object[2];
            objArr[0] = list;
            objArr[1] = Integer.valueOf(list != null ? list.size() : 0);
            x.i(str, str2, objArr);
            if (list != null && list.size() > 0) {
                this.pNl.removeAllViews();
                for (int i = 0; i < list.size(); i++) {
                    DiscountInfo discountInfo = (DiscountInfo) list.get(i);
                    View textView = new TextView(this.mController.xIM);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    textView.setTextSize(1, 12.0f);
                    textView.setTextColor(Color.parseColor("#FA962A"));
                    if (discountInfo.sOz > 0.0d) {
                        textView.setText(discountInfo.pKc + e.d(discountInfo.sOz / 100.0d, this.sEs.paz));
                    } else {
                        textView.setText(discountInfo.pKc);
                    }
                    this.pNl.addView(textView);
                }
                this.pNl.setVisibility(0);
                this.sUc.setVisibility(0);
                this.pNk.setVisibility(0);
            }
            if (commodity.sOk >= 0.0d && commodity.ljg < commodity.sOk) {
                this.pNn.setText(e.d(commodity.sOk, commodity.paz));
                this.pNn.getPaint().setFlags(16);
                this.pNm.setVisibility(0);
                this.sUc.setVisibility(0);
            }
        }
    }

    private void bMD() {
        this.sUf.setVisibility(8);
        if (this.sEs != null) {
            b(this.sEs);
            if (this.sTV != null && this.sTV.size() > 0) {
                Commodity commodity = (Commodity) this.sTV.get(0);
                x.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[]{Boolean.valueOf(commodity.sOt)});
                if (commodity.sOt && commodity.sOs != null && commodity.sOs.size() > 0) {
                    for (Promotions promotions : commodity.sOs) {
                        if (promotions.type == Orders.sOi) {
                            break;
                        }
                    }
                    Promotions promotions2 = null;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[]{promotions2});
                    if (promotions2 != null && !bh.ov(promotions2.paA)) {
                        this.pOF = commodity.fuI;
                        g.pQN.h(13033, new Object[]{Integer.valueOf(1), promotions2.paA, promotions2.url, promotions2.name, this.pOF});
                        this.sUg.setText(promotions2.name);
                        this.sTX = promotions2.paA;
                        this.sUh.setVisibility(0);
                        if (this.sTU.contains(promotions2.paA)) {
                            this.sUh.setChecked(true);
                        } else {
                            this.sUh.setChecked(false);
                        }
                        this.sUf.setOnClickListener(new 17(this));
                        this.sUf.setVisibility(0);
                    }
                }
            }
        }
    }

    private void jN(boolean z) {
        this.sRG.setVisibility(8);
        this.sRO = false;
        this.sRN = false;
        if (this.sEs != null) {
            if (this.sTV != null && this.sTV.size() > 0) {
                Commodity commodity = (Commodity) this.sTV.get(0);
                if (commodity != null) {
                    Promotions promotions;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[]{Boolean.valueOf(commodity.sOt)});
                    if (commodity.sOs != null && commodity.sOs.size() > 0) {
                        for (Promotions promotions2 : commodity.sOs) {
                            if (promotions2.type == Orders.sOj) {
                                promotions = promotions2;
                                break;
                            }
                        }
                    }
                    promotions = null;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[]{promotions});
                    a aVar;
                    MarginLayoutParams marginLayoutParams;
                    List list;
                    if (promotions != null && promotions.sIr > 0 && !bh.ov(promotions.sNx)) {
                        this.sTY = promotions;
                        this.sRK.setVisibility(8);
                        this.sRH.vnf = true;
                        this.sRL.setEnabled(true);
                        this.sRL.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bAb);
                        this.sRJ.setCompoundDrawables(null, null, null, null);
                        aVar = (a) this.sRA.get(promotions.sIr);
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
                            if (!bh.ov(aVar.sAb)) {
                                this.sTY.sOE = aVar.sAb;
                            }
                            if (!bh.ov(aVar.sAc)) {
                                this.sTY.sOF = aVar.sAc;
                            }
                            if (aVar.sUs > 0) {
                                this.sTY.sOG = aVar.sUs;
                            }
                        } else {
                            this.sRH.setUrl(promotions.peY);
                            this.sRI.setText(promotions.name);
                            this.sRL.setText(promotions.sNx);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.sRJ.getLayoutParams();
                        if (aVar != null && !bh.ov(aVar.title)) {
                            this.sRJ.setText(aVar.title);
                            layoutParams.addRule(15, 0);
                        } else if (bh.ov(promotions.title)) {
                            this.sRJ.setVisibility(8);
                            layoutParams.addRule(15, -1);
                        } else {
                            this.sRJ.setText(promotions.title);
                            layoutParams.addRule(15, 0);
                        }
                        this.sRJ.setLayoutParams(layoutParams);
                        this.sRL.setVisibility(0);
                        this.sRL.setOnClickListener(new 2(this));
                        if (promotions.sOB != 1) {
                            this.sRG.setOnClickListener(new 3(this));
                        }
                        String str = this.sRD;
                        boolean z2 = true;
                        switch (str.hashCode()) {
                            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                                if (str.equals("0")) {
                                    z2 = false;
                                    break;
                                }
                                break;
                            case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                                if (str.equals("1")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 50:
                                if (str.equals("2")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 51:
                                if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 52:
                                if (str.equals("4")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 1444:
                                if (str.equals("-1")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                        }
                        switch (z2) {
                            case false:
                                this.sRL.setEnabled(false);
                                break;
                        }
                        marginLayoutParams = (MarginLayoutParams) this.sRG.getLayoutParams();
                        list = commodity.sOn;
                        if ((commodity.sOk < 0.0d || commodity.ljg >= commodity.sOk) && (list == null || list.size() <= 0)) {
                            marginLayoutParams.topMargin = com.tencent.mm.bv.a.fromDPToPix(this, 50);
                        } else {
                            marginLayoutParams.topMargin = 0;
                        }
                        this.sRG.setLayoutParams(marginLayoutParams);
                        this.sRG.setVisibility(0);
                        if (z) {
                            g gVar = g.pQN;
                            Object[] objArr = new Object[6];
                            objArr[0] = this.pOF;
                            objArr[1] = Integer.valueOf(1);
                            objArr[2] = Integer.valueOf(promotions.sOB);
                            objArr[3] = this.sRD.equals("-1") ? Integer.valueOf(5) : this.sRD;
                            objArr[4] = Long.valueOf(promotions.sIr);
                            objArr[5] = Long.valueOf(promotions.sNw);
                            gVar.h(13471, objArr);
                        }
                    } else if (!(commodity.sOr == null || bh.ov(commodity.sOr.sAb))) {
                        this.sRw = commodity.sOr.sAb;
                        this.sRx = commodity.sOr.sAc;
                        this.sND = commodity.sOr.sND;
                        this.sTW = commodity.sOr;
                        this.sRH.setUrl(commodity.sOr.sNA);
                        this.sRI.setText(commodity.sOr.sNB);
                        this.sRJ.setText(getString(i.uON));
                        this.sRJ.setVisibility(0);
                        this.sRH.vnf = true;
                        this.sRL.setEnabled(true);
                        this.sRL.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bAb);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.sRJ.getLayoutParams();
                        layoutParams2.addRule(15, 0);
                        this.sRJ.setLayoutParams(layoutParams2);
                        if (commodity.sOr.sOK > 0) {
                            if (!bh.ov(commodity.sOr.sNC)) {
                                this.sRL.setVisibility(0);
                                this.sRL.setText(commodity.sOr.sNC);
                                this.sRK.setVisibility(8);
                            }
                            aVar = (a) this.sRA.get(commodity.sOr.sOK);
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
                                if (aVar.sUs > 0) {
                                    this.sND = aVar.sUs;
                                }
                            }
                        } else {
                            this.sRL.setVisibility(8);
                            this.sRK.setVisibility(8);
                        }
                        OnClickListener 4 = new 4(this, commodity);
                        this.sRG.setOnClickListener(4);
                        this.sRL.setOnClickListener(4);
                        marginLayoutParams = (MarginLayoutParams) this.sRG.getLayoutParams();
                        list = commodity.sOn;
                        if ((commodity.sOk < 0.0d || commodity.ljg >= commodity.sOk) && (list == null || list.size() <= 0)) {
                            marginLayoutParams.topMargin = com.tencent.mm.bv.a.fromDPToPix(this, 50);
                        } else {
                            marginLayoutParams.topMargin = 0;
                        }
                        this.sRG.setLayoutParams(marginLayoutParams);
                        this.sRG.setVisibility(0);
                    }
                }
            }
            if (this.sRI.getVisibility() == 0) {
                this.sRI.post(new 5(this));
                if (this.sRL.getVisibility() == 0) {
                    CharSequence text = this.sRI.getText();
                    if (!bh.M(text) && text.length() > 9) {
                        this.sRI.setText(text.subSequence(0, 9));
                        this.sRI.append("...");
                        return;
                    }
                    return;
                }
                this.sRI.setEllipsize(TruncateAt.END);
            }
        }
    }

    private void Nn(String str) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", new Object[]{str});
        bMu();
        e.l(this, str, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            x.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", new Object[]{Boolean.valueOf(bh.ov(this.sRz.sUx)), Boolean.valueOf(this.sUn)});
            if (!this.sUn) {
                this.sUn = true;
                if (bh.ov(this.sRz.sUx)) {
                    l(new z(this.sRz.sIN, this.sRz.sUt, this.sRz.sUu, this.sRz.sUv, this.sRz.fwY, this.sRz.pLr, this.sRz.sOP));
                } else {
                    l(new k(this.sRz.sUx, this.sRz.sIN));
                }
            }
        }
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(i.uTB), getResources().getStringArray(com.tencent.mm.plugin.wxpay.a.b.uau), "", new 6(this));
    }

    protected final boolean boa() {
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uFz;
    }

    private void b(Orders orders) {
        this.sTU.clear();
        if (orders == null || orders.sNW == null) {
            x.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
            return;
        }
        for (Commodity commodity : orders.sNW) {
            if (commodity.sNN == 2 && !bh.ov(commodity.sOl)) {
                x.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
                this.sTU.add(commodity.sOl);
            }
        }
    }

    public void done() {
        if (this.vf.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.vf.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoNewUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b = realnameGuideHelper.b(this, bundle, new 7(this));
                boolean a = realnameGuideHelper.a(this, bundle, new 8(this));
                this.vf.remove("key_realname_guide_helper");
                if (!b && !a) {
                    bME();
                    return;
                }
                return;
            }
            return;
        }
        bME();
    }

    public final void bME() {
        bMu();
        b alVar = new al();
        alVar.fox.foy = true;
        com.tencent.mm.sdk.b.a.xef.m(alVar);
        alVar = new gi();
        alVar.fwu.fwv = "ok";
        com.tencent.mm.sdk.b.a.xef.m(alVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.vf.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.vf.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.vf.getBoolean("intent_pay_end"));
        x.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + this.vf.getInt("intent_pay_end_errcode"));
        for (String str : this.sTU) {
            if (!bh.ov(str)) {
                x.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str});
                if (this.sEs == null || this.sEO == null) {
                    com.tencent.mm.kernel.g.Di().gPJ.a(new com.tencent.mm.wallet_core.c.i(str), 0);
                } else {
                    com.tencent.mm.kernel.g.Di().gPJ.a(new com.tencent.mm.wallet_core.c.i(str, this.sEs.fuH, this.sEs.sNW.size() > 0 ? ((Commodity) this.sEs.sNW.get(0)).fuI : "", this.sEO.fCV, this.sEO.fCR, this.sEs.sNN), 0);
                }
            }
            g.pQN.h(13033, new Object[]{Integer.valueOf(2), str, "", "", ""});
        }
        if (this.sRQ != null) {
            this.sRQ.a((Activity) this, 0, bundle);
        }
        if (this.sEs != null && !bh.ov(this.sEs.lOX)) {
            String d = d(this.sEs.lOX, this.sEs.fuH, this.sEs.sNW.size() > 0 ? ((Commodity) this.sEs.sNW.get(0)).fuI : "", this.sEO.kKe, this.sEO.iIj);
            x.d("MicroMsg.WalletOrderInfoNewUI", "url = " + d);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", d);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", q.FS());
            intent.putExtra("stastic_scene", 8);
            com.tencent.mm.bm.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
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
        com.tencent.mm.sdk.b.a.xef.c(this.sUo);
        com.tencent.mm.sdk.b.a.xef.c(this.oYB);
        jj(1979);
        jj(2948);
        jj(2710);
        if (WalletSuccPageAwardWidget.a(this.pNe)) {
            this.pNf.onDestroy();
        }
    }

    private void bMu() {
        int i = 0;
        if (!this.sRv) {
            b inVar = new in();
            inVar.fyU.fyV = 4;
            com.tencent.mm.g.a.in.a aVar = inVar.fyU;
            if (this.vf.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            aVar.bjW = i;
            com.tencent.mm.sdk.b.a.xef.m(inVar);
            this.sRv = true;
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), kVar});
        if (WalletSuccPageAwardWidget.a(this.pNe) && this.pNf.d(i, i2, str, kVar)) {
            return true;
        }
        if (kVar instanceof z) {
            if (i == 0 && i2 == 0) {
                z zVar = (z) kVar;
                a aVar = new a(zVar.orF);
                if (this.sRz != null) {
                    this.sRA.put(zVar.sIN, aVar);
                    jN(false);
                    bMr();
                } else if (this.sRN) {
                    this.sRA.put(zVar.sIN, aVar);
                    jN(false);
                    bMr();
                }
            }
            this.sUn = false;
        } else if (kVar instanceof k) {
            if (i == 0 && i2 == 0) {
                k kVar2 = (k) kVar;
                azr com_tencent_mm_protocal_c_azr = kVar2.sIx;
                if (com_tencent_mm_protocal_c_azr.kLO == 0) {
                    a aVar2 = new a(com_tencent_mm_protocal_c_azr);
                    if (this.sRz != null) {
                        this.sRA.put(kVar2.rVK, aVar2);
                        jN(false);
                        bMr();
                    } else if (this.sRN) {
                        this.sRA.put(kVar2.rVK, aVar2);
                        jN(false);
                        bMr();
                    }
                }
            }
            this.sUn = false;
        } else if (kVar instanceof n) {
            if (i == 0 && i2 == 0) {
                n nVar = (n) kVar;
                String str2 = nVar.sIy;
                if (this.sTY != null && this.sTY.sIr == nVar.sIB.sIr) {
                    x.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[]{this.sTY});
                    this.sRD = str2;
                    x.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[]{nVar.sIB.sNx});
                    jN(false);
                    bMr();
                    if (!(bh.ov(nVar.kZo) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2))) {
                        this.sRL.setText(nVar.kZo);
                    }
                }
                if (!"-1".equals(str2) && !"0".equals(str2) && !bh.ov(nVar.sIz)) {
                    com.tencent.mm.ui.base.h.b(this, nVar.sIz, "", true);
                } else if ("0".equals(str2)) {
                    if (bh.ov(nVar.sIz)) {
                        r0 = getString(i.uUr);
                    } else {
                        r0 = nVar.sIz;
                    }
                    Toast.makeText(this, r0, 0).show();
                }
                return true;
            }
            if (bh.ov(str)) {
                str = getString(i.uXa);
            }
            com.tencent.mm.ui.base.h.a(this, str, null, false, new 9(this));
            return true;
        } else if (kVar instanceof h) {
            if (i == 0 && i2 == 0) {
                h hVar = (h) kVar;
                yk ykVar = hVar.sIq;
                if (ykVar.kLO == 0) {
                    String str3 = ykVar.wiE;
                    if (this.sTY != null && this.sTY.sIr == hVar.sIr) {
                        x.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[]{this.sTY});
                        this.sRD = str3;
                        x.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[]{ykVar.wiG});
                        jN(false);
                        bMr();
                        if (!(bh.ov(ykVar.wiG) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str3))) {
                            this.sRL.setText(ykVar.wiG);
                        }
                    }
                    if (!"-1".equals(str3) && !"0".equals(str3) && !bh.ov(ykVar.wiF)) {
                        com.tencent.mm.ui.base.h.b(this, ykVar.wiF, "", true);
                    } else if ("0".equals(str3)) {
                        if (bh.ov(ykVar.wiF)) {
                            r0 = getString(i.uUr);
                        } else {
                            r0 = ykVar.wiF;
                        }
                        Toast.makeText(this, r0, 0).show();
                    }
                }
                return true;
            }
            if (bh.ov(str)) {
                str = getString(i.uXa);
            }
            com.tencent.mm.ui.base.h.a(this, str, null, false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletOrderInfoNewUI sUp;

                {
                    this.sUp = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        }
        return false;
    }

    public final void uD(int i) {
        this.mController.contentView.setVisibility(i);
    }
}
