package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import java.net.URLEncoder;

public class HandleScanResult$Req extends BaseReq {
    private static final int MAX_URL_LENGHT = 10240;
    public String scanResult;

    public boolean checkArgs() {
        return this.scanResult != null && this.scanResult.length() >= 0 && this.scanResult.length() <= MAX_URL_LENGHT;
    }

    public int getType() {
        return 17;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_scan_qrcode_result", URLEncoder.encode(this.scanResult));
    }
}
