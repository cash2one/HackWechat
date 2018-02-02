package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.m;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileLoginOrForceReg;
import com.tencent.mm.ui.account.mobile.a;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import java.io.File;

public class RegByMobileSendSmsUI extends MMActivity implements e {
    private String bgo;
    private String frP;
    private ak iZb;
    private String mBX;
    private String xNI = "";
    private String xOW = "";
    private String xQM = "";
    private String xQN = "";
    private a xQO;
    private ProgressDialog xQP;
    private int xQQ;
    private Button xQR;
    private Button xQS;
    private int xQT = 15;
    private SecurityImage xQU;
    private boolean xQq;

    static /* synthetic */ void a(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        regByMobileSendSmsUI.xQS.setEnabled(false);
        if (regByMobileSendSmsUI.iZb != null) {
            regByMobileSendSmsUI.iZb.TG();
            regByMobileSendSmsUI.xQT = 15;
            regByMobileSendSmsUI.xQQ = 0;
            regByMobileSendSmsUI.iZb.J(0, 1000);
            return;
        }
        regByMobileSendSmsUI.iZb = new ak(new 7(regByMobileSendSmsUI), true);
        regByMobileSendSmsUI.iZb.J(0, 1000);
    }

    static /* synthetic */ void a(RegByMobileSendSmsUI regByMobileSendSmsUI, String str, String str2) {
        ar.CG().a(701, regByMobileSendSmsUI);
        regByMobileSendSmsUI.xQO = new a(new a.a(regByMobileSendSmsUI) {
            final /* synthetic */ RegByMobileSendSmsUI xQV;

            {
                this.xQV = r1;
            }

            public final void b(ProgressDialog progressDialog) {
                this.xQV.xQP = progressDialog;
            }
        }, str, str2, regByMobileSendSmsUI.xQM);
        regByMobileSendSmsUI.xQO.j(regByMobileSendSmsUI);
    }

    static /* synthetic */ void p(RegByMobileSendSmsUI regByMobileSendSmsUI) {
        regByMobileSendSmsUI.xQQ++;
        if (regByMobileSendSmsUI.xQQ <= 4) {
            k sVar = new s(regByMobileSendSmsUI.xQM, 15, "", 0, "");
            ((m.a) sVar.hnp.Kb()).vBu.vMl = 1;
            g.CG().a(sVar, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xQM = bh.ou(getIntent().getStringExtra("from_mobile"));
        this.xQN = bh.ou(getIntent().getStringExtra("to_mobile"));
        this.xNI = bh.ou(getIntent().getStringExtra("verify_code"));
        this.xOW = bh.ou(getIntent().getStringExtra("regsession_id"));
        this.bgo = bh.ou(getIntent().getStringExtra("kintent_nickname"));
        this.mBX = bh.ou(getIntent().getStringExtra("kintent_password"));
        this.xQq = getIntent().getBooleanExtra("kintent_hasavatar", false);
        initView();
    }

    protected final void initView() {
        super.initView();
        ((TextView) findViewById(R.h.cLx)).setText(getString(R.l.eDK, new Object[]{this.xQM}));
        ((TextView) findViewById(R.h.cLw)).setText(Yz(getString(R.l.eDJ, new Object[]{this.xNI})));
        ((TextView) findViewById(R.h.cLy)).setText(Yz(getString(R.l.eDM, new Object[]{this.xQN})));
        this.xQR = (Button) findViewById(R.h.cLv);
        this.xQS = (Button) findViewById(R.h.cnK);
        if (bh.G(new String[]{this.xQM, this.xQN, this.xNI})) {
            this.xQR.setEnabled(false);
            this.xQS.setEnabled(false);
        } else {
            this.xQS.setOnClickListener(new 1(this));
        }
        if (bh.ov(q.getSimCountryIso())) {
            this.xQR.setVisibility(8);
        } else {
            this.xQR.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RegByMobileSendSmsUI xQV;

                {
                    this.xQV = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("smsto:" + this.xQV.xQN));
                    intent.putExtra("sms_body", this.xQV.xNI);
                    try {
                        this.xQV.startActivity(intent);
                        this.xQV.overridePendingTransition(R.a.bqB, R.a.bqA);
                    } catch (Exception e) {
                        x.e("MicroMsg.RegByMobileSendSmsUI", e.getMessage());
                    }
                }
            });
        }
        setMMTitle(R.l.eDL);
        setBackBtn(new 10(this));
    }

    private j Yz(String str) {
        j jVar = new j(str);
        x.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", new Object[]{str});
        int indexOf = str.indexOf(32) + 1;
        jVar.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(R.f.bvu)), indexOf, str.length(), 33);
        jVar.setSpan(new ForegroundColorSpan(getResources().getColor(R.e.bsE)), indexOf, str.length(), 33);
        return jVar;
    }

    protected final int getLayoutId() {
        return R.i.dqE;
    }

    protected void onResume() {
        super.onResume();
        g.CG().a(c.CTRL_INDEX, this);
    }

    protected void onStop() {
        super.onStop();
        TG();
        g.CG().b(c.CTRL_INDEX, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.xQP != null) {
            this.xQP.dismiss();
        }
        Intent intent;
        com.tencent.mm.h.a eA;
        if (kVar.getType() == c.CTRL_INDEX && ((s) kVar).IS() == 15) {
            s sVar = (s) kVar;
            this.frP = sVar.NW();
            if (i2 == 0) {
                TG();
                if (com.tencent.mm.z.bh.HO().HP() > 0) {
                    ar.CG().a(126, this);
                    k yVar = new y("", this.mBX, this.bgo, 0, "", this.xQM, "", "", this.frP, 1, "", "", "", true, this.xQq);
                    yVar.mx(this.xOW);
                    yVar.is(1);
                    ar.CG().a(yVar, 0);
                    getString(R.l.dGO);
                    this.xQP = h.a(this, getString(R.l.eEh), true, new 11(this, yVar));
                    return;
                }
                intent = new Intent();
                intent.putExtra("regsetinfo_ticket", this.frP);
                intent.putExtra("regsetinfo_user", this.xQM);
                intent.putExtra("regsession_id", this.xOW);
                intent.putExtra("mobile_check_type", 1);
                intent.putExtra("regsetinfo_ismobile", 1);
                intent.putExtra("regsetinfo_NextControl", sVar.Oc());
                intent.setClass(this, RegSetInfoUI.class);
                startActivity(intent);
            } else if (i2 == -35) {
                TG();
                eA = com.tencent.mm.h.a.eA(str);
                if (eA != null) {
                    eA.a(this, new 12(this, sVar), new 13(this));
                    return;
                }
                h.a(this, getString(R.l.dKD), null, new 14(this, sVar), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RegByMobileSendSmsUI xQV;

                    {
                        this.xQV = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -212) {
                TG();
                intent = new Intent(this, MobileLoginOrForceReg.class);
                intent.putExtra("ticket", this.frP);
                intent.putExtra("moble", this.xQM);
                intent.putExtra("regsession_id", this.xOW);
                intent.putExtra("next_controll", sVar.Oc());
                intent.putExtra("username", sVar.getUsername());
                intent.putExtra("password", sVar.NV());
                intent.putExtra("nickname", sVar.Oj());
                intent.putExtra("avatar_url", sVar.Oi());
                intent.putExtra("mobile_check_type", 1);
                intent.putExtra("kintent_hasavatar", this.xQq);
                intent.putExtra("kintent_nickname", this.bgo);
                intent.putExtra("kintent_password", this.mBX);
                startActivity(intent);
            } else if (!bh.ov(str) && this.xQQ >= 4) {
                eA = com.tencent.mm.h.a.eA(str);
                if (eA != null && eA.a(this, null, null)) {
                }
            }
        } else if (kVar.getType() == 126) {
            final y yVar2 = (y) kVar;
            if (i2 == -6 || i2 == -311 || i2 == -310) {
                if (this.xQU == null) {
                    this.xQU = SecurityImage.a.a(this, R.l.eEi, 0, yVar2.Oo(), yVar2.Op(), "", new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ RegByMobileSendSmsUI xQV;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            k yVar = new y("", this.xQV.mBX, this.xQV.bgo, 0, "", this.xQV.xQM, "", "", this.xQV.frP, 1, "", yVar2.Op(), this.xQV.xQU.coF(), true, this.xQV.xQq);
                            yVar.mx(this.xQV.xOW);
                            yVar.is(1);
                            ar.CG().a(yVar, 0);
                            RegByMobileSendSmsUI regByMobileSendSmsUI = this.xQV;
                            Context context = this.xQV.mController.xIM;
                            this.xQV.getString(R.l.dGO);
                            regByMobileSendSmsUI.xQP = h.a(context, this.xQV.getString(R.l.eEh), true, new 1(this, yVar));
                        }
                    }, null, new 2(this), new 3(this, yVar2));
                } else {
                    this.xQU.a(0, ((y) kVar).Oo(), ((y) kVar).Op(), "");
                }
            } else if (i == 0 && i2 == 0) {
                final String str2 = this.xQM;
                ar.unhold();
                ar.by(true);
                if (this.xQq) {
                    String str3 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar";
                    String str4 = com.tencent.mm.compatible.util.e.gHB + "temp.avatar.hd";
                    new File(str3).renameTo(new File(str4));
                    b.deleteFile(str3);
                    d.b(str4, 96, 96, CompressFormat.JPEG, 90, str3);
                    new p(this, com.tencent.mm.compatible.util.e.gHB + "temp.avatar").a(new Runnable(this) {
                        final /* synthetic */ RegByMobileSendSmsUI xQV;

                        public final void run() {
                            this.xQV.frP = yVar2.Sh();
                            aq.hfP.S("login_user_name", str2);
                            b.deleteFile(com.tencent.mm.compatible.util.e.gHB + "temp.avatar");
                            Intent at = com.tencent.mm.plugin.c.a.ifs.at(this.xQV);
                            at.addFlags(67108864);
                            this.xQV.startActivity(at);
                            com.tencent.mm.plugin.c.b.oI(ar.CB() + "," + getClass().getName() + ",R200_600," + ar.fH("R200_600") + ",4");
                            this.xQV.finish();
                        }
                    }, new 5(this, yVar2, str2));
                    return;
                }
                this.frP = yVar2.Sh();
                aq.hfP.S("login_user_name", str2);
                intent = com.tencent.mm.plugin.c.a.ifs.at(this);
                intent.addFlags(67108864);
                intent.putExtra("LauncherUI.enter_from_reg", true);
                startActivity(intent);
                finish();
                com.tencent.mm.plugin.c.b.oH("RE900_100");
                com.tencent.mm.plugin.c.b.b(false, ar.CB() + "," + getClass().getName() + ",R200_600," + ar.fH("R200_600") + ",4");
            } else {
                eA = com.tencent.mm.h.a.eA(str);
                if (eA != null) {
                    eA.a(this, null, null);
                }
            }
        }
    }

    private void TG() {
        if (this.iZb != null) {
            this.iZb.TG();
        }
        this.xQS.setText(R.l.eDG);
        this.xQS.setEnabled(true);
    }

    private void goBack() {
        h.a(this, getString(R.l.eDI), "", new DialogInterface.OnClickListener(this) {
            final /* synthetic */ RegByMobileSendSmsUI xQV;

            {
                this.xQV = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.xQV.TG();
                this.xQV.finish();
            }
        }, null);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }
}
