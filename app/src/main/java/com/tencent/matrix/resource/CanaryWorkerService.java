package com.tencent.matrix.resource;

import android.app.IntentService;
import android.content.Intent;

public class CanaryWorkerService extends IntentService {
    public CanaryWorkerService() {
        super("Matrix.CanaryWorkerService");
    }

    protected void onHandleIntent(Intent intent) {
    }
}
