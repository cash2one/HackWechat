package com.tencent.mm.ui;

import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.sdk.platformtools.bh;

class AddressView$1 extends a {
    final /* synthetic */ AddressView xDC;

    AddressView$1(AddressView addressView) {
        this.xDC = addressView;
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        Object contentDescription = this.xDC.getContentDescription();
        if (bh.ov((String) contentDescription)) {
            contentDescription = this.xDC.nickName;
        }
        accessibilityEvent.getText().add(contentDescription);
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        CharSequence contentDescription = this.xDC.getContentDescription();
        if (bh.ov((String) contentDescription)) {
            contentDescription = this.xDC.nickName;
        }
        bVar.setText(contentDescription);
    }
}
