package com.example.kamranali.compositionpractice.annotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kamranali.compositionpractice.AppLog;
import com.example.kamranali.compositionpractice.R;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationActivity extends AppCompatActivity {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface SmartPhone{
        String os() default "Symbion";
        int version() default 1;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);

        NokiaSeries obj = new NokiaSeries("myPhone");

        Class c = obj.getClass();
        Annotation an = c.getAnnotation(SmartPhone.class);
        SmartPhone s = (SmartPhone) an;
        AppLog.loge(s.os()+"\n"+s.version());

    }


    @SmartPhone()
    class NokiaSeries{
        String model ;

        public NokiaSeries(String model) {
            this.model = model;
        }
    }
}
