package com.kamran.dagger.dagger2retrofit2practice.dependencies;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Kamran ALi on 2/15/2017.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface CustomScope {
}
