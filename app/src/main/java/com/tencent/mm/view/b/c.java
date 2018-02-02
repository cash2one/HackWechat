package com.tencent.mm.view.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.bo.b;

public final class c extends a {
    public c(Context context, b bVar) {
        super(context, bVar);
    }

    public final Rect cAu() {
        return super.cAu().isEmpty() ? this.zEC : super.cAu();
    }

    public final boolean cAt() {
        return false;
    }

    protected final boolean cAs() {
        return false;
    }

    protected final void onDraw(Canvas canvas) {
        canvas.drawColor(0);
        canvas.setMatrix(this.fhZ);
        this.fhY.onDraw(canvas);
    }
}
