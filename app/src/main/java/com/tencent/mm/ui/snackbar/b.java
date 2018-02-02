package com.tencent.mm.ui.snackbar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public final class b {
    af mHandler = new af();
    View mParentView;
    SnackContainer zfE;
    b zfF;
    c zfG;
    private final OnClickListener zfH = new 2(this);

    public b(Activity activity, int i) {
        View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        if (childAt == null) {
            childAt = activity.findViewById(16908290);
        }
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        layoutInflater.inflate(h.gYd, (ViewGroup) childAt);
        a((ViewGroup) childAt, layoutInflater.inflate(h.gYe, (ViewGroup) childAt, false), i, activity);
    }

    public b(Context context, View view, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        layoutInflater.inflate(h.gYd, (ViewGroup) view);
        a((ViewGroup) view, layoutInflater.inflate(h.gYe, (ViewGroup) view, false), i, context);
    }

    private void a(ViewGroup viewGroup, View view, int i, Context context) {
        boolean z;
        this.zfE = (SnackContainer) viewGroup.findViewById(g.gWn);
        if (this.zfE == null) {
            this.zfE = new SnackContainer(viewGroup);
        }
        this.mParentView = view;
        if (i == 36) {
            this.zfE.setOnTouchListener(new 1(this));
        }
        ((TextView) view.findViewById(g.gWm)).setOnClickListener(this.zfH);
        x.i("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", new Object[]{Boolean.valueOf(ae.fy(context)), Integer.valueOf(ae.fx(context))});
        Activity activity = (Activity) context;
        if (d.fM(19)) {
            LayoutParams attributes = activity.getWindow().getAttributes();
            if (attributes.flags == ((attributes.flags & -134217729) | 134217728)) {
                z = true;
                x.i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", new Object[]{Boolean.valueOf(z)});
                if (z && r3) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(g.gWl);
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) linearLayout.getLayoutParams();
                    marginLayoutParams.bottomMargin = r4;
                    linearLayout.setLayoutParams(marginLayoutParams);
                    return;
                }
            }
        }
        z = false;
        x.i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", new Object[]{Boolean.valueOf(z)});
        if (z) {
        }
    }
}
