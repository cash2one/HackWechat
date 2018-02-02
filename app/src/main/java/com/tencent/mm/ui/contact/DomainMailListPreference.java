package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference extends Preference {
    private TextView ihS;
    private boolean lRB;
    private String title;
    private String ySn;
    private TextView ySo;
    private TextView ySp;
    private TextView ySq;

    public DomainMailListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DomainMailListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.lRB = false;
        this.title = "";
        this.ySn = "";
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dny, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.ihS = (TextView) view.findViewById(R.h.title);
        this.ySo = (TextView) view.findViewById(R.h.cie);
        this.ySp = (TextView) view.findViewById(R.h.cKh);
        this.ySq = (TextView) view.findViewById(R.h.cQO);
        this.lRB = true;
        if (this.lRB) {
            this.ihS.setText(t.ou(this.title));
            String[] split = this.ySn.split(";");
            if (t.ou(this.ySn).length() <= 0) {
                this.ySo.setVisibility(8);
                this.ySp.setVisibility(8);
            } else {
                if (split.length > 0) {
                    this.ySo.setVisibility(0);
                    this.ySo.setText(t.ou(split[0]));
                } else {
                    this.ySo.setVisibility(8);
                }
                if (split.length > 1) {
                    this.ySp.setVisibility(0);
                    this.ySp.setText(t.ou(split[1]));
                } else {
                    this.ySp.setVisibility(8);
                }
                if (split.length > 2) {
                    this.ySq.setVisibility(0);
                    this.ySq.setText(t.ou(split[2]));
                }
            }
            this.ySq.setVisibility(8);
        } else {
            x.e("MicroMsg.DomainMailPreference", "initView : unbind view");
        }
        super.onBindView(view);
    }
}
