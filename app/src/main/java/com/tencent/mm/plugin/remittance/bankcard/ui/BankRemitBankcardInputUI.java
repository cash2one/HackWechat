package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.widget.Button;
import android.widget.Filter.FilterListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.st;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;
import com.tencent.mm.plugin.remittance.bankcard.a.d;
import com.tencent.mm.plugin.remittance.bankcard.a.m;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a(1)
public class BankRemitBankcardInputUI extends BankRemitBaseUI {
    private Button lRZ;
    private g omE;
    private CdnImageView pHH;
    private WalletFormView pHO;
    private WalletFormView pHP;
    private WalletFormView pHQ;
    private WalletFormView pHR;
    private ListPopupWindow pHS;
    private c pHT;
    private FilterListener pHU;
    private ArrayList<TransferRecordParcel> pHV;
    private ArrayList<TransferRecordParcel> pHW;
    private String pHX;
    private String pHY;
    private String pHZ;
    private String pIa;
    private String pIb;
    private String pIc;
    private EnterTimeParcel pId;
    private BankcardElemParcel pIe;
    private TransferRecordParcel pIf;
    private boolean pIg = true;
    private boolean pIh = false;
    private boolean pIi = false;
    private boolean pIj = false;
    private com.tencent.mm.plugin.remittance.bankcard.a.g pIk = null;
    private boolean pIl = false;
    private boolean pIm = false;
    private boolean pIn = true;

    static /* synthetic */ void F(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        x.d("MicroMsg.BankRemitBankcardInputUI", "init popup window");
        bankRemitBankcardInputUI.pHS = new ListPopupWindow(bankRemitBankcardInputUI);
        bankRemitBankcardInputUI.pHS.PV = com.tencent.mm.bv.a.eA(bankRemitBankcardInputUI) - com.tencent.mm.bv.a.fromDPToPix(bankRemitBankcardInputUI, 30);
        bankRemitBankcardInputUI.pHS.SM = com.tencent.mm.bv.a.fromDPToPix(bankRemitBankcardInputUI, h.CTRL_INDEX);
        bankRemitBankcardInputUI.pHS.setBackgroundDrawable(new ColorDrawable(0));
        bankRemitBankcardInputUI.pHS.setVerticalOffset(1);
        ListPopupWindow listPopupWindow = bankRemitBankcardInputUI.pHS;
        listPopupWindow.SK.setAnimationStyle(j.gYO);
        bankRemitBankcardInputUI.pHS.SW = bankRemitBankcardInputUI.pHO;
        bankRemitBankcardInputUI.pHS.setModal(false);
        bankRemitBankcardInputUI.pHS.SY = new 18(bankRemitBankcardInputUI);
        bankRemitBankcardInputUI.pHU = new FilterListener(bankRemitBankcardInputUI) {
            final /* synthetic */ BankRemitBankcardInputUI pIo;

            {
                this.pIo = r1;
            }

            public final void onFilterComplete(int i) {
                x.i("MicroMsg.BankRemitBankcardInputUI", "filter complete: %d", new Object[]{Integer.valueOf(i)});
                if (this.pIo.pHS == null) {
                    return;
                }
                if (i > 0 && !this.pIo.pHS.SK.isShowing()) {
                    this.pIo.pHS.show();
                } else if (i <= 0 && this.pIo.pHS.SK.isShowing()) {
                    this.pIo.pHS.dismiss();
                }
            }
        };
        List arrayList = new ArrayList();
        if (bankRemitBankcardInputUI.pHV != null) {
            arrayList.addAll(bankRemitBankcardInputUI.pHV);
        }
        if (bankRemitBankcardInputUI.pHW != null) {
            arrayList.addAll(bankRemitBankcardInputUI.pHW);
        }
        bankRemitBankcardInputUI.pHT = new c(bankRemitBankcardInputUI, arrayList);
        bankRemitBankcardInputUI.pHS.setAdapter(bankRemitBankcardInputUI.pHT);
    }

    static /* synthetic */ void a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2) {
        k kVar;
        x.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by cardNo");
        if (bankRemitBankcardInputUI.pIk != null) {
            x.i("MicroMsg.BankRemitBankcardInputUI", "cancel pre scene");
            kVar = bankRemitBankcardInputUI.pIk;
            com.tencent.mm.wallet_core.d.g gVar = bankRemitBankcardInputUI.zIY;
            x.i("MicroMsg.WalletNetSceneMgr", "cancel scene: %s %s", new Object[]{gVar, kVar});
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.c(kVar);
            gVar.ilR.remove(kVar);
            gVar.ilQ.remove(kVar);
            if (gVar.ilR.isEmpty() && gVar.ilQ.isEmpty() && gVar.ilS != null && gVar.ilS.isShowing()) {
                gVar.ilS.dismiss();
            }
        }
        bankRemitBankcardInputUI.pIn = false;
        kVar = new com.tencent.mm.plugin.remittance.bankcard.a.g(str, str2);
        bankRemitBankcardInputUI.pIk = kVar;
        bankRemitBankcardInputUI.b(kVar, true);
    }

    static /* synthetic */ void a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2, String str3, String str4) {
        x.i("MicroMsg.BankRemitBankcardInputUI", "do check bank bind: %s %s", new Object[]{str3, str4});
        x.d("MicroMsg.BankRemitBankcardInputUI", "payeeName: %s, bankCardNo: %s", new Object[]{str, str2});
        bankRemitBankcardInputUI.l(new d(str, str2, str3, str4));
    }

    static /* synthetic */ void d(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        bankRemitBankcardInputUI.pHP.nK(true);
        bankRemitBankcardInputUI.pIi = false;
    }

    static /* synthetic */ void e(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        bankRemitBankcardInputUI.pHQ.setClickable(true);
        bankRemitBankcardInputUI.pIj = false;
    }

    static /* synthetic */ void k(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        bankRemitBankcardInputUI.pHP.bmK();
        bankRemitBankcardInputUI.pHQ.bmK();
        bankRemitBankcardInputUI.pHH.setImageBitmap(null);
        bankRemitBankcardInputUI.pHR.bmK();
        bankRemitBankcardInputUI.pHR.setVisibility(8);
        bankRemitBankcardInputUI.bnt();
        bankRemitBankcardInputUI.pHZ = "";
        bankRemitBankcardInputUI.pIa = "";
        bankRemitBankcardInputUI.pHX = "";
        bankRemitBankcardInputUI.pIe = null;
        bankRemitBankcardInputUI.pId = null;
    }

    static /* synthetic */ boolean s(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        if (bankRemitBankcardInputUI.pIe == null) {
            return false;
        }
        if (bh.ov(bankRemitBankcardInputUI.pIe.pHv)) {
            return false;
        }
        x.i("MicroMsg.BankRemitBankcardInputUI", "show alert text: %s", new Object[]{bankRemitBankcardInputUI.pIe.pHv});
        com.tencent.mm.ui.base.h.a(bankRemitBankcardInputUI, bankRemitBankcardInputUI.pIe.pHv, "", false, new 21(bankRemitBankcardInputUI));
        return true;
    }

    static /* synthetic */ void x(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        Intent intent = new Intent(bankRemitBankcardInputUI.mController.xIM, BankRemitMoneyInputUI.class);
        if (bankRemitBankcardInputUI.pIh) {
            intent.putExtra("key_bank_card_seqno", bankRemitBankcardInputUI.pIf.pHK);
            intent.putExtra("key_bank_card_tailno", bankRemitBankcardInputUI.pIf.pHL);
            intent.putExtra("key_payee_name", bankRemitBankcardInputUI.pIf.pHM);
            intent.putExtra("key_input_type", 1);
        } else {
            intent.putExtra("key_bank_card_seqno", bankRemitBankcardInputUI.pHZ);
            intent.putExtra("key_bank_card_tailno", bankRemitBankcardInputUI.pIa);
            intent.putExtra("key_payee_name", bankRemitBankcardInputUI.pIb);
            intent.putExtra("key_input_type", 0);
        }
        intent.putExtra("key_enter_time_scene", bankRemitBankcardInputUI.pId.pHx);
        intent.putExtra("key_encrypt_data", bankRemitBankcardInputUI.pHX);
        intent.putExtra("key_bank_card_elem_parcel", bankRemitBankcardInputUI.pIe);
        bankRemitBankcardInputUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        final b stVar = new st();
        stVar.fKA.fKC = "12";
        stVar.fqI = new Runnable(this) {
            final /* synthetic */ BankRemitBankcardInputUI pIo;

            public final void run() {
                if (!bh.ov(stVar.fKB.fKD)) {
                    e.a((TextView) this.pIo.findViewById(f.ufy), stVar.fKB.fKD, stVar.fKB.content, stVar.fKB.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xef.m(stVar);
        ji(1348);
        ji(1542);
        ji(1378);
        ji(1349);
        ji(1280);
        this.pIc = (String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xxm, "");
        hz(false);
        x.i("MicroMsg.BankRemitBankcardInputUI", "do operation");
        b(new com.tencent.mm.plugin.remittance.bankcard.a.k(), false);
        setMMTitle(i.uHZ);
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.h.uGk, new 12(this));
        com.tencent.mm.plugin.report.service.g.pQN.h(14673, new Object[]{Integer.valueOf(1)});
    }

    protected final void initView() {
        this.pHO = (WalletFormView) findViewById(f.ufV);
        this.pHP = (WalletFormView) findViewById(f.ufU);
        this.pHQ = (WalletFormView) findViewById(f.ufT);
        this.pHH = (CdnImageView) this.pHQ.findViewById(f.uyX);
        this.pHR = (WalletFormView) findViewById(f.ufS);
        this.lRZ = (Button) findViewById(f.ufW);
        "\\x20\\t\\r\\n".toCharArray();
        this.pHO.a(new 22(this));
        this.pHO.setOnEditorActionListener(new 23(this));
        this.pHO.cCo();
        com.tencent.mm.wallet_core.ui.formview.a.a(this.pHP);
        a(this.pHP, 2, false, true);
        this.pHP.a(new 24(this));
        this.pHQ.setOnClickListener(new 25(this));
        this.pHR.setOnClickListener(new 26(this));
        this.lRZ.setOnClickListener(new 27(this));
        this.pHO.pEi.setVisibility(0);
        this.pHO.pEi.setClickable(true);
        this.pHO.pEi.setEnabled(true);
        this.pHO.pEi.setOnClickListener(new 20(this));
        bnu();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.a) {
            final com.tencent.mm.plugin.remittance.bankcard.a.a aVar = (com.tencent.mm.plugin.remittance.bankcard.a.a) kVar;
            if (aVar.pHd.equals(this.pIf.pHK)) {
                aVar.a(new com.tencent.mm.wallet_core.c.g.a(this) {
                    final /* synthetic */ BankRemitBankcardInputUI pIo;

                    public final void f(int i, int i2, String str, k kVar) {
                        this.pIo.pHX = aVar.pHc.vIK;
                        this.pIo.pIe = new BankcardElemParcel(aVar.pHc.vIJ);
                        String str2 = "MicroMsg.BankRemitBankcardInputUI";
                        String str3 = "response bank: %s";
                        Object[] objArr = new Object[1];
                        objArr[0] = this.pIo.pIe != null ? this.pIo.pIe.nBM : "";
                        x.i(str2, str3, objArr);
                        this.pIo.bnr();
                        this.pIo.bnv();
                        this.pIo.bns();
                        this.pIo.bnt();
                        this.pIo.bnu();
                    }
                }).b(new 2(this, aVar)).c(new com.tencent.mm.wallet_core.c.g.a(this) {
                    final /* synthetic */ BankRemitBankcardInputUI pIo;

                    {
                        this.pIo = r1;
                    }

                    public final void f(int i, int i2, String str, k kVar) {
                        x.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[]{kVar});
                    }
                });
            } else {
                x.i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", new Object[]{aVar.pHd, this.pHZ});
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.g) {
            com.tencent.mm.plugin.remittance.bankcard.a.g gVar = (com.tencent.mm.plugin.remittance.bankcard.a.g) kVar;
            if (gVar == this.pIk) {
                x.i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
                this.pIk = null;
            }
            if (gVar.fqR.equals(this.pHP.cCl())) {
                gVar.a(new 6(this, gVar)).b(new 5(this, gVar)).c(new 4(this));
            } else {
                x.i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", new Object[]{gVar.fqR, this.pHP.cCl()});
                return true;
            }
        } else if (kVar instanceof m) {
            final m mVar = (m) kVar;
            this.pIm = true;
            mVar.a(new 9(this, mVar)).b(new com.tencent.mm.wallet_core.c.g.a(this) {
                final /* synthetic */ BankRemitBankcardInputUI pIo;

                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", new Object[]{Integer.valueOf(mVar.pHo.liH), mVar.pHo.liI});
                    if (!bh.ov(mVar.pHo.liI)) {
                        Toast.makeText(this.pIo, mVar.pHo.liI, 1).show();
                    }
                    this.pIo.pIl = true;
                }
            }).c(new 7(this));
        } else if (kVar instanceof d) {
            d dVar = (d) kVar;
            dVar.a(new 13(this, dVar)).b(new 11(this, dVar)).c(new com.tencent.mm.wallet_core.c.g.a(this) {
                final /* synthetic */ BankRemitBankcardInputUI pIo;

                {
                    this.pIo = r1;
                }

                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[]{kVar});
                }
            });
        } else if (kVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.k) {
            com.tencent.mm.plugin.remittance.bankcard.a.k kVar2 = (com.tencent.mm.plugin.remittance.bankcard.a.k) kVar;
            kVar2.a(new 16(this, kVar2)).b(new 15(this, kVar2)).c(new 14(this));
        }
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uAX;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1348);
        jj(1542);
        jj(1378);
        jj(1349);
        jj(1280);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Iterator it;
        if (i == 1) {
            TransferRecordParcel transferRecordParcel;
            if (i2 == -1) {
                this.pIg = false;
                this.pHZ = intent.getStringExtra("key_bank_card_seqno");
                String str = this.pHZ;
                if (this.pHV != null) {
                    it = this.pHV.iterator();
                    while (it.hasNext()) {
                        transferRecordParcel = (TransferRecordParcel) it.next();
                        if (transferRecordParcel.pHK.equals(str)) {
                            break;
                        }
                    }
                }
                if (this.pHW != null) {
                    it = this.pHW.iterator();
                    while (it.hasNext()) {
                        transferRecordParcel = (TransferRecordParcel) it.next();
                        if (transferRecordParcel.pHK.equals(str)) {
                            break;
                        }
                    }
                }
                transferRecordParcel = null;
                this.pIf = transferRecordParcel;
                bnq();
                bnu();
                if (this.pIf != null) {
                    O(this.pIf.pHK, this.pHY, this.pIf.oZz);
                }
                ag.h(new Runnable(this) {
                    final /* synthetic */ BankRemitBankcardInputUI pIo;

                    {
                        this.pIo = r1;
                    }

                    public final void run() {
                        this.pIo.pHO.bmJ();
                    }
                }, 50);
            }
            x.i("MicroMsg.BankRemitBankcardInputUI", "resultCode: %s", new Object[]{Integer.valueOf(i2)});
            if (intent != null) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_delete_seq_no_list");
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_modified_record_list");
                if (stringArrayListExtra != null) {
                    it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        j(str2, this.pHV);
                        j(str2, this.pHW);
                    }
                }
                if (parcelableArrayListExtra != null) {
                    Iterator it2 = parcelableArrayListExtra.iterator();
                    while (it2.hasNext()) {
                        transferRecordParcel = (TransferRecordParcel) it2.next();
                        a(transferRecordParcel, this.pHV);
                        a(transferRecordParcel, this.pHW);
                    }
                }
            }
        } else if (i == 3) {
            if (i2 == -1) {
                int intExtra = intent.getIntExtra("key_enter_time_scene", -1);
                if (!(this.pIe == null || this.pIe.pHw == null)) {
                    it = this.pIe.pHw.iterator();
                    while (it.hasNext()) {
                        EnterTimeParcel enterTimeParcel = (EnterTimeParcel) it.next();
                        if (enterTimeParcel.pHx == intExtra) {
                            this.pId = enterTimeParcel;
                            break;
                        }
                    }
                }
                x.w("MicroMsg.BankRemitBankcardInputUI", "can't find the right enter scene: %d", new Object[]{Integer.valueOf(intExtra)});
                bns();
                bnu();
            }
        } else if (i != 2) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            this.pIe = (BankcardElemParcel) intent.getParcelableExtra("key_bank_card_elem_parcel");
            bnr();
            bnv();
            bns();
            bnt();
            bnu();
        }
    }

    private static void a(TransferRecordParcel transferRecordParcel, List<TransferRecordParcel> list) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TransferRecordParcel transferRecordParcel2 = (TransferRecordParcel) list.get(size);
                if (transferRecordParcel2.pHK.equals(transferRecordParcel.pHK)) {
                    transferRecordParcel2.pHN = transferRecordParcel.pHN;
                    return;
                }
            }
        }
    }

    private static void j(String str, List<TransferRecordParcel> list) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TransferRecordParcel transferRecordParcel = (TransferRecordParcel) list.get(size);
                if (transferRecordParcel.pHK.equals(str)) {
                    list.remove(transferRecordParcel);
                    return;
                }
            }
        }
    }

    private void O(String str, String str2, String str3) {
        x.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", new Object[]{str});
        b(new com.tencent.mm.plugin.remittance.bankcard.a.a(str, str2, str3), false);
    }

    private void hz(boolean z) {
        x.i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            b(new m(), true);
        } else {
            b(new m(), false);
        }
    }

    private void bnq() {
        if (this.pIf != null) {
            this.pHO.setText(this.pIf.pHM);
            this.pIh = true;
            this.pHP.setText(getString(i.uHr, new Object[]{this.pIf.pHL}));
            this.pHQ.setText(this.pIf.nBM);
            this.pHH.setUrl(this.pIf.pHq);
            this.pHP.bmJ();
            this.pHP.nK(false);
            this.pIi = true;
            this.pHQ.setClickable(false);
            this.pIj = true;
        }
    }

    private void bnr() {
        if (this.pIe != null) {
            this.pHQ.setText(this.pIe.nBM);
            this.pHH.setUrl(this.pIe.pHq);
        }
    }

    private void bns() {
        if (this.pId != null) {
            if (bh.ov(this.pId.hbM)) {
                this.pHR.HH(a$c.black);
            } else {
                this.pHR.HI(Color.parseColor(this.pId.hbM));
            }
            this.pHR.setText(this.pId.pHy);
            this.pHR.setVisibility(0);
        } else if (bh.ov(this.pIe.pHt)) {
            this.pHR.setVisibility(8);
        } else {
            this.pHR.setText(this.pIe.pHt);
            if (bh.ov(this.pIe.pHu)) {
                this.pHR.HH(a$c.black);
            } else {
                this.pHR.HI(Color.parseColor(this.pIe.pHu));
            }
            this.pHR.setVisibility(0);
        }
    }

    private void bnt() {
        if (this.pHR.getVisibility() == 0) {
            this.pHQ.setBackground(getResources().getDrawable(a$e.udS));
        } else {
            this.pHQ.setBackground(getResources().getDrawable(a$e.ucx));
        }
    }

    private void bnu() {
        if (bh.ov(this.pHO.getText()) || this.pHO.getText().trim().isEmpty() || bh.ov(this.pHP.getText()) || this.pHP.getText().trim().isEmpty() || !this.pHP.XO() || bh.ov(this.pHQ.getText()) || this.pHR.getVisibility() != 0 || bh.ov(this.pHR.getText()) || this.pIe == null || !bh.ov(this.pIe.pHv)) {
            this.lRZ.setEnabled(false);
        } else {
            this.lRZ.setEnabled(true);
        }
    }

    private void bnv() {
        if (this.pIe != null && !bh.ov(this.pIe.pHt)) {
            this.pId = null;
        } else if (this.pIe != null && this.pIe.pHw != null) {
            Iterator it = this.pIe.pHw.iterator();
            while (it.hasNext()) {
                EnterTimeParcel enterTimeParcel = (EnterTimeParcel) it.next();
                if (enterTimeParcel.pHA > 0) {
                    this.pId = enterTimeParcel;
                    return;
                }
            }
        }
    }
}
