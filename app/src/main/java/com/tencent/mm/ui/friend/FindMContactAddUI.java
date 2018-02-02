package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.n;
import com.tencent.mm.modelfriend.j;
import com.tencent.mm.modelfriend.j.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.R$styleable;

public class FindMContactAddUI extends MMWizardActivity {
    private TextView emptyTipTv = null;
    private e hPs = null;
    private ListView ilk;
    private ProgressDialog iln = null;
    private int jge;
    private String lcJ = null;
    private View oim;
    private String pRQ;
    private boolean pyw = true;
    private String xUI = "";
    private int xUJ = 2;
    private j zcn;
    private TextView zco = null;
    private TextView zcp = null;
    private TextView zcq = null;
    private TextView zcr = null;
    private Button zcs = null;
    private List<String[]> zct;
    private a zcu = new 7(this);

    static /* synthetic */ void i(FindMContactAddUI findMContactAddUI) {
        findMContactAddUI.aWs();
        if (findMContactAddUI.zcn.NH() == 0) {
            h.a(findMContactAddUI, findMContactAddUI.getString(R.l.ehW), "", findMContactAddUI.getString(R.l.ehC), findMContactAddUI.getString(R.l.ehD), new 12(findMContactAddUI), new 13(findMContactAddUI));
            return;
        }
        n CG = ar.CG();
        e anonymousClass2 = new e(findMContactAddUI) {
            final /* synthetic */ FindMContactAddUI zcv;

            {
                this.zcv = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                if (this.zcv.iln != null) {
                    this.zcv.iln.dismiss();
                    this.zcv.iln = null;
                }
                if (this.zcv.hPs != null) {
                    ar.CG().b(30, this.zcv.hPs);
                    this.zcv.hPs = null;
                }
                if (i == 4 && i2 == -24 && !bh.ov(str)) {
                    Toast.makeText(this.zcv.mController.xIM, str, 1).show();
                } else if (this.zcv.xUI == null || !this.zcv.xUI.contains("2")) {
                    this.zcv.bov();
                } else {
                    Intent intent = new Intent(this.zcv, FindMContactInviteUI.class);
                    intent.putExtra("regsetinfo_ticket", this.zcv.lcJ);
                    intent.putExtra("login_type", this.zcv.jge);
                    intent.putExtra("regsetinfo_NextStyle", this.zcv.xUJ);
                    MMWizardActivity.A(this.zcv, intent);
                }
            }
        };
        findMContactAddUI.hPs = anonymousClass2;
        CG.a(30, anonymousClass2);
        Context context = findMContactAddUI.mController.xIM;
        findMContactAddUI.getString(R.l.dGO);
        findMContactAddUI.iln = h.a(context, findMContactAddUI.getString(R.l.ehQ), true, new OnCancelListener(findMContactAddUI) {
            final /* synthetic */ FindMContactAddUI zcv;

            {
                this.zcv = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        j jVar = findMContactAddUI.zcn;
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (int i = 0; i < jVar.hvO.size(); i++) {
            if (jVar.hvS[i] == 1) {
                linkedList.add(((aou) jVar.hvO.get(i)).ksU);
                linkedList2.add(Integer.valueOf(52));
            }
        }
        ar.CG().a(new o(2, linkedList, linkedList2, "", ""), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ehJ);
        com.tencent.mm.plugin.c.a.ift.up();
        this.lcJ = getIntent().getStringExtra("regsetinfo_ticket");
        this.xUI = getIntent().getStringExtra("regsetinfo_NextStep");
        this.xUJ = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.jge = getIntent().getIntExtra("login_type", 0);
        this.pRQ = b.Xn();
        initView();
    }

    private void cwT() {
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.iln = h.a(context, getString(R.l.evl), true, new 1(this));
        ar.Dm().a(new 6(this));
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
            b.b(true, ar.CB() + "," + getClass().getName() + ",R300_300_QQ," + ar.fH("R300_300_QQ") + ",1");
            b.oG("R300_300_QQ");
        } else {
            b.b(true, ar.CB() + "," + getClass().getName() + ",R300_300_phone," + ar.fH("R300_300_phone") + ",1");
            b.oG("R300_300_phone");
        }
        if (this.pyw) {
            x.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bh.cgy()});
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                cwT();
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (this.jge == 1) {
            b.b(false, ar.CB() + "," + getClass().getName() + ",R300_300_QQ," + ar.fH("R300_300_QQ") + ",2");
        } else {
            b.b(false, ar.CB() + "," + getClass().getName() + ",R300_300_phone," + ar.fH("R300_300_phone") + ",2");
        }
    }

    public void onDestroy() {
        if (this.hPs != null) {
            ar.CG().b(30, this.hPs);
            this.hPs = null;
        }
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
            this.zcp.setText(getString(R.l.eia));
            this.zcq.setText(getString(R.l.eib));
            this.zcs.setText(getString(R.l.ehE, new Object[]{Integer.valueOf(0)}));
            this.zcr = (TextView) this.oim.findViewById(R.h.cwu);
        } else {
            this.oim = LayoutInflater.from(this).inflate(R.i.dig, null);
            this.zco = (TextView) this.oim.findViewById(R.h.chV);
            this.zcp = (TextView) this.oim.findViewById(R.h.chY);
            this.zcq = (TextView) this.oim.findViewById(R.h.chT);
            this.zcs = (Button) this.oim.findViewById(R.h.chS);
            this.zcp.setText(getString(R.l.eia));
            this.zcq.setText(getString(R.l.eib));
            this.zcs.setText(getString(R.l.ehF));
        }
        this.zcn = new j(this, this.zcu, 1);
        this.zcs.setOnClickListener(new 8(this));
        if (this.zcr != null) {
            this.zcr.setOnClickListener(new 9(this));
            this.zcr.setVisibility(8);
        }
        this.ilk.addHeaderView(this.oim);
        this.ilk.setAdapter(this.zcn);
        addTextOptionMenu(0, getString(R.l.dFQ), new 10(this));
        AnonymousClass11 anonymousClass11 = new OnClickListener(this) {
            final /* synthetic */ FindMContactAddUI zcv;

            {
                this.zcv = r1;
            }

            public final void onClick(View view) {
                c.a(this.zcv.ilk);
            }
        };
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactAddUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    cwT();
                    return;
                }
                this.pyw = false;
                h.a(this, getString(R.l.ezO), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FindMContactAddUI zcv;

                    {
                        this.zcv = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.zcv.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        this.zcv.pyw = true;
                        this.zcv.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FindMContactAddUI zcv;

                    {
                        this.zcv = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.zcv.pyw = true;
                        this.zcv.finish();
                    }
                });
                return;
            default:
                return;
        }
    }
}
