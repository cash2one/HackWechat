package com.tencent.mm.plugin.sns.lucky.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.q.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import java.util.LinkedList;
import java.util.List;

public class SnsLuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    OnScrollListener ogO = new 1(this);
    private ListView ogr;
    private final int ohK = 750;
    private final int ohL = 240;
    private b qSe;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        List DS = a.DS(getIntent().getStringExtra("key_feedid"));
        if (!(DS == null || DS.size() == 0)) {
            b bVar = this.qSe;
            if (DS == null) {
                LinkedList linkedList = new LinkedList();
            } else {
                bVar.ogJ = DS;
            }
            bVar.notifyDataSetChanged();
        }
        cmS();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(c.ubr));
        }
        setMMSubTitle(null);
    }

    protected final void initView() {
        r(getResources().getDrawable(e.ucI));
        setMMTitle(i.uOm);
        setBackBtn(new 2(this));
        this.ogr = (ListView) findViewById(f.uns);
        this.qSe = new b(this.mController.xIM);
        this.ogr.setAdapter(this.qSe);
        this.ogr.setOnScrollListener(this.ogO);
        this.ogr.setOnItemClickListener(new 3(this));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uEk;
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
