package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.aro;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;

public class ModRemarkRoomNameUI extends MMActivity implements a {
    private String iQs;
    private r ilH = null;
    private boolean laa = false;
    private c lae = new 1(this);
    private String lbi = "";
    private MMEditText lbj;
    private b lbk;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iQs = getIntent().getStringExtra("RoomInfo_Id");
        com.tencent.mm.sdk.b.a.xef.b(this.lae);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.eEM);
        this.lbj = (MMEditText) findViewById(R.h.cxb);
        final CharSequence ou = bh.ou(getIntent().getStringExtra("room_name"));
        if (bh.ov(ou)) {
            this.lbj.setHint(i.b(this, ((com.tencent.mm.plugin.chatroom.b.b) g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fh().gu(this.iQs), this.lbj.getTextSize()));
            this.lbj.setEllipsize(TruncateAt.END);
        } else {
            this.lbj.setText(i.b(this, ou, this.lbj.getTextSize()));
        }
        this.lbj.setSelection(this.lbj.getText().length());
        this.lbj.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ModRemarkRoomNameUI lbl;

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!ou.equals(charSequence)) {
                    this.lbl.enableOptionMenu(true);
                }
                if (charSequence.length() > 0) {
                    this.lbl.lbj.setEllipsize(null);
                } else {
                    this.lbl.lbj.setEllipsize(TruncateAt.END);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        com.tencent.mm.ui.tools.a.c fi = com.tencent.mm.ui.tools.a.c.d(this.lbj).fi(1, 32);
        fi.znM = false;
        fi.a(null);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ModRemarkRoomNameUI lbl;

            {
                this.lbl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lbl.setResult(0);
                this.lbl.finish();
                return true;
            }
        });
        a(0, getString(R.l.dGx), new OnMenuItemClickListener(this) {
            final /* synthetic */ ModRemarkRoomNameUI lbl;

            {
                this.lbl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lbl.aWs();
                String str = "";
                String zI = com.tencent.mm.k.b.zI();
                if (bh.ov(zI) || !str.matches(".*[" + zI + "].*")) {
                    com.tencent.mm.ui.tools.a.c.d(this.lbl.lbj).fi(1, 32).a(this.lbl);
                    return true;
                }
                h.b(this.lbl.mController.xIM, this.lbl.getString(R.l.epE, new Object[]{zI}), this.lbl.getString(R.l.dGO), true);
                return false;
            }
        }, p.b.xJz);
        enableOptionMenu(false);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xef.c(this.lae);
    }

    protected final int getLayoutId() {
        return R.i.dor;
    }

    public final void uY(String str) {
        this.lbi = str;
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.ilH = h.a(context, getString(R.l.dUD), false, null);
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_aro = new aro();
        com_tencent_mm_protocal_c_aro.vGG = new bdo().UA(bh.ou(this.iQs));
        com_tencent_mm_protocal_c_aro.wzb = new bdo().UA(bh.ou(str));
        this.lbk = new e.a(27, com_tencent_mm_protocal_c_aro);
        this.laa = true;
        ar.Hg();
        com.tencent.mm.z.c.EX().b(this.lbk);
    }

    public final void amI() {
        h.h(this, R.l.eLR, R.l.eLT);
    }

    public final void aem() {
        h.h(this, R.l.eLS, R.l.eLT);
    }
}
