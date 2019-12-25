package com.example.jeffrey.academic.firebase_example.add_new_user_to_database;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.jeffrey.academic.R;
import com.example.jeffrey.academic.firebase_example.FireBaseInit;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;

public class GetUserNameDetails extends AppCompatActivity {

    private ArrayList<EditText> editTexts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_get_user_name_details);
        setTheEditTexts();
    }

    private void setTheEditTexts() {


        // TODO: 30/12/2018 מתודה שתפקידה היא לטעון את כל הפקדים שלנו אל תוך מערך ולאחר מכן לרוץ על הפקדים ולראות אם הם רקים או לא
        // TODO: 31/12/2018 זה בעצם גורם לקוד שלנו להתקצר בהרבה ולייעל את עצמנו בתור מפתחים
        // TODO: 31/12/2018 כאשר בהמשך אנחנו נשתמש במערך הזה על מנת לבדוק אם הערך שבתוך הפקד הוא ריק או לא
        editTexts=new ArrayList<>();
        EditText name = findViewById(R.id.priavte_name_activity_getusername);
        EditText phone=findViewById(R.id.phone_number_enter_activity_get_user_name);
        EditText area=findViewById(R.id.enter_area_of_live_activity_user_name);

        ImageButton imageButton=findViewById(R.id.enter_profile_photo);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAllFieldHaveData())
                setTheImagePickIntent();
            }
        });
        editTexts.add(name);
        editTexts.add(phone);
        editTexts.add(area);


    }

    private void setTheImagePickIntent() {

        Intent pickImage = new Intent(Intent.ACTION_PICK);
        pickImage.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);
        pickImage.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
        pickImage.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        pickImage.setType("image/*");
        try
        {
            startActivityForResult(pickImage,1);

        }catch (Exception e)
        {

        }

    }
    private boolean checkAllFieldHaveData() {
        // TODO: 30/12/2018 מתודה שבודקת אם הערך שנמצא בפקד ריק ובמידה והוא ריק תציג שגיאה כלשהיא
        int x=0;
        for (EditText e:editTexts) {
            if(e.getText().toString().isEmpty())
            {
                x++;
                e.setError(e.getHint());
            }
        }
        return x == 0;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // TODO: 10/01/2019 ברגע שבחרנו תמונה כלשהיא להעלות לשרת אז המתודה הזו תיכנס לעבודה
        if(requestCode==1&&resultCode==RESULT_OK)
        {
            saveUserNameInServer(data.getData());

        }
    }

    private void saveUserNameInServer(final Uri data) {
        // TODO: 10/01/2019  שומר את הנתונים שלנו בשרת
        final UserNameClass userNameClass=new UserNameClass(editTexts.get(0).getText().toString()
                ,editTexts.get(1).getText().toString()
                ,editTexts.get(2).getText().toString(),
        editTexts.get(0).getText().toString()+"/profileimage.jpeg");

        FireBaseInit.getFireBaseInit().getDatabase().collection("users")
                .add(userNameClass).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                task.getResult().set(userNameClass);
                userNameClass.putImageInServerWithInputStream(GetUserNameDetails.this,data);
            }
        });
    }
}
