package com.tencent.mm.plugin.luckymoney.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.luckymoney.b.y;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI extends LuckyMoneyBaseUI {
    private boolean lAx = false;
    private boolean ogC = true;
    private List<h> ogJ = new LinkedList();
    private String ogM = "";
    private MMLoadMoreListView ohq;
    private d ohr;
    private int wn = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        aXA();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        this.ohq = (MMLoadMoreListView) findViewById(f.uon);
        setMMTitle(getString(a$i.uKm));
        this.ohr = new e(this.mController.xIM);
        this.ohq.setAdapter(this.ohr);
        this.ohq.setOnItemClickListener(new 2(this));
        this.ohq.ybX = new 3(this);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof y) || i != 0 || i2 != 0) {
            return false;
        }
        y yVar = (y) kVar;
        List list = yVar.odn.och;
        this.ogM = yVar.odd;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.ogJ.add(list.get(i3));
            }
            this.wn += list.size();
            this.ogC = yVar.aXi();
            this.lAx = false;
            this.ohr.bd(this.ogJ);
        }
        if (this.ogC) {
            this.ohq.cpp();
        } else {
            this.ohq.cpq();
        }
        return true;
    }

    protected final int getLayoutId() {
        return a$g.uCz;
    }

    private void aXA() {
        this.lAx = true;
        if (this.wn == 0) {
            this.ogM = "";
        }
        l(new y(10, this.wn, 3, "", "v1.0", this.ogM));
    }
}
