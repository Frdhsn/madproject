package com.group02.courses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.group02.courses.model.Course;
import com.group02.courses.recycler_view.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class CourseInfoActivity extends AppCompatActivity {
    int[] pic={R.drawable.shahidulsir,R.drawable.jesminmaam,R.drawable.fahimamaam,R.drawable.mesbahsir,R.drawable.akkassir};
RecyclerView recyclerView;
List<Course> courseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        courseList=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        //DatabaseReference var = FirebaseDatabase.getInstance().getReference("Course");
        //var.setValue();
        Course course=new Course("Human Computer Interfacing","IT-4201","Dr. Mohammad Shahidul Islam","Associate Professor");
        Course course1=new Course("Wireless & Mobile Communication","IT-4203","Jesmin Akhter","Professor");
        Course course2=new Course("Digital Image Processing and pattern Recognition","IT-4225","Fahima Tabassum","Professor");
        Course course3=new Course("Mobile Application Development","IT-4227","Dr. M. Mesbahuddin Sarker","Professor");
        Course course4=new Course("Computer Network Security","IT-4259","K M Akkas Ali","Proud Professor");
        courseList.add(course);
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
        courseList.add(course4);
        MyAdapter myAdapter=new MyAdapter(courseList,pic,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(myAdapter);
    }

    public void LogOut(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this,LogInActivity.class));
        finish();
    }
}