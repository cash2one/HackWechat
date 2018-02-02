package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class ChattingUILayout extends BasePanelKeybordLayout {
    private ChatFooterBottom vrn;

    public ChattingUILayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ChatFooterBottom i(ViewGroup viewGroup) {
        if (this.vrn != null) {
            return this.vrn;
        }
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return this.vrn;
        }
        int i = 0;
        while (i < viewGroup.getChildCount()) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ChatFooterBottom) {
                this.vrn = (ChatFooterBottom) childAt;
                return this.vrn;
            } else if ((childAt instanceof ViewGroup) && i((ViewGroup) childAt) != null) {
                return this.vrn;
            } else {
                i++;
            }
        }
        return this.vrn;
    }

    protected final List<View> aXT() {
        List<View> arrayList = new ArrayList();
        arrayList.add(i(this));
        return arrayList;
    }
}
