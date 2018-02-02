package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.bankcard.a.c;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.wallet_core.c.g$a;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class BankRemitMoneyInputUI extends BankRemitBaseUI {
    private String gAT;
    private final int iiI = a.fromDPToPix(ac.getContext(), 270);
    private Button lRZ;
    private CdnImageView pHH;
    private TextView pHJ;
    private String pIO;
    private TextView pJc;
    private ScrollView pJd;
    private WalletFormView pJe;
    private LinearLayout pJf;
    private TextView pJg;
    private TextView pJh;
    private TextView pJi;
    private TextView pJj;
    private BankcardElemParcel pJk;
    private String pJl;
    private String pJm;
    private String pJn;
    private String pJo;
    private String pJp;
    private int pJq;
    private int pJr;
    private l pJs;
    private long pJt;
    private int pJu;
    private int pJv;

    static /* synthetic */ void a(BankRemitMoneyInputUI bankRemitMoneyInputUI, String str) {
        double d = bh.getDouble(str, 0.0d);
        long round = Math.round(bh.getDouble(str, 0.0d) * 100.0d);
        if (bankRemitMoneyInputUI.pJk.pHr >= 0 && round > 0) {
            bankRemitMoneyInputUI.pJt = com.tencent.mm.plugin.remittance.bankcard.model.a.dM(String.valueOf(com.tencent.mm.plugin.remittance.bankcard.model.a.dO(String.valueOf(round), bankRemitMoneyInputUI.pJk.pHr)), "10000");
            x.d("MicroMsg.BankRemitMoneyInputUI", "moneyYuan: %s, money: %s, a: %s, fee: %s", new Object[]{Double.valueOf(d), Long.valueOf(round), Double.valueOf(r4), Long.valueOf(bankRemitMoneyInputUI.pJt)});
            if (bankRemitMoneyInputUI.pJt < ((long) bankRemitMoneyInputUI.pJu) && bankRemitMoneyInputUI.pJk.pHr > 0) {
                bankRemitMoneyInputUI.pJt = (long) bankRemitMoneyInputUI.pJu;
            }
            double dN = com.tencent.mm.plugin.remittance.bankcard.model.a.dN(bankRemitMoneyInputUI.pJt, "100");
            d += dN;
            bankRemitMoneyInputUI.pJh.setText(e.u(dN));
            bankRemitMoneyInputUI.pJi.setText(e.u(d));
        }
    }

    static /* synthetic */ void a(BankRemitMoneyInputUI bankRemitMoneyInputUI, String str, String str2, String str3, String str4) {
        x.i("MicroMsg.BankRemitMoneyInputUI", "do start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.fuH = str;
        payInfo.fCV = 49;
        String str5 = bankRemitMoneyInputUI.getString(i.uHU, new Object[]{str3, str4}) + str2;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str5);
        payInfo.vzx = bundle;
        h.a(bankRemitMoneyInputUI, payInfo, 1);
    }

    static /* synthetic */ boolean a(BankRemitMoneyInputUI bankRemitMoneyInputUI, n nVar) {
        cg cgVar = nVar.pHp.wJa;
        if (cgVar == null || cgVar.fDt != 1) {
            return false;
        }
        x.i("MicroMsg.BankRemitMoneyInputUI", "show alert item");
        com.tencent.mm.ui.base.h.a(bankRemitMoneyInputUI, cgVar.fyY, "", cgVar.odx, cgVar.odw, false, new 9(bankRemitMoneyInputUI, nVar, cgVar), new 10(bankRemitMoneyInputUI));
        return true;
    }

    static /* synthetic */ void e(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        x.i("MicroMsg.BankRemitMoneyInputUI", "do request order, money: %s, fee: %s, desc: %s, input: %s, timeScene: %s", new Object[]{Integer.valueOf((int) Math.round(bh.getDouble(bankRemitMoneyInputUI.pJe.getText(), 0.0d) * 100.0d)), Long.valueOf(bankRemitMoneyInputUI.pJt), bankRemitMoneyInputUI.gAT, Integer.valueOf(bankRemitMoneyInputUI.pJr), Integer.valueOf(bankRemitMoneyInputUI.pJq)});
        k nVar = new n(bankRemitMoneyInputUI.pJm, bankRemitMoneyInputUI.pJn, bankRemitMoneyInputUI.pJp, bankRemitMoneyInputUI.pJq, r5, bankRemitMoneyInputUI.gAT, (int) bankRemitMoneyInputUI.pJt, bankRemitMoneyInputUI.pJr, bankRemitMoneyInputUI.pJo);
        nVar.k(bankRemitMoneyInputUI);
        bankRemitMoneyInputUI.l(nVar);
    }

    static /* synthetic */ void f(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        if (bankRemitMoneyInputUI.pJd != null) {
            final int i;
            int[] iArr = new int[2];
            bankRemitMoneyInputUI.lRZ.getLocationInWindow(iArr);
            int eB = (a.eB(bankRemitMoneyInputUI) - i) - a.fromDPToPix(bankRemitMoneyInputUI, 30);
            x.d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + bankRemitMoneyInputUI.lRZ.getHeight()), Integer.valueOf(a.eB(bankRemitMoneyInputUI)), Integer.valueOf(eB), Integer.valueOf(bankRemitMoneyInputUI.iiI)});
            if (eB > 0 && eB < bankRemitMoneyInputUI.iiI) {
                i = bankRemitMoneyInputUI.iiI - eB;
                x.d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(i)});
                bankRemitMoneyInputUI.pJd.post(new Runnable(bankRemitMoneyInputUI) {
                    final /* synthetic */ BankRemitMoneyInputUI pJw;

                    public final void run() {
                        this.pJw.pJd.scrollBy(0, i);
                    }
                });
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1380);
        int intValue = ((Integer) g.Dj().CU().get(w.a.xxk, Integer.valueOf(10))).intValue();
        if (intValue < 0) {
            intValue = 10;
        }
        this.pJu = intValue;
        intValue = ((Integer) g.Dj().CU().get(w.a.xxl, Integer.valueOf(5000000))).intValue();
        if (intValue <= 0) {
            intValue = 5000000;
        }
        this.pJv = intValue;
        x.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", new Object[]{Integer.valueOf(this.pJu), Integer.valueOf(this.pJv)});
        this.pJk = (BankcardElemParcel) getIntent().getParcelableExtra("key_bank_card_elem_parcel");
        this.pJl = getIntent().getStringExtra("key_payee_name");
        this.pJm = getIntent().getStringExtra("key_bank_card_seqno");
        this.pJn = getIntent().getStringExtra("key_bank_card_tailno");
        this.pJo = getIntent().getStringExtra("key_encrypt_data");
        this.pJq = getIntent().getIntExtra("key_enter_time_scene", 0);
        this.pJr = getIntent().getIntExtra("key_input_type", 0);
        if (this.pJk == null) {
            x.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
            this.pJk = new BankcardElemParcel();
        }
        this.pJp = this.pJk.oZz;
        initView();
        setMMTitle(i.uHZ);
    }

    protected final void initView() {
        this.pJd = (ScrollView) findViewById(f.uwl);
        this.pHH = (CdnImageView) findViewById(f.ugx);
        this.pHJ = (TextView) findViewById(f.ugz);
        this.pJc = (TextView) findViewById(f.ugE);
        this.pJe = (WalletFormView) findViewById(f.ugy);
        this.pJf = (LinearLayout) findViewById(f.ugA);
        this.pJg = (TextView) this.pJf.findViewById(f.ugB);
        this.pJh = (TextView) this.pJf.findViewById(f.ugC);
        this.pJi = (TextView) this.pJf.findViewById(f.ugG);
        this.pJj = (TextView) this.pJf.findViewById(f.ugF);
        this.lRZ = (Button) findViewById(f.ugD);
        String str = com.tencent.mm.plugin.remittance.bankcard.model.a.dN(this.pJk.pHr, "100") + "%";
        this.pJg.setText(getString(i.uHI, new Object[]{str}));
        this.pHH.setUrl(this.pJk.pHq);
        this.pHJ.setText(getString(i.uHU, new Object[]{this.pJk.nBM, this.pJn}));
        this.pJc.setText(this.pJl);
        this.pJe.xv(u.cBD());
        e(this.pJe, 2, false);
        this.pJe.a(new 1(this));
        this.pJj.setClickable(true);
        this.pJj.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.l(this));
        this.pJs = new l(new 8(this));
        bnx();
        this.lRZ.setOnClickListener(new 3(this));
        bnu();
        this.ofE = new com.tencent.mm.wallet_core.ui.a(this) {
            final /* synthetic */ BankRemitMoneyInputUI pJw;

            {
                this.pJw = r1;
            }

            public final void hA(boolean z) {
                if (z) {
                    BankRemitMoneyInputUI.f(this.pJw);
                } else {
                    this.pJw.pJd.scrollTo(0, 0);
                }
            }
        };
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof n) {
            final n nVar = (n) kVar;
            nVar.a(new g$a(this) {
                final /* synthetic */ BankRemitMoneyInputUI pJw;

                public final void f(int i, int i2, String str, k kVar) {
                    x.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", new Object[]{nVar.pHp.ods, nVar.pHp.vPj});
                    x.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", new Object[]{nVar.pHp.pHM, nVar.pHp.nBM});
                    this.pJw.pIO = nVar.pHp.vPj;
                    if (!BankRemitMoneyInputUI.a(this.pJw, nVar)) {
                        BankRemitMoneyInputUI.a(this.pJw, nVar.pHp.ods, nVar.pHp.pHM, nVar.pHp.nBM, nVar.pHp.pHL);
                    }
                }
            }).b(new g$a(this) {
                final /* synthetic */ BankRemitMoneyInputUI pJw;

                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", new Object[]{Integer.valueOf(nVar.pHp.liH), nVar.pHp.liI});
                    BankRemitMoneyInputUI.a(this.pJw, nVar);
                }
            }).c(new g$a(this) {
                final /* synthetic */ BankRemitMoneyInputUI pJw;

                {
                    this.pJw = r1;
                }

                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitMoneyInputUI", "net error: %s", new Object[]{kVar});
                }
            });
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1380);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uBd;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2;
        if (i == 1) {
            if (i2 == -1) {
                x.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
                intent2 = new Intent(this.mController.xIM, BankRemitDetailUI.class);
                intent2.putExtra("key_transfer_bill_id", this.pIO);
                intent2.putExtra("key_enter_scene", 0);
                startActivityForResult(intent2, 2);
                String str = "";
                if (intent != null) {
                    str = intent.getStringExtra("key_trans_id");
                }
                x.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", new Object[]{this.pIO, str});
                b(new c(this.pIO, str), false);
                return;
            }
            x.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", new Object[]{Integer.valueOf(i2)});
        } else if (i == 2) {
            x.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
            intent2 = new Intent();
            intent2.addFlags(67108864);
            d.b(this.mController.xIM, "offline", ".ui.WalletOfflineCoinPurseUI", intent2);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    private void bnx() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (bh.ov(this.gAT)) {
            spannableStringBuilder.append(getString(i.uHP));
            spannableStringBuilder.setSpan(this.pJs, 0, spannableStringBuilder.length(), 18);
        } else {
            spannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.d.i.a(this.mController.xIM, this.gAT));
            spannableStringBuilder.append(getString(i.uHO));
            spannableStringBuilder.setSpan(this.pJs, this.gAT.length(), spannableStringBuilder.length(), 34);
        }
        this.pJj.setText(spannableStringBuilder);
    }

    private void bnu() {
        if (bh.getDouble(this.pJe.getText(), 0.0d) <= 0.0d || bh.ov(this.pJm) || bh.ov(this.pJn) || bh.ov(this.pJp) || bh.ov(this.pJo)) {
            x.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", new Object[]{this.pJe.getText(), Boolean.valueOf(bh.ov(this.pJm)), Boolean.valueOf(bh.ov(this.pJn)), Boolean.valueOf(bh.ov(this.pJp)), Boolean.valueOf(bh.ov(this.pJo))});
            this.lRZ.setEnabled(false);
            return;
        }
        this.lRZ.setEnabled(true);
    }
}
