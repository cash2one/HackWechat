package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.ae;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.w;
import com.tencent.mm.protocal.c.aey;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.z.a.f;
import com.tencent.mm.z.a.g;
import com.tencent.mm.z.ar;

public class QQFriendUI extends MMActivity implements e {
    private int JI;
    private ListView ilk;
    private ProgressDialog iln = null;
    String ilo;
    private p lcZ;
    private boolean nXt = false;
    private TextView xNY = null;
    d zdl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(143, this);
        String stringExtra = getIntent().getStringExtra("qqgroup_name");
        this.JI = getIntent().getIntExtra("qqgroup_id", -1);
        ae OI = af.OI();
        int i = this.JI;
        x.d("MicroMsg.QQListStorage", "delete: GroupID:" + i);
        OI.hhp.fx("qqlist", "update qqlist set reserved4=0 where groupid=" + i);
        if (m.hD(this.JI)) {
            final k wVar = new w(this.JI);
            ar.CG().a(wVar, 0);
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.iln = h.a(context, getString(R.l.eBm), true, new OnCancelListener(this) {
                final /* synthetic */ QQFriendUI zdn;

                public final void onCancel(DialogInterface dialogInterface) {
                    ar.CG().c(wVar);
                }
            });
        }
        setMMTitle(stringExtra);
        initView();
    }

    protected void onResume() {
        super.onResume();
        n.Jz().d(this.zdl);
        this.zdl.notifyDataSetChanged();
    }

    public void onDestroy() {
        f.ij("2");
        af.OI().b(this.zdl);
        ar.CG().b(143, this);
        this.zdl.aUn();
        n.JS().cancel();
        super.onDestroy();
    }

    public void onPause() {
        n.Jz().e(this.zdl);
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dpO;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        x.v("MicroMsg.QQFriendUI", "qq friend onKeyDown");
        return super.onKeyDown(i, keyEvent);
    }

    protected final void initView() {
        boolean z;
        this.ilk = (ListView) findViewById(R.h.cEs);
        this.xNY = (TextView) findViewById(R.h.cen);
        this.xNY.setText(R.l.eBn);
        this.lcZ = new p(true, true);
        this.lcZ.zms = new 2(this);
        a(this.lcZ);
        if (g.Ij().ie("2") != null) {
            String str = g.Ij().ie("2").value;
            if (str.equals("0")) {
                z = false;
            } else if (str.equals("1")) {
                z = true;
            } else {
                z = true;
            }
            f.ii("2");
        } else {
            z = true;
        }
        if (z) {
            this.zdl = new f(this, this.JI);
        } else {
            this.zdl = new e(this, this.JI);
        }
        this.zdl.a(new 3(this));
        this.ilk.setAdapter(this.zdl);
        this.ilk.setOnItemClickListener(new 4(this));
        af.OI().a(this.zdl);
        setBackBtn(new 5(this));
        6 6 = new 6(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        x.d("MicroMsg.QQFriendUI", "onConfigurationChanged: orientation = " + configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.QQFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((aey) ((w) kVar).gJQ.hmg.hmo).nhx == 1) {
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (i == 0 && i2 == 0) {
                this.zdl.Xy();
            } else {
                Toast.makeText(this, R.l.eBl, 0).show();
            }
        }
    }
}
