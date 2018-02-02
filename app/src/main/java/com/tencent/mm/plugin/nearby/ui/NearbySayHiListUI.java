package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
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
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bf.h;
import com.tencent.mm.bf.i;
import com.tencent.mm.bf.l;
import com.tencent.mm.bk.a;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;

public class NearbySayHiListUI extends MMActivity implements e {
    private int asN = 0;
    private int gBI = 0;
    private ListView ilk;
    private d kBR = new 3(this);
    private c oOp;
    private i oPh = null;
    private a oPi;
    private int oPj = 0;
    private int oPk = 0;
    private boolean oPl;
    private long oPm;
    private View oim;
    private r tipDialog = null;

    static /* synthetic */ void j(NearbySayHiListUI nearbySayHiListUI) {
        if (nearbySayHiListUI.oPj == 0) {
            TextView textView = (TextView) nearbySayHiListUI.findViewById(R.h.cem);
            textView.setText(R.l.eHm);
            textView.setVisibility(0);
            nearbySayHiListUI.enableOptionMenu(false);
        }
    }

    public void onCreate(Bundle bundle) {
        int i;
        NearbySayHiListUI nearbySayHiListUI;
        super.onCreate(bundle);
        this.gBI = bh.VI(g.zY().getValue("ThresholdToCleanLocation"));
        this.oPl = getIntent().getBooleanExtra("show_clear_header", false);
        this.oPh = l.Ty();
        setMMTitle(R.l.eHk);
        this.oPk = this.oPh.Tq();
        this.oPj = this.oPh.getCount();
        if (a.bXU()) {
            i = this.oPj;
            nearbySayHiListUI = this;
        } else if (this.oPk == 0) {
            i = 8;
            nearbySayHiListUI = this;
        } else {
            i = this.oPk;
            nearbySayHiListUI = this;
        }
        nearbySayHiListUI.asN = i;
        this.oPh.Ts();
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.oPj != this.oPh.getCount()) {
            this.oPj = this.oPh.getCount();
            if (this.oPj == 0) {
                TextView textView = (TextView) findViewById(R.h.cem);
                textView.setText(R.l.eHm);
                textView.setVisibility(0);
                enableOptionMenu(false);
            }
            this.oPi.Xy();
        }
        this.oPi.notifyDataSetChanged();
        ar.CG().a(JsApiScanCode.CTRL_INDEX, this);
    }

    public void onDestroy() {
        this.oPi.aUn();
        super.onDestroy();
    }

    public void onPause() {
        ar.CG().b(JsApiScanCode.CTRL_INDEX, this);
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dmC;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final void initView() {
        this.ilk = (ListView) findViewById(R.h.cII);
        if (!a.bXU()) {
            View inflate = getLayoutInflater().inflate(R.i.dqT, null);
            inflate.setOnClickListener(new 1(this, inflate));
            if (this.oPj > 0 && this.asN < this.oPj) {
                this.ilk.addFooterView(inflate);
            }
        }
        addTextOptionMenu(0, getString(R.l.dEo), new 5(this));
        if (this.oPj == 0) {
            TextView textView = (TextView) findViewById(R.h.cem);
            textView.setText(R.l.eHm);
            textView.setVisibility(0);
            enableOptionMenu(false);
        }
        if (this.oPl && this.gBI != 0 && this.oPk >= this.gBI && bh.PT()) {
            this.oim = new CleanLocationHeaderView(this);
            this.oim.setOnClickListener(new 6(this));
            this.ilk.addHeaderView(this.oim);
        }
        this.oPi = new a(this, this, this.oPh, this.asN);
        this.oPi.a(new 7(this));
        this.oPi.a(new 8(this));
        this.oPi.a(new 9(this));
        this.ilk.setAdapter(this.oPi);
        this.ilk.setOnItemLongClickListener(new 10(this, new com.tencent.mm.ui.tools.l(this)));
        this.ilk.setOnItemClickListener(new 11(this));
        setBackBtn(new 12(this));
        AnonymousClass2 anonymousClass2 = new OnClickListener(this) {
            final /* synthetic */ NearbySayHiListUI oPo;

            {
                this.oPo = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.oPo.ilk);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        h hVar = (h) this.oPi.getItem(adapterContextMenuInfo.position);
        if (hVar == null) {
            x.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            return;
        }
        contextMenu.add(0, 0, 0, R.l.dEw);
        this.oPm = hVar.field_svrid;
    }

    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i != 0 || i2 != 0) {
            x.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
        } else if (((c) kVar).IS() == 2) {
            com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.exb), "", new DialogInterface.OnClickListener(this) {
                final /* synthetic */ NearbySayHiListUI oPo;

                {
                    this.oPo = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oPo.setResult(-1);
                    this.oPo.finish();
                }
            });
            this.oOp = null;
        }
    }
}
