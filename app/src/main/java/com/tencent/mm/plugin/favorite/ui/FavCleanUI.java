package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.q;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.b.a.c;
import com.tencent.mm.plugin.favorite.ui.base.a;
import com.tencent.mm.plugin.favorite.ui.base.a$a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import java.util.Iterator;
import java.util.List;

public class FavCleanUI extends MMActivity implements c {
    protected af hae = new af(Looper.getMainLooper());
    private boolean mrE = false;
    protected boolean mrF = false;
    private long mrH = 0;
    private HandlerThread mrK;
    protected af mrL;
    protected View mrM;
    private View mrN;
    private Runnable mrS = new 7(this);
    protected Runnable mrT = new Runnable(this) {
        final /* synthetic */ FavCleanUI msh;

        {
            this.msh = r1;
        }

        public final void run() {
            if (this.msh.mrZ != null) {
                if (this.msh.mrZ.isEmpty() || SystemClock.elapsedRealtime() - this.msh.mrH >= 1000) {
                    this.msh.mrE = false;
                    this.msh.mrH = SystemClock.elapsedRealtime();
                    x.v("MicroMsg.FavCleanUI", "do refresh job");
                    FavCleanUI.d(this.msh);
                    if (this.msh.mrF) {
                        x.v("MicroMsg.FavCleanUI", "do scroll to first");
                        this.msh.msa.setSelection(0);
                        this.msh.mrF = false;
                        return;
                    }
                    return;
                }
                x.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(this.msh.mrH), Integer.valueOf(1000)});
                this.msh.hae.postDelayed(this, 500);
            }
        }
    };
    private h mrY;
    private b mrZ;
    private ListView msa;
    private TextView msb;
    private a msc;
    private boolean msd = false;
    private int mse = 0;
    private com.tencent.mm.plugin.favorite.a.a.a msf = new 3(this);
    private e msg = new 6(this);

    static /* synthetic */ boolean a(FavCleanUI favCleanUI) {
        if (favCleanUI.msa.getChildAt(favCleanUI.msa.getChildCount() - 1) == null || favCleanUI.msa.getLastVisiblePosition() != favCleanUI.msa.getAdapter().getCount() - 1) {
            return false;
        }
        x.i("MicroMsg.FavCleanUI", "at bottom call back");
        return true;
    }

    static /* synthetic */ void b(FavCleanUI favCleanUI) {
        x.v("MicroMsg.FavCleanUI", "on pull down callback");
        if (favCleanUI.mrZ.muy) {
            x.i("MicroMsg.FavCleanUI", "has shown all, do not load data");
        } else if (favCleanUI.mrE) {
            x.w("MicroMsg.FavCleanUI", "onBottomLoadData loading, return");
        } else {
            favCleanUI.mrE = true;
            favCleanUI.fb(true);
            x.i("MicroMsg.FavCleanUI", "on bottom load data listener");
            favCleanUI.mrL.removeCallbacks(favCleanUI.mrS);
            favCleanUI.mrL.post(favCleanUI.mrS);
        }
    }

    static /* synthetic */ void c(FavCleanUI favCleanUI) {
        favCleanUI.mrY = new h(ac.getContext(), 16);
        favCleanUI.mrZ = new b(favCleanUI.mrY, true);
        favCleanUI.mrZ.muw = favCleanUI;
        favCleanUI.msa.setAdapter(favCleanUI.mrZ);
        favCleanUI.msa.setOnItemClickListener(new 4(favCleanUI));
        favCleanUI.msa.setOnTouchListener(null);
        favCleanUI.msa.setOnItemLongClickListener(null);
    }

    static /* synthetic */ void d(FavCleanUI favCleanUI) {
        favCleanUI.mrZ.notifyDataSetChanged();
        if (favCleanUI.mrZ.isEmpty()) {
            favCleanUI.fa(true);
            if (8 != favCleanUI.msa.getVisibility()) {
                favCleanUI.msa.setVisibility(8);
            }
        } else {
            favCleanUI.fa(false);
            if (favCleanUI.msc != null) {
                favCleanUI.msc.show();
            }
            if (favCleanUI.msa.getVisibility() != 0) {
                favCleanUI.msa.setVisibility(0);
            }
        }
        favCleanUI.fb(false);
    }

    protected final int getLayoutId() {
        return R.i.dhs;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mse = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
        this.mrK = com.tencent.mm.sdk.f.e.Wf(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.mrK.start();
        this.mrL = new af(this.mrK.getLooper());
        this.msa = (ListView) findViewById(R.h.cgs);
        setMMTitle(R.l.eeB);
        this.msd = true;
        ar.CG().a(new q(), 0);
        ar.CG().a(438, this.msg);
        setBackBtn(new 1(this));
        ViewStub viewStub = (ViewStub) findViewById(R.h.cek);
        if (viewStub != null) {
            this.mrN = viewStub.inflate();
        } else {
            this.mrN = findViewById(R.h.chv);
        }
        this.msb = (TextView) findViewById(R.h.cei);
        this.mrN.setVisibility(0);
        this.msb.setVisibility(8);
        this.msa.removeFooterView(this.mrM);
        if (this.msc != null) {
            this.msc.hide();
        }
        this.mrM = v.fv(this).inflate(R.i.dhF, null);
        this.msa.setOnScrollListener(new 2(this));
        if (this.msd) {
            this.msc = new a();
            a aVar = this.msc;
            View findViewById = findViewById(R.h.cgr);
            aVar.muO = false;
            aVar.muP = findViewById;
            this.msc.muQ = new a$a(this) {
                final /* synthetic */ FavCleanUI msh;

                {
                    this.msh = r1;
                }

                public final void aJg() {
                    com.tencent.mm.ui.base.h.a(this.msh.mController.xIM, this.msh.getString(R.l.eeA), "", new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass5 msi;

                        {
                            this.msi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            long aJx = this.msi.msh.mrZ.aJx();
                            List fc = this.msi.msh.mrZ.fc(true);
                            a f = this.msi.msh.msc;
                            f.muM += aJx;
                            j.di(j.aIM() - aJx);
                            if (!fc.isEmpty()) {
                                g.pQN.h(14110, new Object[]{Integer.valueOf(this.msi.msh.mse), Integer.valueOf(fc.size()), Integer.valueOf((int) ((((double) aJx) * 1.0d) / 1024.0d))});
                                ar.Dm().F(new 1(this, fc, com.tencent.mm.ui.base.h.a(this.msi.msh.mController.xIM, this.msi.msh.getString(R.l.eeJ), false, null)));
                                g.pQN.h(11125, new Object[]{Integer.valueOf(fc.size()), Integer.valueOf(3)});
                            }
                        }
                    }, null);
                }
            };
            this.msd = false;
        }
        com.tencent.mm.plugin.favorite.a.a.aIw().a(this.msf);
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.favorite.a.a aIw = com.tencent.mm.plugin.favorite.a.a.aIw();
        com.tencent.mm.plugin.favorite.a.a.a aVar = this.msf;
        if (aIw.mpt.contains(aVar)) {
            aIw.mpt.remove(aVar);
        }
        if (this.mrY != null) {
            this.mrY.destory();
            this.mrY = null;
        }
        if (this.mrZ != null) {
            this.mrZ.finish();
        }
        this.mrK.quit();
        ar.CG().b(438, this.msg);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.FavCleanUI", "on create options menu");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    protected final void aJf() {
        x.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
        this.hae.removeCallbacks(this.mrT);
        this.hae.post(this.mrT);
    }

    private void fa(boolean z) {
        if (z) {
            this.mrN.setVisibility(8);
            this.msb.setVisibility(0);
            this.msa.removeFooterView(this.mrM);
            if (this.msc != null) {
                this.msc.hide();
                return;
            }
            return;
        }
        this.mrN.setVisibility(8);
        this.msb.setVisibility(8);
        this.msa.removeFooterView(this.mrM);
        if (this.msc != null) {
            this.msc.show();
        }
    }

    private void fb(boolean z) {
        if (!z) {
            this.msa.removeFooterView(this.mrM);
        } else if (this.msa.getFooterViewsCount() == 0) {
            this.msa.addFooterView(this.mrM);
        }
    }

    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public final void dq(long j) {
        f db = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().db(j);
        if (!(db == null || db.field_favProto == null || db.field_favProto.weU.size() == 0)) {
            Iterator it = db.field_favProto.weU.iterator();
            while (it.hasNext()) {
                long j2 = ((uq) it.next()).wde;
            }
        }
        if (this.mrZ.mux) {
            boolean z;
            a aVar = this.msc;
            if (this.mrZ.aJw() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (aVar.muO) {
                aVar.lgD.setEnabled(z);
            }
            a aVar2 = this.msc;
            List fc = this.mrZ.fc(false);
            j2 = this.mrZ.aJx();
            if (fc.size() == 0 || j2 <= 0) {
                aVar2.aJy();
                return;
            }
            aVar2.lgK.setText(aVar2.lgK.getContext().getString(R.l.eez, new Object[]{d.dg(j2)}));
            aVar2.lgD.setEnabled(true);
        }
    }
}
