package com.tencent.mm.remoteservice;

import android.os.Bundle;
import android.os.IInterface;

public interface b extends IInterface {
    void onCallback(String str, Bundle bundle, boolean z);
}
