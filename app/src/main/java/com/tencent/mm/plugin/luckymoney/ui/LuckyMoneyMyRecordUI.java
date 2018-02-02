package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.y;
import com.tencent.mm.plugin.luckymoney.b.z;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI extends LuckyMoneyBaseUI {
    private boolean lAx = false;
    private ImageView lkk;
    private TextView llq;
    private int mType;
    public String odq = "";
    private boolean ogC = true;
    private List<h> ogJ = new LinkedList();
    private Map<String, Integer> ogK = new HashMap();
    public String ogM = "";
    private TextView ogw;
    private MMLoadMoreListView ohq;
    private d ohr;
    private TextView oif;
    private TextView oig;
    private TextView oih;
    private TextView oii;
    private TextView oij;
    private TextView oik;
    private TextView oil;
    private View oim;
    private String oin;
    private int oio = -1;
    public List<String> oip = new ArrayList();
    private int wn = 0;

    static /* synthetic */ void a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI, h hVar, int i) {
        if (hVar == null || i < 0 || i > luckyMoneyMyRecordUI.ohr.getCount()) {
            x.e("MicroMsg.LuckyMoneyMyRecordUI", "param is illegal");
            return;
        }
        luckyMoneyMyRecordUI.l(new z(hVar.nZa, hVar.obV, luckyMoneyMyRecordUI.mType, i, "v1.0"));
    }

    static /* synthetic */ void b(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        if (luckyMoneyMyRecordUI.ogJ != null) {
            luckyMoneyMyRecordUI.ogJ.clear();
        }
        if (luckyMoneyMyRecordUI.ogK != null) {
            luckyMoneyMyRecordUI.ogK.clear();
        }
        luckyMoneyMyRecordUI.wn = 0;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                View inflate = LayoutInflater.from(this).inflate(g.uCK, null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.upL);
                a aVar = new a(this);
                List list = this.oip;
                if (list == null) {
                    aVar.oip = new ArrayList();
                } else {
                    aVar.oip = list;
                }
                aVar.notifyDataSetChanged();
                aVar.atq = 0;
                listViewInScrollView.setAdapter(aVar);
                listViewInScrollView.setOnItemClickListener(new 8(this, aVar));
                a aVar2 = new a(this);
                aVar2.Ez(i.uKL);
                aVar2.dk(inflate);
                aVar2.d(null);
                return aVar2.akx();
            default:
                return null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 2);
        initView();
        aXA();
        com.tencent.mm.plugin.report.service.g.pQN.h(11701, new Object[]{Integer.valueOf(aXK()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        addIconOptionMenu(0, e.bDI, new 2(this));
        this.llq = (TextView) findViewById(f.uol);
        this.ohq = (MMLoadMoreListView) findViewById(f.uon);
        this.oim = LayoutInflater.from(this).inflate(g.uCx, null);
        this.ohq.addHeaderView(this.oim);
        this.lkk = (ImageView) this.oim.findViewById(f.unZ);
        this.oif = (TextView) this.oim.findViewById(f.uoc);
        this.ogw = (TextView) this.oim.findViewById(f.unY);
        this.oig = (TextView) this.oim.findViewById(f.uod);
        this.oih = (TextView) this.oim.findViewById(f.uoe);
        this.oii = (TextView) this.oim.findViewById(f.uoa);
        this.oij = (TextView) this.oim.findViewById(f.uob);
        this.oik = (TextView) this.oim.findViewById(f.uoh);
        this.oil = (TextView) this.oim.findViewById(f.uog);
        this.ohq.setOnItemClickListener(new 3(this));
        this.ohq.setOnItemLongClickListener(new 4(this));
        this.ohq.ybX = new 5(this);
        this.lkk.setOnClickListener(new 6(this));
        aXJ();
    }

    private void aXJ() {
        this.oil.setVisibility(8);
        this.oim.findViewById(f.uof).setVisibility(8);
        if (this.mType == 1) {
            setMMTitle(getString(i.uKt));
            n.a(this.mController.xIM, this.oif, getString(i.uKM, new Object[]{q.FU()}));
            this.oih.setText(i.uKQ);
            this.ohr = new e(this.mController.xIM);
            this.oil.setVisibility(0);
        } else {
            setMMTitle(getString(i.uKs));
            n.a(this.mController.xIM, this.oif, getString(i.uKF, new Object[]{q.FU()}));
            this.oih.setText(i.uKG);
            this.ohr = new c(this.mController.xIM);
            this.oim.findViewById(f.uof).setVisibility(0);
        }
        this.ohq.setAdapter(this.ohr);
        b.a(this.lkk, q.FS(), 0.0f, false);
        this.oik.setText(getString(i.uKH, new Object[]{bh.ou(this.oin)}));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        h hVar;
        if (kVar instanceof y) {
            if (i == 0 && i2 == 0) {
                y yVar = (y) kVar;
                List list = yVar.odn.och;
                this.ogM = yVar.odd;
                this.odq = yVar.odq;
                if (this.wn == 0) {
                    this.oip = yVar.odo;
                    this.oin = yVar.odp;
                    View findViewById = findViewById(f.uoj);
                    ImageView imageView = (ImageView) findViewById(f.uoi);
                    if (this.oip.size() > 1) {
                        imageView.setVisibility(0);
                        findViewById.setOnClickListener(new 7(this));
                    }
                    this.oik.setText(getString(i.uKH, new Object[]{this.oin}));
                }
                com.tencent.mm.plugin.luckymoney.b.g gVar = yVar.odn;
                if (gVar != null) {
                    if (this.mType == 1) {
                        this.ogw.setText(com.tencent.mm.wallet_core.ui.e.t(((double) gVar.oco) / 100.0d));
                        String str2 = gVar.ocn;
                        CharSequence string = getString(i.uKP, new Object[]{str2});
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(c.uaR));
                        int indexOf = string.indexOf(str2);
                        CharSequence spannableString = new SpannableString(string);
                        spannableString.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
                        this.oil.setText(spannableString);
                    } else {
                        this.ogw.setText(com.tencent.mm.wallet_core.ui.e.t(((double) gVar.ocm) / 100.0d));
                        this.oig.setText(gVar.ocl);
                        this.oii.setText(gVar.hKN);
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        hVar = (h) list.get(i3);
                        if (!this.ogK.containsKey(hVar.nZa)) {
                            this.ogJ.add(list.get(i3));
                            this.ogK.put(hVar.nZa, Integer.valueOf(1));
                        }
                    }
                    this.wn += list.size();
                    this.ogC = yVar.aXi();
                    this.lAx = false;
                    this.ohr.bd(this.ogJ);
                }
                if (this.ogJ == null || this.ogJ.size() == 0) {
                    this.llq.setVisibility(0);
                } else {
                    this.llq.setVisibility(8);
                }
                if (this.ogC) {
                    this.ohq.cpp();
                } else {
                    this.ohq.cpq();
                }
                return true;
            }
            this.odq = null;
            return false;
        } else if (!(kVar instanceof z)) {
            return false;
        } else {
            int i4 = this.oio;
            this.oio = -1;
            if (i != 0 || i2 != 0) {
                return false;
            }
            hVar = this.ohr.sh(i4);
            if (hVar != null) {
                Toast.makeText(this, i.uKo, 0).show();
                this.ohr.a(hVar);
                this.ohr.notifyDataSetChanged();
            } else {
                x.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
            }
            return true;
        }
    }

    protected final int getLayoutId() {
        return g.uCz;
    }

    private void aXA() {
        this.lAx = true;
        if (this.wn == 0) {
            this.ogM = "";
        }
        l(new y(11, this.wn, this.mType, this.oin, "v1.0", this.ogM));
    }

    private int aXK() {
        if (this.mType == 1) {
            return 8;
        }
        return 9;
    }
}
