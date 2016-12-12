package showbizlyra.tumblr.com.gmaps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static SharedPreferences sp;
    public static SharedPreferences.Editor ed;
    public EditText etNama;
    public String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("showbizlyra.tumblr.com.gmaps", MODE_PRIVATE);
        ed = sp.edit();

        etNama = (EditText) findViewById(R.id.editText);
        nama = sp.getString("nama", null);

        if (nama != null)
        {
            etNama.setText(nama);
            etNama.setEnabled(false);
            etNama.setSelectAllOnFocus(false);
        }

    }

    public void onClick(View v){
        if(nama == null || nama== "")
        {
            nama = etNama.getText().toString();
            ed.putString("nama", nama);
            ed.commit();
        }

        finish();
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
