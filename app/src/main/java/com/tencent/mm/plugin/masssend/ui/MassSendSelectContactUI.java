package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MassSendSelectContactUI extends MMBaseSelectContactUI {
    private HashSet<String> iiv;
    private List<String> kiU;
    private Button onY;
    private boolean onZ;
    private MultiSelectContactView ooa;

    protected final void WT() {
        super.WT();
        this.kiU = new ArrayList();
        this.kiU.addAll(s.cwj());
        this.kiU.addAll(s.cwk());
        this.kiU.add(q.FS());
        this.iiv = new HashSet();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.MassSendSelectContactUI", "create!");
        this.ooa = this.ooa;
        if (this.ooa == null) {
            finish();
            return;
        }
        this.ooa.setBackgroundDrawable(null);
        a(1, getString(R.l.cvp), new 1(this), b.xJz);
        this.onY = (Button) findViewById(R.h.cKB);
        this.onY.setOnClickListener(new 2(this));
        this.ooa.vkz = new 3(this);
        ss(this.iiv.size());
    }

    private void ss(int i) {
        if (i > 0) {
            updateOptionMenuText(1, getString(R.l.cvp) + "(" + this.iiv.size() + ")");
            enableOptionMenu(1, true);
            return;
        }
        updateOptionMenuText(1, getString(R.l.cvp));
        enableOptionMenu(1, false);
    }

    protected final void En(String str) {
        g.pQN.h(11225, Integer.valueOf(1), Integer.valueOf(0));
        Intent intent = new Intent();
        intent.putExtra("label", str);
        intent.putExtra("always_select_contact", bh.d(new ArrayList(this.iiv), ","));
        intent.putExtra("list_attr", s.p(new int[]{16384, 64}));
        d.a(this, ".ui.contact.SelectLabelContactUI", intent, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            switch (i) {
                case 0:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (bh.ov(stringExtra)) {
                        x.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    x.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        String str = split[i3];
                        if (this.iiv.add(str)) {
                            this.ooa.Sg(str);
                        }
                        i3++;
                    }
                    ss(this.iiv.size());
                    cvZ().notifyDataSetChanged();
                    if (this.lcZ != null) {
                        this.lcZ.clearFocus();
                        this.lcZ.cxX();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dnf;
    }

    public final void ja(int i) {
        n cvZ = cvZ();
        a Gm = cvZ.Gm(i - this.prJ.getHeaderViewsCount());
        if (Gm != null && Gm.jLe != null) {
            x.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", Gm.jLe.field_username);
            String str = Gm.jLe.field_username;
            cwf();
            if (this.iiv.contains(str)) {
                this.iiv.remove(str);
                this.ooa.Sg(str);
            } else {
                this.iiv.add(str);
                this.ooa.Sg(str);
            }
            ss(this.iiv.size());
            cvZ.notifyDataSetChanged();
            cwf();
            cwg();
        }
    }

    protected final boolean WU() {
        return false;
    }

    protected final boolean WV() {
        return true;
    }

    protected final String WW() {
        return getString(R.l.euN);
    }

    protected final o WX() {
        c.a aVar = new c.a();
        aVar.yQX = true;
        return new c(this, this.kiU, true, aVar);
    }

    protected final m WY() {
        return new com.tencent.mm.ui.contact.q(this, this.kiU, true, this.scene);
    }

    public final boolean a(a aVar) {
        if (!aVar.ySW || aVar.jLe == null) {
            return false;
        }
        return this.iiv.contains(aVar.jLe.field_username);
    }

    public final int[] aXV() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    protected final boolean aZc() {
        return true;
    }
}
