package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mm.ui.chatting.p.a;
import com.tencent.mm.ui.chatting.viewitems.ar;

public class p$b implements OnClickListener, OnTouchListener, b {
    private View Iv;
    private ak ikI;
    private int jNd;
    private q ysA;
    private View ysB;
    private View ysC;
    private int ysD;
    private int ysE;
    private int ysF;
    private int ysG;
    private int ysH;
    private boolean ysI;
    private a ysJ = new a();
    private OnTouchListener ysK = new 1(this);
    private View ysL;
    private int ysM = 300;
    private ak.a ysN = new 2(this);

    private void dismiss() {
        if (this.ysA != null) {
            this.ysA.dismiss();
        }
    }

    public final boolean d(View view, MotionEvent motionEvent) {
        Object tag = view.getTag();
        if (tag == null || !(tag instanceof ar)) {
            x.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
            return false;
        }
        boolean z;
        ar arVar = (ar) view.getTag();
        String str = arVar.userName;
        String FS = com.tencent.mm.z.q.FS();
        if (t.ov(FS) || FS.equals(str)) {
            x.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        Context context = view.getContext();
        if (this.ysA == null) {
            Resources resources = context.getResources();
            this.ysD = (int) ((resources.getDimension(R.f.buo) * 2.0f) + resources.getDimension(R.f.bvC));
            this.Iv = View.inflate(context, R.i.ddc, null);
            this.ysB = this.Iv.findViewById(R.h.cUD);
            this.ysC = this.Iv.findViewById(R.h.bLs);
            this.ysC.setOnClickListener(this);
            this.ysB.setOnClickListener(this);
            this.ysC.setOnTouchListener(this.ysK);
            this.ysB.setOnTouchListener(this.ysK);
            this.ysA = new q(this.Iv, -2, this.ysD, false);
            this.ysA.setOutsideTouchable(true);
            Rect rect = new Rect();
            if (context instanceof Activity) {
                ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            }
            this.jNd = rect.top;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                this.ysE = context.getResources().getDimensionPixelSize(R.f.buF);
            } else {
                this.ysE = context.getResources().getDimensionPixelSize(R.f.buG);
            }
            this.ysA.setBackgroundDrawable(new ColorDrawable(16777215));
            this.ysH = 0;
            this.ikI = new ak(Looper.getMainLooper(), this.ysN, false);
            x.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
        }
        q qVar = this.ysA;
        switch (motionEvent.getAction()) {
            case 9:
                this.ysL = view;
                view.setOnTouchListener(this);
                if (qVar.isShowing()) {
                    qVar.dismiss();
                }
                if (!this.ysI) {
                    this.ysC.setTag(arVar);
                    this.ysB.setTag(arVar);
                    this.ysC.setVisibility(0);
                    this.ysB.setVisibility(8);
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int i = iArr[1];
                    view.getWidth();
                    int height = view.getHeight();
                    this.ysG = this.ysH;
                    if (i > (this.jNd + this.ysE) + this.ysD) {
                        this.ysG = ((-height) - this.ysD) - this.ysH;
                    }
                    this.ysF = 0;
                    if (this.ysG >= 0) {
                        this.Iv.setBackgroundResource(R.g.bBb);
                    } else {
                        this.Iv.setBackgroundResource(R.g.bBc);
                    }
                    long j = (long) this.ysM;
                    this.ikI.J(j, j);
                    break;
                }
                break;
            case 10:
                this.ysI = false;
                this.ysL = null;
                break;
        }
        return true;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.ysI = true;
                break;
            case 3:
                break;
        }
        dismiss();
        return false;
    }

    public final void onClick(View view) {
        ar arVar = (ar) view.getTag();
        if (view == this.ysC) {
            p.p(view.getContext(), arVar.userName, 3);
        } else {
            p.p(view.getContext(), arVar.userName, 2);
        }
        dismiss();
    }
}
