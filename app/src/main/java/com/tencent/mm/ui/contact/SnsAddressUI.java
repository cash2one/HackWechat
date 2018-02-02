package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.p.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI extends MMBaseSelectContactUI {
    private HashSet<String> iiv;
    private List<String> kiU;

    protected final void WT() {
        super.WT();
        this.kiU = new ArrayList();
        Collection F = bh.F(bh.az(getIntent().getStringExtra("Block_list"), "").split(","));
        Collection cwj = s.cwj();
        cwj.addAll(F);
        this.kiU.addAll(cwj);
        this.kiU.addAll(s.cwk());
        this.iiv = new HashSet();
        String az = bh.az(getIntent().getStringExtra("Select_Contact"), "");
        if (!bh.ov(az)) {
            this.iiv.addAll(bh.F(az.split(",")));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.SnsAddressUI", "Create!");
        a(1, getString(R.l.dFU), new 1(this), b.xJz);
        setBackBtn(new 2(this));
        Iterator it = this.iiv.iterator();
        while (it.hasNext()) {
            this.ooa.Sg((String) it.next());
        }
        this.ooa.vkz = new 3(this);
        WZ();
    }

    public final void ja(int i) {
        n cvZ = cvZ();
        a Gm = cvZ.Gm(i - this.prJ.getHeaderViewsCount());
        if (Gm != null && Gm.jLe != null) {
            x.i("MicroMsg.SnsAddressUI", "ClickUser=%s", new Object[]{Gm.jLe.field_username});
            String str = Gm.jLe.field_username;
            cwf();
            if (this.iiv.contains(str)) {
                this.iiv.remove(str);
                this.ooa.Sg(str);
            } else if (this.iiv.size() < v.xmH) {
                this.iiv.add(str);
                this.ooa.Sg(str);
            } else {
                Toast.makeText(this, R.l.ePU, 0).show();
                x.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", new Object[]{Integer.valueOf(v.xmH)});
            }
            WZ();
            cvZ.notifyDataSetChanged();
        }
    }

    protected final boolean WU() {
        return false;
    }

    protected final boolean WV() {
        return true;
    }

    protected final String WW() {
        return bh.az(getIntent().getStringExtra("Add_address_titile"), "");
    }

    protected final o WX() {
        c.a aVar = new c.a();
        aVar.yQX = true;
        aVar.yRe = true;
        aVar.yRg = getString(R.l.dDc);
        aVar.yRf = bh.az(getIntent().getStringExtra("Add_get_from_sns"), "");
        return new c(this, this.kiU, true, aVar);
    }

    protected final m WY() {
        return new q(this, this.kiU, true, this.scene);
    }

    private void WZ() {
        String format;
        boolean z;
        if (this.iiv.size() == 0) {
            format = String.format("%s", new Object[]{getString(R.l.dFU)});
        } else {
            format = String.format("%s(%d/%d)", new Object[]{getString(R.l.dFU), Integer.valueOf(this.iiv.size()), Integer.valueOf(v.xmH)});
        }
        updateOptionMenuText(1, format);
        if (this.iiv.size() >= 0) {
            z = true;
        } else {
            z = false;
        }
        enableOptionMenu(1, z);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 3:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (bh.ov(stringExtra)) {
                        x.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    x.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", new Object[]{stringExtra});
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        String str = split[i3];
                        if (this.iiv.add(str)) {
                            this.ooa.Sg(str);
                        }
                        i3++;
                    }
                    WZ();
                    cvZ().notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
    }

    protected final boolean aZc() {
        return true;
    }

    protected final void En(String str) {
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        Collection hashSet = new HashSet();
        hashSet.addAll(this.iiv);
        intent.putExtra("always_select_contact", bh.d(new ArrayList(hashSet), ","));
        intent.putExtra("list_attr", s.p(16384, 64));
        startActivityForResult(intent, 3);
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

    public final void oE(String str) {
        this.iiv.remove(str);
        cvZ().notifyDataSetChanged();
        WZ();
    }
}
