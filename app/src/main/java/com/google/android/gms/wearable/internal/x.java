package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;

public interface x extends IInterface {
    void a(v vVar);

    void a(v vVar, byte b);

    void a(v vVar, int i);

    void a(v vVar, Uri uri);

    void a(v vVar, Uri uri, int i);

    void a(v vVar, Asset asset);

    void a(v vVar, ConnectionConfiguration connectionConfiguration);

    void a(v vVar, PutDataRequest putDataRequest);

    void a(v vVar, AddListenerRequest addListenerRequest);

    void a(v vVar, AncsNotificationParcelable ancsNotificationParcelable);

    void a(v vVar, RemoveListenerRequest removeListenerRequest);

    void a(v vVar, u uVar, String str);

    void a(v vVar, String str);

    void a(v vVar, String str, int i);

    void a(v vVar, String str, ParcelFileDescriptor parcelFileDescriptor);

    void a(v vVar, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2);

    void a(v vVar, String str, String str2);

    void a(v vVar, String str, String str2, byte[] bArr);

    void a(v vVar, boolean z);

    void b(v vVar);

    void b(v vVar, int i);

    void b(v vVar, Uri uri);

    void b(v vVar, Uri uri, int i);

    void b(v vVar, ConnectionConfiguration connectionConfiguration);

    void b(v vVar, u uVar, String str);

    void b(v vVar, String str);

    void b(v vVar, String str, int i);

    void b(v vVar, boolean z);

    void c(v vVar);

    void c(v vVar, int i);

    void c(v vVar, Uri uri);

    void c(v vVar, String str);

    void d(v vVar);

    void d(v vVar, String str);

    void e(v vVar);

    void e(v vVar, String str);

    void f(v vVar);

    void f(v vVar, String str);

    void g(v vVar);

    void h(v vVar);

    void i(v vVar);

    void j(v vVar);

    void k(v vVar);

    void l(v vVar);

    void m(v vVar);

    void n(v vVar);

    void o(v vVar);

    void p(v vVar);
}
