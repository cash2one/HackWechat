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
import java.util.List;

public class ServicePreference extends Preference {
    private Context context;
    List<f> qjF;
    OnItemClickListener rXE;
    private OnItemClickListener rXF;
    private OnClickListener rXG;
    private int rXH;
    private boolean rXI;
    private int rXJ;
    b rXY;

    public ServicePreference(Context context) {
        this(context, null);
    }

    public ServicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ServicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rXE = null;
        this.rXF = null;
        this.rXG = null;
        this.rXI = false;
        this.rXJ = 0;
        this.context = context;
        setLayoutResource(R.i.dav);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.eZs);
        this.rXH = obtainStyledAttributes.getInt(R.n.eZt, 8);
        this.rXI = obtainStyledAttributes.getBoolean(R.n.eZu, false);
        this.rXJ = obtainStyledAttributes.getResourceId(R.n.eZv, 0);
        obtainStyledAttributes.recycle();
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.h.cnW);
        if (mMGridView != null) {
            this.rXY = new b(this.context, this.qjF);
            an.bin().j(this.rXY);
            an.bin().c(this.rXY);
            mMGridView.setAdapter(this.rXY);
            mMGridView.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ServicePreference rXZ;

                {
                    this.rXZ = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.rXZ.rXY.qY(i)) {
                        this.rXZ.rXY.iR(false);
                    } else if (this.rXZ.rXY.rXA) {
                        if (this.rXZ.rXF != null) {
                            this.rXZ.rXF.onItemClick(adapterView, view, i, j);
                        }
                    } else if (this.rXZ.rXE != null) {
                        this.rXZ.rXE.onItemClick(adapterView, view, i, j);
                    }
                }
            });
            if (this.rXI) {
                mMGridView.setOnItemLongClickListener(new 2(this));
            }
            TextView textView = (TextView) view.findViewById(R.h.cet);
            if (this.rXY.getCount() == 0) {
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
    }

    public final f yg(int i) {
        if (i < 0 || i >= this.rXY.getCount()) {
            return null;
        }
        return (f) this.rXY.getItem(i);
    }

    public final void onResume() {
        if (this.rXY != null) {
            an.bin().c(this.rXY);
        }
    }

    public final void onPause() {
        if (this.rXY != null) {
            an.bin().j(this.rXY);
        }
    }
}
