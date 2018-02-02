package com.tencent.mm.plugin.webwx.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.k.f;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ao;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

@a(3)
public class WebWXLogoutUI extends MMActivity implements e, ao {
    private boolean kHG;
    private c qWt = new c<qw>(this) {
        final /* synthetic */ WebWXLogoutUI tOP;

        {
            this.tOP = r2;
            this.xen = qw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qw qwVar = (qw) bVar;
            x.d("MicroMsg.WebWXLogoutUI", "status Notify function");
            if (qwVar.fIH.fut == 8) {
                this.tOP.finish();
            }
            return false;
        }
    };
    private ProgressDialog qib = null;
    private boolean tOA = false;
    private boolean tOG;
    private ImageButton tOH;
    private ImageButton tOI;
    private ImageView tOJ;
    private int tOK;
    private int tOL;
    private int tOM;
    private Animator tON;
    private int tOO;

    static /* synthetic */ boolean b(WebWXLogoutUI webWXLogoutUI) {
        if (!ar.Hj()) {
            return false;
        }
        int FY = q.FY();
        FY = webWXLogoutUI.tOG ? FY | 8192 : FY & -8193;
        f.fR(FY);
        ar.Hg();
        com.tencent.mm.z.c.CU().set(40, Integer.valueOf(FY));
        webWXLogoutUI.tOA = true;
        webWXLogoutUI.akJ();
        return true;
    }

    static /* synthetic */ void e(WebWXLogoutUI webWXLogoutUI) {
        if (webWXLogoutUI.kHG) {
            ar.CG().a(new com.tencent.mm.plugin.webwx.a.b(2), 0);
            x.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : UNLOCK");
            return;
        }
        ar.CG().a(new com.tencent.mm.plugin.webwx.a.b(1), 0);
        x.d("MicroMsg.WebWXLogoutUI", "doScene netSceneExtDeviceControl : LOCK");
    }

    static /* synthetic */ boolean f(WebWXLogoutUI webWXLogoutUI) {
        if (webWXLogoutUI.tOO == com.tencent.mm.modelsimple.q.RT()) {
            h.a(webWXLogoutUI.mController.xIM, com.tencent.mm.modelsimple.q.hNm, webWXLogoutUI.getString(R.l.dGO), webWXLogoutUI.getString(R.l.eXk), webWXLogoutUI.getString(R.l.dEn), new 8(webWXLogoutUI), null);
        } else {
            webWXLogoutUI.finish();
        }
        return true;
    }

    static /* synthetic */ int g(WebWXLogoutUI webWXLogoutUI) {
        int[] iArr = new int[2];
        View findViewById = webWXLogoutUI.findViewById(R.h.cZe);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            webWXLogoutUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        x.d("MicroMsg.WebWXLogoutUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height));
        return (((int) (((double) point.y) / 4.0d)) - i) - height;
    }

    protected final int getLayoutId() {
        return R.i.dui;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bqm);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        if (getIntent() != null) {
            this.tOO = getIntent().getIntExtra("intent.key.online_version", 0);
        }
        initView();
        overridePendingTransition(R.a.bqo, R.a.bpQ);
        ar.CG().a(281, (e) this);
        ar.CG().a(792, (e) this);
        ar.Hg();
        com.tencent.mm.z.c.a(this);
        com.tencent.mm.sdk.b.a.xef.b(this.qWt);
    }

    protected void onPause() {
        super.onPause();
        if (this.tOA && ar.Hj()) {
            com.tencent.mm.bq.a wlVar = new wl();
            wlVar.wgL = 27;
            wlVar.wgM = q.gL(q.FY()) ? 1 : 2;
            ar.Hg();
            com.tencent.mm.z.c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, wlVar));
            this.tOA = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(R.a.bpQ, R.a.bqm);
        ar.CG().b(281, (e) this);
        ar.CG().b(792, (e) this);
        ar.Hg();
        com.tencent.mm.z.c.b(this);
        com.tencent.mm.sdk.b.a.xef.c(this.qWt);
    }

    protected final void initView() {
        setMMTitle("");
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.e.btS));
        }
        if (f.zo()) {
            this.tOI = (ImageButton) findViewById(R.h.cYU);
            if (q.gL(q.FY())) {
                this.tOG = true;
            } else {
                this.tOG = false;
            }
            kE(this.tOG);
            this.tOI.setOnClickListener(new 1(this));
        } else {
            findViewById(R.h.bWi).setVisibility(8);
            this.tOG = false;
        }
        this.tOJ = (ImageView) findViewById(R.h.cPp);
        x.d("MicroMsg.WebWXLogoutUI", "need hide lock bt ?: " + com.tencent.mm.modelsimple.q.RU());
        if (com.tencent.mm.modelsimple.q.RU()) {
            findViewById(R.h.cuf).setVisibility(8);
        } else {
            final Animator loadAnimator = AnimatorInflater.loadAnimator(this, R.b.bqL);
            loadAnimator.setTarget(findViewById(R.h.cYZ));
            this.tON = AnimatorInflater.loadAnimator(this, R.b.bqM);
            this.tON.setTarget(findViewById(R.h.cYZ));
            this.tON.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ WebWXLogoutUI tOP;

                {
                    this.tOP = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    this.tOP.kD(this.tOP.kHG);
                }
            });
            this.kHG = com.tencent.mm.modelsimple.q.RS();
            this.tOH = (ImageButton) findViewById(R.h.cYX);
            kD(this.kHG);
            this.tOH.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WebWXLogoutUI tOP;

                public final void onClick(View view) {
                    if (this.tOP.kHG) {
                        this.tOP.tOH.setImageResource(R.k.dxT);
                    } else {
                        this.tOP.tOH.setImageResource(R.k.dxS);
                    }
                    WebWXLogoutUI.e(this.tOP);
                    this.tOP.findViewById(R.h.cYZ).setVisibility(0);
                    loadAnimator.start();
                }
            });
        }
        ImageButton imageButton = (ImageButton) findViewById(R.h.cYV);
        x.d("MicroMsg.WebWXLogoutUI", "need hide file bt ?: " + com.tencent.mm.modelsimple.q.RV());
        if (com.tencent.mm.modelsimple.q.RV()) {
            imageButton.setVisibility(8);
        } else {
            imageButton.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WebWXLogoutUI tOP;

                {
                    this.tOP = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", "filehelper");
                    intent.putExtra("key_show_bottom_app_panel", true);
                    com.tencent.mm.plugin.webwx.a.ifs.e(intent, this.tOP);
                    x.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
                    this.tOP.finish();
                }
            });
        }
        Button button = (Button) findViewById(R.h.cZf);
        button.setText(com.tencent.mm.modelsimple.q.hNp);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebWXLogoutUI tOP;

            {
                this.tOP = r1;
            }

            public final void onClick(View view) {
                x.d("MicroMsg.WebWXLogoutUI", "logout webwx");
                WebWXLogoutUI.f(this.tOP);
            }
        });
        ((TextView) findViewById(R.h.cZg)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebWXLogoutUI tOP;

            {
                this.tOP = r1;
            }

            public final void onClick(View view) {
                this.tOP.finish();
            }
        });
        Drawable drawable;
        Drawable drawable2;
        if (com.tencent.mm.modelsimple.q.RQ() == 1) {
            drawable = getResources().getDrawable(R.k.dxZ);
            drawable2 = getResources().getDrawable(R.k.dya);
            if (!(drawable == null || drawable2 == null)) {
                this.tOK = drawable.getIntrinsicWidth();
                this.tOL = drawable2.getIntrinsicWidth();
            }
        } else if (com.tencent.mm.modelsimple.q.RQ() == 2) {
            drawable = getResources().getDrawable(R.k.dxV);
            drawable2 = getResources().getDrawable(R.k.dxX);
            if (!(drawable == null || drawable2 == null)) {
                this.tOK = drawable.getIntrinsicWidth();
                this.tOL = drawable2.getIntrinsicWidth();
            }
        }
        this.tOJ.post(new Runnable(this) {
            final /* synthetic */ WebWXLogoutUI tOP;

            {
                this.tOP = r1;
            }

            public final void run() {
                this.tOP.tOM = WebWXLogoutUI.g(this.tOP);
                this.tOP.akJ();
            }
        });
    }

    private void akJ() {
        if (!bh.ov(com.tencent.mm.modelsimple.q.hNh)) {
            ((TextView) findViewById(R.h.cPo)).setText(com.tencent.mm.modelsimple.q.hNh);
            if (com.tencent.mm.modelsimple.q.RQ() == 1) {
                if (!this.tOG) {
                    this.tOJ.setImageResource(R.k.dya);
                    this.tOJ.setPadding(this.tOL - this.tOK, this.tOM, 0, 0);
                    return;
                }
            } else if (com.tencent.mm.modelsimple.q.RQ() == 2) {
                if (this.tOG) {
                    ((TextView) findViewById(R.h.cEe)).setText(R.l.eXn);
                } else if (!f.zo()) {
                    ((TextView) findViewById(R.h.cEe)).setText("");
                }
                if (this.kHG) {
                    ((TextView) findViewById(R.h.cPo)).setText(getString(R.l.eXd, new Object[]{"Mac"}));
                    this.tOJ.setImageResource(R.k.dxW);
                    this.tOJ.setPadding(0, this.tOM, 0, 0);
                    if (f.zo() && !this.tOG) {
                        ((TextView) findViewById(R.h.cEe)).setText(R.l.eXc);
                        this.tOJ.setImageResource(R.k.dxY);
                        this.tOJ.setPadding(this.tOL - this.tOK, this.tOM, 0, 0);
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.h.cPo)).setText(getString(R.l.eXf, new Object[]{"Mac"}));
                this.tOJ.setImageResource(R.k.dxV);
                this.tOJ.setPadding(0, this.tOM, 0, 0);
                if (f.zo() && !this.tOG) {
                    ((TextView) findViewById(R.h.cEe)).setText(R.l.eXc);
                    this.tOJ.setImageResource(R.k.dxX);
                    this.tOJ.setPadding(this.tOL - this.tOK, this.tOM, 0, 0);
                    return;
                }
                return;
            } else if (com.tencent.mm.modelsimple.q.RQ() == 3) {
                this.tOJ.setImageResource(R.k.dxU);
                this.tOJ.setPadding(0, this.tOM, 0, 0);
                return;
            }
            this.tOJ.setImageResource(R.k.dxZ);
            this.tOJ.setPadding(0, this.tOM, 0, 0);
        }
    }

    private void kD(boolean z) {
        if (this.tOH == null) {
            return;
        }
        if (z) {
            this.tOH.setImageResource(R.g.bHU);
            ((TextView) findViewById(R.h.cYY)).setText(R.l.eXo);
            return;
        }
        this.tOH.setImageResource(R.g.bHS);
        ((TextView) findViewById(R.h.cYY)).setText(R.l.cYX);
    }

    private void kE(boolean z) {
        if (this.tOI == null) {
            return;
        }
        if (z) {
            this.tOI.setImageResource(R.g.bHR);
        } else {
            this.tOI.setImageResource(R.g.bHT);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.qib != null) {
            this.qib.dismiss();
            this.qib = null;
        }
        if (kVar.getType() == 281) {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, R.l.eXl, 1).show();
            }
            finish();
        } else if (kVar.getType() == 792) {
            int i3 = ((com.tencent.mm.plugin.webwx.a.b) kVar).fut;
            if (this.tON != null) {
                this.tON.start();
            }
            if (i == 0 && i2 == 0) {
                boolean z;
                if (i3 == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.kHG = z;
                com.tencent.mm.modelsimple.q.bT(this.kHG);
                akJ();
                String str2 = "MicroMsg.WebWXLogoutUI";
                String str3 = "%s extDevice success";
                Object[] objArr = new Object[1];
                objArr[0] = this.kHG ? "lock" : "unlock";
                x.d(str2, str3, objArr);
            } else if (i3 == 1) {
                Toast.makeText(this, R.l.eXe, 0).show();
            } else {
                Toast.makeText(this, R.l.eXp, 0).show();
            }
        }
    }

    public final void GX() {
        ar.Hg();
        if (!com.tencent.mm.z.c.ET()) {
            finish();
        } else if (com.tencent.mm.modelsimple.q.RS() && !this.kHG) {
            x.d("MicroMsg.WebWXLogoutUI", "extDevice remote lock");
            this.kHG = true;
            kD(this.kHG);
            akJ();
        }
    }
}
