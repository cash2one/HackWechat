package com.tencent.ugc;

import android.os.Bundle;

public interface TXRecordCommon$ITXVideoRecordListener {
    void onRecordComplete(TXRecordCommon$TXRecordResult tXRecordCommon$TXRecordResult);

    void onRecordEvent(int i, Bundle bundle);

    void onRecordProgress(long j);
}
