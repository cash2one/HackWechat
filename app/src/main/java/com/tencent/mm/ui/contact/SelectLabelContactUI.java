package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.p.b;
import java.util.HashSet;

public class SelectLabelContactUI extends MMBaseSelectContactUI {
    private HashSet<String> iiv;
    private String label;
    private int ldq;
    private HashSet<String> yUk;

    protected final void WT() {
        super.WT();
        this.label = getIntent().getStringExtra("label");
        this.ldq = getIntent().getIntExtra("list_attr", 0);
        this.iiv = new HashSet();
        this.yUk = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bh.ov(stringExtra)) {
            this.yUk.addAll(bh.F(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bh.ov(stringExtra)) {
            this.iiv.addAll(bh.F(stringExtra.split(",")));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (s.fa(this.ldq, 64)) {
            a(1, getString(R.l.dFU), new 1(this), b.xJz);
        }
        WZ();
    }

    public final void ja(int i) {
        int headerViewsCount = i - this.prJ.getHeaderViewsCount();
        n cvZ = cvZ();
        a Gm = cvZ.Gm(headerViewsCount);
        if (Gm != null && Gm.jLe != null) {
            String str = Gm.jLe.field_username;
            x.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", new Object[]{str});
            if (!s.fa(this.ldq, 64)) {
                ZD(str);
            } else if (this.yUk.contains(str) || this.iiv.contains(str) || !s.fa(this.ldq, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || this.yUk.size() + this.iiv.size() < getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE)) {
                if (!this.yUk.contains(str)) {
                    if (this.iiv.contains(str)) {
                        this.iiv.remove(str);
                    } else {
                        this.iiv.add(str);
                    }
                }
                WZ();
                cvZ.notifyDataSetChanged();
            } else {
                h.a(this.mController.xIM, getString(R.l.eJi, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE))}), getString(R.l.dGt), new 2(this));
            }
        }
    }

    private void WZ() {
        if (!s.fa(this.ldq, 64) || this.iiv.size() <= 0) {
            updateOptionMenuText(1, getString(R.l.dFU));
            enableOptionMenu(1, false);
            return;
        }
        updateOptionMenuText(1, getString(R.l.dFU) + "(" + this.iiv.size() + ")");
        enableOptionMenu(1, true);
    }

    private void ZD(String str) {
        if (s.fa(this.ldq, 16384)) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", str);
            setResult(-1, intent);
            finish();
            return;
        }
        intent = new Intent();
        intent.setClass(this, ChattingUI.class);
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        startActivity(intent);
        finish();
    }

    protected final boolean WU() {
        return false;
    }

    protected final boolean WV() {
        return false;
    }

    protected final String WW() {
        return this.label;
    }

    protected final o WX() {
        return new h(this, s.fa(this.ldq, 64), com.tencent.mm.plugin.label.a.a.aUX().Dr(com.tencent.mm.plugin.label.a.a.aUX().Do(this.label)));
    }

    protected final m WY() {
        return null;
    }

    public final boolean a(a aVar) {
        if (!aVar.ySW || aVar.jLe == null) {
            return false;
        }
        return this.iiv.contains(aVar.jLe.field_username);
    }

    public final boolean b(a aVar) {
        if (!aVar.ySW || aVar.jLe == null) {
            return false;
        }
        return this.yUk.contains(aVar.jLe.field_username);
    }
}
