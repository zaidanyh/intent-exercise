package id.ac.polinema.intentexercise;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import id.ac.polinema.intentexercise.model.Registrasi;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    public static final String KEY = "key";
    private EditText Fullname, Email, Password, Confirm_password, Homepage, About;
    private ImageView avatarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Fullname = findViewById(R.id.text_fullname);
        Email = findViewById(R.id.text_email);
        Password = findViewById(R.id.text_password);
        Confirm_password = findViewById(R.id.text_confirm_password);
        Homepage = findViewById(R.id.text_homepage);
        About = findViewById(R.id.text_about);
        avatarImage = findViewById(R.id.image_profile);
    }
    @Override
    protected void onActivityResult(int requsetCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requsetCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }
        if (requsetCode == GALLERY_REQUEST_CODE) {
            if (data != null) {
                try {
                    Uri imaUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imaUri);
                    avatarImage.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load Image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }

    public void handleSubmit(View view) {
        String fullname = Fullname.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String confirm = Confirm_password.getText().toString();
        String homepage = Homepage.getText().toString();
        String about = About.getText().toString();

        Registrasi regis = new Registrasi(fullname, email, password, confirm, homepage, about);
        Intent intent = new Intent(this, ProfileActivity.class);

        if (!fullname.equals("") && !email.equals("") && !password.equals("") && !homepage.equals("") && !about.equals("")) {
            if (password.equals(confirm)) {
                intent.putExtra(KEY, regis);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Masukkan Password dengan benar!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Pastikan Form Terisi Semua!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void handleChangeAvatar(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }
}
