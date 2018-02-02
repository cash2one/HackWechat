package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public class HomeUI$FitSystemWindowLayoutView extends FrameLayout {
    private Rect fD = new Rect();
    public int xGG;
    public ViewGroup xGH = null;

    public HomeUI$FitSystemWindowLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HomeUI$FitSystemWindowLayoutView(Context context) {
        super(context);
    }

    @TargetApi(14)
    public boolean fitSystemWindows(Rect rect) {
        View childAt;
        boolean fitSystemWindows;
        x.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d", new Object[]{rect.toString(), Integer.valueOf(this.xGG), Integer.valueOf(hashCode())});
        this.xGG = rect.top;
        if (this.xGH != null && (this.xGH.getLayoutParams() instanceof MarginLayoutParams)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.xGH.getLayoutParams();
            int i = marginLayoutParams.bottomMargin;
            int i2 = marginLayoutParams.rightMargin;
            x.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            int i3 = 0;
            while (i3 < getChildCount()) {
                childAt = getChildAt(i3);
                if (childAt instanceof TestTimeForChatting) {
                    TestTimeForChatting testTimeForChatting = (TestTimeForChatting) childAt;
                    if (Float.compare((float) i, ((float) a.fromDPToPix(testTimeForChatting.getContext(), 48)) * DownloadHelper.SAVE_FATOR) > 0 || i < 0) {
                        x.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[]{Integer.valueOf(i)});
                        testTimeForChatting.znp = 0;
                    } else {
                        testTimeForChatting.znp = i;
                    }
                    if (Float.compare((float) i2, ((float) a.fromDPToPix(testTimeForChatting.getContext(), 48)) * DownloadHelper.SAVE_FATOR) > 0 || i2 < 0) {
                        x.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[]{Integer.valueOf(i)});
                        testTimeForChatting.znq = 0;
                    } else {
                        testTimeForChatting.znq = i2;
                    }
                    x.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    ae.w(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                } else {
                    i3++;
                }
            }
            ae.w(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        this.fD.set(rect);
        if (d.fM(14)) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                childAt = getChildAt(i4);
                if (childAt instanceof TestTimeForChatting) {
                    childAt.setFitsSystemWindows(true);
                    fitSystemWindows = ((TestTimeForChatting) childAt).fitSystemWindows(rect);
                    childAt.setFitsSystemWindows(false);
                    break;
                }
            }
        }
        fitSystemWindows = false;
        x.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", new Object[]{Boolean.valueOf(fitSystemWindows), Integer.valueOf(VERSION.SDK_INT)});
        x.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", new Object[]{Boolean.valueOf(super.fitSystemWindows(this.fD))});
        return super.fitSystemWindows(this.fD);
    }
}
