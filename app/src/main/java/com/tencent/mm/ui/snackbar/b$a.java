package com.tencent.mm.ui.snackbar;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.ui.snackbar.SnackContainer.a;
import com.tencent.mm.ui.snackbar.b.c;
import com.tencent.mm.w.a.d;

public class b$a {
    private Context mContext;
    String mMessage;
    private int yg = -1;
    private int zfA = 0;
    private Parcelable zfB;
    private short zfC = (short) 3500;
    b zfL;
    int zfM = 0;
    String zfz;

    public b$a(Activity activity) {
        this.mContext = activity.getApplicationContext();
        this.zfL = new b(activity, this.zfM);
    }

    public b$a(Context context, View view) {
        this.mContext = context;
        this.zfL = new b(context, view, this.zfM);
    }

    public final b$a a(Short sh) {
        this.zfC = sh.shortValue();
        return this;
    }

    public final b cxt() {
        int i;
        String str = this.mMessage;
        String toUpperCase = this.zfz != null ? this.zfz.toUpperCase() : null;
        int i2 = this.zfA;
        Parcelable parcelable = this.zfB;
        short s = this.zfC;
        if (this.yg != -1) {
            i = this.yg;
        } else {
            i = this.mContext.getResources().getColor(d.bui);
        }
        Snack snack = new Snack(str, toUpperCase, i2, parcelable, s, i);
        b bVar = this.zfL;
        ViewParent viewParent = bVar.zfE;
        View view = bVar.mParentView;
        c cVar = bVar.zfG;
        if (!(view.getParent() == null || view.getParent() == viewParent)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        a aVar = new a(snack, view, cVar, (byte) 0);
        viewParent.zfN.offer(aVar);
        if (viewParent.zfN.size() == 1) {
            viewParent.a(aVar, false);
        }
        return this.zfL;
    }
}
