package com.tencent.matrix.resource;

import android.app.IntentService;
import android.content.Intent;

public class CanaryResultService extends IntentService {
    public CanaryResultService() {
        super("Matrix.CanaryResultService");
    }

    protected void onHandleIntent(Intent intent) {
    }
}
