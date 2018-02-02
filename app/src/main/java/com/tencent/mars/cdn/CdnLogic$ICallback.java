package com.tencent.mars.cdn;

import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.CheckFileIDResult;

public interface CdnLogic$ICallback {
    void ReportFlow(int i, int i2, int i3, int i4);

    void RequestGetCDN(int i);

    byte[] decodeSessionResponseBuf(String str, byte[] bArr);

    byte[] getSessionRequestBuf(String str, byte[] bArr);

    void onC2CDownloadCompleted(String str, C2CDownloadResult c2CDownloadResult);

    void onC2CUploadCompleted(String str, C2CUploadResult c2CUploadResult);

    void onCheckFileidCompleted(String str, CheckFileIDResult checkFileIDResult);

    void onDataAvailable(String str, int i, int i2);

    void onDownloadToEnd(String str, int i, int i2);

    void onMoovReady(String str, int i, int i2);

    void onPreloadCompleted(String str, int i, int i2);

    void onPreloadCompletedWithResult(String str, int i, int i2, C2CDownloadResult c2CDownloadResult);

    void onProgressChanged(String str, int i, int i2, boolean z);

    void onRecvedData(String str, int i, byte[] bArr);
}
