package com.mimeinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MimeTypesList extends Activity {

    public static final String MIME_TYPE = "mime_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String[] mimeTypes = new String[] { "text/plain", "text/html", "text/rfc822" };
        ListView list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                mimeTypes));
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mimeType = parent.getAdapter().getItem(position).toString();
                Intent intent = new Intent(MimeTypesList.this, MimeTypeAppsList.class);
                intent.putExtra(MIME_TYPE, mimeType);
                startActivity(intent);
            }
        });
    }

}
