package com.ebiii.comeback;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import co.ronash.pushe.Pushe;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ContentMain contentMain;
    private  FrameLayout frameLayout;
    public static int _ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Pushe.initialize(this,true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "openmindd2017@gmail.com", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("منابع")
                        .setMessage("منابع جمع اوری اطلاعات :\n" +
                                "\n" +
                                " 1 - https://www.tutorialspoint.com/spoken_english_errors/\n" +
                                "\n" +
                                "2 - https://www.sophia.org/subjects/english\n" +
                                "\n" +
                                "3 - https://www.talkenglish.com/\n" +
                                "\n" +
                                "4 - https://thewritepractice.com/short-story/")
                        .setIcon(android.R.drawable.ic_menu_manage)
                        .setCancelable(false)
                        .setPositiveButton("بستن",null)
                        .show();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        contentMain = new ContentMain(this);
        frameLayout =  contentMain.getFrameLayout();
        //نمایش فرگمنت اولی
        Fragment_Amozesh fragment_amozesh = new Fragment_Amozesh();
        getSupportFragmentManager().beginTransaction()
                .replace(frameLayout.getId(),fragment_amozesh)
                .commit();


        DrawerLayout constraintLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(_ID == 0){
                Fragment_Amozesh fragment_amozesh = new Fragment_Amozesh();
                getSupportFragmentManager().beginTransaction()
                        .replace(frameLayout.getId(),fragment_amozesh)
                        .commit();
            }else if(_ID == 11 || _ID == 1){
                ListDroosFragment listDroosFragment =
                        new ListDroosFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frm,listDroosFragment)
                        .commit();
            }else if(_ID == 22|| _ID == 2){
                Lesson_part_1 lesson_part_1 =
                        new Lesson_part_1();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frm,lesson_part_1)
                        .commit();
            }else if(_ID == 33|| _ID == 3){

                Lesson_part_2 lesson_part_2 =
                        new Lesson_part_2();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frm,lesson_part_2)
                        .commit();
            }else if(_ID == 44|| _ID == 4){
                Lesson_psrt_3 lesson_part_3 =
                        new Lesson_psrt_3();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frm,lesson_part_3)
                        .commit();
            }

            else{
                Tow_Fragment tow_fragment1 = new Tow_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frm,tow_fragment1)
                        .commit();
            }
        }
    }





    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Fragment_Amozesh fragment_amozesh = new Fragment_Amozesh();
            getSupportFragmentManager().beginTransaction()
                    .replace(frameLayout.getId(),fragment_amozesh)
                    .commit();

        } else if (id == R.id.nav_gallery) {
            showMessage();

        } else if (id == R.id.nav_slideshow) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + "nc_521"));
                intent.setPackage("com.farsitel.bazaar");
                startActivity(intent);
            }catch (RuntimeException e){
                Toast t = Toast.makeText(this, "برنامه بازار بر روی گوشی شما نصب نیست", Toast.LENGTH_SHORT);
                t.getView().setBackgroundColor(getResources()
                        .getColor(R.color.colorAccent));
                t.show();
            }
        } else if (id == R.id.nav_manage) {
          try{
            Intent intent = new Intent(Intent.ACTION_EDIT);
            intent.setData(Uri.parse("bazaar://details?id=" +"com.ebiii.comeback"));
            intent.setPackage("com.farsitel.bazaar");
            startActivity(intent);
        }catch (RuntimeException e){
           Toast toast = Toast.makeText(this, "برنامه بازار بر روی گوشی شما نصب نیست", Toast.LENGTH_SHORT);
              toast.getView().setBackgroundColor(getResources()
                      .getColor(R.color.colorAccent));
              toast.show();
        }


        } else if (id == R.id.nav_share) {


        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showMessage(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("اعلان")
                .setCancelable(false)
                .setMessage("در صورت داشتن پیشنهاد برای بهبود برنامه میتوانید با جیمیل زیر در ارتباط باشید  openmindd2017@gmail.com")
                .setPositiveButton("دارم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("mailto:openmindd2017@gmail.com"));
                            startActivity(intent);
                        }catch (RuntimeException ex){
                            Toast toast = Toast.makeText(MainActivity.this, "برنامه ارسال جیمیل بر روی گوشی شما نصب نمی باشد", Toast.LENGTH_SHORT);
                            toast.getView().setBackgroundColor(getResources()
                                    .getColor(R.color.colorAccent));
                            toast.show();
                        }
                    }
                })
                .setNegativeButton("ندارم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }
}
