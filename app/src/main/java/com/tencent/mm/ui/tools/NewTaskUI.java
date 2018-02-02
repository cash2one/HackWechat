package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage$a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;

public class NewTaskUI extends MMBaseActivity implements e {
    static NewTaskUI zma;
    private ProgressDialog iln = null;
    private SecurityImage xKa = null;
    private c xNR = new c<iy>(this) {
        final /* synthetic */ NewTaskUI zmc;

        {
            this.zmc = r2;
            this.xen = iy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iy iyVar = (iy) bVar;
            if (iyVar == null || iyVar.fzB == null) {
                return false;
            }
            x.i("MicroMsg.NewTaskUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", new Object[]{iyVar.fzB.content, iyVar.fzB.url});
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", iyVar.fzB.content);
            intent.putExtra("key_disaster_url", iyVar.fzB.url);
            intent.setClass(ac.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ac.getContext().startActivity(intent);
            return true;
        }
    };
    private i zmb = new i();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.NewTaskUI", "onCreate :%d", new Object[]{Integer.valueOf(hashCode())});
        setContentView(R.i.daM);
        ar.CG().a(701, this);
        zma = this;
        k vVar = new v(0, "", "", "");
        ar.CG().a(vVar, 0);
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.etF), true, new 2(this, vVar));
    }

    public void onResume() {
        a.xef.b(this.xNR);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        a.xef.c(this.xNR);
    }

    public void onDestroy() {
        x.i("MicroMsg.NewTaskUI", "onDestroy :%d", new Object[]{Integer.valueOf(hashCode())});
        if (equals(zma)) {
            zma = null;
        }
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
        if (this.xKa != null) {
            this.xKa.dismiss();
        }
        ar.CG().b(701, this);
        super.onDestroy();
    }

    public static NewTaskUI cxW() {
        return zma;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
        if (i == 4 && i2 == -3) {
            x.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", new Object[]{Boolean.valueOf(ar.Hj())});
            if (t.a(zma, i, i2, new Intent().setClass(zma, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                return;
            }
        }
        if (i == 4 && (i2 == -6 || i2 == -311 || i2 == -310)) {
            if (kVar instanceof v) {
                v vVar = (v) kVar;
                this.zmb.xPt = vVar.RZ();
                this.zmb.xPs = vVar.Oo();
                this.zmb.xPq = vVar.Op();
                this.zmb.xPr = vVar.Sa();
                x.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.zmb.xPq + " img len" + this.zmb.xPs.length + " " + g.zh());
            }
            if (this.xKa == null) {
                this.xKa = SecurityImage$a.a(this, R.l.eEi, this.zmb.xPt, this.zmb.xPs, this.zmb.xPq, this.zmb.xPr, new 3(this), new 4(this), new OnDismissListener(this) {
                    final /* synthetic */ NewTaskUI zmc;

                    {
                        this.zmc = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.zmc.xKa = null;
                    }
                }, this.zmb);
                return;
            }
            x.d("MicroMsg.NewTaskUI", "imgSid:" + this.zmb.xPq + " img len" + this.zmb.xPs.length + " " + g.zh());
            this.xKa.a(this.zmb.xPt, this.zmb.xPs, this.zmb.xPq, this.zmb.xPr);
            return;
        }
        zma = null;
        finish();
    }
}
