package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.widget.p;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.wcdb.FileUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

final class ak extends p implements OnClickListener {
    private final SearchView XK;
    private final SearchableInfo Xt;
    private final WeakHashMap<String, ConstantState> Xz;
    private int YA;
    private int YB;
    private final Context Ys;
    private final int Yt;
    private int Yu;
    private ColorStateList Yv;
    private int Yw;
    private int Yx;
    private int Yy;
    private int Yz;
    private boolean mClosed;

    public final boolean hasStableIds() {
        return false;
    }

    public final Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.XK.getVisibility() != 0 || this.XK.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursor;
            SearchableInfo searchableInfo = this.Xt;
            if (searchableInfo == null) {
                cursor = null;
            } else {
                String suggestAuthority = searchableInfo.getSuggestAuthority();
                if (suggestAuthority == null) {
                    cursor = null;
                } else {
                    String[] strArr;
                    Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
                    String suggestPath = searchableInfo.getSuggestPath();
                    if (suggestPath != null) {
                        fragment.appendEncodedPath(suggestPath);
                    }
                    fragment.appendPath("search_suggest_query");
                    suggestPath = searchableInfo.getSuggestSelection();
                    if (suggestPath != null) {
                        strArr = new String[]{charSequence2};
                    } else {
                        fragment.appendPath(charSequence2);
                        strArr = null;
                    }
                    fragment.appendQueryParameter("limit", "50");
                    cursor = this.mContext.getContentResolver().query(fragment.build(), null, suggestPath, strArr, null);
                }
            }
            if (cursor != null) {
                cursor.getCount();
                return cursor;
            }
        } catch (RuntimeException e) {
        }
        return null;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        a(this.BA);
    }

    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        a(this.BA);
    }

    private static void a(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public final void changeCursor(Cursor cursor) {
        if (!this.mClosed) {
            try {
                super.changeCursor(cursor);
                if (cursor != null) {
                    this.Yw = cursor.getColumnIndex("suggest_text_1");
                    this.Yx = cursor.getColumnIndex("suggest_text_2");
                    this.Yy = cursor.getColumnIndex("suggest_text_2_url");
                    this.Yz = cursor.getColumnIndex("suggest_icon_1");
                    this.YA = cursor.getColumnIndex("suggest_icon_2");
                    this.YB = cursor.getColumnIndex("suggest_flags");
                }
            } catch (Exception e) {
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new a(newView));
        ((ImageView) newView.findViewById(f.edit_query)).setImageResource(this.Yt);
        return newView;
    }

    public final void a(View view, Cursor cursor) {
        Drawable drawable = null;
        a aVar = (a) view.getTag();
        int i;
        if (this.YB != -1) {
            i = cursor.getInt(this.YB);
        } else {
            i = 0;
        }
        if (aVar.YC != null) {
            a(aVar.YC, a(cursor, this.Yw));
        }
        if (aVar.YD != null) {
            CharSequence charSequence;
            CharSequence a = a(cursor, this.Yy);
            if (a != null) {
                if (this.Yv == null) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(a.textColorSearchUrl, typedValue, true);
                    this.Yv = this.mContext.getResources().getColorStateList(typedValue.resourceId);
                }
                CharSequence spannableString = new SpannableString(a);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.Yv, null), 0, a.length(), 33);
                charSequence = spannableString;
            } else {
                charSequence = a(cursor, this.Yx);
            }
            if (TextUtils.isEmpty(charSequence)) {
                if (aVar.YC != null) {
                    aVar.YC.setSingleLine(false);
                    aVar.YC.setMaxLines(2);
                }
            } else if (aVar.YC != null) {
                aVar.YC.setSingleLine(true);
                aVar.YC.setMaxLines(1);
            }
            a(aVar.YD, charSequence);
        }
        if (aVar.YE != null) {
            Drawable drawable2;
            ImageView imageView = aVar.YE;
            if (this.Yz == -1) {
                drawable2 = null;
            } else {
                drawable2 = x(cursor.getString(this.Yz));
                if (drawable2 == null) {
                    ComponentName searchActivity = this.Xt.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    if (this.Xz.containsKey(flattenToShortString)) {
                        ConstantState constantState = (ConstantState) this.Xz.get(flattenToShortString);
                        drawable2 = constantState == null ? null : constantState.newDrawable(this.Ys.getResources());
                    } else {
                        Drawable activityIcon = getActivityIcon(searchActivity);
                        this.Xz.put(flattenToShortString, activityIcon == null ? null : activityIcon.getConstantState());
                        drawable2 = activityIcon;
                    }
                    if (drawable2 == null) {
                        drawable2 = this.mContext.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            a(imageView, drawable2, 4);
        }
        if (aVar.YF != null) {
            ImageView imageView2 = aVar.YF;
            if (this.YA != -1) {
                drawable = x(cursor.getString(this.YA));
            }
            a(imageView2, drawable, 8);
        }
        if (this.Yu == 2 || (this.Yu == 1 && (r7 & 1) != 0)) {
            aVar.YG.setVisibility(0);
            aVar.YG.setTag(aVar.YC.getText());
            aVar.YG.setOnClickListener(this);
            return;
        }
        aVar.YG.setVisibility(8);
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.XK.h((CharSequence) tag);
        }
    }

    private static void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private static void a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.Xt.shouldRewriteQueryFromData()) {
            a = a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.Xt.shouldRewriteQueryFromText()) {
            return null;
        }
        a = a(cursor, "suggest_text_1");
        if (a != null) {
            return a;
        }
        return null;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            View newView = newView(this.mContext, this.BA, viewGroup);
            if (newView != null) {
                ((a) newView.getTag()).YC.setText(e.toString());
            }
            return newView;
        }
    }

    private Drawable x(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        Drawable y;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.Ys.getPackageName() + "/" + parseInt;
            y = y(str2);
            if (y != null) {
                return y;
            }
            y = android.support.v4.content.a.b(this.Ys, parseInt);
            a(str2, y);
            return y;
        } catch (NumberFormatException e) {
            y = y(str);
            if (y != null) {
                return y;
            }
            y = b(Uri.parse(str));
            a(str, y);
            return y;
        } catch (NotFoundException e2) {
            return null;
        }
    }

    private Drawable b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return c(uri);
            }
            openInputStream = this.Ys.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (IOException e) {
                new StringBuilder("Error closing icon stream for ").append(uri);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            new StringBuilder("Icon not found: ").append(uri).append(", ").append(e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (IOException e4) {
                new StringBuilder("Error closing icon stream for ").append(uri);
            }
        }
    }

    private Drawable y(String str) {
        ConstantState constantState = (ConstantState) this.Xz.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.Xz.put(str, drawable.getConstantState());
        }
    }

    private Drawable getActivityIcon(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, FileUtils.S_IWUSR);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            new StringBuilder("Invalid icon resource ").append(iconResource).append(" for ").append(componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            e.toString();
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private static String a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Exception e) {
            }
        }
        return str;
    }

    private Drawable c(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }
}
