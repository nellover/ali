package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        EditText noteTitle = findViewById(R.id.note_title);
        EditText noteContent = findViewById(R.id.note_content);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {
            String title = noteTitle.getText().toString();
            String content = noteContent.getText().toString();

            if (!title.isEmpty() && !content.isEmpty()) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("note_title", title);
                resultIntent.putExtra("note_content", content);
                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}