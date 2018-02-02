package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.z.a.f;
import com.tencent.mm.z.a.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.util.List;
import org.xwalk.core.R$styleable;

public class MobileFriendUI extends MMActivity implements e {
    private TextView emptyTipTv = null;
    private ListView ilk;
    private View ilm;
    private ProgressDialog iln = null;
    String ilo;
    private TextView xNY = null;
    a ymD;
    private aa ymE;

    static /* synthetic */ void e(MobileFriendUI mobileFriendUI) {
        if (m.NN() != a.hwi && m.NN() != a.hwj) {
            mobileFriendUI.ilm.setVisibility(0);
            mobileFriendUI.ilm.setOnClickListener(new 7(mobileFriendUI));
            mobileFriendUI.ilk.setVisibility(8);
            mobileFriendUI.emptyTipTv.setVisibility(8);
        } else if (mobileFriendUI.ymD.getCount() <= 0) {
            mobileFriendUI.emptyTipTv.setVisibility(0);
            mobileFriendUI.ilk.setVisibility(8);
            mobileFriendUI.ilm.setVisibility(8);
        } else {
            mobileFriendUI.emptyTipTv.setVisibility(8);
            mobileFriendUI.ilk.setVisibility(0);
            mobileFriendUI.ilm.setVisibility(8);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.evm);
        af.OD().hhp.fx("qqlist", "update addr_upload2 set reserved4=0");
        ar.CG().a(32, this);
        ar.CG().a(d.CTRL_INDEX, this);
        initView();
        x.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null))});
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            beX();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.MobileFriendUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    beX();
                    return;
                } else {
                    h.a(this, getString(R.l.ezO), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 1(this), new 8(this));
                    return;
                }
            default:
                return;
        }
    }

    private void beX() {
        if (!m.NM()) {
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.iln = h.a(context, getString(R.l.evl), true, new 9(this));
            if (this.ymD.getCount() != 0) {
                List NU = m.NU();
                List NT = m.NT();
                if (NU.size() == 0 && NT.size() == 0) {
                    ar.CG().a(new v(), 0);
                    return;
                }
                this.ymE = new aa(m.NU(), m.NT());
                ar.CG().a(this.ymE, 0);
            } else if (!com.tencent.mm.modelfriend.a.a(new 10(this)) && this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.ymD.notifyDataSetChanged();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        f.ij("2");
        ar.CG().b(32, this);
        ar.CG().b(d.CTRL_INDEX, this);
        this.ymD.aUn();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dok;
    }

    protected final void initView() {
        boolean z;
        this.emptyTipTv = (TextView) findViewById(R.h.cwy);
        this.emptyTipTv.setText(R.l.evj);
        this.xNY = (TextView) findViewById(R.h.cel);
        this.xNY.setText(R.l.evo);
        this.ilm = findViewById(R.h.cwB);
        this.ilk = (ListView) findViewById(R.h.cwA);
        p pVar = new p(true, true);
        pVar.zms = new 11(this);
        a(pVar);
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
        x.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.ymD = new c(this, new 13(this));
        } else {
            this.ymD = new b(this, new 12(this));
        }
        this.ilk.setAdapter(this.ymD);
        this.ilk.setOnItemClickListener(new 14(this));
        this.ymD.a(new a$a(this) {
            final /* synthetic */ MobileFriendUI ymF;

            {
                this.ymF = r1;
            }

            public final void Ef(int i) {
                if (i > 0) {
                    this.ymF.xNY.setVisibility(8);
                } else {
                    this.ymF.xNY.setVisibility(0);
                }
            }
        });
        if (!(m.NN() == a.hwi || m.NN() == a.hwj)) {
            this.ilm = findViewById(R.h.cwB);
            this.ilm.setVisibility(0);
            this.ilm.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MobileFriendUI ymF;

                {
                    this.ymF = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.ymF.mController.xIM, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 6);
                    MMWizardActivity.A(this.ymF, intent);
                }
            });
            this.ilk.setVisibility(8);
        }
        setBackBtn(new 3(this));
        AnonymousClass4 anonymousClass4 = new OnClickListener(this) {
            final /* synthetic */ MobileFriendUI ymF;

            {
                this.ymF = r1;
            }

            public final void onClick(View view) {
                c.a(this.ymF.ilk);
            }
        };
        if (!q.Gv() || m.NM()) {
            h.a(this, R.l.dKE, R.l.dGO, R.l.dFU, R.l.dEn, new 5(this), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ MobileFriendUI ymF;

                {
                    this.ymF = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(12322, Boolean.valueOf(false));
                    com.tencent.mm.platformtools.m.k(false, true);
                    this.ymF.finish();
                }
            });
        }
    }

    public final void b(b bVar) {
        if (bh.ov(bVar.getUsername())) {
            x.e("MicroMsg.MobileFriendUI", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", bVar.getUsername());
        intent.putExtra("Contact_Nick", bVar.Nw());
        intent.putExtra("Contact_Mobile_MD5", bVar.Nr());
        intent.putExtra("Contact_Alias", bVar.hvy);
        intent.putExtra("Contact_Sex", bVar.hvt);
        intent.putExtra("Contact_Signature", bVar.hvw);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(bVar.hvC, bVar.hvu, bVar.hvv));
        intent.putExtra("Contact_Scene", 13);
        intent.putExtra("Contact_ShowUserName", false);
        com.tencent.mm.plugin.c.a.ifs.d(intent, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 32 && this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (!(i == 0 && i2 == 0)) {
            x.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
        if (kVar.getType() == d.CTRL_INDEX) {
            ar.CG().a(new v(), 0);
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 32) {
                com.tencent.mm.modelsimple.d.bs(getApplicationContext());
            }
            this.ymD.a(null, null);
        } else if (kVar.getType() == 32) {
            Toast.makeText(this, R.l.evk, 0).show();
        }
    }
}
