package com.tencent.recovery;

import com.tencent.recovery.model.RecoveryStatusItem;
import java.util.ArrayList;

public final class RecoveryContext {
    public ArrayList<RecoveryStatusItem> zRk = new ArrayList();

    public final String toString() {
        return this.zRk.toString();
    }
}
