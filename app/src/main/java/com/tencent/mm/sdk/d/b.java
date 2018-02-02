package com.tencent.mm.sdk.d;

import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;

public class b extends c implements Serializable {
    public final String name = getClass().getSimpleName();

    public void enter() {
        super.enter();
        x.i("LogStateTransitionState", "entering " + this.name);
    }

    public void exit() {
        super.exit();
        x.i("LogStateTransitionState", "exiting " + this.name);
    }
}
