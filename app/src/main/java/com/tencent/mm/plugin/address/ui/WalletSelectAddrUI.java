package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.az.k;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.address.c.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.e.d;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI extends MMActivity implements a {
    private boolean imJ = false;
    private ListView inm;
    private List<b> iod = new LinkedList();
    private b ioe;
    private a iof;
    private com.tencent.mm.plugin.address.c.b iog = null;
    private View ioh;
    private TextView ioi = null;
    private o ioj;
    private boolean iok = false;
    private i iol = null;
    private Object lockObj = new Object();

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI) {
        ar.Hg();
        String ou = bh.ou((String) c.CU().get(46, null));
        ar.Hg();
        String ou2 = bh.ou((String) c.CU().get(72, null));
        if (bh.ov(ou) && bh.ov(ou2)) {
            walletSelectAddrUI.XV();
        } else {
            walletSelectAddrUI.aH(ou, ou2);
        }
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI, b bVar) {
        if (bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(bVar.imp)) {
                stringBuilder.append(walletSelectAddrUI.getString(R.l.bJk));
                stringBuilder.append("：");
                stringBuilder.append(bVar.imp);
                stringBuilder.append(" \n");
            }
            if (!TextUtils.isEmpty(bVar.imq)) {
                stringBuilder.append(walletSelectAddrUI.getString(R.l.bJm));
                stringBuilder.append("：");
                stringBuilder.append(bVar.imq);
                stringBuilder.append(" \n");
            }
            stringBuilder.append(walletSelectAddrUI.getString(R.l.dDi));
            stringBuilder.append("：");
            if (!TextUtils.isEmpty(bVar.imk)) {
                stringBuilder.append(bVar.imk);
            }
            if (!TextUtils.isEmpty(bVar.iml)) {
                stringBuilder.append(bVar.iml);
            }
            if (!TextUtils.isEmpty(bVar.imm)) {
                stringBuilder.append(bVar.imm);
            }
            if (!TextUtils.isEmpty(bVar.imo)) {
                stringBuilder.append(bVar.imo);
            }
            if (!TextUtils.isEmpty(bVar.imn)) {
                stringBuilder.append(" \n");
                stringBuilder.append(walletSelectAddrUI.getString(R.l.dDf));
                stringBuilder.append("：");
                stringBuilder.append(bVar.imn);
            }
            try {
                d.I(walletSelectAddrUI.mController.xIM, stringBuilder.toString());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WalletSelectAddrUI", e, "", new Object[0]);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iog = new com.tencent.mm.plugin.address.c.b(this, this);
        Intent intent = getIntent();
        this.iok = intent.getBooleanExtra("launch_from_appbrand", false);
        if (intent.getBooleanExtra("launch_from_webview", false) || this.iok) {
            this.imJ = true;
            this.mController.contentView.setVisibility(8);
            if (this.iok) {
                getWindow().setBackgroundDrawableResource(R.e.btq);
            }
            x.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
            ar.Hg();
            if (((Boolean) c.CU().get(w.a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true))).booleanValue()) {
                x.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
                h.a(this, getString(R.l.dDj), getString(R.l.dDk), getString(R.l.dBP), new 1(this));
                ar.Hg();
                c.CU().a(w.a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(false));
            }
        }
        setMMTitle(R.l.dDi);
        this.iog.ji(417);
        this.iog.ji(416);
        this.iog.ji(419);
        this.iog.ji(582);
        this.iog.g(new e(intent.getStringExtra("req_url"), intent.getStringExtra("req_app_id"), 2));
        ar.Hg();
        this.ioj = new o(bh.a((Integer) c.CU().get(9, null), 0));
        initView();
        ar.Hg();
        if (c.isSDCardAvailable()) {
            ar.CG().a(new k(12), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.iog.jj(417);
        this.iog.jj(416);
        this.iog.jj(419);
        this.iog.jj(582);
    }

    public void onResume() {
        super.onResume();
        XQ();
    }

    private void XQ() {
        synchronized (this.lockObj) {
            com.tencent.mm.plugin.address.a.a.XE();
            this.iod = com.tencent.mm.plugin.address.a.a.XG().ima.imi;
            this.iof.hiv = this.iod;
            this.iod.size();
            this.ioh.setVisibility(8);
            this.iof.notifyDataSetChanged();
        }
    }

    public final void initView() {
        this.ioi = (TextView) findViewById(R.h.cpH);
        this.ioi.setVisibility(8);
        this.ioi.setOnClickListener(new 3(this));
        this.inm = (ListView) findViewById(R.h.cMt);
        this.iof = new a(this, this);
        this.ioh = findViewById(R.h.bIZ);
        this.ioh.findViewById(R.h.bJf).setVisibility(8);
        ((TextView) this.ioh.findViewById(R.h.bJl)).setText(R.l.dCG);
        this.inm.setAdapter(this.iof);
        this.inm.setOnItemClickListener(new 4(this));
        this.inm.setOnItemLongClickListener(new 5(this));
        XQ();
        this.ioh.setOnClickListener(new 6(this));
        this.iof.notifyDataSetChanged();
        setBackBtn(new 7(this));
        addIconOptionMenu(0, R.l.dCI, R.k.duO, new 8(this));
    }

    protected final int getLayoutId() {
        return R.i.dtT;
    }

    public final void e(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        this.iog.a(i, i2, str, kVar);
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 417) {
                if (((e) kVar).ilT) {
                    XQ();
                    this.mController.contentView.setVisibility(0);
                    if (this.imJ && this.iod.size() == 0) {
                        Intent intent = new Intent();
                        intent.setClass(this, WalletAddAddressUI.class);
                        startActivityForResult(intent, 1);
                    }
                }
            } else if (kVar.getType() == 416) {
                f fVar = (f) kVar;
                com.tencent.mm.plugin.address.a.a.XE();
                b jh = com.tencent.mm.plugin.address.a.a.XG().jh(fVar.ilU);
                if (jh != null) {
                    com.tencent.mm.plugin.address.a.a.XE();
                    x.d("MicroMsg.WalletSelectAddrUI", "delte addr " + com.tencent.mm.plugin.address.a.a.XG().a(jh));
                }
                XQ();
            } else if (kVar.getType() == 419) {
                if (this.ioe != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.ioe));
                    finish();
                }
            } else if (kVar.getType() == 582) {
                String string = getString(R.l.dDs);
                switch (((com.tencent.mm.plugin.address.model.d) kVar).status) {
                    case 0:
                        ar.Hg();
                        c.CU().set(196657, Boolean.valueOf(true));
                        this.ioi.setVisibility(8);
                        XQ();
                        this.mController.contentView.setVisibility(0);
                        string = getString(R.l.dDu);
                        break;
                    case 1:
                    case 2:
                        ar.Hg();
                        c.CU().set(196657, Boolean.valueOf(true));
                        this.ioi.setVisibility(8);
                        string = getString(R.l.dDt);
                        break;
                    case 3:
                        XV();
                        return;
                }
                if (this.iol != null) {
                    this.iol.dismiss();
                }
                this.iol = h.a(this, string, null, true, null);
            }
        } else if (kVar.getType() == 419 && i2 == -3103) {
            h.a(this, true, str, "", getString(R.l.dCM), getString(R.l.dEn), new OnClickListener(this) {
                final /* synthetic */ WalletSelectAddrUI iom;

                {
                    this.iom = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.iom.jn(this.iom.ioe.id);
                }
            }, new 2(this));
        }
    }

    private void aH(String str, String str2) {
        this.iog.g(new com.tencent.mm.plugin.address.model.d(str, str2, this.ioj));
    }

    private void XV() {
        com.tencent.mm.sdk.b.b jtVar = new jt();
        jtVar.fAD.fAF = this;
        jtVar.fAD.fAG = new 9(this, jtVar);
        com.tencent.mm.sdk.b.a.xef.a(jtVar, Looper.myLooper());
    }

    private void jn(int i) {
        Intent intent = new Intent();
        intent.setClass(this, WalletAddAddressUI.class);
        intent.putExtra("address_id", i);
        startActivity(intent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (-1 == i2) {
                b bVar;
                if (intent == null) {
                    x.e("MicroMsg.AddrUtil", "intent == null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.imr = intent.getStringExtra("nationalCode");
                    bVar.imp = intent.getStringExtra("userName");
                    bVar.imq = intent.getStringExtra("telNumber");
                    bVar.imn = intent.getStringExtra("addressPostalCode");
                    bVar.imk = intent.getStringExtra("proviceFirstStageName");
                    bVar.iml = intent.getStringExtra("addressCitySecondStageName");
                    bVar.imm = intent.getStringExtra("addressCountiesThirdStageName");
                    bVar.imo = intent.getStringExtra("addressDetailInfo");
                }
                setResult(-1, com.tencent.mm.plugin.address.e.a.b(bVar));
            } else {
                setResult(0);
            }
            finish();
        }
    }
}
