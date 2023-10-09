package com.suvai.multilanguageapp

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.preference.PreferenceManager
import java.util.Locale


class LocaleHelper {
    companion object {
        private const val SELECTED_LANGUAGE = "Locale.Helper.Selected.Language"

        fun setLocale(activity: Activity, languageCode: String) {
            val locale = Locale(languageCode)
            Locale.setDefault(locale)
            val resources = activity.resources
            val config = resources.configuration
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }
        /*
                // the method is used to set the language at runtime
                fun setLocale(context: Context, language: String): Context? {
                    persist(context, language)

                    // updating the language for devices above android nougat
                    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        updateResources(context, language)
                    } else updateResourcesLegacy(context, language)
                    // for devices having lower version of android os
                }

                private fun persist(context: Context, language: String) {
                    val preferences = PreferenceManager.getDefaultSharedPreferences(context)
                    val editor = preferences.edit()
                    editor.putString(SELECTED_LANGUAGE, language)
                    editor.apply()
                }

                // the method is used update the language of application by creating
                // object of inbuilt Locale class and passing language argument to it
                @TargetApi(Build.VERSION_CODES.N)
                private fun updateResources(context: Context, language: String): Context? {
                    val locale = Locale(language)
                    Locale.setDefault(locale)
                    val configuration: Configuration = context.resources.configuration
                    configuration.setLocale(locale)
                    configuration.setLayoutDirection(locale)
                    return context.createConfigurationContext(configuration)
                }

                @Suppress("deprecation")
                private fun updateResourcesLegacy(context: Context, language: String): Context? {
                    val locale = Locale(language)
                    Locale.setDefault(locale)
                    val resources = context.resources
                    val configuration = resources.configuration
                    configuration.locale = locale
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        configuration.setLayoutDirection(locale)
                    }
                    resources.updateConfiguration(configuration, resources.displayMetrics)
                    return context
                }

         */
    }
}