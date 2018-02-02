package com.google.android.gms.c;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public interface c extends IInterface {
    Bundle a(Account account, String str, Bundle bundle);

    Bundle a(String str, Bundle bundle);

    AccountChangeEventsResponse a(AccountChangeEventsRequest accountChangeEventsRequest);

    Bundle c(String str, String str2, Bundle bundle);

    Bundle h(Bundle bundle);
}
