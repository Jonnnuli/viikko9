package userstorage.viikko9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioGroup radioGroup2;
    RadioButton radioButton1;
    RadioButton radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup2 = findViewById(R.id.radioGroup2);

    }
    public void addUser(View view) {
        int radioButtonId = radioGroup.getCheckedRadioButtonId();

        radioButton1 = findViewById(radioButtonId);
        String degreeProgram = radioButton1.getText().toString();
        EditText firstName = findViewById(R.id.editTextFirstName);
        EditText lastName = findViewById(R.id.editTextLastName);
        EditText email = findViewById(R.id.editTextEmail);

        String firstNameString = firstName.getText().toString();
        String lastNameString = lastName.getText().toString();
        String emailString = email.getText().toString();

        int radioButtonId2 = radioGroup2.getCheckedRadioButtonId();
        radioButton2 = findViewById(radioButtonId2);
        String imageString = radioButton2.getText().toString(); // tulee Kuva 1, Kuva 2 tai Kuva 3
        int image = 0;
        if (imageString.equals("Kuva 1")) image = R.drawable.ukkeli1;
        if (imageString.equals("Kuva 2")) image = R.drawable.possu;
        if (imageString.equals("Kuva 3")) image = R.drawable.ukkeli2;

        UserStorage.getInstance().addUser(new User(firstNameString, lastNameString, emailString, degreeProgram, image));
        Toast.makeText(this, "Lisäsit käyttäjän!", Toast.LENGTH_SHORT).show();

    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}