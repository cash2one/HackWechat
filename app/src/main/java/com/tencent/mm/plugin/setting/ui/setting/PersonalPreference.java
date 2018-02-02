package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference extends Preference {
    private String fDB;
    private String gfN;
    Bitmap hkT = null;
    private TextView kEZ = null;
    ImageView mxV = null;
    private TextView qhg = null;
    int qhh = -1;
    String qhi = null;
    private OnClickListener qhj;
    private String username;

    public PersonalPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PersonalPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnt);
        setWidgetLayoutResource(R.i.dod);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.dnH, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        if (this.mxV == null) {
            this.mxV = (ImageView) view.findViewById(R.h.cpk);
        }
        if (this.hkT != null) {
            this.mxV.setImageBitmap(this.hkT);
        } else if (this.qhh > 0) {
            this.mxV.setImageResource(this.qhh);
        } else if (this.qhi != null) {
            b.a(this.mxV, this.qhi);
        }
        this.mxV.setOnClickListener(this.qhj);
        if (!(this.kEZ == null || this.fDB == null)) {
            this.kEZ.setText(i.b(this.mContext, this.fDB, this.kEZ.getTextSize()));
        }
        if (this.qhg != null) {
            String str = bh.ov(this.gfN) ? this.username : this.gfN;
            if (bh.ov(this.gfN) && x.WB(this.username)) {
                this.qhg.setVisibility(8);
            }
            this.qhg.setText(this.mContext.getString(R.l.dFe) + str);
        }
        super.onBindView(view);
    }
}
