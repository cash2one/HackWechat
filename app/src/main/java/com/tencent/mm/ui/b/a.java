package com.tencent.mm.ui.b;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public abstract class a {
    public b Ha = null;
    public MenuInflater iY;
    public ActionBar mActionBar;
    public final Activity mActivity;

    class a implements android.support.v7.view.b.a {
        private android.support.v7.view.b.a Hv;
        final /* synthetic */ a xVt;

        public a(a aVar, android.support.v7.view.b.a aVar2) {
            this.xVt = aVar;
            this.Hv = aVar2;
        }

        public final boolean a(b bVar, Menu menu) {
            return this.Hv.a(bVar, menu);
        }

        public final boolean b(b bVar, Menu menu) {
            return this.Hv.b(bVar, menu);
        }

        public final boolean a(b bVar, MenuItem menuItem) {
            return this.Hv.a(bVar, menuItem);
        }

        public final void a(b bVar) {
            this.Hv.a(bVar);
            this.xVt.Ha = null;
        }
    }

    abstract ActionBar coB();

    public a(Activity activity) {
        this.mActivity = activity;
    }

    public final ActionBar getSupportActionBar() {
        if (this.mActionBar == null) {
            this.mActionBar = coB();
        }
        return this.mActionBar;
    }
}
