package com.example.guacamole.discoverfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.core.result.Resource
import com.example.core.util.extensions.tag
import com.example.guacamole.R
import org.koin.android.viewmodel.ext.android.viewModel

class DiscoverFragment : Fragment() {

    private val discoveryViewModel: DiscoveryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.discover_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO : Clean this up when working on the Fragment UI
        discoveryViewModel.getData().observe(this, Observer {
            when (it) {

                is Resource.Success -> {
                    Log.d(tag(), "Success ${it.data.size}")
                }

                is Resource.Loading -> {
                    Log.d(tag(), "Loading ${it.data?.size ?: 0}")
                }
                is Resource.Error -> {
                    Log.d(tag(), "Error ${it.throwable}")
                }
            }
        })
    }
}
