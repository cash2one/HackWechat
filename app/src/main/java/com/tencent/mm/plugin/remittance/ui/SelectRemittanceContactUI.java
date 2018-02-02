package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@a(19)
public class SelectRemittanceContactUI extends MMBaseSelectContactUI {
    private int fromScene;
    private List<String> kiU;
    private View okJ;
    private List<String> pOv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void WT() {
        super.WT();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        String stringExtra = getIntent().getStringExtra("recent_remittance_contact_list");
        x.v("MicroMsg.SelectRemittanceContactUI", "recent list:" + stringExtra);
        this.pOv = new ArrayList();
        if (!bh.ov(stringExtra)) {
            this.pOv = bh.F(stringExtra.split(","));
        }
        Collection hashSet = new HashSet();
        hashSet.addAll(s.cwj());
        hashSet.addAll(s.cwk());
        String stringExtra2 = getIntent().getStringExtra("Select_block_List");
        if (!bh.ov(stringExtra2)) {
            hashSet.addAll(bh.F(stringExtra2.split(",")));
        }
        this.kiU = new ArrayList();
        this.kiU.addAll(hashSet);
    }

    protected final o WX() {
        return new c(this, this.pOv, this.kiU, this.fromScene);
    }

    protected final m WY() {
        return new q(this, this.kiU, false, this.scene);
    }

    public final int[] aXV() {
        if (this.fromScene == 1) {
            return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
        }
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public final void ja(int i) {
        if (i < this.prJ.getHeaderViewsCount()) {
            x.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
            x.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            Intent intent = new Intent();
            if (this.fromScene == 1) {
                intent.putExtra("list_attr", s.p(new int[]{s.yTD, 16384, 64, Downloads.RECV_BUFFER_SIZE, 262144}));
                intent.putExtra("min_limit_num", 1);
                intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
                intent.putExtra("titile", getString(i.uWC));
            } else {
                int p = s.p(new int[]{16, 1, 2, 4, 16384});
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", p);
                intent.putExtra("titile", getString(i.uOj));
                intent.putExtra("sub_title", getString(i.uXt));
            }
            d.a(this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.bqo, com.tencent.mm.plugin.wxpay.a.a.bqa);
            return;
        }
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) this.prJ.getAdapter().getItem(i);
        if (aVar != null) {
            af afVar = aVar.jLe;
            if (afVar != null) {
                x.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[]{afVar.field_username});
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_User", r0);
                setResult(-1, intent2);
                finish();
                aWs();
                if (cvZ() instanceof c) {
                    int i2;
                    p = i - this.prJ.getHeaderViewsCount();
                    c cVar = (c) cvZ();
                    x.d("MicroMsg.RecentConversationAdapter", "pos: %s", new Object[]{Integer.valueOf(p)});
                    if (cVar.pOt >= 0) {
                        if (cVar.pOu < 0) {
                            i2 = 1;
                        } else if (p > cVar.pOt && p < cVar.pOu) {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            g.pQN.h(13721, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                        }
                    }
                    i2 = 0;
                    if (i2 != 0) {
                        g.pQN.h(13721, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                    }
                }
            }
        }
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

    protected final boolean WU() {
        return false;
    }

    protected final boolean WV() {
        return false;
    }

    protected final String WW() {
        if (this.fromScene == 1) {
            return getString(i.uWB);
        }
        return getString(i.uOk);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.okJ == null) {
            View inflate = View.inflate(this, com.tencent.mm.plugin.wxpay.a.g.uEh, null);
            this.okJ = inflate.findViewById(f.content);
            TextView textView = (TextView) inflate.findViewById(f.cRV);
            if (this.fromScene == 1) {
                textView.setText(i.uWz);
            } else {
                textView.setText(i.uNT);
            }
            listView.addHeaderView(inflate);
        }
        this.okJ.setVisibility(i);
    }

    protected final void aXW() {
        super.aXW();
        aWs();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aXW();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
