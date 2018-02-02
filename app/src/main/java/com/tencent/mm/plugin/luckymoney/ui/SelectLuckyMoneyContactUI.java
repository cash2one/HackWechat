package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wxpay.a$a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.z.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class SelectLuckyMoneyContactUI extends MMBaseSelectContactUI {
    private List<String> kiU;
    private View okJ;

    protected final void WT() {
        super.WT();
        Collection hashSet = new HashSet();
        hashSet.addAll(s.cwj());
        hashSet.addAll(s.cwk());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!bh.ov(stringExtra)) {
            hashSet.addAll(bh.F(stringExtra.split(",")));
        }
        this.kiU = new ArrayList();
        this.kiU.addAll(hashSet);
    }

    public final void ja(int i) {
        if (i < this.prJ.getHeaderViewsCount()) {
            x.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", Integer.valueOf(i));
            x.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            int intExtra = getIntent().getIntExtra("key_friends_num", 0);
            Intent intent = new Intent();
            int p = s.p(new int[]{16, 1, 2, 4, 16384, 64, 65536, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT});
            intent.putExtra("list_type", 0);
            intent.putExtra("list_attr", p);
            intent.putExtra("max_limit_num", intExtra);
            intent.putExtra("titile", getString(i.uKJ, new Object[]{Integer.valueOf(intExtra)}));
            intent.putExtra("sub_title", getString(i.uYq));
            d.a(this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(a$a.bqo, a$a.bqa);
            return;
        }
        a aVar = (a) this.prJ.getAdapter().getItem(i);
        if (aVar != null) {
            af afVar = aVar.jLe;
            if (afVar != null) {
                String str = afVar.field_username;
                x.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", str);
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_User", str);
                String str2 = null;
                if (com.tencent.mm.z.s.eV(str)) {
                    str2 = getString(i.uWy, new Object[]{Integer.valueOf(m.gl(str))});
                }
                ((com.tencent.mm.pluginsdk.i) g.h(com.tencent.mm.pluginsdk.i.class)).a(this.mController, str, getString(i.eEF), str, str2, getString(i.dGA), new 1(this, intent2));
            }
        }
    }

    protected final boolean WU() {
        return false;
    }

    protected final boolean WV() {
        return false;
    }

    protected final String WW() {
        return getString(i.uKK);
    }

    protected final o WX() {
        return new t(this, this.kiU);
    }

    protected final com.tencent.mm.ui.contact.m WY() {
        return new q(this, this.kiU, false, this.scene);
    }

    public final int[] aXV() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.okJ == null) {
            View inflate = View.inflate(this, com.tencent.mm.plugin.wxpay.a.g.uEh, null);
            this.okJ = inflate.findViewById(a$f.content);
            ((TextView) inflate.findViewById(a$f.cRV)).setText(i.uKg);
            listView.addHeaderView(inflate);
        }
        this.okJ.setVisibility(i);
    }

    protected final void aXW() {
        super.aXW();
        aWs();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aXW();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            x.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            x.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            x.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 == -1) {
            x.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
            setResult(-1, intent);
            finish();
        }
    }
}
