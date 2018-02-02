package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;

public class AppPreference extends Preference {
    private Context context;
    int rXB;
    a rXD;
    OnItemClickListener rXE;
    OnItemClickListener rXF;
    private OnClickListener rXG;
    private int rXH;
    private boolean rXI;
    private int rXJ;

    public AppPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rXE = null;
        this.rXF = null;
        this.rXG = null;
        this.rXB = 0;
        this.rXI = false;
        this.rXJ = 0;
        this.context = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.eZs);
        this.rXH = obtainStyledAttributes.getInt(R.n.eZt, 8);
        this.rXI = obtainStyledAttributes.getBoolean(R.n.eZu, false);
        this.rXJ = obtainStyledAttributes.getResourceId(R.n.eZv, 0);
        obtainStyledAttributes.recycle();
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.h.cnW);
        this.rXD = new a(this.context, this.rXB);
        mMGridView.setAdapter(this.rXD);
        mMGridView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ AppPreference rXK;

            {
                this.rXK = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.rXK.rXD.qY(i)) {
                    this.rXK.rXD.iR(false);
                } else if (this.rXK.rXD.rXA) {
                    if (this.rXK.rXF != null) {
                        this.rXK.rXF.onItemClick(adapterView, view, i, j);
                    }
                } else if (this.rXK.rXE != null) {
                    this.rXK.rXE.onItemClick(adapterView, view, i, j);
                }
            }
        });
        if (this.rXI) {
            mMGridView.setOnItemLongClickListener(new 2(this));
        }
        TextView textView = (TextView) view.findViewById(R.h.cet);
        if (this.rXD.getCount() == 0) {
            textView.setVisibility(0);
            textView.setText(this.rXJ);
            mMGridView.setVisibility(8);
        } else {
            textView.setVisibility(8);
            mMGridView.setVisibility(0);
        }
        Button button = (Button) view.findViewById(R.h.bOX);
        button.setVisibility(this.rXH);
        button.setOnClickListener(this.rXG);
    }

    public final f yg(int i) {
        if (i < 0 || i >= this.rXD.getCount()) {
            return null;
        }
        return (f) this.rXD.getItem(i);
    }

    public final void onResume() {
        if (this.rXD != null) {
            an.bin().c(this.rXD);
        }
    }

    public final void onPause() {
        if (this.rXD != null) {
            an.bin().j(this.rXD);
        }
    }
}
