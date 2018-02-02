package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.t;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage$b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.bindmobile.FindMContactAlertUI;
import com.tencent.mm.ui.bindmobile.FindMContactIntroUI;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI extends MMActivity implements e {
    private ProgressDialog iln = null;
    private Button lRZ;
    private String lcJ;
    private ProgressBar lpy;
    private String mzL;
    private int sceneType = 0;
    private SecurityImage xKa = null;
    private a xOK;
    private String xOW;
    private boolean xQq = false;
    private EditText xRJ;
    private String xRK;
    private String xRL;
    private int xRM;
    private String xRN;
    private TextView xRO;
    private View xRP;
    private boolean xRQ = false;
    private ImageView xRR;
    private int xRS = 3;
    private int xRT;
    private LinkedList<String> xRU = new LinkedList();
    private ImageView xRV;
    private String xRW = "";
    private ImageView xRX;
    private View xRY;
    private TextView xRZ;
    private EditText xRb;
    private String xSa = null;
    private boolean xSb = false;
    private q xSc;
    private View xSd;
    private boolean xSe = false;
    private ak xSf = new ak(Looper.myLooper(), new 1(this), true);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void p(RegSetInfoUI regSetInfoUI) {
        String trim = regSetInfoUI.xRb.getText().toString().trim();
        String trim2 = regSetInfoUI.xRJ.getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            h.h(regSetInfoUI, R.l.eSF, R.l.eDR);
        } else if (regSetInfoUI.lpy.getVisibility() == 0) {
            regSetInfoUI.getString(R.l.dGO);
            regSetInfoUI.iln = h.a((Context) regSetInfoUI, regSetInfoUI.getString(R.l.eEh), true, new 6(regSetInfoUI));
        } else if (regSetInfoUI.cof() && regSetInfoUI.coi() && !bh.ov(trim2)) {
            String charSequence = regSetInfoUI.xRO.getText().toString();
            if (!bh.ov(charSequence)) {
            }
            charSequence = bh.ov(regSetInfoUI.xSa) ? regSetInfoUI.getString(R.l.eEs) : regSetInfoUI.xSa;
            h.b(regSetInfoUI, charSequence, "", true);
        } else {
            regSetInfoUI.aWs();
            int com;
            k yVar;
            if (regSetInfoUI.coi()) {
                int i = (regSetInfoUI.xRU == null || regSetInfoUI.xRU.size() == 0) ? 0 : regSetInfoUI.xRU.contains(trim2) ? 1 : 2;
                com = regSetInfoUI.com();
                ar.CG().a(126, regSetInfoUI);
                yVar = new y("", regSetInfoUI.mzL, trim, regSetInfoUI.xRM, regSetInfoUI.xRL, regSetInfoUI.xRK, "", "", regSetInfoUI.lcJ, com, trim2, "", "", regSetInfoUI.xRQ, regSetInfoUI.xQq);
                ((com.tencent.mm.protocal.y.a) yVar.hnp.Kb()).vBS.wAX = i;
                yVar.mx(regSetInfoUI.xOW);
                yVar.is(regSetInfoUI.xRT);
                ar.CG().a(yVar, 0);
                regSetInfoUI.getString(R.l.dGO);
                regSetInfoUI.iln = h.a((Context) regSetInfoUI, regSetInfoUI.getString(R.l.eEh), true, new 7(regSetInfoUI, yVar));
                return;
            }
            com = regSetInfoUI.com();
            ar.CG().a(126, regSetInfoUI);
            yVar = new y("", regSetInfoUI.mzL, trim, regSetInfoUI.xRM, regSetInfoUI.xRL, regSetInfoUI.xRK, "", "", regSetInfoUI.lcJ, com, "", "", "", regSetInfoUI.xRQ, regSetInfoUI.xQq);
            yVar.mx(regSetInfoUI.xOW);
            yVar.is(regSetInfoUI.xRT);
            ar.CG().a(yVar, 0);
            regSetInfoUI.getString(R.l.dGO);
            regSetInfoUI.iln = h.a((Context) regSetInfoUI, regSetInfoUI.getString(R.l.eEh), true, new 8(regSetInfoUI, yVar));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.l.eEr);
        if (d.vAC) {
            string = getString(R.l.app_name) + getString(R.l.dDD);
        }
        setMMTitle(string);
        com.tencent.mm.plugin.c.a.ift.up();
        this.xRK = getIntent().getStringExtra("regsetinfo_user");
        this.xRL = getIntent().getStringExtra("regsetinfo_bind_email");
        this.lcJ = getIntent().getStringExtra("regsetinfo_ticket");
        this.mzL = getIntent().getStringExtra("regsetinfo_pwd");
        this.xRN = getIntent().getStringExtra("regsetinfo_binduin");
        this.xRT = getIntent().getIntExtra("mobile_check_type", 0);
        if (!bh.ov(this.xRN)) {
            this.xRM = o.bY(this.xRN);
        }
        this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
        this.xRQ = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
        this.xRS = getIntent().getIntExtra("regsetinfo_NextControl", 3);
        this.xOW = getIntent().getStringExtra("regsession_id");
        initView();
        if (this.sceneType == 1) {
            b.b(true, ar.CB() + "," + getClass().getName() + ",R200_900_phone," + ar.fH("R200_900_phone") + ",1");
            b.oG("R200_900_phone");
        } else if (this.sceneType == 2) {
            b.b(true, ar.CB() + "," + getClass().getName() + ",R4_QQ," + ar.fH("R4_QQ") + ",1");
            b.oG("R4_QQ");
        } else if (this.sceneType == 3) {
            b.b(true, ar.CB() + "," + getClass().getName() + ",R200_900_email," + ar.fH("R200_900_email") + ",1");
            b.oG("R200_900_email");
        }
        this.xSe = false;
        this.xOK = new a();
    }

    public void onResume() {
        super.onResume();
        this.xRb.postDelayed(new 12(this), 500);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.sceneType == 1) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",R200_900_phone," + ar.fH("R200_900_phone") + ",2");
        } else if (this.sceneType == 2) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",R4_QQ," + ar.fH("R4_QQ") + ",2");
        } else if (this.sceneType == 3) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",R200_900_email," + ar.fH("R200_900_email") + ",2");
        }
        if (this.xOK != null) {
            this.xOK.close();
        }
    }

    protected final void initView() {
        int i;
        int i2 = 0;
        this.xSd = findViewById(R.h.cDd);
        this.xRY = findViewById(R.h.cLJ);
        this.xRR = (ImageView) findViewById(R.h.cLI);
        this.xRb = (EditText) findViewById(R.h.cHj);
        this.xRZ = (TextView) findViewById(R.h.cLL);
        this.xRJ = (EditText) findViewById(R.h.cHm);
        this.xRO = (TextView) findViewById(R.h.bJY);
        this.xRP = findViewById(R.h.cHy);
        this.xRV = (ImageView) findViewById(R.h.cZh);
        this.lpy = (ProgressBar) findViewById(R.h.cDX);
        this.xRX = (ImageView) findViewById(R.h.cLK);
        this.lRZ = (Button) findViewById(R.h.cAg);
        this.xRV.setVisibility(8);
        this.lpy.setVisibility(8);
        this.xRX.setVisibility(8);
        this.xQq = false;
        this.xSb = false;
        this.xRY.setVisibility(coh() ? 0 : 8);
        View view = this.xRP;
        if (coi()) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        TextView textView = this.xRO;
        if (!coi()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (coh() && coi()) {
            this.xRZ.setText(getString(R.l.eEo));
        } else if (coh() && !coi()) {
            this.xRZ.setText(getString(R.l.eEm));
        } else if (coh() || !coi()) {
            this.xRZ.setText(getString(R.l.eEl));
        } else {
            this.xRZ.setText(getString(R.l.eEn));
        }
        ar.Dm().a(new 23(this));
        this.xRb.addTextChangedListener(new 29(this));
        this.lRZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegSetInfoUI xSg;

            {
                this.xSg = r1;
            }

            public final void onClick(View view) {
                RegSetInfoUI.p(this.xSg);
            }
        });
        this.xRJ.setOnFocusChangeListener(new 31(this));
        this.xRJ.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegSetInfoUI xSg;

            {
                this.xSg = r1;
            }

            public final void afterTextChanged(Editable editable) {
                if (!this.xSg.xSf.cfK()) {
                    this.xSg.xSf.TG();
                }
                String trim = this.xSg.xRJ.getText().toString().trim();
                if (bh.ov(trim)) {
                    this.xSg.xRO.setText(this.xSg.getString(R.l.eEq));
                    this.xSg.S(false, false);
                    if (this.xSg.xSc != null) {
                        this.xSg.xSc.dismiss();
                        this.xSg.xSc = null;
                    }
                    this.xSg.xRJ.postDelayed(new 1(this), 50);
                }
                if (!bh.ov(trim) && (this.xSg.cof() || !trim.equals(this.xSg.xRW))) {
                    this.xSg.S(false, false);
                    this.xSg.xSf.J(500, 500);
                }
                this.xSg.xRW = trim;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        setBackBtn(new 33(this));
        this.xRb.setOnEditorActionListener(new 34(this));
        this.xRb.setOnKeyListener(new 2(this));
        this.xRJ.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ RegSetInfoUI xSg;

            {
                this.xSg = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                RegSetInfoUI.p(this.xSg);
                return true;
            }
        });
        this.xRJ.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ RegSetInfoUI xSg;

            {
                this.xSg = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                RegSetInfoUI.p(this.xSg);
                return true;
            }
        });
        this.xRR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegSetInfoUI xSg;

            {
                this.xSg = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.c.a.ift.d(this.xSg);
            }
        });
        File file = new File(com.tencent.mm.compatible.util.e.gHB);
        if (!file.exists()) {
            file.mkdir();
        }
        cog();
    }

    private void S(boolean z, boolean z2) {
        boolean z3 = false;
        if (bh.ov(this.xRJ.getText().toString().trim())) {
            z = false;
        }
        this.xRV.setImageResource(z2 ? R.g.bGp : R.g.bGm);
        this.xRV.setVisibility(z ? 0 : 8);
        if (z && z2) {
            z3 = true;
        }
        this.xSb = z3;
    }

    private boolean cof() {
        return this.xRV.getVisibility() == 8 || this.xSb;
    }

    private void cog() {
        this.lRZ.setEnabled(!bh.ov(this.xRb.getText().toString().trim()));
    }

    private boolean coh() {
        return (this.xRS & 1) > 0;
    }

    private boolean coi() {
        return (this.xRS & 2) > 0;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        Bitmap a = com.tencent.mm.plugin.c.a.ift.a(this, i, i2, intent);
        if (a != null) {
            this.xRR.setImageBitmap(a);
            this.xQq = true;
            this.xRX.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return R.i.dqI;
    }

    private boolean coj() {
        return this.sceneType == 1;
    }

    private boolean cok() {
        return this.sceneType == 2;
    }

    private boolean col() {
        return this.sceneType == 3;
    }

    private int com() {
        if (coj()) {
            return 4;
        }
        if (cok() || !col()) {
            return 2;
        }
        return 6;
    }

    private String con() {
        if (coj()) {
            return this.xRK;
        }
        if (col()) {
            return this.xRL;
        }
        return this.xRN;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int VI;
        com.tencent.mm.h.a eA;
        x.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 126) {
            ar.CG().b(126, this);
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (i == 0 && i2 == 0) {
                String str2;
                String str3;
                Intent intent;
                String str4;
                this.xSa = null;
                String con = con();
                String Si = ((y) kVar).Si();
                int Sj = ((y) kVar).Sj();
                String str5 = null;
                String str6 = null;
                boolean z = false;
                Map y = bi.y(((y) kVar).Sk(), "wording");
                if (y != null) {
                    str2 = (String) y.get(".wording.switch");
                    if (bh.ov(str2)) {
                        z = true;
                    } else {
                        VI = bh.VI(str2);
                        if (VI == 0) {
                            z = false;
                        } else if (VI == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        str2 = (String) y.get(".wording.title");
                        if (!bh.ov(str2)) {
                            str5 = str2;
                        }
                        str2 = (String) y.get(".wording.desc");
                        if (bh.ov(str2)) {
                            str3 = str5;
                        } else {
                            str6 = str2;
                            str3 = str5;
                        }
                        x.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[]{r4});
                        ar.unhold();
                        ar.by(true);
                        if (this.xQq) {
                            this.lcJ = ((y) kVar).Sh();
                            aq.hfP.S("login_user_name", con);
                            if (Si == null && Si.contains("0")) {
                                b.oH("R300_100_phone");
                                if (z) {
                                    intent = new Intent(this, FindMContactAlertUI.class);
                                    intent.putExtra("alert_title", str3);
                                    intent.putExtra("alert_message", str6);
                                } else {
                                    intent = new Intent(this, FindMContactIntroUI.class);
                                }
                                intent.addFlags(67108864);
                                intent.putExtra("regsetinfo_ticket", this.lcJ);
                                intent.putExtra("regsetinfo_NextStep", Si);
                                intent.putExtra("regsetinfo_NextStyle", Sj);
                                Intent at = com.tencent.mm.plugin.c.a.ifs.at(this);
                                at.addFlags(67108864);
                                at.putExtra("LauncherUI.enter_from_reg", true);
                                MMWizardActivity.b(this, intent, at);
                                finish();
                            } else {
                                intent = com.tencent.mm.plugin.c.a.ifs.at(this);
                                intent.addFlags(67108864);
                                intent.putExtra("LauncherUI.enter_from_reg", true);
                                startActivity(intent);
                                b.oI(ar.CB() + "," + getClass().getName() + ",R200_900_phone," + ar.fH("R200_900_phone") + ",4");
                                finish();
                            }
                        } else {
                            str4 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar";
                            str2 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar.hd";
                            new File(str4).renameTo(new File(str2));
                            com.tencent.mm.loader.stub.b.deleteFile(str4);
                            com.tencent.mm.sdk.platformtools.d.b(str2, 96, 96, CompressFormat.JPEG, 90, str4);
                            new p(this, com.tencent.mm.compatible.util.e.gHB + "temp.avatar").a(new 9(this, kVar, con, Si, z, str3, str6, Sj), new 10(this, kVar, con, Si, z, str3, str6, Sj));
                        }
                    }
                }
                str3 = null;
                x.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[]{r4});
                ar.unhold();
                ar.by(true);
                if (this.xQq) {
                    this.lcJ = ((y) kVar).Sh();
                    aq.hfP.S("login_user_name", con);
                    if (Si == null) {
                    }
                    intent = com.tencent.mm.plugin.c.a.ifs.at(this);
                    intent.addFlags(67108864);
                    intent.putExtra("LauncherUI.enter_from_reg", true);
                    startActivity(intent);
                    b.oI(ar.CB() + "," + getClass().getName() + ",R200_900_phone," + ar.fH("R200_900_phone") + ",4");
                    finish();
                } else {
                    str4 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar";
                    str2 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar.hd";
                    new File(str4).renameTo(new File(str2));
                    com.tencent.mm.loader.stub.b.deleteFile(str4);
                    com.tencent.mm.sdk.platformtools.d.b(str2, 96, 96, CompressFormat.JPEG, 90, str4);
                    new p(this, com.tencent.mm.compatible.util.e.gHB + "temp.avatar").a(new 9(this, kVar, con, Si, z, str3, str6, Sj), new 10(this, kVar, con, Si, z, str3, str6, Sj));
                }
            }
            if (i2 != -6 && i2 != -311 && i2 != -310) {
                eA = com.tencent.mm.h.a.eA(str);
                if (eA != null) {
                    eA.a(this, null, null);
                    return;
                } else if (o(i, i2, str)) {
                    return;
                }
            } else if (this.xKa == null) {
                final k kVar2 = kVar;
                this.xKa = SecurityImage.a.a(this.mController.xIM, R.l.eEi, 0, ((y) kVar).Oo(), ((y) kVar).Op(), "", new 11(this, kVar), null, new 13(this), new SecurityImage$b(this) {
                    final /* synthetic */ RegSetInfoUI xSg;

                    public final void cnJ() {
                        this.xSg.aWs();
                        String trim = this.xSg.xRJ.getText().toString().trim();
                        String trim2 = this.xSg.xRb.getText().toString().trim();
                        int e = this.xSg.com();
                        ar.CG().a(126, this.xSg);
                        k yVar = new y("", this.xSg.mzL, trim2, this.xSg.xRM, this.xSg.xRL, this.xSg.xRK, "", "", this.xSg.lcJ, e, trim, ((y) kVar2).Op(), "", this.xSg.xRQ, this.xSg.xQq);
                        yVar.mx(this.xSg.xOW);
                        yVar.is(this.xSg.xRT);
                        ar.CG().a(yVar, 0);
                    }
                });
                return;
            } else {
                this.xKa.a(0, ((y) kVar).Oo(), ((y) kVar).Op(), "");
                return;
            }
        }
        if (kVar.getType() == 429) {
            ar.CG().b(429, this);
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            this.lpy.setVisibility(8);
            if (i == 0 && i2 == 0) {
                this.xSa = null;
                VI = ((t.b) ((com.tencent.mm.modelfriend.x) kVar).hnp.Hp()).vBM.wnO;
                x.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", new Object[]{Integer.valueOf(VI)});
                if (VI == -14 || VI == -10 || VI == -7) {
                    LinkedList linkedList = ((t.b) ((com.tencent.mm.modelfriend.x) kVar).hnp.Hp()).vBM.ksP;
                    eA = com.tencent.mm.h.a.eA(str);
                    if (eA != null) {
                        this.xRO.setText(eA.desc);
                    }
                    this.xRU.clear();
                    if (linkedList != null && linkedList.size() > 0) {
                        int size = linkedList.size() > 3 ? 3 : linkedList.size();
                        String[] strArr = new String[size];
                        for (int i3 = 0; i3 < size; i3++) {
                            strArr[i3] = ((bdo) linkedList.get(i3)).wJF;
                            this.xRU.add(strArr[i3]);
                        }
                        if (this.xSe) {
                            if (this.xSc != null) {
                                this.xSc.dismiss();
                                this.xSc = null;
                            }
                            this.xSc = g.a(this, this.xSd, strArr, new 19(this, strArr));
                        }
                    }
                    S(true, true);
                    return;
                } else if (bh.ov(this.xRJ.getText().toString().trim())) {
                    S(false, false);
                    return;
                } else {
                    S(true, false);
                    this.xRO.setText(getString(R.l.eEq));
                    if (this.xSc != null) {
                        this.xSc.dismiss();
                        this.xSc = null;
                    }
                    this.xRJ.postDelayed(new Runnable(this) {
                        final /* synthetic */ RegSetInfoUI xSg;

                        {
                            this.xSg = r1;
                        }

                        public final void run() {
                            this.xSg.xRJ.clearFocus();
                            this.xSg.xRJ.requestFocus();
                        }
                    }, 50);
                    return;
                }
            } else if (i2 != -6 && i2 != -311 && i2 != -310) {
                S(true, true);
            } else if (this.xKa == null) {
                kVar2 = kVar;
                this.xKa = SecurityImage.a.a(this.mController.xIM, R.l.eEi, 0, ((com.tencent.mm.modelfriend.x) kVar).Oo(), ((com.tencent.mm.modelfriend.x) kVar).Op(), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegSetInfoUI xSg;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String trim = this.xSg.xRb.getText().toString().trim();
                        String trim2 = this.xSg.xRJ.getText().toString().trim();
                        if (trim == null || trim.length() <= 0) {
                            h.h(this.xSg, R.l.eSF, R.l.eDR);
                            return;
                        }
                        this.xSg.aWs();
                        int e = this.xSg.com();
                        String f = this.xSg.con();
                        ar.CG().a(429, this.xSg);
                        k xVar = new com.tencent.mm.modelfriend.x(f, this.xSg.lcJ, e, trim, trim2, ((com.tencent.mm.modelfriend.x) kVar2).Op(), this.xSg.xKa.coF());
                        ar.CG().a(xVar, 0);
                        RegSetInfoUI regSetInfoUI = this.xSg;
                        Context context = this.xSg;
                        this.xSg.getString(R.l.dGO);
                        regSetInfoUI.iln = h.a(context, this.xSg.getString(R.l.eEh), true, new 1(this, xVar));
                    }
                }, null, new 17(this), new 18(this, kVar));
                return;
            } else {
                this.xKa.a(0, ((com.tencent.mm.modelfriend.x) kVar).Oo(), ((com.tencent.mm.modelfriend.x) kVar).Op(), "");
                return;
            }
        }
        if (!o(i, i2, str)) {
            if (i == 8) {
                this.xSa = getString(R.l.eiD, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                Toast.makeText(this, this.xSa, 0).show();
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this, getString(R.l.eiZ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private boolean o(int i, int i2, String str) {
        if (this.xOK.a(this, new com.tencent.mm.pluginsdk.h.o(i, i2, str))) {
            return true;
        }
        if (com.tencent.mm.plugin.c.a.ift.a(this.mController.xIM, i, i2, str)) {
            return true;
        }
        switch (i2) {
            case -100:
                ar.hold();
                h.a(this.mController.xIM, TextUtils.isEmpty(ar.Ci()) ? com.tencent.mm.bv.a.ac(this.mController.xIM, R.l.euu) : ar.Ci(), this.mController.xIM.getString(R.l.dGO), new 20(this), new 21(this));
                return true;
            case -75:
                h.h(this, R.l.dDG, R.l.eCW);
                return true;
            case -48:
                com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                if (eA != null) {
                    eA.a(this, null, null);
                } else {
                    h.b(this, getString(R.l.eEp), "", true);
                }
                return true;
            case -10:
            case -7:
                h.h(this, R.l.eCV, R.l.eCW);
                return true;
            default:
                return false;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bov();
        return true;
    }

    private void bov() {
        aWs();
        if (coj()) {
            h.a((Context) this, getString(R.l.eEk), "", new 22(this), new 24(this));
        } else if (!cok()) {
            if ((this.sceneType == 0 ? 1 : null) != null) {
                h.a((Context) this, getString(R.l.eEj), "", new 25(this), new 26(this));
            } else if (col()) {
                h.a((Context) this, getString(R.l.eEj), "", new 27(this), new 28(this));
            } else {
                b.oH("R200_100");
                Intent intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 2);
                intent.addFlags(67108864);
                startActivity(intent);
                finish();
            }
        }
    }
}
