package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bf.b;
import com.tencent.mm.bf.e;
import com.tencent.mm.bf.l;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.o$a;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.a.f;
import com.tencent.mm.z.a.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class FMessageConversationUI extends MMActivity {
    private d kBR = new d(this) {
        final /* synthetic */ FMessageConversationUI rXh;

        {
            this.rXh = r1;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            e.e(this.rXh.rXg, this.rXh.pnS);
        }
    };
    private String pnS;
    private b rWO;
    private ListView rXd;
    private a rXe;
    private TextView rXf;
    private long rXg;

    class a {
        ImageView jMv;
        TextView jpW;
        final /* synthetic */ FMessageConversationUI rXh;

        public a(FMessageConversationUI fMessageConversationUI, View view) {
            this.rXh = fMessageConversationUI;
            this.jMv = (ImageView) view.findViewById(R.h.ciJ);
            this.jpW = (TextView) view.findViewById(R.h.ciK);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eif);
        try {
            ar.getNotification().wY();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FMessageConversationUI", e, "try cancel notification fail", new Object[0]);
        }
        if (ar.Hj()) {
            initView();
        } else {
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
        ar.Hg();
        c.CU().set(143618, Integer.valueOf(0));
    }

    protected void onResume() {
        super.onResume();
        if (!ar.Hj()) {
            finish();
        } else if (this.rXf != null && bh.PT()) {
            this.rXf.setText(R.l.eii);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        f.ij("1");
        l.Tx().Tk();
        if (this.rWO != null) {
            l.Tx().j(this.rWO);
        }
    }

    protected final void initView() {
        boolean z = true;
        if (g.Ij().ie("1") != null) {
            int i;
            String str = g.Ij().ie("1").value;
            if (str.equals("0")) {
                i = 0;
            } else if (str.equals("1")) {
                r0 = true;
            } else {
                r0 = true;
            }
            f.ii("1");
            int i2 = i;
        } else {
            boolean z2 = true;
        }
        this.rWO = new b(this.mController.xIM);
        l.Tx().c(this.rWO);
        this.rWO.xIi = new o$a(this) {
            final /* synthetic */ FMessageConversationUI rXh;

            {
                this.rXh = r1;
            }

            public final void Xw() {
            }

            public final void Xv() {
                if (this.rXh.rWO.getCount() >= 0) {
                    this.rXh.enableOptionMenu(0, true);
                } else {
                    this.rXh.enableOptionMenu(0, false);
                }
            }
        };
        this.rXd = (ListView) findViewById(R.h.ciE);
        if (i2 != 0) {
            View inflate = LayoutInflater.from(this.mController.xIM).inflate(R.i.div, null);
            inflate.findViewById(R.h.ciN).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FMessageConversationUI rXh;

                {
                    this.rXh = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.bm.d.b(this.rXh.mController.xIM, "search", ".ui.FTSAddFriendUI", new Intent().putExtra("Search_Scene", 2).putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, 0));
                }
            });
            this.rXd.addHeaderView(inflate);
        }
        this.rXd.setAdapter(this.rWO);
        this.rXd.setOnItemLongClickListener(new 3(this, new com.tencent.mm.ui.tools.l(this)));
        Context context = this.mController.xIM;
        b bVar = this.rWO;
        if (this.rXd.getHeaderViewsCount() <= 0) {
            z = false;
        }
        this.rXe = new a(context, bVar, z);
        this.rXd.setOnItemClickListener(this.rXe);
        View findViewById;
        if (i2 == 0) {
            findViewById = findViewById(R.h.ciC);
            findViewById.setVisibility(0);
            ((TextView) findViewById(R.h.cer)).setOnClickListener(new 4(this));
            this.rXd.setEmptyView(findViewById);
        } else {
            findViewById = findViewById(R.h.ciD);
            findViewById.setVisibility(0);
            this.rXf = (TextView) findViewById.findViewById(R.h.ciM);
            ListView listView = (ListView) findViewById.findViewById(R.h.ciL);
            listView.setAdapter(new 5(this));
            listView.setOnItemClickListener(new 6(this));
            this.rXd.setEmptyView(findViewById);
        }
        addTextOptionMenu(0, getString(R.l.euR), new 7(this));
        setBackBtn(new 8(this));
    }

    protected final int getLayoutId() {
        return R.i.dit;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        b bVar = (b) this.rWO.getItem(adapterContextMenuInfo.position);
        if (bVar == null) {
            x.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            return;
        }
        if (!bh.ov(bVar.field_displayName)) {
            contextMenu.setHeaderTitle(i.a(this, bVar.field_displayName));
        }
        contextMenu.add(0, 0, 0, R.l.dEw);
        this.rXg = bVar.field_fmsgSysRowId;
        this.pnS = bVar.field_talker;
    }
}
