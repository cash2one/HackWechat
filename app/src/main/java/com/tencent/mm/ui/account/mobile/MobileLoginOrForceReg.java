package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.pluginsdk.h.o;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.RegByMobileRegAIOUI;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.f;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import java.io.File;

public class MobileLoginOrForceReg extends MMActivity implements e {
    private String fAf;
    private String fIG;
    private String fpL;
    private String frP;
    private int hNU;
    private af handler = new 1(this);
    private ImageView iip;
    protected ProgressDialog iln = null;
    private String jiK;
    private TextView kBH;
    private String mzr;
    private String username;
    private String xJM;
    private SecurityImage xKa = null;
    private c xNR = new 12(this);
    private f xOA = null;
    private a xOK;
    private String xOW;
    private a xQO = null;
    private int xRT;
    private Button xUn;
    private Button xUo;
    private LinearLayout xUp;
    private LinearLayout xUq;
    private TextView xUr;
    private int xUs;
    private boolean xUt = true;
    private boolean xUu;
    private String xUv;
    private String xUw;

    static /* synthetic */ void l(MobileLoginOrForceReg mobileLoginOrForceReg) {
        k yVar = new y("", mobileLoginOrForceReg.xUw, mobileLoginOrForceReg.xUv, 0, "", mobileLoginOrForceReg.fAf, "", "", mobileLoginOrForceReg.frP, mobileLoginOrForceReg.hNU, "", "", "", true, mobileLoginOrForceReg.xUu);
        yVar.mx(mobileLoginOrForceReg.xOW);
        yVar.is(mobileLoginOrForceReg.xRT);
        ar.CG().a(yVar, 0);
        Context context = mobileLoginOrForceReg.mController.xIM;
        mobileLoginOrForceReg.getString(R.l.dGO);
        mobileLoginOrForceReg.iln = h.a(context, mobileLoginOrForceReg.getString(R.l.eEh), true, new 11(mobileLoginOrForceReg, yVar));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xJM = b.Xn();
        ar.CG().a(701, this);
        ar.CG().a(126, this);
        ar.CG().a(255, this);
        this.frP = getIntent().getStringExtra("ticket");
        this.fAf = getIntent().getStringExtra("moble");
        this.xUs = getIntent().getIntExtra("next_controll", 0);
        this.username = getIntent().getStringExtra("username");
        this.mzr = getIntent().getStringExtra("password");
        this.fpL = getIntent().getStringExtra("nickname");
        this.jiK = getIntent().getStringExtra("avatar_url");
        this.xOW = getIntent().getStringExtra("regsession_id");
        this.xRT = getIntent().getIntExtra("mobile_check_type", 0);
        this.xUu = getIntent().getBooleanExtra("kintent_hasavatar", false);
        this.xUv = getIntent().getStringExtra("kintent_nickname");
        this.xUw = getIntent().getStringExtra("kintent_password");
        if (this.xUw == null || this.xUw.length() < 8) {
            this.hNU = 4;
        } else {
            this.hNU = 1;
        }
        initView();
        this.xOK = new a();
    }

    public final void initView() {
        String De;
        CharSequence charSequence;
        this.xUn = (Button) findViewById(R.h.bYU);
        this.xUo = (Button) findViewById(R.h.cjb);
        this.xUp = (LinearLayout) findViewById(R.h.cof);
        this.xUq = (LinearLayout) findViewById(R.h.cAo);
        this.iip = (ImageView) findViewById(R.h.bLL);
        this.kBH = (TextView) findViewById(R.h.cAn);
        this.xUr = (TextView) findViewById(R.h.bNy);
        ao aoVar = new ao();
        if (this.fAf.startsWith("+")) {
            De = ao.De(this.fAf);
            if (bh.ov(De)) {
                charSequence = this.fAf;
            } else {
                charSequence = "+" + De + " " + ao.formatNumber(De, this.fAf.substring(De.length() + 1));
            }
        } else {
            charSequence = "+86 " + ao.formatNumber("86", this.fAf);
        }
        this.xUr.setText(charSequence);
        if (bh.ov(this.fpL) && bh.ov(this.jiK)) {
            this.xUq.setVisibility(0);
            this.xUp.setVisibility(8);
        } else {
            this.xUq.setVisibility(8);
            this.xUp.setVisibility(0);
            if (bh.ov(this.fpL)) {
                this.kBH.setVisibility(8);
            } else {
                this.kBH.setText(this.fpL);
            }
            Bitmap tJ = com.tencent.mm.pluginsdk.ui.a.b.bZV().tJ();
            if (tJ != null) {
                this.iip.setImageBitmap(tJ);
            }
            if (!bh.ov(this.jiK)) {
                De = this.jiK;
                ar.Dm().F(new Runnable(this) {
                    final /* synthetic */ MobileLoginOrForceReg xUx;

                    public final void run() {
                        Object obj = null;
                        try {
                            obj = d.decodeStream(com.tencent.mm.network.b.l(De, 10000, HardCoderJNI.sHCENCODEVIDEOTIMEOUT));
                        } catch (Throwable e) {
                            x.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
                            x.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", e, "", new Object[0]);
                        }
                        this.xUx.handler.sendMessage(this.xUx.handler.obtainMessage(0, obj));
                    }

                    public final String toString() {
                        return super.toString() + "|loadBitmap";
                    }
                });
            }
        }
        this.xUn.setOnClickListener(new 14(this));
        this.xUo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileLoginOrForceReg xUx;

            {
                this.xUx = r1;
            }

            public final void onClick(View view) {
                if (bh.ov(this.xUx.xUv)) {
                    Intent intent = new Intent();
                    b.oH("R200_900_phone");
                    intent.putExtra("regsetinfo_ticket", this.xUx.frP);
                    intent.putExtra("regsetinfo_user", this.xUx.fAf);
                    intent.putExtra("regsetinfo_ismobile", 1);
                    intent.putExtra("regsetinfo_isForce", true);
                    intent.putExtra("regsession_id", this.xUx.xOW);
                    intent.putExtra("regsetinfo_NextControl", this.xUx.xUs);
                    intent.putExtra("mobile_check_type", this.xUx.xRT);
                    intent.setClass(this.xUx, RegSetInfoUI.class);
                    this.xUx.startActivity(intent);
                    return;
                }
                MobileLoginOrForceReg.l(this.xUx);
            }
        });
        setMMTitle(R.l.evn);
        setBackBtn(new 16(this));
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.xef.b(this.xNR);
        super.onResume();
        b.oI(ar.CB() + "," + getClass().getName() + ",R200_600," + ar.fH("R200_600") + ",1");
        b.oG("R200_600");
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xef.c(this.xNR);
    }

    public void onDestroy() {
        ar.CG().b(701, this);
        ar.CG().b(126, this);
        ar.CG().b(255, this);
        if (this.xOK != null) {
            this.xOK.close();
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.don;
    }

    private void goBack() {
        Intent intent;
        b.oH("R200_100");
        if (com.tencent.mm.z.bh.HO().HP() > 0) {
            intent = new Intent(this, RegByMobileRegAIOUI.class);
        } else {
            intent = new Intent(this, MobileInputUI.class);
        }
        intent.putExtra("mobile_input_purpose", 2);
        intent.addFlags(67108864);
        startActivity(intent);
        b.oG(this.xJM);
        b.b(false, ar.CB() + "," + getClass().getName() + ",R200_600," + ar.fH("R200_600") + ",2");
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (this.xOA == null) {
            this.xOA = new f();
        }
        if (kVar.getType() == 255) {
            if (i != 0 || i2 != 0) {
                boolean z = this.xUt;
                Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", getString(R.l.eLU));
                intent.putExtra("kintent_cancelable", z);
                startActivityForResult(intent, 0);
            }
        } else if (kVar.getType() != 701 || this.xQO == null) {
            com.tencent.mm.h.a eA;
            Object obj;
            if (kVar.getType() == 126) {
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    final Boolean valueOf = Boolean.valueOf(this.xUu);
                    final String str2 = this.xUw;
                    final String str3 = this.xUv;
                    if (this.xKa == null) {
                        final k kVar2 = kVar;
                        final String str4 = str2;
                        final String str5 = str3;
                        final k kVar3 = kVar;
                        final Boolean bool = valueOf;
                        this.xKa = SecurityImage.a.a(this, R.l.eEi, 0, ((y) kVar).Oo(), ((y) kVar).Op(), "", new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg xUx;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                k yVar = new y("", str2, str3, 0, "", this.xUx.fAf, "", "", this.xUx.frP, this.xUx.hNU, "", ((y) kVar2).Op(), this.xUx.xKa.coF(), true, valueOf.booleanValue());
                                yVar.mx(this.xUx.xOW);
                                yVar.is(this.xUx.xRT);
                                ar.CG().a(yVar, 0);
                                MobileLoginOrForceReg mobileLoginOrForceReg = this.xUx;
                                Context context = this.xUx.mController.xIM;
                                this.xUx.getString(R.l.dGO);
                                mobileLoginOrForceReg.iln = h.a(context, this.xUx.getString(R.l.eEh), true, new 1(this, yVar));
                            }
                        }, null, new 3(this), new SecurityImage.b(this) {
                            final /* synthetic */ MobileLoginOrForceReg xUx;

                            public final void cnJ() {
                                this.xUx.aWs();
                                k yVar = new y("", str4, str5, 0, "", this.xUx.fAf, "", "", this.xUx.frP, this.xUx.hNU, "", ((y) kVar3).Op(), "", true, bool.booleanValue());
                                yVar.mx(this.xUx.xOW);
                                yVar.is(this.xUx.xRT);
                                ar.CG().a(yVar, 0);
                            }
                        });
                        return;
                    }
                    this.xKa.a(0, ((y) kVar).Oo(), ((y) kVar).Op(), "");
                    return;
                }
                if (i == 0 && i2 == 0) {
                    String str6 = this.fAf;
                    Boolean valueOf2 = Boolean.valueOf(this.xUu);
                    ar.unhold();
                    ar.by(true);
                    if (valueOf2.booleanValue()) {
                        String str7 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar";
                        String str8 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar.hd";
                        new File(str7).renameTo(new File(str8));
                        com.tencent.mm.loader.stub.b.deleteFile(str7);
                        d.b(str8, 96, 96, CompressFormat.JPEG, 90, str7);
                        new p(this, com.tencent.mm.compatible.util.e.gHB + "temp.avatar").a(new 5(this, kVar, str6), new 6(this, kVar, str6));
                    } else {
                        this.frP = ((y) kVar).Sh();
                        aq.hfP.S("login_user_name", str6);
                        Intent at = com.tencent.mm.plugin.c.a.ifs.at(this);
                        at.addFlags(67108864);
                        at.putExtra("LauncherUI.enter_from_reg", true);
                        startActivity(at);
                        finish();
                        b.oH("RE900_100");
                        b.b(false, ar.CB() + "," + getClass().getName() + ",R200_600," + ar.fH("R200_600") + ",4");
                    }
                }
                eA = com.tencent.mm.h.a.eA(str);
                if (eA != null) {
                    eA.a(this, null, null);
                    return;
                }
            }
            if (!this.xOK.a(this, new o(i, i2, str))) {
                obj = null;
                switch (i2) {
                    case -140:
                        if (!bh.ov(this.fIG)) {
                            m.j(this.mController.xIM, str, this.fIG);
                        }
                        obj = 1;
                        break;
                    case -100:
                        ar.hold();
                        h.a(this.mController.xIM, TextUtils.isEmpty(ar.Ci()) ? com.tencent.mm.bv.a.ac(this.mController.xIM, R.l.euu) : ar.Ci(), this.mController.xIM.getString(R.l.dGO), new 9(this), new 10(this));
                        obj = 1;
                        break;
                    case -75:
                        h.h(this, R.l.dDG, R.l.eCW);
                        obj = 1;
                        break;
                    case -43:
                        Toast.makeText(this, R.l.dKQ, 0).show();
                        obj = 1;
                        break;
                    case -41:
                        Toast.makeText(this, R.l.dKS, 0).show();
                        obj = 1;
                        break;
                    case -36:
                        Toast.makeText(this, R.l.dKV, 0).show();
                        obj = 1;
                        break;
                    case -34:
                        Toast.makeText(this, R.l.dKT, 0).show();
                        obj = 1;
                        break;
                    case -33:
                        h.a(this, R.l.dLA, R.l.bNB, new 8(this));
                        obj = 1;
                        break;
                    case -32:
                        h.a(this, getString(R.l.dLC), "", new 7(this));
                        obj = 1;
                        break;
                    default:
                        break;
                }
            }
            obj = 1;
            if (obj == null) {
                if (kVar.getType() == 701) {
                    eA = com.tencent.mm.h.a.eA(str);
                    if (eA != null && eA.a(this.mController.xIM, null, null)) {
                        return;
                    }
                }
                if (i != 0 || i2 != 0) {
                    Toast.makeText(this.mController.xIM, getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else if (i2 == -6 || i2 == -311 || i2 == -310) {
            this.xOA.hNv = this.username;
            this.xOA.xPp = this.xUw;
            this.xOA.xPq = ((v) kVar).Op();
            this.xOA.xPs = ((v) kVar).Oo();
            this.xOA.xPr = ((v) kVar).Sa();
            this.xOA.xPt = ((v) kVar).RZ();
            if (this.xKa == null) {
                this.xKa = SecurityImage.a.a(this, R.l.eEi, this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ MobileLoginOrForceReg xUx;

                    {
                        this.xUx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + this.xUx.xOA.xPq + " img len" + this.xUx.xOA.xPs.length + " " + g.zh());
                        k vVar = new v(this.xUx.xOA.hNv, this.xUx.xOA.xPp, this.xUx.xOA.xPt, this.xUx.xKa.coF(), this.xUx.xKa.xPq, this.xUx.xKa.xPr, 1, "", false, true);
                        ar.CG().a(vVar, 0);
                        Context context = this.xUx;
                        this.xUx.getString(R.l.dGO);
                        h.a(context, this.xUx.getString(R.l.etF), true, new 1(this, vVar));
                    }
                }, null, new 18(this), this.xOA);
            } else {
                this.xKa.a(this.xOA.xPt, this.xOA.xPs, this.xOA.xPq, this.xOA.xPr);
            }
        } else {
            this.fIG = ((v) kVar).RY();
            this.xQO.a(this, i, i2, str, kVar);
            if (kVar instanceof v) {
                this.xUt = ((v) kVar).Sg();
            }
            if (i == 0 && i2 == 0) {
                k xVar = new com.tencent.mm.modelsimple.x(1);
                ar.CG().a(xVar, 0);
                getString(R.l.dGO);
                this.iln = h.a(this, getString(R.l.eLF), true, new 19(this, xVar));
            }
        }
    }
}
