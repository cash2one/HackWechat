package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public class ShakeMsgListUI extends MMActivity {
    private int asN = 0;
    private int fqe;
    private p$d kBR = new 6(this);
    private long knc;
    private TextView llq;
    private int mType;
    private int oPj = 0;
    private int oPk = 0;
    private g qqN = null;
    private d qqO;
    private ListView qqP;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("shake_msg_type", 0);
        this.qqN = m.brD();
        this.oPk = this.qqN.Tq();
        this.asN = this.oPk == 0 ? 8 : this.oPk;
        this.oPj = this.qqN.getCount();
        this.fqe = getIntent().getIntExtra("shake_msg_from", 1);
        if (this.fqe == 1) {
            com.tencent.mm.plugin.report.service.g.pQN.h(11313, new Object[]{Integer.valueOf(this.oPk), e.bsz()});
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.h(11315, new Object[]{Integer.valueOf(this.oPk), e.bsz()});
        }
        g gVar = this.qqN;
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(1));
        gVar.gJP.update(gVar.getTableName(), contentValues, "status!=? ", new String[]{"1"});
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.oPj != this.qqN.getCount()) {
            this.oPj = this.qqN.getCount();
            if (this.oPj == 0) {
                bsk();
            }
            this.qqO.Xy();
        }
        this.qqO.notifyDataSetChanged();
    }

    public void onDestroy() {
        this.qqO.aUn();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dst;
    }

    protected final void initView() {
        setMMTitle(getIntent().getStringExtra("shake_msg_list_title"));
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.dEo), new 2(this));
        this.llq = (TextView) findViewById(R.h.cem);
        if (this.oPj == 0) {
            bsk();
        }
        this.qqP = (ListView) findViewById(R.h.cMT);
        View inflate = getLayoutInflater().inflate(R.i.dqT, null);
        inflate.setOnClickListener(new 3(this, inflate));
        if (this.oPj > 0 && this.asN < this.oPj) {
            this.qqP.addFooterView(inflate);
        }
        this.qqO = new d(this);
        this.qqO.qqK = this.asN;
        this.qqP.setAdapter(this.qqO);
        this.qqP.setOnItemClickListener(new 4(this));
        this.qqP.setOnItemLongClickListener(new 5(this, new l(this)));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.knc = ((f) this.qqO.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dEw);
    }

    private void bsk() {
        this.llq.setText(R.l.eOF);
        this.llq.setVisibility(0);
        enableOptionMenu(false);
    }
}
