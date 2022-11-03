package kr.ac.mjc.ict2007261051.firestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addStudentBtn=findViewById(R.id.add_student_btn);
        RecyclerView studentListRv=findViewById(R.id.studentlist_rv);

        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddstudentActivity.class);
                startActivityForResult(intent,1);
            }
        });

    }
}