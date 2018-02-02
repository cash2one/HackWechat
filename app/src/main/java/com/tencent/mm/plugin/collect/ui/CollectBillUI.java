package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.b.j;
import com.tencent.mm.plugin.collect.b.p;
import com.tencent.mm.plugin.collect.b.r;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.z.q;

public class CollectBillUI extends WalletBaseUI {
    private int asN = 20;
    private int fromScene;
    private boolean hik = false;
    private String ihh;
    private l juS;
    private View kUE;
    private long liA;
    private a llI;
    private LinearLayout llJ;
    private CollectBillHeaderView llK;
    private ImageView llL;
    private MMSwitchBtn llM;
    private ImageView llN;
    private MMSwitchBtn llO;
    private TextView llP;
    private boolean llQ = false;
    private boolean llR = true;
    private long llS;
    private e llT = new 1(this);
    private d llU = new 7(this);
    private ListView llm;
    private boolean llu = false;
    private int type;

    static /* synthetic */ void a(CollectBillUI collectBillUI, String str, long j) {
        x.i("MicroMsg.CollectBillUI", "do delete, billid: %s, timestamp: %s", new Object[]{str, Long.valueOf(j)});
        k pVar = new p(str, collectBillUI.type, j);
        collectBillUI.llR = true;
        collectBillUI.r(pVar);
    }

    static /* synthetic */ void f(CollectBillUI collectBillUI) {
        if (!collectBillUI.llQ) {
            x.d("MicroMsg.CollectBillUI", "show loading");
            collectBillUI.llm.addFooterView(collectBillUI.kUE, null, false);
            collectBillUI.llQ = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.llS = q.FX();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        this.type = getIntent().getIntExtra("key_type", 0);
        this.liA = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000);
        azj();
        initView();
        setMMTitle(i.uIs);
        g.Dk();
        g.Di().gPJ.a(1256, this.llT);
        k jVar = new j();
        g.Dk();
        g.Di().gPJ.a(jVar, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        g.Dk();
        g.Di().gPJ.b(1256, this.llT);
    }

    protected final void initView() {
        this.llm = (ListView) findViewById(f.uil);
        this.llJ = (LinearLayout) findViewById(f.uhW);
        this.llP = (TextView) findViewById(f.uhT);
        this.kUE = v.fv(this).inflate(a.g.uBw, this.llm, false);
        this.llK = new CollectBillHeaderView(this);
        this.llm.addHeaderView(this.llK, null, false);
        this.llI = new a(this);
        this.llm.setAdapter(this.llI);
        this.llm.setOnScrollListener(new 2(this));
        this.juS = new l(this);
        this.llm.setOnItemClickListener(new 3(this));
        this.llm.setOnItemLongClickListener(new 4(this));
        if (this.fromScene != 2) {
            addTextOptionMenu(0, getString(i.uIq), new 5(this));
        }
        if (this.fromScene == 2) {
            View findViewById = this.llK.findViewById(f.uiV);
            View findViewById2 = this.llJ.findViewById(f.uiU);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        this.llL = (ImageView) this.llK.findViewById(f.uiS);
        this.llM = (MMSwitchBtn) this.llK.findViewById(f.uiT);
        this.llN = (ImageView) this.llJ.findViewById(f.uiS);
        this.llO = (MMSwitchBtn) this.llJ.findViewById(f.uiT);
        com.tencent.mm.plugin.collect.a.a.ayE();
        if (com.tencent.mm.plugin.collect.a.a.ayG()) {
            this.llM.nB(true);
            this.llO.nB(true);
            this.llL.setImageResource(h.uGu);
            this.llN.setImageResource(h.uGu);
        } else {
            this.llM.nB(false);
            this.llO.nB(false);
            this.llL.setImageResource(h.uGt);
            this.llN.setImageResource(h.uGt);
        }
        MMSwitchBtn.a 6 = new 6(this);
        this.llM.zvp = 6;
        this.llO.zvp = 6;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, i.uIr);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof r) {
            r rVar = (r) kVar;
            if (this.llQ) {
                this.llm.removeFooterView(this.kUE);
                this.llQ = false;
            }
            if (i == 0 && i2 == 0) {
                this.hik = rVar.hik;
                this.type = rVar.type;
                this.liA = rVar.liA;
                d(rVar.liB, rVar.liC, rVar.liA);
                if (rVar.lje.isEmpty()) {
                    this.hik = true;
                    if (bh.ov(this.ihh)) {
                        x.i("MicroMsg.CollectBillUI", "no record, show empty view");
                        azi();
                    }
                } else {
                    if (bh.ov(this.ihh)) {
                        x.d("MicroMsg.CollectBillUI", "first query, hide block view");
                        this.llm.setVisibility(0);
                        this.llJ.setVisibility(8);
                    }
                    a aVar = this.llI;
                    aVar.lli.addAll(rVar.lje);
                    aVar.notifyDataSetChanged();
                    this.ihh = ((com.tencent.mm.plugin.collect.b.a) rVar.lje.get(rVar.lje.size() - 1)).lid;
                }
                this.llu = false;
                return true;
            }
            x.i("MicroMsg.CollectBillUI", "net error!");
            this.llu = false;
            Toast.makeText(this, i.uIn, 1).show();
            if (bh.ov(this.ihh)) {
                x.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
            }
            return true;
        } else if (!(kVar instanceof p)) {
            return false;
        } else {
            p pVar = (p) kVar;
            if (i == 0 && i2 == 0) {
                a aVar2 = this.llI;
                String str2 = pVar.lid;
                for (com.tencent.mm.plugin.collect.b.a aVar3 : aVar2.lli) {
                    if (aVar3.lid.equals(str2)) {
                        aVar2.lli.remove(aVar3);
                        aVar2.notifyDataSetChanged();
                        break;
                    }
                }
                if (this.llI.getCount() <= 0) {
                    x.i("MicroMsg.CollectBillUI", "delete all records");
                    azi();
                } else {
                    d(pVar.liB, pVar.liC, this.liA);
                }
                return false;
            }
            x.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, pVar.lid});
            Toast.makeText(this, i.uIm, 1).show();
            return false;
        }
    }

    protected final int getLayoutId() {
        return a.g.uBp;
    }

    private void d(int i, int i2, long j) {
        if (this.llR) {
            CollectBillHeaderView collectBillHeaderView = this.llK;
            collectBillHeaderView.llj.setText(com.tencent.mm.plugin.collect.b.e.a(collectBillHeaderView.getContext(), j, this.type));
            collectBillHeaderView.llk.setText(com.tencent.mm.plugin.collect.b.e.oq(i2));
            collectBillHeaderView.lkn.setText(collectBillHeaderView.getContext().getString(i.uIt, new Object[]{Integer.valueOf(i)}));
            this.llR = false;
        }
    }

    private void azj() {
        if (!this.hik) {
            r(new r(this.type, this.liA, this.ihh, this.asN));
            this.llu = true;
        }
    }

    private void azi() {
        this.llm.setVisibility(8);
        this.llJ.setVisibility(0);
        findViewById(f.uhX).setVisibility(0);
    }
}
