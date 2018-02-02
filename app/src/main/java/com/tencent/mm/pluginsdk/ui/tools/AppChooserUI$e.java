package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.i;

class AppChooserUI$e {
    OnDismissListener Gk;
    public i iol;
    BaseAdapter kPo;
    Context mContext;
    String mTitle;
    OnClickListener vwe;
    final /* synthetic */ AppChooserUI vwh;
    ListViewInScrollView vwq = ((ListViewInScrollView) View.inflate(this.mContext, R.i.dan, null));
    OnItemClickListener vwr;
    OnClickListener vws;

    public AppChooserUI$e(AppChooserUI appChooserUI, Context context) {
        this.vwh = appChooserUI;
        this.mContext = context;
    }

    public final void lp(boolean z) {
        if (this.iol == null) {
            return;
        }
        if (z) {
            this.iol.a(R.l.dGW, this.vwe);
            this.iol.b(R.l.dGV, this.vws);
            return;
        }
        this.iol.a(R.l.dGW, null);
        this.iol.b(R.l.dGV, null);
    }
}
