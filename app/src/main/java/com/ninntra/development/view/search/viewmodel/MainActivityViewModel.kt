package com.ninntra.development.view.search.viewmodel

import androidx.lifecycle.ViewModel
import com.ninntra.development.helper.Filters


class MainActivityViewModel : ViewModel() {

    var isSigningIn: Boolean = false
    var filters: Filters = Filters.default
}
