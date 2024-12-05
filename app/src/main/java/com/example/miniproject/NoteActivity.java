package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        String contents = getIntent().getStringExtra("contents");
        String Title = getIntent().getStringExtra("title");
        TextView title_tv = findViewById(R.id.title);
        title_tv.setText(Title);
        TextView contents_tv = findViewById(R.id.noteDetail);
        contents_tv.setText(contents);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.shareNote) {
            String noteContent = getIntent().getStringExtra("title") + "\n\n" + getIntent().getStringExtra("contents");
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, noteContent.toString());

            Intent chooser = Intent.createChooser(shareIntent, "Share your note via");
            if (shareIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}