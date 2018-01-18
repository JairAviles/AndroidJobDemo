package mx.jairaviles.androidevernotejobexample.helper

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefsHelper {

    private var mSharedPreferences: SharedPreferences

    companion object {
        const val LAST_TIME_SAVED: String = "LAST_TIME_SAVED"
    }

    @Inject
    constructor(mSharedPreferences: SharedPreferences) {
        this.mSharedPreferences = mSharedPreferences
    }

    fun setPreferenceValue(key: String, value: String) {
        val editor: SharedPreferences.Editor = mSharedPreferences.edit()
        editor.putString(key, value)
        editor.commit()
    }

    fun getPreferenceValue(key: String): String = mSharedPreferences.getString(key, "")

}