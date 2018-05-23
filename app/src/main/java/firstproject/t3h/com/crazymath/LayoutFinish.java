package firstproject.t3h.com.crazymath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LayoutFinish extends Activity implements View.OnClickListener {
    ImageView btnchuyenn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutfinish);
        btnchuyenn = findViewById(R.id.imgbuttonn);
        btnchuyenn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(LayoutFinish.this,mylayout.class);
        startActivity(intent);
    }


}
