package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ipcall.a.d.b;
import com.tencent.mm.plugin.ipcall.a.d.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bwo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

@a(3)
public class IPCallDialUI extends MMActivity implements e, b.a {
    private TextView iiQ;
    private DialPad nHd;
    private TextView nHe;
    private EditText nHf;
    private View nHg;
    private ImageButton nHh;
    private View nHi;
    private TextView nHj;
    private TextView nHk;
    private String nJA;
    private String nJB;
    private String nJC;
    private int nJD = 0;
    private int nJE = 0;
    private int nJF = -1;
    private LinkedList<bwo> nJG;
    b nJH;
    c nJI;
    private com.tencent.mm.sdk.b.c nJJ = new 2(this);
    private b nJy;
    private String nJz;
    private String nlp;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xef.b(this.nJJ);
        ar.CG().a(807, this);
        ar.CG().a(746, this);
        getWindow().addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        setBackBtn(new 1(this), R.k.byB);
        this.nlp = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.nJz = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.nJA = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.nJB = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.nJC = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.nJD = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        x.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", new Object[]{this.nlp, this.nJz, this.nJA, this.nJB, this.nJC, Integer.valueOf(this.nJD)});
        if (!bh.ov(this.nJz)) {
            this.nJz = com.tencent.mm.plugin.ipcall.b.c.Dm(this.nJz);
        }
        if (bh.ov(this.nJB)) {
            if (com.tencent.mm.plugin.ipcall.b.a.Dg(this.nJz)) {
                if (bh.ov(com.tencent.mm.plugin.ipcall.b.a.De(this.nJz))) {
                    this.nJz = com.tencent.mm.plugin.ipcall.b.a.Dh(this.nJz);
                } else {
                    x.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
                    this.nJE = 4;
                    Intent intent = new Intent(this, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_contactId", this.nJA);
                    intent.putExtra("IPCallTalkUI_countryCode", this.nJB);
                    intent.putExtra("IPCallTalkUI_nickname", this.nlp);
                    intent.putExtra("IPCallTalkUI_phoneNumber", this.nJz);
                    intent.putExtra("IPCallTalkUI_dialScene", this.nJD);
                    intent.putExtra("IPCallTalkUI_countryType", this.nJE);
                    startActivityForResult(intent, 1001);
                    finish();
                    return;
                }
            }
            this.nJB = com.tencent.mm.plugin.ipcall.b.c.aUO();
        }
        if (this.nJD != 1) {
            this.nJF = 0;
            this.nJE = 3;
            this.nJH = new b(this.nJz, this.nJB, "", bh.cgv(), this.nJD);
            ar.CG().a(this.nJH, 0);
        } else {
            this.nJF = -1;
            this.nJE = 4;
        }
        init();
    }

    public void onStart() {
        super.onStart();
        this.nJI = new c();
        ar.CG().a(this.nJI, 0);
    }

    protected void onResume() {
        x.d("MicroMsg.IPCallDialUI", "onResume");
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.dmb;
    }

    private void init() {
        x.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), bh.cgy()});
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            setMMTitle(R.l.eqB);
            setVolumeControlStream(1);
            this.nHd = (DialPad) findViewById(R.h.cbT);
            this.nHe = (TextView) findViewById(R.h.bZe);
            this.nHi = findViewById(R.h.bZc);
            this.nHf = (EditText) findViewById(R.h.cCu);
            this.nHg = findViewById(R.h.cCt);
            this.iiQ = (TextView) findViewById(R.h.cbV);
            this.nHh = (ImageButton) findViewById(R.h.cbD);
            this.nHj = (TextView) findViewById(R.h.bZg);
            this.nHk = (TextView) findViewById(R.h.cbG);
            this.nJy = new b(this, this.nHf, this.nHe, this.nHg, this.nHd, this.nHh, this.iiQ, this.nHi, this.nHj, this.nHk);
            this.nJy.nHc = this;
            if (!bh.ov(this.nJz)) {
                this.nJy.bv(this.nJz, -1);
            }
            if (!bh.ov(this.nJB)) {
                this.nJy.CK(this.nJB);
            }
            if (!(bh.ov(this.nJz) || bh.ov(this.nJB))) {
                this.nJy.aUl();
            }
            this.nJy.W(this.nJG);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        b bVar = this.nJy;
        x.d("MicroMsg.DialPadController", "onActivityResult");
        if (i == 100 && i2 == 100) {
            String az = bh.az(intent.getStringExtra("country_name"), "");
            String az2 = bh.az(intent.getStringExtra("couttry_code"), "");
            x.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", new Object[]{az2, az});
            if (!bh.ov(az2) && !bh.ov(az)) {
                bVar.nHm = az;
                bVar.nHn = "+" + az2;
                bVar.nHe.setText(bVar.nHn);
                bVar.nHo = bVar.cW(az2.replace("+", ""), bVar.nHo);
                bVar.bv(bVar.nHo, -1);
                bVar.nHs = false;
            }
        } else if (i == 1001 && i2 == -1) {
            intent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
            bVar.fmM.setResult(-1, intent);
            bVar.fmM.finish();
        }
    }

    public final void i(String str, String str2, String str3, String str4) {
        x.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", new Object[]{str, str2, str3, str4});
        if (!com.tencent.mm.plugin.ipcall.b.c.cX(this)) {
            return;
        }
        if (com.tencent.mm.plugin.ipcall.a.c.aTj().rq(bh.getInt(str, -1))) {
            h.b(this, getString(R.l.dNk), getString(R.l.dNl), true);
            g.pQN.k(12058, str);
            return;
        }
        g.pQN.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        Intent intent = new Intent(this, IPCallTalkUI.class);
        intent.putExtra("IPCallTalkUI_contactId", str3);
        intent.putExtra("IPCallTalkUI_countryCode", str);
        intent.putExtra("IPCallTalkUI_nickname", str4);
        intent.putExtra("IPCallTalkUI_phoneNumber", str2);
        intent.putExtra("IPCallTalkUI_dialScene", this.nJD);
        intent.putExtra("IPCallTalkUI_countryType", this.nJE);
        startActivityForResult(intent, 1001);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.nJy != null) {
            this.nJy.nHc = null;
        }
        com.tencent.mm.sdk.b.a.xef.c(this.nJJ);
        ar.CG().b(807, this);
        ar.CG().b(746, this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.IPCallDialUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    init();
                    return;
                } else {
                    h.a(this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 3(this), new 4(this));
                    return;
                }
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            if (i == 0 && i2 == 0 && kVar == this.nJH) {
                if (this.nJH.nFr != null) {
                    x.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", new Object[]{Integer.valueOf(this.nJH.nFr.vVT), this.nJH.nFr.wFt, this.nJH.nFr.nOu});
                }
                if (this.nJF != 2) {
                    this.nJF = 1;
                    this.nJE = 1;
                    b bVar = this.nJH;
                    int i3 = (bVar.nFr == null || bVar.nFr.vVT != 2) ? 0 : 1;
                    if (i3 != 0) {
                        x.i("MicroMsg.IPCallDialUI", "check error show error dialog");
                        return;
                    }
                    bVar = this.nJH;
                    i3 = (bVar.nFr == null || !(bVar.nFr.vVT == 1 || bVar.nFr.vVT == 0)) ? 0 : 1;
                    if (i3 != 0) {
                        if (this.nJH.nFr == null || bh.ov(this.nJH.nFr.nOu)) {
                            x.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
                        } else if (this.nJy != null) {
                            x.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", new Object[]{this.nJH.nFr.nOu, this.nJB});
                            this.nJB = this.nJH.nFr.nOu;
                            this.nJy.CK(this.nJH.nFr.nOu);
                        }
                    }
                    if (this.nJH.nFr != null && !bh.ov(this.nJH.nFr.wFt) && this.nJy != null) {
                        x.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", new Object[]{this.nJH.nFr.wFt, this.nJz});
                        this.nJz = this.nJH.nFr.wFt;
                        this.nJy.bv(this.nJH.nFr.wFt, -1);
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
            }
        } else if (kVar instanceof c) {
            if (i == 0 && i2 == 0) {
                this.nJG = ((c) kVar).nFt.wpf;
            } else {
                this.nJG = null;
            }
            if (this.nJy != null) {
                this.nJy.W(this.nJG);
            }
        }
    }

    public final void CL(String str) {
        x.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", new Object[]{str, this.nJB});
        if (this.nJF != 2 && this.nJF != -1 && !this.nJB.equals(str)) {
            aUv();
        }
    }

    public final void CM(String str) {
        x.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", new Object[]{str, this.nJz});
        if (this.nJF != 2 && this.nJF != -1 && !this.nJz.equals(str)) {
            aUv();
        }
    }

    private void aUv() {
        x.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
        this.nJF = 2;
        if (this.nJE == 1) {
            this.nJE = 2;
        } else {
            this.nJE = 4;
        }
    }
}
