package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import id.ac.polinema.intentexercise.model.Registrasi;

public class ProfileActivity extends AppCompatActivity {
    private TextView Fullname, Email, Homepage, About;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Fullname = findViewById(R.id.label_fullname);
        Email = findViewById(R.id.label_email);
        Homepage = findViewById(R.id.label_homepage);
        About = findViewById(R.id.label_about);

        Bundle bundle = getIntent().getExtras();
        Registrasi regis = bundle.getParcelable("key");

        if (bundle != null) {
            Fullname.setText(regis.getFullname());
            Email.setText(regis.getEmail());
            Homepage.setText(regis.getHomepage());
            About.setText(regis.getAbout());
        }
    }

    public void handleVisit(View view) {
        Intent visit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://github.com/zaidanyh"));
        startActivity(visit);
    }
}
