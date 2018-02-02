package com.tencent.mm.plugin.collect.reward.ui;

import android.os.Bundle;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.collect.reward.a.g;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QrRewardSetMoneyUI extends QrRewardBaseUI {
    private String desc;
    private String iIb;
    private TextView jJn;
    private int ljZ;
    private MMGridView lkV;
    private Button lkW;
    private MMEditText lkX;
    private TextView lkY;
    private TextView lkZ;
    private ImageView lkk;
    private SparseArray<WalletFormView> lla;
    private List<Integer> llb;
    private List<Integer> llc;
    private boolean lld = false;
    private Runnable lle = new 5(this);
    private TextWatcher llf = new 6(this);

    private class a extends BaseAdapter {
        final /* synthetic */ QrRewardSetMoneyUI llg;

        private a(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
            this.llg = qrRewardSetMoneyUI;
        }

        public final int getCount() {
            return this.llg.llc.size();
        }

        public final Object getItem(int i) {
            return this.llg.llc.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return (View) this.llg.lla.get(i);
            }
            return view;
        }
    }

    static /* synthetic */ boolean a(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < qrRewardSetMoneyUI.lla.size(); i++) {
            WalletFormView walletFormView = (WalletFormView) qrRewardSetMoneyUI.lla.get(i);
            int round = (int) Math.round(bh.getDouble(walletFormView.getText(), 0.0d) * 100.0d);
            qrRewardSetMoneyUI.llc.set(i, Integer.valueOf(round));
            if (round > qrRewardSetMoneyUI.ljZ) {
                walletFormView.HH(a$c.uay);
                z2 = true;
            } else {
                if (round <= 0) {
                    z = true;
                }
                walletFormView.HH(a$c.black);
            }
        }
        if (z2) {
            if (!qrRewardSetMoneyUI.lkY.isShown()) {
                qrRewardSetMoneyUI.lkY.startAnimation(AnimationUtils.loadAnimation(qrRewardSetMoneyUI, com.tencent.mm.plugin.wxpay.a.a.uao));
                qrRewardSetMoneyUI.lkY.setVisibility(0);
            }
            qrRewardSetMoneyUI.lkW.setEnabled(false);
        } else if (z) {
            qrRewardSetMoneyUI.lkW.setEnabled(false);
        } else {
            if (qrRewardSetMoneyUI.lkY.isShown()) {
                qrRewardSetMoneyUI.lkY.startAnimation(AnimationUtils.loadAnimation(qrRewardSetMoneyUI, com.tencent.mm.plugin.wxpay.a.a.uap));
                qrRewardSetMoneyUI.lkY.setVisibility(8);
            }
            qrRewardSetMoneyUI.lkW.setEnabled(true);
        }
        return z2;
    }

    static /* synthetic */ void b(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        x.i("MicroMsg.QrRewardSetMoneyUI", "do set code");
        k gVar = new g(new LinkedList(qrRewardSetMoneyUI.llc), qrRewardSetMoneyUI.lkX.getText().toString().replace("\n", ""), qrRewardSetMoneyUI.lld, qrRewardSetMoneyUI.azf());
        gVar.m(qrRewardSetMoneyUI);
        qrRewardSetMoneyUI.b(gVar, true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uMK);
        ji(1562);
        List<String> fs = bh.fs((String) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xwV, ""), ",");
        this.llb = new ArrayList();
        if (fs.isEmpty()) {
            x.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
            this.llb = Arrays.asList(b.ljE);
        } else {
            for (String str : fs) {
                this.llb.add(Integer.valueOf(bh.getInt(str, 0)));
            }
        }
        this.llc = new ArrayList(this.llb);
        this.ljZ = ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xwU, Integer.valueOf(HardCoderJNI.sHCENCODEVIDEOTIMEOUT))).intValue();
        this.lld = getIntent().getBooleanExtra("key_first_flag", false);
        this.lla = new SparseArray();
        azg();
        initView();
    }

    protected final void initView() {
        this.lkV = (MMGridView) findViewById(f.uuu);
        this.lkW = (Button) findViewById(f.uut);
        this.lkY = (TextView) findViewById(f.uuq);
        this.lkk = (ImageView) findViewById(f.uur);
        this.lkX = (MMEditText) findViewById(f.uuv);
        this.jJn = (TextView) findViewById(f.uuw);
        this.lkZ = (TextView) findViewById(f.uus);
        CharSequence FU = q.FU();
        if (bh.ov(FU)) {
            FU = q.FV();
        }
        this.jJn.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this.mController.xIM, FU));
        com.tencent.mm.pluginsdk.ui.a.b.a(this.lkk, q.FS(), 0.06f, false);
        this.lkV.setAdapter(new a());
        this.lkY.setText(getString(i.uMJ, new Object[]{Math.round(((float) this.ljZ) / 100.0f)}));
        if (this.lld) {
            this.lkW.setText(i.uMy);
            this.lkZ.setVisibility(8);
        }
        this.lkW.setOnClickListener(new r(this) {
            final /* synthetic */ QrRewardSetMoneyUI llg;

            {
                this.llg = r1;
            }

            public final void ayX() {
                if (QrRewardSetMoneyUI.a(this.llg)) {
                    x.i("MicroMsg.QrRewardSetMoneyUI", "amt error!");
                } else {
                    QrRewardSetMoneyUI.b(this.llg);
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(14721, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
            }
        });
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uDO;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1562);
        ag.K(this.lle);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof g) {
            final g gVar = (g) kVar;
            gVar.a(new 4(this, gVar)).b(new com.tencent.mm.plugin.collect.reward.a.a.a(this) {
                final /* synthetic */ QrRewardSetMoneyUI llg;

                public final void i(k kVar) {
                    x.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", new Object[]{Integer.valueOf(gVar.ljy.liH), gVar.ljy.liI});
                    if (bh.ov(gVar.ljy.liI)) {
                        Toast.makeText(this.llg, i.uMI, 1).show();
                    } else {
                        Toast.makeText(this.llg, gVar.ljy.liI, 1).show();
                    }
                }
            }).c(new 2(this));
        }
        return false;
    }

    private boolean azf() {
        int i = 0;
        while (i < this.llb.size()) {
            if (((Integer) this.llb.get(i)).equals(this.llc.get(i))) {
                i++;
            } else {
                x.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", new Object[]{this.llb.get(i), this.llc.get(i)});
                return true;
            }
        }
        return false;
    }

    private void azg() {
        for (int i = 0; i < this.llc.size(); i++) {
            WalletFormView walletFormView = (WalletFormView) LayoutInflater.from(this.mController.xIM).inflate(com.tencent.mm.plugin.wxpay.a.g.uDN, null);
            walletFormView.a(this.llf);
            int intValue = ((Integer) this.llc.get(i)).intValue();
            if (((double) intValue) / 100.0d > ((double) (intValue / 100))) {
                walletFormView.setText(String.format("%.2f", new Object[]{Double.valueOf(((double) intValue) / 100.0d)}));
            } else {
                walletFormView.setText(String.format("%d", new Object[]{Integer.valueOf(intValue / 100)}));
            }
            e(walletFormView, 2, false);
            this.lla.put(i, walletFormView);
        }
    }
}
