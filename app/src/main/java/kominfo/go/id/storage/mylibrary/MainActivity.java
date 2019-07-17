package kominfo.go.id.storage.mylibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private TextView entername;
    private EditText etname;
    private Button btnStore;
    private Button btnget;
    private TextView tvnames;
    private DatabaseHelper databaseHelper;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);

        initView();

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(etname.getText().toString());
                etname.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = databaseHelper.getAllStudentsList();
                tvnames.setText(arrayList.get(0));
                for (int i = 1; i < arrayList.size(); i++) {
                    tvnames.setText(tvnames.getText().toString()
                            + ", " + arrayList.get(i));
                }
            }
        });


    }

    private void initView() {
        entername = (TextView) findViewById(R.id.entername);
        etname = (EditText) findViewById(R.id.etname);
        btnStore = (Button) findViewById(R.id.btnStore);
        btnget = (Button) findViewById(R.id.btnget);
        tvnames = (TextView) findViewById(R.id.tvnames);
    }

}
