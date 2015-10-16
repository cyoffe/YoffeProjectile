package yoffe.projectile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private EditText angleInput;
    private EditText velocityInput;
    private EditText timeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angleInput = (EditText) findViewById(R.id.angleInput);
        velocityInput = (EditText) findViewById(R.id.velocityInput);
        timeInput = (EditText) findViewById(R.id.timeInput);
        Button projectile = (Button) findViewById(R.id.projectile);
        ImageView image = (ImageView) findViewById(R.id.image);
        Picasso.with(this)
                .load("http://www.physicsclassroom.com/Class/vectors/u3l2b3.gif")
                .into(image);

        projectile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswer();
            }
        });
    }

    private void showAnswer() {
        double radians = Double.parseDouble(angleInput.getText().toString());
        double velocity = Double.parseDouble(velocityInput.getText().toString());
        double time = Double.parseDouble(timeInput.getText().toString());




        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra("ANGLE", radians);
        intent.putExtra("VELOCITY", velocity);
        intent.putExtra("TIME", time);
        startActivity(intent);


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
}
