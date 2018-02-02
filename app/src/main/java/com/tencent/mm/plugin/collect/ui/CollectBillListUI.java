package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.b;
import android.support.design.widget.c;
import android.support.v4.view.z;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.collect.b.h;
import com.tencent.mm.plugin.collect.b.q;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI extends WalletBaseUI {
    private int asN = 20;
    private Dialog ilS;
    private View kUE;
    private int lja = 0;
    private boolean llA = false;
    private long llB = 0;
    private long llC = 0;
    private Calendar llD;
    private List<h> llE = new ArrayList();
    private ListView llm;
    private b lln;
    private LinearLayout llo;
    private CollectPullDownView llp;
    private TextView llq;
    private Dialog llr;
    private boolean lls = false;
    private boolean llt = false;
    private boolean llu = false;
    private boolean llv = false;
    private boolean llw = false;
    private boolean llx = false;
    private boolean lly = true;
    private boolean llz = false;
    private int retryCount = 0;
    private int type = 0;

    static /* synthetic */ void a(CollectBillListUI collectBillListUI) {
        if (collectBillListUI.llr == null) {
            collectBillListUI.llr = new c(collectBillListUI);
            View datePickerDialogView = new DatePickerDialogView(collectBillListUI);
            datePickerDialogView.lnD = collectBillListUI.type;
            datePickerDialogView.azA();
            collectBillListUI.llr.setContentView(datePickerDialogView);
            datePickerDialogView.lnB.setOnClickListener(new 4(collectBillListUI, datePickerDialogView));
            datePickerDialogView.lnC.setOnClickListener(new 5(collectBillListUI));
            if (VERSION.SDK_INT >= 21) {
                collectBillListUI.llr.getWindow().addFlags(Integer.MIN_VALUE);
            }
            BottomSheetBehavior i = BottomSheetBehavior.i((View) datePickerDialogView.getParent());
            i.fj = false;
            if (3 != i.mState) {
                if (i.fq == null) {
                    i.mState = 3;
                } else {
                    View view = (View) i.fq.get();
                    if (view != null) {
                        int i2 = i.fh;
                        i.r(2);
                        if (i.fk.e(view, view.getLeft(), i2)) {
                            z.a(view, new b(i, view, 3));
                        }
                    }
                }
            }
            ag.h(new 6(collectBillListUI, datePickerDialogView, i), 300);
        }
        collectBillListUI.llr.show();
    }

    static /* synthetic */ void a(CollectBillListUI collectBillListUI, long j) {
        x.i("MicroMsg.CollectBillListUI", "get filter page, type: %d, timestamp: %s", new Object[]{Integer.valueOf(collectBillListUI.type), Long.valueOf(j)});
        collectBillListUI.llt = false;
        collectBillListUI.azh();
        collectBillListUI.zIY.aXc();
        collectBillListUI.llu = false;
        collectBillListUI.llv = false;
        collectBillListUI.r(new q(collectBillListUI.type, j, collectBillListUI.asN, 1));
        collectBillListUI.llw = true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setMMTitle(a$i.uIq);
        if (this.llA) {
            addIconOptionMenu(0, a$h.uGq, new 1(this));
        }
        this.ilS = g.a(this, false, new 3(this));
        azj();
        com.tencent.mm.plugin.report.service.g.pQN.h(13944, new Object[]{Integer.valueOf(4)});
    }

    protected final void initView() {
        this.llm = (ListView) findViewById(f.uii);
        this.llo = (LinearLayout) findViewById(f.uig);
        this.llq = (TextView) findViewById(f.uih);
        this.kUE = v.fv(this).inflate(a$g.uBv, this.llm, false);
        View view = new View(this);
        view.setLayoutParams(new LayoutParams(-1, a.fromDPToPix(this, 5)));
        this.llm.addHeaderView(view, null, true);
        new View(this).setLayoutParams(new LayoutParams(-1, a.fromDPToPix(this, 10)));
        this.llm.addFooterView(view, null, true);
        this.llm.setOverScrollMode(2);
        this.lln = new b(this);
        this.llm.setAdapter(this.lln);
        this.llm.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CollectBillListUI llF;

            {
                this.llF = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                x.d("MicroMsg.CollectBillListUI", "click item: %d", new Object[]{Integer.valueOf(i)});
                if (i >= 0 && i < adapterView.getAdapter().getCount()) {
                    Intent intent = new Intent(this.llF.mController.xIM, CollectBillUI.class);
                    h hVar = (h) adapterView.getItemAtPosition(i);
                    if (hVar == null) {
                        x.w("MicroMsg.CollectBillListUI", "invaild record: %d", new Object[]{Integer.valueOf(i)});
                        return;
                    }
                    intent.putExtra("key_type", hVar.type);
                    intent.putExtra("key_timestamp", hVar.liA);
                    intent.putExtra("key_from_scene", 2);
                    this.llF.startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.pQN.h(13944, new Object[]{Integer.valueOf(3)});
                }
            }
        });
        this.llm.setOnScrollListener(new 8(this));
        this.llp = (CollectPullDownView) findViewById(f.uik);
        this.llp.mp(false);
        this.llp.mm(false);
        this.llp.mo(true);
        this.llp.mn(false);
        this.llp.ycJ = true;
        this.llp.ycC = new 9(this);
        this.llp.ycB = new 10(this);
        this.llp.ycp = new MMPullDownView.g(this) {
            final /* synthetic */ CollectBillListUI llF;

            {
                this.llF = r1;
            }

            public final boolean azn() {
                x.d("MicroMsg.CollectBillListUI", "top load");
                return true;
            }
        };
        this.llp.ycq = new 2(this);
    }

    protected final int getLayoutId() {
        return a$g.uBt;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof q)) {
            return false;
        }
        q qVar = (q) kVar;
        if (this.ilS.isShowing()) {
            this.ilS.dismiss();
        }
        this.llp.ycx = true;
        if (i == 0 && i2 == 0) {
            b bVar;
            if (qVar.lja != 0) {
                this.llx = qVar.hik;
                if (qVar.liZ) {
                    if (!qVar.lje.isEmpty()) {
                        this.llE.addAll(qVar.lje);
                    }
                    if (qVar.ljc != 0 || qVar.ljd <= 0) {
                        this.retryCount = 0;
                        this.lly = true;
                        this.llC = qVar.liA;
                        if (qVar.ljc == 0) {
                            this.llx = false;
                        } else {
                            this.llx = true;
                        }
                        if (this.llE.size() > 0) {
                            this.lln.ax(this.llE);
                        } else {
                            x.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
                            azi();
                            if (!bh.ov(qVar.jcO)) {
                                this.llq.setText(qVar.jcO);
                                this.llq.setVisibility(0);
                            }
                            bVar = this.lln;
                            bVar.lli.clear();
                            bVar.notifyDataSetChanged();
                        }
                    } else {
                        x.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[]{Integer.valueOf(this.retryCount)});
                        a(qVar.ljd, qVar.liA, qVar.ljb, qVar.lja);
                    }
                    return true;
                }
                if (!qVar.lje.isEmpty()) {
                    this.lln.ax(qVar.lje);
                    this.llB = ((h) qVar.lje.get(0)).liA;
                    this.llC = ((h) qVar.lje.get(qVar.lje.size() - 1)).liA;
                } else if (qVar.ljc != 0 || qVar.ljd <= 0) {
                    azi();
                } else {
                    x.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[]{Integer.valueOf(qVar.ljd), Long.valueOf(qVar.liA)});
                    a(qVar.ljd, qVar.liA, qVar.ljb, qVar.lja);
                    this.llE.clear();
                }
                this.llw = false;
                this.lly = false;
            } else if (this.llw) {
                x.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
                return true;
            } else if (qVar.ljb == 1) {
                this.lly = qVar.hik;
                if (qVar.lje.isEmpty()) {
                    this.lly = true;
                } else {
                    bVar = this.lln;
                    bVar.lli.addAll(0, qVar.lje);
                    bVar.notifyDataSetChanged();
                    this.llB = ((h) qVar.lje.get(0)).liA;
                }
                this.llv = false;
                this.llt = false;
            } else {
                this.llx = qVar.hik;
                this.llm.setVisibility(0);
                this.llo.setVisibility(8);
                if (qVar.liZ) {
                    if (!qVar.lje.isEmpty()) {
                        this.llE.addAll(qVar.lje);
                    }
                    if (qVar.ljc == 0 && qVar.ljd > 0 && qVar.lje.isEmpty()) {
                        x.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[]{Integer.valueOf(this.retryCount)});
                        a(qVar.ljd, qVar.liA, qVar.ljb, qVar.lja);
                    } else {
                        this.retryCount = 0;
                        if (this.llE.size() > 0) {
                            this.lln.ay(this.llE);
                        } else {
                            x.i("MicroMsg.CollectBillListUI", "retry data is empty");
                            xt(qVar.jcO);
                        }
                        this.llu = false;
                        this.llC = qVar.liA;
                        azh();
                        en(this.llx);
                    }
                    return true;
                } else if (!qVar.lje.isEmpty()) {
                    this.lln.ay(qVar.lje);
                    this.llC = ((h) qVar.lje.get(qVar.lje.size() - 1)).liA;
                    if (this.llC > qVar.liA) {
                        x.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                        this.llC = qVar.liA;
                    } else {
                        x.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[]{Long.valueOf(this.llC), Long.valueOf(qVar.liA)});
                    }
                    this.llu = false;
                    azh();
                    en(this.llx);
                } else if (qVar.ljc != 0 || qVar.ljd <= 0) {
                    this.llu = false;
                    azh();
                    x.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
                    xt(qVar.jcO);
                    en(this.llx);
                } else {
                    x.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[]{Integer.valueOf(qVar.ljd), Long.valueOf(qVar.liA)});
                    a(qVar.ljd, qVar.liA, qVar.ljb, qVar.lja);
                    this.llE.clear();
                }
            }
            return true;
        }
        x.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(qVar.lja), Integer.valueOf(qVar.ljb)});
        if (qVar.lja != 0) {
            this.llw = false;
        } else if (qVar.ljb == 0) {
            this.llu = false;
            azh();
        } else {
            this.llv = false;
        }
        if (this.lln.isEmpty()) {
            azi();
        }
        Toast.makeText(this, a$i.uIn, 1).show();
        return true;
    }

    private void azh() {
        this.llp.scrollTo(0, this.llp.ycr);
    }

    private void azi() {
        this.llm.setVisibility(8);
        this.llo.setVisibility(0);
        this.llq.setVisibility(0);
    }

    private void xt(String str) {
        if (this.lln.getCount() == 0) {
            x.i("MicroMsg.CollectBillListUI", "show empty view");
            if (!bh.ov(str)) {
                this.llq.setText(str);
            } else if (this.llx) {
                this.llq.setText(getString(a$i.uIo));
            } else {
                this.llq.setText(getString(a$i.uIo) + getString(a$i.uIp));
            }
            azi();
        } else if (!bh.ov(str)) {
            Toast.makeText(this.mController.xIM, str, 1).show();
        }
    }

    private void en(boolean z) {
        this.llp.mo(!z);
    }

    private void azj() {
        int count = this.lln.getCount();
        if (count > 0) {
            long j = this.lln.or(count - 1).liA;
            if (j < this.llC) {
                x.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[]{Long.valueOf(j), Long.valueOf(this.llC)});
                this.llC = j;
            }
        }
        x.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[]{Integer.valueOf(this.type), Long.valueOf(this.llC)});
        b(new q(this.type, this.llC, this.asN, 0), false);
        this.llu = true;
    }

    private void a(int i, long j, int i2, int i3) {
        x.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", new Object[]{Integer.valueOf(this.type), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        b(new q(this.type, j, i2, this.asN, i3, i), false);
        this.retryCount++;
    }
}
