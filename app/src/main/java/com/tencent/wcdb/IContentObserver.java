package com.tencent.wcdb;

import android.net.Uri;
import android.os.IInterface;

public interface IContentObserver extends IInterface {
    void onChange(boolean z, Uri uri);
}
