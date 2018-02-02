package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI extends ContactLabelBaseUI implements OnCreateContextMenuListener, OnItemClickListener, e, p$d {
    private ListView Fv;
    private int RE;
    private int kGp = 0;
    private int kGq = 0;
    private i kGt;
    private View lCQ;
    private af mHandler = new af(this) {
        final /* synthetic */ ContactLabelManagerUI nPj;

        {
            this.nPj = r1;
        }

        public final void handleMessage(Message message) {
            x.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", new Object[]{Integer.valueOf(message.what)});
            switch (message.what) {
                case 5001:
                    this.nPj.gj(false);
                    return;
                case 5002:
                    this.nPj.Ds(this.nPj.getString(R.l.dHc));
                    return;
                case 5003:
                    this.nPj.aUZ();
                    return;
                default:
                    return;
            }
        }
    };
    private b nOZ = b.nPo;
    private View nPa;
    private View nPb;
    private a nPc;
    private ArrayList<z> nPd = new ArrayList();
    private HashMap<Integer, Integer> nPe = new HashMap();
    private boolean nPf = true;
    private OnClickListener nPg = new OnClickListener(this) {
        final /* synthetic */ ContactLabelManagerUI nPj;

        {
            this.nPj = r1;
        }

        public final void onClick(View view) {
            ContactLabelManagerUI.b(this.nPj);
        }
    };
    private a nPh = new a(this) {
        final /* synthetic */ ContactLabelManagerUI nPj;

        {
            this.nPj = r1;
        }

        public final void a(String str, l lVar) {
            if (!bh.ov(str)) {
                this.nPj.gj(false);
            }
        }
    };
    private b nPi = new 8(this);

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI, b bVar) {
        contactLabelManagerUI.nOZ = bVar;
        switch (5.nPn[contactLabelManagerUI.nOZ.ordinal()]) {
            case 1:
                contactLabelManagerUI.lCQ.setVisibility(0);
                contactLabelManagerUI.nPa.setVisibility(8);
                return;
            case 2:
                contactLabelManagerUI.lCQ.setVisibility(8);
                contactLabelManagerUI.nPa.setVisibility(0);
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelManagerUI", "unkonw mode:%s", new Object[]{contactLabelManagerUI.nOZ});
                return;
        }
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI, z zVar) {
        if (zVar == null) {
            x.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteScene] can not do scene. lable is null");
            return;
        }
        contactLabelManagerUI.Ds(contactLabelManagerUI.getString(R.l.esx));
        ar.CG().a(new com.tencent.mm.plugin.label.b.b(zVar.field_labelID), 0);
    }

    static /* synthetic */ void b(ContactLabelManagerUI contactLabelManagerUI) {
        if (contactLabelManagerUI.nPd == null || contactLabelManagerUI.nPd.isEmpty()) {
            g.pQN.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        } else {
            g.pQN.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        }
        x.i("MicroMsg.Label.ContactLabelManagerUI", "dz[dealAddLabel]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", s.p(s.yTE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelManagerUI.getString(R.l.esu));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 5);
        d.a(contactLabelManagerUI, ".ui.contact.SelectContactUI", intent, 7001);
    }

    protected final int getLayoutId() {
        return R.i.deQ;
    }

    protected final void initView() {
        this.RE = com.tencent.mm.bv.a.aa(this.mController.xIM, R.f.bvK);
        setMMTitle(getString(R.l.esv));
        addTextOptionMenu(0, getString(R.l.esB), new 9(this));
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelManagerUI nPj;

            {
                this.nPj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nPj.finish();
                return false;
            }
        });
        this.nPc = new a(this);
        this.lCQ = findViewById(R.h.csl);
        this.nPa = findViewById(R.h.csf);
        this.nPb = findViewById(R.h.csm);
        this.nPb.setOnClickListener(this.nPg);
        this.Fv = (ListView) findViewById(R.h.csk);
        this.kGt = new i(this);
        this.Fv.setOnTouchListener(new 11(this));
        this.Fv.setOnItemLongClickListener(new 12(this));
        this.Fv.setAdapter(this.nPc);
        this.Fv.setOnItemClickListener(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        ar.Dm().F(new 13(this));
        com.tencent.mm.plugin.label.e.aUW().c(this.nPh);
    }

    protected void onResume() {
        ar.CG().a(636, this);
        ar.Hg();
        c.EY().a(this.nPi);
        gj(true);
        super.onResume();
    }

    protected void onPause() {
        ar.CG().b(636, this);
        ar.Hg();
        c.EY().b(this.nPi);
        super.onPause();
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.label.e.aUW().j(this.nPh);
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.nPc != null && i >= 0) {
            z rJ = this.nPc.rJ(i);
            if (rJ != null) {
                String str = rJ.field_labelID;
                String str2 = rJ.field_labelName;
                Intent intent = new Intent();
                intent.putExtra("label_id", str);
                intent.putExtra("label_name", str2);
                intent.setClass(this, ContactLabelEditUI.class);
                startActivity(intent);
                if (!bh.ov(str)) {
                    return;
                }
                if (this.nPd == null || this.nPd.isEmpty()) {
                    g.pQN.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                    return;
                }
                g.pQN.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = ((AdapterContextMenuInfo) contextMenuInfo).position;
        if (this.nPc != null && i >= 0) {
            z rJ = this.nPc.rJ(i);
            if (rJ != null) {
                contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(view.getContext(), rJ.field_labelName));
                contextMenu.add(0, 0, 0, getString(R.l.dEw));
                contextMenu.add(0, 1, 1, getString(R.l.dEF));
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = ((AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        if (this.nPc != null && i2 >= 0) {
            z rJ = this.nPc.rJ(i2);
            switch (i) {
                case 0:
                    h.a(this, getString(R.l.esw), "", getString(R.l.dEw), getString(R.l.dEn), new 2(this, rJ), new 3(this));
                    return;
                case 1:
                    Intent intent = new Intent();
                    intent.setClass(this, ContactLabelEditUI.class);
                    intent.putExtra("label_id", rJ.field_labelID);
                    intent.putExtra("label_name", rJ.field_labelName);
                    startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 636:
                if (i == 0 && i2 == 0) {
                    Dw(((com.tencent.mm.plugin.label.b.b) kVar).nOE);
                    return;
                }
                x.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
                aVe();
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
                return;
        }
    }

    private synchronized void gj(boolean z) {
        x.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", new Object[]{String.valueOf(z)});
        if (z && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(5002, 400);
        }
        ar.Dm().F(new 4(this, z));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 7001:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    x.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
                    if (!bh.ov(stringExtra)) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this, ContactLabelEditUI.class);
                        intent2.putExtra("Select_Contact", stringExtra);
                        startActivity(intent2);
                        break;
                    }
                    break;
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private void Dw(String str) {
        if (com.tencent.mm.plugin.label.e.aUW().iF(str)) {
            aUZ();
            gj(false);
            return;
        }
        x.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
        aVe();
    }

    private void aVe() {
        aUZ();
        yE(getString(R.l.dYm));
    }
}
