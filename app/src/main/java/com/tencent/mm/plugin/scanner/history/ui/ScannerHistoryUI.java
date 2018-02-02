package com.tencent.mm.plugin.scanner.history.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.history.a.a;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.ui.MMActivity;

public class ScannerHistoryUI extends MMActivity {
    private ListView Fv;
    private LinearLayout kVl;
    private View kVm;
    private TextView kVn;
    private View kgl;
    private a pSm;

    static /* synthetic */ void a(ScannerHistoryUI scannerHistoryUI, int i) {
        a aVar = (a) scannerHistoryUI.pSm.getItem(i);
        if (aVar != null) {
            Intent intent = new Intent();
            intent.setClass(scannerHistoryUI, ProductUI.class);
            intent.setFlags(65536);
            intent.putExtra("key_Product_xml", aVar.field_xmlContent);
            intent.putExtra("key_Product_funcType", aVar.field_funcType);
            intent.putExtra("key_Qrcode_Url", aVar.field_qrcodeUrl);
            intent.putExtra("key_need_add_to_history", false);
            scannerHistoryUI.startActivity(intent);
            g.pQN.h(12684, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
        }
    }

    protected final int getLayoutId() {
        return R.i.drc;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eHE);
        setBackBtn(new 1(this));
        this.Fv = (ListView) findViewById(R.h.cIT);
        this.kVl = (LinearLayout) View.inflate(getBaseContext(), R.i.drb, null);
        this.Fv.addHeaderView(this.kVl);
        this.pSm = new a(this);
        this.Fv.setAdapter(this.pSm);
        this.Fv.setOnItemClickListener(new 2(this));
        this.Fv.setOnItemLongClickListener(new 3(this));
        addTextOptionMenu(0, getString(R.l.dNM), new 4(this));
        this.kgl = findViewById(R.h.bYR);
        this.kVm = View.inflate(this, R.i.dra, null);
        if (this.kVl != null) {
            this.kVl.addView(this.kVm);
        }
        this.kVn = (TextView) this.kVm.findViewById(R.h.coD);
        this.kVn.setText(R.l.epi);
        ava();
    }

    private void ava() {
        if (c.boB().getCount() > 0) {
            this.Fv.setVisibility(0);
            this.kgl.setVisibility(8);
            this.kVm.setVisibility(0);
            enableOptionMenu(true);
        } else {
            this.Fv.setVisibility(8);
            this.kgl.setVisibility(0);
            this.kVm.setVisibility(8);
            enableOptionMenu(false);
        }
        this.pSm.notifyDataSetChanged();
    }
}
