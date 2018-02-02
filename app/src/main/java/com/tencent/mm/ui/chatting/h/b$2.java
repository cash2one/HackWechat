package com.tencent.mm.ui.chatting.h;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Calendar;

class b$2 implements OnValueChangeListener {
    final /* synthetic */ b yIj;

    b$2(b bVar) {
        this.yIj = bVar;
    }

    public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        x.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", Integer.valueOf(i), Integer.valueOf(i2));
        this.yIj.yId.j(this.yIj.Gj(i2));
        int i3 = Calendar.getInstance().get(11);
        if (i2 == 0) {
            this.yIj.yId.setValue(0);
        } else {
            this.yIj.yId.setValue(i3);
        }
    }
}
