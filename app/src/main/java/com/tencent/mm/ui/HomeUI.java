package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI.c;
import com.tencent.mm.ui.LauncherUI.d;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.k;
import com.tencent.mm.ui.conversation.j;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.LinkedList;

@a(3)
@TargetApi(11)
public final class HomeUI implements LauncherUI$b, c, d {
    public static Boolean xGa = Boolean.valueOf(false);
    public static Boolean xGb = Boolean.valueOf(false);
    View contentView;
    private String fCU = null;
    ActionBar mActionBar;
    private long mVc = 0;
    LayoutInflater nny;
    private boolean pyw = true;
    private final long rHI = 300;
    private long rHJ = SystemClock.elapsedRealtime();
    private View rQw;
    private int riW = 0;
    private final HashMap<String, Object> values = new HashMap();
    MMFragmentActivity xFE;
    private final long xFV = 604800000;
    public boolean xFW = false;
    boolean xFX;
    public boolean xFY = false;
    ab xFZ;
    private final long xGc = 432000000;
    private final long xGd = 604800000;
    int xGe = a.xGC;
    LauncherUI.a xGf;
    j xGg;
    public w xGh = new w();
    OnLayoutChangeListener xGi = new 21(this);
    private boolean xGj = w.cfe();
    View xGk;
    ImageView xGl;
    View xGm;
    MenuItem xGn;
    MenuItem xGo;
    public VoiceSearchLayout xGp;
    com.tencent.mm.sdk.b.c xGq = new 4(this);
    IdleHandler xGr = new 6(this);
    Runnable xGs = new 7(this);
    private LinkedList<Runnable> xGt = new LinkedList();
    m xGu = new 18(this);

    static /* synthetic */ void cmE() {
        int ev = com.tencent.mm.bv.a.ev(ac.getContext());
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ac.getContext().getSharedPreferences(ac.cfs() + "_font_size_report_time", 4).getLong("font_size_report_time", 0) > 604800000) {
            g.pQN.h(14239, new Object[]{Integer.valueOf(ev)});
            ac.getContext().getSharedPreferences(ac.cfs() + "_font_size_report_time", 4).edit().putLong("font_size_report_time", currentTimeMillis).commit();
            x.i("MicroMsg.LauncherUI.HomeUI", "using font size kvReport logID:%d , usingFontSize: %d", new Object[]{Integer.valueOf(14239), Integer.valueOf(ev)});
        }
    }

    static /* synthetic */ void cmF() {
        if (VERSION.SDK_INT < 18) {
            ac.getContext().startService(new Intent(ac.getContext(), NotifyService.class));
        }
    }

    private void updateTitle() {
        String string = getString(R.l.app_name);
        if (com.tencent.mm.protocal.d.vAC) {
            if (this.xGj) {
                string = string + getString(R.l.dDD);
            } else {
                string = string + " " + getString(R.l.dDD);
            }
        }
        if (this.xGh.cnj() > 0) {
            if (!this.xGj) {
                string = string + " ";
            }
            CharSequence charSequence = string + "(" + this.xGh.cnj() + ")";
        } else {
            Object obj = string;
        }
        TextView textView = (TextView) this.mActionBar.getCustomView().findViewById(16908308);
        if (textView != null) {
            textView.setText(charSequence);
            textView.setTextSize(0, ((float) com.tencent.mm.bv.a.ab(ac.getContext(), R.f.bum)) * com.tencent.mm.bv.a.ew(ac.getContext()));
        }
    }

    final void cmw() {
        if (ar.Hj()) {
            ar.Hg();
            Boolean valueOf = Boolean.valueOf(t.c((Boolean) com.tencent.mm.z.c.CU().get(340227, null)));
            if (!(valueOf.booleanValue() || k.ySw.booleanValue())) {
                xGa = Boolean.valueOf(true);
                lR(true);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ar.Hg();
            currentTimeMillis -= t.d((Long) com.tencent.mm.z.c.CU().get(340240, null));
            ar.Hg();
            Boolean valueOf2 = Boolean.valueOf(t.c((Boolean) com.tencent.mm.z.c.CU().get(340230, null)));
            ar.Hg();
            Boolean valueOf3 = Boolean.valueOf(t.c((Boolean) com.tencent.mm.z.c.CU().get(340228, null)));
            ar.Hg();
            Boolean valueOf4 = Boolean.valueOf(t.c((Boolean) com.tencent.mm.z.c.CU().get(340229, null)));
            if (valueOf.booleanValue() && valueOf3.booleanValue() && valueOf4.booleanValue() && !valueOf2.booleanValue() && currentTimeMillis >= 432000000) {
                xGb = Boolean.valueOf(true);
                lR(false);
                return;
            }
            return;
        }
        x.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
    }

    private void lR(final boolean z) {
        if (this.rQw != null) {
            x.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
            return;
        }
        this.rQw = View.inflate(ac.getContext(), R.i.dpa, null);
        TextView textView = (TextView) this.rQw.findViewById(R.h.cAd);
        if (z) {
            textView.setText(ac.getContext().getString(R.l.dCp));
        } else {
            textView.setText(ac.getContext().getString(R.l.dCo));
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
        this.rQw.setBackgroundResource(R.g.bEw);
        if (this.contentView != null) {
            ((ViewGroup) this.contentView).addView(this.rQw, layoutParams);
            this.rQw.startAnimation(AnimationUtils.loadAnimation(ac.getContext(), R.a.bqw));
            this.rQw.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ HomeUI xGv;

                public final void onClick(View view) {
                    this.xGv.xFZ.dM();
                    if (z) {
                        this.xGv.c(Boolean.valueOf(true), Boolean.valueOf(true));
                    } else {
                        this.xGv.c(Boolean.valueOf(true), Boolean.valueOf(false));
                    }
                }
            });
        }
    }

    final void c(Boolean bool, Boolean bool2) {
        if (this.rQw != null) {
            this.rQw.clearAnimation();
            this.rQw.setVisibility(8);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(340227, Boolean.valueOf(true));
                    g.pQN.a(232, 0, 1, false);
                    xGa = Boolean.valueOf(false);
                } else {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(340230, Boolean.valueOf(true));
                    g.pQN.a(232, 5, 1, false);
                    xGb = Boolean.valueOf(false);
                }
            }
            this.rQw = null;
        }
    }

    final void cmx() {
        if (this.xFZ != null && ar.Hj()) {
            if (this.xFZ.isShowing()) {
                this.xFZ.dismiss();
            } else {
                this.xFZ.dM();
            }
        }
    }

    final void lS(boolean z) {
        if (this.xFZ != null && this.xGk != null) {
            if (ar.Hj()) {
                int i;
                this.xFZ.xMe.lY(z);
                if (this.xFZ.xMe.xLX > 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    this.xGm.setVisibility(0);
                    return;
                } else {
                    this.xGm.setVisibility(8);
                    return;
                }
            }
            x.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
        }
    }

    final void cmy() {
        if (((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).isFTSIndexReady()) {
            int i = this.xGh.mnk;
            if (i == 0) {
                ((j) this.xGh.cng()).z(500, 5);
            }
            com.tencent.mm.bm.d.b(this.xFE, "search", ".ui.FTSMainUI", new Intent().putExtra("from_tab_index", i).putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, 0));
            return;
        }
        Toast.makeText(ac.getContext(), R.l.eIT, 0).show();
    }

    public final String getString(int i) {
        return this.xFE.getString(i);
    }

    public final void cmz() {
        ar.Dm().cfC();
        this.xGh.cnk();
        ag.y(this.xGs);
    }

    public final boolean cmA() {
        return this.xGe == a.xGD;
    }

    public final void a(FitSystemWindowLayoutView fitSystemWindowLayoutView, Rect rect, ViewGroup viewGroup) {
        this.xFE.getWindow().getDecorView().getBottom();
        this.xFE.getSupportActionBar().getCustomView().getBottom();
        fitSystemWindowLayoutView.xGH = viewGroup;
        fitSystemWindowLayoutView.fitSystemWindows(rect);
    }

    final void initActionBar() {
        if (!this.xGf.cmM()) {
            this.mActionBar.setLogo(new ColorDrawable(this.xFE.getResources().getColor(17170445)));
            this.mActionBar.cO();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.cN();
            this.mActionBar.cP();
            this.mActionBar.setCustomView(b.DY().a(this.xFE, "R.layout.actionbar_title_launcher", R.i.cZX));
            updateTitle();
            this.mActionBar.getCustomView().findViewById(R.h.bIU).setOnClickListener(new 8(this));
        }
    }

    public final void aa(Runnable runnable) {
        if (!this.xGt.contains(runnable)) {
            this.xGt.add(runnable);
        }
    }

    public final void ab(Runnable runnable) {
        this.xGt.remove(runnable);
    }

    final void clA() {
        this.xFE.moveTaskToBack(true);
        if (ar.Hj()) {
            ar.Dm().g(new 13(this), 500);
        }
        com.tencent.mm.app.k tX = com.tencent.mm.app.k.tX();
        tX.ffC = false;
        tX.ffD.removeMessages(-1999);
        tX.ffD.removeMessages(-2999);
        tX.ffD.sendEmptyMessageDelayed(-1999, 3000);
        tX.ffD.sendEmptyMessageDelayed(-2999, 30000);
    }

    public final void cmB() {
        this.xFY = false;
        this.xGp.reset();
    }

    public final void clu() {
        if (this.xGp != null) {
            this.xGp.reset();
        }
    }

    public final void cmC() {
        updateTitle();
    }

    public final void cmD() {
        this.xGh.cmD();
    }
}
