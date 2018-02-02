package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.v4.view.m;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.j;
import com.tencent.mm.w.a.k;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class p {
    private static WakeLock wakeLock = null;
    private static boolean xIQ = false;
    public static final int xJe = h.gWZ;
    private static byte[] xJh = new byte[]{(byte) 0};
    String className;
    public View contentView;
    AudioManager hWF;
    private com.tencent.mm.ui.tools.p lcZ;
    public ActionBar mActionBar;
    Context mContext;
    private int mTd = 0;
    private LayoutInflater nny;
    protected af pFW = new af(Looper.getMainLooper());
    private final long rHI = 300;
    private long rHJ = SystemClock.elapsedRealtime();
    private TextView xIA;
    FrameLayout xIB;
    boolean xIC = true;
    private String xID = " ";
    private int xIE = 0;
    private int xIF = 0;
    private e xIG = null;
    private e xIH = null;
    private e xII = null;
    private e xIJ = null;
    private boolean xIK = false;
    boolean xIL = false;
    public ActionBarActivity xIM;
    private boolean xIN;
    private a xIO = new a();
    public LinkedList<a> xIP = new LinkedList();
    private ArrayList<Dialog> xIR;
    public View xIS;
    public TextView xIT;
    View xIU;
    public ImageView xIV;
    View xIW;
    private TextView xIX;
    private ImageButton xIY;
    private ImageView xIZ;
    protected boolean xIo = false;
    private View xIx;
    public View xIy;
    View xIz;
    private int xJa = 0;
    private boolean xJb = false;
    private c xJc = new c<rs>(this) {
        final /* synthetic */ p xJm;

        {
            this.xJm = r2;
            this.xen = rs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.g.a.rs.a aVar = ((rs) bVar).fJx;
            if (aVar.fom == 2) {
                String str = aVar.fop;
                int i = aVar.position;
                x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position[%d] noticeId[%s]", Integer.valueOf(i), str);
                if (i <= 0 || i == this.xJm.xJa) {
                    this.xJm.a(aVar.foo, aVar.visible, aVar.url, aVar.desc, str, i, false);
                } else {
                    x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.xJm.xJa));
                }
            }
            return false;
        }
    };
    private int xJd = h.gWY;
    private int xJf = -1;
    public int xJg = 0;
    private a xJi;
    private MenuItem xJj;
    private Runnable xJk = new Runnable(this) {
        final /* synthetic */ p xJm;

        {
            this.xJm = r1;
        }

        public final void run() {
            this.xJm.xIM.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (this.xJm.mActionBar != null) {
                this.xJm.mActionBar.hide();
            }
        }
    };
    private Runnable xJl = new Runnable(this) {
        final /* synthetic */ p xJm;

        {
            this.xJm = r1;
        }

        public final void run() {
            if (this.xJm.mActionBar != null) {
                this.xJm.mActionBar.show();
            }
        }
    };

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ p xJm;
        final /* synthetic */ Runnable xJn;

        AnonymousClass2(p pVar, Runnable runnable) {
            this.xJm = pVar;
            this.xJn = runnable;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.xJm.rHJ < 300) {
                this.xJn.run();
            }
            this.xJm.rHJ = SystemClock.elapsedRealtime();
        }
    }

    public static final class a {
        boolean fqP = true;
        public OnLongClickListener mwJ;
        public OnMenuItemClickListener pRz;
        public String text;
        public int textColor;
        boolean visible = true;
        public int xJr = -1;
        int xJs;
        Drawable xJt;
        View xJu;
        View xJv;
        public int xJw = b.xJy;
        boolean xJx = false;
    }

    public enum b {
        ;

        static {
            xJy = 1;
            xJz = 2;
            xJA = 3;
            xJB = 4;
            xJC = 5;
            xJD = 6;
            xJE = 7;
            xJF = 8;
            xJG = 9;
            xJH = 10;
            xJI = 11;
            xJJ = new int[]{xJy, xJz, xJA, xJB, xJC, xJD, xJE, xJF, xJG, xJH, xJI};
        }
    }

    protected abstract boolean cmP();

    protected abstract void dealContentView(View view);

    protected abstract String getClassName();

    protected abstract String getIdentString();

    protected abstract int getLayoutId();

    protected abstract View getLayoutView();

    protected abstract void onCreateBeforeSetContentView();

    public abstract void onKeyboardStateChanged();

    static /* synthetic */ boolean a(p pVar, View view, a aVar) {
        if (pVar.xIC) {
            return aVar.mwJ != null ? aVar.mwJ.onLongClick(view) : false;
        } else {
            x.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
            return true;
        }
    }

    static /* synthetic */ boolean f(p pVar) {
        return (pVar.xIM.getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0;
    }

    static /* synthetic */ void g(p pVar) {
        pVar.xJg = 2;
        pVar.onKeyboardStateChanged();
    }

    static /* synthetic */ void h(p pVar) {
        pVar.xJg = 1;
        pVar.onKeyboardStateChanged();
    }

    private void a(int i, final boolean z, final String str, final String str2, final String str3, final int i2, boolean z2) {
        x.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str3, Integer.valueOf(i2), this.xIz);
        if (!needShowIdcError()) {
            return;
        }
        if (!z && this.xIz == null) {
            return;
        }
        if (this.mActionBar == null || this.mActionBar.isShowing()) {
            if (this.xIB == null) {
                this.xIB = (FrameLayout) this.contentView.findViewById(g.cwm);
            }
            if (this.xIz != null) {
                this.xIB.removeView(this.xIz);
            }
            int i3 = h.doj;
            if (i <= 0) {
                i = i3;
            }
            this.xIz = this.nny.inflate(i, null);
            this.xIA = (TextView) this.xIz.findViewById(g.cBq);
            this.xIz.findViewById(g.gVW).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ p xJm;

                public final void onClick(View view) {
                    com.tencent.mm.sdk.b.b ahVar = new ah();
                    ahVar.foi.type = 1;
                    ahVar.foi.fok = str3;
                    ahVar.foi.position = i2;
                    com.tencent.mm.sdk.b.a.xef.m(ahVar);
                    this.xJm.xIz.setVisibility(8);
                }
            });
            this.xIz.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ p xJm;

                public final void onClick(View view) {
                    if (str != null) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        this.xJm.mContext.startActivity(intent);
                    }
                }
            });
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.xJb && VERSION.SDK_INT >= 16) {
                layoutParams.setMargins(0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.xIM, 48.0f), 0, 0);
                x.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", Integer.valueOf(layoutParams.height), Integer.valueOf(layoutParams.topMargin));
            }
            this.xIB.addView(this.xIz, this.xIB.getChildCount(), layoutParams);
            if (this.xIz == null) {
                return;
            }
            if (z2) {
                this.xIz.setVisibility(z ? 0 : 8);
                String string = this.mContext.getString(k.gYB);
                if (bh.ov(str2)) {
                    str2 = this.mContext.getString(k.dYN);
                }
                if (str != null) {
                    CharSequence spannableString = new SpannableString(str2 + string);
                    spannableString.setSpan(new ForegroundColorSpan(-10119449), str2.length(), string.length() + str2.length(), 33);
                    this.xIA.setText(spannableString);
                } else {
                    x.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
                    this.xIA.setText(str2);
                }
                this.xIz.invalidate();
                this.xIB.invalidate();
                return;
            }
            this.xIz.post(new Runnable(this) {
                final /* synthetic */ p xJm;

                public final void run() {
                    this.xJm.xIz.setVisibility(z ? 0 : 8);
                    String string = this.xJm.mContext.getString(k.gYB);
                    CharSequence string2 = bh.ov(str2) ? this.xJm.mContext.getString(k.dYN) : str2;
                    if (str != null) {
                        CharSequence spannableString = new SpannableString(string2 + string);
                        spannableString.setSpan(new ForegroundColorSpan(-10119449), string2.length(), string2.length() + string.length(), 33);
                        this.xJm.xIA.setText(spannableString);
                    } else {
                        x.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
                        this.xJm.xIA.setText(string2);
                    }
                    this.xJm.xIz.invalidate();
                    this.xJm.xIB.invalidate();
                }
            });
            return;
        }
        x.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
    }

    private View findViewById(int i) {
        View findViewById = this.contentView.findViewById(i);
        return findViewById != null ? findViewById : this.xIM.findViewById(i);
    }

    public final void setBackGroundColorResource(int i) {
        if (this.contentView != null) {
            if (this.xIB == null) {
                this.xIB = (FrameLayout) this.contentView.findViewById(g.cwm);
            }
            this.xIB.setBackgroundResource(i);
            this.xIy.setBackgroundResource(i);
        }
    }

    public final void ad(int i, boolean z) {
        this.xJa = i;
        this.xJb = z;
    }

    public static Locale initLanguage(Context context) {
        return bn(context, w.d(context.getSharedPreferences(ac.cfs(), 0)));
    }

    public static Locale bn(Context context, String str) {
        Resources resources = ac.getResources();
        if (str.equals("language_default")) {
            w.a(context, Locale.ENGLISH);
            if (resources instanceof com.tencent.mm.bw.a) {
                ((com.tencent.mm.bw.a) resources).cdY();
            }
            return Locale.getDefault();
        }
        Locale UX = w.UX(str);
        w.a(context, UX);
        if (resources instanceof com.tencent.mm.bw.a) {
            ((com.tencent.mm.bw.a) resources).cdY();
        }
        return UX;
    }

    public ActionBar getSupportActionBar() {
        return this.xIM.getSupportActionBar();
    }

    public final void a(Context context, ActionBarActivity actionBarActivity) {
        this.mContext = actionBarActivity;
        this.xIM = actionBarActivity;
        onCreateBeforeSetContentView();
        this.className = getClass().getName();
        ad.aT(3, this.className);
        initLanguage(context);
        this.hWF = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        int layoutId = getLayoutId();
        this.nny = LayoutInflater.from(this.mContext);
        this.contentView = com.tencent.mm.kiss.a.b.DY().a(actionBarActivity, "R.layout.mm_activity", h.dnk);
        this.xIx = this.contentView.findViewById(g.gVR);
        this.xIB = (FrameLayout) this.contentView.findViewById(g.cwm);
        this.mTd = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.w.a.e.gUN);
        if (layoutId != -1) {
            this.xIy = getLayoutView();
            if (this.xIy == null) {
                this.xIy = this.nny.inflate(getLayoutId(), null);
            } else if (this.xIy.getParent() != null) {
                ((ViewGroup) this.xIy.getParent()).removeView(this.xIy);
            }
            this.xIB.addView(this.xIy, 0);
        }
        dealContentView(this.contentView);
        if (cmP()) {
            int dimensionPixelSize;
            ae.c(ae.a(this.xIM.getWindow(), this.xIy), this.xIy);
            ((ViewGroup) this.xIy.getParent()).removeView(this.xIy);
            ((ViewGroup) this.xIM.getWindow().getDecorView()).addView(this.xIy, 0);
            layoutId = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 25);
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.w.a.e.buF);
            } else {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.w.a.e.buG);
            }
            this.xIy.setPadding(this.xIy.getPaddingLeft(), dimensionPixelSize + (layoutId + this.xIy.getPaddingTop()), this.xIy.getPaddingRight(), this.xIy.getPaddingBottom());
        }
        this.mActionBar = getSupportActionBar();
        x.d("MicroMsg.MMActivityController", "onCreate, before.");
        V(actionBarActivity);
        if (this.xIB == null || !(this.xIB instanceof LayoutListenerView)) {
            x.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
        } else {
            ((LayoutListenerView) this.xIB).xHX = new com.tencent.mm.ui.LayoutListenerView.a(this) {
                final /* synthetic */ p xJm;
                private final int xJo = com.tencent.mm.bv.a.fromDPToPix(this.xJm.mContext, 100);

                {
                    this.xJm = r3;
                }

                public final void onSizeChanged(int i, int i2, int i3, int i4) {
                    if (!p.f(this.xJm) && i != 0 && i2 != 0 && i3 != 0 && i4 != 0 && i == i3) {
                        if (i2 > i4 && i2 - i4 > this.xJo) {
                            p.g(this.xJm);
                        } else if (i4 > i2 && i4 - i2 > this.xJo) {
                            p.h(this.xJm);
                        }
                    }
                }
            };
        }
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.foi.type = 2;
        ahVar.foi.position = this.xJa;
        com.tencent.mm.sdk.b.a.xef.m(ahVar);
        if (ahVar.foj.fom == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = ahVar.foj.fop;
            int i = ahVar.foj.position;
            x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", Integer.valueOf(i), str, bh.cgy());
            if (i <= 0 || i == this.xJa) {
                a(ahVar.foj.foo, ahVar.foj.visible, ahVar.foj.url, ahVar.foj.desc, str, i, true);
            } else {
                x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.xJa));
            }
            x.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = actionBarActivity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(actionBarActivity.getResources().getColor(d.btS));
        }
    }

    public boolean noActionBar() {
        return false;
    }

    final void V(Activity activity) {
        if (this.mActionBar != null && !noActionBar()) {
            if (VERSION.SDK_INT < 11) {
                this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.mContext.getResources().getColor(d.brg)));
            }
            x.d("MicroMsg.MMActivityController", "onCreate, after");
            this.mActionBar.setLogo(new ColorDrawable(this.xIM.getResources().getColor(17170445)));
            this.mActionBar.cO();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.cN();
            this.mActionBar.cP();
            this.mActionBar.setIcon(f.bHb);
            if (this.xJf == -1) {
                this.mActionBar.setCustomView(v.fv(this.xIM).inflate(this.xJd, new LinearLayout(this.xIM), false));
            } else {
                this.mActionBar.setCustomView(v.fv(this.xIM).inflate(this.xJf, new LinearLayout(this.xIM), false));
            }
            this.xIT = (TextView) findViewById(16908308);
            this.xIX = (TextView) findViewById(16908309);
            this.xIS = findViewById(g.divider);
            this.xIU = findViewById(g.bIV);
            this.xIV = (ImageView) findViewById(g.bIW);
            if (this.xIV != null) {
                this.xIV.setContentDescription(this.xIM.getString(k.dDO));
            }
            this.xIW = findViewById(g.gVg);
            if (this.xIT != null) {
                this.xIT.setText(k.app_name);
            }
            if (activity.getClass().getName() == "WebViewUI") {
                if (this.xIW != null) {
                    this.xIW.setVisibility(8);
                }
                if (this.xIV != null) {
                    this.xIV.setVisibility(0);
                }
                if (this.xIU != null) {
                    this.xIU.setVisibility(0);
                }
            } else if (activity instanceof MMActivity) {
                if (this.xIW != null) {
                    this.xIW.setVisibility(8);
                }
                if (this.xIV != null) {
                    this.xIV.setVisibility(0);
                }
                if (this.xIU != null) {
                    this.xIU.setVisibility(0);
                }
                if (this.xIT != null) {
                    this.xIT.setVisibility(0);
                }
            } else {
                if (this.xIW != null) {
                    this.xIW.setVisibility(0);
                }
                if (this.xIV != null) {
                    this.xIV.setVisibility(8);
                }
                if (this.xIU != null) {
                    this.xIU.setVisibility(8);
                }
            }
        }
    }

    public final void setScreenEnable(boolean z) {
        boolean z2 = true;
        this.xIC = z;
        if (this.xIx == null && this.contentView != null) {
            this.xIx = this.contentView.findViewById(g.gVR);
        }
        if (this.xIx == null) {
            x.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
            return;
        }
        this.xIx.setFocusable(!z);
        View view = this.xIx;
        if (z) {
            z2 = false;
        }
        view.setFocusableInTouchMode(z2);
        if (z) {
            synchronized (xJh) {
                if (wakeLock == null || !wakeLock.isHeld()) {
                    x.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", toString());
                } else {
                    wakeLock.release();
                    x.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
                }
            }
            return;
        }
        Context context = this.xIM;
        synchronized (xJh) {
            if (wakeLock == null) {
                wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(32, "screen Lock");
            }
            if (wakeLock.isHeld()) {
                x.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", toString());
            } else {
                wakeLock.acquire();
                x.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
            }
        }
    }

    public static boolean cna() {
        boolean isHeld;
        synchronized (xJh) {
            isHeld = wakeLock != null ? wakeLock.isHeld() : false;
        }
        return isHeld;
    }

    protected static int getForceOrientation() {
        return -1;
    }

    public final void onStart() {
        this.xIo = this.mContext.getSharedPreferences(ac.cfs(), 0).getBoolean("settings_landscape_mode", false);
        if (this.xIo) {
            this.xIM.setRequestedOrientation(-1);
        } else {
            this.xIM.setRequestedOrientation(1);
        }
    }

    public final boolean getLandscapeMode() {
        return this.xIo;
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || keyEvent.getAction() != 1) {
            return false;
        }
        if (this.xJi == null || !this.xJi.fqP) {
            return true;
        }
        a(this.xJj, this.xJi);
        return true;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.tencent.mm.compatible.b.f.xK();
        com.tencent.mm.compatible.b.f.xK();
        if (!this.xIN || this.lcZ == null || !this.lcZ.onKeyDown(i, keyEvent)) {
            return false;
        }
        x.d("MicroMsg.MMActivityController", "match search view on key down");
        return true;
    }

    public boolean needShowIdcError() {
        return true;
    }

    public final void onResume() {
        activateBroadcast(true);
        com.tencent.mm.sdk.b.a.xef.b(this.xJc);
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.foi.type = 2;
        ahVar.foi.position = this.xJa;
        com.tencent.mm.sdk.b.a.xef.m(ahVar);
        if (ahVar.foj.fom == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = ahVar.foj.fop;
            int i = ahVar.foj.position;
            x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", Integer.valueOf(i), str);
            if (i <= 0 || i == this.xJa) {
                a(ahVar.foj.foo, ahVar.foj.visible, ahVar.foj.url, ahVar.foj.desc, str, i, true);
            } else {
                x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.xJa));
            }
            x.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final void addDialog(Dialog dialog) {
        if (dialog != null) {
            if (this.xIR == null) {
                this.xIR = new ArrayList();
            }
            this.xIR.add(dialog);
        }
    }

    public final void onDestroy() {
        if (this.xIR != null) {
            int size = this.xIR.size();
            for (int i = 0; i < size; i++) {
                Dialog dialog = (Dialog) this.xIR.get(i);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
            this.xIR.clear();
            this.xIR = null;
        }
    }

    public final void activateBroadcast(boolean z) {
        if (xIQ || !z) {
            com.tencent.mm.ui.base.ac.a(z, new Intent().putExtra("classname", getClassName() + getIdentString()));
        } else {
            com.tencent.mm.ui.base.ac.a(z, new Intent().putExtra("classname", getClassName()).putExtra("main_process", false));
        }
    }

    public static void cmR() {
        xIQ = true;
    }

    public final void onPause() {
        activateBroadcast(false);
        com.tencent.mm.sdk.b.a.xef.c(this.xJc);
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", Integer.valueOf(this.xIP.size()));
        if (this.mActionBar == null || this.xIP.size() == 0) {
            x.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.xIP.size()));
            return false;
        }
        this.xJi = null;
        this.xJj = null;
        if (this.mActionBar.getHeight() == 0) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.w.a.e.buF);
            } else {
                this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.w.a.e.buG);
            }
        }
        Iterator it = this.xIP.iterator();
        while (it.hasNext()) {
            final a aVar = (a) it.next();
            if (aVar.xJr == 16908332) {
                x.v("MicroMsg.MMActivityController", "match back option menu, continue");
            } else if (aVar.xJr == g.cvP) {
                boolean z;
                r1 = "MicroMsg.MMActivityController";
                String str = "match search menu, enable search view[%B], search view helper is null[%B]";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(this.xIN);
                if (this.lcZ == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                x.v(r1, str, objArr);
                if (this.xIN && this.lcZ != null) {
                    this.lcZ.a(this.xIM, menu);
                }
            } else {
                final MenuItem add = menu.add(0, aVar.xJr, 0, aVar.text);
                r1 = getClass().getName();
                if (add == null) {
                    x.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
                } else if (add.getTitleCondensed() == null) {
                    x.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", r1);
                    add.setTitleCondensed("");
                } else if (!(add.getTitleCondensed() instanceof String)) {
                    x.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", r1, add.getTitleCondensed().getClass().getName(), add.getTitleCondensed());
                    add.setTitleCondensed(add.getTitleCondensed().toString());
                }
                OnClickListener anonymousClass10 = new OnClickListener(this) {
                    final /* synthetic */ p xJm;

                    public final void onClick(View view) {
                        this.xJm.a(add, aVar);
                    }
                };
                OnLongClickListener anonymousClass11 = new OnLongClickListener(this) {
                    final /* synthetic */ p xJm;

                    public final boolean onLongClick(View view) {
                        return p.a(this.xJm, view, aVar);
                    }
                };
                if (aVar.xJs == 0 && aVar.xJt == null) {
                    TextView textView;
                    if (aVar.xJu == null) {
                        aVar.xJu = View.inflate(this.mContext, h.gWV, null);
                    }
                    if (aVar.xJw == b.xJA) {
                        aVar.xJu.findViewById(g.bIK).setVisibility(8);
                        aVar.xJu.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xJu.findViewById(g.gVj);
                        textView.setBackgroundResource(f.bAd);
                        textView.setPadding(this.mTd, 0, this.mTd, 0);
                    } else if (aVar.xJw == b.xJz) {
                        aVar.xJu.findViewById(g.bIK).setVisibility(8);
                        aVar.xJu.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xJu.findViewById(g.gVj);
                        textView.setBackgroundResource(f.bAb);
                        textView.setPadding(this.mTd, 0, this.mTd, 0);
                    } else if (aVar.xJw == b.xJB) {
                        aVar.xJu.findViewById(g.bIK).setVisibility(8);
                        aVar.xJu.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xJu.findViewById(g.gVj);
                        ((TextView) aVar.xJu.findViewById(g.gVj)).setTextColor(-8393929);
                        textView.setBackgroundResource(f.gUZ);
                        textView.setPadding(this.mTd, 0, this.mTd, 0);
                        aVar.xJu.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                    } else if (aVar.xJw == b.xJC || aVar.xJw == b.xJD || aVar.xJw == b.xJE || aVar.xJw == b.xJG) {
                        aVar.xJu.findViewById(g.gVj).setVisibility(8);
                        aVar.xJu.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xJu.findViewById(g.bIK);
                        if (aVar.xJw == b.xJD) {
                            textView.setTextColor(this.xIM.getResources().getColor(d.gUE));
                        } else if (aVar.xJw == b.xJE) {
                            textView.setTextColor(this.xIM.getResources().getColor(d.bui));
                        } else if (aVar.xJw == b.xJG) {
                            textView.setTextColor(this.xIM.getResources().getColor(d.gUy));
                        }
                    } else if (aVar.xJw == b.xJF) {
                        aVar.xJu.findViewById(g.bIK).setVisibility(8);
                        aVar.xJu.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xJu.findViewById(g.gVj);
                        textView.setBackgroundResource(f.gUQ);
                        textView.setPadding(this.mTd, 0, this.mTd, 0);
                        textView.setTextColor(-2601405);
                    } else if (aVar.xJw == b.xJH) {
                        aVar.xJu.findViewById(g.gVj).setVisibility(8);
                        aVar.xJu.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xJu.findViewById(g.bIK);
                        textView.setTextColor(this.xIM.getResources().getColor(d.bui));
                        textView.setBackgroundResource(f.gUP);
                    } else if (aVar.xJw == b.xJI) {
                        aVar.xJu.findViewById(g.gVj).setVisibility(8);
                        aVar.xJu.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xJu.findViewById(g.bIK);
                        textView.setTextColor(this.xIM.getResources().getColor(d.black));
                    } else {
                        aVar.xJu.findViewById(g.gVj).setVisibility(8);
                        aVar.xJu.findViewById(g.divider).setVisibility(0);
                        textView = (TextView) aVar.xJu.findViewById(g.bIK);
                    }
                    textView.setVisibility(0);
                    textView.setText(aVar.text);
                    if (aVar.textColor != 0) {
                        textView.setTextColor(aVar.textColor);
                    }
                    textView.setOnClickListener(anonymousClass10);
                    textView.setOnLongClickListener(anonymousClass11);
                    textView.setEnabled(aVar.fqP);
                    m.a(add, aVar.xJu);
                } else {
                    if (aVar.xJv == null) {
                        aVar.xJv = View.inflate(this.mContext, h.gWV, null);
                    }
                    ImageView imageView = (ImageView) aVar.xJv.findViewById(g.divider);
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    this.xIY = (ImageButton) aVar.xJv.findViewById(g.gVi);
                    this.xIY.setVisibility(0);
                    if (aVar.xJt != null) {
                        this.xIY.setImageDrawable(aVar.xJt);
                    } else {
                        this.xIY.setImageResource(aVar.xJs);
                    }
                    this.xIY.setOnClickListener(anonymousClass10);
                    this.xIY.setEnabled(aVar.fqP);
                    this.xIY.setContentDescription(aVar.text);
                    if (aVar.mwJ != null) {
                        this.xIY.setOnLongClickListener(anonymousClass11);
                    }
                    this.xIZ = (ImageView) aVar.xJv.findViewById(g.cct);
                    if (this.xIZ != null) {
                        if (aVar.xJx) {
                            this.xIZ.setVisibility(0);
                        } else {
                            this.xIZ.setVisibility(8);
                        }
                    }
                    m.a(add, aVar.xJv);
                }
                add.setEnabled(aVar.fqP);
                add.setVisible(aVar.visible);
                m.a(add, 2);
                if (aVar.xJs == f.bDI) {
                    this.xJi = aVar;
                    this.xJj = add;
                }
                x.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", Integer.valueOf(aVar.xJr), aVar.text, Boolean.valueOf(aVar.fqP), Boolean.valueOf(aVar.visible));
            }
        }
        return true;
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        x.d("MicroMsg.MMActivityController", "on prepare option menu");
        if (this.xIN && this.lcZ != null) {
            this.lcZ.a(this.xIM, menu);
        }
        return true;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        x.v("MicroMsg.MMActivityController", "on options item selected");
        if (!this.xIC) {
            x.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
            return true;
        } else if (menuItem.getItemId() == this.xIO.xJr && this.xIO.fqP) {
            a(menuItem, this.xIO);
            return true;
        } else {
            Iterator it = this.xIP.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (menuItem.getItemId() == aVar.xJr) {
                    x.d("MicroMsg.MMActivityController", "on option menu %d click", Integer.valueOf(menuItem.getItemId()));
                    a(menuItem, aVar);
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean callBackMenu() {
        if (this.xIO == null || !this.xIO.fqP) {
            return false;
        }
        a(null, this.xIO);
        return true;
    }

    private void a(MenuItem menuItem, a aVar) {
        if (!this.xIC) {
            x.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
        } else if (aVar.pRz != null) {
            aVar.pRz.onMenuItemClick(menuItem);
        }
    }

    public final void fullScreenNoTitleBar(boolean z) {
        if (z) {
            if (this.mActionBar != null) {
                this.mActionBar.hide();
            }
            this.pFW.removeCallbacks(this.xJl);
            this.pFW.removeCallbacks(this.xJk);
            this.pFW.postDelayed(this.xJk, 256);
            return;
        }
        this.xIM.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.pFW.removeCallbacks(this.xJk);
        this.pFW.removeCallbacks(this.xJl);
        this.pFW.postDelayed(this.xJl, 256);
    }

    public final void i(boolean z, long j) {
        if (this.mActionBar != null) {
            this.mActionBar.hide();
        }
        this.pFW.removeCallbacks(this.xJl);
        this.pFW.removeCallbacks(this.xJk);
        this.pFW.postDelayed(this.xJk, 0);
    }

    public final void setTitleVisibility(int i) {
        if (this.mActionBar != null) {
            if (i == 0) {
                this.mActionBar.show();
                if (VERSION.SDK_INT >= 21) {
                    this.xIM.getWindow().setStatusBarColor(this.xIM.getResources().getColor(d.btS));
                    return;
                }
                return;
            }
            this.mActionBar.hide();
            if (VERSION.SDK_INT >= 21) {
                this.xIM.getWindow().setStatusBarColor(this.xIM.getResources().getColor(d.black));
            }
        }
    }

    public final void setMMTitle(String str) {
        if (this.mActionBar != null) {
            this.xID = str;
            if (com.tencent.mm.bv.a.ey(this.xIM)) {
                this.xIT.setTextSize(0, ((float) com.tencent.mm.bv.a.ab(this.xIM, com.tencent.mm.w.a.e.bum)) * com.tencent.mm.bv.a.ew(this.xIM));
            }
            cnb();
            updateDescription(str);
        }
    }

    public final void O(CharSequence charSequence) {
        if (this.mActionBar != null) {
            this.xID = charSequence.toString();
            this.xIT.setText(charSequence);
            if (com.tencent.mm.bv.a.ey(this.xIM)) {
                this.xIT.setTextSize(0, ((float) com.tencent.mm.bv.a.ab(this.xIM, com.tencent.mm.w.a.e.bum)) * com.tencent.mm.bv.a.ew(this.xIM));
            }
            updateDescription(charSequence.toString());
        }
    }

    protected final void updateDescription(String str) {
        com.tencent.mm.ui.a.a cnI = a.xNi;
        Activity activity = this.xIM;
        if (!cnI.cnH() && !bh.ov(str) && activity != null) {
            activity.getWindow().getDecorView().setContentDescription(activity.getString(k.gYy) + str);
        }
    }

    public final void setMMTitle(int i) {
        setMMTitle(this.mContext.getString(i));
    }

    public final void setMMSubTitle(String str) {
        if (this.mActionBar != null) {
            if (str == null) {
                this.xIX.setVisibility(8);
                return;
            }
            this.xIX.setText(str);
            if (com.tencent.mm.bv.a.ey(this.xIM)) {
                this.xIX.setTextSize(1, 14.0f);
                this.xIT.setTextSize(1, 18.0f);
            }
            this.xIX.setVisibility(0);
            updateDescription(str);
        }
    }

    public final void setMMSubTitle(int i) {
        if (this.mActionBar != null) {
            this.xIX.setText(this.mContext.getString(i));
            if (com.tencent.mm.bv.a.ey(this.xIM)) {
                this.xIX.setTextSize(1, 14.0f);
                this.xIT.setTextSize(1, 18.0f);
            }
            this.xIX.setVisibility(0);
            updateDescription(this.mContext.getString(i));
        }
    }

    public final void setTitleLogo(int i, int i2) {
        if (this.mActionBar != null) {
            if (i == 0) {
                this.xIE = 0;
                this.xIG = null;
            } else if (this.xIE != i) {
                this.xIE = i;
                this.xIG = eK(this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.w.a.e.bus), this.xIE);
            }
            if (i2 == 0) {
                this.xIF = 0;
                this.xIH = null;
            } else if (this.xIF != i2) {
                this.xIF = i2;
                this.xIH = eK(this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.w.a.e.bus), this.xIF);
            }
            cnb();
        }
    }

    private e eK(int i, int i2) {
        Drawable drawable = this.mContext.getResources().getDrawable(i2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        e eVar = new e(drawable, 1);
        eVar.zsZ = (drawable.getIntrinsicHeight() - i) / 2;
        return eVar;
    }

    final void cnb() {
        String str;
        int i;
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        String str3 = "%s";
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.w.a.e.bus);
        if (this.xIE != 0) {
            str3 = "# " + str3;
        }
        if (this.xIF != 0) {
            str = str3 + " #";
            i = 1;
        } else {
            str = str3;
            i = 0;
        }
        if (this.xIK) {
            str2 = str + " #";
            i2 = i + 2;
            i = 1;
        } else {
            str2 = str;
            i2 = i;
            i = 0;
        }
        if (this.xIL) {
            i3 = i + 2;
            i4 = i2 + 2;
            str3 = str2 + " #";
            i5 = 1;
        } else {
            i3 = i;
            i4 = i2;
            str3 = str2;
            i5 = 0;
        }
        CharSequence format = String.format(str3, new Object[]{this.xID});
        x.v("MicroMsg.MMActivityController", "span title format %s", str3);
        format = com.tencent.mm.ui.e.c.b.a(this.mContext, format, dimensionPixelSize);
        if (format instanceof SpannableString) {
            int length;
            SpannableString spannableString = (SpannableString) format;
            if (this.xIE != 0) {
                spannableString.setSpan(this.xIG, 0, 1, 33);
            }
            if (this.xIF != 0) {
                length = spannableString.length() - i4;
                spannableString.setSpan(this.xIH, length, length + 1, 33);
            }
            if (this.xIK) {
                if (this.xII == null) {
                    this.xII = eK(dimensionPixelSize, j.gYo);
                }
                length = spannableString.length() - i3;
                spannableString.setSpan(this.xII, length, length + 1, 33);
            }
            if (this.xIL) {
                if (this.xIJ == null) {
                    this.xIJ = eK(dimensionPixelSize, j.gYp);
                }
                length = spannableString.length() - i5;
                spannableString.setSpan(this.xIJ, length, length + 1, 33);
            }
        }
        this.xIT.setText(format);
    }

    public final void showHomeBtn(boolean z) {
        int i = 8;
        if (this.mActionBar != null) {
            this.mActionBar.setDisplayHomeAsUpEnabled(z);
            if (this.xIU != null && this.xIW != null) {
                int i2;
                View view = this.xIU;
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                view.setVisibility(i2);
                View view2 = this.xIW;
                if (!z) {
                    i = 0;
                }
                view2.setVisibility(i);
            }
        }
    }

    public void supportInvalidateOptionsMenu() {
        this.xIM.supportInvalidateOptionsMenu();
    }

    public boolean interceptSupportInvalidateOptionsMenu() {
        return false;
    }

    public final void enableBackMenu(boolean z) {
        if (this.xIO != null && this.xIO.fqP != z) {
            this.xIO.fqP = z;
            supportInvalidateOptionsMenu();
        }
    }

    final void a(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.xIP.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.fqP != z2) {
                    aVar.fqP = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.xIP.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.xJr != i || aVar.fqP == z2) {
                    z4 = z3;
                } else {
                    aVar.fqP = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        if (!(this.lcZ == null ? false : this.lcZ.zmn)) {
            supportInvalidateOptionsMenu();
        }
        x.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    final void b(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.xIP.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.visible != z2) {
                    aVar.visible = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.xIP.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.xJr != i || aVar.visible == z2) {
                    z4 = z3;
                } else {
                    aVar.visible = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        z4 = this.lcZ == null ? false : this.lcZ.zmn;
        if (z3 && !z4) {
            supportInvalidateOptionsMenu();
        }
        x.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    public final void addSearchMenu(boolean z, com.tencent.mm.ui.tools.p pVar) {
        x.v("MicroMsg.MMActivityController", "add search menu");
        a aVar = new a();
        aVar.xJr = g.cvP;
        aVar.text = this.mContext.getString(k.dGz);
        aVar.xJs = j.dvb;
        aVar.pRz = null;
        aVar.mwJ = null;
        removeOptionMenu(aVar.xJr);
        this.xIP.add(0, aVar);
        this.xIN = z;
        this.lcZ = pVar;
        supportInvalidateOptionsMenu();
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, 0, str, false, onMenuItemClickListener, null, b.xJy);
    }

    public final void addTextOptionMenu$7df2a0ca(int i, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, int i2) {
        a(i, 0, str, false, onMenuItemClickListener, onLongClickListener, i2);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i2, "", false, onMenuItemClickListener, null, b.xJy);
    }

    public final void a(int i, String str, Drawable drawable, OnMenuItemClickListener onMenuItemClickListener) {
        int i2 = b.xJy;
        a aVar = new a();
        aVar.xJr = i;
        aVar.xJt = drawable;
        aVar.text = str;
        aVar.pRz = onMenuItemClickListener;
        aVar.mwJ = null;
        aVar.xJw = i2;
        DS(aVar.xJr);
        this.xIP.add(aVar);
        new af().postDelayed(new Runnable(this) {
            final /* synthetic */ p xJm;

            {
                this.xJm = r1;
            }

            public final void run() {
                this.xJm.supportInvalidateOptionsMenu();
            }
        }, 200);
    }

    public final void addIconOptionMenu(int i, String str, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i2, str, false, onMenuItemClickListener, null, b.xJy);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i3, this.mContext.getString(i2), false, onMenuItemClickListener, null, b.xJy);
    }

    public final void updateOptionMenuText(int i, String str) {
        a DT = DT(i);
        if (DT != null && !bh.az(str, "").equals(DT.text)) {
            DT.text = str;
            supportInvalidateOptionsMenu();
        }
    }

    public final void updateOptionMenuListener(int i, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        a DT = DT(i);
        if (DT != null) {
            DT.pRz = onMenuItemClickListener;
            DT.mwJ = onLongClickListener;
        }
    }

    public final void setBackBtn(final OnMenuItemClickListener onMenuItemClickListener, int i) {
        if (this.mActionBar != null) {
            if (onMenuItemClickListener == null) {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
            } else {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
                if (this.xIU != null) {
                    this.xIU.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ p xJm;

                        public final void onClick(View view) {
                            onMenuItemClickListener.onMenuItemClick(null);
                        }
                    });
                }
            }
            if (!(this.xIV == null || i == 0)) {
                this.xIV.setImageResource(i);
            }
            this.xIO.xJr = 16908332;
            this.xIO.pRz = onMenuItemClickListener;
        }
    }

    public final void removeAllOptionMenu() {
        if (!this.xIP.isEmpty()) {
            this.xIP.clear();
            supportInvalidateOptionsMenu();
        }
    }

    public final boolean DS(int i) {
        for (int i2 = 0; i2 < this.xIP.size(); i2++) {
            if (((a) this.xIP.get(i2)).xJr == i) {
                x.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.xIP.remove(i2);
                return true;
            }
        }
        return false;
    }

    public final boolean removeOptionMenu(int i) {
        for (int i2 = 0; i2 < this.xIP.size(); i2++) {
            if (((a) this.xIP.get(i2)).xJr == i) {
                x.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.xIP.remove(i2);
                supportInvalidateOptionsMenu();
                return true;
            }
        }
        return false;
    }

    final void a(int i, int i2, String str, boolean z, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, int i3) {
        a aVar = new a();
        aVar.xJr = i;
        aVar.xJs = i2;
        aVar.text = str;
        aVar.pRz = onMenuItemClickListener;
        aVar.mwJ = onLongClickListener;
        aVar.xJw = i3;
        aVar.xJx = z;
        if (aVar.xJs == f.bDI && bh.ov(str)) {
            aVar.text = this.mContext.getString(k.gYx);
        }
        DS(aVar.xJr);
        this.xIP.add(aVar);
        supportInvalidateOptionsMenu();
    }

    public final a DT(int i) {
        Iterator it = this.xIP.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.xJr == i) {
                return aVar;
            }
        }
        return null;
    }

    public final CharSequence getMMTitle() {
        if (this.mActionBar == null) {
            return null;
        }
        return this.xID != null ? this.xID : this.mActionBar.getTitle();
    }

    public final void hideTitleView() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "hideTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        if (this.mActionBar != null) {
            this.mActionBar.hide();
        }
    }

    public final void showTitleView() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "showTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        if (this.mActionBar != null) {
            this.mActionBar.show();
        }
    }

    public final boolean isTitleShowing() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "isTitleShowing hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        if (this.mActionBar == null) {
            return false;
        }
        return this.mActionBar.isShowing();
    }

    public final int getTitleLocation() {
        if (this.mActionBar == null) {
            return 0;
        }
        return this.mActionBar.getHeight();
    }

    public final void setTitleMuteIconVisibility(int i) {
        this.xIK = i == 0;
        cnb();
    }

    public final boolean hideVKB() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        View currentFocus = this.xIM.getCurrentFocus();
        if (currentFocus == null) {
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.MMActivityController", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        x.v("MicroMsg.MMActivityController", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
        return hideSoftInputFromWindow;
    }

    public final boolean hideVKB(View view) {
        if (view == null) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        return hideSoftInputFromWindow;
    }

    public final void showVKB() {
        Activity activity = this.xIM;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }
}
