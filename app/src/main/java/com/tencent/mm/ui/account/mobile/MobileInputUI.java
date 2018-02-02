package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.MMKeyboardUperView;
import com.tencent.mm.ui.account.ResizeLayout;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.g;

public class MobileInputUI extends MMActivity {
    protected String countryCode = null;
    protected String hEx = null;
    protected int hgg;
    private g jLx;
    protected EditText lTk;
    protected int[] nZZ = new int[5];
    protected String pRQ;
    protected String phQ = null;
    protected TextView rYg;
    private c xNR = new 1(this);
    private ResizeLayout xOH;
    protected Button xOw;
    protected Button xOx;
    private View xOy;
    protected Button xOz;
    protected MMFormInputView xPC;
    protected boolean xPG;
    private MMKeyboardUperView xPH;
    protected boolean xPI = false;
    protected CheckBox xPW;
    protected r xPh;
    protected LinearLayout xQd;
    protected TextView xQe;
    protected String xQh = null;
    protected boolean xQi = true;
    protected TextView xQm;
    protected Button xQn;
    protected Button xQo;
    protected MMFormInputView xTX;
    protected EditText xTY;
    protected MMFormVerifyCodeInputView xTZ;
    protected View xUa;
    protected TextView xUb;
    protected TextView xUc;
    protected Button xUd;
    protected String xUe = null;
    private int xUf = 0;
    private b xUg;
    protected boolean xUh;

    static /* synthetic */ boolean a(MobileInputUI mobileInputUI, String str) {
        return str != null && str.length() > 0 && mobileInputUI.xQi && (!mobileInputUI.cox() || mobileInputUI.xPW.isChecked());
    }

    static /* synthetic */ boolean f(MobileInputUI mobileInputUI) {
        if (mobileInputUI.xUf != -1) {
            if (mobileInputUI.cox() && !mobileInputUI.xPW.isChecked()) {
                return false;
            }
            mobileInputUI.coy();
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dom;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xUf = getIntent().getIntExtra("mobile_input_purpose", 0);
        this.hgg = getIntent().getIntExtra("mobile_auth_type", 0);
        this.xUh = getIntent().getBooleanExtra("can_finish", false);
        setBackBtn(new 11(this), R.k.dvO);
        switch (this.xUf) {
            case -1:
                this.xUg = new e();
                break;
            case 1:
                if (!bh.ov(getIntent().getStringExtra("auth_ticket"))) {
                    this.xUg = new e();
                    break;
                }
                int[] intArrayExtra = getIntent().getIntArrayExtra("kv_report_login_method_data");
                if (intArrayExtra != null) {
                    this.nZZ = intArrayExtra;
                }
                this.xUg = new c();
                setBackBtn(new 12(this), R.k.duV);
                overridePendingTransition(R.a.bpQ, R.a.bpQ);
                break;
            case 2:
                this.xUg = new d();
                break;
            case 3:
                this.xUg = new b();
                break;
            case 4:
                this.xUg = new d();
                break;
            default:
                x.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[]{Integer.valueOf(this.xUf)});
                finish();
                return;
        }
        this.countryCode = ao.Vl(bh.az(getIntent().getStringExtra("input_country_code"), ""));
        this.hEx = bh.az(getIntent().getStringExtra("country_name"), "");
        this.xQh = bh.az(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.xUe = ao.Vm(this.countryCode);
        this.phQ = bh.az(getIntent().getStringExtra("input_mobile_number"), "");
        this.pRQ = b.Xn();
        initView();
        this.xPI = getIntent().getBooleanExtra("from_deep_link", false);
        if (!(!this.xPI || bh.ov(this.xUe) || bh.ov(this.phQ))) {
            this.xTX.setText(this.phQ);
        }
        this.xUg.a(this);
        this.xPG = getIntent().getBooleanExtra("from_switch_account", false);
    }

    public void onResume() {
        a.xef.b(this.xNR);
        super.onResume();
        this.xUg.start();
        showVKB();
    }

    public void onPause() {
        super.onPause();
        a.xef.c(this.xNR);
        this.xUg.stop();
    }

    public void finish() {
        super.finish();
        if (this.xUf == 1) {
            overridePendingTransition(R.a.bpQ, R.a.bpQ);
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(14262, new Object[]{Integer.valueOf(this.nZZ[0]), Integer.valueOf(this.nZZ[1]), Integer.valueOf(this.nZZ[2]), Integer.valueOf(this.nZZ[3]), Integer.valueOf(this.nZZ[4])});
    }

    public void onDestroy() {
        this.xTZ.reset();
        super.onDestroy();
    }

    private boolean cox() {
        return this.xUf == 2;
    }

    protected final void initView() {
        this.xPC = (MMFormInputView) findViewById(R.h.cLM);
        this.lTk = this.xPC.pqM;
        com.tencent.mm.ui.tools.a.c.d(this.lTk).GN(16).a(null);
        this.xTX = (MMFormInputView) findViewById(R.h.cwJ);
        this.xTX.setInputType(3);
        this.xTY = this.xTX.pqM;
        this.xTZ = (MMFormVerifyCodeInputView) findViewById(R.h.cOQ);
        this.xTZ.cpa();
        this.xQd = (LinearLayout) findViewById(R.h.bZd);
        this.xQe = (TextView) findViewById(R.h.bZf);
        this.xUa = findViewById(R.h.cHh);
        this.xPW = (CheckBox) findViewById(R.h.bJD);
        this.xQm = (TextView) findViewById(R.h.bJE);
        this.xQn = (Button) findViewById(R.h.bJC);
        this.xQo = (Button) findViewById(R.h.cAg);
        this.xUb = (TextView) findViewById(R.h.cHx);
        this.xUc = (TextView) findViewById(R.h.cuu);
        this.rYg = (TextView) findViewById(R.h.cwI);
        this.xUd = (Button) findViewById(R.h.cuk);
        this.xOw = (Button) findViewById(R.h.cun);
        this.xOx = (Button) findViewById(R.h.cuo);
        this.xOy = findViewById(R.h.cjf);
        this.xOz = (Button) findViewById(R.h.cup);
        this.xOH = (ResizeLayout) findViewById(R.h.cHL);
        this.xPH = (MMKeyboardUperView) findViewById(R.h.scrollView);
        this.xQd.setVisibility(8);
        this.xPC.setVisibility(8);
        this.xTZ.setVisibility(8);
        this.xTX.setVisibility(8);
        this.xUb.setVisibility(8);
        this.xUc.setVisibility(8);
        this.xQo.setVisibility(8);
        this.xUa.setVisibility(8);
        this.xUd.setVisibility(8);
        this.xPW.setVisibility(8);
        this.xPW.setChecked(true);
        this.xOH.xSs = new 13(this);
        this.xPH.setOnTouchListener(new 14(this));
        this.xOw.setOnClickListener(new 15(this));
        this.xOx.setOnClickListener(new 16(this));
        this.jLx = new g(this, g.ztp, false);
        this.jLx.rKC = new p.c(this) {
            final /* synthetic */ MobileInputUI xUi;

            {
                this.xUi = r1;
            }

            public final void a(n nVar) {
                if (nVar.cps()) {
                    nVar.eQ(5001, R.l.eXB);
                    nVar.eQ(5002, R.l.eXy);
                }
            }
        };
        this.jLx.rKD = new p$d(this) {
            final /* synthetic */ MobileInputUI xUi;

            {
                this.xUi = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 5001:
                        MobileInputUI.bp(this.xUi, this.xUi.getString(R.l.eXC) + w.cfi());
                        return;
                    case 5002:
                        MobileInputUI.bp(this.xUi, this.xUi.getString(R.l.eXz) + w.cfi());
                        return;
                    default:
                        return;
                }
            }
        };
        this.jLx.ztB = new g.a(this) {
            final /* synthetic */ MobileInputUI xUi;

            {
                this.xUi = r1;
            }

            public final void onDismiss() {
                this.xUi.jLx.bxh();
            }
        };
        if (w.cff()) {
            this.xOz.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MobileInputUI xUi;

                {
                    this.xUi = r1;
                }

                public final void onClick(View view) {
                    MobileInputUI.bp(this.xUi, this.xUi.getString(R.l.eXC) + w.cfi());
                }
            });
        } else {
            this.xOy.setVisibility(8);
            this.xOz.setText(R.l.etr);
            this.xOz.setOnClickListener(new 5(this));
        }
        this.xTY.addTextChangedListener(new 6(this));
        this.xTY.setOnEditorActionListener(new 7(this));
        this.xTY.setOnKeyListener(new 8(this));
        this.xQo.setEnabled(false);
        this.xQo.setOnClickListener(new 9(this));
        if (bh.ov(this.hEx) || bh.ov(this.countryCode)) {
            String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            x.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + simCountryIso);
            if (bh.ov(simCountryIso)) {
                x.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
            } else {
                com.tencent.mm.ar.b.a h = com.tencent.mm.ar.b.h(this, simCountryIso, getString(R.l.bZb));
                if (h == null) {
                    x.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
                } else {
                    this.countryCode = ao.Vl(h.hEw);
                    this.hEx = h.hEx;
                }
            }
        }
        if (bh.ov(this.hEx) || bh.ov(this.countryCode)) {
            this.hEx = getString(R.l.dXI);
            this.countryCode = ao.Vl(getString(R.l.dXH));
        }
        cnZ();
        if (bh.ov(this.xQh)) {
            this.xTY.setText(this.xQh);
        }
        this.xQd.setOnClickListener(new 10(this));
        setMMTitle("");
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.e.btq));
        getSupportActionBar().getCustomView().findViewById(R.h.divider).setVisibility(8);
    }

    private void coy() {
        aWs();
        this.xUg.Ei(a.xUl);
    }

    private void goBack() {
        if (this.xUh) {
            aWs();
            Intent at = com.tencent.mm.plugin.c.a.ifs.at(this);
            at.addFlags(67108864);
            at.putExtra("can_finish", true);
            startActivity(at);
            finish();
            com.tencent.mm.ui.base.b.fG(this);
            return;
        }
        this.xUg.Ei(a.xUk);
        b.oH(this.pRQ);
        aWs();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void cnZ() {
        if (bh.ov(this.hEx) || bh.ov(this.countryCode)) {
            this.xQe.setText(getString(R.l.evh));
        } else {
            this.xQe.setText(ao.fr(this.hEx, this.countryCode));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 32047) {
            if (i2 == -1) {
                if (this.xUg instanceof d) {
                    ((d) this.xUg).xTR = 0;
                } else if (this.xUg instanceof e) {
                    ((e) this.xUg).xTR = 0;
                }
                this.xUg.Ei(a.xUl);
            } else if (this.xUg instanceof d) {
                ((d) this.xUg).xTR = 1;
            } else if (this.xUg instanceof e) {
                ((e) this.xUg).xTR = 1;
            }
        } else if (i == 32046) {
            if (i2 == -1) {
                if (this.xUg instanceof d) {
                    ((d) this.xUg).xTR = 2;
                }
                if (this.xUg instanceof e) {
                    ((e) this.xUg).xTR = 2;
                }
                this.xUg.Ei(a.xUl);
            }
        } else if (i != 32045) {
            switch (i2) {
                case -1:
                    if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                        String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                        int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
                        String str = "MicroMsg.MobileInputUI";
                        String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(bh.ov(stringExtra));
                        objArr[1] = Integer.valueOf(bh.ov(stringExtra) ? 0 : stringExtra.length());
                        objArr[2] = Integer.valueOf(intExtra);
                        x.d(str, str2, objArr);
                        if (intExtra == -217) {
                            coy();
                            return;
                        }
                        return;
                    }
                    return;
                case 100:
                    this.hEx = bh.az(intent.getStringExtra("country_name"), "");
                    this.countryCode = bh.az(intent.getStringExtra("couttry_code"), "");
                    cnZ();
                    return;
                default:
                    return;
            }
        } else if (i2 == -1 && (this.xUg instanceof e)) {
            if (intent.hasExtra("VoiceLoginAuthPwd")) {
                ((e) this.xUg).mBX = intent.getStringExtra("VoiceLoginAuthPwd");
            }
            this.xUg.Ei(a.xUl);
        }
    }

    public void setRequestedOrientation(int i) {
    }

    private static void bp(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
