package nyc.c4q.jordansmith.nycevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class NYCEventsSplashScreen extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nycevents_splash_screen);

        imageView = (ImageView)findViewById(R.id.imageView_skyscrapper_background);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.explore_nyc_welcome);
        imageView.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
