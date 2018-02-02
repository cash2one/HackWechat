package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.p.AnonymousClass2;
import com.tencent.mm.ui.tools.p;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity extends MMFragmentActivity {
    private static String xIs;
    String className;
    public a jwN = null;
    public p mController = new p(this) {
        final /* synthetic */ MMActivity xIw;

        {
            this.xIw = r1;
        }

        protected final int getLayoutId() {
            return this.xIw.getLayoutId();
        }

        protected final void dealContentView(View view) {
            this.xIw.dealContentView(view);
        }

        protected final String getIdentString() {
            return this.xIw.getIdentString();
        }

        protected final View getLayoutView() {
            return MMActivity.getLayoutView();
        }

        public final void onKeyboardStateChanged() {
            this.xIw.onKeyboardStateChanged();
        }

        protected final void onCreateBeforeSetContentView() {
            this.xIw.onCreateBeforeSetContentView();
        }

        protected final String getClassName() {
            return this.xIw.getClass().getName();
        }

        protected final boolean cmP() {
            return this.xIw.cmP();
        }

        public final boolean noActionBar() {
            return this.xIw.noActionBar();
        }

        public final boolean needShowIdcError() {
            return this.xIw.needShowIdcError();
        }
    };
    public boolean xIo = false;
    private ViewGroup xIp = null;
    public boolean xIq = false;
    private View xIr;
    private long xIt = 0;
    private long xIu = 0;
    private long xIv = 0;

    public interface a {
        void b(int i, int i2, Intent intent);
    }

    public abstract int getLayoutId();

    @Deprecated
    public void initView() {
    }

    public final void setBackGroundColorResource(int i) {
        this.mController.setBackGroundColorResource(i);
    }

    public static Locale initLanguage(Context context) {
        return p.initLanguage(context);
    }

    public void onCreateBeforeSetContentView() {
    }

    public boolean cmP() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.a(getBaseContext(), (ActionBarActivity) this);
        x.i("MicroMsg.MMActivity", "checktask onCreate:%s#0x%x, taskid:%d, task:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bh.fb(this));
        initNavigationSwipeBack();
    }

    public void dealContentView(View view) {
        setContentView(view);
    }

    public boolean noActionBar() {
        return false;
    }

    public void onKeyboardStateChanged() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final void setScreenEnable(boolean z) {
        this.mController.setScreenEnable(z);
    }

    public void uD(int i) {
        this.mController.contentView.setVisibility(i);
        if (i == 0) {
            this.mController.showTitleView();
        } else {
            this.mController.hideTitleView();
        }
    }

    public void onSwipeBack() {
        if (!akK()) {
            this.mController.callBackMenu();
        }
        super.onSwipeBack();
    }

    public void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.xIp = new FrameLayout(this);
            this.xIp.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.xIp);
            getSwipeBackLayout().Iv = this.xIp;
        }
    }

    public boolean akK() {
        return false;
    }

    public int getForceOrientation() {
        return -1;
    }

    public void afg() {
        if (getForceOrientation() == -1) {
            this.xIo = getSharedPreferences(ac.cfs(), 0).getBoolean("settings_landscape_mode", false);
            if (this.xIo) {
                setRequestedOrientation(-1);
                return;
            } else {
                setRequestedOrientation(1);
                return;
            }
        }
        setRequestedOrientation(getForceOrientation());
    }

    public void onStart() {
        afg();
        super.onStart();
    }

    @TargetApi(17)
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (!this.mController.onKeyUp(i, keyEvent)) {
            try {
                z = super.onKeyUp(i, keyEvent);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMActivity", e, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
            }
        }
        return z;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mController.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean needShowIdcError() {
        return true;
    }

    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        ad.aT(1, this.className);
        super.onResume();
        x.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.mController.onResume();
        x.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(hashCode()));
        if (this.xIu > this.xIt) {
            this.xIv += this.xIu - this.xIt;
        }
        this.xIt = bh.Wq();
        this.xIu = 0;
    }

    public final void addDialog(Dialog dialog) {
        this.mController.addDialog(dialog);
    }

    public final ActionBarActivity cmQ() {
        return this.mController.xIM;
    }

    public void onDestroy() {
        x.i("MicroMsg.MMActivity", "checktask onDestroy:%s#0x%x task:%s ", getClass().getSimpleName(), Integer.valueOf(hashCode()), bh.fb(this));
        super.onDestroy();
        com.tencent.mm.sdk.platformtools.a.dd(this.mController.contentView);
        com.tencent.mm.sdk.platformtools.a.eF(this.mController.xIM);
        this.mController.onDestroy();
        this.xIq = true;
    }

    public static void cmR() {
        p.cmR();
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        ad.aT(2, this.className);
        super.onPause();
        this.mController.onPause();
        boolean isFinishing = isFinishing();
        x.v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(isFinishing), Integer.valueOf(hashCode()));
        this.xIu = bh.Wq();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.mController.onCreateOptionsMenu(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.mController.onPrepareOptionsMenu(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mController.onOptionsItemSelected(menuItem);
    }

    public String getIdentString() {
        return "";
    }

    protected static View getLayoutView() {
        return null;
    }

    public final void fullScreenNoTitleBar(boolean z) {
        this.mController.fullScreenNoTitleBar(z);
    }

    public final void setTitleVisibility(int i) {
        this.mController.setTitleVisibility(i);
    }

    public void nR(int i) {
        p pVar = this.mController;
        if (pVar.mActionBar != null) {
            pVar.xIT.setTextColor(i);
        }
    }

    public void setMMTitle(String str) {
        this.mController.setMMTitle(str);
    }

    public final void O(CharSequence charSequence) {
        this.mController.O(charSequence);
    }

    public void setMMTitle(int i) {
        this.mController.setMMTitle(i);
    }

    public void setMMSubTitle(String str) {
        this.mController.setMMSubTitle(str);
    }

    public final void setMMSubTitle(int i) {
        this.mController.setMMSubTitle(i);
    }

    public final void DP(int i) {
        this.mController.xIT.setVisibility(i);
    }

    public final void DQ(int i) {
        this.mController.setTitleLogo(0, i);
    }

    public final void cmS() {
        p pVar = this.mController;
        if (pVar.xIS != null) {
            pVar.xIS.setVisibility(8);
        }
    }

    public final void showHomeBtn(boolean z) {
        this.mController.showHomeBtn(z);
    }

    public final void enableBackMenu(boolean z) {
        this.mController.enableBackMenu(z);
    }

    public final void enableOptionMenu(boolean z) {
        this.mController.a(true, -1, z);
    }

    public final void enableOptionMenu(int i, boolean z) {
        this.mController.a(false, i, z);
    }

    public final void showOptionMenu(boolean z) {
        this.mController.b(true, -1, z);
    }

    public final void showOptionMenu(int i, boolean z) {
        this.mController.b(false, i, z);
    }

    public final boolean cmT() {
        Iterator it = this.mController.xIP.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.p.a aVar = (com.tencent.mm.ui.p.a) it.next();
            if (aVar.xJr == 0) {
                return aVar.fqP;
            }
        }
        return false;
    }

    public final boolean cmU() {
        Iterator it = this.mController.xIP.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.p.a aVar = (com.tencent.mm.ui.p.a) it.next();
            if (aVar.xJr == 0) {
                return aVar.visible;
            }
        }
        return false;
    }

    public final void a(p pVar) {
        this.mController.addSearchMenu(true, pVar);
    }

    public void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    public final void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener, int i2) {
        this.mController.addTextOptionMenu$7df2a0ca(i, str, onMenuItemClickListener, null, i2);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }

    public final void a(int i, String str, Drawable drawable, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.a(i, str, drawable, onMenuItemClickListener);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, i3, onMenuItemClickListener);
    }

    public final void updateOptionMenuText(int i, String str) {
        this.mController.updateOptionMenuText(i, str);
    }

    public final void a(OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.updateOptionMenuListener(1, onMenuItemClickListener, null);
    }

    public final void aa(Runnable runnable) {
        p pVar = this.mController;
        if (pVar.mActionBar != null) {
            pVar.mActionBar.getCustomView().setOnClickListener(new AnonymousClass2(pVar, runnable));
        }
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.setBackBtn(onMenuItemClickListener, 0);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.mController.setBackBtn(onMenuItemClickListener, i);
    }

    public final void cmV() {
        p pVar = this.mController;
        if (pVar.xIV != null) {
            pVar.xIV.setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        }
    }

    public final void lV(boolean z) {
        p pVar = this.mController;
        if (pVar.xIV == null) {
            return;
        }
        if (z) {
            pVar.xIV.setVisibility(0);
        } else {
            pVar.xIV.setVisibility(8);
        }
    }

    public final boolean removeOptionMenu(int i) {
        return this.mController.removeOptionMenu(i);
    }

    public final void setTitleMuteIconVisibility(int i) {
        this.mController.setTitleMuteIconVisibility(i);
    }

    public void aWs() {
        this.mController.hideVKB();
    }

    public final void df(View view) {
        this.mController.hideVKB(view);
    }

    public void showVKB() {
        this.mController.showVKB();
    }

    public static void showVKB(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }

    public void finish() {
        super.finish();
        int a = t.a(getIntent(), u.FLAG_OVERRIDE_ENTER_ANIMATION, -1);
        int a2 = t.a(getIntent(), u.FLAG_OVERRIDE_EXIT_ANIMATION, -1);
        if (a != -1) {
            super.overridePendingTransition(a, a2);
        }
    }

    public final void G(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void a(Class<?> cls, Intent intent) {
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void b(a aVar, Intent intent, int i) {
        this.jwN = aVar;
        startActivityForResult(intent, i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jwN != null) {
            this.jwN.b(i, i2, intent);
        }
        this.jwN = null;
    }

    public final void cmW() {
        p pVar = this.mController;
        pVar.xIW.setVisibility(0);
        pVar.xIV.setVisibility(8);
        pVar.xIU.setVisibility(8);
    }

    public final void cmX() {
        p pVar = this.mController;
        if (pVar.mContext != null) {
            pVar.V(pVar.xIM);
        }
    }

    public final void cmY() {
        int i = 0;
        if (fs(this.mController.xIM)) {
            int i2;
            if (this.xIr == null) {
                this.xIr = new View(this.mController.xIM);
                ((ViewGroup) getWindow().getDecorView()).addView(this.xIr);
            }
            Context context = this.mController.xIM;
            Resources resources = context.getResources();
            if (resources.getConfiguration().orientation == 1) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (VERSION.SDK_INT >= 14 && fs(context)) {
                i2 = resources.getIdentifier(i2 != 0 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
                if (i2 > 0) {
                    i = resources.getDimensionPixelSize(i2);
                }
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, i);
            layoutParams.gravity = 80;
            this.xIr.setLayoutParams(layoutParams);
            this.xIr.setBackgroundColor(-637534208);
            this.xIr.setVisibility(8);
            return;
        }
        x.w("MicroMsg.MMActivity", "has not NavigationBar!");
    }

    public final void DR(int i) {
        if (this.xIr != null) {
            this.xIr.setVisibility(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                xIs = (String) declaredMethod.invoke(null, new Object[]{"qemu.hw.mainkeys"});
            } catch (Throwable th) {
                xIs = null;
            }
        }
    }

    public static boolean fs(Context context) {
        Resources resources = context.getResources();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            if ("1".equals(xIs)) {
                z = false;
            } else if ("0".equals(xIs)) {
                z = true;
            }
            if (!z || deviceHasKey || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                return false;
            }
            return true;
        } else if (ViewConfiguration.get(context).hasPermanentMenuKey() || deviceHasKey) {
            return false;
        } else {
            return true;
        }
    }

    public final long cmZ() {
        long j;
        if (this.xIu != 0) {
            j = (this.xIu - this.xIt) + this.xIv;
        } else {
            j = (bh.Wq() - this.xIt) + this.xIv;
        }
        if (j < 0) {
            x.w("MicroMsg.MMActivity", "%d get activity browse time is error, may be something warn here.[%d %d %d %d]", Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(this.xIt), Long.valueOf(this.xIu), Long.valueOf(this.xIv));
        }
        x.v("MicroMsg.MMActivity", "%d get activity browse time [%d]", Integer.valueOf(hashCode()), Long.valueOf(j));
        return j;
    }
}
