package firstproject.t3h.com.crazymath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by LE VAN KHAI on 1/2/2018.
 */

public class mylayout extends Activity implements View.OnClickListener {
    TextView sothu1, sothu2, dapan, tv_score, tvtime;
    ImageView imgtrue, imgfalse;
    private int scores;
    private int ketqua, dem = 0;
    private int timeFinish = 120000;
    private boolean check = true;
    CountDownTimer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        tv_score = findViewById(R.id.tv_score);
        tv_score.setText("0");
        int so1 = new Random().nextInt(100);
        sothu1 = findViewById(R.id.sothu1);
        sothu1.setText(String.valueOf(so1));
        int so2 = new Random().nextInt(100);
        sothu2 = findViewById(R.id.sothu2);
        sothu2.setText(String.valueOf(so2));
        ketqua = so1 + so2;
        tvtime = findViewById(R.id.tv_runtime);
        int min = ketqua - 1;
        int max = ketqua + 1;
        int item = max - min + 1;
        int kq = ketqua - 1 + new Random().nextInt(item);
        dapan = findViewById(R.id.dapan);
        dapan.setText(String.valueOf(kq));
        imgtrue = findViewById(R.id.imgtrue);
        imgfalse = findViewById(R.id.imgfalse);
        tvtime.setText("");
        if (scores<3) {
            timer = new CountDownTimer(timeFinish, 1000) {
                @Override
                public void onTick(long l) {

                    if (check == true) {
                        tvtime.setText(String.valueOf(l / 1000));
                    }
                }

                @Override
                public void onFinish() {
                    tvtime.setText("0");
                    Toast.makeText(mylayout.this, "Diem cua ban: " + scores, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mylayout.this, LayoutFinish.class);
                    startActivity(intent);
                }
            }.start();
        }
        else if (scores<10){
            timer = new CountDownTimer(timeFinish, 1500) {
                @Override
                public void onTick(long l) {

                    if (check == true) {
                        tvtime.setText(String.valueOf(l / 1500));
                    }
                }

                @Override
                public void onFinish() {
                    tvtime.setText("0");
                    Toast.makeText(mylayout.this, "Diem cua ban: " + scores, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(mylayout.this, LayoutFinish.class);
                    startActivity(intent);
                }
            }.start();
        }
        else {
            timer = new CountDownTimer(timeFinish, 2000) {
                @Override
                public void onTick(long l) {

                    if (check == true) {
                        tvtime.setText(String.valueOf(l / 2000));
                    }
                }

                @Override
                public void onFinish() {
                    tvtime.setText("0");
                    Toast.makeText(mylayout.this, "Diem cua ban: " + scores, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(mylayout.this, LayoutFinish.class);
                    startActivity(intent);
                }
            }.start();
        }
        imgtrue.setOnClickListener(this);
        imgfalse.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        ketqua = Integer.parseInt(sothu1.getText().toString()) + Integer.parseInt(sothu2.getText().toString());

        switch (view.getId()) {

            case R.id.imgtrue:
                if (Integer.parseInt(dapan.getText().toString()) == ketqua) {
                    int so1 = new Random().nextInt(100);
                    sothu1.setText(String.valueOf(so1));
                    int so2 = new Random().nextInt(100);
                    sothu2.setText(String.valueOf(so2));
                    ketqua = so1 + so2;
                    int min = ketqua - 1;
                    int max = ketqua + 1;
                    int item = max - min;
                    int kq = min + new Random().nextInt(item);
                    scores++;


                    dapan.setText(String.valueOf(kq));
                    tv_score.setText(String.valueOf(scores));

                } else {
                    Toast.makeText(this, "ban da chon dap an sai ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mylayout.this, MainActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.imgfalse:

                if (Integer.parseInt(dapan.getText().toString()) != ketqua) {
                    int so1 = new Random().nextInt(100);
                    sothu1.setText(String.valueOf(so1));
                    int so2 = new Random().nextInt(100);
                    sothu2.setText(String.valueOf(so2));
                    ketqua = so1 + so2;
                    int min = ketqua - 1;
                    int max = ketqua + 1;
                    int item = max - min;
                    int kq = min + new Random().nextInt(item);
                    scores++;
                    dapan.setText(String.valueOf(kq));
                    tv_score.setText(String.valueOf(scores));


                } else {
                    Toast.makeText(this, "ban da chon dap an sai ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mylayout.this, MainActivity.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }

    }


}
