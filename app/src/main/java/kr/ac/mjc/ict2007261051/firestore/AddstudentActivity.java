package kr.ac.mjc.ict2007261051.firestore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddstudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);

        EditText nameEt=findViewById(R.id.name_et);
        EditText numberEt=findViewById(R.id.number_et);
        EditText departmentEt=findViewById(R.id.department_et);

        Button addBtn=findViewById(R.id.add_btn);
        FirebaseFirestore firestore=FirebaseFirestore.getInstance();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=nameEt.getText().toString();
                String number=numberEt.getText().toString();
                String department=departmentEt.getText().toString();

                Student student=new Student();
                student.setName(name);
                student.setNumber(number);
                student.setDepartment(department);
                Log.d("AddstudentActivity",name);
                firestore.collection("students").add(student)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("AddstudentActivity","성공");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("AddstudentActivity",e.getMessage());
                            }
                        });
            }
        });

    }
}
