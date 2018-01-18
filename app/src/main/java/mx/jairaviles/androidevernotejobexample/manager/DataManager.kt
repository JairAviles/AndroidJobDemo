package mx.jairaviles.androidevernotejobexample.manager

import mx.jairaviles.androidevernotejobexample.helper.SharedPrefsHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager
@Inject constructor(private val mSharedPrefsHelper: SharedPrefsHelper) {

    fun setValue(key: String, value: String) {
        mSharedPrefsHelper.setPreferenceValue(key, value)
    }

    fun getValue(key: String): String = mSharedPrefsHelper.getPreferenceValue(key)

}