package id.ac.polinema.intentexercise.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Registrasi implements Parcelable {
    private String Fullname, Email, Password, Confirm_password, Homepage, About;

    public Registrasi(String fullname, String email, String password, String confirm_password, String homepage, String about) {
        Fullname = fullname;
        Email = email;
        Password = password;
        Confirm_password = confirm_password;
        Homepage = homepage;
        About = about;
    }

    protected Registrasi(Parcel in) {
        Fullname = in.readString();
        Email = in.readString();
        Password = in.readString();
        Confirm_password = in.readString();
        Homepage = in.readString();
        About = in.readString();
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirm_password() {
        return Confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        Confirm_password = confirm_password;
    }

    public String getHomepage() {
        return Homepage;
    }

    public void setHomepage(String homepage) {
        Homepage = homepage;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public static final Creator<Registrasi> CREATOR = new Creator<Registrasi>() {
        @Override
        public Registrasi createFromParcel(Parcel in) {
            return new Registrasi(in);
        }

        @Override
        public Registrasi[] newArray(int size) {
            return new Registrasi[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Fullname);
        dest.writeString(Email);
        dest.writeString(Password);
        dest.writeString(Confirm_password);
        dest.writeString(Homepage);
        dest.writeString(About);
    }
}
