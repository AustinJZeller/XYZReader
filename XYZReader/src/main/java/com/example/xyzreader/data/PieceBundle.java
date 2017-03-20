package com.example.xyzreader.data;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;

/**
 * Helper for loading a list of articles or a single article.
 */
public class PieceBundle extends CursorLoader {
    public static PieceBundle newAllArticlesInstance(Context context) {
        return new PieceBundle(context, BondObject.Items.buildDirUri());
    }

    public static PieceBundle newInstanceForItemId(Context context, long itemId) {
        return new PieceBundle(context, BondObject.Items.buildItemUri(itemId));
    }

    private PieceBundle(Context context, Uri uri) {
        super(context, uri, Query.PROJECTION, null, null, BondObject.Items.DEFAULT_SORT);
    }

    public interface Query {
        String[] PROJECTION = {
                BondObject.Items._ID,
                BondObject.Items.TITLE,
                BondObject.Items.PUBLISHED_DATE,
                BondObject.Items.AUTHOR,
                BondObject.Items.THUMB_URL,
                BondObject.Items.PHOTO_URL,
                BondObject.Items.ASPECT_RATIO,
                BondObject.Items.BODY,
        };

        int _ID = 0;
        int TITLE = 1;
        int PUBLISHED_DATE = 2;
        int AUTHOR = 3;
        int THUMB_URL = 4;
        int PHOTO_URL = 5;
        int ASPECT_RATIO = 6;
        int BODY = 7;
    }
}
