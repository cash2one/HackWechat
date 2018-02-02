package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.ipcall.a.d;
import com.tencent.mm.plugin.ipcall.a.f.b;
import com.tencent.mm.plugin.ipcall.ui.e.1;
import com.tencent.mm.plugin.ipcall.ui.e.2;
import com.tencent.mm.plugin.ipcall.ui.e.3;
import com.tencent.mm.plugin.ipcall.ui.e.4;
import com.tencent.mm.plugin.ipcall.ui.e.5;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import org.xwalk.core.R$styleable;

public class IPCallAddressUI extends MMActivity implements e {
    private boolean nIA = false;
    private c nIB = new 1(this);
    private Runnable nIC = new 3(this);
    private View nIj;
    private ListView nIv;
    private e nIw = null;
    private int nIx = 0;
    private boolean nIy = false;
    private boolean nIz = true;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.Hg();
        if (((Boolean) com.tencent.mm.z.c.CU().get(a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.valueOf(false));
            Intent intent = new Intent();
            intent.setClass(this.mController.xIM, IPCallAcitivityUI.class);
            this.mController.xIM.startActivity(intent);
            overridePendingTransition(R.a.bqB, R.a.bqA);
            this.nIz = false;
        }
        setBackBtn(new 2(this));
        if (this.nIz) {
            this.nIA = true;
            aUr();
        }
        ar.Hg();
        this.nIy = ((Boolean) com.tencent.mm.z.c.CU().get(a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.valueOf(true))).booleanValue();
        setMMTitle(R.l.eqI);
        this.nIv = (ListView) findViewById(R.h.bJd);
        this.nIj = findViewById(R.h.bJp);
        this.nIw = new e(this, this.nIv, this.nIj);
        e eVar = this.nIw;
        eVar.nIi = new h(eVar.nIk);
        ViewGroup viewGroup = (ViewGroup) View.inflate(eVar.nIk, R.i.dmg, null);
        eVar.nIh.addHeaderView(viewGroup, null, false);
        eVar.nIh.setAdapter(eVar.nIi);
        eVar.nIm = (TextView) viewGroup.findViewById(R.h.bIt);
        eVar.nIn = (TextView) viewGroup.findViewById(R.h.bIx);
        eVar.nIo = (LinearLayout) viewGroup.findViewById(R.h.bIq);
        eVar.nIp = (TextView) viewGroup.findViewById(R.h.bIr);
        eVar.nIq = (ImageView) viewGroup.findViewById(R.h.cTM);
        viewGroup.findViewById(R.h.bIy).setOnClickListener(new 1(eVar));
        viewGroup.findViewById(R.h.bYq).setOnClickListener(new 2(eVar));
        viewGroup.findViewById(R.h.cbU).setOnClickListener(new 3(eVar));
        eVar.nIh.setOnItemClickListener(new 4(eVar));
        eVar.nIh.setOnItemLongClickListener(new 5(eVar));
        ar.Hg();
        if (((Boolean) com.tencent.mm.z.c.CU().get(a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.valueOf(true))).booleanValue()) {
            d.aTn().fQ(true);
            ar.Hg();
            com.tencent.mm.z.c.CU().a(a.USERINFO_IPCALL_FIRST_IN_BOOLEAN, Boolean.valueOf(false));
        } else {
            d.aTn().fQ(false);
        }
        if (eVar.nIi.getCount() > 0) {
            eVar.nIj.setVisibility(8);
        } else {
            eVar.nIj.setVisibility(0);
        }
        eVar.aUp();
        eVar.aUo();
        eVar.nIl = true;
        ar.CG().a(257, (e) this);
        com.tencent.mm.sdk.b.a.xef.b(this.nIB);
        this.nIx = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
        g.pQN.a(257, 0, 1, true);
    }

    protected final int getLayoutId() {
        return R.i.dlU;
    }

    private void aUr() {
        x.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bh.cgy());
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            com.tencent.mm.sdk.f.e.post(this.nIC, "IPCallAddressUI_LoadSystemAddressBook");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.nIw != null) {
            e eVar = this.nIw;
            eVar.nIh.setOnItemClickListener(null);
            eVar.nIh.setOnItemLongClickListener(null);
            n.Jz().b(eVar.nIi);
        }
        ar.CG().b(257, (e) this);
        com.tencent.mm.sdk.b.a.xef.c(this.nIB);
    }

    protected void onResume() {
        super.onResume();
        if (this.nIw != null) {
            e eVar = this.nIw;
            if (!(eVar.nIi == null || eVar.nIl)) {
                eVar.nIi.notifyDataSetChanged();
                if (eVar.nIi.getCount() > 0) {
                    eVar.nIj.setVisibility(8);
                } else {
                    eVar.nIj.setVisibility(0);
                }
            }
            eVar.nIl = false;
        }
        supportInvalidateOptionsMenu();
        b.aUc().gb(true);
        if (!this.nIA) {
            this.nIA = true;
            aUr();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.ipcall.a.d.g) && i == 0 && i2 == 0 && this.nIw != null) {
            this.nIw.aUp();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        if (this.nIx == 1) {
            com.tencent.mm.plugin.ipcall.b.ifs.s(new Intent(), this);
        } else {
            super.onBackPressed();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.IPCallAddressUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bh.cgy();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.IPCallAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] != 0 && this.nIy) {
                    this.nIy = false;
                    h.a(this, getString(R.l.ezO), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 4(this), new 5(this));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
