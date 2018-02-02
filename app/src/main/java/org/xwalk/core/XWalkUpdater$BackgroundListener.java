package org.xwalk.core;

import android.os.AsyncTask;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

class XWalkUpdater$BackgroundListener implements DownloadListener {
    final /* synthetic */ XWalkUpdater this$0;

    private XWalkUpdater$BackgroundListener(XWalkUpdater xWalkUpdater) {
        this.this$0 = xWalkUpdater;
    }

    public void onDownloadStarted() {
        XWalkUpdater.access$100(this.this$0).onXWalkUpdateStarted();
    }

    public void onDownloadUpdated(int i) {
        XWalkUpdater.access$100(this.this$0).onXWalkUpdateProgress(i);
    }

    public void onDownloadCancelled() {
        XWalkUpdater.access$100(this.this$0).onXWalkUpdateCancelled();
    }

    public void onDownloadFailed(int i, int i2) {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk failed");
        XWalkUpdater.access$100(this.this$0).onXWalkUpdateFailed(-1);
    }

    public void onDownloadCompleted(final UpdateConfig updateConfig) {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk completed, apkver = " + updateConfig.apkVer);
        new AsyncTask<Void, Void, Integer>() {
            protected Integer doInBackground(Void... voidArr) {
                return XWalkUpdater.onHandleFile(updateConfig);
            }

            protected void onPostExecute(Integer num) {
                if (num.intValue() != 0) {
                    XWalkUpdater.access$100(XWalkUpdater$BackgroundListener.this.this$0).onXWalkUpdateFailed(num.intValue());
                } else {
                    XWalkUpdater.access$100(XWalkUpdater$BackgroundListener.this.this$0).onXWalkUpdateCompleted();
                }
            }
        }.execute(new Void[0]);
    }
}
