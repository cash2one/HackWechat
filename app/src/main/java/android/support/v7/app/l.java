package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.view.z;
import android.support.v7.a.a.h;
import android.support.v7.a.a.j;
import android.support.v7.view.i;
import android.support.v7.view.menu.e;
import android.support.v7.view.menu.f;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.aq;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import java.util.ArrayList;

final class l extends ActionBar {
    u HT;
    boolean HU;
    Callback HV;
    private boolean HW;
    private boolean HX;
    private ArrayList<Object> HY = new ArrayList();
    e HZ;
    private final Runnable Ia = new Runnable(this) {
        final /* synthetic */ l Ic;

        public final void run() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0032 in list [B:12:0x002f]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r5 = this;
            r0 = 0;
            r3 = r5.Ic;
            r1 = r3.getMenu();
            r2 = r1 instanceof android.support.v7.view.menu.f;
            if (r2 == 0) goto L_0x0033;
        L_0x000b:
            r0 = r1;
            r0 = (android.support.v7.view.menu.f) r0;
            r2 = r0;
        L_0x000f:
            if (r2 == 0) goto L_0x0014;
        L_0x0011:
            r2.dw();
        L_0x0014:
            r1.clear();	 Catch:{ all -> 0x0035 }
            r0 = r3.HV;	 Catch:{ all -> 0x0035 }
            r4 = 0;	 Catch:{ all -> 0x0035 }
            r0 = r0.onCreatePanelMenu(r4, r1);	 Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x002a;	 Catch:{ all -> 0x0035 }
        L_0x0020:
            r0 = r3.HV;	 Catch:{ all -> 0x0035 }
            r3 = 0;	 Catch:{ all -> 0x0035 }
            r4 = 0;	 Catch:{ all -> 0x0035 }
            r0 = r0.onPreparePanel(r3, r4, r1);	 Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x002d;	 Catch:{ all -> 0x0035 }
        L_0x002a:
            r1.clear();	 Catch:{ all -> 0x0035 }
        L_0x002d:
            if (r2 == 0) goto L_0x0032;
        L_0x002f:
            r2.dx();
        L_0x0032:
            return;
        L_0x0033:
            r2 = r0;
            goto L_0x000f;
        L_0x0035:
            r0 = move-exception;
            if (r2 == 0) goto L_0x003b;
        L_0x0038:
            r2.dx();
        L_0x003b:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.l.1.run():void");
        }

        {
            this.Ic = r1;
        }
    };
    private final android.support.v7.widget.Toolbar.b Ib = new android.support.v7.widget.Toolbar.b(this) {
        final /* synthetic */ l Ic;

        {
            this.Ic = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return this.Ic.HV.onMenuItemSelected(0, menuItem);
        }
    };

    private final class a implements android.support.v7.view.menu.l.a {
        private boolean Hk;
        final /* synthetic */ l Ic;

        private a(l lVar) {
            this.Ic = lVar;
        }

        public final boolean d(f fVar) {
            if (this.Ic.HV == null) {
                return false;
            }
            this.Ic.HV.onMenuOpened(108, fVar);
            return true;
        }

        public final void a(f fVar, boolean z) {
            if (!this.Hk) {
                this.Hk = true;
                this.Ic.HT.dismissPopupMenus();
                if (this.Ic.HV != null) {
                    this.Ic.HV.onPanelClosed(108, fVar);
                }
                this.Hk = false;
            }
        }
    }

    private final class b implements android.support.v7.view.menu.f.a {
        final /* synthetic */ l Ic;

        private b(l lVar) {
            this.Ic = lVar;
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            return false;
        }

        public final void b(f fVar) {
            if (this.Ic.HV == null) {
                return;
            }
            if (this.Ic.HT.isOverflowMenuShowing()) {
                this.Ic.HV.onPanelClosed(108, fVar);
            } else if (this.Ic.HV.onPreparePanel(0, null, fVar)) {
                this.Ic.HV.onMenuOpened(108, fVar);
            }
        }
    }

    private final class c implements android.support.v7.view.menu.l.a {
        final /* synthetic */ l Ic;

        private c(l lVar) {
            this.Ic = lVar;
        }

        public final void a(f fVar, boolean z) {
            if (this.Ic.HV != null) {
                this.Ic.HV.onPanelClosed(0, fVar);
            }
        }

        public final boolean d(f fVar) {
            if (fVar == null && this.Ic.HV != null) {
                this.Ic.HV.onMenuOpened(0, fVar);
            }
            return true;
        }
    }

    private class d extends i {
        final /* synthetic */ l Ic;

        public d(l lVar, Callback callback) {
            this.Ic = lVar;
            super(callback);
        }

        public final boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !this.Ic.HU) {
                this.Ic.HT.dW();
                this.Ic.HU = true;
            }
            return onPreparePanel;
        }

        public final View onCreatePanelView(int i) {
            switch (i) {
                case 0:
                    Menu menu = this.Ic.HT.getMenu();
                    if (onPreparePanel(i, null, menu) && onMenuOpened(i, menu)) {
                        l lVar = this.Ic;
                        if (lVar.HZ == null && (menu instanceof f)) {
                            f fVar = (f) menu;
                            Context context = lVar.HT.getContext();
                            TypedValue typedValue = new TypedValue();
                            Theme newTheme = context.getResources().newTheme();
                            newTheme.setTo(context.getTheme());
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
                            Context contextThemeWrapper = new ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(newTheme);
                            lVar.HZ = new e(contextThemeWrapper, h.abc_list_menu_item_layout);
                            lVar.HZ.ef = new c();
                            fVar.a(lVar.HZ);
                        }
                        if (menu == null || lVar.HZ == null) {
                            return null;
                        }
                        return lVar.HZ.getAdapter().getCount() > 0 ? (View) lVar.HZ.c(lVar.HT.eH()) : null;
                    }
                    break;
            }
            return super.onCreatePanelView(i);
        }
    }

    public l(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.HT = new aq(toolbar, false);
        this.HV = new d(this, callback);
        this.HT.b(this.HV);
        toolbar.ZT = this.Ib;
        this.HT.e(charSequence);
    }

    public final void setCustomView(View view) {
        LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -2);
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.HT.setCustomView(view);
    }

    public final void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.HT.getContext()).inflate(i, this.HT.eH(), false));
    }

    public final void setIcon(int i) {
        this.HT.setIcon(i);
    }

    public final void setLogo(Drawable drawable) {
        this.HT.setLogo(drawable);
    }

    public final void setElevation(float f) {
        z.g(this.HT.eH(), f);
    }

    public final Context getThemedContext() {
        return this.HT.getContext();
    }

    public final void v(boolean z) {
    }

    public final void setHomeActionContentDescription(int i) {
        this.HT.setNavigationContentDescription(i);
    }

    public final void w(boolean z) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void e(CharSequence charSequence) {
        this.HT.e(charSequence);
    }

    public final boolean requestFocus() {
        ViewGroup eH = this.HT.eH();
        if (eH == null || eH.hasFocus()) {
            return false;
        }
        eH.requestFocus();
        return true;
    }

    public final void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
    }

    private void setDisplayOptions(int i, int i2) {
        this.HT.setDisplayOptions((this.HT.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
    }

    public final void cN() {
        setDisplayOptions(0, 2);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public final void cO() {
        setDisplayOptions(0, 8);
    }

    public final void cP() {
        setDisplayOptions(16, 16);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.HT.setBackgroundDrawable(drawable);
    }

    public final View getCustomView() {
        return this.HT.getCustomView();
    }

    public final CharSequence getTitle() {
        return this.HT.getTitle();
    }

    public final int getDisplayOptions() {
        return this.HT.getDisplayOptions();
    }

    public final int getHeight() {
        return this.HT.getHeight();
    }

    public final void show() {
        this.HT.setVisibility(0);
    }

    public final void hide() {
        this.HT.setVisibility(8);
    }

    public final boolean isShowing() {
        return this.HT.getVisibility() == 0;
    }

    public final boolean cQ() {
        this.HT.eH().removeCallbacks(this.Ia);
        z.a(this.HT.eH(), this.Ia);
        return true;
    }

    public final boolean collapseActionView() {
        if (!this.HT.hasExpandedActionView()) {
            return false;
        }
        this.HT.collapseActionView();
        return true;
    }

    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu = getMenu();
        if (menu != null) {
            boolean z;
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            menu.setQwertyMode(z);
            menu.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    final void onDestroy() {
        this.HT.eH().removeCallbacks(this.Ia);
    }

    public final void x(boolean z) {
        if (z != this.HX) {
            this.HX = z;
            int size = this.HY.size();
            for (int i = 0; i < size; i++) {
                this.HY.get(i);
            }
        }
    }

    final Menu getMenu() {
        if (!this.HW) {
            this.HT.a(new a(), new b());
            this.HW = true;
        }
        return this.HT.getMenu();
    }
}
