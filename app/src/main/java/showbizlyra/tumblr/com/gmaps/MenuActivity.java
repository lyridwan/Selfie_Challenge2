package showbizlyra.tumblr.com.gmaps;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import static showbizlyra.tumblr.com.gmaps.MainActivity.sp;

public class MenuActivity extends AppCompatActivity {
    ProgressBar mprogressBar;
    RatingBar rbLevel;

    //untuk menampung atribut dr pemain
    //nilai masih dummy
    String uName = "LyraLyralei";
    int score = 17;
    int level = score/5;

    //menampilkan atribut pemain dalam textview
    TextView tvUname;
    TextView tvLevel;
    TextView tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tvUname = (TextView) findViewById(R.id.tvUname);
        tvLevel = (TextView) findViewById(R.id.tvLevel);
        tvScore = (TextView) findViewById(R.id.tvScore);

        uName = sp.getString("nama", null);
        tvUname.setText(uName);
        tvScore.setText(String.valueOf(score));
        tvLevel.setText("Level " + String.valueOf(level));

        rbLevel = (RatingBar) findViewById(R.id.ratingBar2);
        rbLevel.setRating(Float.valueOf(level));

        mprogressBar = (ProgressBar) findViewById(R.id.circular_progress_bar);

        ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, 100);
        anim.setDuration(1500);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();
    }

    public void onClick(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
