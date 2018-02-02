package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout;

public class TestTimeForChatting extends DrawedCallBackLinearLayout {
    public final String TAG = "MicroMsg.TestTimeForChatting";
    public int gTs = 0;
    public a zno;
    public int znp = 0;
    public int znq = 0;

    public TestTimeForChatting(Context context) {
        super(context);
    }

    public TestTimeForChatting(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onDraw(canvas);
        x.i("MicroMsg.TestTimeForChatting", (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void cyc() {
        x.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", Integer.valueOf(this.gTs));
        g.pQN.h(11198, Integer.valueOf(this.gTs));
    }

    protected void dispatchDraw(Canvas canvas) {
        this.gTs++;
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.TestTimeForChatting", th, "dispatchDraw", new Object[0]);
        }
        f.vA(9);
        f.vA(18);
        f.vA(25);
        f.vA(24);
        f.vA(20);
        f.vA(18);
        if (this.zno != null) {
            this.zno.cnA();
        }
    }

    public boolean fitSystemWindows(Rect rect) {
        x.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", rect.toString(), Integer.valueOf(this.znp), Integer.valueOf(this.znq));
        rect.bottom += this.znp;
        rect.right += this.znq;
        return super.fitSystemWindows(rect);
    }
}
