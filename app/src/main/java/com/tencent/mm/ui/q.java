package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.view.f;
import android.support.v7.view.g;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.b.b.a;

public final class q extends p implements a {
    private ActionBar mActionBar;
    public u xJX = null;
    public b xJY;

    public final ActionMode startActionMode(Callback callback) {
        com.tencent.mm.ui.b.a aVar = this.xJY;
        Object aVar2 = new f.a(aVar.mActivity, callback);
        if (aVar.Ha != null) {
            aVar.Ha.finish();
        }
        android.support.v7.view.b.a aVar3 = new a(aVar, aVar2);
        ActionBar supportActionBar = aVar.getSupportActionBar();
        if (supportActionBar != null) {
            aVar.Ha = supportActionBar.a(aVar3);
        }
        android.support.v7.view.b bVar = aVar.Ha;
        return bVar != null ? aVar2.b(bVar) : null;
    }

    protected final int getLayoutId() {
        if (this.xJX != null) {
            return this.xJX.getLayoutId();
        }
        return -1;
    }

    protected final void dealContentView(View view) {
        if (this.xJX != null) {
            this.xJX.dealContentView(view);
        }
    }

    protected final String getIdentString() {
        if (this.xJX != null) {
            return this.xJX.getIdentString();
        }
        return null;
    }

    protected final View getLayoutView() {
        if (this.xJX != null) {
            return this.xJX.getLayoutView();
        }
        return null;
    }

    public final void onKeyboardStateChanged() {
        if (this.xJX != null) {
            this.xJX.onKeyboardStateChanged();
        }
    }

    protected final void onCreateBeforeSetContentView() {
        if (this.xJX != null) {
            this.xJX.onCreateBeforeSetContentView();
        }
    }

    protected final String getClassName() {
        return this.xJX.getClass().getName();
    }

    protected final boolean cmP() {
        return false;
    }

    public final ActionBar getSupportActionBar() {
        if (this.mActionBar == null) {
            this.mActionBar = this.xJY.coB();
        }
        return this.mActionBar;
    }

    public final boolean interceptSupportInvalidateOptionsMenu() {
        return true;
    }

    public final void supportInvalidateOptionsMenu() {
        this.xJY.supportInvalidateOptionsMenu();
    }

    public final boolean c(Menu menu) {
        if (this.xJX != null) {
            this.xJX.onPrepareOptionsMenu(menu);
        }
        return true;
    }

    public final boolean d(Menu menu) {
        u uVar = this.xJX;
        com.tencent.mm.ui.b.a aVar = this.xJY;
        if (aVar.iY == null) {
            ActionBar supportActionBar = aVar.getSupportActionBar();
            if (supportActionBar != null) {
                aVar.iY = new g(supportActionBar.getThemedContext());
            } else {
                aVar.iY = new g(aVar.mActivity);
            }
        }
        uVar.onCreateOptionsMenu(menu, aVar.iY);
        return true;
    }

    public final boolean j(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }
}
