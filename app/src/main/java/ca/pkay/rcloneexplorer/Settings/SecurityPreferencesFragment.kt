package ca.pkay.rcloneexplorer.Settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ca.pkay.rcloneexplorer.R

class SecurityPreferencesFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_security_preferences, rootKey)
        requireActivity().title = getString(R.string.pref_header_security)
    }
}
