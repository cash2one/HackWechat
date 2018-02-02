package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.q;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.appusage.c;
import com.tencent.mm.plugin.appbrand.appusage.g.b;
import com.tencent.mm.plugin.appbrand.appusage.h.d;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.smtt.sdk.WebView;

public final class AppBrandLauncherUI extends DrawStatusBarActivity {
    static final int jKJ = n.isf;
    private static final int jKK = g.iup;
    private String jKL;
    private boolean jKM = false;
    private int jKN;
    private boolean jKO = true;
    private final b jKP = new b(this) {
        final /* synthetic */ AppBrandLauncherUI jKR;

        {
            this.jKR = r1;
        }

        public final void aaT() {
            com.tencent.mm.plugin.appbrand.appusage.g.b(this);
            if (!com.tencent.mm.plugin.appbrand.appusage.g.aaR()) {
                this.jKR.runOnUiThread(new 1(this));
            }
        }
    };
    public d jKQ;
    private int jxi;

    public static abstract class a extends Fragment {
        public View Iv;
        public int irz;
        private final af jKT = new af(Looper.getMainLooper());
        public String jKU;

        public abstract void initView();

        public void akD() {
        }

        public void akE() {
        }

        public void lw(int i) {
            this.irz = i;
        }

        public final int lx(int i) {
            Context activity = getActivity();
            if (activity == null) {
                activity = ac.getContext();
            }
            return com.tencent.mm.bv.a.fromDPToPix(activity, i);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.Iv = new FrameLayout(viewGroup.getContext());
            initView();
            return this.Iv;
        }

        public final void s(Runnable runnable) {
            if (runnable != null) {
                this.jKT.post(runnable);
            }
        }

        public final void runOnUiThread(Runnable runnable) {
            if (getActivity() != null) {
                getActivity().runOnUiThread(runnable);
            }
        }
    }

    public final void dg(boolean z) {
        Class cls = z ? com.tencent.mm.plugin.appbrand.ui.recents.a.class : c.class;
        Fragment N = super.getSupportFragmentManager().N(jKK);
        if ((N == null || !cls.isInstance(N)) && !isFinishing() && !this.xIq) {
            Fragment aVar;
            q aS = super.getSupportFragmentManager().aS();
            if (z) {
                aVar = new com.tencent.mm.plugin.appbrand.ui.recents.a();
            } else {
                aVar = c.bB(getString(j.dDT), getString(j.izY));
            }
            aVar.lw(this.jxi);
            aVar.jKU = this.jKL;
            aS.b(jKK, aVar);
            aS.commit();
            if (z && this.jKQ != null) {
                this.jKQ.iJH[4] = "1";
            }
        }
    }

    protected final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && j.b(getWindow())) {
            return -1052684;
        }
        if (VERSION.SDK_INT >= 21) {
            return jKJ;
        }
        return super.getStatusBarColor();
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        getWindow().setSoftInputMode(3);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        } else if (com.tencent.mm.plugin.appbrand.appusage.a.aaB()) {
            overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.xKg, com.tencent.mm.ui.MMFragmentActivity.a.xKh);
            this.jKM = true;
            this.jxi = getIntent().getIntExtra("extra_enter_scene", 1);
            this.jKL = getIntent().getStringExtra("extra_enter_scene_note");
            if (getSupportActionBar() != null) {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(-1052684));
            }
            aa(new Runnable(this) {
                final /* synthetic */ AppBrandLauncherUI jKR;

                {
                    this.jKR = r1;
                }

                public final void run() {
                    if (!this.jKR.xIq && !this.jKR.isFinishing()) {
                        Fragment N = super.getSupportFragmentManager().N(AppBrandLauncherUI.jKK);
                        if (N != null && (N instanceof a)) {
                            ((a) N).akD();
                        }
                    }
                }
            });
            setMMTitle(getResources().getString(j.dDT));
            nR(WebView.NIGHT_MODE_COLOR);
            k.a(this);
            setBackBtn(new 3(this), f.itj);
            if (com.tencent.mm.plugin.appbrand.l.a.ake()) {
                int i = b.jKV - 1;
                int i2 = j.eRj;
                Drawable c = com.tencent.mm.svg.a.a.c(ac.getResources(), i.dvb);
                if (c == null) {
                    c = null;
                } else {
                    c = c.mutate();
                    c.setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
                }
                this.mController.a(i, getString(i2), c, new OnMenuItemClickListener(this) {
                    final /* synthetic */ AppBrandLauncherUI jKR;

                    {
                        this.jKR = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.jKR.startActivityForResult(((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.compat.a.a.class)).bK(this.jKR), 1);
                        return true;
                    }
                });
            }
            this.mController.contentView.setBackgroundColor(-1052684);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            View frameLayout = new FrameLayout(this);
            frameLayout.setId(jKK);
            ((ViewGroup) this.mController.contentView).addView(frameLayout, layoutParams);
            com.tencent.mm.plugin.report.service.g.pQN.a(465, 0, 1, false);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(intent);
            if (com.tencent.mm.plugin.appbrand.appusage.h.aaW()) {
                this.jKQ = new d();
            }
            com.tencent.mm.plugin.appbrand.appusage.h.aaY();
            com.tencent.mm.plugin.appbrand.appusage.a.aaC();
            com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, getStatusBarColor(), true);
        } else {
            finish();
        }
    }

    protected final void onResume() {
        boolean z;
        super.onResume();
        getStatusBarColor();
        if (!this.jKM) {
            if (this.jKN == 1) {
                this.jxi = 7;
            } else if (this.jKN == 2) {
                this.jxi = 6;
            } else if (this.jKN == 3) {
                this.jxi = 9;
            } else if (this.jKN == 4) {
                this.jxi = 12;
            } else {
                this.jxi = 4;
            }
            this.jKL = "";
            this.jKN = 0;
            a aVar = (a) super.getSupportFragmentManager().N(jKK);
            if (aVar != null) {
                aVar.lw(this.jxi);
            }
        }
        this.jKM = false;
        if (com.tencent.mm.plugin.appbrand.appusage.a.aaE() || com.tencent.mm.plugin.appbrand.appusage.a.aaF()) {
            z = true;
        } else {
            z = false;
        }
        dg(z);
        if (!z && this.jKO) {
            com.tencent.mm.plugin.appbrand.appusage.g.a(this.jKP);
            if (!com.tencent.mm.plugin.appbrand.appusage.g.refresh()) {
                com.tencent.mm.plugin.appbrand.appusage.g.b(this.jKP);
            }
        }
        this.jKO = false;
    }

    protected final void onPause() {
        super.onPause();
    }

    protected final void onDestroy() {
        a aVar = (a) super.getSupportFragmentManager().N(jKK);
        if (aVar != null) {
            aVar.akE();
        }
        super.onDestroy();
        com.tencent.mm.plugin.appbrand.appusage.g.b(this.jKP);
        com.tencent.mm.plugin.appbrand.appusage.g.aaS();
        c.release();
        if (this.jKQ != null) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14113, (Object[]) this.jKQ.iJH);
            this.jKQ = null;
        }
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jKN = i;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("key_session_id");
            int intExtra = intent.getIntExtra("ftsbizscene", 0);
            x.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", stringExtra, com.tencent.mm.modelappbrand.b.hjy);
            com.tencent.mm.plugin.report.service.g.pQN.h(13929, stringExtra, com.tencent.mm.modelappbrand.b.hjy, Integer.valueOf(2), Integer.valueOf(intExtra));
        }
    }

    public final void setTitle(CharSequence charSequence) {
        O(charSequence);
    }

    public final void setTitle(int i) {
        setMMTitle(i);
    }

    public final void onBackPressed() {
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
