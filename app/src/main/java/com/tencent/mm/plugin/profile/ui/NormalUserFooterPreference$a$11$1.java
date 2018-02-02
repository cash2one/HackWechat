package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.11;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class NormalUserFooterPreference$a$11$1 implements d {
    final /* synthetic */ 11 pkJ;

    NormalUserFooterPreference$a$11$1(11 11) {
        this.pkJ = 11;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                this.pkJ.pkC.HB(NormalUserFooterPreference.a(this.pkJ.pkC.pkA).field_username);
                return;
            case 5:
                h.a(this.pkJ.pkC.pkA.mContext, this.pkJ.pkC.pkA.mContext.getString(R.l.dVI), this.pkJ.pkC.pkA.mContext.getString(R.l.dVH), new OnClickListener(this) {
                    final /* synthetic */ NormalUserFooterPreference$a$11$1 pkK;

                    {
                        this.pkK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.b(this.pkK.pkJ.pkC);
                    }
                }, null);
                return;
            case 8:
                a.a(this.pkJ.pkC);
                return;
            default:
                return;
        }
    }
}
