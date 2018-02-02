package com.tencent.mm.plugin.multitalk.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.p;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.HashSet;

@a(3)
public class MultiTalkSelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private HashSet<String> iiu;
    private HashSet<String> iiv;
    private c oGy = new c<jq>(this) {
        final /* synthetic */ MultiTalkSelectContactUI oHR;

        {
            this.oHR = r2;
            this.xen = jq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jq jqVar = (jq) bVar;
            if ((jqVar instanceof jq) && jqVar.fAq.action == 0) {
                this.oHR.finish();
            }
            return false;
        }
    };
    private boolean oHO;
    private d oHP;
    private boolean oHQ = false;

    protected final void WT() {
        super.WT();
        this.oHO = getIntent().getBooleanExtra("key_need_gallery", false);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!s.eV(this.chatroomName)) {
            finish();
        }
        this.iiv = new HashSet();
        this.iiu = new HashSet();
    }

    protected void initView() {
        super.initView();
        this.oHP = new d(this);
        if (this.oHO) {
            this.oHP.setVisible(true);
        } else {
            this.oHP.setVisible(false);
        }
        int i = R.l.dFU;
        if (this.oHO) {
            i = R.l.ewD;
        }
        a(1, getString(i), new 1(this), p.b.xJz);
        WZ();
        this.ooa.setBackgroundResource(R.e.btn);
        this.ooa.vkv.setTextColor(-1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bh.ov(stringExtra)) {
            this.iiu.addAll(bh.F(stringExtra.split(",")));
        }
        this.iiu.add(q.FS());
        if (this.oHO) {
            this.oHP.FG(q.FS());
        }
        com.tencent.mm.sdk.b.a.xef.b(this.oGy);
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.xef.c(this.oGy);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.doz;
    }

    protected final boolean WU() {
        return false;
    }

    protected final boolean WV() {
        return false;
    }

    protected final String WW() {
        return getIntent().getStringExtra("titile");
    }

    protected final o WX() {
        return new a(this, this.chatroomName);
    }

    protected final m WY() {
        return new b(this, this.chatroomName);
    }

    public final void ja(int i) {
        n cvZ = cvZ();
        com.tencent.mm.ui.contact.a.a Gm = cvZ.Gm(i - this.prJ.getHeaderViewsCount());
        if (Gm != null && Gm.jLe != null) {
            x.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[]{Gm.jLe.field_username});
            String str = Gm.jLe.field_username;
            if (!q.FS().equals(str)) {
                cwf();
                if (this.iiv.contains(str)) {
                    if (this.oHO) {
                        d dVar = this.oHP;
                        if (dVar.size != 0) {
                            int i2;
                            boolean z;
                            boolean z2;
                            int i3 = -1;
                            for (i2 = 0; i2 < dVar.oIo.getChildCount(); i2++) {
                                if (dVar.oIo.getChildAt(i2).getTag().equals(str)) {
                                    i3 = i2;
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                            if (i3 < 0) {
                                i2 = 0;
                                while (i2 < dVar.oIp.getChildCount()) {
                                    if (dVar.oIp.getChildAt(i2).getTag().equals(str)) {
                                        z2 = true;
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            i2 = i3;
                            z2 = false;
                            if (i2 >= 0) {
                                if (z2) {
                                    dVar.oIp.removeViewAt(i2);
                                    dVar.size--;
                                }
                                if (z) {
                                    if (dVar.size <= 5) {
                                        dVar.oIo.removeViewAt(i2);
                                        dVar.size--;
                                    } else {
                                        dVar.oIo.removeViewAt(i2);
                                        View childAt = dVar.oIp.getChildAt(0);
                                        dVar.oIp.removeViewAt(0);
                                        dVar.oIo.addView(childAt);
                                        dVar.size--;
                                    }
                                }
                                dVar.tk(dVar.size);
                                dVar.tl(dVar.size);
                            }
                        }
                    }
                    this.iiv.remove(str);
                } else if (this.iiu.size() + this.iiv.size() == 9) {
                    this.oHQ = true;
                    Toast.makeText(this, R.l.ewA, 0).show();
                    return;
                } else {
                    if (this.oHO) {
                        this.oHP.FG(str);
                    }
                    this.iiv.add(str);
                }
                cvZ.notifyDataSetChanged();
                WZ();
            }
        }
    }

    protected final void aXW() {
        super.aXW();
        aWs();
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ySW || aVar.jLe == null) {
            return false;
        }
        return this.iiv.contains(aVar.jLe.field_username);
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ySW || aVar.jLe == null) {
            return false;
        }
        return this.iiu.contains(aVar.jLe.field_username);
    }

    private void WZ() {
        if (this.iiv.size() > 0) {
            enableOptionMenu(1, true);
        } else {
            enableOptionMenu(1, false);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
