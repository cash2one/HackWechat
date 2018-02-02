package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView extends LinearLayout {
    String jKk;
    private TextView lVn;
    private MMHorList lVo;
    private a lVp;
    private ArrayList<String> lVq;

    public ExdeviceProfileAffectedUserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.dgS, this, true);
        this.lVn = (TextView) inflate.findViewById(R.h.cDL);
        this.lVo = (MMHorList) inflate.findViewById(R.h.cDK);
        this.lVo.ybJ = true;
        int fromDPToPix = a.fromDPToPix(context, 44);
        this.lVo.ybK = true;
        this.lVo.ybL = fromDPToPix;
        this.lVo.ybJ = true;
        this.lVp = new a(this, (byte) 0);
        this.lVo.setAdapter(this.lVp);
        this.lVo.setOnItemClickListener(new 1(this, context));
        this.lVn.setOnClickListener(new 2(this));
        setOnClickListener(new 3(this));
        setVisibility(8);
    }

    public final void v(ArrayList<String> arrayList) {
        this.lVq = arrayList;
        if (this.lVq == null || this.lVq.size() == 0) {
            this.lVn.setText("");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lVn.setText(getResources().getString(R.l.edv, new Object[]{Integer.valueOf(this.lVq.size())}));
        this.lVp.notifyDataSetChanged();
    }
}
