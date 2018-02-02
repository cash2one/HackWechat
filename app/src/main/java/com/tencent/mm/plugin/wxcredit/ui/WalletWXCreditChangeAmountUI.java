package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI extends WalletBaseUI implements OnClickListener {
    private List<l> tZD;
    private List<l> tZE = new ArrayList();
    private l tZF;
    private l tZG;
    private int tZH = -1;
    private boolean tZI;
    private boolean tZJ;
    private TextView tZK;
    private TextView tZL;
    private TextView tZM;
    private TextView tZN;
    private TextView tZO;
    private TextView tZP;
    private EditText tZQ;
    private EditText tZR;
    private EditText tZS;
    private EditText tZT;
    private BaseAdapter tZU = new BaseAdapter(this) {
        final /* synthetic */ WalletWXCreditChangeAmountUI tZW;

        {
            this.tZW = r1;
        }

        public final /* synthetic */ Object getItem(int i) {
            return Bx(i);
        }

        public final int getCount() {
            return this.tZW.tZE != null ? this.tZW.tZE.size() : 0;
        }

        private l Bx(int i) {
            return (l) this.tZW.tZE.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.tZW, g.uFe, null);
            l Bx = Bx(i);
            checkedTextView.setText(Bx.desc);
            checkedTextView.setChecked(Bx.tZu != 0);
            return checkedTextView;
        }
    };
    private BaseAdapter tZV = new 2(this);

    static /* synthetic */ void a(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        walletWXCreditChangeAmountUI.tZE.clear();
        if (walletWXCreditChangeAmountUI.tZI) {
            for (l lVar : walletWXCreditChangeAmountUI.tZD) {
                if (lVar.tZu != 2) {
                    walletWXCreditChangeAmountUI.tZE.add(lVar);
                }
            }
            return;
        }
        for (l lVar2 : walletWXCreditChangeAmountUI.tZD) {
            if (lVar2.tZu != 1) {
                walletWXCreditChangeAmountUI.tZE.add(lVar2);
            }
        }
    }

    static /* synthetic */ boolean b(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        if (walletWXCreditChangeAmountUI.tZF == null || walletWXCreditChangeAmountUI.tZG == null) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.tZQ.getVisibility() == 0 && bh.ov(walletWXCreditChangeAmountUI.tZQ.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.tZR.getVisibility() == 0 && bh.ov(walletWXCreditChangeAmountUI.tZR.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.tZO.getVisibility() == 0 && bh.ov(walletWXCreditChangeAmountUI.tZO.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.tZS.getVisibility() == 0 && bh.ov(walletWXCreditChangeAmountUI.tZS.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.tZT.getVisibility() == 0 && bh.ov(walletWXCreditChangeAmountUI.tZT.getText().toString())) {
            return false;
        }
        return (walletWXCreditChangeAmountUI.tZP.getVisibility() == 0 && bh.ov(walletWXCreditChangeAmountUI.tZP.getText().toString())) ? false : true;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        View inflate;
        ListViewInScrollView listViewInScrollView;
        a aVar;
        switch (i) {
            case 1:
                inflate = getLayoutInflater().inflate(g.uFd, null);
                listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.bJe);
                listViewInScrollView.setAdapter(this.tZU);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ WalletWXCreditChangeAmountUI tZW;

                    {
                        this.tZW = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.tZW.dismissDialog(1);
                        if (this.tZW.tZI) {
                            this.tZW.tZF.tZu = 0;
                            this.tZW.tZF = (l) this.tZW.tZE.get(i);
                            this.tZW.tZF.tZu = 1;
                        } else {
                            this.tZW.tZG.tZu = 0;
                            this.tZW.tZG = (l) this.tZW.tZE.get(i);
                            this.tZW.tZG.tZu = 2;
                        }
                        this.tZW.au();
                    }
                });
                aVar = new a(this);
                aVar.Ez(i.uYh);
                aVar.dk(inflate);
                aVar.d(null);
                return aVar.akx();
            case 2:
                inflate = getLayoutInflater().inflate(g.uFd, null);
                listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.bJe);
                listViewInScrollView.setAdapter(this.tZV);
                listViewInScrollView.setOnItemClickListener(new 8(this));
                aVar = new a(this);
                aVar.Ez(i.uYd);
                aVar.dk(inflate);
                aVar.d(null);
                return aVar.akx();
            case 3:
                String string = getString(i.uYg);
                if (this.tZH > 0) {
                    string = getString(i.uYe, new Object[]{Integer.valueOf(this.tZH)});
                }
                return h.a(this, string, null, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletWXCreditChangeAmountUI tZW;

                    {
                        this.tZW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        c ag = com.tencent.mm.wallet_core.a.ag(this.tZW);
                        if (ag != null) {
                            ag.b(this.tZW, this.tZW.vf);
                        } else {
                            this.tZW.finish();
                        }
                    }
                }, new 10(this));
            default:
                return h.b(this, "", "", true);
        }
    }

    public final int getLayoutId() {
        return g.uGb;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        au();
    }

    protected final void initView() {
        setMMTitle(i.uYi);
        this.tZK = (TextView) findViewById(f.uAz);
        this.tZM = (TextView) findViewById(f.uAA);
        this.tZL = (TextView) findViewById(f.uAB);
        this.tZN = (TextView) findViewById(f.uAC);
        this.tZQ = (EditText) findViewById(f.uAp);
        this.tZR = (EditText) findViewById(f.uAq);
        this.tZS = (EditText) findViewById(f.uAr);
        this.tZT = (EditText) findViewById(f.uAs);
        this.tZO = (TextView) findViewById(f.uAt);
        this.tZP = (TextView) findViewById(f.uAu);
        this.tZO.setOnClickListener(this);
        this.tZP.setOnClickListener(this);
        this.tZK.setOnClickListener(new 1(this));
        this.tZL.setOnClickListener(new 4(this));
        setBackBtn(new 5(this));
        findViewById(f.cAg).setOnClickListener(new 6(this));
    }

    private void au() {
        if (this.tZF != null) {
            this.tZK.setText(this.tZF.desc);
            if (this.tZF.tZx != null) {
                this.tZO.setVisibility(0);
                this.tZQ.setVisibility(8);
                this.tZM.setText(this.tZF.tZx.desc);
                this.tZR.setHint(this.tZF.tZx.kNs);
                if ("Y".equals(this.tZF.ocF)) {
                    this.tZM.setVisibility(0);
                    this.tZR.setVisibility(0);
                    this.tZO.setText(i.dHd);
                } else {
                    this.tZM.setVisibility(8);
                    this.tZR.setVisibility(8);
                    if ("N".equals(this.tZF.ocF)) {
                        this.tZO.setText(i.dFR);
                    }
                }
            } else {
                this.tZO.setVisibility(8);
                this.tZQ.setVisibility(0);
                this.tZQ.setHint(this.tZF.kNs);
                this.tZM.setVisibility(8);
                this.tZR.setVisibility(8);
            }
        }
        if (this.tZG != null) {
            this.tZL.setText(this.tZG.desc);
            if (this.tZG.tZx != null) {
                this.tZP.setVisibility(0);
                this.tZS.setVisibility(8);
                this.tZN.setText(this.tZG.tZx.desc);
                this.tZT.setHint(this.tZG.tZx.kNs);
                if ("Y".equals(this.tZG.ocF)) {
                    this.tZN.setVisibility(0);
                    this.tZT.setVisibility(0);
                    this.tZP.setText(i.dHd);
                    return;
                }
                this.tZN.setVisibility(8);
                this.tZT.setVisibility(8);
                if ("N".equals(this.tZG.ocF)) {
                    this.tZP.setText(i.dFR);
                    return;
                }
                return;
            }
            this.tZP.setVisibility(8);
            this.tZS.setVisibility(0);
            this.tZS.setHint(this.tZG.kNs);
            this.tZN.setVisibility(8);
            this.tZT.setVisibility(8);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof e) {
                this.tZD = ((e) kVar).tZb;
                this.tZH = ((e) kVar).tZc;
                if (this.tZD != null && this.tZD.size() >= 2) {
                    this.tZF = (l) this.tZD.get(0);
                    this.tZG = (l) this.tZD.get(1);
                    this.tZF.tZu = 1;
                    this.tZG.tZu = 2;
                }
                au();
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wxcredit.a.c) {
            h.a(this, str, null, false, new 3(this));
            return true;
        }
        return false;
    }

    public void onClick(View view) {
        if (view.getId() == f.uAt) {
            this.tZJ = true;
            showDialog(2);
        } else if (view.getId() == f.uAu) {
            this.tZJ = false;
            showDialog(2);
        }
    }
}
