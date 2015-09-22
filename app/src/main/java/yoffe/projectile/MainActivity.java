package yoffe.projectile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView angle;
    private EditText angleInput;
    private TextView velocity;
    private EditText velocityInput;
    private TextView time;
    private EditText timeInput;
    private Button projectile;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angle = (TextView)findViewById(R.id.angle);
        angleInput = (EditText)findViewById(R.id.angleInput);
        velocity = (TextView)findViewById(R.id.velocity);
        velocityInput = (EditText)findViewById(R.id.velocityInput);
        time = (TextView)findViewById(R.id.time);
        timeInput = (EditText)findViewById(R.id.timeInput);
        projectile = (Button)findViewById(R.id.projectile);
        answer = (TextView)findViewById(R.id.answer);

        projectile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double radians = Math.toRadians(Double.parseDouble(angleInput.getText().toString()));
                double velocity = Double.parseDouble(velocityInput.getText().toString());
                double time=Double.parseDouble(timeInput.getText().toString());
                double x =getX(radians, velocity, time);
                double y=getY(radians, velocity, time);

                StringBuilder builder = new StringBuilder();
                builder.append(x);
                builder.append(", ");
                builder.append(y);
                answer.setText(builder.toString());
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

    private double getY(double radians, double velocity, double time) {
        return Math.cos(radians) * velocity * time - (1 / 2 * 9.8 * time * time);
    }


    private double getX(double radians, double velocity, double time) {
        return Math.sin(radians) * velocity * time;
    }
}
