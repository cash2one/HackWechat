package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.z.ak.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class j extends LinearLayout {
    private Context context;
    private String hog;

    public j(Context context, String str) {
        super(context);
        this.context = context;
        this.hog = str;
        View inflate = View.inflate(getContext(), R.i.dgl, this);
        View findViewById = findViewById(R.h.ceB);
        inflate.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ j ySv;

            {
                this.ySv = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("enterprise_from_scene", 2);
                intent.putExtra("enterprise_biz_name", this.ySv.hog);
                d.b(view.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", intent);
            }
        });
        findViewById.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ j ySv;

            {
                this.ySv = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.ySv.context instanceof MMActivity) {
                    ((MMActivity) this.ySv.context).aWs();
                }
                return false;
            }
        });
        ar.Hg();
        af WM = c.EY().WM(this.hog);
        if (WM == null || ((int) WM.gJd) <= 0) {
            x.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", this.hog);
            return;
        }
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(R.h.bNO);
        b.a((ImageView) maskLayout.view, this.hog);
        if (WM.field_verifyFlag == 0) {
            maskLayout.cpP();
        } else if (a.hfN != null) {
            String gP = a.hfN.gP(WM.field_verifyFlag);
            if (gP != null) {
                maskLayout.d(m.kf(gP), MaskLayout.a.yfa);
            } else {
                maskLayout.cpP();
            }
        } else {
            maskLayout.cpP();
        }
        ((TextView) findViewById(R.h.ceC)).setText(WM.AP());
    }
}
