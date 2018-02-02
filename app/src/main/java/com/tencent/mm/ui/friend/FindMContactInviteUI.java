package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.j;
import com.tencent.mm.modelfriend.j.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.List;
import org.xwalk.core.R$styleable;

public class FindMContactInviteUI extends MMWizardActivity {
    private TextView emptyTipTv = null;
    private e hPs = null;
    private ListView ilk;
    private ProgressDialog iln = null;
    private int jge;
    private View oim;
    private String pRQ;
    private boolean pyw = true;
    private int xUJ = 2;
    private j zcn;
    private TextView zco = null;
    private TextView zcp = null;
    private TextView zcq = null;
    private TextView zcr = null;
    private Button zcs = null;
    private List<String[]> zct;
    private a zcu = new 6(this);
    private String zcw = null;

    static /* synthetic */ void h(FindMContactInviteUI findMContactInviteUI) {
        findMContactInviteUI.aWs();
        if (findMContactInviteUI.zcn.NH() == 0) {
            findMContactInviteUI.bov();
        } else {
            h.a(findMContactInviteUI, findMContactInviteUI.getString(R.l.ehM), "", new 12(findMContactInviteUI), new OnClickListener(findMContactInviteUI) {
                final /* synthetic */ FindMContactInviteUI zcx;

                {
                    this.zcx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ehR);
        com.tencent.mm.plugin.c.a.ift.up();
        this.zcw = getIntent().getStringExtra("regsetinfo_ticket");
        this.jge = getIntent().getIntExtra("login_type", 0);
        this.xUJ = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.pRQ = b.Xn();
        initView();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bov();
        return true;
    }

    private void bov() {
        b.oH(this.pRQ);
        aWs();
        DU(1);
    }

    protected void onResume() {
        super.onResume();
        this.zcn.notifyDataSetChanged();
        if (this.jge == 1) {
            b.b(true, ar.CB() + "," + getClass().getName() + ",R300_400_QQ," + ar.fH("R300_400_QQ") + ",1");
        } else {
            b.b(true, ar.CB() + "," + getClass().getName() + ",R300_400_phone," + ar.fH("R300_400_phone") + ",1");
        }
        if (this.pyw) {
            x.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bh.cgy());
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                cwT();
            }
        }
    }

    private void cwT() {
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.iln = h.a(context, getString(R.l.evl), true, new 1(this));
        ar.Dm().a(new 5(this));
    }

    public void onPause() {
        super.onPause();
        if (this.jge == 1) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",R300_400_QQ," + ar.fH("R300_400_QQ") + ",2");
        } else {
            b.b(false, ar.CB() + "," + getClass().getName() + ",R300_400_phone," + ar.fH("R300_400_phone") + ",2");
        }
    }

    public void onDestroy() {
        if (this.hPs != null) {
            ar.CG().b(432, this.hPs);
            this.hPs = null;
        }
        if (this.zcn != null) {
            j jVar = this.zcn;
            if (jVar.hvU != null) {
                jVar.hvU.detach();
                jVar.hvU = null;
            }
        }
        af.OK();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.die;
    }

    protected final void initView() {
        this.emptyTipTv = (TextView) findViewById(R.h.cwy);
        this.emptyTipTv.setText(R.l.evj);
        this.ilk = (ListView) findViewById(R.h.cwA);
        if (this.xUJ == 2 || this.xUJ != 1) {
            this.oim = LayoutInflater.from(this).inflate(R.i.dif, null);
            this.zco = (TextView) this.oim.findViewById(R.h.chV);
            this.zcp = (TextView) this.oim.findViewById(R.h.chY);
            this.zcq = (TextView) this.oim.findViewById(R.h.chT);
            this.zcs = (Button) this.oim.findViewById(R.h.chS);
            this.zcp.setText(getString(R.l.ehS));
            this.zcq.setText(getString(R.l.ehP));
            this.zcs.setText(getString(R.l.ehN, new Object[]{Integer.valueOf(0)}));
            this.zcr = (TextView) this.oim.findViewById(R.h.cwu);
        } else {
            this.oim = LayoutInflater.from(this).inflate(R.i.dig, null);
            this.zco = (TextView) this.oim.findViewById(R.h.chV);
            this.zcp = (TextView) this.oim.findViewById(R.h.chY);
            this.zcq = (TextView) this.oim.findViewById(R.h.chT);
            this.zcs = (Button) this.oim.findViewById(R.h.chS);
            this.zcp.setText(getString(R.l.ehP));
            this.zcq.setText(getString(R.l.ehP));
            this.zcs.setText(getString(R.l.ehO));
        }
        this.zcn = new j(this, this.zcu, 2);
        this.zcs.setOnClickListener(new 7(this));
        if (this.zcr != null) {
            this.zcr.setOnClickListener(new 8(this));
            this.zcr.setVisibility(8);
        }
        this.ilk.addHeaderView(this.oim);
        this.ilk.setAdapter(this.zcn);
        this.ilk.setOnScrollListener(new com.tencent.mm.ui.applet.a());
        this.ilk.setOnTouchListener(new 9(this));
        addTextOptionMenu(0, getString(R.l.dFl), new 10(this));
        11 11 = new 11(this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactInviteUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    cwT();
                    return;
                }
                this.pyw = false;
                h.a(this, getString(R.l.ezO), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 3(this), new 4(this));
                return;
            default:
                return;
        }
    }
}
