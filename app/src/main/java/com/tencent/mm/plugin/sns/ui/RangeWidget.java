package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RangeWidget extends RelativeLayout {
    private View contentView;
    private Activity iQz;
    private ImageView rrj;
    SnsUploadConfigView rrm;
    private TextView rwr;
    private boolean rws = true;
    int rwt = 0;
    String rwu = "";
    private String rwv = "";
    private String rww = "";
    public int style = 0;

    public RangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public RangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.iQz = (Activity) context;
        this.contentView = View.inflate(context, getLayoutResource(), this);
        this.rwr = (TextView) this.contentView.findViewById(f.qFw);
        this.rrj = (ImageView) this.contentView.findViewById(f.qDb);
        this.contentView.setOnClickListener(new 1(this));
    }

    private static List<String> ar(List<String> list) {
        List<String> linkedList = new LinkedList();
        g.Dk();
        if (!g.Dh().Cy()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            g.Dk();
            a WO = ((h) g.h(h.class)).EY().WO(obj2);
            if (!(WO == null || ((int) WO.gJd) == 0)) {
                obj2 = WO.AQ();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public boolean a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        String d;
        this.rwt = intent.getIntExtra("Ktag_range_index", 0);
        this.rwv = intent.getStringExtra("Klabel_name_list");
        this.rww = intent.getStringExtra("Kother_user_name_list");
        int bzZ = bzZ();
        Object obj = "";
        if (!bh.ov(this.rwv)) {
            obj = obj + this.rwv;
        }
        if (!bh.ov(this.rww)) {
            d = bh.d(ar(Arrays.asList(this.rww.split(","))), ",");
            if (obj.length() > 0) {
                obj = obj + "," + d;
            } else {
                obj = obj + d;
            }
        }
        if (!(bzZ == -1 || obj == null || obj.length() <= bzZ)) {
            obj = obj.substring(0, bzZ) + "...";
        }
        bzZ = this.rwt;
        if (this.rrj != null) {
            this.rrj.setImageResource(i.qJj);
        }
        if (this.rrm != null) {
            this.rrm.iN(false);
        }
        switch (bzZ) {
            case 0:
                if (this.rrj != null) {
                    this.rrj.setImageResource(i.qJi);
                }
                this.rwr.setText(j.qLr);
                break;
            case 1:
                if (this.rrm != null) {
                    this.rrm.iN(true);
                }
                if (!(atContactWidget == null || this.rrm == null || atContactWidget.byY().size() <= 0)) {
                    com.tencent.mm.ui.base.h.h(this.iQz, j.qMo, j.dGO);
                    atContactWidget.byZ();
                    this.rrm.bBZ();
                }
                this.rwr.setText(j.qLp);
                break;
            case 2:
                this.rwr.setText(obj);
                break;
            case 3:
                TextView textView = this.rwr;
                d = this.iQz.getString(j.qLd);
                obj = d + "  " + obj;
                CharSequence spannableString = new SpannableString(obj);
                spannableString.setSpan(new ForegroundColorSpan(-65536), d.length() + 2, obj.length(), 33);
                textView.setText(spannableString);
                break;
        }
        return true;
    }

    protected int getLayoutResource() {
        return com.tencent.mm.plugin.sns.i.g.qGF;
    }

    protected int bzZ() {
        return -1;
    }
}
