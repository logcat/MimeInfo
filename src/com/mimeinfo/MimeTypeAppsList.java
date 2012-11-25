package com.mimeinfo;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MimeTypeAppsList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String mimeType = getIntent().getStringExtra(MimeTypesList.MIME_TYPE);
        getActionBar().setTitle("type: " + mimeType);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(mimeType);
        List<ResolveInfo> resolveInfos = getPackageManager().queryIntentActivities(intent, 0);
        ListView list = new ListView(this);
        list.setAdapter(new ArrayAdapter<ResolveInfo>(this, android.R.layout.simple_list_item_1,
                resolveInfos) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView) view).setText(getItem(position).loadLabel(getPackageManager()));
                return view;
            }
        });
        setContentView(list);
    }
}
