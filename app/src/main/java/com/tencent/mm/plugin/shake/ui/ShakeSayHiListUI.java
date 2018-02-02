package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bf.j;
import com.tencent.mm.bf.k;
import com.tencent.mm.bf.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p.d;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public class ShakeSayHiListUI extends MMActivity {
    private int asN = 0;
    private ListView ilk;
    private d kBR = new 2(this);
    private long knc;
    private int oPj = 0;
    private int oPk = 0;
    private k qqh = null;
    private int qsp = 0;
    private b qsq;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qsp = getIntent().getIntExtra("IntentSayHiType", 1);
        if (this.qsp == 1) {
            this.qqh = l.Tz();
            setMMTitle(R.l.eHl);
        } else {
            setMMTitle(R.l.eHk);
        }
        this.oPk = this.qqh.Tq();
        this.asN = this.oPk == 0 ? 8 : this.oPk;
        this.oPj = this.qqh.getCount();
        k kVar = this.qqh;
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(4));
        if (kVar.gJP.update(kVar.getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            kVar.doNotify();
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.oPj != this.qqh.getCount()) {
            this.oPj = this.qqh.getCount();
            if (this.oPj == 0) {
                TextView textView = (TextView) findViewById(R.h.cem);
                textView.setText(R.l.eHm);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.qsq.Xy();
        }
        this.qsq.notifyDataSetChanged();
    }

    public void onDestroy() {
        this.qsq.aUn();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (this.qsq.kBF != null) {
            this.qsq.kBF.aUy();
        }
    }

    protected final int getLayoutId() {
        return R.i.dmC;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final void initView() {
        View inflate = getLayoutInflater().inflate(R.i.dqT, null);
        this.ilk = (ListView) findViewById(R.h.cII);
        inflate.setOnClickListener(new 1(this, inflate));
        addTextOptionMenu(0, getString(R.l.dEo), new 3(this));
        if (this.oPj == 0) {
            TextView textView = (TextView) findViewById(R.h.cem);
            textView.setText(R.l.eHm);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.oPj > 0 && this.asN < this.oPj) {
            this.ilk.addFooterView(inflate);
        }
        this.qsq = new b(this, this.qqh, this.asN);
        this.qsq.a(new 4(this));
        this.qsq.a(new 5(this));
        this.qsq.a(new 6(this));
        this.ilk.setAdapter(this.qsq);
        this.ilk.setOnItemClickListener(new 7(this));
        this.ilk.setOnItemLongClickListener(new 8(this, new com.tencent.mm.ui.tools.l(this)));
        setBackBtn(new 9(this));
        AnonymousClass10 anonymousClass10 = new OnClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI qsr;

            {
                this.qsr = r1;
            }

            public final void onClick(View view) {
                c.a(this.qsr.ilk);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.knc = ((j) this.qsq.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dEw);
    }
}
