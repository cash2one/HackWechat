package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget extends LinearLayout {
    private View contentView;
    private Activity iQz;
    private ImageView rrj;
    private TextView rrk;
    private PreviewContactView rrl;
    SnsUploadConfigView rrm;
    private List<String> rrn = new LinkedList();
    private boolean rro = false;

    static /* synthetic */ void a(AtContactWidget atContactWidget) {
        if (atContactWidget.rrn == null) {
            atContactWidget.rrn = new LinkedList();
        }
        if (atContactWidget.rrm == null || atContactWidget.rrm.bCc() <= 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_Compose", true);
            intent.putExtra("List_Type", 1);
            intent.putExtra("Add_address_titile", atContactWidget.iQz.getString(j.qMO));
            intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
            intent.putExtra("Block_list", q.FS());
            intent.putExtra("Select_Contact", bh.d(atContactWidget.rrn, ","));
            intent.putExtra("sns_address_count", 0);
            a.ifs.a(intent, atContactWidget.iQz, 6);
            return;
        }
        h.h(atContactWidget.iQz, j.qMo, j.dGO);
    }

    @TargetApi(11)
    public AtContactWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public AtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final List<String> byY() {
        if (this.rrn == null) {
            this.rrn = new LinkedList();
        }
        return this.rrn;
    }

    public final void byZ() {
        if (this.rrn == null) {
            this.rrn = new LinkedList();
        }
        this.rrn.clear();
        if (this.rrl != null) {
            this.rrl.bV(this.rrn);
        }
        bza();
        if (this.rrk != null) {
            this.rrk.setVisibility(8);
        }
    }

    private void init(Context context) {
        this.iQz = (Activity) context;
        this.contentView = v.fv(context).inflate(getLayoutResource(), this);
        this.rrl = (PreviewContactView) this.contentView.findViewById(f.qBp);
        this.rrj = (ImageView) this.contentView.findViewById(f.qBq);
        this.rrk = (TextView) this.contentView.findViewById(f.qBr);
        this.contentView.setOnClickListener(new 1(this));
    }

    public final boolean U(Intent intent) {
        String stringExtra = intent.getStringExtra("Select_Contact");
        LinkedList linkedList = new LinkedList();
        List linkedList2;
        if (stringExtra == null || stringExtra.equals("")) {
            linkedList2 = new LinkedList();
        } else {
            linkedList2 = bh.F(stringExtra.split(","));
        }
        if (this.rrn == null) {
            this.rrn = new LinkedList();
        }
        this.rrn.clear();
        for (String stringExtra2 : r0) {
            if (!this.rrn.contains(stringExtra2)) {
                this.rrn.add(stringExtra2);
            }
        }
        if (this.rrl != null) {
            this.rrl.bV(this.rrn);
        }
        if (this.rro) {
            x.d("MicroMsg.AtContactWiget", "withList count " + this.rrn.size());
            if (!this.rro || this.rrk == null || this.rrn.size() <= 0) {
                this.rrk.setVisibility(8);
            } else {
                this.rrk.setVisibility(0);
                if (this.rrn.size() < 100) {
                    this.rrk.setText(this.rrn.size());
                } else {
                    this.rrk.setText(j.eRP);
                }
            }
        }
        bza();
        return true;
    }

    private void bza() {
        if (this.rrn.size() > 0) {
            this.rrj.setImageResource(bzb());
        } else {
            this.rrj.setImageResource(bzc());
        }
    }

    protected int getLayoutResource() {
        return g.qBs;
    }

    protected int bzb() {
        return i.qJd;
    }

    protected int bzc() {
        return i.qJc;
    }
}
