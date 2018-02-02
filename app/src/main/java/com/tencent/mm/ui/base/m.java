package com.tencent.mm.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.l;

public final class m extends AlertDialog {
    private ListView Fv;
    private View kND;
    public BaseAdapter kPo;
    private Context mContext;
    private CharSequence uU;
    public OnItemClickListener vwr;

    public m(Context context) {
        super(context, l.eYV);
        this.mContext = context;
        if (a.ey(this.mContext)) {
            this.kND = View.inflate(this.mContext, h.gXB, null);
        } else {
            this.kND = View.inflate(this.mContext, h.gXA, null);
        }
        this.Fv = (ListView) this.kND.findViewById(g.list);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.kND);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.uU = charSequence;
        } else {
            this.uU = null;
        }
    }

    public final void show() {
        if (this.uU != null) {
            this.uU.length();
        }
        if (this.vwr != null) {
            this.Fv.setOnItemClickListener(this.vwr);
        }
        if (this.kPo != null) {
            this.Fv.setAdapter(this.kPo);
        }
        super.show();
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.MMListDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
