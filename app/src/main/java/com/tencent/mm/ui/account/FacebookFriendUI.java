package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

@Deprecated
public class FacebookFriendUI extends MMActivity implements a, e {
    private ListView ilk;
    private View ilm;
    private ProgressDialog iln = null;
    String ilo;
    private boolean nXt = false;
    d xNX;
    private TextView xNY = null;

    static /* synthetic */ void f(FacebookFriendUI facebookFriendUI) {
        x.e("MicroMsg.FacebookFriendUI", "dealWithRefreshTokenFail");
        facebookFriendUI.aF(facebookFriendUI.getString(R.l.dGO), facebookFriendUI.getString(R.l.eel));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ehp);
        ar.CG().a(32, this);
        initView();
    }

    protected void onResume() {
        super.onResume();
        n.Jz().d(this);
        this.xNX.notifyDataSetChanged();
    }

    public void onPause() {
        super.onPause();
        n.Jz().e(this);
    }

    public void onDestroy() {
        ar.CG().b(32, this);
        this.xNX.aUn();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dhZ;
    }

    protected final void initView() {
        this.ilk = (ListView) findViewById(R.h.cwA);
        this.xNY = (TextView) findViewById(R.h.ceh);
        this.xNY.setText(R.l.eem);
        TextView textView = (TextView) findViewById(R.h.cem);
        textView.setText(R.l.eek);
        p pVar = new p(true, true);
        pVar.zms = new 1(this);
        a(pVar);
        this.xNX = new d(this, new 5(this, textView));
        this.xNX.xNT = new d.a(this) {
            final /* synthetic */ FacebookFriendUI xNZ;

            {
                this.xNZ = r1;
            }

            public final void Ef(int i) {
                if (i > 0) {
                    this.xNZ.xNY.setVisibility(8);
                } else {
                    this.xNZ.xNY.setVisibility(0);
                }
            }
        };
        this.ilk.setAdapter(this.xNX);
        this.ilm = findViewById(R.h.cwB);
        this.ilk.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FacebookFriendUI xNZ;

            {
                this.xNZ = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                h hVar = (h) this.xNZ.xNX.getItem(i - this.xNZ.ilk.getHeaderViewsCount());
                if (hVar.status == 100 || hVar.status == 101) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", hVar.getUsername());
                    intent.putExtra("Contact_Nick", hVar.Nw());
                    intent.putExtra("Contact_KFacebookId", hVar.fWh);
                    intent.putExtra("Contact_KFacebookName", hVar.NF());
                    intent.putExtra("Contact_Scene", 31);
                    com.tencent.mm.plugin.c.a.ifs.d(intent, this.xNZ);
                }
                if (hVar.status != 102) {
                }
            }
        });
        x.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + q.Gt());
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
                new h(cVar, new com.tencent.mm.aa.a(this) {
                    final /* synthetic */ FacebookFriendUI xNZ;

                    {
                        this.xNZ = r1;
                    }

                    public final void k(Bundle bundle) {
                        super.k(bundle);
                    }

                    public final void onError(int i, String str) {
                        super.onError(i, str);
                        if (i == 3) {
                            FacebookFriendUI.f(this.xNZ);
                        }
                    }
                }).cnV();
            }
            final k vVar = new v();
            vVar.On();
            ak akVar = new ak(new ak.a(this) {
                final /* synthetic */ FacebookFriendUI xNZ;

                public final boolean uF() {
                    ar.Hg();
                    c.CU().set(65829, Integer.valueOf(1));
                    ar.CG().a(vVar, 0);
                    return false;
                }
            }, false);
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
            this.iln = com.tencent.mm.ui.base.h.a(context, getString(R.l.eBm), true, new 10(this, akVar, vVar));
            addTextOptionMenu(0, getString(R.l.ehq), new 11(this));
        } else {
            this.ilk.setVisibility(8);
            this.ilm.setVisibility(0);
            ((TextView) findViewById(R.h.cwC)).setText(R.l.ehb);
            this.ilm.setOnClickListener(new 12(this));
        }
        setBackBtn(new 2(this));
        3 3 = new 3(this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
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
                this.xNX.a(null, null);
            } else {
                Toast.makeText(this, R.l.evk, 0).show();
            }
        }
    }

    private void aF(String str, String str2) {
        com.tencent.mm.ui.base.h.a(this, str2, str, new 4(this), null);
    }

    public final void jh(String str) {
        this.xNX.notifyDataSetChanged();
    }
}
