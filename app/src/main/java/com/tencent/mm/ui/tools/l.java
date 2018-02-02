package com.tencent.mm.ui.tools;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p$a;
import com.tencent.mm.ui.base.p$c;
import com.tencent.mm.ui.base.p.b;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.MMWebView;

public final class l implements OnItemClickListener {
    private LayoutInflater DF;
    private OnDismissListener jWl;
    private Context mContext;
    public m rKB;
    public p$c rKC;
    public d rKD;
    private n rKE = new n();
    private a zls;
    public p$a zlt;
    public b zlu;

    public l(Context context) {
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
        this.rKB = new m(context);
    }

    public final void a(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        this.rKD = dVar;
        x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
        if (view instanceof AbsListView) {
            x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
            ((AbsListView) view).setOnItemLongClickListener(new 1(this, onCreateContextMenuListener));
        } else if (view instanceof MMWebView) {
            x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
            view.setOnLongClickListener(new 2(this, onCreateContextMenuListener));
        } else {
            x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
            view.setOnLongClickListener(new 3(this, onCreateContextMenuListener));
        }
    }

    public final void a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).isSwiping()) {
            x.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
            return;
        }
        this.rKE.clear();
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.rKE, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.rKE.ycc) {
            ((o) menuItem).ycf = adapterContextMenuInfo;
        }
        bBX();
        this.rKD = dVar;
    }

    public final void a(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, OnDismissListener onDismissListener) {
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).isSwiping()) {
            x.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
            return;
        }
        this.jWl = onDismissListener;
        this.rKE.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.rKE, view, null);
        bBX();
        this.rKD = dVar;
    }

    public final void b(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        a(view, onCreateContextMenuListener, dVar, null);
    }

    public final void e(OnCancelListener onCancelListener) {
        this.rKB.setOnCancelListener(onCancelListener);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        o oVar = (o) this.rKE.ycc.get(i);
        if (oVar.performClick()) {
            x.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
            dismiss();
            return;
        }
        if (this.rKD != null) {
            this.rKD.onMMMenuItemSelected(oVar, i);
        }
        dismiss();
    }

    public final void dismiss() {
        if (this.rKB.isShowing()) {
            this.rKB.dismiss();
        }
    }

    public final Dialog bBX() {
        if (this.rKC != null) {
            this.rKE.clear();
            this.rKE = new n();
            this.rKC.a(this.rKE);
        }
        if (this.rKE.cps()) {
            x.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
            return null;
        }
        if (this.zls == null) {
            this.zls = new a(this, (byte) 0);
        }
        this.rKB.kPo = this.zls;
        this.rKB.vwr = this;
        this.rKB.setTitle(this.rKE.Lp);
        this.rKB.setOnDismissListener(this.jWl);
        this.rKB.show();
        return this.rKB;
    }
}
