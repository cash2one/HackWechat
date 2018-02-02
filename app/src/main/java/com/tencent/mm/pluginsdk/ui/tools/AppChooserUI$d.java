package com.tencent.mm.pluginsdk.ui.tools;

import android.os.AsyncTask;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.c;

class AppChooserUI$d extends AsyncTask<c, Void, c> {
    final /* synthetic */ AppChooserUI vwh;

    AppChooserUI$d(AppChooserUI appChooserUI) {
        this.vwh = appChooserUI;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        c cVar = ((c[]) objArr)[0];
        if (cVar.vwn == null) {
            cVar.vwn = AppChooserUI.a(this.vwh, cVar.vwl);
        }
        return cVar;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        AppChooserUI.a(this.vwh).notifyDataSetChanged();
    }
}
