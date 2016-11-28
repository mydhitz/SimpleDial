package mydhitz.simpledial;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton tombolpanggil; //--->>deklarasi image button untuk java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tombolpanggil = (ImageButton) findViewById(R.id.panggil); //-->>memakai tombol panggil java dengan tombol panggil di xml

        tombolpanggil.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent panggilan = new Intent(Intent.ACTION_CALL);
                panggilan.setData(Uri.parse("tel:+6282221225083"));

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) !=
                        PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(panggilan);
            }
        });
    }
}
