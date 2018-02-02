package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.plugin.address.ui.InvoiceEditView.a;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.protocal.c.ajk;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public class AddInvoiceUI extends MMActivity implements e, a {
    private int JI = 0;
    private String fDW = "";
    private Dialog ilS = null;
    private InvoiceEditView imA;
    private InvoiceEditView imB;
    private InvoiceEditView imC;
    private InvoiceEditView imD;
    private InvoiceEditView imE;
    private InvoiceEditView imF;
    private InvoiceEditView imG;
    private b imH = null;
    private b imI = new b();
    private boolean imJ = false;
    private boolean imK = false;
    private int ims = 0;
    private Button imt = null;
    private Button imu = null;
    private TextView imv;
    private TextView imw;
    private TextView imx;
    private TextView imy = null;
    private InvoiceEditView imz;

    static /* synthetic */ void o(AddInvoiceUI addInvoiceUI) {
        ar.CG().a(new i(addInvoiceUI.imI), 0);
        ar.CG().a(1180, addInvoiceUI);
        if (addInvoiceUI.ims != 0) {
            x.i("MicroMsg.AddInvoiceUI", "modify save invoice " + addInvoiceUI.imI.toString());
        }
        addInvoiceUI.ilS = h.a(addInvoiceUI, "", true, null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.imJ = intent.getBooleanExtra("launch_from_webview", false);
        this.imK = intent.getBooleanExtra("launch_from_invoicelist_webview", false);
        ar.CG().a(1191, this);
        x.d("MicroMsg.AddInvoiceUI", "index Oncreate");
        this.imI = new b();
        this.ims = getIntent().getIntExtra("invoice_id", 0);
        if (this.ims == 0) {
            setMMTitle(R.l.eKS);
        } else {
            setMMTitle(R.l.eLQ);
        }
        initView();
    }

    public final void initView() {
        this.JI = 0;
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.h.cqH);
        if (mMScrollView != null) {
            mMScrollView.a(mMScrollView, mMScrollView);
        }
        this.imt = (Button) findViewById(R.h.cqy);
        if (this.imt != null) {
            this.imt.setVisibility(0);
        }
        this.imu = (Button) findViewById(R.h.cqw);
        if (this.imu != null) {
            this.imu.setVisibility(0);
        }
        if (this.ims == 0 && this.imu != null) {
            this.imu.setActivated(true);
        }
        if (this.imu != null) {
            this.imu.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ AddInvoiceUI imL;

                {
                    this.imL = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        return true;
                    }
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    if (!this.imL.imu.isActivated()) {
                        this.imL.imu.setActivated(true);
                    }
                    if (this.imL.imu.isActivated()) {
                        this.imL.imt.setActivated(false);
                        this.imL.imI.type = "0";
                    }
                    this.imL.XK();
                    return true;
                }
            });
        }
        if (this.imt != null) {
            this.imt.setOnTouchListener(new 2(this));
        }
        this.imz = (InvoiceEditView) findViewById(R.h.cqK);
        this.imA = (InvoiceEditView) findViewById(R.h.cqJ);
        this.imB = (InvoiceEditView) findViewById(R.h.cqz);
        this.imC = (InvoiceEditView) findViewById(R.h.cqI);
        this.imD = (InvoiceEditView) findViewById(R.h.cqv);
        this.imE = (InvoiceEditView) findViewById(R.h.cqA);
        this.imF = (InvoiceEditView) findViewById(R.h.cqs);
        this.imG = (InvoiceEditView) findViewById(R.h.cqt);
        this.imC.inf = true;
        this.imC.imY = true;
        this.imC.ing = this;
        this.imz.ing = this;
        this.imA.ing = this;
        this.imB.ing = this;
        this.imD.ing = this;
        this.imE.ing = this;
        this.imF.ing = this;
        this.imG.ing = this;
        if (this.ims != 0) {
            this.imw = (TextView) findViewById(R.h.cRV);
            this.imw.setVisibility(8);
            this.imx = (TextView) findViewById(R.h.cTC);
            this.imH = com.tencent.mm.plugin.address.a.a.XF().jg(this.ims);
            if (this.imH != null && this.imH.type != null && this.imH.type.equals("0")) {
                this.imx.setText(getString(R.l.eqh));
            } else if (!(this.imH == null || this.imH.type == null || !this.imH.type.equals("1"))) {
                this.imx.setText(getString(R.l.eqj));
            }
            this.imx.setVisibility(0);
            this.imu.setVisibility(8);
            this.imt.setVisibility(8);
            if (this.imH != null) {
                this.imz.oO(this.imH.type);
                this.imA.oO(this.imH.title);
                this.imB.oO(this.imH.nBJ);
                this.imC.oO(this.imH.nBK);
                this.imD.oO(this.imH.nBQ);
                this.imE.oO(this.imH.nBO);
                this.imF.oO(this.imH.nBM);
                this.imG.oO(this.imH.nBL);
            }
        }
        if (this.imK || this.imJ) {
            this.imy = (TextView) findViewById(R.h.cse);
            if (this.imy != null) {
                this.imy.setVisibility(0);
            }
        } else {
            this.imy = (TextView) findViewById(R.h.cse);
            if (this.imy != null) {
                this.imy.setVisibility(8);
            }
        }
        setBackBtn(new 3(this));
        a(0, getString(R.l.dGx), new 4(this), p.b.xJz);
        enableOptionMenu(false);
        XK();
    }

    public void onDestroy() {
        ar.CG().b(1180, this);
        ar.CG().b(1191, this);
        getWindow().setSoftInputMode(3);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!bh.ov(stringExtra)) {
                        x.d("MicroMsg.AddInvoiceUI", "AREA_RESULT:" + stringExtra);
                        this.imE.oO(stringExtra);
                    }
                    stringExtra = intent.getStringExtra("kpost_code");
                    if (!bh.ov(stringExtra)) {
                        x.d("MicroMsg.AddInvoiceUI", "post:" + stringExtra);
                        this.imE.oO(stringExtra);
                    }
                    this.fDW = intent.getStringExtra("kwcode");
                    return;
                }
                return;
            case 3:
                if (i2 != -1) {
                    x.i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dnl;
    }

    public final void a(int i, int i2, String str, k kVar) {
        Intent intent = null;
        x.i("MicroMsg.AddInvoiceUI", "errType " + i + ",errCode " + i2 + ",errMsg " + str);
        if (this.ilS != null) {
            this.ilS.dismiss();
        }
        if (i != 0 || i2 != 0) {
            h.a(this, getString(R.l.eqm), getString(R.l.dGO), false, null);
        } else if (kVar.getType() == 1180) {
            bdu com_tencent_mm_protocal_c_bdu = ((i) kVar).ilV;
            if (!(com_tencent_mm_protocal_c_bdu == null || com_tencent_mm_protocal_c_bdu.wJJ == null || com_tencent_mm_protocal_c_bdu.wJJ.size() <= 0 || com_tencent_mm_protocal_c_bdu.wJJ.get(0) == null)) {
                this.JI = ((ajk) com_tencent_mm_protocal_c_bdu.wJJ.get(0)).vYZ;
            }
            ar.CG().b(1180, this);
            ar.CG().a(new com.tencent.mm.plugin.address.model.b(), 0);
        } else if (kVar.getType() == 1191) {
            ar.CG().b(1191, this);
            if (this.imJ) {
                x.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
                b bVar = this.imI;
                if (bVar == null) {
                    x.e("MicroMsg.InvoiceUtil", "invoiceObj == null");
                } else {
                    intent = new Intent();
                    intent.putExtra(DownloadSettingTable$Columns.TYPE, bVar.type);
                    if (bVar.type == null || !bVar.type.equals("1")) {
                        intent.putExtra("title", bVar.title);
                        intent.putExtra("tax_number", bVar.nBK);
                        intent.putExtra("company_address", bVar.nBQ);
                        intent.putExtra("telephone", bVar.nBO);
                        intent.putExtra("bank_name", bVar.nBM);
                        intent.putExtra("bank_account", bVar.nBL);
                    } else {
                        intent.putExtra("title", bVar.nBJ);
                    }
                }
                setResult(-1, intent);
                finish();
                return;
            }
            if (this.ims == 0 && this.JI != 0) {
                intent = new Intent();
                intent.setClass(this, QrcodeInvoiceUI.class);
                intent.putExtra("invoice_id", this.JI);
                startActivity(intent);
                this.JI = 0;
            }
            finish();
        }
    }

    private boolean XK() {
        boolean z = true;
        if ((this.imu != null && this.imu.isActivated()) || (this.imH != null && this.imH.type != null && this.imH.type.equals("0"))) {
            boolean z2;
            this.imC.setVisibility(0);
            this.imD.setVisibility(0);
            this.imE.setVisibility(0);
            this.imF.setVisibility(0);
            this.imG.setVisibility(0);
            this.imA.setVisibility(0);
            this.imB.setVisibility(8);
            if (!(this.imu.isActivated() || this.imH.type.equals("0"))) {
                z = false;
            }
            if (!this.imA.XO()) {
                if (this.imA.getText().length() > 100) {
                    ac(getString(R.l.cqJ), 100);
                }
                z = false;
            }
            if (this.imu != null && this.imu.isActivated() && this.imA.getText().length() == 0) {
                z2 = false;
            } else {
                z2 = z;
            }
            enableOptionMenu(z2);
            if (this.imC.XO()) {
                if (this.imv != null) {
                    this.imv.setVisibility(8);
                }
            } else if (this.imC.getText().length() > 0) {
                ViewStub viewStub = (ViewStub) findViewById(R.h.cVZ);
                if (viewStub != null) {
                    viewStub.inflate();
                    this.imv = (TextView) findViewById(R.h.cVY);
                }
                if (this.imv != null) {
                    this.imv.setVisibility(0);
                }
            }
            if (!this.imD.XO()) {
                if (this.imD.getText().length() > 100) {
                    ac(getString(R.l.cqv), 100);
                }
                z2 = false;
            }
            if (!this.imE.XO()) {
                if (this.imE.getText().length() > 100) {
                    ac(getString(R.l.cqA), 100);
                }
                z2 = false;
            }
            if (!this.imF.XO()) {
                if (this.imF.getText().length() > 100) {
                    ac(getString(R.l.cqs), 100);
                }
                z2 = false;
            }
            if (this.imG.XO()) {
                return z2;
            }
            if (this.imG.getText().length() <= 48) {
                return false;
            }
            ac(getString(R.l.cqt), 39);
            return false;
        } else if ((this.imt == null || !this.imt.isActivated()) && (this.imH == null || this.imH.type == null || !this.imH.type.equals("1"))) {
            this.imC.setVisibility(0);
            this.imD.setVisibility(0);
            this.imE.setVisibility(0);
            this.imF.setVisibility(0);
            this.imG.setVisibility(0);
            this.imB.setVisibility(8);
            this.imA.setVisibility(0);
            this.imB.setVisibility(8);
            if (!(this.imt == null || this.imt.isActivated() || this.imu == null || this.imu.isActivated())) {
                z = false;
            }
            if (!this.imA.XO()) {
                z = false;
            }
            if (!this.imC.XO()) {
                z = false;
            }
            if (!this.imD.XO()) {
                z = false;
            }
            if (!this.imE.XO()) {
                z = false;
            }
            if (!this.imF.XO()) {
                z = false;
            }
            if (this.imG.XO()) {
                return z;
            }
            return false;
        } else {
            this.imC.setVisibility(8);
            this.imD.setVisibility(8);
            this.imE.setVisibility(8);
            this.imF.setVisibility(8);
            this.imG.setVisibility(8);
            this.imA.setVisibility(8);
            this.imB.setVisibility(0);
            if (!(this.imt.isActivated() || this.imH.type.equals("1"))) {
                z = false;
            }
            if (!this.imB.XO()) {
                if (this.imB.getText().length() > 100) {
                    ac(getString(R.l.cqJ), 100);
                }
                z = false;
            }
            if (this.imt != null && this.imt.isActivated() && this.imB.getText().length() == 0) {
                z = false;
            }
            enableOptionMenu(z);
            return z;
        }
    }

    public final void XL() {
        XK();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        XM();
        return true;
    }

    private void XM() {
        boolean z;
        boolean z2 = true;
        if ((this.ims == 0 || this.imH == null || this.imI.type == null || this.imI.type.equals("") || this.imI.type.equals(this.imH.type)) && (this.ims != 0 || this.imI.type == null || this.imI.type.equals(""))) {
            z = false;
        } else {
            z = true;
        }
        if (!(this.imt == null || this.imu == null || this.imt.isActivated() || this.imu.isActivated() || this.imH != null)) {
            z = true;
        }
        if (this.imA.XP()) {
            z = true;
        }
        if (this.imB.XP()) {
            z = true;
        }
        if (this.imC.XP()) {
            z = true;
        }
        if (this.imD.XP()) {
            z = true;
        }
        if (this.imE.XP()) {
            z = true;
        }
        if (this.imF.XP()) {
            z = true;
        }
        if (!this.imG.XP()) {
            z2 = z;
        }
        if (z2) {
            h.a(this, false, this.mController.xIM.getString(R.l.eqc), "", this.mController.xIM.getString(R.l.eqb), this.mController.xIM.getString(R.l.eqa), new 5(this), null);
            return;
        }
        setResult(0);
        finish();
    }

    private void ac(String str, int i) {
        h.a(this, getString(R.l.eqe, new Object[]{str, Integer.valueOf(i)}), getString(R.l.dGO), false, null);
    }

    public final void XN() {
        h.a(this, getString(R.l.eqp), getString(R.l.dGO), false, null);
    }
}
