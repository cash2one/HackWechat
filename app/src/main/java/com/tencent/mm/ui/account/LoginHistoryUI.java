package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.e.1;
import com.tencent.mm.ui.account.e.2;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.account.mobile.a$a;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p$c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import com.tencent.mm.z.bh;
import com.tencent.mm.z.bq;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

@a(19)
public class LoginHistoryUI extends MMActivity implements e {
    private String fIG = "";
    private SharedPreferences gZO;
    protected ProgressDialog iln = null;
    protected MMFormVerifyCodeInputView jNX;
    protected int jge;
    protected EditText lTk;
    protected int[] nZZ = new int[5];
    protected String pRM;
    protected String sgP = "";
    protected LinearLayout tYh;
    private SecurityImage xKa = null;
    private c xNR = new 1(this);
    protected f xOA = new f();
    protected String xOB;
    protected String xOC;
    private String xOD;
    private String xOE;
    private ImageView xOF;
    private MMKeyboardUperView xOG;
    private ResizeLayout xOH;
    protected String xOI;
    private String xOJ;
    private com.tencent.mm.pluginsdk.h.a xOK;
    protected LinearLayout xOL;
    protected LinearLayout xOM;
    protected MMFormInputView xON;
    protected boolean xOO = false;
    protected boolean xOP;
    private int xOQ;
    private int xOR;
    private boolean xOS = false;
    private String xOT;
    private int xOU;
    private String xOV;
    private String xOW;
    private String xOX;
    private int xOY;
    private int xOZ = 0;
    protected TextView xOq;
    protected Button xOr;
    protected Button xOs;
    protected View xOt;
    protected View xOu;
    protected View xOv;
    protected Button xOw;
    protected Button xOx;
    private View xOy;
    protected Button xOz;

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI) {
        ae.Vd("welcome_page_show");
        k.e(loginHistoryUI, true);
        b yVar = new y();
        yVar.fnQ.fnR = false;
        com.tencent.mm.sdk.b.a.xef.m(yVar);
        ar.getNotification().up();
        loginHistoryUI.finish();
        Context context = loginHistoryUI.mController.xIM;
        x.cfk();
        MMNativeJpeg.Destroy();
        Intent intent = null;
        try {
            intent = new Intent().setClass(context, Class.forName(ac.cfq()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LoginHistoryUI", e, "", new Object[0]);
        }
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI, int i) {
        loginHistoryUI.nZZ[3] = 1;
        Intent intent;
        switch (i) {
            case 7001:
                intent = new Intent(loginHistoryUI, LoginVoiceUI.class);
                intent.putExtra("switch_login_wx_id", loginHistoryUI.xOE);
                loginHistoryUI.startActivity(intent);
                loginHistoryUI.finish();
                return;
            case 7006:
                intent = new Intent(loginHistoryUI, LoginFaceUI.class);
                intent.putExtra("switch_login_wx_id", loginHistoryUI.xOE);
                loginHistoryUI.startActivity(intent);
                loginHistoryUI.finish();
                return;
            case 7007:
                intent = new Intent(loginHistoryUI, LoginPasswordUI.class);
                intent.putExtra("switch_login_wx_id", loginHistoryUI.xOE);
                loginHistoryUI.startActivity(intent);
                loginHistoryUI.finish();
                return;
            case 7008:
                intent = new Intent(loginHistoryUI, LoginSmsUI.class);
                intent.putExtra("switch_login_wx_id", loginHistoryUI.xOE);
                loginHistoryUI.startActivity(intent);
                loginHistoryUI.finish();
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void d(LoginHistoryUI loginHistoryUI) {
        loginHistoryUI.nZZ[4] = 1;
        Intent intent = new Intent(loginHistoryUI, MobileInputUI.class);
        intent.putExtra("mobile_input_purpose", 1);
        int[] iArr = new int[5];
        iArr[4] = 1;
        intent.putExtra("kv_report_login_method_data", iArr);
        loginHistoryUI.startActivity(intent);
    }

    static /* synthetic */ void e(LoginHistoryUI loginHistoryUI) {
        int i = 1;
        if (d.vAC) {
            String string = loginHistoryUI.getString(R.l.dXK, new Object[]{"0x" + Integer.toHexString(d.vAz), w.cfi()});
            x.e("MicroMsg.LoginHistoryUI", "url " + string);
            bp(loginHistoryUI.mController.xIM, string);
            return;
        }
        if (bh.HO().HP() <= 0) {
            i = 0;
        }
        if (i == 0) {
            Intent intent = new Intent(loginHistoryUI, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 2);
            loginHistoryUI.startActivity(intent);
            com.tencent.mm.plugin.c.b.oH("R200_100");
            com.tencent.mm.plugin.c.b.oG("RE100_100_logout");
            com.tencent.mm.plugin.c.b.b(false, ar.CB() + "," + loginHistoryUI.getClass().getName() + ",RE100_100_logout," + ar.fH("RE100_100_logout") + ",2");
            return;
        }
        intent = new Intent(loginHistoryUI, RegByMobileRegAIOUI.class);
        intent.putExtra("login_type", 0);
        loginHistoryUI.startActivity(intent);
        bh.HO();
        com.tencent.mm.plugin.c.b.jd(20);
        com.tencent.mm.plugin.c.b.oH("RE200_100");
        com.tencent.mm.plugin.c.b.oG("RE100_100_logout");
        com.tencent.mm.plugin.c.b.b(false, ar.CB() + "," + loginHistoryUI.getClass().getName() + ",RE100_100_logout," + ar.fH("RE100_100_logout") + ",2");
    }

    static /* synthetic */ void h(LoginHistoryUI loginHistoryUI) {
        int i = 0;
        if (loginHistoryUI.xOR == 0) {
            i = !com.tencent.mm.ar.b.PT() ? 7 : 6;
        } else {
            if (!((loginHistoryUI.xOR & 2) == 0 && (loginHistoryUI.xOR & 4) == 0)) {
                i = 2;
            }
            if ((loginHistoryUI.xOR & 4) != 0) {
                i |= 4;
            }
            if ((loginHistoryUI.xOR & 1) != 0) {
                i |= 1;
            }
        }
        i |= 8;
        l lVar = new l(loginHistoryUI);
        lVar.rKC = new 1(i, loginHistoryUI);
        lVar.rKD = new 2(loginHistoryUI, null, null, null);
        lVar.bBX();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[]{com.tencent.mm.plugin.c.a.ift});
        com.tencent.mm.plugin.c.a.ift.up();
        this.gZO = ac.getContext().getSharedPreferences(ac.cfs(), 0);
        Intent intent = getIntent();
        if (intent != null) {
            this.xOS = intent.getBooleanExtra("login_success_need_bind_fingerprint", false);
            this.xOS = this.xOS;
            if (this.xOS) {
                this.xOT = intent.getStringExtra("bind_login_fingerprint_info");
            }
        }
        initView();
        this.xOK = new com.tencent.mm.pluginsdk.h.a();
    }

    public void onDestroy() {
        x.i("MicroMsg.LoginHistoryUI", "onDestroy");
        ar.CG().b(701, this);
        if (this.xOK != null) {
            this.xOK.close();
        }
        g.pQN.h(14262, new Object[]{Integer.valueOf(this.nZZ[0]), Integer.valueOf(this.nZZ[1]), Integer.valueOf(this.nZZ[2]), Integer.valueOf(this.nZZ[3]), Integer.valueOf(this.nZZ[4])});
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        final List arrayList = new ArrayList();
        if (!(!cnR() || this.jge == 1 || (this.xOQ & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0)) {
            o oVar = new o(7001, 0);
            oVar.setTitle(R.l.etE);
            arrayList.add(oVar);
        }
        if (!(this.jge == 5 || (this.xOQ & 262144) == 0)) {
            oVar = new o(7005, 0);
            oVar.setTitle(R.l.etB);
            arrayList.add(oVar);
        }
        if (!com.tencent.mm.sdk.platformtools.bh.ov(this.xOI)) {
            if (this.jge != 2) {
                oVar = new o(7007, 0);
                oVar.setTitle(getString(R.l.etC));
                arrayList.add(oVar);
            }
            if (!(com.tencent.mm.sdk.platformtools.bh.ov(this.xOC) || this.jge == 3)) {
                oVar = new o(7008, 0);
                oVar.setTitle(getString(R.l.etD));
                arrayList.add(oVar);
            }
            if (this.xOI.equalsIgnoreCase(this.xOB)) {
                this.lTk.setHint(getString(R.l.eEg));
            }
        }
        if (arrayList.size() > 1) {
            com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(this, com.tencent.mm.ui.widget.g.ztp, false);
            gVar.rKC = new p$c(this) {
                final /* synthetic */ LoginHistoryUI xPa;

                public final void a(n nVar) {
                    if (nVar.size() == 0) {
                        for (o oVar : arrayList) {
                            if (oVar != null) {
                                nVar.ycc.add(oVar);
                            }
                        }
                    }
                }
            };
            gVar.rKD = new p.d(this) {
                final /* synthetic */ LoginHistoryUI xPa;

                {
                    this.xPa = r1;
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    LoginHistoryUI.a(this.xPa, menuItem.getItemId());
                }
            };
            gVar.ztB = new 24(this, gVar);
            this.xOs.setVisibility(0);
            this.xOs.setText(R.l.ett);
            this.xOs.setOnClickListener(new 25(this, gVar));
        } else if (arrayList.size() > 0) {
            this.xOs.setVisibility(0);
            this.xOs.setText(((o) arrayList.get(0)).getTitle());
            this.xOs.setOnClickListener(new 26(this, arrayList));
        } else {
            this.xOs.setVisibility(8);
        }
        com.tencent.mm.sdk.b.a.xef.b(this.xNR);
        ar.CC();
        if (!ar.Hi() || this.xOI.equals("")) {
            if (com.tencent.mm.o.a.AV() == 2) {
                i$a com_tencent_mm_ui_base_i_a = new i$a(this);
                com_tencent_mm_ui_base_i_a.Ez(R.l.dTu);
                com_tencent_mm_ui_base_i_a.YG(getString(R.l.dTt));
                com_tencent_mm_ui_base_i_a.mi(false);
                com_tencent_mm_ui_base_i_a.EC(R.l.dTr).a(new 22(this));
                com_tencent_mm_ui_base_i_a.akx().show();
                com.tencent.mm.o.a.b(this, System.currentTimeMillis());
            }
        } else if (this.iln == null || !this.iln.isShowing()) {
            b(null);
        }
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xef.c(this.xNR);
    }

    private void goBack() {
        Intent at = com.tencent.mm.plugin.c.a.ifs.at(this);
        at.addFlags(67108864);
        if (com.tencent.mm.sdk.platformtools.bh.ov(this.xOE)) {
            at.putExtra("can_finish", true);
        }
        startActivity(at);
        finish();
        com.tencent.mm.ui.base.b.fG(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected final void initView() {
        this.tYh = (LinearLayout) findViewById(R.h.cWC);
        this.xOM = (LinearLayout) findViewById(R.h.cfO);
        this.xOL = (LinearLayout) findViewById(R.h.chZ);
        this.xON = (MMFormInputView) findViewById(R.h.cur);
        this.jNX = (MMFormVerifyCodeInputView) findViewById(R.h.cOQ);
        this.xOE = getIntent().getStringExtra("switch_login_wx_id");
        if (com.tencent.mm.sdk.platformtools.bh.ov(this.xOE)) {
            this.xOI = aq.hfP.H("login_user_name", "");
            this.xOJ = aq.hfP.GY();
            this.xOR = com.tencent.mm.sdk.platformtools.bh.VI(aq.hfP.H("last_bind_info", ""));
            if ((this.xOR & 1) != 0) {
                this.xOB = aq.hfP.H("last_login_bind_qq", "");
            }
            if ((this.xOR & 4) != 0) {
                this.xOC = aq.hfP.H("last_login_bind_mobile", "");
            }
            this.xOQ = com.tencent.mm.sdk.platformtools.bh.VI(aq.hfP.H("last_login_use_voice", ""));
        } else {
            this.xOI = bq.hhK.getString(this.xOE, "login_user_name");
            this.xOJ = bq.hhK.getString(this.xOE, "last_avatar_path");
            this.xOR = com.tencent.mm.sdk.platformtools.bh.VI(bq.hhK.getString(this.xOE, "last_bind_info"));
            if ((this.xOR & 1) != 0) {
                this.xOB = bq.hhK.getString(this.xOE, "last_login_bind_qq");
            }
            if ((this.xOR & 4) != 0) {
                this.xOC = bq.hhK.getString(this.xOE, "last_login_bind_mobile");
            }
            this.xOQ = com.tencent.mm.sdk.platformtools.bh.VI(bq.hhK.getString(this.xOE, "last_login_use_voice"));
            setBackBtn(new 27(this), R.k.duV);
        }
        String stringExtra = getIntent().getStringExtra("email_address");
        if (!(com.tencent.mm.sdk.platformtools.bh.ov(stringExtra) || stringExtra.equalsIgnoreCase(this.xOI))) {
            this.xOI = stringExtra;
        }
        this.xOF = (ImageView) findViewById(R.h.csw);
        if (!com.tencent.mm.sdk.platformtools.bh.ov(this.xOJ)) {
            Bitmap jg = com.tencent.mm.ad.d.jg(this.xOJ);
            if (jg != null && jg.getWidth() > 10) {
                this.xOF.setImageBitmap(Bitmap.createBitmap(jg, 5, 5, jg.getWidth() - 10, jg.getHeight() - 10, null, false));
            }
        }
        if (!ar.Hi() || this.xOI.equals("")) {
            this.xOG = (MMKeyboardUperView) findViewById(R.h.scrollView);
            this.xOq = (TextView) findViewById(R.h.cuh);
            this.lTk = this.xON.pqM;
            this.xOr = (Button) findViewById(R.h.cuj);
            this.xOt = findViewById(R.h.cuv);
            this.xOu = findViewById(R.h.cum);
            this.xOv = (Button) findViewById(R.h.cOm);
            this.xOs = (Button) findViewById(R.h.cul);
            this.xOw = (Button) findViewById(R.h.cun);
            this.xOx = (Button) findViewById(R.h.cuo);
            this.xOy = findViewById(R.h.cjf);
            this.xOz = (Button) findViewById(R.h.cup);
            this.xOw.setOnClickListener(new 28(this));
            this.xOx.setOnClickListener(new 29(this));
            if (!w.cff()) {
                this.xOy.setVisibility(8);
            }
            this.xON.setVisibility(8);
            this.tYh.setVisibility(8);
            this.xOM.setVisibility(8);
            this.xOL.setVisibility(8);
            this.xOr.setVisibility(8);
            this.xOt.setVisibility(8);
            this.xOu.setVisibility(8);
            this.xOv.setVisibility(8);
            this.xOs.setVisibility(8);
            com.tencent.mm.ui.tools.a.c.d(this.lTk).fi(4, 16).a(null);
            this.xOH = (ResizeLayout) findViewById(R.h.cHL);
            if (!com.tencent.mm.sdk.platformtools.bh.VR(this.xOI).booleanValue() || this.xOI.equals(this.xOB)) {
                this.nZZ[2] = 2;
                this.xOq.setText(this.xOI);
            } else {
                this.nZZ[2] = 1;
                this.xOq.setText(Id(this.xOI));
            }
            this.xOH.xSs = new 30(this);
            this.xOG.setOnTouchListener(new 31(this));
            final com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(this, com.tencent.mm.ui.widget.g.ztp, false);
            gVar.rKC = new p$c(this) {
                final /* synthetic */ LoginHistoryUI xPa;

                {
                    this.xPa = r1;
                }

                public final void a(n nVar) {
                    if (nVar.size() == 0) {
                        nVar.eQ(7002, R.l.etu);
                        nVar.eQ(7003, R.l.epz);
                        nVar.eQ(7004, R.l.eXB);
                        if (!w.cff()) {
                            nVar.eQ(7009, R.l.eXy);
                        }
                    }
                }
            };
            gVar.rKD = new 2(this);
            gVar.ztB = new com.tencent.mm.ui.widget.g.a(this) {
                final /* synthetic */ LoginHistoryUI xPa;

                public final void onDismiss() {
                    gVar.bxh();
                }
            };
            if (com.tencent.mm.sdk.platformtools.bh.ov(this.xOE)) {
                this.xOz.setOnClickListener(new 4(this, gVar));
            } else if (w.cff()) {
                this.xOz.setText(R.l.eXB);
                this.xOz.setOnClickListener(new 6(this));
            } else {
                this.xOz.setText(R.l.eXy);
                this.xOz.setOnClickListener(new 5(this));
            }
            setMMTitle("");
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.e.btq));
            getSupportActionBar().getCustomView().findViewById(R.h.divider).setVisibility(8);
            if (f.xeC) {
                com.tencent.mm.plugin.c.a.ift.e(this);
                return;
            }
            return;
        }
        this.xOO = true;
        b(null);
    }

    protected final String Id(String str) {
        ao aoVar = new ao();
        String str2 = "86";
        if (this.xOI.startsWith("+")) {
            str = str.replace("+", "");
            str2 = ao.De(str);
            if (str2 != null) {
                str = str.substring(str2.length());
            }
        }
        return ao.formatNumber(str2, str);
    }

    protected final void cnN() {
        ar.CG().a(701, this);
    }

    protected final void cnO() {
        ar.CG().b(701, this);
    }

    protected void afF() {
        this.xOA.hNv = this.xOI.trim();
    }

    public final void aWs() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    private void cnP() {
        Intent intent = new Intent();
        intent.putExtra("regsetinfo_ticket", this.xOX);
        intent.putExtra("regsetinfo_user", this.xOC);
        intent.putExtra("regsetinfo_ismobile", 1);
        intent.putExtra("regsetinfo_NextControl", this.xOY);
        intent.putExtra("regsession_id", this.xOW);
        intent.setClass(this, RegSetInfoUI.class);
        com.tencent.mm.plugin.c.b.oH("R200_950_olduser");
        startActivity(intent);
        com.tencent.mm.plugin.c.b.oI(ar.CB() + "," + getClass().getName() + ",L200_900_phone," + ar.fH("L200_900_phone") + ",2");
    }

    private void cnQ() {
        Intent intent = new Intent(this, ShowAgreementsUI.class);
        intent.putExtra("agreement_type", 0);
        startActivityForResult(intent, 31687);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginHistoryUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.d(str, str2, objArr);
        if (i == 31687) {
            if (i2 != -1) {
                return;
            }
            if (this.xOU == -355) {
                m.b(this, this.xOV, 31686);
            } else {
                cnP();
            }
        } else if (i != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || intent == null) {
            if (i != 1025 || intent == null) {
                if (i == 31686) {
                    if (i2 == -1) {
                        cnP();
                    }
                } else if (i == 31685) {
                    if (intent != null && intent.hasExtra("VoiceLoginAuthPwd")) {
                        this.sgP = intent.getStringExtra("VoiceLoginAuthPwd");
                    }
                    if (i2 == -1) {
                        afF();
                    }
                }
            } else if (i2 == 2) {
                r0 = intent.getStringExtra("KFaceLoginAuthPwd");
                str = "MicroMsg.LoginHistoryUI";
                str2 = "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d";
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(com.tencent.mm.sdk.platformtools.bh.ov(r0));
                if (!com.tencent.mm.sdk.platformtools.bh.ov(r0)) {
                    i3 = r0.length();
                }
                objArr[1] = Integer.valueOf(i3);
                x.i(str, str2, objArr);
                Yu(r0);
            }
        } else if (i2 == -1) {
            r0 = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginHistoryUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(com.tencent.mm.sdk.platformtools.bh.ov(r0));
            if (!com.tencent.mm.sdk.platformtools.bh.ov(r0)) {
                i3 = r0.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            x.d(str2, str3, objArr2);
            Yu(r0);
        }
    }

    private void Yu(String str) {
        this.sgP = str;
        afF();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        x.d("MicroMsg.LoginHistoryUI", "Scene Type " + kVar.getType());
        com.tencent.mm.h.a eA;
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX) {
            if (this.iln != null && this.iln.isShowing()) {
                this.iln.dismiss();
                this.iln = null;
            }
            int IS = ((s) kVar).IS();
            if (IS == 16) {
                if (i2 == -41) {
                    h.h(this, R.l.eDE, R.l.eDF);
                    this.jNX.reset();
                    return;
                } else if (i2 == -75) {
                    h.b(this, getString(R.l.dDF), "", true);
                    this.jNX.reset();
                    return;
                }
            } else if (IS == 17) {
                this.xOU = i2;
                this.xOV = str;
                if (i == 0 && i2 == 0) {
                    new com.tencent.mm.ui.account.mobile.a(new a$a(this) {
                        final /* synthetic */ LoginHistoryUI xPa;

                        {
                            this.xPa = r1;
                        }

                        public final void b(ProgressDialog progressDialog) {
                            this.xPa.iln = progressDialog;
                        }
                    }, ((s) kVar).getUsername(), ((s) kVar).NV(), this.xOC).j(this);
                    return;
                } else if (i2 == -51) {
                    eA = com.tencent.mm.h.a.eA(str);
                    if (eA != null) {
                        eA.a(this, null, null);
                        return;
                    } else {
                        h.h(this, R.l.eDb, R.l.bNB);
                        return;
                    }
                } else if (i2 == -355 || i2 == -30) {
                    com.tencent.mm.plugin.c.b.oI(ar.CB() + "," + getClass().getName() + ",L200_900_phone," + ar.fH("L200_900_phone") + ",1");
                    this.xOX = ((s) kVar).NW();
                    this.xOY = ((s) kVar).Oc();
                    this.xOW = ((s) kVar).Ok();
                    if (d.vAC) {
                        String string = getString(R.l.dXK, new Object[]{"0x" + Integer.toHexString(d.vAz), w.cfi()});
                        x.e("MicroMsg.LoginHistoryUI", "url " + string);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", string);
                        intent.putExtra("showShare", false);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("needRedirect", false);
                        intent.putExtra("neverGetA8Key", true);
                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
                        com.tencent.mm.plugin.c.a.ifs.j(intent, this);
                        return;
                    } else if (i2 == -355) {
                        cnQ();
                        return;
                    } else {
                        eA = com.tencent.mm.h.a.eA(str);
                        if (eA != null) {
                            eA.a(this, new 8(this), null);
                            return;
                        }
                        return;
                    }
                }
            }
        } else if (kVar.getType() == 701) {
            this.fIG = ((v) kVar).RY();
            x.e("MicroMsg.LoginHistoryUI", "url " + this.fIG);
            ar.CG().b(701, this);
            this.xOA.xPt = ((v) kVar).RZ();
            this.xOA.xPq = ((v) kVar).Op();
            this.xOA.xPs = ((v) kVar).Oo();
            this.xOA.xPr = ((v) kVar).Sa();
            if (i2 == -205) {
                this.pRM = ((v) kVar).NX();
                this.xOC = ((v) kVar).Sb();
                this.xOD = ((v) kVar).Se();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                ar.CG().a(new bd(new 9(this)), 0);
                r0 = true;
            } else {
                r0 = false;
            }
            if (r0 || (i == 0 && i2 == 0)) {
                ar.unhold();
                com.tencent.mm.modelsimple.d.bq(this);
                m.or(this.xOA.hNv);
                if (this.iln != null && this.iln.isShowing()) {
                    this.iln.setMessage(getString(R.l.eLF));
                }
                b((v) kVar);
                if (this.jge == 3) {
                    this.xOP = ((v) kVar).Sg();
                    ar.CG().a(255, this);
                    final com.tencent.mm.ae.k xVar = new com.tencent.mm.modelsimple.x(1);
                    ar.CG().a(xVar, 0);
                    getString(R.l.dGO);
                    this.iln = h.a(this, getString(R.l.eLF), true, new OnCancelListener(this) {
                        final /* synthetic */ LoginHistoryUI xPa;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ar.CG().c(xVar);
                            ar.CG().b(255, this.xPa);
                        }
                    });
                    return;
                }
                return;
            }
            if (this.iln != null && this.iln.isShowing()) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (i2 == -106) {
                m.b(this, str, 31685);
                return;
            } else if (i2 == -217) {
                m.a(this, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
                return;
            } else if (i2 == -30) {
                if (d.vAC) {
                    bp(this.mController.xIM, this.fIG);
                    return;
                } else {
                    h.a(this, getString(R.l.etI), "", new 11(this, kVar), new 12(this));
                    return;
                }
            } else if (!o(i, i2, str)) {
                eA = com.tencent.mm.h.a.eA(str);
                if (eA == null || !eA.a(this, null, null)) {
                    Toast.makeText(this, getString(R.l.eio, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (kVar.getType() == 255) {
            if (this.iln != null && this.iln.isShowing()) {
                this.iln.dismiss();
                this.iln = null;
            }
            ar.CG().b(255, this);
            if (i != 0 || i2 != 0) {
                r0 = this.xOP;
                Intent intent2 = new Intent(this, RegByMobileSetPwdUI.class);
                intent2.putExtra("kintent_hint", getString(R.l.eLU));
                intent2.putExtra("kintent_cancelable", r0);
                startActivity(intent2);
                return;
            }
            return;
        }
        if (!o(i, i2, str)) {
        }
    }

    private void b(v vVar) {
        x.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[]{Integer.valueOf(hashCode()), com.tencent.mm.sdk.platformtools.bh.cgy()});
        Intent at = com.tencent.mm.plugin.c.a.ifs.at(this);
        at.addFlags(67108864);
        if (vVar != null) {
            at.putExtra("kstyle_show_bind_mobile_afterauth", vVar.Sc());
            at.putExtra("kstyle_bind_recommend_show", vVar.Sf());
            at.putExtra("kstyle_bind_wording", vVar.Sd());
        }
        startActivity(at);
        finish();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean o(final int i, int i2, String str) {
        if (i == 4) {
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    ar.CG().a(701, this);
                    if (this.xKa == null) {
                        this.xKa = SecurityImage.a.a(this, R.l.eEi, this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr, new OnClickListener(this) {
                            final /* synthetic */ LoginHistoryUI xPa;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                int i2 = -1;
                                x.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.xPa.xOA.xPq + " img len" + this.xPa.xOA.xPs.length + " " + com.tencent.mm.compatible.util.g.zh());
                                String str = "MicroMsg.LoginHistoryUI";
                                String str2 = "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
                                Object[] objArr = new Object[5];
                                objArr[0] = Integer.valueOf(i);
                                objArr[1] = Integer.valueOf(this.xPa.sgP == null ? -1 : this.xPa.sgP.length());
                                objArr[2] = com.tencent.mm.sdk.platformtools.bh.VT(this.xPa.sgP);
                                if (this.xPa.xOA.xPo != null) {
                                    i2 = this.xPa.xOA.xPo.length();
                                }
                                objArr[3] = Integer.valueOf(i2);
                                objArr[4] = com.tencent.mm.sdk.platformtools.bh.VT(this.xPa.xOA.xPo);
                                x.d(str, str2, objArr);
                                com.tencent.mm.ae.k vVar = new v(this.xPa.xOA.hNv, this.xPa.xOA.xPo, this.xPa.xOA.xPt, this.xPa.xKa.coF(), this.xPa.xKa.xPq, this.xPa.xKa.xPr, 0, "", false, false);
                                if (com.tencent.mm.sdk.platformtools.bh.ov(this.xPa.xOA.xPo) && !com.tencent.mm.sdk.platformtools.bh.ov(this.xPa.sgP)) {
                                    x.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[]{com.tencent.mm.sdk.platformtools.bh.VT(this.xPa.sgP)});
                                    vVar.mw(this.xPa.sgP);
                                }
                                ar.CG().a(vVar, 0);
                                LoginHistoryUI loginHistoryUI = this.xPa;
                                Context context = this.xPa;
                                this.xPa.getString(R.l.dGO);
                                loginHistoryUI.iln = h.a(context, this.xPa.getString(R.l.etF), true, new 1(this, vVar));
                            }
                        }, null, new 18(this), this.xOA);
                    } else {
                        x.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.xOA.xPq + " img len" + this.xOA.xPs.length + " " + com.tencent.mm.compatible.util.g.zh());
                        this.xKa.a(this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr);
                    }
                    return true;
                case -205:
                    x.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[]{com.tencent.mm.sdk.platformtools.bh.VT(this.pRM), this.xOD});
                    f.a(this.xOA);
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.pRM);
                    intent.putExtra("binded_mobile", this.xOC);
                    intent.putExtra("close_safe_device_style", this.xOD);
                    intent.putExtra("from_source", 2);
                    com.tencent.mm.plugin.c.a.ifs.g(this, intent);
                    return true;
                case -140:
                    if (!com.tencent.mm.sdk.platformtools.bh.ov(this.fIG)) {
                        m.j(this, str, this.fIG);
                    }
                    return true;
                case -100:
                    ar.hold();
                    h.a(this, TextUtils.isEmpty(ar.Ci()) ? com.tencent.mm.bv.a.ac(this, R.l.euu) : ar.Ci(), getString(R.l.dGO), new 19(this), new 20(this));
                    return true;
                case -75:
                    m.bE(this);
                    return true;
                case -72:
                    h.h(this, R.l.eEb, R.l.dGO);
                    return true;
                case -33:
                    h.a(this, R.l.dLA, R.l.bNB, new 16(this));
                    return true;
                case -32:
                    h.a(this, getString(R.l.dLC), "", new 15(this));
                    return true;
                case -9:
                    break;
                case -4:
                case -3:
                    if (this.xOZ <= 0) {
                        h.h(this, R.l.ecj, R.l.etw);
                        this.xOZ++;
                    } else {
                        h.a(this, getString(R.l.eck), getString(R.l.etw), getString(R.l.ecl), getString(R.l.dEn), new 13(this), new 14(this));
                    }
                    return true;
                case -1:
                    if (ar.CG().Km() == 5) {
                        h.h(this, R.l.exG, R.l.exF);
                        return true;
                    }
                    break;
            }
        }
        if (com.tencent.mm.plugin.c.a.ift.a(this, i, i2, str)) {
            if (this.xKa != null) {
                this.xKa.dismiss();
            }
            return true;
        }
        return this.xOK.a(this, new com.tencent.mm.pluginsdk.h.o(i, i2, str));
    }

    protected final int getLayoutId() {
        return R.i.dmM;
    }

    public void setRequestedOrientation(int i) {
    }

    public static void bp(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        com.tencent.mm.bm.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public boolean cnR() {
        return true;
    }
}
