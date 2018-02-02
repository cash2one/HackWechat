package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.List;

class MassSendSelectContactUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MassSendSelectContactUI oob;

    MassSendSelectContactUI$1(MassSendSelectContactUI massSendSelectContactUI) {
        this.oob = massSendSelectContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
        List F = bh.F((String[]) MassSendSelectContactUI.a(this.oob).toArray(new String[0]));
        if (F == null) {
            x.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
            return false;
        }
        F.remove(q.FS());
        String d = bh.d(F, ";");
        Intent intent = new Intent(this.oob, MassSendMsgUI.class);
        intent.putExtra("mass_send_contact_list", d);
        this.oob.startActivity(intent);
        return true;
    }
}
