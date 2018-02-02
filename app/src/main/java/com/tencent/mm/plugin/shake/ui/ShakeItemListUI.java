package com.tencent.mm.plugin.shake.ui;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class ShakeItemListUI extends MMActivity {
    private a hCG = null;
    private int id;
    private View jMa;
    private p$d kBR = new p$d(this) {
        final /* synthetic */ ShakeItemListUI qqB;

        {
            this.qqB = r1;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            m.brC().vZ(this.qqB.id);
        }
    };
    private ListView oOC;
    private a qqA;
    public long qqy = 0;
    private boolean qqz = false;
    private int showType;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        m.brC().c(this.qqA);
        this.qqA.Xz();
        x.i("MicroMsg.ShakeItemListUI", "onResume");
    }

    protected final void initView() {
        this.hCG = new a(this);
        ar.Hg();
        int a = bh.a((Integer) c.CU().get(12290, null), 0);
        this.showType = getIntent().getIntExtra("_key_show_type_", 0);
        String stringExtra = getIntent().getStringExtra("_key_title_");
        if (!bh.ov(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.qqz = getIntent().getBooleanExtra("_key_show_from_shake_", false);
        addTextOptionMenu(0, getString(R.l.dEo), new 1(this));
        this.oOC = (ListView) findViewById(R.h.cyW);
        this.jMa = getLayoutInflater().inflate(R.i.dsq, null);
        this.jMa.findViewById(R.h.cMD).setOnClickListener(new 2(this));
        this.oOC.addFooterView(this.jMa);
        if (this.showType == -1) {
            this.jMa.findViewById(R.h.cMD).setVisibility(0);
        } else {
            this.jMa.findViewById(R.h.cMD).setVisibility(8);
        }
        this.qqA = new a(this, this);
        this.qqA.wg(this.showType);
        if (this.qqA.getCount() <= 0) {
            this.oOC.setVisibility(8);
            TextView textView = (TextView) findViewById(R.h.cyY);
            textView.setText(wh(this.showType));
            textView.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.oOC.setAdapter(this.qqA);
            this.oOC.setOnItemClickListener(new 3(this, a));
            this.oOC.setOnItemLongClickListener(new 4(this, new l(this)));
        }
        setBackBtn(new 5(this));
        AnonymousClass6 anonymousClass6 = new OnClickListener(this) {
            final /* synthetic */ ShakeItemListUI qqB;

            {
                this.qqB = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.qqB.oOC);
            }
        };
        this.oOC.setOnTouchListener(new 7(this));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.id = ((d) this.qqA.getItem(adapterContextMenuInfo.position)).field_shakeItemID;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dEw);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        this.qqA.aUn();
        a aVar = this.qqA;
        if (aVar.hvU != null) {
            aVar.hvU.detach();
            aVar.hvU = null;
        }
        m.brC().j(this.qqA);
        x.i("MicroMsg.ShakeItemListUI", "onPause");
        if (this.hCG != null) {
            this.hCG.detach();
        }
        super.onDestroy();
    }

    protected final void wg(int i) {
        this.qqA.wg(i);
        switch (i) {
            case -12:
            case -1:
                if (this.jMa != null) {
                    this.jMa.findViewById(R.h.cMD).setVisibility(0);
                    return;
                }
                return;
            case 0:
            case 11:
                if (this.jMa != null) {
                    this.jMa.findViewById(R.h.cMD).setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dso;
    }

    public static int wh(int i) {
        switch (i) {
            case -12:
            case 11:
                return R.l.eOq;
            case -6:
            case 5:
                return R.l.eOZ;
            case -5:
            case 4:
                return R.l.eOH;
            case -1:
            case 0:
                return R.l.eOk;
            case 100:
                return R.l.eOn;
            default:
                return R.l.eOk;
        }
    }
}
