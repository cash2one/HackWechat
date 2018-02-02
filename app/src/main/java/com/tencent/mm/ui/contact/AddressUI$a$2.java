package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$2 implements OnTouchListener {
    final /* synthetic */ a yQF;

    AddressUI$a$2(a aVar) {
        this.yQF = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.yQF.hideVKB();
                a.a(this.yQF, (int) motionEvent.getRawX());
                a.b(this.yQF, (int) motionEvent.getRawY());
                break;
        }
        return false;
    }
}
