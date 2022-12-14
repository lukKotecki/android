package com.example.aplikacja_2022_09v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.aplikacja_2022_09v2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void click(View view) {

        Intent intent;

        switch(view.getId())
        {
            case R.id.lewy:
                intent = new Intent(MainActivity.this, LewyActivity.class);
                startActivity(intent);
                break;

            case R.id.prawy:
                intent = new Intent(MainActivity.this, PrawyActivity.class);
                startActivity(intent);
                break;
            case R.id.taskOneButton:
                intent = new Intent(this, TaskOneActivity.class);
                startActivity(intent);
                break;
            case R.id.taskTwoButton:
                intent = new Intent(this, TaskTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.taskThreeButton:
                intent = new Intent(this, TaskThreeActivity.class);
                startActivity(intent);
                break;
            case R.id.taskFourButton:
                intent = new Intent(this,TaskFourActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this, "Brak intencji :/", Toast.LENGTH_SHORT).show();
                break;

        }

    }





}