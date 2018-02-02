package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.v;
import android.support.v4.view.ae;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.ap;
import android.support.v4.view.k;
import android.support.v4.view.z;
import android.support.v4.widget.m;
import android.support.v7.a.a.j;
import android.support.v7.view.menu.e;
import android.support.v7.view.menu.f;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.am;
import android.support.v7.widget.ar;
import android.support.v7.widget.at;
import android.support.v7.widget.h;
import android.support.v7.widget.t;
import android.support.v7.widget.x;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

class AppCompatDelegateImplV7 extends f implements k, android.support.v7.view.menu.f.a {
    private TextView FN;
    private t GX;
    private a GY;
    private d GZ;
    android.support.v7.view.b Ha;
    ActionBarContextView Hb;
    PopupWindow Hc;
    Runnable Hd;
    ai He = null;
    private boolean Hf;
    private ViewGroup Hg;
    private View Hh;
    private boolean Hi;
    private boolean Hj;
    private boolean Hk;
    private PanelFeatureState[] Hl;
    private PanelFeatureState Hm;
    private boolean Hn;
    private boolean Ho;
    private int Hp;
    private final Runnable Hq = new Runnable(this) {
        final /* synthetic */ AppCompatDelegateImplV7 Ht;

        {
            this.Ht = r1;
        }

        public final void run() {
            if ((this.Ht.Hp & 1) != 0) {
                AppCompatDelegateImplV7.a(this.Ht, 0);
            }
            if ((this.Ht.Hp & Downloads.RECV_BUFFER_SIZE) != 0) {
                AppCompatDelegateImplV7.a(this.Ht, 108);
            }
            this.Ht.Ho = false;
            this.Ht.Hp = 0;
        }
    };
    private boolean Hr;
    private k Hs;
    private Rect hl;
    private Rect hm;

    private static final class PanelFeatureState {
        boolean Ec;
        View HA;
        f HB;
        e HC;
        Context HD;
        boolean HE;
        boolean HF;
        public boolean HG;
        boolean HH = false;
        boolean HI;
        Bundle HJ;
        int Hx;
        ViewGroup Hy;
        View Hz;
        int background;
        int gravity;
        int windowAnimations;
        int x;
        int y;

        private static class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c<SavedState>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SavedState[i];
                }
            });
            boolean Ec;
            int Hx;
            Bundle ja;

            private SavedState() {
            }

            static /* synthetic */ SavedState a(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.Hx = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.Ec = z;
                if (savedState.Ec) {
                    savedState.ja = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.Hx);
                parcel.writeInt(this.Ec ? 1 : 0);
                if (this.Ec) {
                    parcel.writeBundle(this.ja);
                }
            }
        }

        PanelFeatureState(int i) {
            this.Hx = i;
        }

        final void e(f fVar) {
            if (fVar != this.HB) {
                if (this.HB != null) {
                    this.HB.b(this.HC);
                }
                this.HB = fVar;
                if (fVar != null && this.HC != null) {
                    fVar.a(this.HC);
                }
            }
        }
    }

    private final class a implements android.support.v7.view.menu.l.a {
        final /* synthetic */ AppCompatDelegateImplV7 Ht;

        private a(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.Ht = appCompatDelegateImplV7;
        }

        public final boolean d(f fVar) {
            Callback callback = this.Ht.Ft.getCallback();
            if (callback != null) {
                callback.onMenuOpened(108, fVar);
            }
            return true;
        }

        public final void a(f fVar, boolean z) {
            this.Ht.c(fVar);
        }
    }

    class b implements android.support.v7.view.b.a {
        final /* synthetic */ AppCompatDelegateImplV7 Ht;
        private android.support.v7.view.b.a Hv;

        public b(AppCompatDelegateImplV7 appCompatDelegateImplV7, android.support.v7.view.b.a aVar) {
            this.Ht = appCompatDelegateImplV7;
            this.Hv = aVar;
        }

        public final boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.Hv.a(bVar, menu);
        }

        public final boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.Hv.b(bVar, menu);
        }

        public final boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.Hv.a(bVar, menuItem);
        }

        public final void a(android.support.v7.view.b bVar) {
            this.Hv.a(bVar);
            if (this.Ht.Hc != null) {
                this.Ht.Ft.getDecorView().removeCallbacks(this.Ht.Hd);
            }
            if (this.Ht.Hb != null) {
                this.Ht.cY();
                this.Ht.He = z.U(this.Ht.Hb).q(0.0f);
                this.Ht.He.a(new an(this) {
                    final /* synthetic */ b Hw;

                    {
                        this.Hw = r1;
                    }

                    public final void q(View view) {
                        this.Hw.Ht.Hb.setVisibility(8);
                        if (this.Hw.Ht.Hc != null) {
                            this.Hw.Ht.Hc.dismiss();
                        } else if (this.Hw.Ht.Hb.getParent() instanceof View) {
                            z.Y((View) this.Hw.Ht.Hb.getParent());
                        }
                        this.Hw.Ht.Hb.removeAllViews();
                        this.Hw.Ht.He.a(null);
                        this.Hw.Ht.He = null;
                    }
                });
            }
            if (this.Ht.GI != null) {
                this.Ht.GI.onSupportActionModeFinished(this.Ht.Ha);
            }
            this.Ht.Ha = null;
        }
    }

    private class c extends ContentFrameLayout {
        final /* synthetic */ AppCompatDelegateImplV7 Ht;

        public c(AppCompatDelegateImplV7 appCompatDelegateImplV7, Context context) {
            this.Ht = appCompatDelegateImplV7;
            super(context);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.Ht.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                boolean z = x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5;
                if (z) {
                    this.Ht.a(this.Ht.aD(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(h.ey().a(getContext(), i, false));
        }
    }

    private final class d implements android.support.v7.view.menu.l.a {
        final /* synthetic */ AppCompatDelegateImplV7 Ht;

        private d(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.Ht = appCompatDelegateImplV7;
        }

        public final void a(f fVar, boolean z) {
            Menu menu;
            f dD = fVar.dD();
            boolean z2 = dD != fVar;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.Ht;
            if (z2) {
                menu = dD;
            }
            PanelFeatureState a = appCompatDelegateImplV7.a(menu);
            if (a == null) {
                return;
            }
            if (z2) {
                this.Ht.a(a.Hx, a, (Menu) dD);
                this.Ht.a(a, true);
                return;
            }
            this.Ht.a(a, z);
        }

        public final boolean d(f fVar) {
            if (fVar == null && this.Ht.GJ) {
                Callback callback = this.Ht.Ft.getCallback();
                if (!(callback == null || this.Ht.GO)) {
                    callback.onMenuOpened(108, fVar);
                }
            }
            return true;
        }
    }

    static /* synthetic */ void a(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        PanelFeatureState aD = appCompatDelegateImplV7.aD(i);
        if (aD.HB != null) {
            Bundle bundle = new Bundle();
            aD.HB.c(bundle);
            if (bundle.size() > 0) {
                aD.HJ = bundle;
            }
            aD.HB.dw();
            aD.HB.clear();
        }
        aD.HI = true;
        aD.HH = true;
        if ((i == 108 || i == 0) && appCompatDelegateImplV7.GX != null) {
            aD = appCompatDelegateImplV7.aD(0);
            if (aD != null) {
                aD.HE = false;
                appCompatDelegateImplV7.b(aD, null);
            }
        }
    }

    static /* synthetic */ int b(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (appCompatDelegateImplV7.Hb == null || !(appCompatDelegateImplV7.Hb.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) appCompatDelegateImplV7.Hb.getLayoutParams();
            if (appCompatDelegateImplV7.Hb.isShown()) {
                if (appCompatDelegateImplV7.hl == null) {
                    appCompatDelegateImplV7.hl = new Rect();
                    appCompatDelegateImplV7.hm = new Rect();
                }
                Rect rect = appCompatDelegateImplV7.hl;
                Rect rect2 = appCompatDelegateImplV7.hm;
                rect.set(0, i, 0, 0);
                at.a(appCompatDelegateImplV7.Hg, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (appCompatDelegateImplV7.Hh == null) {
                        appCompatDelegateImplV7.Hh = new View(appCompatDelegateImplV7.mContext);
                        appCompatDelegateImplV7.Hh.setBackgroundColor(appCompatDelegateImplV7.mContext.getResources().getColor(android.support.v7.a.a.c.abc_input_method_navigation_guard));
                        appCompatDelegateImplV7.Hg.addView(appCompatDelegateImplV7.Hh, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = appCompatDelegateImplV7.Hh.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            appCompatDelegateImplV7.Hh.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (appCompatDelegateImplV7.Hh == null) {
                    i3 = 0;
                }
                if (!(appCompatDelegateImplV7.GL || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                appCompatDelegateImplV7.Hb.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (appCompatDelegateImplV7.Hh != null) {
            View view = appCompatDelegateImplV7.Hh;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    static /* synthetic */ void d(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        if (appCompatDelegateImplV7.GX != null) {
            appCompatDelegateImplV7.GX.dX();
        }
        if (appCompatDelegateImplV7.Hc != null) {
            appCompatDelegateImplV7.Ft.getDecorView().removeCallbacks(appCompatDelegateImplV7.Hd);
            if (appCompatDelegateImplV7.Hc.isShowing()) {
                try {
                    appCompatDelegateImplV7.Hc.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            appCompatDelegateImplV7.Hc = null;
        }
        appCompatDelegateImplV7.cY();
        PanelFeatureState aD = appCompatDelegateImplV7.aD(0);
        if (aD != null && aD.HB != null) {
            aD.HB.close();
        }
    }

    AppCompatDelegateImplV7(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    public void onCreate(Bundle bundle) {
        if ((this.GG instanceof Activity) && v.b((Activity) this.GG) != null) {
            ActionBar actionBar = this.mActionBar;
            if (actionBar == null) {
                this.Hr = true;
            } else {
                actionBar.v(true);
            }
        }
    }

    public final void cR() {
        cX();
    }

    public final void cV() {
        cX();
        if (this.GJ && this.mActionBar == null) {
            if (this.GG instanceof Activity) {
                this.mActionBar = new o((Activity) this.GG, this.GK);
            } else if (this.GG instanceof Dialog) {
                this.mActionBar = new o((Dialog) this.GG);
            }
            if (this.mActionBar != null) {
                this.mActionBar.v(this.Hr);
            }
        }
    }

    public final void setSupportActionBar(Toolbar toolbar) {
        if (this.GG instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof o) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.iY = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                ActionBar lVar = new l(toolbar, ((Activity) this.mContext).getTitle(), this.GH);
                this.mActionBar = lVar;
                this.Ft.setCallback(lVar.HV);
            } else {
                this.mActionBar = null;
                this.Ft.setCallback(this.GH);
            }
            invalidateOptionsMenu();
        }
    }

    public final View findViewById(int i) {
        cX();
        return this.Ft.findViewById(i);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.GJ && this.Hf) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.onConfigurationChanged(configuration);
            }
        }
        cT();
    }

    public final void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.w(false);
        }
    }

    public final void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.w(true);
        }
    }

    public final void setContentView(View view) {
        cX();
        ViewGroup viewGroup = (ViewGroup) this.Hg.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.GG.onContentChanged();
    }

    public final void setContentView(int i) {
        cX();
        ViewGroup viewGroup = (ViewGroup) this.Hg.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.GG.onContentChanged();
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        cX();
        ViewGroup viewGroup = (ViewGroup) this.Hg.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.GG.onContentChanged();
    }

    public final void addContentView(View view, LayoutParams layoutParams) {
        cX();
        ((ViewGroup) this.Hg.findViewById(16908290)).addView(view, layoutParams);
        this.GG.onContentChanged();
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.mActionBar != null) {
            this.mActionBar.onDestroy();
        }
    }

    private void cX() {
        if (!this.Hf) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(android.support.v7.a.a.k.AppCompatTheme);
            if (obtainStyledAttributes.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowActionBar)) {
                View view;
                View view2;
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowNoTitle, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowActionBar, false)) {
                    requestWindowFeature(108);
                }
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowActionBarOverlay, false)) {
                    requestWindowFeature(109);
                }
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowActionModeOverlay, false)) {
                    requestWindowFeature(10);
                }
                this.GM = obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                this.Ft.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.mContext);
                if (this.GN) {
                    view = this.GL ? (ViewGroup) from.inflate(android.support.v7.a.a.h.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(android.support.v7.a.a.h.abc_screen_simple, null);
                    if (VERSION.SDK_INT >= 21) {
                        z.b(view, new android.support.v4.view.t(this) {
                            final /* synthetic */ AppCompatDelegateImplV7 Ht;

                            {
                                this.Ht = r1;
                            }

                            public final ap a(View view, ap apVar) {
                                int systemWindowInsetTop = apVar.getSystemWindowInsetTop();
                                int b = AppCompatDelegateImplV7.b(this.Ht, systemWindowInsetTop);
                                if (systemWindowInsetTop != b) {
                                    apVar = apVar.e(apVar.getSystemWindowInsetLeft(), b, apVar.getSystemWindowInsetRight(), apVar.getSystemWindowInsetBottom());
                                }
                                return z.a(view, apVar);
                            }
                        });
                        view2 = view;
                    } else {
                        ((x) view).a(new android.support.v7.widget.x.a(this) {
                            final /* synthetic */ AppCompatDelegateImplV7 Ht;

                            {
                                this.Ht = r1;
                            }

                            public final void d(Rect rect) {
                                rect.top = AppCompatDelegateImplV7.b(this.Ht, rect.top);
                            }
                        });
                        view2 = view;
                    }
                } else if (this.GM) {
                    r0 = (ViewGroup) from.inflate(android.support.v7.a.a.h.abc_dialog_title_material, null);
                    this.GK = false;
                    this.GJ = false;
                    view2 = r0;
                } else if (this.GJ) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                    r0 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.d(this.mContext, typedValue.resourceId) : this.mContext).inflate(android.support.v7.a.a.h.abc_screen_toolbar, null);
                    this.GX = (t) r0.findViewById(android.support.v7.a.a.f.decor_content_parent);
                    this.GX.b(this.Ft.getCallback());
                    if (this.GK) {
                        this.GX.aH(109);
                    }
                    if (this.Hi) {
                        this.GX.aH(2);
                    }
                    if (this.Hj) {
                        this.GX.aH(5);
                    }
                    view2 = r0;
                } else {
                    view2 = null;
                }
                if (view2 == null) {
                    throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.GJ + ", windowActionBarOverlay: " + this.GK + ", android:windowIsFloating: " + this.GM + ", windowActionModeOverlay: " + this.GL + ", windowNoTitle: " + this.GN + " }");
                }
                if (this.GX == null) {
                    this.FN = (TextView) view2.findViewById(android.support.v7.a.a.f.title);
                }
                at.bw(view2);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view2.findViewById(android.support.v7.a.a.f.action_bar_activity_content);
                ViewGroup viewGroup = (ViewGroup) this.Ft.findViewById(16908290);
                if (viewGroup != null) {
                    while (viewGroup.getChildCount() > 0) {
                        View childAt = viewGroup.getChildAt(0);
                        viewGroup.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup instanceof FrameLayout) {
                        ((FrameLayout) viewGroup).setForeground(null);
                    }
                }
                this.Ft.setContentView(view2);
                contentFrameLayout.QN = new android.support.v7.widget.ContentFrameLayout.a(this) {
                    final /* synthetic */ AppCompatDelegateImplV7 Ht;

                    {
                        this.Ht = r1;
                    }

                    public final void onDetachedFromWindow() {
                        AppCompatDelegateImplV7.d(this.Ht);
                    }
                };
                this.Hg = view2;
                CharSequence title = this.GG instanceof Activity ? ((Activity) this.GG).getTitle() : this.uU;
                if (!TextUtils.isEmpty(title)) {
                    f(title);
                }
                contentFrameLayout = (ContentFrameLayout) this.Hg.findViewById(16908290);
                view = this.Ft.getDecorView();
                contentFrameLayout.QM.set(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                if (z.ai(contentFrameLayout)) {
                    contentFrameLayout.requestLayout();
                }
                TypedArray obtainStyledAttributes2 = this.mContext.obtainStyledAttributes(android.support.v7.a.a.k.AppCompatTheme);
                int i = android.support.v7.a.a.k.AppCompatTheme_windowMinWidthMajor;
                if (contentFrameLayout.QG == null) {
                    contentFrameLayout.QG = new TypedValue();
                }
                obtainStyledAttributes2.getValue(i, contentFrameLayout.QG);
                i = android.support.v7.a.a.k.AppCompatTheme_windowMinWidthMinor;
                if (contentFrameLayout.QH == null) {
                    contentFrameLayout.QH = new TypedValue();
                }
                obtainStyledAttributes2.getValue(i, contentFrameLayout.QH);
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMajor)) {
                    i = android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMajor;
                    if (contentFrameLayout.QI == null) {
                        contentFrameLayout.QI = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.QI);
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMinor)) {
                    i = android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMinor;
                    if (contentFrameLayout.QJ == null) {
                        contentFrameLayout.QJ = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.QJ);
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMajor)) {
                    i = android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMajor;
                    if (contentFrameLayout.QK == null) {
                        contentFrameLayout.QK = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.QK);
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMinor)) {
                    i = android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMinor;
                    if (contentFrameLayout.QL == null) {
                        contentFrameLayout.QL = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.QL);
                }
                obtainStyledAttributes2.recycle();
                contentFrameLayout.requestLayout();
                this.Hf = true;
                PanelFeatureState aD = aD(0);
                if (!this.GO) {
                    if (aD == null || aD.HB == null) {
                        invalidatePanelMenu(108);
                        return;
                    }
                    return;
                }
                return;
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final boolean requestWindowFeature(int i) {
        if (i == 8) {
            i = 108;
        } else if (i == 9) {
            i = 109;
        }
        if (this.GN && i == 108) {
            return false;
        }
        if (this.GJ && i == 1) {
            this.GJ = false;
        }
        switch (i) {
            case 1:
                cZ();
                this.GN = true;
                return true;
            case 2:
                cZ();
                this.Hi = true;
                return true;
            case 5:
                cZ();
                this.Hj = true;
                return true;
            case 10:
                cZ();
                this.GL = true;
                return true;
            case 108:
                cZ();
                this.GJ = true;
                return true;
            case 109:
                cZ();
                this.GK = true;
                return true;
            default:
                return this.Ft.requestFeature(i);
        }
    }

    final void f(CharSequence charSequence) {
        if (this.GX != null) {
            this.GX.e(charSequence);
        } else if (this.mActionBar != null) {
            this.mActionBar.e(charSequence);
        } else if (this.FN != null) {
            this.FN.setText(charSequence);
        }
    }

    final void aA(int i) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.x(false);
            }
        } else if (i == 0) {
            PanelFeatureState aD = aD(i);
            if (aD.Ec) {
                a(aD, false);
            }
        }
    }

    final boolean aB(int i) {
        if (i != 108) {
            return false;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return true;
        }
        supportActionBar.x(true);
        return true;
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        Callback callback = this.Ft.getCallback();
        if (!(callback == null || this.GO)) {
            PanelFeatureState a = a(fVar.dD());
            if (a != null) {
                return callback.onMenuItemSelected(a.Hx, menuItem);
            }
        }
        return false;
    }

    public final void b(f fVar) {
        if (this.GX == null || !this.GX.dU() || (ae.b(ViewConfiguration.get(this.mContext)) && !this.GX.dV())) {
            PanelFeatureState aD = aD(0);
            aD.HH = true;
            a(aD, false);
            a(aD, null);
            return;
        }
        Callback callback = this.Ft.getCallback();
        if (this.GX.isOverflowMenuShowing()) {
            this.GX.hideOverflowMenu();
            if (!this.GO) {
                callback.onPanelClosed(108, aD(0).HB);
            }
        } else if (callback != null && !this.GO) {
            if (this.Ho && (this.Hp & 1) != 0) {
                this.Ft.getDecorView().removeCallbacks(this.Hq);
                this.Hq.run();
            }
            PanelFeatureState aD2 = aD(0);
            if (aD2.HB != null && !aD2.HI && callback.onPreparePanel(0, aD2.HA, aD2.HB)) {
                callback.onMenuOpened(108, aD2.HB);
                this.GX.showOverflowMenu();
            }
        }
    }

    public final android.support.v7.view.b startSupportActionMode(android.support.v7.view.b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.Ha != null) {
            this.Ha.finish();
        }
        android.support.v7.view.b.a bVar = new b(this, aVar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.Ha = supportActionBar.a(bVar);
            if (!(this.Ha == null || this.GI == null)) {
                this.GI.onSupportActionModeStarted(this.Ha);
            }
        }
        if (this.Ha == null) {
            this.Ha = b(bVar);
        }
        return this.Ha;
    }

    public final void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.cQ()) {
            invalidatePanelMenu(0);
        }
    }

    final android.support.v7.view.b b(android.support.v7.view.b.a aVar) {
        android.support.v7.view.b onWindowStartingSupportActionMode;
        ViewStubCompat viewStubCompat;
        TypedValue typedValue;
        Theme theme;
        Context dVar;
        boolean z;
        android.support.v7.view.b eVar;
        cY();
        if (this.Ha != null) {
            this.Ha.finish();
        }
        android.support.v7.view.b.a bVar = new b(this, aVar);
        if (!(this.GI == null || this.GO)) {
            try {
                onWindowStartingSupportActionMode = this.GI.onWindowStartingSupportActionMode(bVar);
            } catch (AbstractMethodError e) {
            }
            if (onWindowStartingSupportActionMode == null) {
                this.Ha = onWindowStartingSupportActionMode;
            } else {
                if (this.Hb == null) {
                    if (this.GM) {
                        viewStubCompat = (ViewStubCompat) this.Hg.findViewById(android.support.v7.a.a.f.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.DF = LayoutInflater.from(cW());
                            this.Hb = (ActionBarContextView) viewStubCompat.inflate();
                        }
                    } else {
                        typedValue = new TypedValue();
                        theme = this.mContext.getTheme();
                        theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId == 0) {
                            Theme newTheme = this.mContext.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            dVar = new android.support.v7.view.d(this.mContext, 0);
                            dVar.getTheme().setTo(newTheme);
                        } else {
                            dVar = this.mContext;
                        }
                        this.Hb = new ActionBarContextView(dVar);
                        this.Hc = new PopupWindow(dVar, null, android.support.v7.a.a.a.actionModePopupWindowStyle);
                        m.a(this.Hc, 2);
                        this.Hc.setContentView(this.Hb);
                        this.Hc.setWidth(-1);
                        dVar.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarSize, typedValue, true);
                        this.Hb.aF(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                        this.Hc.setHeight(-2);
                        this.Hd = new Runnable(this) {
                            final /* synthetic */ AppCompatDelegateImplV7 Ht;

                            {
                                this.Ht = r1;
                            }

                            public final void run() {
                                this.Ht.Hc.showAtLocation(this.Ht.Hb, 55, 0, 0);
                                this.Ht.cY();
                                z.d(this.Ht.Hb, 0.0f);
                                this.Ht.He = z.U(this.Ht.Hb).q(1.0f);
                                this.Ht.He.a(new an(this) {
                                    final /* synthetic */ AnonymousClass5 Hu;

                                    {
                                        this.Hu = r1;
                                    }

                                    public final void q(View view) {
                                        z.d(this.Hu.Ht.Hb, 1.0f);
                                        this.Hu.Ht.He.a(null);
                                        this.Hu.Ht.He = null;
                                    }

                                    public final void p(View view) {
                                        this.Hu.Ht.Hb.setVisibility(0);
                                    }
                                });
                            }
                        };
                    }
                }
                if (this.Hb != null) {
                    cY();
                    this.Hb.dP();
                    Context context = this.Hb.getContext();
                    ActionBarContextView actionBarContextView = this.Hb;
                    if (this.Hc != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    eVar = new android.support.v7.view.e(context, actionBarContextView, bVar, z);
                    if (aVar.a(eVar, eVar.getMenu())) {
                        this.Ha = null;
                    } else {
                        eVar.invalidate();
                        this.Hb.c(eVar);
                        this.Ha = eVar;
                        z.d(this.Hb, 0.0f);
                        this.He = z.U(this.Hb).q(1.0f);
                        this.He.a(new an(this) {
                            final /* synthetic */ AppCompatDelegateImplV7 Ht;

                            {
                                this.Ht = r1;
                            }

                            public final void q(View view) {
                                z.d(this.Ht.Hb, 1.0f);
                                this.Ht.He.a(null);
                                this.Ht.He = null;
                            }

                            public final void p(View view) {
                                this.Ht.Hb.setVisibility(0);
                                this.Ht.Hb.sendAccessibilityEvent(32);
                                if (this.Ht.Hb.getParent() != null) {
                                    z.Y((View) this.Ht.Hb.getParent());
                                }
                            }
                        });
                        if (this.Hc != null) {
                            this.Ft.getDecorView().post(this.Hd);
                        }
                    }
                }
            }
            if (!(this.Ha == null || this.GI == null)) {
                this.GI.onSupportActionModeStarted(this.Ha);
            }
            return this.Ha;
        }
        onWindowStartingSupportActionMode = null;
        if (onWindowStartingSupportActionMode == null) {
            if (this.Hb == null) {
                if (this.GM) {
                    viewStubCompat = (ViewStubCompat) this.Hg.findViewById(android.support.v7.a.a.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.DF = LayoutInflater.from(cW());
                        this.Hb = (ActionBarContextView) viewStubCompat.inflate();
                    }
                } else {
                    typedValue = new TypedValue();
                    theme = this.mContext.getTheme();
                    theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId == 0) {
                        dVar = this.mContext;
                    } else {
                        Theme newTheme2 = this.mContext.getResources().newTheme();
                        newTheme2.setTo(theme);
                        newTheme2.applyStyle(typedValue.resourceId, true);
                        dVar = new android.support.v7.view.d(this.mContext, 0);
                        dVar.getTheme().setTo(newTheme2);
                    }
                    this.Hb = new ActionBarContextView(dVar);
                    this.Hc = new PopupWindow(dVar, null, android.support.v7.a.a.a.actionModePopupWindowStyle);
                    m.a(this.Hc, 2);
                    this.Hc.setContentView(this.Hb);
                    this.Hc.setWidth(-1);
                    dVar.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarSize, typedValue, true);
                    this.Hb.aF(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.Hc.setHeight(-2);
                    this.Hd = /* anonymous class already generated */;
                }
            }
            if (this.Hb != null) {
                cY();
                this.Hb.dP();
                Context context2 = this.Hb.getContext();
                ActionBarContextView actionBarContextView2 = this.Hb;
                if (this.Hc != null) {
                    z = false;
                } else {
                    z = true;
                }
                eVar = new android.support.v7.view.e(context2, actionBarContextView2, bVar, z);
                if (aVar.a(eVar, eVar.getMenu())) {
                    this.Ha = null;
                } else {
                    eVar.invalidate();
                    this.Hb.c(eVar);
                    this.Ha = eVar;
                    z.d(this.Hb, 0.0f);
                    this.He = z.U(this.Hb).q(1.0f);
                    this.He.a(/* anonymous class already generated */);
                    if (this.Hc != null) {
                        this.Ft.getDecorView().post(this.Hd);
                    }
                }
            }
        } else {
            this.Ha = onWindowStartingSupportActionMode;
        }
        this.GI.onSupportActionModeStarted(this.Ha);
        return this.Ha;
    }

    private void cY() {
        if (this.He != null) {
            this.He.cancel();
        }
    }

    final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.Hm == null || !a(this.Hm, keyEvent.getKeyCode(), keyEvent)) {
            if (this.Hm == null) {
                PanelFeatureState aD = aD(0);
                b(aD, keyEvent);
                boolean a = a(aD, keyEvent.getKeyCode(), keyEvent);
                aD.HE = false;
                if (a) {
                    return true;
                }
            }
            return false;
        } else if (this.Hm == null) {
            return true;
        } else {
            this.Hm.HF = true;
            return true;
        }
    }

    final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.GG.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        boolean z;
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            switch (keyCode) {
                case 4:
                    this.Hn = (keyEvent.getFlags() & FileUtils.S_IWUSR) != 0;
                    break;
                case 82:
                    if (keyEvent.getRepeatCount() != 0) {
                        return true;
                    }
                    PanelFeatureState aD = aD(0);
                    if (aD.Ec) {
                        return true;
                    }
                    b(aD, keyEvent);
                    return true;
            }
            if (VERSION.SDK_INT < 11) {
                onKeyShortcut(keyCode, keyEvent);
            }
            return false;
        }
        PanelFeatureState aD2;
        switch (keyCode) {
            case 4:
                z = this.Hn;
                this.Hn = false;
                aD2 = aD(0);
                if (aD2 == null || !aD2.Ec) {
                    if (this.Ha != null) {
                        this.Ha.finish();
                        z = true;
                    } else {
                        ActionBar supportActionBar = getSupportActionBar();
                        z = supportActionBar != null && supportActionBar.collapseActionView();
                    }
                    if (z) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    a(aD2, true);
                    return true;
                }
                break;
            case 82:
                if (this.Ha != null) {
                    return true;
                }
                aD2 = aD(0);
                if (this.GX == null || !this.GX.dU() || ae.b(ViewConfiguration.get(this.mContext))) {
                    if (aD2.Ec || aD2.HF) {
                        z = aD2.Ec;
                        a(aD2, true);
                    } else {
                        if (aD2.HE) {
                            if (aD2.HI) {
                                aD2.HE = false;
                                z = b(aD2, keyEvent);
                            } else {
                                z = true;
                            }
                            if (z) {
                                a(aD2, keyEvent);
                                z = true;
                            }
                        }
                        z = false;
                    }
                } else if (this.GX.isOverflowMenuShowing()) {
                    z = this.GX.hideOverflowMenu();
                } else {
                    if (!this.GO && b(aD2, keyEvent)) {
                        z = this.GX.showOverflowMenu();
                    }
                    z = false;
                }
                if (!z) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (audioManager == null) {
                    return true;
                }
                audioManager.playSoundEffect(0);
                return true;
        }
        return false;
    }

    public final void cS() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            android.support.v4.view.h.a(from, this);
        } else {
            android.support.v4.view.h.a(from);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = false;
        View a = a(str, context, attributeSet);
        if (a == null) {
            boolean z2;
            k kVar;
            boolean hc;
            Context context2;
            View view2;
            boolean z3 = VERSION.SDK_INT < 21;
            if (this.Hs == null) {
                this.Hs = new k();
            }
            if (z3) {
                ViewParent viewParent = (ViewParent) view;
                if (viewParent == null) {
                    z2 = false;
                } else {
                    ViewParent decorView = this.Ft.getDecorView();
                    ViewParent viewParent2 = viewParent;
                    while (viewParent2 != null) {
                        if (viewParent2 == decorView || !(viewParent2 instanceof View) || z.ak((View) viewParent2)) {
                            z2 = false;
                            break;
                        }
                        viewParent2 = viewParent2.getParent();
                    }
                    z2 = true;
                }
                if (z2) {
                    z2 = true;
                    kVar = this.Hs;
                    hc = ar.hc();
                    context2 = (z2 || view == null) ? context : view.getContext();
                    context2 = k.a(context2, attributeSet, z3, true);
                    if (hc) {
                        context2 = am.r(context2);
                    }
                    view2 = null;
                    switch (str.hashCode()) {
                        case -1946472170:
                            if (str.equals("RatingBar")) {
                                z = true;
                                break;
                            }
                        case -1455429095:
                            if (str.equals("CheckedTextView")) {
                                z = true;
                                break;
                            }
                        case -1346021293:
                            if (str.equals("MultiAutoCompleteTextView")) {
                                z = true;
                                break;
                            }
                        case -938935918:
                            if (str.equals("TextView")) {
                                break;
                            }
                        case -937446323:
                            if (str.equals("ImageButton")) {
                                z = true;
                                break;
                            }
                        case -658531749:
                            if (str.equals("SeekBar")) {
                                z = true;
                                break;
                            }
                        case -339785223:
                            if (str.equals("Spinner")) {
                                z = true;
                                break;
                            }
                        case 776382189:
                            if (str.equals("RadioButton")) {
                                z = true;
                                break;
                            }
                        case 1125864064:
                            if (str.equals("ImageView")) {
                                z = true;
                                break;
                            }
                        case 1413872058:
                            if (str.equals("AutoCompleteTextView")) {
                                z = true;
                                break;
                            }
                        case 1601505219:
                            if (str.equals("CheckBox")) {
                                z = true;
                                break;
                            }
                        case 1666676343:
                            if (str.equals("EditText")) {
                                z = true;
                                break;
                            }
                        case 2001146706:
                            if (str.equals("Button")) {
                                z = true;
                                break;
                            }
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            view2 = new AppCompatTextView(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatImageView(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatButton(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatEditText(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatSpinner(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatImageButton(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatCheckBox(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatRadioButton(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatCheckedTextView(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatAutoCompleteTextView(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatMultiAutoCompleteTextView(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatRatingBar(context2, attributeSet);
                            break;
                        case true:
                            view2 = new AppCompatSeekBar(context2, attributeSet);
                            break;
                    }
                    a = (view2 == null || context == context2) ? view2 : kVar.a(context2, str, attributeSet);
                    if (a != null) {
                        k.a(a, attributeSet);
                    }
                }
            }
            z2 = false;
            kVar = this.Hs;
            hc = ar.hc();
            if (z2) {
            }
            context2 = k.a(context2, attributeSet, z3, true);
            if (hc) {
                context2 = am.r(context2);
            }
            view2 = null;
            switch (str.hashCode()) {
                case -1946472170:
                    if (str.equals("RatingBar")) {
                        z = true;
                        break;
                    }
                case -1455429095:
                    if (str.equals("CheckedTextView")) {
                        z = true;
                        break;
                    }
                case -1346021293:
                    if (str.equals("MultiAutoCompleteTextView")) {
                        z = true;
                        break;
                    }
                case -938935918:
                    if (str.equals("TextView")) {
                        break;
                    }
                case -937446323:
                    if (str.equals("ImageButton")) {
                        z = true;
                        break;
                    }
                case -658531749:
                    if (str.equals("SeekBar")) {
                        z = true;
                        break;
                    }
                case -339785223:
                    if (str.equals("Spinner")) {
                        z = true;
                        break;
                    }
                case 776382189:
                    if (str.equals("RadioButton")) {
                        z = true;
                        break;
                    }
                case 1125864064:
                    if (str.equals("ImageView")) {
                        z = true;
                        break;
                    }
                case 1413872058:
                    if (str.equals("AutoCompleteTextView")) {
                        z = true;
                        break;
                    }
                case 1601505219:
                    if (str.equals("CheckBox")) {
                        z = true;
                        break;
                    }
                case 1666676343:
                    if (str.equals("EditText")) {
                        z = true;
                        break;
                    }
                case 2001146706:
                    if (str.equals("Button")) {
                        z = true;
                        break;
                    }
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    view2 = new AppCompatTextView(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatImageView(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatButton(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatEditText(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatSpinner(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatImageButton(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatCheckBox(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatRadioButton(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatCheckedTextView(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatAutoCompleteTextView(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatMultiAutoCompleteTextView(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatRatingBar(context2, attributeSet);
                    break;
                case true:
                    view2 = new AppCompatSeekBar(context2, attributeSet);
                    break;
            }
            if (view2 == null) {
            }
            if (a != null) {
                k.a(a, attributeSet);
            }
        }
        return a;
    }

    View a(String str, Context context, AttributeSet attributeSet) {
        if (this.GG instanceof Factory) {
            View onCreateView = ((Factory) this.GG).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i = -1;
        if (!panelFeatureState.Ec && !this.GO) {
            boolean z;
            if (panelFeatureState.Hx == 0) {
                Context context = this.mContext;
                z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean z2;
                if (context.getApplicationInfo().targetSdkVersion >= 11) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z && r4) {
                    return;
                }
            }
            Callback callback = this.Ft.getCallback();
            if (callback == null || callback.onMenuOpened(panelFeatureState.Hx, panelFeatureState.HB)) {
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null && b(panelFeatureState, keyEvent)) {
                    LayoutParams layoutParams;
                    if (panelFeatureState.Hy == null || panelFeatureState.HH) {
                        if (panelFeatureState.Hy == null) {
                            Context cW = cW();
                            TypedValue typedValue = new TypedValue();
                            Theme newTheme = cW.getResources().newTheme();
                            newTheme.setTo(cW.getTheme());
                            newTheme.resolveAttribute(android.support.v7.a.a.a.actionBarPopupTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                newTheme.applyStyle(typedValue.resourceId, true);
                            }
                            newTheme.resolveAttribute(android.support.v7.a.a.a.panelMenuListTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                newTheme.applyStyle(typedValue.resourceId, true);
                            } else {
                                newTheme.applyStyle(j.Theme_AppCompat_CompactMenu, true);
                            }
                            Context dVar = new android.support.v7.view.d(cW, 0);
                            dVar.getTheme().setTo(newTheme);
                            panelFeatureState.HD = dVar;
                            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(android.support.v7.a.a.k.AppCompatTheme);
                            panelFeatureState.background = obtainStyledAttributes.getResourceId(android.support.v7.a.a.k.AppCompatTheme_panelBackground, 0);
                            panelFeatureState.windowAnimations = obtainStyledAttributes.getResourceId(android.support.v7.a.a.k.AppCompatTheme_android_windowAnimationStyle, 0);
                            obtainStyledAttributes.recycle();
                            panelFeatureState.Hy = new c(this, panelFeatureState.HD);
                            panelFeatureState.gravity = 81;
                            if (panelFeatureState.Hy == null) {
                                return;
                            }
                        } else if (panelFeatureState.HH && panelFeatureState.Hy.getChildCount() > 0) {
                            panelFeatureState.Hy.removeAllViews();
                        }
                        if (panelFeatureState.HA != null) {
                            panelFeatureState.Hz = panelFeatureState.HA;
                            z = true;
                        } else {
                            if (panelFeatureState.HB != null) {
                                android.support.v7.view.menu.m mVar;
                                if (this.GZ == null) {
                                    this.GZ = new d();
                                }
                                android.support.v7.view.menu.l.a aVar = this.GZ;
                                if (panelFeatureState.HB == null) {
                                    mVar = null;
                                } else {
                                    if (panelFeatureState.HC == null) {
                                        panelFeatureState.HC = new e(panelFeatureState.HD, android.support.v7.a.a.h.abc_list_menu_item_layout);
                                        panelFeatureState.HC.ef = aVar;
                                        panelFeatureState.HB.a(panelFeatureState.HC);
                                    }
                                    mVar = panelFeatureState.HC.c(panelFeatureState.Hy);
                                }
                                panelFeatureState.Hz = (View) mVar;
                                if (panelFeatureState.Hz != null) {
                                    z = true;
                                }
                            }
                            z = false;
                        }
                        if (z) {
                            LayoutParams layoutParams2;
                            ViewParent parent;
                            if (panelFeatureState.Hz != null) {
                                if (panelFeatureState.HA != null) {
                                    z = true;
                                } else if (panelFeatureState.HC.getAdapter().getCount() > 0) {
                                    z = true;
                                }
                                if (z) {
                                    layoutParams = panelFeatureState.Hz.getLayoutParams();
                                    if (layoutParams != null) {
                                        layoutParams2 = new LayoutParams(-2, -2);
                                    } else {
                                        layoutParams2 = layoutParams;
                                    }
                                    panelFeatureState.Hy.setBackgroundResource(panelFeatureState.background);
                                    parent = panelFeatureState.Hz.getParent();
                                    if (parent != null && (parent instanceof ViewGroup)) {
                                        ((ViewGroup) parent).removeView(panelFeatureState.Hz);
                                    }
                                    panelFeatureState.Hy.addView(panelFeatureState.Hz, layoutParams2);
                                    if (!panelFeatureState.Hz.hasFocus()) {
                                        panelFeatureState.Hz.requestFocus();
                                    }
                                    i = -2;
                                } else {
                                    return;
                                }
                            }
                            z = false;
                            if (z) {
                                layoutParams = panelFeatureState.Hz.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams2 = layoutParams;
                                } else {
                                    layoutParams2 = new LayoutParams(-2, -2);
                                }
                                panelFeatureState.Hy.setBackgroundResource(panelFeatureState.background);
                                parent = panelFeatureState.Hz.getParent();
                                ((ViewGroup) parent).removeView(panelFeatureState.Hz);
                                panelFeatureState.Hy.addView(panelFeatureState.Hz, layoutParams2);
                                if (panelFeatureState.Hz.hasFocus()) {
                                    panelFeatureState.Hz.requestFocus();
                                }
                                i = -2;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (panelFeatureState.HA != null) {
                        layoutParams = panelFeatureState.HA.getLayoutParams();
                        if (layoutParams != null) {
                        }
                    }
                    i = -2;
                    panelFeatureState.HF = false;
                    layoutParams = new WindowManager.LayoutParams(i, -2, panelFeatureState.x, panelFeatureState.y, 1002, 8519680, -3);
                    layoutParams.gravity = panelFeatureState.gravity;
                    layoutParams.windowAnimations = panelFeatureState.windowAnimations;
                    windowManager.addView(panelFeatureState.Hy, layoutParams);
                    panelFeatureState.Ec = true;
                    return;
                }
                return;
            }
            a(panelFeatureState, true);
        }
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.GO) {
            return false;
        }
        if (panelFeatureState.HE) {
            return true;
        }
        if (!(this.Hm == null || this.Hm == panelFeatureState)) {
            a(this.Hm, false);
        }
        Callback callback = this.Ft.getCallback();
        if (callback != null) {
            panelFeatureState.HA = callback.onCreatePanelView(panelFeatureState.Hx);
        }
        boolean z = panelFeatureState.Hx == 0 || panelFeatureState.Hx == 108;
        if (z && this.GX != null) {
            this.GX.dW();
        }
        if (panelFeatureState.HA == null && !(z && (this.mActionBar instanceof l))) {
            if (panelFeatureState.HB == null || panelFeatureState.HI) {
                if (panelFeatureState.HB == null) {
                    Context dVar;
                    f fVar;
                    Context context = this.mContext;
                    if ((panelFeatureState.Hx == 0 || panelFeatureState.Hx == 108) && this.GX != null) {
                        Theme newTheme;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = context.getTheme();
                        theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            newTheme = context.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            newTheme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
                            newTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (newTheme == null) {
                                newTheme = context.getResources().newTheme();
                                newTheme.setTo(theme);
                            }
                            newTheme.applyStyle(typedValue.resourceId, true);
                        }
                        Theme theme2 = newTheme;
                        if (theme2 != null) {
                            dVar = new android.support.v7.view.d(context, 0);
                            dVar.getTheme().setTo(theme2);
                            fVar = new f(dVar);
                            fVar.a((android.support.v7.view.menu.f.a) this);
                            panelFeatureState.e(fVar);
                            if (panelFeatureState.HB == null) {
                                return false;
                            }
                        }
                    }
                    dVar = context;
                    fVar = new f(dVar);
                    fVar.a((android.support.v7.view.menu.f.a) this);
                    panelFeatureState.e(fVar);
                    if (panelFeatureState.HB == null) {
                        return false;
                    }
                }
                if (z && this.GX != null) {
                    if (this.GY == null) {
                        this.GY = new a();
                    }
                    this.GX.a(panelFeatureState.HB, this.GY);
                }
                panelFeatureState.HB.dw();
                if (callback.onCreatePanelMenu(panelFeatureState.Hx, panelFeatureState.HB)) {
                    panelFeatureState.HI = false;
                } else {
                    panelFeatureState.e(null);
                    if (!z || this.GX == null) {
                        return false;
                    }
                    this.GX.a(null, this.GY);
                    return false;
                }
            }
            panelFeatureState.HB.dw();
            if (panelFeatureState.HJ != null) {
                panelFeatureState.HB.d(panelFeatureState.HJ);
                panelFeatureState.HJ = null;
            }
            if (callback.onPreparePanel(0, panelFeatureState.HA, panelFeatureState.HB)) {
                boolean z2;
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                panelFeatureState.HG = z2;
                panelFeatureState.HB.setQwertyMode(panelFeatureState.HG);
                panelFeatureState.HB.dx();
            } else {
                if (z && this.GX != null) {
                    this.GX.a(null, this.GY);
                }
                panelFeatureState.HB.dx();
                return false;
            }
        }
        panelFeatureState.HE = true;
        panelFeatureState.HF = false;
        this.Hm = panelFeatureState;
        return true;
    }

    private void c(f fVar) {
        if (!this.Hk) {
            this.Hk = true;
            this.GX.dX();
            Callback callback = this.Ft.getCallback();
            if (!(callback == null || this.GO)) {
                callback.onPanelClosed(108, fVar);
            }
            this.Hk = false;
        }
    }

    private void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.Hx == 0 && this.GX != null && this.GX.isOverflowMenuShowing()) {
            c(panelFeatureState.HB);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.Ec || panelFeatureState.Hy == null)) {
            windowManager.removeView(panelFeatureState.Hy);
            if (z) {
                a(panelFeatureState.Hx, panelFeatureState, null);
            }
        }
        panelFeatureState.HE = false;
        panelFeatureState.HF = false;
        panelFeatureState.Ec = false;
        panelFeatureState.Hz = null;
        panelFeatureState.HH = true;
        if (this.Hm == panelFeatureState) {
            this.Hm = null;
        }
    }

    private void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.Hl.length) {
                panelFeatureState = this.Hl[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.HB;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.Ec) && !this.GO) {
            this.GG.onPanelClosed(i, menu);
        }
    }

    private PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.Hl;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.HB == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    private PanelFeatureState aD(int i) {
        Object obj = this.Hl;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.Hl = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.HE || b(panelFeatureState, keyEvent)) && panelFeatureState.HB != null) {
            return panelFeatureState.HB.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    private void invalidatePanelMenu(int i) {
        this.Hp |= 1 << i;
        if (!this.Ho) {
            z.a(this.Ft.getDecorView(), this.Hq);
            this.Ho = true;
        }
    }

    private void cZ() {
        if (this.Hf) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }
}
