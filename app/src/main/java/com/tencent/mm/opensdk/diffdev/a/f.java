package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;

final class f extends AsyncTask<Void, Void, a> {
    private OAuthListener m;
    private String p;
    private String url;
    private int v;

    public f(String str, OAuthListener oAuthListener) {
        this.p = str;
        this.m = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (this.p == null || this.p.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            a aVar = new a();
            aVar.o = OAuthErrCode.WechatAuth_Err_NormalErr;
            return aVar;
        }
        while (!isCancelled()) {
            String str = this.url + (this.v == 0 ? "" : "&last=" + this.v);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] a = e.a(str, 60000);
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar = a.b(a);
            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{str, aVar.o.toString(), Integer.valueOf(aVar.x), Long.valueOf(currentTimeMillis2 - currentTimeMillis)}));
            if (aVar.o == OAuthErrCode.WechatAuth_Err_OK) {
                this.v = aVar.x;
                if (aVar.x == g.UUID_SCANED.getCode()) {
                    this.m.onQrcodeScanned();
                } else if (aVar.x != g.UUID_KEEP_CONNECT.getCode() && aVar.x == g.UUID_CONFIRM.getCode()) {
                    if (aVar.w != null && aVar.w.length() != 0) {
                        return aVar;
                    }
                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                    aVar.o = OAuthErrCode.WechatAuth_Err_NormalErr;
                    return aVar;
                }
            }
            Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{aVar.o.toString(), Integer.valueOf(aVar.x)}));
            return aVar;
        }
        Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
        aVar = new a();
        aVar.o = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        return aVar;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        this.m.onAuthFinish(aVar.o, aVar.w);
    }
}
