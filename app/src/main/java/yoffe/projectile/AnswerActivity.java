package yoffe.projectile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.TextureView;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        answer = (TextView) findViewById(R.id.answer);

        Intent intent = getIntent();
        double angle = intent.getDoubleExtra("ANGLE", 0.0);
        double velocity = intent.getDoubleExtra("VELOCITY", 0.0);
        double time = intent.getDoubleExtra("TIME", 0.0);

        Projectile proj = new Projectile(angle, velocity, time);
        double x = proj.getX();
        double y = proj.getY();
        answer.setText(x + ", " + y);
    }
}
