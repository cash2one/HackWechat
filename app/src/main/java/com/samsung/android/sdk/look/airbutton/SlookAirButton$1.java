package com.samsung.android.sdk.look.airbutton;

import android.view.View;
import com.samsung.android.airbutton.AirButtonImpl.OnItemSelectedListener;

class SlookAirButton$1 implements OnItemSelectedListener {
    final /* synthetic */ SlookAirButton this$0;

    SlookAirButton$1(SlookAirButton slookAirButton) {
        this.this$0 = slookAirButton;
    }

    public void onItemSelected(View view, int i, Object obj) {
        SlookAirButton.access$000(this.this$0).onItemSelected(view, i, obj);
    }
}
