package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al$a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.at.f;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.z.q;

public class SnsUserUI extends MMActivity implements com.tencent.mm.plugin.sns.b.h.a {
    private String jKk;
    private c jeX = new 3(this);
    private boolean rHV = false;
    private OnMenuItemClickListener rIF = new 10(this);
    private String rIa;
    private boolean rIb;
    private int rIc;
    private at rLW;
    private bb rLX;
    private al$a rLY;
    private com.tencent.mm.plugin.sns.ui.bb.a rLZ;
    private Runnable rMa = new 1(this);
    private boolean rtl;

    class a extends f {
        private ba rIK = null;
        final /* synthetic */ SnsUserUI rMb;

        a(SnsUserUI snsUserUI) {
            this.rMb = snsUserUI;
        }

        public void dF(int i, int i2) {
            x.i("MicroMsg.SnsUserUI", "showImg snsinfo snslocalId:%d, pos:%d，mIsSelf:%b ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.rMb.rtl)});
            if (this.rMb.rtl && i2 == -1) {
                this.rIK = new ba(this.rMb);
                this.rIK.rKC = new p.c(this) {
                    final /* synthetic */ a rMc;

                    {
                        this.rMc = r1;
                    }

                    public final void a(n nVar) {
                        nVar.f(0, this.rMc.rMb.getString(j.dEW));
                        nVar.f(1, this.rMc.rMb.getString(j.dFa));
                    }
                };
                this.rIK.d(0, this.rMb.mController.xIM.getString(j.qJt));
                this.rIK.rKD = new 2(this);
                this.rIK.bBX();
                return;
            }
            Intent intent = new Intent(this.rMb, SnsGalleryUI.class);
            intent.putExtra("sns_gallery_userName", this.rMb.jKk);
            intent.putExtra("sns_gallery_is_self", this.rMb.rtl);
            intent.putExtra("sns_gallery_localId", i);
            intent.putExtra("sns_source", this.rMb.rIc);
            intent.putExtra("sns_gallery_st_time", this.rMb.rLW.rFc);
            intent.putExtra("sns_gallery_ed_time", this.rMb.rLW.rFd);
            if (this.rMb.rLW != null) {
                intent.putExtra("sns_gallery_limit_seq", this.rMb.rLW.maQ);
                this.rMb.rLY.h(this.rMb.jKk, this.rMb.rLW.dE(i, i2));
                intent.putExtra("sns_gallery_position", this.rMb.rLW.rFg);
            }
            this.rMb.startActivityForResult(intent, 8);
        }

        public final void dG(int i, int i2) {
            m xo = ae.bvv().xo(i);
            if (xo != null) {
                if (xo.field_type == 15) {
                    Intent intent = new Intent(this.rMb, SnsGalleryUI.class);
                    intent.putExtra("sns_gallery_userName", this.rMb.jKk);
                    intent.putExtra("sns_gallery_is_self", this.rMb.rtl);
                    intent.putExtra("sns_gallery_localId", i);
                    intent.putExtra("sns_source", this.rMb.rIc);
                    intent.putExtra("sns_gallery_st_time", this.rMb.rLW.rFc);
                    intent.putExtra("sns_gallery_ed_time", this.rMb.rLW.rFd);
                    if (this.rMb.rLW != null) {
                        intent.putExtra("sns_gallery_limit_seq", this.rMb.rLW.maQ);
                        this.rMb.rLY.h(this.rMb.jKk, this.rMb.rLW.dE(i, i2));
                        intent.putExtra("sns_gallery_position", this.rMb.rLW.rFg);
                    }
                    this.rMb.startActivityForResult(intent, 8);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setClass(this.rMb, SnsCommentDetailUI.class);
                intent2.putExtra("INTENT_TALKER", xo.field_userName);
                intent2.putExtra("INTENT_SNS_LOCAL_ID", u.ac("sns_table_", (long) i));
                this.rMb.startActivityForResult(intent2, 12);
            }
        }

        public final void xJ(int i) {
            m xo = ae.bvv().xo(i);
            if (xo != null) {
                Intent intent = new Intent();
                intent.setClass(this.rMb, SnsCommentDetailUI.class);
                intent.putExtra("INTENT_TALKER", xo.field_userName);
                intent.putExtra("INTENT_SNS_LOCAL_ID", u.ac("sns_table_", (long) i));
                this.rMb.startActivityForResult(intent, 12);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        if (this.mController != null) {
            this.mController.ad(2, false);
        }
        super.onCreate(bundle);
        if (g.Dh().Cy()) {
            af WO;
            this.rLY = ae.bvl();
            this.rIc = getIntent().getIntExtra("sns_source", 0);
            this.jKk = getIntent().getStringExtra("sns_userName");
            if (this.jKk == null) {
                this.jKk = "";
            }
            g.Dk();
            this.rIb = ((h) g.h(h.class)).EY().WK(this.jKk);
            this.rIa = q.FS();
            this.rtl = this.rIa.equals(this.jKk);
            ar bvj = ae.bvj();
            String az = bh.az(getIntent().getStringExtra("sns_signature"), "");
            String az2 = bh.az(getIntent().getStringExtra("sns_nickName"), "");
            if (this.jKk == null || this.jKk.equals("")) {
                WO = bvj.WO(this.rIa);
            } else {
                WO = bvj.WO(this.jKk);
            }
            if (WO != null && ((int) WO.gJd) > 0) {
                az = WO.signature;
                az2 = WO.AP();
                x.i("MicroMsg.SnsUserUI", "contact:user[%s] id[%d] nickname[%s]", new Object[]{WO.field_username, Integer.valueOf((int) WO.gJd), az2});
            }
            this.rLX = new bb(this);
            this.rLX.a(this.rIa, this.jKk, az2, az, this.rIb, this.rtl, this.rIc);
            bb bbVar = this.rLX;
            com.tencent.mm.plugin.sns.ui.bb.a 4 = new 4(this);
            this.rLZ = 4;
            bbVar.rLj = 4;
            this.rLX.onCreate();
            if (getIntent().getExtras() != null) {
                getIntent().getExtras().setClassLoader(getClass().getClassLoader());
            }
            initView();
            com.tencent.mm.sdk.b.a.xef.b(this.jeX);
            return;
        }
        finish();
    }

    public void onDestroy() {
        this.rHV = true;
        com.tencent.mm.sdk.b.a.xef.c(this.jeX);
        b q = b.q(getIntent());
        if (q != null) {
            q.update();
            q.Sx();
        }
        if (!(this.rLX == null || this.rLX.tipDialog == null)) {
            this.rLX.tipDialog.dismiss();
            this.rLX.tipDialog = null;
        }
        g.Dk();
        if (g.Dh().Cy() && this.rLY != null) {
            this.rLY.a(this, this.rLZ.getType());
        }
        if (this.rLX != null) {
            this.rLX.onDestroy();
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return i$g.qHM;
    }

    public void onResume() {
        if (this.rLW != null) {
            this.rLW.notifyDataSetChanged();
        }
        cmX();
        setRequestedOrientation(-1);
        if (this.rtl) {
            this.mController.addIconOptionMenu(0, getString(j.qLD), i.qIw, new 9(this));
        } else {
            enableOptionMenu(false);
        }
        setBackBtn(this.rIF, e.byy);
        if (this.rtl) {
            setMMTitle(j.qLP);
        } else {
            CharSequence AQ;
            x.d("MicroMsg.SnsUserUI", "SnsUserUI, userName:%s, title:%s", new Object[]{this.jKk, this.rLX.title});
            com.tencent.mm.l.a WO = ae.bvj().WO(this.jKk);
            if (WO != null) {
                x.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is not null");
                AQ = WO.AQ();
            } else {
                x.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is null, title:%s", new Object[]{this.rLX.title});
                AQ = this.rLX.title;
            }
            setMMTitle(com.tencent.mm.plugin.sns.data.i.A(AQ));
        }
        bb.onResume();
        super.onResume();
    }

    public void onPause() {
        bb.onPause();
        super.onPause();
    }

    protected final void initView() {
        this.rLW = new at(this, new 5(this), this.jKk, new 6(this));
        this.rLX.nKG.setAdapter(this.rLW);
        this.rLX.nKG.setOnItemClickListener(new 7(this));
        this.rLX.nKG.postDelayed(new Runnable(this) {
            final /* synthetic */ SnsUserUI rMb;

            {
                this.rMb = r1;
            }

            public final void run() {
                if (this.rMb.rHV) {
                    x.w("MicroMsg.SnsUserUI", "too fast that it finish");
                    return;
                }
                this.rMb.rLY.a(this.rMb.rLZ.getType(), this.rMb.jKk, this.rMb);
                if (this.rMb.rLZ.getType() == 1 && this.rMb.rLZ.bBM()) {
                    ae.bvl().x(ae.bvC().qXh, -1);
                }
                if (!this.rMb.rLZ.bBM()) {
                    al$a b = this.rMb.rLY;
                    int type = this.rMb.rLZ.getType();
                    String c = this.rMb.jKk;
                    this.rMb.rIb;
                    b.a(type, c, this.rMb.rtl, this.rMb.rIc);
                }
            }
        }, 500);
        setBackBtn(this.rIF, e.byy);
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
        if (this.rLW != null) {
            this.rLW.rwz = str;
            if (str.compareTo(this.rLW.maQ) < 0) {
                x.i("MicroMsg.SnsUserUI", "onFpSetSize addsize %s %s isNeedNP %s", new Object[]{str, this.rLW.maQ, Boolean.valueOf(z)});
                this.rLW.bBr();
            } else {
                x.i("MicroMsg.SnsUserUI", "onFpSetSize addsize passed %s %s isNeedNP %s", new Object[]{str, this.rLW.maQ, Boolean.valueOf(z)});
            }
            this.rLW.bzt();
        }
        if (!z4 || this.rIa.equals(this.jKk)) {
            if (this.rIa.equals(this.jKk) && j != 0) {
                g.Dk();
                g.Dj().CU().a(com.tencent.mm.storage.w.a.xtJ, Long.valueOf(j));
                this.rLW.eW(j);
            }
            this.rLX.rLh = z2;
            if (z2) {
                this.rLX.iE(false);
            } else if (z) {
                this.rLY.b(this.rLZ.getType(), this.jKk, this.rtl, this.rIc);
            }
        } else {
            this.rLX.rLh = true;
            this.rLX.xv(i);
        }
        if (z3) {
            this.rLX.raX.bAT();
        }
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
        ae.aNT().removeCallbacks(this.rMa);
        if (this.rLW != null) {
            this.rLW.rEZ = z2;
            this.rLW.rwz = str;
            if (str.compareTo(this.rLW.maQ) < 0) {
                x.i("MicroMsg.SnsUserUI", "onNpAddSize addsize %s %s", new Object[]{str, this.rLW.maQ});
                this.rLW.bBr();
            } else {
                x.i("MicroMsg.SnsUserUI", "onNpAddSize addsize passed %s %s", new Object[]{str, this.rLW.maQ});
            }
            this.rLW.bzt();
        }
        if (!z3 || this.rIa.equals(this.jKk)) {
            if (this.rIa.equals(this.jKk) && j != 0) {
                g.Dk();
                g.Dj().CU().a(com.tencent.mm.storage.w.a.xtJ, Long.valueOf(j));
                this.rLW.eW(j);
            }
            this.rLX.rLh = z;
            if (z) {
                this.rLX.iE(z2);
                return;
            }
            return;
        }
        this.rLX.rLh = true;
        this.rLX.xv(i);
    }

    private void bCh() {
        if (!com.tencent.mm.p.a.aU(this)) {
            x.d("MicroMsg.SnsUserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 18, "", "")), bh.cgy(), this});
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 18, "", "")) {
                x.d("MicroMsg.SnsUserUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), bh.cgy(), this});
                if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                    k.x(this.mController.xIM, new Intent());
                }
            }
        }
    }

    public void onBackPressed() {
        finish();
    }

    public boolean supportNavigationSwipeBack() {
        return super.supportNavigationSwipeBack();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsUserUI", "on activity result, %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (5985 == i && i2 == -1) {
            finish();
            return;
        }
        super.onActivityResult(i, i2, intent);
        this.rLX.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.SnsUserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    bCh();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? j.ezM : j.ezQ;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this, getString(i2), getString(j.ezT), getString(j.est), getString(j.dEn), false, new 11(this), new 2(this));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
