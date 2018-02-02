package com.tencent.rtmp.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class TXScreenCapture$TXScreenCaptureAssistantActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        a();
    }

    @TargetApi(21)
    public void a() {
        try {
            startActivityForResult((Intent) getIntent().getParcelableExtra("TXScreenCapture.ScreenCaptureIntent"), 1001);
        } catch (Exception e) {
            Intent intent = new Intent("TXScreenCapture.OnAssistantActivityResult");
            intent.putExtra("TXScreenCapture.RequestCode", 1001);
            intent.putExtra("TXScreenCapture.ResultCode", 20000002);
            sendBroadcast(intent);
            finish();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2 = new Intent("TXScreenCapture.OnAssistantActivityResult");
        intent2.putExtra("TXScreenCapture.RequestCode", i);
        intent2.putExtra("TXScreenCapture.ResultCode", i2);
        intent2.putExtra("TXScreenCapture.ResultData", intent);
        sendBroadcast(intent2);
        finish();
    }
}
