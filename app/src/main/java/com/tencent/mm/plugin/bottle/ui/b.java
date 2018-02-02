package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.k;

public final class b extends k {
    TextView imw = ((TextView) this.view.findViewById(R.h.bOd));
    private Button kBV = ((Button) this.view.findViewById(R.h.bOc));
    private View view;

    public b(Context context) {
        super(context, R.m.eYZ);
        this.view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.i.dbu, null);
        setContentView(this.view, new LayoutParams(-2, -2));
        this.kBV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b kBW;

            {
                this.kBW = r1;
            }

            public final void onClick(View view) {
                this.kBW.dismiss();
            }
        });
    }
}
