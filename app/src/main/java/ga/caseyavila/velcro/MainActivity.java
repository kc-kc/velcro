package ga.caseyavila.velcro;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import ga.caseyavila.velcrotest.R;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private EditText input1;
    private EditText input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
    }

    public void find_website(View v) throws ExecutionException, InterruptedException, IOException {

        User casey = new User();
        casey.setUsername(input1.getText().toString());
        casey.setPassword(input2.getText().toString());


        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Account", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", input1.getText().toString());
        editor.putString("password", input2.getText().toString());
        editor.apply();

        text1.setText(casey.getTeachers());
        text2.setText(casey.getGrades());
        text3.setText(casey.getClasses());
    }
}
