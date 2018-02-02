package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.h;

class AddInvoiceUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ AddInvoiceUI imL;

    AddInvoiceUI$4(AddInvoiceUI addInvoiceUI) {
        this.imL = addInvoiceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (AddInvoiceUI.f(this.imL) == 0) {
            g.pQN.h(14199, Integer.valueOf(3));
        } else {
            g.pQN.h(14199, Integer.valueOf(4));
        }
        if (AddInvoiceUI.a(this.imL) != null && AddInvoiceUI.a(this.imL).isActivated() && AddInvoiceUI.g(this.imL).getText().length() == 0) {
            this.imL.XN();
            return false;
        } else if (AddInvoiceUI.b(this.imL) != null && AddInvoiceUI.b(this.imL).isActivated() && AddInvoiceUI.h(this.imL).getText().length() == 0) {
            this.imL.XN();
            return false;
        } else if (AddInvoiceUI.f(this.imL) != 0 && AddInvoiceUI.h(this.imL).getText().length() == 0 && AddInvoiceUI.g(this.imL).getText().length() == 0) {
            this.imL.XN();
            return false;
        } else if (AddInvoiceUI.i(this.imL).getText().length() > 100) {
            Context context = this.imL;
            h.a(context, context.getString(R.l.eqf), context.getString(R.l.dGO), false, null);
            return false;
        } else if (AddInvoiceUI.d(this.imL)) {
            if (AddInvoiceUI.a(this.imL).isActivated()) {
                AddInvoiceUI.c(this.imL).type = "0";
            } else if (AddInvoiceUI.b(this.imL).isActivated()) {
                AddInvoiceUI.c(this.imL).type = "1";
            }
            if (AddInvoiceUI.j(this.imL) != null) {
                AddInvoiceUI.c(this.imL).type = AddInvoiceUI.j(this.imL).type;
            }
            AddInvoiceUI.c(this.imL).title = AddInvoiceUI.g(this.imL).getText();
            AddInvoiceUI.c(this.imL).nBJ = AddInvoiceUI.h(this.imL).getText();
            AddInvoiceUI.c(this.imL).nBK = AddInvoiceUI.i(this.imL).getText();
            AddInvoiceUI.c(this.imL).nBI = AddInvoiceUI.f(this.imL);
            AddInvoiceUI.c(this.imL).nBO = AddInvoiceUI.k(this.imL).getText();
            AddInvoiceUI.c(this.imL).nBM = AddInvoiceUI.m(this.imL).getText();
            AddInvoiceUI.c(this.imL).nBL = AddInvoiceUI.l(this.imL).getText();
            AddInvoiceUI.c(this.imL).nBQ = AddInvoiceUI.n(this.imL).getText();
            AddInvoiceUI.o(this.imL);
            return true;
        } else {
            if ((AddInvoiceUI.a(this.imL) != null && AddInvoiceUI.a(this.imL).isActivated()) || !(AddInvoiceUI.j(this.imL) == null || AddInvoiceUI.j(this.imL).type == null || !AddInvoiceUI.j(this.imL).type.equals("0"))) {
                Context context2;
                if (!AddInvoiceUI.k(this.imL).XO()) {
                    context2 = this.imL;
                    h.a(context2, context2.getString(R.l.eqk), context2.getString(R.l.dGO), false, null);
                }
                if (!AddInvoiceUI.l(this.imL).XO()) {
                    context2 = this.imL;
                    h.a(context2, context2.getString(R.l.eqd), context2.getString(R.l.dGO), false, null);
                }
            }
            return true;
        }
    }
}
