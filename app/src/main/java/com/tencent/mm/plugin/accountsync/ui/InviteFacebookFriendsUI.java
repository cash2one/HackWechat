package com.tencent.mm.plugin.accountsync.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class InviteFacebookFriendsUI extends MMActivity implements e {
    private ListView ilk;
    a ill;
    private View ilm;
    private ProgressDialog iln = null;
    String ilo;
    private final int ilp = 5;

    static /* synthetic */ void c(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        x.e("MicroMsg.InviteFacebookFriendsUI", "dealWithRefreshTokenFail");
        inviteFacebookFriendsUI.aF(inviteFacebookFriendsUI.getString(R.l.dGO), inviteFacebookFriendsUI.getString(R.l.eel));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eer);
        ar.CG().a(32, this);
        initView();
    }

    protected void onDestroy() {
        ar.CG().b(32, this);
        this.ill.aUn();
        super.onDestroy();
    }

    protected final void initView() {
        this.ilk = (ListView) findViewById(R.h.cwA);
        TextView textView = (TextView) findViewById(R.h.cem);
        textView.setText(R.l.eek);
        p pVar = new p(true, true);
        pVar.zms = new 1(this);
        a(pVar);
        this.ill = new a(this, new 3(this, textView));
        this.ilk.setAdapter(this.ill);
        this.ilm = findViewById(R.h.cwB);
        this.ilk.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI ilq;

            {
                this.ilq = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.ilq.ill.Xx().length >= 50) {
                    h.h(this.ilq, R.l.eeq, R.l.dGO);
                    return;
                }
                this.ilq.ill.jf(i - this.ilq.ilk.getHeaderViewsCount());
                if (this.ilq.ill.Xx().length > 0) {
                    this.ilq.showOptionMenu(true);
                } else {
                    this.ilq.showOptionMenu(false);
                }
            }
        });
        x.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + q.Gt());
        if (q.Gt()) {
            this.ilk.setVisibility(0);
            this.ilm.setVisibility(8);
            ar.Hg();
            long c = bh.c((Long) c.CU().get(65831, null));
            ar.Hg();
            String ou = bh.ou((String) c.CU().get(65830, null));
            if (bh.bz(c) > 86400000 && ou.length() > 0) {
                com.tencent.mm.ui.f.a.c cVar = new com.tencent.mm.ui.f.a.c("290293790992170");
                cVar.ZI(ou);
                new com.tencent.mm.ui.account.h(cVar, new 5(this)).cnV();
            }
            k vVar = new v();
            vVar.On();
            ak akVar = new ak(new 6(this, vVar), false);
            ar.Hg();
            if (bh.e((Integer) c.CU().get(65829, null)) > 0) {
                ar.Hg();
                c.CU().set(65829, Integer.valueOf(1));
                ar.CG().a(vVar, 0);
            } else {
                akVar.J(5000, 5000);
            }
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.iln = h.a(context, getString(R.l.eBm), true, new 7(this, akVar, vVar));
        }
        setBackBtn(new 8(this));
        9 9 = new 9(this);
        addTextOptionMenu(0, getString(R.l.eeo), new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI ilq;

            {
                this.ilq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.f.a.c cVar = new com.tencent.mm.ui.f.a.c("290293790992170");
                Bundle bundle = new Bundle();
                bundle.putString("message", this.ilq.getString(R.l.een));
                long[] Xx = this.ilq.ill.Xx();
                String l = Long.toString(Xx[0]);
                for (int i = 1; i < Xx.length; i++) {
                    l = (l + ",") + Long.toString(Xx[i]);
                }
                bundle.putString("to", l);
                cVar.a(this.ilq, "apprequests", bundle, new 1(this, Xx));
                return true;
            }
        });
        showOptionMenu(false);
    }

    private void aF(String str, String str2) {
        h.a(this, str2, str, new OnClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI ilq;

            {
                this.ilq = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(this.ilq.mController.xIM, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                this.ilq.mController.xIM.startActivity(intent);
                this.ilq.finish();
            }
        }, null);
    }

    protected final int getLayoutId() {
        return R.i.dhZ;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 32) {
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (i == 4 && i2 == -68) {
                if (bh.ov(str)) {
                    str = "error";
                }
                aF(getString(R.l.dGO), str);
            } else if (i == 0 && i2 == 0) {
                this.ill.a(null, null);
            } else {
                Toast.makeText(this, R.l.evk, 0).show();
            }
        }
    }
}
