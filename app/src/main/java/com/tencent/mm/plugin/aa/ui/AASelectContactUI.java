package com.tencent.mm.plugin.aa.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AASelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private HashSet<String> iiu;
    private HashSet<String> iiv;
    private long iiw;
    private int iix;
    private CheckBox iiy;
    private View iiz;
    private String title;

    static /* synthetic */ void a(AASelectContactUI aASelectContactUI, List list) {
        if (aASelectContactUI.iiv != null) {
            aASelectContactUI.iiv.clear();
        } else {
            aASelectContactUI.iiv = new HashSet();
        }
        aASelectContactUI.iiv.addAll(list);
        aASelectContactUI.iiy.setChecked(true);
        aASelectContactUI.cvZ().notifyDataSetChanged();
    }

    protected final void WT() {
        super.WT();
        this.title = getIntent().getStringExtra("titile");
        this.iiw = getIntent().getLongExtra("max_select_num", 20);
        this.iix = getIntent().getIntExtra("select_type", 1);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!s.eV(this.chatroomName)) {
            x.i("MicroMsg.AASelectContactUI", "is single chat");
        }
        this.iiv = new HashSet();
        this.iiu = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bh.ov(stringExtra)) {
            this.iiu.addAll(Arrays.asList(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bh.ov(stringExtra)) {
            this.iiv.addAll(bh.F(stringExtra.split(",")));
            WZ();
        }
        this.iiy = (CheckBox) findViewById(a$f.uxi);
        this.iiz = findViewById(a$f.uxj);
        this.iiz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AASelectContactUI iiA;

            {
                this.iiA = r1;
            }

            public final void onClick(View view) {
                if (this.iiA.iiy.isChecked()) {
                    if (this.iiA.iiv != null) {
                        this.iiA.iiv.clear();
                    } else {
                        this.iiA.iiv = new HashSet();
                    }
                    this.iiA.iiy.setChecked(false);
                    this.iiA.cvZ().notifyDataSetChanged();
                } else {
                    List oA = h.oA(this.iiA.chatroomName);
                    if (((long) oA.size()) > this.iiA.iiw) {
                        com.tencent.mm.ui.base.h.a(this.iiA.mController.xIM, this.iiA.getString(i.uHm, new Object[]{Long.valueOf(this.iiA.iiw)}), "", new 1(this, oA), new 2(this));
                    } else {
                        AASelectContactUI.a(this.iiA, oA);
                    }
                }
                g.pQN.h(13721, Integer.valueOf(2), Integer.valueOf(6));
            }
        });
        if (this.iiv.size() == h.oA(this.chatroomName).size()) {
            this.iiy.setChecked(true);
        } else {
            this.iiy.setChecked(false);
        }
        this.iiy.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ AASelectContactUI iiA;

            {
                this.iiA = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.iiA.WZ();
            }
        });
    }

    protected final void initView() {
        super.initView();
        a(1, getString(i.dFU), new 3(this), b.xJz);
        WZ();
        this.ooa.vkz = this;
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ AASelectContactUI iiA;

            {
                this.iiA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.iiA.iiv == null || this.iiA.iiv.size() <= 0 || ((long) this.iiA.iiv.size()) > this.iiA.iiw || (this.iiA.iiv.size() == 1 && this.iiA.iiv.contains(q.FS()))) {
                    this.iiA.finish();
                } else {
                    com.tencent.mm.ui.base.h.a(this.iiA, this.iiA.getString(i.uHl), null, this.iiA.getString(i.uHo), this.iiA.getString(i.uHn), false, new 1(this), new 2(this));
                }
                g.pQN.h(13721, Integer.valueOf(2), Integer.valueOf(7));
                return true;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bh.ov(stringExtra)) {
            this.iiu.addAll(bh.F(stringExtra.split(",")));
        }
    }

    protected final boolean WU() {
        return false;
    }

    protected final boolean WV() {
        return false;
    }

    protected final String WW() {
        return this.title;
    }

    protected final o WX() {
        return new d(this, this.chatroomName);
    }

    protected final m WY() {
        return new e(this, this.chatroomName);
    }

    public final void ja(int i) {
        n cvZ = cvZ();
        a Gm = cvZ.Gm(i - this.prJ.getHeaderViewsCount());
        if (Gm != null && Gm.jLe != null) {
            x.i("MicroMsg.AASelectContactUI", "ClickUser=%s", Gm.jLe.field_username);
            String str = Gm.jLe.field_username;
            if (str.equals(q.FS())) {
                g.pQN.h(13721, Integer.valueOf(2), Integer.valueOf(4));
            } else {
                g.pQN.h(13721, Integer.valueOf(2), Integer.valueOf(5));
            }
            cwf();
            if (this.iiv.contains(str)) {
                this.iiv.remove(str);
            } else {
                this.iiv.add(str);
            }
            if (this.iiv.size() == h.oA(this.chatroomName).size()) {
                this.iiy.setChecked(true);
            } else {
                this.iiy.setChecked(false);
            }
            cvZ.notifyDataSetChanged();
            WZ();
        }
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
        return this.iiu.contains(aVar.jLe.field_username);
    }

    private void WZ() {
        if (this.iiv.size() > 0) {
            updateOptionMenuText(1, getString(i.uGT, new Object[]{Integer.valueOf(this.iiv.size())}));
        } else {
            updateOptionMenuText(1, getString(i.dFU));
        }
        if (this.iiv.size() == 1 && this.iiv.contains(q.FS())) {
            enableOptionMenu(1, false);
        } else {
            enableOptionMenu(1, true);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final void oE(String str) {
        this.iiv.remove(str);
        cvZ().notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uAV;
    }
}
