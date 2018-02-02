package com.tencent.map.geolocation.internal;

import android.os.Bundle;

public interface TencentHttpClient {
    Bundle postSync(String str, byte[] bArr);
}
