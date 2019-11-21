package com.example.thirdassessment;

import android.os.Bundle;

import com.example.thirdassessment.Modules.Students;
import com.example.thirdassessment.ui.ui.students.StudentsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_aboutUs, R.id.navigation_students)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        StudentsFragment.studentsList.add(new Students("Sandeep Maharjan", "35", "Male", "Kathmandu", R.drawable.male));
        StudentsFragment.studentsList.add(new Students("Sarina Karmacharya", "15", "Female", "Bhaktapur", R.drawable.female));
        StudentsFragment.studentsList.add(new Students("Sunil Thakul", "23", "other", "India", R.drawable.others));
        NavigationUI.setupWithNavController(navView, navController);
    }

}
