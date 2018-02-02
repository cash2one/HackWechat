package android.support.v7.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class f extends e {
    final Window Ft;
    final Callback GG = this.Ft.getCallback();
    final Callback GH;
    final d GI;
    boolean GJ;
    boolean GK;
    boolean GL;
    boolean GM;
    boolean GN;
    boolean GO;
    MenuInflater iY;
    ActionBar mActionBar;
    final Context mContext;
    CharSequence uU;

    private class a implements android.support.v7.app.a.a {
        final /* synthetic */ f GP;

        private a(f fVar) {
            this.GP = fVar;
        }

        public final void az(int i) {
            ActionBar supportActionBar = this.GP.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    class b extends i {
        final /* synthetic */ f GP;

        b(f fVar, Callback callback) {
            this.GP = fVar;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.GP.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.GP.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof android.support.v7.view.menu.f)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            android.support.v7.view.menu.f fVar;
            if (menu instanceof android.support.v7.view.menu.f) {
                fVar = (android.support.v7.view.menu.f) menu;
            } else {
                fVar = null;
            }
            if (i == 0 && fVar == null) {
                return false;
            }
            if (fVar != null) {
                fVar.Lz = true;
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (fVar == null) {
                return onPreparePanel;
            }
            fVar.Lz = false;
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.GP.aB(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.GP.aA(i);
        }
    }

    abstract void aA(int i);

    abstract boolean aB(int i);

    abstract android.support.v7.view.b b(android.support.v7.view.b.a aVar);

    abstract void cV();

    abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    abstract void f(CharSequence charSequence);

    abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    f(Context context, Window window, d dVar) {
        this.mContext = context;
        this.Ft = window;
        this.GI = dVar;
        if (this.GG instanceof b) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.GH = a(this.GG);
        this.Ft.setCallback(this.GH);
    }

    Callback a(Callback callback) {
        return new b(this, callback);
    }

    public final ActionBar getSupportActionBar() {
        cV();
        return this.mActionBar;
    }

    public final MenuInflater getMenuInflater() {
        if (this.iY == null) {
            cV();
            this.iY = new g(this.mActionBar != null ? this.mActionBar.getThemedContext() : this.mContext);
        }
        return this.iY;
    }

    public final android.support.v7.app.a.a getDrawerToggleDelegate() {
        return new a();
    }

    final Context cW() {
        Context context = null;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            context = supportActionBar.getThemedContext();
        }
        if (context == null) {
            return this.mContext;
        }
        return context;
    }

    public void onDestroy() {
        this.GO = true;
    }

    public boolean cT() {
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.uU = charSequence;
        f(charSequence);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }
}
