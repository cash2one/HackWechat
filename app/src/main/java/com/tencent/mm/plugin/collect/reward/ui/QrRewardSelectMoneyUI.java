package com.tencent.mm.plugin.collect.reward.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.collect.reward.a.a$a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class QrRewardSelectMoneyUI extends QrRewardBaseUI {
    private int fCR;
    private String jeE;
    private String ljQ;
    private String ljS;
    private String ljU;
    private String ljV;
    private String ljW;
    private String ljX;
    private String ljY;
    private int ljZ;
    private List<Integer> lkG = new ArrayList();
    private ImageView lkH;
    private TextView lkI;
    private TextView lkJ;
    private TextView lkK;
    private TextView lkL;
    private MMGridView lkM;
    private TextView lkN;
    private a lkO;
    private String lkP;
    private String lkQ;

    private class a extends BaseAdapter {
        final /* synthetic */ QrRewardSelectMoneyUI lkR;

        private a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI) {
            this.lkR = qrRewardSelectMoneyUI;
        }

        public final int getCount() {
            return this.lkR.lkG.size();
        }

        public final Object getItem(int i) {
            return this.lkR.lkG.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.lkR.mController.xIM).inflate(g.uDL, viewGroup, false);
            }
            int intValue = ((Integer) getItem(i)).intValue();
            TextView textView = (TextView) view.findViewById(f.uui);
            if (((double) intValue) / 100.0d > ((double) (intValue / 100))) {
                textView.setText(String.format("%.2f", new Object[]{Double.valueOf(r4)}) + this.lkR.getString(i.uMM));
            } else {
                textView.setText(String.format("%d", new Object[]{Integer.valueOf(r2)}) + this.lkR.getString(i.uMM));
            }
            return view;
        }
    }

    static /* synthetic */ void a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, int i, int i2) {
        x.i("MicroMsg.QrRewardSelectMoneyUI", "go to grant ui");
        Intent intent = new Intent(qrRewardSelectMoneyUI.mController.xIM, QrRewardGrantUI.class);
        intent.putExtra("key_amt_type", i2);
        if (i2 == 1) {
            intent.putExtra("key_money_amt", i);
        }
        intent.putExtra("key_rcvr_name", qrRewardSelectMoneyUI.ljU);
        intent.putExtra("key_rcvr_true_name", qrRewardSelectMoneyUI.ljV);
        intent.putExtra("key_rcvr_open_id", qrRewardSelectMoneyUI.ljS);
        intent.putExtra("key_qrcode_desc", qrRewardSelectMoneyUI.ljQ);
        intent.putExtra("key_channel", qrRewardSelectMoneyUI.fCR);
        intent.putExtra("key_web_url", qrRewardSelectMoneyUI.jeE);
        intent.putExtra("key_scan_id", qrRewardSelectMoneyUI.ljW);
        intent.putExtra("key_sxtend_1", qrRewardSelectMoneyUI.ljX);
        intent.putExtra("key_sxtend_2", qrRewardSelectMoneyUI.ljY);
        intent.putExtra("key_max_amt", qrRewardSelectMoneyUI.ljZ);
        qrRewardSelectMoneyUI.startActivityForResult(intent, 1);
    }

    static /* synthetic */ void b(QrRewardSelectMoneyUI qrRewardSelectMoneyUI) {
        String str = qrRewardSelectMoneyUI.ljU;
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.l.a WN = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WN(str);
        if (WN == null || ((int) WN.gJd) <= 0) {
            x.d("MicroMsg.QrRewardSelectMoneyUI", "Receiver in contactStg and try to get contact");
            com.tencent.mm.z.ak.a.hfL.a(str, "", new 6(qrRewardSelectMoneyUI, bh.Wp()));
        } else {
            b.a(qrRewardSelectMoneyUI.lkH, str, 0.03f, false);
            qrRewardSelectMoneyUI.lkJ.setText(com.tencent.mm.pluginsdk.ui.d.i.a(qrRewardSelectMoneyUI.mController.xIM, e.gu(str)));
        }
        if (!bh.ov(qrRewardSelectMoneyUI.ljQ)) {
            qrRewardSelectMoneyUI.lkK.setText(com.tencent.mm.pluginsdk.ui.d.i.b(qrRewardSelectMoneyUI, qrRewardSelectMoneyUI.getString(i.uML, new Object[]{qrRewardSelectMoneyUI.ljQ}), qrRewardSelectMoneyUI.lkK.getTextSize()));
        }
        if (bh.ov(qrRewardSelectMoneyUI.lkQ)) {
            qrRewardSelectMoneyUI.lkI.setVisibility(8);
        } else {
            qrRewardSelectMoneyUI.lkI.setText(qrRewardSelectMoneyUI.lkQ);
        }
        qrRewardSelectMoneyUI.lkO.notifyDataSetChanged();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1516);
        setMMTitle(i.uMC);
        uD(4);
        this.lkP = getIntent().getStringExtra("key_qrcode_url");
        this.fCR = getIntent().getIntExtra("key_channel", 0);
        this.jeE = getIntent().getStringExtra("key_web_url");
        x.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
        l(new com.tencent.mm.plugin.collect.reward.a.f(this.lkP, this.fCR, this.jeE));
        initView();
        int intExtra = getIntent().getIntExtra("key_scene", 0);
        x.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", new Object[]{Integer.valueOf(intExtra)});
        com.tencent.mm.plugin.report.service.g.pQN.h(14721, new Object[]{Integer.valueOf(2), Integer.valueOf(intExtra)});
    }

    protected final void ayW() {
    }

    protected final void initView() {
        this.lkH = (ImageView) findViewById(f.uuj);
        this.lkI = (TextView) findViewById(f.uuo);
        this.lkJ = (TextView) findViewById(f.uum);
        this.lkK = (TextView) findViewById(f.uuk);
        this.lkL = (TextView) findViewById(f.uup);
        this.lkM = (MMGridView) findViewById(f.uul);
        this.lkN = (TextView) findViewById(f.uun);
        this.lkO = new a();
        this.lkM.setAdapter(this.lkO);
        this.lkM.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ QrRewardSelectMoneyUI lkR;

            {
                this.lkR = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                QrRewardSelectMoneyUI.a(this.lkR, ((Integer) adapterView.getAdapter().getItem(i)).intValue(), 1);
            }
        });
        this.lkN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ QrRewardSelectMoneyUI lkR;

            {
                this.lkR = r1;
            }

            public final void onClick(View view) {
                QrRewardSelectMoneyUI.a(this.lkR, 0, 2);
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.collect.reward.a.f) {
            final com.tencent.mm.plugin.collect.reward.a.f fVar = (com.tencent.mm.plugin.collect.reward.a.f) kVar;
            fVar.a(new 5(this, fVar)).b(new a$a(this) {
                final /* synthetic */ QrRewardSelectMoneyUI lkR;

                public final void i(k kVar) {
                    x.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
                    if (!bh.ov(fVar.ljx.liI)) {
                        Toast.makeText(this.lkR, fVar.ljx.liI, 1).show();
                    }
                    this.lkR.finish();
                }
            }).c(new a$a(this) {
                final /* synthetic */ QrRewardSelectMoneyUI lkR;

                public final void i(k kVar) {
                    x.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", new Object[]{fVar});
                    com.tencent.mm.ui.base.h.a(this.lkR.mController.xIM, this.lkR.getString(i.uXa), null, false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 lkT;

                        {
                            this.lkT = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.lkT.lkR.finish();
                        }
                    });
                }
            });
            super.ayW();
            uD(0);
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.uDM;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1516);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            x.i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
            finish();
        }
    }
}
