package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ai;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.protocal.c.ef;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.as;
import com.tencent.mm.z.c;

public abstract class SetPwdUI extends MMActivity implements e {
    public String frP = null;
    private ProgressDialog iln = null;
    public boolean qoX = true;
    private String xSt;
    private String xSu;
    public bdn xSv = null;

    protected enum a {
        ;

        public static int[] cop() {
            return (int[]) xSC.clone();
        }

        static {
            xSy = 1;
            xSz = 2;
            xSA = 3;
            xSB = 4;
            xSC = new int[]{xSy, xSz, xSA, xSB};
        }
    }

    protected abstract void Eg(int i);

    protected abstract String cnW();

    protected abstract String cnX();

    protected abstract boolean s(int i, int i2, String str);

    public void onCreate(Bundle bundle) {
        ar.CG().a(cnY(), this);
        super.onCreate(bundle);
        this.frP = getIntent().getStringExtra("setpwd_ticket");
        byte[] VD = bh.VD(as.Hn().getString("_auth_key", ""));
        ef efVar = new ef();
        if (bh.bw(VD)) {
            this.xSv = new bdn().bj(new byte[0]);
        } else {
            this.xSv = new bdn().bj(VD);
            try {
                efVar.aF(VD);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SetPwdUI", e, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
            }
        }
        a(0, getString(R.l.dFl), new OnMenuItemClickListener(this) {
            final /* synthetic */ SetPwdUI xSw;

            {
                this.xSw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.xSw.xSt = this.xSw.cnW();
                this.xSw.xSu = this.xSw.cnX();
                if (!bh.ov(this.xSw.xSt)) {
                    if (!this.xSw.xSt.equals(this.xSw.xSu)) {
                        this.xSw.Eg(a.xSy);
                    } else if (this.xSw.xSt.length() > 16) {
                        this.xSw.Eg(a.xSz);
                    } else if (bh.Vq(this.xSw.xSt)) {
                        h.h(this.xSw, R.l.eDw, R.l.eDR);
                    } else if (bh.Vv(this.xSw.xSt)) {
                        this.xSw.xSt;
                        this.xSw.xSu;
                        SetPwdUI.coo();
                        this.xSw.aWs();
                        if (bh.ov(this.xSw.frP)) {
                            SetPwdUI setPwdUI = this.xSw;
                            ar.Hg();
                            setPwdUI.frP = (String) c.CU().get(77830, null);
                        }
                        k a = this.xSw.a(this.xSw.xSt, this.xSw.frP, this.xSw.xSv);
                        ar.CG().a(a, 0);
                        this.xSw.iln = this.xSw.a(this.xSw, this.xSw.getString(R.l.dGO), this.xSw.getString(R.l.eCU), new 1(this, a));
                        if (this.xSw.cod() && !this.xSw.qoX) {
                            x.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
                            g.pQN.h(11868, new Object[]{Integer.valueOf(0)});
                        }
                    } else if (this.xSw.xSt.length() < 8 || this.xSw.xSt.length() >= 16) {
                        this.xSw.Eg(a.xSA);
                    } else {
                        this.xSw.Eg(a.xSB);
                    }
                }
                return true;
            }
        }, b.xJz);
        setBackBtn(new 2(this));
    }

    public void onDestroy() {
        ar.CG().b(cnY(), this);
        super.onDestroy();
    }

    protected static boolean coo() {
        return true;
    }

    protected ProgressDialog a(Context context, String str, String str2, OnCancelListener onCancelListener) {
        return h.a(context, str2, true, onCancelListener);
    }

    protected int cnY() {
        return 383;
    }

    protected k a(String str, String str2, bdn com_tencent_mm_protocal_c_bdn) {
        return new ai(str, str2, com_tencent_mm_protocal_c_bdn);
    }

    public final void a(int i, int i2, String str, k kVar) {
        bhm com_tencent_mm_protocal_c_bhm = null;
        if (kVar.getType() == cnY()) {
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (kVar.getType() == 383 && i == 0 && i2 == 0) {
                Toast.makeText(this, getString(R.l.ejm), 0).show();
                ai aiVar = (ai) kVar;
                if (!(aiVar.gJQ == null || aiVar.gJQ.hmh.hmo == null)) {
                    com_tencent_mm_protocal_c_bhm = (bhm) aiVar.gJQ.hmh.hmo;
                }
                if (!(com_tencent_mm_protocal_c_bhm == null || com_tencent_mm_protocal_c_bhm.vJa == null)) {
                    byte[] toByteArray = com_tencent_mm_protocal_c_bhm.vJa.wJD.toByteArray();
                    Editor edit = ac.getContext().getSharedPreferences("auth_info_key_prefs", 4).edit();
                    edit.putBoolean("key_auth_info_prefs_created", true);
                    edit.putInt("key_auth_update_version", d.vAz);
                    edit.putString("_auth_key", bh.by(toByteArray));
                    ar.Hg();
                    edit.putInt("_auth_uin", c.Cg());
                    edit.commit();
                }
                setResult(-1);
            }
            if (!s(i, i2, str)) {
                Toast.makeText(this, getString(R.l.ejl, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    protected final boolean o(int i, int i2, String str) {
        if (com.tencent.mm.plugin.c.a.ift.a(this.mController.xIM, i, i2, str)) {
            return true;
        }
        return false;
    }

    public boolean cod() {
        return false;
    }

    public void onBackPressed() {
        if (this.qoX) {
            if (cod()) {
                x.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                g.pQN.h(11868, new Object[]{Integer.valueOf(1)});
            }
            super.onBackPressed();
        }
    }
}
