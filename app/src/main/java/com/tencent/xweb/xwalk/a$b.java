package com.tencent.xweb.xwalk;

import android.app.ProgressDialog;
import android.content.Context;

class a$b extends l {
    boolean AsG = false;
    private ProgressDialog AsH;
    final /* synthetic */ a Asx;

    public a$b(a aVar, Context context) {
        this.Asx = aVar;
        super(context);
    }

    public final void onXWalkUpdateProgress(int i) {
        super.onXWalkUpdateProgress(i);
        if (!this.AsG) {
            acu("正在下载runtime");
            this.AsH.setProgress(i);
        }
    }

    public final void onXWalkUpdateFailed(int i) {
        super.onXWalkUpdateFailed(i);
        this.AsH.setCancelable(true);
        this.AsH.setCanceledOnTouchOutside(true);
        acu("更新失败, error code = :" + i);
    }

    public final void onXWalkUpdateCancelled() {
        super.onXWalkUpdateCancelled();
        this.AsH.setCancelable(true);
        this.AsH.setCanceledOnTouchOutside(true);
        acu("更新失败, 更新被取消");
    }

    public final void onXWalkUpdateCompleted() {
        super.onXWalkUpdateCompleted();
        acu("更新完成，点任意位置重启进程生效");
        this.AsH.setCancelable(true);
        this.AsH.setCanceledOnTouchOutside(true);
        this.AsH.setProgress(100);
        this.AsG = true;
    }

    private void acu(String str) {
        if (this.AsH == null) {
            this.AsH = new ProgressDialog(this.mContext);
            this.AsH.setProgressStyle(1);
            this.AsH.setMessage(str);
            this.AsH.setOnCancelListener(new 1(this));
            this.AsH.setCancelable(false);
            this.AsH.show();
        }
        this.AsH.setMessage(str);
    }
}
