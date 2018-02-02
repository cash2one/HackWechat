package com.tencent.mm.ui.contact;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class SnsLabelContactListUI extends MMActivity {
    private ListView nPx;
    private bjv qyf;
    private a yUH;
    private ArrayList<String> yUI = new ArrayList();
    private int yUJ;
    private String yUK;
    private b yUL;

    private static class c {
        TextView kEZ;
        MaskLayout ldx;
        TextView nJd;
        TextView yUR;

        private c() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.yUL = new b(this, (byte) 0);
        a.xef.b(this.yUL);
        this.yUJ = getIntent().getIntExtra("sns_label_sns_info", -1);
        if (this.yUJ == -1) {
            finish();
            return;
        }
        b hqVar = new hq();
        hqVar.fxW.ftB = this.yUJ;
        a.xef.m(hqVar);
        this.qyf = hqVar.fxX.fxY;
        if (this.qyf == null) {
            return;
        }
        if ((this.qyf.wzw == 3 && this.qyf.wNl != null && this.qyf.wNl.size() > 0) || (this.qyf.wzw == 5 && this.qyf.wym != null && this.qyf.wym.size() > 0)) {
            cwn();
            initView();
        }
    }

    private void cwn() {
        Iterator it;
        if (this.qyf.wzw == 3) {
            this.yUK = getString(R.l.ePR);
            it = this.qyf.wNl.iterator();
            while (it.hasNext()) {
                this.yUI.add(((bdo) it.next()).wJF);
            }
        } else if (this.qyf.wzw == 5) {
            this.yUK = getString(R.l.ePS);
            it = this.qyf.wym.iterator();
            while (it.hasNext()) {
                this.yUI.add(((bdo) it.next()).wJF);
            }
        }
    }

    protected final void initView() {
        setMMTitle(this.yUK);
        findViewById(R.h.ctC).setVisibility(8);
        this.nPx = (ListView) findViewById(R.h.bJe);
        ((TextView) findViewById(R.h.cee)).setVisibility(8);
        findViewById(R.h.bJn).setVisibility(8);
        this.nPx.setBackgroundColor(getResources().getColor(R.e.white));
        ((View) this.nPx.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
        setBackBtn(new 1(this));
        showOptionMenu(false);
        if (this.yUI != null && this.yUI.size() != 0) {
            this.yUH = new a(this, this.yUI);
            this.nPx.setAdapter(this.yUH);
            this.nPx.setVisibility(0);
            this.nPx.setOnItemClickListener(new 2(this));
        }
    }

    public void onResume() {
        super.onResume();
        if (this.yUH != null) {
            this.yUH.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        a.xef.c(this.yUL);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.daa;
    }
}
