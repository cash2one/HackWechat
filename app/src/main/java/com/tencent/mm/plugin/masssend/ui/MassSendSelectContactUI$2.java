package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HeaderViewListAdapter;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import java.util.Iterator;

class MassSendSelectContactUI$2 implements OnClickListener {
    final /* synthetic */ MassSendSelectContactUI oob;

    MassSendSelectContactUI$2(MassSendSelectContactUI massSendSelectContactUI) {
        this.oob = massSendSelectContactUI;
    }

    public final void onClick(View view) {
        boolean z;
        x.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
        n nVar = (n) ((HeaderViewListAdapter) this.oob.prJ.getAdapter()).getWrappedAdapter();
        if (MassSendSelectContactUI.b(this.oob)) {
            MassSendSelectContactUI.c(this.oob).setText(R.l.euM);
            Iterator it = MassSendSelectContactUI.a(this.oob).iterator();
            while (it.hasNext()) {
                MassSendSelectContactUI.d(this.oob).Sg((String) it.next());
            }
            MassSendSelectContactUI.a(this.oob).clear();
        } else {
            MassSendSelectContactUI.c(this.oob).setText(R.l.euF);
            int count = nVar.getCount();
            for (int i = 0; i < count; i++) {
                a Gm = nVar.Gm(i);
                if (!(Gm == null || Gm.jLe == null || MassSendSelectContactUI.a(this.oob).contains(Gm.jLe.field_username))) {
                    MassSendSelectContactUI.a(this.oob).add(Gm.jLe.field_username);
                    MassSendSelectContactUI.d(this.oob).Sg(Gm.jLe.field_username);
                }
            }
        }
        MassSendSelectContactUI massSendSelectContactUI = this.oob;
        if (MassSendSelectContactUI.b(this.oob)) {
            z = false;
        } else {
            z = true;
        }
        MassSendSelectContactUI.a(massSendSelectContactUI, z);
        MassSendSelectContactUI.a(this.oob, MassSendSelectContactUI.a(this.oob).size());
        nVar.notifyDataSetChanged();
    }
}
