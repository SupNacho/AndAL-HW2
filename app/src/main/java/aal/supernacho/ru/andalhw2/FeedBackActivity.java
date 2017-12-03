package aal.supernacho.ru.andalhw2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedBackActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextMultyLine;
    private EditText editTextEmail;
    private Button buttonOk;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextName = findViewById(R.id.editText_name);
        editTextLastName = findViewById(R.id.editText_LastName);
        editTextMultyLine = findViewById(R.id.editText_multiLine);
        editTextEmail = findViewById(R.id.editText_Email);
        buttonOk = findViewById(R.id.button_ok);
        buttonCancel = findViewById(R.id.button_cancel);
        buttonOk.setOnClickListener(mOnClickListener);
        buttonCancel.setOnClickListener(mOnClickListener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button_cancel:
                    Intent intent = new Intent(FeedBackActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.button_ok:
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plane");
                    shareIntent.putExtra(Intent.EXTRA_EMAIL, "support@supernacho.ru");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Abstract feedback");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, my name is " + editTextName.getText().toString()
                            + editTextLastName.getText().toString()+ ", " + editTextMultyLine.getText().toString()
                            + "\nPls answer to this e-mail: " + editTextEmail.getText().toString());
                    startActivity(shareIntent);
                    break;
                default:
                    Snackbar.make(view, "Unknown view clicked", Snackbar.LENGTH_SHORT).show();
            }
        }
    };
}

