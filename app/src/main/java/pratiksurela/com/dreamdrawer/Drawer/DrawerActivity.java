package pratiksurela.com.dreamdrawer.Drawer;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pratiksurela.com.dreamdrawer.R;
import pratiksurela.com.dreamdrawer.fragment.AboutUsFragment;
import pratiksurela.com.dreamdrawer.fragment.FavouriteFragment;
import pratiksurela.com.dreamdrawer.fragment.HistoryFragment;
import pratiksurela.com.dreamdrawer.fragment.HomeFragment;
import pratiksurela.com.dreamdrawer.fragment.MyCartFragment;
import pratiksurela.com.dreamdrawer.fragment.ProfileFragment;

public class DrawerActivity extends AppCompatActivity implements View.OnClickListener, RecyclerViewClickListener {

    private String TAG = "DrawerActivity";
    private Context context;
    private Fragment fr;
    private Toolbar toolbar;
    private ImageView imgDrawer;
    private DrawerLayout drawer;
    //Toolbar Title
    private TextView txtHeading;
    //RecyclerView for drawer list items
    private RecyclerView drawerRecyclerView;
    private ArrayList<DrawerItem> drawerItemList;
    private DrawerAdapter adapter;
    private ActionBarDrawerToggle toggle;
    private int fragmentPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        context = this;
        initView(savedInstanceState);
    }

    private void initToolbar() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgDrawer = toolbar.findViewById(R.id.imgDrawer);
        txtHeading = toolbar.findViewById(R.id.txtHeading);
        imgDrawer.setOnClickListener(this);
    }

    private void initView(Bundle savedInstanceState) {
        initToolbar();
        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.syncState();

        drawerRecyclerView = findViewById(R.id.drawerRecyclerView);

        drawerItemList = new ArrayList<>();

        adapter = new DrawerAdapter(context, drawerItemList, this);
        drawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        drawerRecyclerView.setAdapter(adapter);
        setDrawerMenuItem();

        if (savedInstanceState == null) {
            //Default fragment set
            adapter.drawerChangedSelection(0);
            onDrawerListClick(fragmentPos);
        } else {
            onDrawerListClick(fragmentPos);
            adapter.drawerChangedSelection(fragmentPos);
        }
    }

    private void setDrawerMenuItem() {

        drawerItemList.add(new DrawerItem(R.drawable.ic_home, R.drawable.ic_home_white, getString(R.string.home)));
        drawerItemList.add(new DrawerItem(R.drawable.ic_my_cart, R.drawable.ic_my_cart_white, getString(R.string.my_cart)));
        drawerItemList.add(new DrawerItem(R.drawable.ic_favourite, R.drawable.ic_favourite_white, getString(R.string.favourites)));
        drawerItemList.add(new DrawerItem(R.drawable.ic_history, R.drawable.ic_history_white, getString(R.string.purchase_history)));
        drawerItemList.add(new DrawerItem(R.drawable.ic_profile, R.drawable.ic_profile_white, getString(R.string.profile)));
        drawerItemList.add(new DrawerItem(R.drawable.ic_about_us, R.drawable.ic_about_us_white, getString(R.string.about_us)));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDrawerListClick(int position) {

        if (position == 0) {
            txtHeading.setText(getString(R.string.home));
            fr = new HomeFragment();
        } else if (position == 1) {
            txtHeading.setText(getString(R.string.my_cart));
            fr = new MyCartFragment();
        } else if (position == 2) {
            txtHeading.setText(getString(R.string.favourites));
            fr = new FavouriteFragment();
        } else if (position == 3) {
            txtHeading.setText(getString(R.string.purchase_history));
            fr = new HistoryFragment();
        } else if (position == 4) {
            txtHeading.setText(getString(R.string.profile));
            fr = new ProfileFragment();
        } else if (position == 5) {
            txtHeading.setText(getString(R.string.about_us));
            fr = new AboutUsFragment();
        } else {
            fr = new HomeFragment();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frameDrawer, fr)
                        .commitAllowingStateLoss();
            }
        }, 500);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onClick(View view) {
        if (view == imgDrawer) {
            if (!drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.openDrawer(GravityCompat.START);
            } else {
                drawer.closeDrawer(GravityCompat.START);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            appExitDialog();
        }
    }

    private void appExitDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        alertDialogBuilder.setTitle("Are you sure for exit?");
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}