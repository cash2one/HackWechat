package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.address.b.b.a;
import com.tencent.mm.plugin.address.e.d;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.LinkedList;

public class InvoiceListUI extends MMActivity implements e {
    private boolean imJ = false;
    private TextView imy = null;
    private b ink;
    private a inl;
    private ListView inm;
    private a inn = null;
    private TextView ino = null;
    private LinkedList<b> inp = new LinkedList();
    private boolean inq = false;
    private boolean inr = false;
    private Object lockObj = new Object();

    static /* synthetic */ void a(InvoiceListUI invoiceListUI) {
        g.pQN.h(14199, new Object[]{Integer.valueOf(2)});
        invoiceListUI.jk(0);
    }

    static /* synthetic */ void b(InvoiceListUI invoiceListUI, b bVar) {
        if (bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (bVar.type != null && bVar.type.equals("0")) {
                if (!TextUtils.isEmpty(bVar.title)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqJ));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.title);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nBK)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqI));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nBK);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nBQ)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqv));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nBQ);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nBO)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqA));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nBO);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nBM)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqs));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nBM);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nBL)) {
                    stringBuilder.append(invoiceListUI.getString(R.l.cqt));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nBL);
                    stringBuilder.append(" \n");
                }
            } else if (!(bVar.type == null || !bVar.type.equals("1") || TextUtils.isEmpty(bVar.nBJ))) {
                stringBuilder.append(invoiceListUI.getString(R.l.cqJ));
                stringBuilder.append("：");
                stringBuilder.append(bVar.nBJ);
                stringBuilder.append(" \n");
            }
            try {
                d.I(invoiceListUI.mController.xIM, stringBuilder.toString());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.InvoiceListUI", e, "", new Object[0]);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.imJ = intent.getBooleanExtra("launch_from_webview", false);
        this.inq = intent.getBooleanExtra("launch_from_appbrand", false);
        if (this.imJ || this.inq) {
            this.imJ = true;
        }
        if (this.imJ) {
            ar.Hg();
            boolean booleanValue = ((Boolean) c.CU().get(w.a.xsn, Boolean.valueOf(true))).booleanValue();
            x.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog " + booleanValue);
            if (booleanValue) {
                x.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
                h.a((Context) this, getString(R.l.eqn), getString(R.l.eqo), getString(R.l.dBP), false, new 6(this));
                ar.Hg();
                c.CU().a(w.a.xsn, Boolean.valueOf(false));
            }
        }
        setMMTitle(R.l.eLY);
        ar.CG().a(1194, this);
        ar.CG().a(1191, this);
        initView();
        XQ();
    }

    public void onDestroy() {
        ar.CG().b(1194, this);
        ar.CG().b(1191, this);
        super.onDestroy();
    }

    public void onResume() {
        ar.CG().a(new com.tencent.mm.plugin.address.model.b(), 0);
        super.onResume();
    }

    private void XQ() {
        synchronized (this.lockObj) {
            com.tencent.mm.plugin.address.a.a.XE();
            this.inp = com.tencent.mm.plugin.address.a.a.XF().ilP.nBH;
            this.inl.hiv = this.inp;
            this.inp.size();
            this.inl.notifyDataSetChanged();
        }
    }

    public final void initView() {
        this.ino = (TextView) findViewById(R.h.cpI);
        if (this.ino != null) {
            this.ino.setVisibility(8);
        }
        if (this.imJ) {
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
        this.ino.setOnClickListener(new 1(this));
        this.inm = (ListView) findViewById(R.h.cMu);
        this.inl = new a(this, this);
        this.inm.setAdapter(this.inl);
        this.inm.setOnItemClickListener(new 2(this));
        this.inm.setOnItemLongClickListener(new 3(this));
        this.inl.notifyDataSetChanged();
        setBackBtn(new 4(this));
        addIconOptionMenu(0, R.l.eKS, R.k.duO, new 5(this));
    }

    protected final int getLayoutId() {
        return R.i.dlQ;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return;
        }
        if (kVar.getType() == 1191) {
            XQ();
            if (this.imJ) {
                com.tencent.mm.plugin.address.a.a.XE();
                if (com.tencent.mm.plugin.address.a.a.XF().ilP.nBH.size() == 0 && !this.inr) {
                    Intent intent = new Intent();
                    intent.setClass(this, AddInvoiceUI.class);
                    intent.putExtra("launch_from_webview", true);
                    startActivityForResult(intent, 1);
                }
            }
        } else if (kVar.getType() == 1194) {
            ar.CG().a(new com.tencent.mm.plugin.address.model.b(), 0);
            this.inr = true;
        }
    }

    private void jk(int i) {
        Intent intent = new Intent();
        if (i != 0) {
            intent.setClass(this, QrcodeInvoiceUI.class);
            intent.putExtra("invoice_id", i);
        } else {
            intent.setClass(this, AddInvoiceUI.class);
            intent.putExtra("launch_from_invoicelist_webview", this.imJ);
            intent.putExtra("invoice_id", i);
        }
        startActivity(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (-1 == i2) {
                b bVar;
                if (intent == null) {
                    x.e("MicroMsg.InvoiceUtil", "intent is null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.type = intent.getStringExtra(DownloadSettingTable$Columns.TYPE);
                    if (bVar.type == null || !bVar.type.equals("1")) {
                        bVar.title = intent.getStringExtra("title");
                        bVar.nBK = intent.getStringExtra("tax_number");
                        bVar.nBQ = intent.getStringExtra("company_address");
                        bVar.nBO = intent.getStringExtra("telephone");
                        bVar.nBM = intent.getStringExtra("bank_name");
                        bVar.nBL = intent.getStringExtra("bank_account");
                    } else {
                        bVar.nBJ = intent.getStringExtra("title");
                    }
                }
                Intent intent2 = new Intent();
                intent2.putExtra("choose_invoice_title_info", com.tencent.mm.plugin.address.e.e.a(bVar));
                setResult(-1, intent2);
            } else {
                setResult(0);
            }
            finish();
        }
    }
}
