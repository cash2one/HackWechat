package com.google.android.search.verification.client;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.search.verification.a.a$a;

class SearchActionVerificationClientService$a implements ServiceConnection {
    final /* synthetic */ SearchActionVerificationClientService bfG;

    SearchActionVerificationClientService$a(SearchActionVerificationClientService searchActionVerificationClientService) {
        this.bfG = searchActionVerificationClientService;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        SearchActionVerificationClientService.a(this.bfG, a$a.v(iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        SearchActionVerificationClientService.a(this.bfG, null);
    }
}
